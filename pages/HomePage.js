import React from "react";
import CityDropDown from "../components/CityDropdown";
import { Text, TouchableOpacity, View, StyleSheet } from "react-native";
import { AppContext } from "../appContext";
import { SafeAreaView } from "react-native-safe-area-context";

import Login from "./Authentication/Login"
import  Registration from "./Authentication/Registration"

import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
const Stack = createStackNavigator();

class HomePage extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (

      <SafeAreaView style={styles.safeArea}>

            <View style={styles.container}>

            <Text>My Home Page</Text>
            <TouchableOpacity
            style={styles.button}
            onPress={() => this.props.navigation.navigate("Login")}
            >
            <Text>Login</Text>
            </TouchableOpacity>
            <TouchableOpacity
              style={styles.button}
              onPress={() => this.props.navigation.navigate("Registration")}
            >
              <Text>Registration</Text>
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

HomePage.contextType = AppContext;

export default HomePage;
