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
public class EquipmentResponse {
 
    String id;
 
    String name;
 
    LocalDate warranty;
 
    LocalDate datePurchase;
 
    LocalDate maintenanceDate;
 
    TypeEquipmentResponse type;
 
    String location; 
    
    String status;

    LocalDate dayDelete;

    int deleteStatus;
}

