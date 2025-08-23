import React, { Component, createRef } from "react";

//Controlled Component
class FlightBookingControlled extends Component {
  constructor(props) {
    super(props);
    this.state = {
      passengerName: "",
      email: "",            //state variables
      gender: "",
      meal: "Veg",
      request: "",
      submitted: false    //default, form submission status
    };
  }

  //Event Handler that update the state values
  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  //Event Handler that set submitted is true and wont allow to reload the page
  handleSubmit = (event) => {
    event.preventDefault();
    this.setState({ submitted: true });
  };


  render() {
    return (
      <div className="col-md-6">
        <h3>Controlled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3">
            <label>Passenger Name</label>
            <input
              type="text"
              name="passengerName"
              className="form-control"
              value={this.state.passengerName}
              onChange={this.handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label>Email</label>
            <input
              type="email"
              name="email"
              className="form-control"
              value={this.state.email}
              onChange={this.handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label>Gender</label> <br />
            <input
              type="radio"
              name="gender"
              value="Male"
              checked={this.state.gender === "Male"}  //Radio buttons for input as MAle or Female
              onChange={this.handleChange}
            />{" "}
            Male
            <input
              type="radio"
              name="gender"
              value="Female"
              className="ms-3"
              checked={this.state.gender === "Female"}
              onChange={this.handleChange}
            />{" "}
            Female
          </div>

          <div className="mb-3">
            <label>Meal Preference</label>
            <select
              name="meal"
              className="form-control"
              value={this.state.meal}
              onChange={this.handleChange}  //Select tag to choose veg or non veg
            >
              <option>Veg</option>
              <option>Non-Veg</option>
            </select>
          </div>

          <div className="mb-3">
            <label>Special Request</label>
            <textarea
              name="request"
              className="form-control"
              value={this.state.request}      //special request if any can be written in this text box
              onChange={this.handleChange}
            ></textarea>
          </div>

          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>

        {/* Table for Displaying */}
        {this.state.submitted && (
          <table className="table table-bordered mt-3">
            <thead>
              <tr>
                <th>Passenger Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Meal</th>
                <th>Request</th>
              </tr>
            </thead>
            <tbody>
              <tr>                                    
                <td>{this.state.passengerName}</td>
                <td>{this.state.email}</td>
                <td>{this.state.gender}</td>
                <td>{this.state.meal}</td>
                <td>{this.state.request}</td>
              </tr>
            </tbody>
          </table>
        )}
      </div>
    );
  }
}


//Form 2
/* Uncontrolled Component using Ref*/
class FlightBookingUncontrolled extends Component {
  constructor(props) {
    super(props);
    this.flightNoRef = createRef();
    this.sourceRef = createRef();
    this.destRef = createRef();
    this.dateRef = createRef();         //state ref varaibles
    this.termsRef = createRef();
    this.state = { submitted: false, details: {} };
  }

  handleSubmit = (event) => {
    event.preventDefault();
    this.setState({                         //Reads values directly from refs instead of state
      submitted: true,
      details: {
        flightNo: this.flightNoRef.current.value,
        source: this.sourceRef.current.value,
        dest: this.destRef.current.value,
        date: this.dateRef.current.value,
        terms: this.termsRef.current.checked
      }
    });
  };

  render() {
    return (
      <div className="col-md-6">
        <h3>Uncontrolled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3">
            <label>Flight Number</label>
            <input type="text" ref={this.flightNoRef} className="form-control" />
          </div>

          <div className="mb-3">
            <label>Source</label>
            <input type="text" ref={this.sourceRef} className="form-control" />
          </div>

          <div className="mb-3">
            <label>Destination</label>
            <input type="text" ref={this.destRef} className="form-control" />
          </div>

          <div className="mb-3">
            <label>Travel Date</label>
            <input type="date" ref={this.dateRef} className="form-control" />
          </div>

          <div className="mb-3 form-check">
            <input type="checkbox" ref={this.termsRef} className="form-check-input" />
            <label className="form-check-label">Terms Accepted</label>
          </div>

          <button type="submit" className="btn btn-success">
            Submit
          </button>
        </form>

        {this.state.submitted && (
          <div className="card mt-3">
            <div className="card-body">
              <h5 className="card-title">Flight Details</h5>        {/*For displaying the details*/}
              <p>Flight Number: {this.state.details.flightNo}</p>
              <p>Source: {this.state.details.source}</p>
              <p>Destination: {this.state.details.dest}</p>
              <p>Date: {this.state.details.date}</p>
              <p>
                Terms Accepted:{" "}
                {this.state.details.terms ? "Yes" : "No"}     {/* terenary operator to display Yes/No */}
              </p>
            </div>
          </div>
        )}
      </div>
    );
  }
}

/* Parent App */
function App() {
  return (
    <div className="container mt-4">
      <div className="row">
        <FlightBookingControlled />
        <FlightBookingUncontrolled />
      </div>
    </div>
  );
}

export default App;
