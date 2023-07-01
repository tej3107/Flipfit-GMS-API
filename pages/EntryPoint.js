import { StyleSheet, SafeAreaView ,View , Text} from "react-native";
import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";

import HomePage from "./HomePage";
import Login from "./Authentication/Login"
import Registration from "./Authentication/Registration"
import CustomerRegistration from "./Authentication/CustomerRegistration"
import OwnerRegistration from "./Authentication/OwnerRegistration"
import CustomerPages from "./CustomerPages"
import { Toast } from "react-native-toast-message/lib/src/Toast";
import BookSlots from "./CustomerPages/BookSlots"

const Stack = createStackNavigator();

// Context
import { cities, AppContext } from "../appContext";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.changeCity = (city) => {
      this.setState({
        city: city,
      });
    };
    this.state = {
      city: cities.bangalore,
      changeCity: this.changeCity,
    };
  }

  render() {
    return (
     <View style={{ flex: 1 }}>

      <NavigationContainer>

          <Stack.Navigator>
            <Stack.Screen
              name="Home"
              component={HomePage}
              options={{
                headerShown: false,
              }}
            />
            <Stack.Screen
              name="Login"
              component={Login}
              options={{
                headerShown: false,
              }}
            />
            <Stack.Screen
              name="Registration"
              component={Registration}
              options={{
                headerShown: false,
              }}
            />
            <Stack.Screen
              name="CustomerRegistration"
              component={CustomerRegistration}
              options={{
                headerShown: false,
              }}
            />

            <Stack.Screen
              name="OwnerRegistration"
              component={OwnerRegistration}
              options={{
                headerShown: false,
              }}
            />
            <Stack.Screen
              name="CustomerPages"
              component={CustomerPages}
              options={{
                headerShown: false,
              }}
            />
          </Stack.Navigator>
          <Toast/>

      </NavigationContainer>

      </View>
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