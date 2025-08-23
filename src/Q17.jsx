import React, { useState, useEffect } from "react";

//Loading Component
const LoadingComponent = () => (
  <h2>Loading product details...</h2>           //shows simple text while data is being fetched
);


//Error Component
const ErrorComponent = () => (
  <h2>⚠️ Error fetching product details</h2>    //shows error message if data fetch fails
);

//Product Component
const ProductComponent = ({ product }) => {
  return (
    <div style={{ border: "2px solid black", padding: "15px", borderRadius: "10px", width: "300px" }}>
      
      {/*display product name */}
      <h2>{product.name}</h2>
      
      {/*display product brand */}
      <p><b>Brand:</b> {product.brand}</p>
      
      {/* shows price and labels it as Premium or Budget */}
      <p>
        <b>Price:</b> ₹{product.price} {" "}
        ({product.price > 50000 ? "Premium Product" : "Budget Product"})
      </p>
      
      {/* display category and add free Bag offer only if category is Laptop */}
      <p>
        <b>Category:</b> {product.category} 
        {product.category === "Laptop" ? " 🎒 Free Laptop Bag Offer" : ""}
      </p>
      
      {/* display warranty details if >0 show years else No Warranty */}
      <p>
        <b>Warranty:</b> 
        {product.warranty > 0 ? `Warranty: ${product.warranty} years` : "No Warranty"}
      </p>
      
      {/* display availability (if true 'In Stock' else 'Out of Stock') */}
      <p>
        <b>Availability:</b> 
        {product.availability ? " ✅ In Stock" : " ❌ Out of Stock"}
      </p>
    </div>
  );
};

//Main App Component
const Q17 = () => {
  const [loading, setLoading] = useState(true); //state variables
  const [error, setError] = useState(false);
  const [product, setProduct] = useState(null); 

  //useEffect runs once after page loads
  useEffect(() => {
    setTimeout(() => {
      const success = Math.random() > 0.3;      // Simulates success most of the time, but sometimes shows an error

      if (success) {
        setProduct({                // If success; sets product details
          name: "MacBook Pro",
          brand: "Apple",
          price: 120000,
          category: "Laptop",
          warranty: 2,
          availability: true,
        });
        setLoading(false);          //stops the loading
      } else {
        setError(true);             // If failure; set error true
        setLoading(false);          //stops loading
      }
    }, 2000);                       //simulate API call delay of 2 seconds
  }, []);                           //defined useEffect with empty dep array, it runs once after 1st render

  //Conditional Rendering using ternary operators
  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      {loading ? (
        <LoadingComponent />
      ) : error ? (
        <ErrorComponent />
      ) : (
        <ProductComponent product={product} />
      )}
    </div>
  );
};

export default Q17;
