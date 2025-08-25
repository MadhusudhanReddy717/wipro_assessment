import React, { Component } from "react";
import Car from "./Car";

class Q2 extends Component {
  render() {
    return (
      <div style={{ textAlign: "center" }}>
        <h1>Car Details</h1>
        <Car brand="Tata" model="Harrier" color="Black" year="2025" />
        <Car brand="Tata" model="Safari" color="White" year="2025" />
        <Car brand="BMW" model="M3" color="Black" year="2023" />
      </div>
    );
  }
}
export default Q2;
