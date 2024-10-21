package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "role_")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String name_role_;
}
