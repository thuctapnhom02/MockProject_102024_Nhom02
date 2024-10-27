fetch('api/apartments/')
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
                <input class='' type="checkbox">
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