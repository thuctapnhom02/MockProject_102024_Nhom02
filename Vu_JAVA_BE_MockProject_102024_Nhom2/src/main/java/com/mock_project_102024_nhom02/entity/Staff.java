package com.mock_project_102024_nhom02.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "staff_")
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @Column(name = "name_")
    String name;

    @Column(name = "phone_")
    String phone;

    @Column(name = "gender_")
    String gender;

    @Column(name = "start_day_")
    LocalDate startDay;

    @Column(name = "end_day_")
    LocalDate endDay;

    @Column(name = "status_")
    String status;

    @Column(name = "password_")
    String password;

    @Column(name = "address_")
    String address;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_role_")
    Role role;

}
