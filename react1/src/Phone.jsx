import React, { useState } from "react";

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
export default Phone;
