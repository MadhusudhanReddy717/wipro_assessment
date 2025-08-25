import React from "react";

const CanteenItem = ({ name, price, category, available }) => (
  <li>
    {name} – Price: ₹{price} – Category: {category} – {available === "Yes" ? "Available" : "Not Available"}
  </li>
);

const Q6 = () => (
  <div style={{ border: "2px solid black", padding: "15px", margin: "10px", borderRadius: "8px" }}>
    <h2>Canteen Name: Campus Food Court</h2>
    <p><strong>Location:</strong> Block A, Ground Floor</p>
    <p><strong>Open Hours:</strong> 8:00 AM – 8:00 PM</p>
    <h3>Canteen Menu:</h3>
    <ul>
      <CanteenItem name="Idli" price={20} category="Breakfast" available="Yes" />
      <CanteenItem name="Dosa" price={10} category="Breakfast" available="Yes" />
      <CanteenItem name="Vada" price={10} category="Snack" available="No" />
      <CanteenItem name="Poori" price={40} category="Breakfast" available="Yes" />
      <CanteenItem name="Meals" price={120} category="Lunch" available="Yes" />
    </ul>
  </div>
);
export default Q6;
