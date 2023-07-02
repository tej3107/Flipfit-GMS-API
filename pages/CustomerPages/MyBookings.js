import React from "react";
import { Alert, Modal, Button, Text, StyleSheet, ScrollView, View, Pressable, TouchableOpacity } from "react-native";
import { AppContext } from "../../appContext"

import { Toast } from "react-native-toast-message/lib/src/Toast";
class MyBookings extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: null,
            data: null,
            modalVisible: false,
            element: null

        }
    }
    setModalVisible = (visible) => {
        this.setState({ modalVisible: visible });
    }
    fetchData = () => {
        fetch(`http://10.0.2.2:5000/customer/booked/${this.context.userName}`, {

        })
            .then((res) => {
                if (res.ok) return res.json()
                else console.log("error In show booking")
            }

            )
            .then(res => {
                this.setState({ data: res.data })
            })
            .catch(err => console.error(err));

    }

    componentDidMount() {

        this.fetchData()

    }
    handleCancel = (el) => {



        fetch(`http://10.0.2.2:5000/customer/delete/slot/${el.userName}/${el.slotId}`, { method: "POST" })
            .then((res) => {

                if (res.ok) return res.json()
                else console.log(res.status + "error In shddow booking")
            }

            )
            .then(res => {
                if (res.data[0]) {

                    Toast.show(
                        {
                            type: "info",
                            text1: "The slot was canceled successsfully",
                            //text2: responseJson[1],
                            position: "top",
                            autoHide: true,
                            visibilityTime: 2000
                        }
                    )
                }
                else {
                    console.log("error in cancellation")
                }

            })
            .catch(err => console.error(err))

            .finally(() => this.fetchData())
    }



    RenderList = (el) => {
        return (
            <TouchableOpacity key={el.bookingId}  >
                <View style={styles.container}>
                    <Text style={styles.text}>{el.gymName}</Text>
                    <Text style={styles.text}>{el.slotTime}</Text>
                    <Text style={styles.text}>{el.slotDate}</Text>
                    <Button title="Cancel" onPress={() => {
                        this.setState({ element: el })
                        this.setModalVisible(true)


                    }} />
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
                                <Text style={styles.modalText}>Do you want to cancel this slot.</Text>
                                <Pressable
                                    style={[styles.button, styles.buttonClose]}
                                    onPress={() => {
                                        this.handleCancel(this.state.element)
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
                <ScrollView>

                    {
                        (this.state.data != null) ? ((this.state.data.length === 0) ?
                            (<Text>You have not booked any slot</Text>) :
                            this.state.data.map((el) => this.RenderList(el))) :

                            (<Text>Nothing to show</Text>)

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

MyBookings.contextType = AppContext;

export default MyBookings;
