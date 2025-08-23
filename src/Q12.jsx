import React, { Component } from "react";

// Parent Component that manages TV models
class TelevisionManager extends Component {
  constructor(props) {
    super(props);
    this.state = {
      models: ["Samsung", "Sony", "LG"], // state variable holding list of all TV models
      newModel: ""                       // state variable for input field
    };
  }


  // Arrow function to handle typing in input box
  // Any change in input will update the state variable 'newModel'
  handleChange = (e) => {
    this.setState({ newModel: e.target.value });
  };



  // Function to add new model to the list
  addModel = () => {
    const { newModel, models } = this.state; // Checks if input is not empty, then updates the models array in state
    if (newModel.trim() !== "") {
      this.setState({
        models: [...models, newModel],     // keep old models + add new one
        newModel: ""                       // reset input field after adding
      });
    }
  };

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h2>Television Manager</h2>

        {/* Input field bound to 'newModel' state */}
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleChange}   //Change in input value will be shown in the newModel
          placeholder="Enter model"  // shows hint text in input
        />

        {/* Button to add new model to list */}
        <button onClick={this.addModel} style={{ marginLeft: "10px" }}>
          Add
        </button>

        {/* Child component displays list of models */}
        {/* Passing models state as props */}
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

// Child Component responsible only for displaying the list of models
function TelevisionList({ models }) {
  return (
    <div style={{ marginTop: "15px" }}>
      <h3>Television List</h3>
      <ul>
        {models.map((model, index) => (
          <li key={index}>{model}</li>    // Each model will be displayed as a list item, map is used to iterate the model
        ))}
      </ul>
    </div>
  );
}


export default TelevisionManager;
