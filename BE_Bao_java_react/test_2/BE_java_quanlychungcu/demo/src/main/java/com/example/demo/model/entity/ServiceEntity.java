package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "service_")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String name_;
    Double price_;
    String regulation_;
    String deription_;
    Date day_delete_;
    Integer delete_status_;
}
