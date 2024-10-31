import React, { useState } from "react";

import RevenueBarChart from "../../../component/Chart/RevenueBarChart";
import ComplaintPieChart from "../../../component/Chart/ComplaintPieChart";
import CostLineChart from "../../../component/Chart/CostLineChart";
import "./style.scss";
import home from "../../../component/img/home.png";
import house from "../../../component/img/house.png";
// Dữ liệu mẫu
const revenueData = [
  { month: 1, year: 2022, ApartmentRental: 900, ServiceFee: 300, Other: 200 },
  { month: 2, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 3, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 4, year: 2022, ApartmentRental: 900, ServiceFee: 300, Other: 200 },
  { month: 5, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 6, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 7, year: 2022, ApartmentRental: 900, ServiceFee: 300, Other: 200 },
  { month: 8, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 9, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 10, year: 2022, ApartmentRental: 900, ServiceFee: 300, Other: 200 },
  { month: 11, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 12, year: 2022, ApartmentRental: 800, ServiceFee: 400, Other: 100 },
  { month: 1, year: 2023, ApartmentRental: 950, ServiceFee: 320, Other: 220 },
  { month: 2, year: 2023, ApartmentRental: 870, ServiceFee: 410, Other: 150 },
  { month: 3, year: 2023, ApartmentRental: 950, ServiceFee: 320, Other: 220 },
  { month: 4, year: 2023, ApartmentRental: 870, ServiceFee: 410, Other: 150 },
  { month: 5, year: 2023, ApartmentRental: 950, ServiceFee: 320, Other: 220 },
  { month: 6, year: 2023, ApartmentRental: 870, ServiceFee: 410, Other: 150 },
  { month: 7, year: 2023, ApartmentRental: 950, ServiceFee: 320, Other: 220 },
  { month: 8, year: 2023, ApartmentRental: 870, ServiceFee: 410, Other: 150 },
  { month: 9, year: 2023, ApartmentRental: 950, ServiceFee: 320, Other: 220 },
  { month: 10, year: 2023, ApartmentRental: 870, ServiceFee: 410, Other: 150 },
  { month: 11, year: 2023, ApartmentRental: 950, ServiceFee: 320, Other: 220 },
  { month: 12, year: 2023, ApartmentRental: 870, ServiceFee: 410, Other: 150 },
];

const complaintData = [
  { name: "Resolved", value: 400 },
  { name: "In Progress", value: 300 },
  { name: "Pending", value: 300 },
];

const costData = [
  { month: 1, year: 2022, TotalCost: 100 },
  { month: 2, year: 2022, TotalCost: 50 },
  { month: 3, year: 2022, TotalCost: 100 },
  { month: 4, year: 2022, TotalCost: 50 },
  { month: 5, year: 2022, TotalCost: 100 },
  { month: 6, year: 2022, TotalCost: 50 },
  { month: 7, year: 2022, TotalCost: 100 },
  { month: 8, year: 2022, TotalCost: 50 },
  { month: 9, year: 2022, TotalCost: 100 },
  { month: 10, year: 2022, TotalCost: 50 },
  { month: 11, year: 2022, TotalCost: 100 },
  { month: 12, year: 2022, TotalCost: 50 },
];

const AdminHome = () => {
  const [selectedYear, setSelectedYear] = useState(2023);

  const handleYearChange = (event) => {
    setSelectedYear(parseInt(event.target.value));
  };

  // Lọc dữ liệu dựa trên năm được chọn cho doanh thu
  const filteredRevenueData = revenueData.filter(
    (data) => data.year === selectedYear
  );
  return (
    <div className="dashboard_content">
      <h1 className="header">Dashboard</h1>
      <div className="row_chart">
        <div className="revenue_chart" style={{ width: "100%" }}>
          <div>
            <label>Chọn năm: </label>
            <select value={selectedYear} onChange={handleYearChange}>
              <option value={2022}>2022</option>
              <option value={2023}>2023</option>
            </select>
          </div>
          <div>
            <div style={{ display: "flex", justifyContent: "space-between" }}>
              <div style={{ width: "100%" }}>
                <h2>Aggregate revenue</h2>
                <RevenueBarChart
                  data={filteredRevenueData}
                  xtitle=""
                  ytitle=""
                />
              </div>
            </div>
          </div>
        </div>
        <div className="number_chart">
          <div className="row_chart">
            <img style={{ marginRight: "10px" }} src={home} alt="Home" />
            <h3 style={{ margin: 0 }}>1.234 apartments</h3>
          </div>
          <div className="row_chart">
            <img style={{ marginRight: "10px" }} src={house} alt="House" />
            <h3 style={{ margin: 0 }}>1.234 apartments</h3>
          </div>
        </div>
      </div>
      <div className="row_chart">
        <div className="complaint_chart">
          <div style={{ width: "100%" }}>
            <h2>Complaints</h2>
            <ComplaintPieChart data={complaintData} />
          </div>
        </div>
        <div className="costline_chart">
          <div style={{ width: "100%" }}>
            <h2>Total cost</h2>
            <CostLineChart data={costData} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminHome;
