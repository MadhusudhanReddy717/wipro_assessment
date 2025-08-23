import React, { useState } from "react";

const Q21 = () => {
  const [fruits, setFruits] = useState(["Apple", "Mango", "Banana"]);
  const [selectedFruit, setSelectedFruit] = useState("");
  const [sendIndex, setSendIndex] = useState(0);                      // track which fruit to send next

  // Child A displays the fruit list and allow selection
  const ChildA = ({ fruits, onSelect }) => (
    <div style={boxStyle}>
      <h4>Fruit List</h4>
      <ul>
        {fruits.map((fruit, index) => (
          <li
            key={index}
            style={{ cursor: "pointer" }}
            onClick={() => onSelect(fruit)}
          >
            {fruit}
          </li>
        ))}
      </ul>
    </div>
  );

  // will send fruits one by one
  const ChildB = ({ addFruit, sendIndex, setSendIndex }) => {
    const fruitsToSend = ["Orange", "Grapes"];

    const handleClick = () => {
      if (sendIndex < fruitsToSend.length) {
        addFruit(fruitsToSend[sendIndex]);
        setSendIndex(sendIndex + 1);
      }
    };

    return (
      <div style={boxStyle}>
        <h4>Sender</h4>
        <button onClick={handleClick}>
          {sendIndex < fruitsToSend.length ? "Send Fruit" : "All Sent"}
        </button>
      </div>
    );
  };

  // child C shows selected fruit
  const ChildC = ({ fruit }) => (
    <div style={boxStyle}>
      <h4>Selected Fruit</h4>
      <p>{fruit || "None"}</p>
    </div>
  );

  // add fruit function for child to patient
  const handleAddFruit = (newFruit) => {
    if (!fruits.includes(newFruit)) {
      setFruits([...fruits, newFruit]);
    }
  };

  return (
    <div style={containerStyle}>
      <h3>Q21 Output</h3>
      <div style={{ display: "flex", gap: "20px" }}>
        <ChildA fruits={fruits} onSelect={setSelectedFruit} />
        <ChildB
          addFruit={handleAddFruit}
          sendIndex={sendIndex}
          setSendIndex={setSendIndex}
        />
        <ChildC fruit={selectedFruit} />
      </div>
    </div>
  );
};

const containerStyle = {
  backgroundColor: "#f0f0f0",
  padding: "20px",
  borderRadius: "10px",
};

const boxStyle = {
  backgroundColor: "white",
  padding: "15px",
  borderRadius: "8px",
  boxShadow: "0 0 5px rgba(0,0,0,0.1)",
};

export default Q21;
