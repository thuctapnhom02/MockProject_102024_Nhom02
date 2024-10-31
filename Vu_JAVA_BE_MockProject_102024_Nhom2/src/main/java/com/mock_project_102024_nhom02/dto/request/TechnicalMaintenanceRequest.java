package com.mock_project_102024_nhom02.dto.request;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class TechnicalMaintenanceRequest {
 
    String id;
  
    String staffSend;
 
    String staffAction;
 
    String status;
 
    String name;
 
    LocalDate nearestMaintenance;
 
    LocalDate nextMaintenance;
 
    String location;
 
    String maintenanceTask;
 
    String description;
 
    int floor;
 
    String equipment;
}

