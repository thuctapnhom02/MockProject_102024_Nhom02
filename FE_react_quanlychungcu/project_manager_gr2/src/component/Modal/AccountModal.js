import React, { useState, useEffect } from "react";
import "./style.scss";
import Filter from "../Filter/Filter";

const options = [
  "Admin",
  "Staff Repair",
  "Staff Maintenance",
  "Staff Complant",
  "Staff Request",
  "Staff Income",
  "Staff Outcome",
];

const AccountModal = ({ account, onClose, onSave }) => {
  const [updatedAccount, setUpdatedAccount] = useState({
    name: "",
    roleName: "",
    phone: "",
    status: "Active",
    password: "",
  });

  useEffect(() => {
    if (account) {
      setUpdatedAccount({
        name: account.name || "",
        roleName: account.role.nameRole || "", // Cập nhật từ account
        phone: account.phone || "",
        status: account.status || "Active", // Đặt mặc định là "Active" nếu không có
        password: account.password || "",
      });
    }
  }, [account]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUpdatedAccount({ ...updatedAccount, [name]: value });
  };

  const handleSave = () => {
    onSave(updatedAccount);
  };

  const handleFilter = (selectedOption) => {
    // Cập nhật roleName trong updatedAccount khi chọn một tùy chọn
    setUpdatedAccount({ ...updatedAccount, roleName: selectedOption });
  };

  return (
    <div className="modal">
      <div className="modal-content">
        <h2>{account ? "Edit Account" : "Add Account"}</h2>
        <label>
          Name:
          <input
            name="name" // Sửa thành "name" để liên kết đúng
            value={updatedAccount.name}
            onChange={handleChange}
          />
        </label>
        <label>
          Account Type:
          <Filter
            style={{ width: "100%" }}
            options={options}
            selectedValue={updatedAccount.roleName || options[0]} // Giá trị mặc định
            onFilter={handleFilter}
          />
        </label>
        <label>
          Phone:
          <input
            name="phone" // Đảm bảo tên trường là "phone"
            value={updatedAccount.phone}
            onChange={handleChange}
          />
        </label>
        <label>
          Password:
          <input
            name="password" // Đảm bảo tên trường là "password"
            value={updatedAccount.password}
            onChange={handleChange}
          />
        </label>
        <label>
          Status:
          <Filter
            style={{ width: "100%" }}
            options={["Active", "Inactive"]} // Cung cấp thêm tùy chọn nếu cần
            selectedValue={updatedAccount.status}
            onFilter={(status) =>
              setUpdatedAccount({ ...updatedAccount, status })
            }
          />
        </label>
        <button onClick={handleSave}>Save</button>
        <button onClick={onClose}>Cancel</button>
      </div>
    </div>
  );
};

export default AccountModal;
