package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class TechnicalMaintenanceResponse {
 
    String id;
  
    StaffResponse staffSend;
 
    StaffResponse staffAction;
 
    String status;
 
    String name;
 
    LocalDate nearestMaintenance;
 
    LocalDate nextMaintenance;
 
    String location;
 
    String maintenanceTask;
 
    String description;
 
    int floor;

    LocalDate dayDelete;

    int deleteStatus;
 
    EquipmentResponse equipment;
}

