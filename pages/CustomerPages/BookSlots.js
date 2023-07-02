import React, { useState } from "react";
import { Alert, Modal, Text, StyleSheet, ScrollView, View, TouchableOpacity, Pressable } from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { Toast } from "react-native-toast-message/lib/src/Toast";
import { AppContext } from "../../appContext"
import { PagerView } from 'react-native-pager-view'

import {
  addDays,
  eachDayOfInterval,
  eachWeekOfInterval,
  subDays,

} from
  "date-fns"
// import format from "date-fns/format"

class BookSlots extends React.Component {


  constructor(props) {
    super(props);
    this.state = {
      data: null,
      modalVisible: false,
      slotStatus: 0,
      element: null
    }
  }

  setModalVisible = (visible) => {
    this.setState({ modalVisible: visible });
  }

  handleBookSlot = (el) => {
    const gymId = this.props.route.params.gymId;
    console.log("hello bhai")
    fetch(`http://10.0.2.2:5000/customer/bookslot/${el.slotId}/${this.context.userName}`)
      .then((res) => {

        if (res.ok) {
          {
            return res.json()
          }
        }
        else console.log("error in  b ook slot")
      })
      .then(res => {

        //   if(customerDao.sameSlotAlreadyBooked(userName, slotId)){
        //     return 0;
        // }
        // else if (isFull(slotId)) {
        //     return 1;
        // } else if (alreadyBooked(slotId, userName)) {
        //     //will change slot in it
        //     return 2;
        // } else {
        //     customerDao.bookSlots(slotId, userName);
        //     return 3;
        // }

        console.log(res)


        if (res.data[0] == 1) {
          Toast.show(
            {
              type: "info",
              text1: "This Slot is not available!!!",
              //text2: responseJson[1],
              position: "top",
              autoHide: true,
              visibilityTime: 2000
            }
          )
        }
        else if (res.data[0] == 0) {
          Toast.show(
            {
              type: "info",
              text1: "You have already booked this slot!!!",
              //text2: responseJson[1],
              position: "top",
              autoHide: true,
              visibilityTime: 2000
            }
          )
        }
        else if (res.data[0] == 2) {


          Toast.show(
            {
              type: "success",
              text1: "Slot has been booked!!!",
              text2: "Previous booking on this slot time has been cancled.",
              position: "top",
              autoHide: true,
              visibilityTime: 3000
            }
          )

        }
        else if (res.data[0] == 3) {
          Toast.show(
            {
              type: "success",
              text1: "The slot has been booked!!!",
              //text2: responseJson[1],
              position: "top",
              autoHide: true,
              visibilityTime: 2000
            }
          )

        }




      })
      .catch(err => console.error(err))
      .finally(() => {
        this.fetchSlots()
      })

  }

  fetchSlots = () => {
    const gymId = this.props.route.params.gymId;
    console.log(this.dates)
    fetch(`http://10.0.2.2:5000/customer/fetchGymSlot/${gymId}`,)
      .then((res) => {
        if (res.ok)
          return res.json()

        else {
          console.log("error in fetch slots")
        }
      })

      .then(r => {

        this.setState({ data: r.data })
      })
      .catch(err => console.error(err));
  }

  componentDidMount() {


    this.fetchSlots();

  }






  RenderList = (el) => {

    return (
      <TouchableOpacity key={el.slotId} onPress={() => {
        this.setModalVisible(true)
        this.setState({ element: el })
      }}>
        <View style={styles.container}>
          <Text style={styles.text}>Date : {el.date}</Text>
          <Text style={styles.text}>Time : {el.time}</Text>
          <Text style={styles.text}>Capacity: {el.capacity}</Text>
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
                <Text style={styles.modalText}>Confirm booking</Text>
                <Pressable
                  style={[styles.button, styles.buttonClose]}
                  onPress={() => {
                    this.handleBookSlot(this.state.element)
                    this.setModalVisible(!this.state.modalVisible)
                  }}
                >
                  <Text style={styles.textStyle}>Ok</Text>
                </Pressable>
                <Pressable
                  style={[styles.button, styles.buttonClose]}
                  onPress={() => {
                    this.setModalVisible(!this.state.modalVisible)
                    this.setState({ element: null })
                  }}
                >
                  <Text style={styles.textStyle}>Cancel</Text>
                </Pressable>
              </View>
            </View>
          </Modal>

        </View>
        <View>

        </View>
        < ScrollView>

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

  dateSlider: {
    flex: 1
  },

  row: {
    // flexDirection: 'row'
  }
})
BookSlots.contextType = AppContext;

export default BookSlots;
