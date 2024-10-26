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
@Table(name = "equipment_")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @Column(name = "name_")
    String name;

    @Column(name = "warranty_")
    LocalDate warranty;

    @Column(name = "date_purchase_")
    LocalDate datePurchase;

    @Column(name = "maintenance_date_")
    LocalDate maintenanceDate;

    @ManyToOne
    @JoinColumn(name = "id_type_")
    TypeEquipment typeEquipment;

    @Column(name = "location_")
    String location;

    @Column(name = "status_")
    String status;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;
}

