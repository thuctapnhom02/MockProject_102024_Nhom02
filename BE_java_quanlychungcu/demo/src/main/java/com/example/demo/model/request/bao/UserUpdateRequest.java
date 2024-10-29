package com.example.demo.model.request.bao;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String id_;
    String name_;
    String phone_;
    String email_;
    String gender_;
    String ssn_;
    String status_;
    String password_;
    Double debt_;
    Double total_payment_;
    Date start_day_;
    Date end_day_;
    String address_;
}
