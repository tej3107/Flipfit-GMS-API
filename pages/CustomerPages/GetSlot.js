import React from "react";
import { Text, StyleSheet, ScrollView, View, TouchableOpacity } from "react-native";


class GetSlot extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null

        }
    }

    handleClick = (el) => {
        console.log("Handle click");
        console.log(el.name)
        this.props.navigation.navigate('BookSlots', el)
    }

    componentDidMount() {

        console.log("View gym Mounted");

        fetch("http://10.0.2.2:5000/customer/fetchGym", {

        })
            .then((res) => {
                if (res.ok) {
                    return res.json()
                }
                else {
                    throw new Error();
                }
            })

            .then(r => {
                console.log(r.data)
                this.setState({ data: r.data })
            })
            .catch(err => console.error(err));
    }


    RenderList = (el) => {
        return (

            <TouchableOpacity key={el.gymId} onPress={() => { this.handleClick(el) }} >
                <View style={styles.container}>
                    <Text style={styles.text}>Gym Name: {el.name}</Text>
                    <Text style={styles.text}>Gym Address:{el.address}</Text>
                </View>
            </TouchableOpacity>
        )
    }


    render() {
        return (

            <ScrollView>

                {
                    this.state.data && this.state.data.map((el) => this.RenderList(el))
                }
            </ScrollView>
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

export default GetSlot;
