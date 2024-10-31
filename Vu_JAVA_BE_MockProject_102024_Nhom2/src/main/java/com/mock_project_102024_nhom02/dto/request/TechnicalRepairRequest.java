package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class TechnicalRepairRequest {
 
    String id;
 
    String staffSend;
  
    String staffAction;
 
    String status;
   
    String name;
 
    LocalDate nearestRepair;
 
    LocalDate nextRepair;
 
    String location;
 
    String repairTask;
 
    String description;
 
    int floor;
 
    String equipment;
}
