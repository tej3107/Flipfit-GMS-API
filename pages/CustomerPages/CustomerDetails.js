import React, { Component } from 'react';
import { View, TouchableOpacity, Text, Button, StyleSheet } from 'react-native';
import { AppContext } from "../../appContext"
class CustomerDetails extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userData: "e"
        }
    }
    fetchData = () => {

        console.log(`http://10.0.2.2:5000/customer/getCustomerDetails/${this.context.userName}`);
        fetch(`http://10.0.2.2:5000/customer/getCustomerDetails/${this.context.userName}`,)
            .then((res) => {
                if (res.ok)
                    return res.json()

                else {
                    console.log("error in fetch user data")
                }
            })

            .then(r => {

                console.log(r.data[0])
                this.setState({ userData: r.data[0] })
                console.log("this is isi isi s ")
                console.log(this.state)
            })
            .catch(err => console.error(err));
    }

    componentDidMount() {

        this.fetchData();

    }
    handleLogout = () => {

        this.context.changeUser(null)

        this.props.navigation.navigate("Home")

    }

    render() {

        // const { userName, name, mobile, email, address } = this.state.userData;

        return (
            <View style={styles.container}>
                <Text style={styles.label}>Username: {this.state.userData.userName}</Text>
                <Text style={styles.label}>Name: {this.state.userData.name}</Text>
                <Text style={styles.label}>Mobile: {this.state.userData.mobile}</Text>
                <Text style={styles.label}>Email: {this.state.userData.email}</Text>
                <Text style={styles.label}>Address: {this.state.userData.address}</Text>

                <TouchableOpacity>
                    <Button
                        title="Logout"
                        onPress={this.handleLogout}
                        style={styles.logoutButton}
                    />
                </TouchableOpacity>

            </View>
        );
    }

}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 16,
        alignItems: 'center',
        justifyContent: 'center',
    },
    label: {
        fontSize: 18,
        marginBottom: 8,
    },
    logoutButton: {
        marginTop: 16,
    },
});
CustomerDetails.contextType = AppContext;

export default CustomerDetails;
