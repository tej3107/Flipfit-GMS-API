import React , {useState} from "react";
import { Alert, Modal,Text, StyleSheet,ScrollView, View, TouchableOpacity ,Pressable } from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { Toast } from "react-native-toast-message/lib/src/Toast";
import {AppContext} from "../../appContext"
class BookSlots extends React.Component {


            constructor(props) {
               super(props);
               this.state = {
                   data: null,
                   modalVisible: false,
                   slotStatus: 0
               }
            }

            setModalVisible = (visible) => {
                this.setState({ modalVisible: visible });
            }

             handleBookSlot =(el)=>{
                    const gymId = this.props.route.params.gymId;
                    fetch(`http://10.0.2.2:5000/customer/bookslot/${el.slotId}/${this.context.userName}`)
                    .then((res) => res.json())
                    .then(res => {



                       if(res==1){
                           Toast.show(
                             {
                               type:"success",
                               text1: "This Slot is not available!!!",
                               //text2: responseJson[1],
                               position:"top",
                               autoHide:true,
                               visibilityTime: 2000
                             }
                           )
                       }
                       else if(res==0){
                          Toast.show(
                            {
                              type:"success",
                              text1: "You have already booked this slot!!!",
                              //text2: responseJson[1],
                              position:"top",
                              autoHide:true,
                              visibilityTime: 2000
                            }
                          )
                      }
                      else if(res ==2){

                        this.setModalVisible(true)
                      }




                   })
                   .catch(err => console.error(err));

                   this.fetchSlots()

             }

             fetchSlots = ()=>{
                   const gymId = this.props.route.params.gymId;

                   fetch(`http://10.0.2.2:5000/customer/fetchGymSlot/${gymId}`,)
                   .then((res) => res.json())
                   .then(res => {

                       this.setState({ data: res })
                   })
                   .catch(err => console.error(err));
             }

            componentDidMount() {

               console.log("View slots of gym Mounted");
               this.fetchSlots();

            }

//            BookingModal = () => {
//                console.log("In Modal")
//                return (
//
//
//
//                )
//
//            }




            RenderList = (el) => {

               return (
                   <TouchableOpacity key={el.slotId} onPress = {()=>this.handleBookSlot(el)}>
                       <View style={styles.container}>
                           <Text style={styles.text}>Date : {el.date}</Text>
                           <Text style={styles.text}>Time : {el.capacity}</Text>
                           <Text style={styles.text}>Capacity: {el.time}</Text>
                       </View>
                   </TouchableOpacity>
               )
            }


            render() {


               return (
                   <View>
                     <View>
                            <Modal
                                animationType="slide"
                                transparent={true}
                                visible={this.state.modalVisible}
                                onRequestClose={() => {
                                  Alert.alert('Modal has been closed.');
                                  this.setModalVisible(!this.state.modalVisible);
                                }}
                              >
                                <View style={styles.centeredView}>
                                  <View style={styles.modalView}>
                                    <Text style={styles.modalText}>Slot has been booked</Text>
                                    <Pressable
                                      style={[styles.button, styles.buttonClose]}
                                      onPress={() => this.setModalVisible(!this.state.modalVisible)}
                                    >
                                      <Text style={styles.textStyle}>Ok</Text>
                                    </Pressable>
                                  </View>
                                </View>
                              </Modal>

                       </View>
                    < ScrollView>
                       <Text>View all slots here: </Text>
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
   },
    centeredView: {
       flex: 1,
       justifyContent: 'center',
       alignItems: 'center',
       marginTop: 22,
     },
     modalView: {
       margin: 20,
       backgroundColor: 'white',
       borderRadius: 20,
       padding: 35,
       alignItems: 'center',
       shadowColor: '#000',
       shadowOffset: {
         width: 0,
         height: 2,
       },
       shadowOpacity: 0.25,
       shadowRadius: 4,
       elevation: 5,
     },
     button: {
       borderRadius: 20,
       padding: 10,
       elevation: 2,
     },
     buttonOpen: {
       backgroundColor: '#F194FF',
     },
     buttonClose: {
       backgroundColor: '#2196F3',
     },
     textStyle: {
       color: 'white',
       fontWeight: 'bold',
       textAlign: 'center',
     },
     modalText: {
       marginBottom: 15,
       textAlign: 'center',
     },
})
BookSlots.contextType = AppContext;

export default BookSlots;
