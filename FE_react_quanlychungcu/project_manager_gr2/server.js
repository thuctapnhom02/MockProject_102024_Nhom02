const express = require("express");
const cors = require("cors");
const app = express();
const PORT = 5000;

app.use(cors());

// Generate 40 items of sample data
const generateIncome = () => {
  const incomes = [];

  for (let i = 1; i <= 40; i++) {
    incomes.push({
      id: `INC${String(i).padStart(4, "0")}`,
      status: i % 2 === 0 ? "Completed" : "Pending", // Trạng thái ngẫu nhiên
      total: (Math.random() * 1000).toFixed(2), // Tổng tiền ngẫu nhiên từ 0 đến 1000
      paymentDeadline: new Date(
        Date.now() + Math.floor(Math.random() * 10) * 24 * 60 * 60 * 1000
      )
        .toISOString()
        .split("T")[0], // Hạn thanh toán ngẫu nhiên trong 10 ngày tới
      user: {
        id: `USR${String(i).padStart(4, "0")}`,
        name: `User ${i}`, // Tên người dùng
        email: `user${i}@email.com`, // Email người dùng
        phone: `098176${String(Math.floor(Math.random() * 10000)).padStart(
          4,
          "0"
        )}`, // Số điện thoại ngẫu nhiên
        gender: i % 2 === 0 ? "Female" : "Male", // Giới tính ngẫu nhiên
        ssn: `${Math.floor(Math.random() * 900000000) + 100000000}`, // Giả lập SSN
      },
      apartment: {
        id: `APM_${String(i).padStart(3, "0")}`,
        flor: Math.floor(Math.random() * 10) + 1, // Tầng ngẫu nhiên từ 1 đến 10
        numApartment: `L${Math.floor(Math.random() * 10) + 1}_${String(
          Math.floor(Math.random() * 100)
        ).padStart(3, "0")}`, // Số căn hộ ngẫu nhiên
        numBedroom: Math.floor(Math.random() * 5) + 1, // Số phòng ngủ ngẫu nhiên từ 1 đến 5
        square: (Math.random() * 100).toFixed(2), // Diện tích ngẫu nhiên từ 0 đến 100
        rentPrice: (Math.random() * 1500).toFixed(2), // Giá thuê ngẫu nhiên từ 0 đến 1500
      },
      service: {
        id: `Q${String(Math.random()).substring(2, 12)}`, // ID dịch vụ ngẫu nhiên
        name: `Service ${i}`, // Tên dịch vụ
        price: (Math.random() * 500).toFixed(2), // Giá dịch vụ ngẫu nhiên
      },
      paymentMethod: {
        id: `PM${String(Math.random()).substring(2, 12)}`, // ID phương thức thanh toán ngẫu nhiên
        nameMethod: i % 2 === 0 ? "Credit Card" : "Cash", // Phương thức thanh toán ngẫu nhiên
      },
      typeIncome: {
        id: `TIC${String(Math.random()).substring(2, 12)}`, // ID loại thu nhập ngẫu nhiên
        nameType: i % 2 === 0 ? "Service income" : "Rent a house income", // Loại thu nhập ngẫu nhiên
      },
    });
  }
  return incomes;
};
const generateStaff = () => {
  const roles = [
    "Admin",
    "Staff Repair",
    "Staff Maintenance",
    "Staff Complant",
    "Staff Request",
    "Staff Income",
    "Staff Outcome",
  ];

  const data = [];
  for (let i = 1; i <= 40; i++) {
    data.push({
      id: `ST${String(i).padStart(8, "0")}`,
      name: `User ${i}`,
      phone: `09810000${String(i).padStart(2, "0")}`,
      gender: i % 2 === 0 ? "Male" : "Female",
      startDay: "2024-01-01",
      endDay: null,
      status: "Active",
      password: `password${i}`,
      address: `Address ${i}`,
      dayDelete: null,
      deleteStatus: 0,
      role: {
        id: `role${i}`,
        nameRole: roles[i % roles.length],
        dayDelete: null,
        deleteStatus: 1,
      },
    });
  }
  return data;
};

const usersData = generateStaff();
const incomesData = generateIncome();
app.get("/api/v1/incomes", (req, res) => {
  const { searchValue, serviceId, page = 1, pageSize = 9 } = req.query;

  // Chuyển đổi page và pageSize thành số
  const currentPage = parseInt(page, 10); // Sửa lại biến từ page
  const size = parseInt(pageSize, 10);

  // Kiểm tra kiểu dữ liệu
  if (isNaN(currentPage) || currentPage < 1 || isNaN(size) || size < 1) {
    return res
      .status(400)
      .json({ code: 400, message: "Invalid pagination parameters." });
  }

  // Lọc dữ liệu theo điều kiện
  const filteredIncomes = incomesData.filter((income) => {
    const matchesSearchValue = searchValue
      ? income.user.name.toLowerCase().includes(searchValue.toLowerCase()) ||
        income.apartment.numApartment
          .toLowerCase()
          .includes(searchValue.toLowerCase())
      : true;

    const matchesServiceId = serviceId ? income.service.id === serviceId : true;

    return matchesSearchValue && matchesServiceId;
  });

  // Tính toán phân trang
  const totalItem = filteredIncomes.length;
  const totalPage = Math.ceil(totalItem / size);
  const startIndex = (currentPage - 1) * size; // Tính chỉ số bắt đầu
  const endIndex = startIndex + size; // Tính chỉ số kết thúc
  const result = filteredIncomes.slice(startIndex, endIndex); // Cắt mảng để lấy dữ liệu cho trang hiện tại

  res.json({
    code: 200,
    currentPage: currentPage,
    pageSize: size,
    totalItem,
    totalPage,
    result,
  });
});
app.get("/api/v1/staff", (req, res) => {
  const page = parseInt(req.query.page) || 1;
  const pageSize = parseInt(req.query.pageSize) || 9;
  const search = req.query.search || ""; // Lấy tham số tìm kiếm
  const statusFilter = req.query.status || ""; // Lấy tham số trạng thái
  const totalItem = usersData.length;

  // Lọc dữ liệu dựa trên tham số tìm kiếm và trạng thái
  const filteredData = usersData.filter((user) => {
    const matchesSearch =
      user.phone.includes(search) ||
      user.name.toLowerCase().includes(search.toLowerCase());
    const matchesStatus = statusFilter ? user.status === statusFilter : true; // Kiểm tra trạng thái

    return matchesSearch && matchesStatus; // Phải thỏa mãn cả hai điều kiện
  });

  const totalFilteredItem = filteredData.length;
  const totalPage = Math.ceil(totalFilteredItem / pageSize);

  // Tính toán chỉ số bắt đầu và kết thúc cho trang yêu cầu
  const startIndex = (page - 1) * pageSize;
  const endIndex = startIndex + pageSize;
  const result = filteredData.slice(startIndex, endIndex);

  res.json({
    code: 200,
    currentPage: page,
    pageSize: pageSize,
    totalItem: totalFilteredItem,
    totalPage: totalPage,
    result: result,
  });
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
