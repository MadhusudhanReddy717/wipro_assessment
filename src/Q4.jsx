import React from "react";

//arrow function component
const Q4 = () => {
  const sweets = [
    { id: 1, name: "Gulab Jamun", price: 70 },
    { id: 2, name: "Rasgulla", price: 60 },
    { id: 3, name: "Jalebi", price: 40 },
    { id: 4, name: "Laddu", price: 50 }
  ];

  return (
    <div style={{ border: "2px solid black", padding: "15px", margin: "10px", borderRadius: "8px" }}>
      <h2>Sweets List</h2>
      <ul>
        {sweets.map((sweet) => (
          <li key={sweet.id}>
            {sweet.name} - Price: ₹{sweet.price}
          </li>
        ))}
      </ul>
    </div>
  );
};
export default Q4;


//used map function to iterate the sweets at 16
//renders each sweet as list using key