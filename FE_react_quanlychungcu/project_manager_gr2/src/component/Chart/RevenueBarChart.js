import React from "react";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
} from "recharts";

const RevenueBarChart = ({ data }) => {
  return (
    <BarChart
      width={800}
      height={300}
      data={data}
      margin={{
        top: 5,
        right: 30,
        left: 20,
        bottom: 5,
      }}
    >
      <CartesianGrid strokeDasharray="3 3" />
      <XAxis dataKey="month" />
      <YAxis />
      <Tooltip />
      <Legend />
      <Bar dataKey="ApartmentRental" fill="#8884d8" />
      <Bar dataKey="ServiceFee" fill="#82ca9d" />
      <Bar dataKey="Other" fill="#ffc658" />
    </BarChart>
  );
};

export default RevenueBarChart;
