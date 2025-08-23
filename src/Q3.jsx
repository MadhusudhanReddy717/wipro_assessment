import React, { useState } from "react";

//functional component
const Q3 = () => (
  <div style={{ textAlign: "center" }}>
    <h1>Phone Information</h1>
    <Phone />
  </div>
);

const Phone = () => {
  const [phone, setPhone] = useState({ brand: "Apple", model: "iPhone 15", price: 80000 });
  const updatePrice = () => setPhone({ ...phone, price: phone.price + 5000 });

  return (
    <div style={{ border: "2px solid black", padding: "15px", margin: "10px", borderRadius: "8px" }}>
      <h2>Phone Details</h2>
      <p><strong>Brand:</strong> {phone.brand}</p>
      <p><strong>Model:</strong> {phone.model}</p>
      <p><strong>Price:</strong> ₹{phone.price}</p>
      <button onClick={updatePrice} style={{ backgroundColor: "blue", color: "white", padding: "8px 16px", border: "none", borderRadius: "5px", cursor: "pointer" }}>
        Increase Price
      </button>
    </div>
  );
};
export default Q3;

//useState for re-rendering 
//setPhone is stateupdater to update the phone object
//state variable for phone object at line 13
//used spread operator to keep the other unchanged upon changing the price
