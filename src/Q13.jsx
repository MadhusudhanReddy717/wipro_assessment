import React, { Component } from "react";

// Class component
class MarriageForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      brideName: "",
      groomName: "", // state variables
      date: "",      
      venue: "",     
      submitted: false // tracks if the form has been submitted
    };
  }


  // Event handler
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value }); 
    // the value typed in the input will be updated to the corresponding state variable
  };


  // Handles the form submission
  handleSubmit = (e) => {
    e.preventDefault(); // prevents browser default action
    this.setState({ submitted: true }); 
    // when submit is clicked, submitted state is set to true to display details
  };

  render() {
    return (
      <div className="container mt-4">
        <div className="card p-4 shadow">
          <h2 className="text-center mb-4">Marriage Form</h2>
          <form onSubmit={this.handleSubmit}>
            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                name="brideName"
                className="form-control"
                value={this.state.brideName} // User input is updated to its state property
                onChange={this.handleChange} // changes will update the brideName state
              />
            </div>

            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                name="groomName"
                className="form-control"
                value={this.state.groomName} // User input is updated to its state property
                onChange={this.handleChange} // changes will update the groomName state
              />
            </div>

            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date"
                name="date"
                className="form-control"
                value={this.state.date} // User input is updated to its state property
                onChange={this.handleChange} // changes will update the date state
              />
            </div>

            <div className="form-group mb-3">
              <label>Venue</label>
              <input
                type="text"
                name="venue"
                className="form-control"
                value={this.state.venue} // User input is updated to its state property
                onChange={this.handleChange} // changes will update the venue state
              />
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {this.state.submitted && (    //conditional rendering
          <div className="card mt-4 p-4 shadow">
            <h3>Marriage Details</h3>
            <p>Bride Name: {this.state.brideName}</p>
            <p>Groom Name: {this.state.groomName}</p>
            <p>Date: {this.state.date}</p>
            <p>Venue: {this.state.venue}</p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm; 