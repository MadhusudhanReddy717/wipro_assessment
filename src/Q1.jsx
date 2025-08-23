import React from "react";

//Functional Component Q1
const Q1 = () => {
  const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];
  return <GroceryList items={groceries} />;
};


//child component
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

export default Q1;
//presentational component
//constant Array groceries is declared
//display data received from {items} using key