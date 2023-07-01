import React from "react";
import { Text, StyleSheet,ScrollView, View, TouchableOpacity } from "react-native";
import {AppContext} from "../../appContext"
class MyBookings extends React.Component {
       constructor(props) {
           super(props);
           this.state = {
               userName:null,
                data: null
           }
       }



       componentDidMount() {

           console.log("My Booking Mounted");

           fetch(`http://10.0.2.2:5000/customer/booked/${this.context.userName}`, {

           })
               .then((res) => res.json())
               .then(res => {
                   this.setState({ data: res })
               })
               .catch(err => console.error(err));
       }


       RenderList = (el) => {
           return (
               <TouchableOpacity key={el.bookingId}  >
                   <View style={styles.container}>
                       <Text style={styles.text}>{el.gymName}</Text>
                       <Text style={styles.text}>{el.slotTime}</Text>
                       <Text style={styles.text}>{el.slotDate}</Text>
                   </View>
               </TouchableOpacity>
           )
       }


       render() {
           return (
               <View>
               <ScrollView>
                      <Text>View all owners here: </Text>
                   {
                       this.state.data && this.state.data.map((el) => this.RenderList(el))
                   }
                   </ScrollView>
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

MyBookings.contextType = AppContext;

export default MyBookings;
