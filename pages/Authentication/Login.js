import React, { useState } from "react";

import { Text, TouchableOpacity, View, TextInput, Button, StyleSheet } from "react-native";

import { SafeAreaView } from "react-native-safe-area-context";
import { Toast } from "react-native-toast-message/lib/src/Toast";
import { AppContext } from "../../appContext"

class Login extends React.Component {
  constructor(props) {
    super(props);


    this.state = {
      userName: '',
      password: '',
    }
  }


  handleLogin = () => {

    fetch('http://10.0.2.2:5000/login/authenticate', {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ userName: this.state.userName, password: this.state.password }), // Replace with your payload
    })
      .then((response) => {


        if (response.ok) {
          console.log("Ok respoonse")

          return response.json()

        }
        else {
          console.log(response.data)
        }

      })
      .then((json) => {
        // Handle the response

        console.log("data" + json.data[0]);
        if (json.data[0] == 1) {
          this.context.changeUser(this.state.userName)
          this.props.navigation.navigate("CustomerPages")
          console.log("admin")
        }
        else if (json.data[0] === 2) {
          this.context.changeUser(this.state.userName)
          Toast.show(
            {
              type: "error",
              text1: "Registration Successfull...Welcome to FlipFit",
              //text2: responseJson[1],
              position: "top",
              autoHide: true,
              visibilityTime: 3000
            }
          )
          console.log("owner")
        }
        else if (json.data[0] == 3) {
          console.log("customer")
          this.context.changeUser(this.state.userName)
          Toast.show(
            {
              type: "error",
              text1: "Welcome to FlipFit",
              //text2: responseJson[1],
              position: "center",
              autoHide: true,
              visibilityTime: 2000
            }
          )
          this.props.navigation.navigate("CustomerPages")

        }
        else {

          Toast.show(
            {
              type: "error",
              text1: "InValid UserId or Password!!!",
              position: "top",
              autoHide: true,
              visibilityTime: 3000
            }

          )
          this.props.navigation.navigate("Login");
        }



      })
      .catch((error) => {
        // Handle any error
        console.error(error);
      });

  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.heading}>FlipFit Login</Text>
        <TextInput
          style={styles.input}
          placeholder="UserId"
          value={this.state.userName}
          onChangeText={(text) => this.setState({ userName: text })}
        />
        <TextInput
          style={styles.input}
          placeholder="Password"
          secureTextEntry
          value={this.state.password}
          onChangeText={(text) => this.setState({ password: text })}
        />
        <Button title="Login" onPress={this.handleLogin} />
      </View>
    );
  };

}

const styles = StyleSheet.create({

  heading: {
    margin: 10,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 16,
  },
  input: {
    width: '80%',
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 12,
    paddingHorizontal: 10,
  },
});

Login.contextType = AppContext;
export default Login;
