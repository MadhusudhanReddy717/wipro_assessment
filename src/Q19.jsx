import React, { useEffect, useState, useRef } from "react";

const Q19 = () => {
  // festival stores the current festival name
  const [festival, setFestival] = useState("Diwali");
  const [countdown, setCountdown] = useState(3); // countdown stores seconds left

  // useRef to keep a flag, so alert runs only once, since running twice due to index.js
  const alerted = useRef(false);

  // helper function to get the current time
  const getTimestamp = () => {
    const now = new Date();
    return now.toISOString().substr(11, 12);
  };

  // runs after EVERY render
  useEffect(() => {
    console.log(`Festival App Rendered\t${getTimestamp()}`);
  });

  // runs only once when app starts (on mount)
  useEffect(() => {
    if (!alerted.current) {
      alert("Welcome to Diwali Festival App"); // show alert box once
      console.log(`Welcome to Diwali Festival App\t${getTimestamp()}`);
      alerted.current = true;
    }
  }, []);

  // Countdown timer decreases seconds every second
  useEffect(() => {
    const timer = setInterval(() => {
      setCountdown((prev) => (prev > 0 ? prev - 1 : 0));
    }, 1000);

    // cleanup when component unmounts
    return () => clearInterval(timer);
  }, []);

  // runs when either festival or countdown changes
  useEffect(() => {
    if (festival !== "Diwali") {
      console.log(
        `Festival changed to ${festival}. Seconds left: ${countdown}\t${getTimestamp()}`
      );
    }
  }, [festival, countdown]);

  // button handler cycles festivals
  const handleChangeFestival = () => {
    if (festival === "Diwali") setFestival("Holi");
    else if (festival === "Holi") setFestival("Pongal");
    else setFestival("Diwali");
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Festival React App</h2>
      <p>
        Current Festival: <b>{festival}</b>
      </p>
      <button onClick={handleChangeFestival}>Change Festival</button>
    </div>
  );
};

export default Q19;
