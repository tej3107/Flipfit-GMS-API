import React from "react";

import { Text, TouchableOpacity, View, StyleSheet } from "react-native";

import { SafeAreaView } from "react-native-safe-area-context";

class Login extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (

      <SafeAreaView style={styles.safeArea}>
        <View style={styles.container}>
           <Text>In Owner Registration tab</Text>
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
});


export default Login;
