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
@Table(name = "payment_method_")
public class PaymentMethod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @Column(name = "name_method_")
    String nameMethod;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;
}
