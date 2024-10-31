package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class MaintenanceRepairRequest{
 
    String id;
 
    String user;
 
    ApartmentRequest apartment;
 
    LocalDate expectedCompletionDate;
 
    String repairContent;
 
    String conditionOfDamage;
 
    String equipment;
}

