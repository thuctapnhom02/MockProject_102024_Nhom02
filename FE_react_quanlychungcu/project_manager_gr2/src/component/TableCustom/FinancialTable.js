import React from "react";

import "./style.scss";

const FinancialTable = ({ data, selectedIds, onSelect, onSelectAll }) => {
  return (
    <table border="1">
      <thead>
        <tr>
          <th>
            {/* Checkbox Chọn tất cả */}
            <input
              type="checkbox"
              checked={selectedIds.length === data.length && data.length > 0}
              onChange={onSelectAll}
            />
          </th>
          <th>Service type</th>
          <th>Apartment</th>
          <th>Tenant</th>
          <th>Fee</th>
          <th>Payment deadline</th>
          <th>Status</th>
          <th>Payment method</th>
          <th>Note</th>
        </tr>
      </thead>
      <tbody>
        {data.map((item) => (
          <tr key={item.id}>
            <td>
              {/* Checkbox cho từng hàng */}
              <input
                type="checkbox"
                checked={selectedIds.includes(item.id)}
                onChange={() => onSelect(item.id)}
              />
            </td>
            <td>{item.serviceType}</td>
            <td>{item.apartment}</td>
            <td>{item.tenant}</td>
            <td>{item.fee}</td>
            <td>{item.paymentDeadline}</td>
            <td>{item.status}</td>
            <td>{item.paymentMethod}</td>
            <td></td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default FinancialTable;
