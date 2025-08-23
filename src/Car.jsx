import React, { Component } from "react";

class Car extends Component {
  render() {
    const { brand, model, color, year } = this.props;
    return (
      <div style={{ border: "2px solid black", padding: "15px", margin: "10px", borderRadius: "8px" }}>
        <p><strong>Brand:</strong> {brand}</p>
        <p><strong>Model:</strong> {model}</p>
        <p><strong>Color:</strong> {color}</p>
        <p><strong>Year:</strong> {year}</p>
      </div>
    );
  }
}
export default Car;
//child class component named Car
//presentational since no Business Logic
// object destructuring at line 5