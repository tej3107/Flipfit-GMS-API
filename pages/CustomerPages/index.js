import React from "react";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import MaterialCommunityIcons from "react-native-vector-icons/MaterialCommunityIcons";

import MyBookings from "./MyBookings";
//import GetSlot from "./GetSlot";
import SlotInterface from "./SlotInterface"
import ViewOwners from "./ViewOwners";
import CustomerDetails from "./CustomerDetails";


const Tab = createBottomTabNavigator();

class CustomerPages extends React.Component {
  render() {
    return (
      <Tab.Navigator
        screenOptions={
          { unmountOnBlur: true }
        }
      >

        <Tab.Screen
          name="Book Slots"
          component={SlotInterface}
          options={{
            tabBarLabel: "Book Slots",
            tabBarIcon: ({ color, size }) => (
              <MaterialCommunityIcons
                name="kabaddi"
                color={color}
                size={size}
              />
            ),
          }}
        />
        <Tab.Screen
          name="My Bookings"
          component={MyBookings}
          options={{
            tabBarLabel: "My Booking",
            tabBarIcon: ({ color, size }) => (
              <MaterialCommunityIcons
                name="account-heart"
                color={color}
                size={size}
              />
            ),
          }}
        />
        <Tab.Screen
          name="My Profile"
          component={CustomerDetails}
          options={{
            tabBarLabel: "My Profile",
            tabBarIcon: ({ color, size }) => (
              <MaterialCommunityIcons
                name="account-heart"
                color={color}
                size={size}
              />
            ),
          }}
        />
      </Tab.Navigator>
    );
  }
}

export default CustomerPages;
