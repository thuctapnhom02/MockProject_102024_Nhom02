import React, { useState } from "react";

const IncomeModal = ({ isOpen, onClose, onAdd }) => {
  const [formData, setFormData] = useState({
    serviceType: "",
    apartment: "",
    tenant: "",
    fee: "",
    paymentDeadline: "",
    status: "",
    paymentMethod: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onAdd(formData); // Pass the form data to the onAdd function
    onClose(); // Close the modal after adding
    setFormData({
      serviceType: "",
      apartment: "",
      tenant: "",
      fee: "",
      paymentDeadline: "",
      status: "",
      paymentMethod: "",
    });
  };

  if (!isOpen) return null;

  return (
    <div className="modal">
      <div className="modal-content">
        <h2>Add New Income</h2>
        <form onSubmit={handleSubmit}>
          <label>
            Service Type:
            <input
              type="text"
              name="serviceType"
              value={formData.serviceType}
              onChange={handleChange}
            />
          </label>
          <label>
            Apartment:
            <input
              type="text"
              name="apartment"
              value={formData.apartment}
              onChange={handleChange}
            />
          </label>
          <label>
            Tenant:
            <input
              type="text"
              name="tenant"
              value={formData.tenant}
              onChange={handleChange}
            />
          </label>
          <label>
            Fee:
            <input
              type="text"
              name="fee"
              value={formData.fee}
              onChange={handleChange}
            />
          </label>
          <label>
            Payment Deadline:
            <input
              type="date"
              name="paymentDeadline"
              value={formData.paymentDeadline}
              onChange={handleChange}
            />
          </label>
          <label>
            Status:
            <select
              name="status"
              value={formData.status}
              onChange={handleChange}
            >
              <option value="Unpaid">Unpaid</option>
              <option value="Paid">Paid</option>
              <option value="Late">Late</option>
            </select>
          </label>
          <label>
            Payment Method:
            <select
              name="paymentMethod"
              value={formData.paymentMethod}
              onChange={handleChange}
            >
              <option value="Bank transfer">Bank transfer</option>
              <option value="Cash">Cash</option>
            </select>
          </label>
          <div className="modal-actions">
            <button type="submit" className="add-button">
              Add
            </button>
            <button type="button" className="cancel-button" onClick={onClose}>
              Cancel
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default IncomeModal;
