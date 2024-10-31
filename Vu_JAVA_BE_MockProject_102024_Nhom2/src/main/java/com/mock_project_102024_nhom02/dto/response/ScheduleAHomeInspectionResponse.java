package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;
 
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ScheduleAHomeInspectionResponse {
 
    String id;
 
    ApartmentResponse apartment;
 
    String name;
 
    String phone;
 
    LocalDate date;
 
    String status;

    LocalDate dayDelete;

    int deleteStatus;
}

