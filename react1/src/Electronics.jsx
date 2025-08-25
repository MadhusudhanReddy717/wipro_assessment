import React, { useState } from "react";

const Electronics = () => {
  const [name] = useState("Laptop");
  const [brand, setBrand] = useState("Dell");
  const [price, setPrice] = useState(55000);

  return (
    <div style={{ border: "2px solid black", padding: "15px", margin: "10px", borderRadius: "8px" }}>
      <h2>Electronic Item Details</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>Brand:</strong> {brand}</p>
      <p><strong>Price:</strong> ₹{price}</p>
      <button onClick={() => setBrand("HP")} style={{ marginRight: "10px" }}>Change Brand</button>
      <button onClick={() => setPrice(price + 5000)} style={{ backgroundColor: "black", color: "white", padding: "8px 16px", border: "none", borderRadius: "5px", cursor: "pointer" }}>
        Increase Price
      </button>
    </div>
  );
};
export default Electronics;
