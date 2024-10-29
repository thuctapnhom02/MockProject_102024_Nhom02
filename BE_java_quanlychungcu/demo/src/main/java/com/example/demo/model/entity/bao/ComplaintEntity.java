package com.example.demo.model.entity.bao;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "complaints_")
public class ComplaintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String id_user_;
    String id_apartment_;
    String content_of_complaint_;
    String proof_img_;
    String id_staff_;
    String note_;
    String status_;
    Integer delete_status_;
    Date day_delete_;
    Date complaint_date_;
    Date expected_completion_date_;

}
