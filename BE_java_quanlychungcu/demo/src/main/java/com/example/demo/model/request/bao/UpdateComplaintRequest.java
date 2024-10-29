package com.example.demo.model.request.bao;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateComplaintRequest {
    String idComplaint_;
    String status_;
    String idStaff_;
}
