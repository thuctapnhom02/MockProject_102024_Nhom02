



function showAddForm() {
    var formContainer = document.getElementById("formContainer");
    formContainer.innerHTML = `
        <div class="main-header">
            <p> Apartment Management In The United States </p>
        </div>
        <div class="head-infor">
            <a href="#" class="previous round">&#8249;</a>
            ADD SYSTEM NEED MAINTENANCE
        </div>
        <div class="main-element">
            <div class="element">
                <label>Choose the equipment/system</label>
                <select class="form-select" id="system_" onchange="populateTechSysForm()">
                    
                </select>
            </div>
            <div class="element">
                <label>System ID</label>
                <select class="form-select" id="name_">
                    
                </select>
            </div>
            <div class="element">
                <label>Location</label>
                <select class="form-select" id="location_">
                </select>
            </div>
            <div class="element">
                <label>Status</label>
                <select class="form-select" id="status__">
                </select>
            </div>
            <div class="element">
                <label>Maintenance Task</label>
                <input type="text" class="form-control" id="description_">
                </select>
            </div>
            <div class="element">
                <label>Description</label>
                <input type="text" class="form-control" id="description_">
            </div>
        </div>
        <div class="main-element">
    
            <div class="element-head">
                Assign maintenance staff
            </div>
            <div class="element">
                <label>Expertise</label>
                <select class="form-select" id="role_">
                    <option value="">Staff Repair</option>
                </select>
            </div>
            <div class="element">
                <label>ID Staff</label>
                <select class="form-select" id="id_staff_">
                    <option value="ST0000001">ST0000001</option>
                </select>
            </div>

            <div class="add_but">
                <input class="font-size-20" type="button" value="Assign tasks" onclick="assignTasks()">
            </div>
        </div>
    `;

    formContainer.style.display = "block";

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://127.0.0.1:8000/api/technical-system/', true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            let data;
            try {
                data = JSON.parse(xhr.responseText);
                console.log("Data received:", data); // Kiểm tra dữ liệu nhận từ API
                if (Array.isArray(data.TechnicalMaintenances)) {  // Kiểm tra mảng con
                    populateEquipmentDropdown(data.TechnicalMaintenances);  // Truyền mảng thiết bị vào hàm này
                    populateLocationDropdown();
                    populateStatusDropdown();
                } else {
                    console.error("Expected an array, but received:", data.TechnicalMaintenances);
                }
            } catch (error) {
                console.error("Error parsing JSON response:", error);
            }
        } else {
            console.error("Failed to fetch data, status:", xhr.status);
        }
    };
    xhr.onerror = function() {
        console.error("Request failed");
    };
    xhr.send();
}

function populateEquipmentDropdown(data) {
    const systemDropdown = document.getElementById("system_");
    const idDropdown = document.getElementById("name_");

    data.forEach(item => {
        // Thêm tên thiết bị vào dropdown 'Choose the equipment/system'
        const equipmentOption = document.createElement("option");
        equipmentOption.value = item.equipment;
        equipmentOption.textContent = item.equipment_name;
        systemDropdown.appendChild(equipmentOption);

        // Thêm System ID vào dropdown 'System ID'
        const idOption = document.createElement("option");
        idOption.value = item.id;
        idOption.textContent = item.equipment_id;
        idDropdown.appendChild(idOption);
    });
}

function populateLocationDropdown() {
    const locationDropdown = document.getElementById("location_");
    for (let i = 0; i <= 9; i++) {
        const locationOption = document.createElement("option");
        locationOption.value = i;
        locationOption.textContent = "Floor " + i;
        locationDropdown.appendChild(locationOption);
    }
}

function populateStatusDropdown() {
    const statusDropdown = document.getElementById("status__");
    const statuses = ["Active", "Inactive", "Completed"];
    statuses.forEach(status => {
        const statusOption = document.createElement("option");
        statusOption.value = status;
        statusOption.textContent = status;
        statusDropdown.appendChild(statusOption);
    });
}


