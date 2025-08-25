import React from "react";

function Juice({ id, name, price }) {
  return (
    <tr>
      <td style={{ width: "100px" }}>{id}</td>
      <td style={{ width: "250px", textAlign: "left" }}>{name}</td>
      <td style={{ width: "150px" }}>₹ {price}</td>
    </tr>
  );
}

function Q7() {
  const juices = [
    { id: 1, name: "Orange Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 }
  ];

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>🥤 Juice Menu</h2>
      <table border="1" cellPadding="10" cellSpacing="0" style={{ margin: "0 auto", borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {juices.map((juice) => (
            <Juice key={juice.id} {...juice} />
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default Q7;
