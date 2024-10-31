document.addEventListener("DOMContentLoaded", function () {
    fetch("http://127.0.0.1:8000/api/information-building/")
        .then(response => response.json())
        .then(data => {
            document.getElementById("area").textContent = `Area: ${data.area}`;
            document.getElementById("build-year").textContent = `Build year: ${data.build_year}`;
            document.getElementById("num-apartments").textContent = `Number of apartments: ${data.num_apartments}`;
        })
        .catch(error => console.error("Error fetching data:", error));
});
fetch('/api/apartments/')
    .then(response => response.json())
    .then(data => {
        const apartmentList = document.getElementById('apartment-list');

        // Xóa các phần tử hiện có nếu có
        apartmentList.innerHTML = '';

        // Duyệt qua từng apartment trong dữ liệu trả về
        data.forEach(apartment => {
            const apartmentDiv = document.createElement('div');
            apartmentDiv.classList.add('table-data');

            // Tạo phần tử cho từng thông tin apartment
            apartmentDiv.innerHTML = `
                <p class="text-data">${apartment.id}</p>
                <p class="text-data">${apartment.num_apartment}</p>
                <p class="text-data">${apartment.square}</p>
                <p class="text-data">${apartment.status}</p>
                <a href="#" class="text-data">Detail</a>
            `;

            // Thêm apartmentDiv vào apartmentList
            apartmentList.appendChild(apartmentDiv);
        });
    })
    .catch(error => console.error('Error fetching apartments:', error));