import React, { Component } from "react";

//class component
class CarsForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      carName: "",           // state variable for carName
      description: "",       // state variable for description
      category: "",          // state variable for category
      brand: "",             // state variable for brand
      available: false,      // state variable for available
      warranty: "",          // state variable for warranty
      submittedData: [],     // state variable for storing submitted car entries
    };
  }

  // Event handler - this updates state variable for input
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    this.setState({
      [name]: type === "checkbox" ? checked : value,
    });
  };

  // Event handler: on form submit, store current form data and reset inputs
  handleSubmit = (e) => {
    e.preventDefault();
    const newData = {
      carName: this.state.carName,
      description: this.state.description,
      category: this.state.category,
      brand: this.state.brand,
      available: this.state.available,
      warranty: this.state.warranty,
    };
    this.setState({
      submittedData: [...this.state.submittedData, newData],  //spread operator to add the elements into list st the end
      carName: "",
      description: "",
      category: "",
      brand: "",
      available: false,
      warranty: "",
    });
  };

  render() {
    return (
      <div className="container mt-4">
        <h2 className="mb-3">Car Accessories Form</h2>

        <form onSubmit={this.handleSubmit} className="mb-4">
          <div className="mb-3">
            <label className="form-label">Car Name</label>
            <input
              type="text"
              className="form-control"
              name="carName"
              value={this.state.carName}  // state variable for carName
              onChange={this.handleChange} // event handler
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Description</label>
            <textarea
              className="form-control"
              name="description"
              value={this.state.description} // state variable for description
              onChange={this.handleChange}   // event handler
              required
            ></textarea>
          </div>


          <div className="mb-3">
            <label className="form-label">Category</label>
            <select
              className="form-select"
              name="category"
              value={this.state.category}    // state variable for category
              onChange={this.handleChange}  // event handler
              required
            >
              <option value="">Select Category</option>
              <option value="SUV">SUV</option>
              <option value="Sedan">Sedan</option>
              <option value="Hatchback">Hatchback</option>
              <option value="Convertible">Convertible</option>
            </select>
          </div>


          <div className="mb-3">
            <label className="form-label">Brand</label> <br />
            <div className="form-check form-check-inline">
              <input
                type="radio"
                className="form-check-input"
                name="brand"
                value="Toyota"
                checked={this.state.brand === "Toyota"} // state variable for brand
                onChange={this.handleChange}           // event handler
              />
              <label className="form-check-label">Toyota</label>
            </div>
          </div>

          <div className="mb-3 form-check">
            <input
              type="checkbox"
              className="form-check-input"
              name="available"
              checked={this.state.available}    // state variable for available
              onChange={this.handleChange}     // event handler
            />
            <label className="form-check-label">Available in stock</label>
          </div>


          <div className="mb-3">
            <label className="form-label">Warranty (years)</label>
            <input
              type="number"
              className="form-control"
              name="warranty"
              value={this.state.warranty}     // state variable for warranty
              onChange={this.handleChange}    // event handler
              required
            />
          </div>

          {/*Submit button*/}
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>

          {/*Conditional rendering*/}
        {this.state.submittedData.length > 0 && (
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>Car Name</th>
                <th>Description</th>
                <th>Category</th>
                <th>Brand</th>
                <th>Available</th>
                <th>Warranty</th>
              </tr>
            </thead>
            <tbody>
              {this.state.submittedData.map((data, index) => (
                <tr key={index}>
                  <td>{data.carName}</td>
                  <td>{data.description}</td>
                  <td>{data.category}</td>
                  <td>{data.brand}</td>
                  <td>{data.available ? "Yes" : "No"}</td>
                  <td>{data.warranty}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    );
  }
}
export default CarsForm;
