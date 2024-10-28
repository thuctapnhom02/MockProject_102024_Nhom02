package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ComplaintsRequest  {

    String id;

    String apartment;

    String user;

    LocalDate complaintDate;

    LocalDate expectedCompletionDate;

    String contentOfComplaint;

    String proofImg;

    String staff;

    String note;

    String status;
}
