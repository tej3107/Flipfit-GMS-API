import React from "react";
import { Text, StyleSheet, View, TouchableOpacity  } from "react-native";


class CustomerDetails extends React.Component {
      constructor(props) {
               super(props);
               this.state = {
                   data: null
               }
            }


            fetchData = ()=>{
                    console.log("mounted")
                   fetch("http://10.0.2.2:5000/customer/fetchGym", {

                   })
                   .then((res) => res.json())
                   .then(res => {
                       console.log(res)
                       this.setState({ data: res })
                   })
                   .catch(err => console.error(err));
            }


            componentDidMount() {
                this.fetchData();

            }





            render() {
               return (
                   <View>
                          <Text>View My Profile: </Text>

                   </View>
               )
            }
      }

const styles = StyleSheet.create({
   container: {
       flexDirection: "row",
       padding: 10,
       margin: 10,
       borderRadius: 3,
       justifyContent: "center",
       alignContent: "center",
       backgroundColor: "grey",
   },
   text: {
       fontSize: 16,
       margin: 10,
   }
})

export default CustomerDetails;
