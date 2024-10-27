async function fetchTechnicalMaintenances() {
    try {
        const response = await fetch('/api/technical-system/'); //API
        const data = await response.json();
        updateEquipmentTypes(data.TechnicalMaintenances);
        updateMaintenanceStatuses(data.TechnicalMaintenances);
        displayTechnicalMaintenances(data.TechnicalMaintenances);

    } catch (error) {
        console.error('Error fetching data:', error);
    }
}
function updateEquipmentTypes(maintenances) {
    const equipmentTypes = new Set(maintenances.map(m => m.equipment_type));
    const systemSelect = document.getElementById('system');
    systemSelect.innerHTML = ''; 

    const allOption = document.createElement('option');
    allOption.value = '';
    allOption.textContent = 'All';
    systemSelect.appendChild(allOption);

    equipmentTypes.forEach(type => {
        const option = document.createElement('option');
        option.value = type; 
        option.textContent = type; 
        systemSelect.appendChild(option);
    });
}

function updateMaintenanceStatuses(maintenances) {
    const maintenanceStatuses = new Set(maintenances.map(m => m.status));
    const statusSelect = document.getElementById('status');
    statusSelect.innerHTML = ''; 

    const allOption = document.createElement('option');
    allOption.value = '';
    allOption.textContent = 'All';
    statusSelect.appendChild(allOption);

    maintenanceStatuses.forEach(status => {
        const option = document.createElement('option');
        option.value = status; 
        option.textContent = status; 
        statusSelect.appendChild(option);
    });
}

function displayTechnicalMaintenances(maintenances) {
    const maintenanceTable = document.getElementById('maintenanceTable');
    maintenanceTable.innerHTML = ''; 
    maintenances.forEach(maintenance => {
        const div = document.createElement('div');
        
        div.className = 'table-data';
        div.setAttribute('equipment-name', maintenance.equipment_name);
        div.setAttribute('equipment-status', maintenance.status);
        div.setAttribute('equipment-type', maintenance.equipment_type);
        
        const detailsLink = document.createElement('a');
        detailsLink.className = 'text-data';
        detailsLink.innerText = 'Details';
        detailsLink.href = '#';
        detailsLink.onclick = function() { 
            showDescription(maintenance); 
        };

        div.innerHTML = `
            <p class="text-data">${maintenance.equipment_name}</p>
            <p class="text-data">${maintenance.location}</p>
            <p class="text-data">${maintenance.status}</p>
            <p class="text-data">${new Date(maintenance.nearest_maintenance).toLocaleString()}</p>
            <p class="text-data">${new Date(maintenance.next_maintenance).toLocaleString()}</p>
        `;
        
        div.appendChild(detailsLink);
        maintenanceTable.appendChild(div);
    });
}

function showDescription(maintenance) {
    const modal = document.getElementById('descriptionModal');
    document.getElementById('equipment_id').innerText = maintenance.equipment_id || 'N/A';
    document.getElementById('equipment_name').innerText = maintenance.equipment_name || 'N/A';
    document.getElementById('location').innerText = maintenance.location || 'N/A';
    document.getElementById('status_').innerText = maintenance.status || 'N/A';
    document.getElementById('nearest_maintenance').innerText = maintenance.nearest_maintenance || 'N/A';
    document.getElementById('next_maintenance').innerText = maintenance.next_maintenance || 'N/A';
    document.getElementById('maintenance_task').innerText = maintenance.maintenance_task || 'N/A';
    document.getElementById('description').innerText = maintenance.description || 'No description available';

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

function filterData() {
    const selectedType = document.getElementById('system').value;
    const selectedStatus = document.getElementById('status').value;
    const rows = document.querySelectorAll('.table-data');

    rows.forEach(row => {
        const matchesType = selectedType === '' || row.getAttribute('equipment-type') === selectedType;
        const matchesStatus = selectedStatus === '' || row.getAttribute('equipment-status') === selectedStatus;
        row.style.display = matchesType && matchesStatus ? '' : 'none';
    });
}

function searchByName() {
    const input = document.getElementById('searchInput').value.toLowerCase();
    const rows = document.querySelectorAll('.table-data');
    rows.forEach(row => {
        const equipmentName = row.getAttribute('equipment-name').toLowerCase();
        if (equipmentName.includes(input)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}


document.addEventListener('DOMContentLoaded', (event) => {
    fetchTechnicalMaintenances();
});
