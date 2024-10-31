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
public class ComplaintsResponse  {

    String id;

    ApartmentResponse apartment;

    UserResponse user;

    LocalDate complaintDate;

    LocalDate expectedCompletionDate;

    String contentOfComplaint;

    String proofImg;

    StaffResponse staff; 

    String note;

    String status;

    LocalDate dayDelete;

    int deleteStatus;
}
