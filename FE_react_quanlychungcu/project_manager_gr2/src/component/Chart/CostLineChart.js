import React from "react";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

const CostLineChart = ({ data }) => {
  return (
    <ResponsiveContainer width="100%" height={300}>
      <LineChart data={data}>
        <XAxis
          dataKey="month"
          label={{
            value: "Months",
            position: "insideBottomRight",
            offset: -10,
          }}
        />
        <YAxis
          label={{
            value: "Million USD",
            position: "insideTopRight",
            dy: -30,
            dx: 20,
          }}
        />
        <Tooltip />
        <Line
          type="monotone"
          dataKey="TotalCost"
          stroke="#8884d8"
          activeDot={{ r: 8 }}
        />
      </LineChart>
    </ResponsiveContainer>
  );
};

export default CostLineChart;
