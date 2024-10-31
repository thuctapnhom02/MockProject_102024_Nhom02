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
public class MaintenanceRepairResponse{
 
    String id;
 
    UserResponse user;
 
    ApartmentResponse apartment;
 
    LocalDate expectedCompletionDate;
 
    String repairContent;
 
    String conditionOfDamage;
 
    EquipmentResponse equipment;

    LocalDate dayDelete;

    int deleteStatus;
}

