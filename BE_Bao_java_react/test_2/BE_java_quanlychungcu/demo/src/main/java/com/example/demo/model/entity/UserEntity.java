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
@Table(name = "user_")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String name_;
    String phone_;
    String email_;
    String gender_;
    String ssn_;
    String status_;
    String password_;
    Float debt_;
    Double total_payment_;
    Date start_day_;
    Date end_day_;
    String address_;
    Date day_delete_;
    Integer delete_status_;
}
