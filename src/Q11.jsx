import React, { Component } from "react";

//Parent Component
class Fruits extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fruits: ["Apple", "Banana", "Mango"],   // fruits array that holds all the values of fruits
      newFruit: ""     // state variable for the input value
    };
  }

  //Arrow function to handle input change
  handleChange = (e) => {
    this.setState({ newFruit: e.target.value });   //update newFruit state with input value
  };

  // Arrow function to add a new fruit
  addFruit = () => {
    if (this.state.newFruit.trim() !== "") {   //check if input is not empty
      this.setState((prevState) => ({
        fruits: [...prevState.fruits, prevState.newFruit],   //used spread operator to keep existing fruits and add new one
        newFruit: ""   //reset input field after adding
      }));
    }
  };

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h2>Fruit Management</h2>
        <input
          type="text"
          value={this.state.newFruit}     // change in input value will update the state variable
          onChange={this.handleChange}    // it calls handleChange to update the state
          placeholder="Enter fruit name"
        />
        <button onClick={this.addFruit} style={{ marginLeft: "10px" }}>
          Add Fruit {/* button that activate the addFruit function */}
        </button>

        <FruitList fruits={this.state.fruits} /> {/* will pass fruits array to child as props */}
      </div>
    );
  }
}

// Child component
function FruitList(props) {
  return (
    <div style={{ marginTop: "15px" }}>
      <h3>Fruit List:</h3>
      <ul>
        {props.fruits.map((fruit, index) => (
          <li key={index}>{fruit}</li>              // created list item for each fruit in the array
        ))}
      </ul>
    </div>
  );
}

export default Fruits;
