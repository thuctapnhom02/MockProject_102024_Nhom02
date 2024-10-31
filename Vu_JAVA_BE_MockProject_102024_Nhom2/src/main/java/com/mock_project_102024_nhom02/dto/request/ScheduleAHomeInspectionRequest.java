package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ScheduleAHomeInspectionRequest {
 
    String id;
 
    String apartment;
 
    String name;
 
    String phone;
 
    LocalDate date;
 
    String status;
}

