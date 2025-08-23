import React, { useState } from "react";

function Chair() {
  return (
    <div className="border rounded-2xl shadow p-4 w-100">
      <h4 className="fw-bold">🪑 Chair</h4>
      <p>Name: Office Chair</p>
      <p>Price: ₹2500</p>
      <p>Material: Plastic</p>
      <p>Brand: Nilkamal</p>
    </div>
  );
}

function Table() {
  return (
    <div className="border rounded-2xl shadow p-4 w-100">
      <h4 className="fw-bold">📏 Table</h4>
      <p>Name: Dining Table</p>
      <p>Price: ₹7500</p>
      <p>Material: Wood</p>
      <p>Brand: Godrej</p>
    </div>
  );
}

function Sofa() {
  return (
    <div className="border rounded-2xl shadow p-4 w-100">
      <h4 className="fw-bold">🛋 Sofa</h4>
      <p>Name: Recliner Sofa</p>
      <p>Price: ₹15000</p>
      <p>Material: Leather</p>
      <p>Brand: Pepperfry</p>
    </div>
  );
}

function Bed() {
  return (
    <div className="border rounded-2xl shadow p-4 w-100">
      <h4 className="fw-bold">🛏 Bed</h4>
      <p>Name: King Size Bed</p>
      <p>Price: ₹20000</p>
      <p>Material: Teak Wood</p>
      <p>Brand: Durian</p>
    </div>
  );
}

export default function Q18() {
  const [selected, setSelected] = useState("Chair");

  const renderFurniture = () => {
    switch (selected) {
      case "Chair":
        return <Chair />;
      case "Table":
        return <Table />;
      case "Sofa":
        return <Sofa />;
      case "Bed":
        return <Bed />;
      default:
        return null;
    }
  };

  return (
    <div className="d-flex flex-column align-items-center">
      <h2 className="mb-3">Furniture Store</h2>
      <select
        className="form-select mb-4 w-50"
        value={selected}
        onChange={(e) => setSelected(e.target.value)}
      >
        <option>Chair</option>
        <option>Table</option>
        <option>Sofa</option>
        <option>Bed</option>
      </select>
      {renderFurniture()}
    </div>
  );
}
