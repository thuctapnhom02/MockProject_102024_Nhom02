package com.example.demo.model.entity.custom;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplaintCustomNameUserEntity {
    String id_;
    String name_;
    String status_;
    Date complaint_date_;
    Date expected_completion_date_;
    String content_of_complaint_;
    String note_;
    String id_apartment_;
    String num_apartment_;
    String id_staff_;
    String name_staff_;
}
