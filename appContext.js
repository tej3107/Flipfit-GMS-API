import React from "react";

export const cities = {
    bangalore: "Bangalore",
    chennai: "Chennai",
    mumbai: "Mumbai"
}

const globalContext = {
    city: cities.bangalore,
    changeCity: () => { },
    userName : null,
    changeUser: ()=>{}
}

export const AppContext = React.createContext(globalContext)