import React from "react";
import Button from "../Button";

const AccountTable = ({
  accounts,
  onEdit,
  selectedAccounts,
  onSelectAccount,
  onSelectAll,
}) => {
  const isAllSelected =
    accounts.length > 0 &&
    accounts.every((acc) => selectedAccounts.includes(acc.id));

  return (
    <table className="account-table">
      <thead>
        <tr>
          <th>
            <input
              type="checkbox"
              checked={isAllSelected}
              onChange={onSelectAll}
            />
          </th>
          <th>ID</th>
          <th>Name</th>
          <th>Account Type</th>
          <th>Phone</th>
          <th>Password</th>
          <th>Status</th>
          <th>Details</th>
        </tr>
      </thead>
      <tbody>
        {accounts.map((account) => (
          <tr key={account.id}>
            <td>
              <input
                type="checkbox"
                checked={selectedAccounts.includes(account.id)}
                onChange={() => onSelectAccount(account.id)} // Checkbox chọn từng tài khoản
              />
            </td>
            <td>{account.id}</td>
            <td>{account.name}</td>
            <td>{account.role.nameRole}</td>
            <td>{account.phone}</td>
            <td>{account.password}</td>
            <td>{account.status}</td>
            <td>
              <Button outline small onClick={() => onEdit(account)}>
                Edit
              </Button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default AccountTable;
