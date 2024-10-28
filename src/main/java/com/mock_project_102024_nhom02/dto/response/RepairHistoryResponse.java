package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;
 
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class RepairHistoryResponse  {
 
    String id;
 
    EquipmentResponse equipment;
 
    LocalDate repairMaintenanceDate;
 
    BigDecimal price;
 
    String description;

    LocalDate dayDelete;

    int deleteStatus;
 
    StaffResponse staff;
}

