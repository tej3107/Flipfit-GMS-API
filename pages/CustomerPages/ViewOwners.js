import React from "react";
import { Text, View, StyleSheet, TouchableOpacity } from "react-native";
//import Toast from 'react-native-toast-message';
import { AppContext } from "../../appContext";

class ViewOwners extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null
        }
    }



    componentDidMount() {

        console.log("View Owner Mounted");

        fetch("http://10.0.2.2:5000/admin/view/owner/all", {

        })
            .then((res) => res.json())
            .then(res => {
                console.log(res)
                this.setState({ data: res })
            })
            .catch(err => console.error(err));
    }


    RenderList = (el) => {
        return (
            <TouchableOpacity key={el.slug} >
                <View style={styles.container}>
                    <Text style={styles.text}>{el.ownerId}</Text>
                    <Text style={styles.text}>{el.name}</Text>
                </View>
            </TouchableOpacity>
        )
    }


    render() {
        return (
            <View>
                <Text>View all owners here: </Text>
                {
                    this.state.data && this.state.data.map((el) => this.RenderList(el))
                }
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



export default ViewOwners;