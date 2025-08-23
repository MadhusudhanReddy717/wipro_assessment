import React from "react";

const Q9 = () => {
  const temples = [
    { id: 1, name: "Mallikarjun Temple", location: "Srisailam, Andhra Pradesh", deities: ["Shiva", "Parvati"] },
    { id: 2, name: "Sri Venkateswara Temple", location: "Tirupati, Andhra Pradesh", deities: ["Venkateswara", "Lakshmi"] },
    { id: 3, name: "Arunachaleswar Temple", location: "Tiruvannamalai, Tamil Nadu", deities: ["Shiva"] }
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h2>🛕 Famous Temples in India</h2>
      <table border="1" cellPadding="10" cellSpacing="0" style={{ borderCollapse: "collapse", width: "100%" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {temples.map((temple) => (
            <tr key={temple.id}>
              <td>{temple.id}</td>
              <td>{temple.name}</td>
              <td>{temple.location}</td>
              <td>
                <ul>
                  {temple.deities.map((deity, index) => (
                    <li key={index}>{deity}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default Q9;
