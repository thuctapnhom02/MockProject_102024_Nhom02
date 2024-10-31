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
@Table(name = "maintenance_repair_")
public class MaintenanceRepair implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_apartment_")
    Apartment apartment;

    @Column(name = "expected_completion_date_")
    LocalDate expectedCompletionDate;

    @Column(name = "repair_content_")
    String repairContent;

    @Column(name = "condition_of_damage_")
    String conditionOfDamage;

    @ManyToOne
    @JoinColumn(name = "id_equipment_")
    Equipment equipment;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;
}

