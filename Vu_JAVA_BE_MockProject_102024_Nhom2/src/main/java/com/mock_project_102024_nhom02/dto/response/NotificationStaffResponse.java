package com.mock_project_102024_nhom02.dto.response;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
 
import java.time.LocalDate ;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class NotificationStaffResponse  {
 
    String id;
 
    UserResponse user;
 
    StaffResponse staff;
 
    String title; 

    String description;
 
    LocalDate noticeDate;
 
    String sender;

    LocalDate dayDelete;

    int deleteStatus;
}

