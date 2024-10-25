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
@Table(name = "technical_repair_")
public class TechnicalRepair implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @ManyToOne
    @JoinColumn(name = "id_staff_send_")
    Staff staffSend;

    @ManyToOne
    @JoinColumn(name = "id_staff_action_")
    Staff staffAction;

    @Column(name = "status_")
    String status;

    @Column(name = "name_")
    String name;

    @Column(name = "nearest_repair_")
    LocalDate nearestRepair;

    @Column(name = "next_repair_")
    LocalDate nextRepair;

    @Column(name = "location_")
    String location;

    @Column(name = "repair_task_")
    String repairTask;

    @Column(name = "description_")
    String description;

    @Column(name = "floor_")
    int floor;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_equipment_")
    Equipment equipment;
}
