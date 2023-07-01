import { StyleSheet, SafeAreaView ,View , Text} from "react-native";
import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import { Toast } from "react-native-toast-message/lib/src/Toast";


import BookSlots from "./BookSlots";
import GetSlot from "./GetSlot"


const Stack = createStackNavigator();

// Context
import { cities, AppContext } from "../../appContext";

class SlotInterface extends React.Component {
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

      <NavigationContainer independent={true}>

          <Stack.Navigator>
            <Stack.Screen
              name="GetSlot"
              component={GetSlot}
              options={{
                headerShown: false,
              }}
            />
            <Stack.Screen
              name="BookSlots"
              component={BookSlots}
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

export default SlotInterface;