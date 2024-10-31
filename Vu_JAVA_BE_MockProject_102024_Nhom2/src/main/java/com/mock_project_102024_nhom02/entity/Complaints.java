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
@Table(name = "complaints_")
public class Complaints implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @ManyToOne
    @JoinColumn(name = "id_apartment_")
    Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    User user;

    @Column(name = "complaint_date_")
    LocalDate complaintDate;

    @Column(name = "expected_completion_date_")
    LocalDate expectedCompletionDate;

    @Column(name = "content_of_complaint_")
    String contentOfComplaint;

    @Column(name = "proof_img_", columnDefinition = "TEXT")
    String proofImg;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_staff_")
    Staff staff;

    @Column(name = "note_", columnDefinition = "TEXT")
    String note;

    @Column(name = "status_")
    String status;
}
