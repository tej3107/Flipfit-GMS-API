//import React from "react";
//
//import { Text, TouchableOpacity, View, StyleSheet } from "react-native";
//
//import { SafeAreaView } from "react-native-safe-area-context";
//
//class CustomerRegistration extends React.Component {
//  constructor(props) {
//    super(props);
//  }
//  render() {
//    return (
//
//      <SafeAreaView style={styles.safeArea}>
//        <View style={styles.container}>
//           <Text>In Customer Registration</Text>
//        </View>
//
//      </SafeAreaView>
//    );
//  }
//}
//
//const styles = StyleSheet.create({
//  safeArea: {
//    flex: 1
//  },
//  container: {
//    flex: 1,
//    flexDirection: 'column',
//    padding: 20,
//  },
//  button: {
//    backgroundColor: "#DDDDDD",
//    padding: 10,
//  },
//});
//
//
//export default CustomerRegistration;


import React from "react";

import { Text, TouchableOpacity, View, StyleSheet, TextInput, Button } from "react-native";

import { SafeAreaView } from "react-native-safe-area-context";
import { Toast } from "react-native-toast-message/lib/src/Toast";

class CustomerRegistration extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: '',
      password: '',
      roleId: 3,
      name: '',
      mobile: '',
      email: '',
      address: '',
    }
  }

  handleRegistration = () => {

    fetch('http://10.0.2.2:5000/customer/create', {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ userName: this.state.userName, password: this.state.password, roleId: this.state.roleId, name: this.state.name, mobile: this.state.mobile, email: this.state.email, address: this.state.address }),
    })
      .then((response) => {
        this.setState({
          userName: '',
          password: '',
          roleId: 3,
          name: '',
          mobile: '',
          email: '',
          address: '',
        })


        return response.json()

      })
      .then((responseJson) => {

        console.log(responseJson);
        if (responseJson.data && responseJson.data[0] == 'true') {
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
          this.props.navigation.navigate("CustomerPages")
        }
        else {
          Toast.show(
            {
              type: "error",
              text1: "There is an issue while registering...",
              text2: responseJson.message,
              position: "top",
              autoHide: true,
              visibilityTime: 3000
            }
          )

        }
      }).catch((err) => {
        console.log(err)

      })


  }
  render() {
    return (

      <SafeAreaView style={styles.safeArea}>
        <View style={styles.container}>
          <Text>In Customer Registration</Text>

          <Text>Enter Your Details Below</Text>

          <TextInput
            style={styles.input}
            placeholder="Prefered Username"
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
          <TextInput
            style={styles.input}
            placeholder="Name"
            //secureTextEntry
            value={this.state.name}
            onChangeText={(text) => this.setState({ name: text })}
          />
          <TextInput
            style={styles.input}
            placeholder="Mobile Number"
            //secureTextEntry
            value={this.state.mobile}
            onChangeText={(text) => this.setState({ mobile: text })}
          />
          <TextInput
            style={styles.input}
            placeholder="Email Address"
            // secureTextEntry
            value={this.state.email}
            onChangeText={(text) => this.setState({ email: text })}
          />
          <TextInput
            style={styles.input}
            placeholder="Address"
            // secureTextEntry
            value={this.state.address}
            onChangeText={(text) => this.setState({ address: text })}
          />
          <Button

            title="Register" onPress={this.handleRegistration}
          />
        </View>

      </SafeAreaView>
    );
  }
}

const styles = StyleSheet.create({
  safeArea: {
    flex: 1
  },
  container: {
    flex: 1,
    flexDirection: 'column',
    padding: 20,
  },
  button: {
    backgroundColor: "#DDDDDD",
    padding: 10,
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


export default CustomerRegistration;