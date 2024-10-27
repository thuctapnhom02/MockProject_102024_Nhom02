package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "staff_")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String id_role_;
    String name_;
    String phone_;
    String gender_;
    Date start_day_;
    Date end_day_;
    String status_;
    String password_;
    String address_;
    Date day_delete_;
    Integer delete_status_;
}
