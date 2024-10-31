package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class EquipmentRequest {
 
    String id;
 
    String name;
 
    LocalDate warranty;
 
    LocalDate datePurchase;
 
    LocalDate maintenanceDate;
 
    String type;
 
    String location; 
    
    String status;
}

