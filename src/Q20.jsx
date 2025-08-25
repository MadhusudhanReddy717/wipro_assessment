import React, { useState, useEffect } from "react";

export default function Q20() {
  /* State to store form data */
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contact: "",
    address: "",
    cuisine: "",
    hours: ""
  });

  const [submittedData, setSubmittedData] = useState(null);

  /* Handle input changes */
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  /* Handle form submit */
  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmittedData(formData);
  };

  /* ------------------- useEffect Examples ------------------- */

  // 1. Runs on every render
  useEffect(() => {
    console.log("Component rendered or re-rendered");
  });

  // 2. Runs only once (on mount)
  useEffect(() => {
    console.log("Component mounted (runs only once)");
  }, []);

  // 3. Runs whenever form data changes
  useEffect(() => {
    console.log("Form data changed:", formData);
  }, [formData]);

  // 4. Auto-save every 5 seconds with cleanup
  useEffect(() => {
    const interval = setInterval(() => {
      console.log("Auto-saving data:", formData);
    }, 5000);

    return () => clearInterval(interval); // cleanup
  }, [formData]);

  /* ------------------- JSX ------------------- */
  return (
    <div className="container mt-4">
      <h2 className="mb-3">🍴 Restaurant Registration Form</h2>
      <p>Welcome to Restaurant Registration 🏬</p>

      <form onSubmit={handleSubmit}>
        <div className="mb-2">
          <input
            type="text"
            name="restaurantName"
            className="form-control"
            placeholder="Restaurant Name"
            value={formData.restaurantName}
            onChange={handleChange}
          />
        </div>

        <div className="mb-2">
          <input
            type="text"
            name="ownerName"
            className="form-control"
            placeholder="Owner Name"
            value={formData.ownerName}
            onChange={handleChange}
          />
        </div>

        <div className="mb-2">
          <input
            type="email"
            name="email"
            className="form-control"
            placeholder="Email"
            value={formData.email}
            onChange={handleChange}
          />
        </div>

        <div className="mb-2">
          <input
            type="text"
            name="contact"
            className="form-control"
            placeholder="Contact Number"
            value={formData.contact}
            onChange={handleChange}
          />
        </div>

        <div className="mb-2">
          <input
            type="text"
            name="address"
            className="form-control"
            placeholder="Address"
            value={formData.address}
            onChange={handleChange}
          />
        </div>

        <div className="mb-2">
          <input
            type="text"
            name="cuisine"
            className="form-control"
            placeholder="Cuisine Type"
            value={formData.cuisine}
            onChange={handleChange}
          />
        </div>

        <div className="mb-2">
          <input
            type="text"
            name="hours"
            className="form-control"
            placeholder="Opening Hours"
            value={formData.hours}
            onChange={handleChange}
          />
        </div>

        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>

      {/* Show submitted data */}
      {submittedData && (
        <div className="mt-4">
          <h5>📂 Submitted Data (JSON)</h5>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}
