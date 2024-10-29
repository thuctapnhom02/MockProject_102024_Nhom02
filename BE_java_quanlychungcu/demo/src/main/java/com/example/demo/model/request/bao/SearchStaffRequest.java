package com.example.demo.model.request.bao;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SearchStaffRequest {
    String name_;
    String status_;
}
