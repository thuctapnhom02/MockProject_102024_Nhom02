package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class RepairHistoryRequest  {
 
    String id;
 
    String equipment;
 
    LocalDate repairMaintenanceDate;
 
    BigDecimal price;
 
    String description;
 
    String staff;
}

