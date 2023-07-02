import React from "react";

import { Text, TouchableOpacity, View, StyleSheet } from "react-native";
import { AppContext } from "../../appContext";
import { SafeAreaView } from "react-native-safe-area-context";

class Registration extends React.Component {
  constructor(props) {
    super(props);

  }

  render() {

    return (

      <SafeAreaView style={styles.safeArea}>

        <View style={styles.container}>

          <Text>Registration</Text>
          <TouchableOpacity
            style={styles.button}
            onPress={() => this.props.navigation.navigate("CustomerRegistration")}
          >
            <Text>Customer</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={styles.button}
            onPress={() => this.props.navigation.navigate("OwnerRegistration")}
          >
            <Text>Gym Owner</Text>
          </TouchableOpacity>
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
    margin: 10,
  },
});


export default Registration;
