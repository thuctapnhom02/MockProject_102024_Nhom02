document.addEventListener("DOMContentLoaded", function () {
    fetch('/api/maintenance-repair/')
        .then(response => response.json())
        .then(data => {
            const repairList = document.getElementById('repair-list');

            // Xóa các mục hiện có
            repairList.innerHTML = '';

            // Lưu trữ dữ liệu đã lấy để sử dụng sau
            const repairs = data;

            // Hàm để hiển thị các sửa chữa
            function renderRepairs(filteredRepairs) {
                repairList.innerHTML = ''; // Xóa nội dung trước đó
                filteredRepairs.forEach(repair => {
                    const repairDiv = document.createElement('div');
                    repairDiv.classList.add('table-data');

                    repairDiv.innerHTML = `
                        <input class='' type="checkbox">
                        <p class="text-data">${repair.id}</p>
                        <p class="text-data">${repair.id_apartment}</p>
                        <p class="text-data">${repair.expected_completion_date}</p>
                        <p class="text-data">${repair.id_equipment}</p>
                        <p class="text-data">${repair.repair_content}</p>
                        <a href="#" class="text-data detail-link" data-repair='${JSON.stringify(repair)}'>Detail</a>
                    `;

                    repairList.appendChild(repairDiv);
                });

                // Gán sự kiện cho các liên kết "Detail"
                const detailLinks = document.querySelectorAll('.detail-link');
                detailLinks.forEach(link => {
                    link.addEventListener('click', function(event) {
                        event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ a
                        const maintenance = JSON.parse(this.getAttribute('data-repair'));
                        showRepair(maintenance);
                    });
                });
            }

            // Hiển thị tất cả sửa chữa ban đầu
            renderRepairs(repairs);

            // Hàm tìm kiếm
            function filterBySearch_Repair() {
                const searchValue = document.querySelector('.repair_search').value.toLowerCase();
                const filteredRepairs = repairs.filter(repair =>
                    repair.repair_content.toLowerCase().includes(searchValue) || 
                    repair.id.toString().includes(searchValue) // Ví dụ: tìm theo ID
                );
                renderRepairs(filteredRepairs);
            }

            // Hàm lọc theo trạng thái
            function filterByStatus_Repair() {
                const selectedStatus = document.getElementById('status').value;
                const filteredRepairs = repairs.filter(repair => 
                    !selectedStatus || repair.status === selectedStatus // Điều chỉnh theo cấu trúc dữ liệu của bạn
                );
                renderRepairs(filteredRepairs);
            }

            // Gán sự kiện cho ô tìm kiếm và dropdown
            document.querySelector('.repair_search').addEventListener('input', filterBySearch_Repair);
            document.getElementById('status').addEventListener('change', filterByStatus_Repair);
        })
        .catch(error => console.error('Lỗi khi lấy dữ liệu sửa chữa:', error));

    function showRepair(maintenance) {
        const modal = document.getElementById('repairModel'); // Kiểm tra ID ở đây
        document.getElementById('request_id').innerText = maintenance.id || 'N/A';
        document.getElementById('id_user_').innerText = maintenance.id_user || 'N/A';
        document.getElementById('expected_completion_date').innerText = maintenance.expected_completion_date || 'N/A';
        document.getElementById('expected_completion_date_').innerText = maintenance.expected_completion_date || 'N/A'; // Lưu ý: ID này trùng lặp
        document.getElementById('id_equipment__').innerText = maintenance.id_equipment || 'N/A';
        document.getElementById('apartment_id_').innerText = maintenance.id_apartment || 'N/A';
        document.getElementById('repair_content').innerText = maintenance.repair_content || 'N/A';
        document.getElementById('condition_of_damage').innerText = maintenance.condition_of_damage || 'No description available';

        // Hiển thị modal
        modal.style.display = 'block';

        // Nút đóng
        const closeButton = document.querySelector('.close-button');
        closeButton.onclick = function() {
            modal.style.display = 'none';
        };

        window.onclick = function(event) {
            if (event.target === modal) {
                modal.style.display = 'none';
            }
        };
    }
});