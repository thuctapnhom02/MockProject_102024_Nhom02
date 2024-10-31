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
public class OutcomeResponse   {
 
    String id;
 
    String status;

    String nameService;
 
    String description;
 
    BigDecimal price;

    LocalDate dayOutcome;

    String details;

    LocalDate dayDelete;

    int deleteStatus;
 
    TypeOutcomeResponse typeOutcome;
 
    RepairHistoryResponse repairHistory;

    SuppliersResponse suppliers;
}

