import React, { useState } from "react";

const Q14a = () => {
  const [formData, setFormData] = useState({
    itemName: "",
    quantity: "",
    ingredients: "",
    bakingTime: "",
    category: "Cake",
  });

  const [bakingItems, setBakingItems] = useState([]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setBakingItems([...bakingItems, formData]);
    setFormData({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake",
    });
  };

  return (
    <div className="container mt-4">
      <div className="card p-4 shadow">
        <h2 className="text-center mb-4">🍰 Baking Items Form</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Item Name</label>
            <input
              type="text"
              className="form-control"
              name="itemName"
              value={formData.itemName}
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Quantity</label>
            <input
              type="number"
              className="form-control"
              name="quantity"
              value={formData.quantity}
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Ingredients</label>
            <input
              type="text"
              className="form-control"
              name="ingredients"
              value={formData.ingredients}
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Baking Time (minutes)</label>
            <input
              type="text"
              className="form-control"
              name="bakingTime"
              value={formData.bakingTime}
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Category</label>
            <select
              className="form-control"
              name="category"
              value={formData.category}
              onChange={handleChange}
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          <button type="submit" className="btn btn-success w-100">
            Add Baking Item
          </button>
        </form>
      </div>

      {bakingItems.length > 0 && (
        <div className="mt-5">
          <h3>Baking Items List</h3>
          <table className="table table-bordered table-striped mt-3">
            <thead className="table-dark">
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {bakingItems.map((item, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime}</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default Q14a;
