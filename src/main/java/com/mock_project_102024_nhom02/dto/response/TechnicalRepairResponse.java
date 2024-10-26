package com.mock_project_102024_nhom02.dto.response;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class TechnicalRepairResponse {
 
    String id;
 
    StaffResponse staffSend;
  
    StaffResponse staffAction;
 
    String status;
   
    String name;
 
    LocalDate nearestRepair;
 
    LocalDate nextRepair;
 
    String location;
 
    String repairTask;
 
    String description;
 
    int floor;

    LocalDate dayDelete;

    int deleteStatus;
 
    EquipmentResponse equipment;
}
