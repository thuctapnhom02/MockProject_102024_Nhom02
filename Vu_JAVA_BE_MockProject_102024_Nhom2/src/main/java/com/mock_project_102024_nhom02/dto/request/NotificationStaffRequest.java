package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class NotificationStaffRequest  {
 
    String id;
 
    String user;
 
    String staff;
 
    String title; 

    String description;
 
    LocalDate noticeDate;
 
    String sender;
}

