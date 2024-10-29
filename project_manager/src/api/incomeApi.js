const BASE_URL = "http://localhost:5000/api/v1";

export const fetchIncomes = async (
  search = "",
  building = "",
  time = "",

  page = 1,
  pageSize = 9
) => {
  const params = new URLSearchParams({
    page,
    pageSize,
    ...(search && { search }), // Nếu có tìm kiếm, thêm vào params
    ...(accountType && { accountType }), // Nếu có loại tài khoản, thêm vào params
    ...(status && { status }), // Nếu có trạng thái, thêm vào params
  });

  const response = await fetch(`${BASE_URL}/staff?${params.toString()}`);

  if (!response.ok) {
    throw new Error("Network response was not ok");
  }

  const data = await response.json();
  return data; // Trả về danh sách người dùng
};
