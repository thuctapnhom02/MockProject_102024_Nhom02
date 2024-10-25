package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContractServiceRequest {

    String idContract;

    LocalDate startContract;

    LocalDate endContract;

    String scopeOfTheContract;

    String qualityStandards;

    String status;

    String user;

    String staff;

    String suppliers;
}

