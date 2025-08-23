import React, { useState } from "react";

const Q5 = () => {

  //state variables
  const [name] = useState("Laptop");
  const [brand, setBrand] = useState("Dell"); //default
  const [price, setPrice] = useState(55000); //default

  //function to increase the price
  const increasePrice = () => setPrice(price + 5000);

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Electronic Item Details</h1>
      <div style={{ border: "2px solid black", padding: "15px", margin: "10px", borderRadius: "8px", display: "inline-block" }}>

        <p><strong>Name:</strong> {name}</p>
        <p><strong>Brand:</strong> {brand}</p>
        <p><strong>Price:</strong> ₹{price}</p>

        <button onClick={() => setBrand("HP")} style={{ marginRight: "10px" }}>
          Change Brand
        </button>

        <button
          onClick={increasePrice}
          style={{
            backgroundColor: "black",
            color: "white",
            padding: "8px 16px",
            border: "none",
            borderRadius: "5px",
            cursor: "pointer"
          }}
        >
          Increase Price
        </button>
      </div>
    </div>
  );
};

export default Q5;

//state variables are initialised some are const, some are variable
//function to update price is defined
//buttons like Change Brand and Increase Price are given as responsive