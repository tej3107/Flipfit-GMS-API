import { StyleSheet, SafeAreaView } from "react-native";
import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";

import EntryPoint from "./pages/EntryPoint";

const Stack = createStackNavigator();

// Context
import { cities, AppContext } from "./appContext";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.changeCity = (city) => {
      this.setState({
        city: city,
      });
    };
    this.changeUser = (userName) => {
          this.setState({
            userName: userName,
          });
        };
    this.state = {
      city: cities.bangalore,
      changeCity: this.changeCity,
      userName : null,
      changeUser: this.changeUser
    };
  }

  render() {
    return (
    <AppContext.Provider value = {this.state}>
      <EntryPoint />
      </AppContext.Provider>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});

export default App;
