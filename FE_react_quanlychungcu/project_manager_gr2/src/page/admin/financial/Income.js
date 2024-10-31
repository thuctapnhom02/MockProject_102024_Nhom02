import { useState } from "react";
import Filter from "../../../component/Filter/Filter";
import SearchBar from "../../../component/SearchBar/SearchBar";
import FinancialTable from "../../../component/TableCustom/FinancialTable";
import IncomeModal from "../../../component/Modal/IncomeModal";
import "./income.scss"; // Import file SCSS

const sampleData = [
  {
    id: 1,
    serviceType: "Park",
    apartment: "CH001",
    tenant: "James",
    fee: "200 USD",
    paymentDeadline: "15-05-2023",
    status: "Late",
    paymentMethod: "Bank transfer",
  },
  {
    id: 2,
    serviceType: "Park",
    apartment: "CH003",
    tenant: "Tony",
    fee: "200 USD",
    paymentDeadline: "15-05-2023",
    status: "Late",
    paymentMethod: "Bank transfer",
  },
  {
    id: 3,
    serviceType: "Gym",
    apartment: "CH001",
    tenant: "James",
    fee: "200 USD",
    paymentDeadline: "16-05-2023",
    status: "Paid",
    paymentMethod: "Bank transfer",
  },
  {
    id: 4,
    serviceType: "Pool",
    apartment: "CH002",
    tenant: "MIA",
    fee: "200 USD",
    paymentDeadline: "16-05-2023",
    status: "Paid",
    paymentMethod: "Bank transfer",
  },
  {
    id: 5,
    serviceType: "Gym",
    apartment: "CH002",
    tenant: "MIA",
    fee: "200 USD",
    paymentDeadline: "17-05-2023",
    status: "Paid",
    paymentMethod: "Cash",
  },
];

function Income() {
  const [data, setData] = useState(sampleData);
  const [selectedIds, setSelectedIds] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleSelect = (id) => {
    if (selectedIds.includes(id)) {
      setSelectedIds(selectedIds.filter((selectedId) => selectedId !== id));
    } else {
      setSelectedIds([...selectedIds, id]);
    }
  };

  const handleSelectAll = () => {
    if (selectedIds.length === data.length) {
      setSelectedIds([]);
    } else {
      setSelectedIds(data.map((item) => item.id));
    }
  };

  const handleDelete = () => {
    const newData = data.filter((item) => !selectedIds.includes(item.id));
    setData(newData);
    setSelectedIds([]);
  };

  const handleAdd = (newData) => {
    setData((prevData) => [
      ...prevData,
      { id: prevData.length + 1, ...newData },
    ]);
  };

  return (
    <div className="income-container">
      <h1 style={{ marginBottom: "10px" }}>Financial management &gt; Income</h1>
      <SearchBar onSearch />
      <div className="flex-container">
        <Filter
          label="Income"
          options={["Apartment rental", "Service fee", "Other"]}
          onFilter
          className="filter"
        />
        <Filter
          label="Time"
          options={["Month", "Year", "Quarter"]}
          onFilter
          className="filter"
        />
        <Filter
          label="Building"
          options={["Building 1", "Building 2", "Building 3"]}
          onFilter
          className="filter"
        />
      </div>

      <FinancialTable
        data={data}
        selectedIds={selectedIds}
        onSelect={handleSelect}
        onSelectAll={handleSelectAll}
      />

      <div className="flex-container">
        <button onClick={() => setIsModalOpen(true)}>Add</button>
        <button onClick={handleDelete}>Delete</button>
        <button>Export file</button>
      </div>

      <IncomeModal
        isOpen={isModalOpen}
        onClose={() => setIsModalOpen(false)}
        onAdd={IncomeModal}
      />

      <div className="summary">
        <div className="summary-grid">
          <div className="summary-item">
            Total service fee receivable:{" "}
            <span className="number">10,000 USD</span>
          </div>
          <div className="summary-item">
            Total service fee collected:{" "}
            <span className="number">10,000 USD</span>
          </div>
          <div className="summary-item">
            Unpaid: <span className="number">0</span>
          </div>
          <div className="summary-item">
            Late: <span className="number">2</span>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Income;
