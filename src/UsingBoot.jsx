import React, { useState } from "react";

const UsingBoot = ({ serviceName, price, fabricsAvailable }) => {
  const [showFabrics, setShowFabrics] = useState(false);

  return (
    <div className="col-md-4 mb-4">
      <div className="card shadow-sm h-100">
        <div className="card-body">
          <h5 className="card-title">{serviceName}</h5>
          <p className="card-text"><strong>Price:</strong> ₹{price}</p>
          <button className="btn btn-primary btn-sm mb-2" onClick={() => setShowFabrics(!showFabrics)}>
            {showFabrics ? "Hide Fabrics" : "Show Fabrics"}
          </button>
          {showFabrics && (
            <div>
              <p className="card-text"><strong>Fabrics:</strong></p>
              <ul>
                {fabricsAvailable.map((fabric, index) => <li key={index}>{fabric}</li>)}
              </ul>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};
export default UsingBoot;
