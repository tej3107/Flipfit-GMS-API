import React from "react";
import CityDropDown from "../components/CityDropdown";
import { Text, TouchableOpacity, View, StyleSheet } from "react-native";
import { AppContext } from "../appContext";
import { SafeAreaView } from "react-native-safe-area-context";

import Login from "./Authentication/Login"
import Registration from "./Authentication/Registration"

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

// //======================================================================================================================

// import React from "react";
// import CityDropDown from "../components/CityDropdown";
// import { Text, TouchableOpacity, View, StyleSheet, Image } from "react-native";
// import { AppContext } from "../appContext";
// import { SafeAreaView } from "react-native-safe-area-context";

// import Login from "./Authentication/Login";
// import Registration from "./Authentication/Registration";

// import { NavigationContainer } from "@react-navigation/native";
// import { createStackNavigator } from "@react-navigation/stack";
// const Stack = createStackNavigator();

// class HomePage extends React.Component {
//   constructor(props) {
//     super(props);
//   }

//   render() {
//     return (
//       <SafeAreaView style={styles.safeArea}>
//         <View style={styles.container}>
//           <Text style={styles.title}>FlipFit</Text>
//           <TouchableOpacity
//             style={styles.button}
//             onPress={() => this.props.navigation.navigate("Login")}
//           >
//             <Text style={styles.buttonText}>Login</Text>
//           </TouchableOpacity>
//           <TouchableOpacity
//             style={styles.button}
//             onPress={() => this.props.navigation.navigate("Registration")}
//           >
//             <Text style={styles.buttonText}>Registration</Text>
//           </TouchableOpacity>
//           <Image
//             source={require("../assets/icon.png")} // Placeholder image path
//             style={styles.image}
//           />
//           <Image
//             source={require("../assets/favicon.png")} // Placeholder image path
//             style={styles.image}
//           />
//         </View>
//       </SafeAreaView>
//     );
//   }
// }

// const styles = StyleSheet.create({
//   safeArea: {
//     flex: 1,
//   },
//   container: {
//     flex: 1,
//     padding: 20,
//     alignItems: "center",
//     justifyContent: "center",
//   },
//   title: {
//     fontSize: 24,
//     fontWeight: "bold",
//     marginBottom: 16,
//   },
//   button: {
//     backgroundColor: "#DDDDDD",
//     padding: 10,
//     marginVertical: 10,
//     width: "80%",
//     alignItems: "center",
//   },
//   buttonText: {
//     fontSize: 18,
//     fontWeight: "bold",
//   },
//   image: {
//     width: 200,
//     height: 200,
//     resizeMode: "contain",
//     marginVertical: 10,
//   },
// });

// HomePage.contextType = AppContext;

// export default HomePage;


//======================================================================================================================
// import React from "react";
// import CityDropDown from "../components/CityDropdown";
// import { Text, TouchableOpacity, View, StyleSheet, Image } from "react-native";
// import { AppContext } from "../appContext";
// import { SafeAreaView } from "react-native-safe-area-context";

// import Login from "./Authentication/Login";
// import Registration from "./Authentication/Registration";

// import { NavigationContainer } from "@react-navigation/native";
// import { createStackNavigator } from "@react-navigation/stack";
// const Stack = createStackNavigator();

// class HomePage extends React.Component {
//   constructor(props) {
//     super(props);
//   }

//   render() {
//     return (
//       <SafeAreaView style={styles.safeArea}>
//         <View style={styles.container}>
//           <Text style={styles.title}>My Home Page</Text>
//           <TouchableOpacity
//             style={styles.button}
//             onPress={() => this.props.navigation.navigate("Login")}
//           >
//             <Text style={styles.buttonText}>Login</Text>
//           </TouchableOpacity>
//           <TouchableOpacity
//             style={styles.button}
//             onPress={() => this.props.navigation.navigate("Registration")}
//           >
//             <Text style={styles.buttonText}>Registration</Text>
//           </TouchableOpacity>
//           <Image
//             source={require("../assets/favicon.png")} // Placeholder image path
//             style={styles.image}
//           />
//           <Image
//             source={require("../assets/splash.png")} // Placeholder image path
//             style={styles.image}
//           />
//         </View>
//       </SafeAreaView>
//     );
//   }
// }

// const styles = StyleSheet.create({
//   safeArea: {
//     flex: 1,
//     backgroundColor: "#f0f0f0",
//   },
//   container: {
//     flex: 1,
//     padding: 20,
//     alignItems: "center",
//     justifyContent: "center",
//   },
//   title: {
//     fontSize: 24,
//     fontWeight: "bold",
//     marginBottom: 16,
//     color: "#333",
//   },
//   button: {
//     backgroundColor: "#047BD5",
//     padding: 10,
//     marginVertical: 10,
//     width: "80%",
//     alignItems: "center",
//     borderRadius: 8,
//   },
//   buttonText: {
//     fontSize: 18,
//     fontWeight: "bold",
//     color: "#fff",
//   },
//   image: {
//     width: 200,
//     height: 200,
//     resizeMode: "contain",
//     marginVertical: 10,
//   },
// });

// HomePage.contextType = AppContext;

// export default HomePage;
