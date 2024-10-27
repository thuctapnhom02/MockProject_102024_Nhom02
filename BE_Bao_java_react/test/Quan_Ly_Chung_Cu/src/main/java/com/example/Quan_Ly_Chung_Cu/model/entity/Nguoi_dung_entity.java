package com.example.Quan_Ly_Chung_Cu.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "nguoi_dung")
public class Nguoi_dung_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String name_;
    String mat_khau_;
    int tuoi_;
    String gioi_tinh_;
    Date time_;
}
