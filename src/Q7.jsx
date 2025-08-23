import React from "react";

function Juice({ id, name, price }) {
  return (
    <tr>
      <td style={{ border: "1px solid black", padding: "10px" }}>{id}</td>
      <td
        style={{
          border: "1px solid black",
          padding: "10px",
          textAlign: "left"
        }}
      >
        {name}
      </td>
      <td style={{ border: "1px solid black", padding: "10px" }}>₹ {price}</td>
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
      <table
        style={{
          margin: "0 auto",
          borderCollapse: "collapse",
          width: "500px"
        }}
      >
        <thead>
          <tr>
            <th
              style={{
                border: "1px solid black",
                padding: "10px",
                backgroundColor: "#f2f2f2"
              }}
            >
              ID
            </th>
            <th
              style={{
                border: "1px solid black",
                padding: "10px",
                backgroundColor: "#f2f2f2"
              }}
            >
              Juice Name
            </th>
            <th
              style={{
                border: "1px solid black",
                padding: "10px",
                backgroundColor: "#f2f2f2"
              }}
            >
              Price
            </th>
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
