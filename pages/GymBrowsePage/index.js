import React from "react";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import MaterialCommunityIcons from "react-native-vector-icons/MaterialCommunityIcons";

import MyBookings from "./MyBookings";
import BookSlot from "./BookSlot";

import ViewOwners from "./ViewOwners";


const Tab = createBottomTabNavigator();

class GymBrowsePage extends React.Component {
  render() {
    return (
      <Tab.Navigator>
        <Tab.Screen
          name="Book Slot"
          component={BookSlot}
          options={{
            tabBarLabel: "Book Slot",
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
          name="View Owners"
          component={ViewOwners}
          options={{
            tabBarLabel: "View Owners",
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

export default GymBrowsePage;
