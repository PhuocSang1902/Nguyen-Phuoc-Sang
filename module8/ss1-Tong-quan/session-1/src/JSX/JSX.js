import React from "react";

function JSX() {
    function formatName(user) {
        return user.firstName + ' ' + user.lastName;
    }

    const user = {
        firstName: 'Harper',
        lastName: 'Perez'
    };

    const myStyle = {
        color: "white",
        backgroundColor: "DodgerBlue",
        padding: "10px",
        fontFamily: "Arial",
        textAlign: "center"
    };

    return (
        <demoJsx>
            <h1 style={{textAlign: "center"}}>
                Hello, {user.firstName + ' ' + user.lastName}!
            </h1>
            <h2 style={{textAlign:"center", color: "blue"}}>This is demo JSX.</h2>
            <h1 style={myStyle}>Demo</h1>
        </demoJsx>

    );
}

export default JSX;
