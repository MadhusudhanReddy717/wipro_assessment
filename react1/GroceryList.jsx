import React from "react";

function GroceryList({ items }) {
  return (
    <div>
      <h2>Grocery List</h2>
      <ul>
        {items.map((item, i) => (
          <li key={i}>{item}</li>
        ))}
      </ul>
    </div>
  );
}

export default GroceryList;
