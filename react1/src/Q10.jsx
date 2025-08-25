import React from "react";
import UsingBoot from "./UsingBoot";

const Q10 = () => {
  const services = [
    { serviceName: "Shirt", price: 800, fabricsAvailable: ["Cotton", "Linen", "Polyester"] },
    { serviceName: "Pants", price: 1200, fabricsAvailable: ["Denim", "Wool", "Chino"] },
    { serviceName: "Lehenga", price: 5000, fabricsAvailable: ["Silk", "Georgette", "Chiffon"] },
    { serviceName: "Blouse", price: 1500, fabricsAvailable: ["Cotton", "Silk", "Satin"] }
  ];

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Tailoring Services</h2>
      <div className="row">
        {services.map((service, index) => (
          <UsingBoot key={index} {...service} />
        ))}
      </div>
    </div>
  );
};
export default Q10;
