package com.mock_project_102024_nhom02.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate ;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "rental_request_")
public class RentalRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @ManyToOne
    @JoinColumn(name = "id_apartment_")
    Apartment apartment;

    @Column(name = "tenant_name_")
    String tenantName;

    @Column(name = "date_of_birth_")
    LocalDate dateOfBirth;

    @Column(name = "address_")
    String address;

    @Column(name = "phone_")
    String phone;

    @Column(name = "email_")
    String email;

    @Column(name = "job_")
    String job;

    @Column(name = "status_")
    String status;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;
}

