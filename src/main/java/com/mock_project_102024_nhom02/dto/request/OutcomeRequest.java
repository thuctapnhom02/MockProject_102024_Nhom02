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
public class OutcomeRequest   {
    String status;
 
    String nameService;
 
    String description;

    BigDecimal price;

    LocalDate dayOutcome;

    String details;
 
    String typeOutcome;
 
    String repairHistory;

    String supplier;
}

