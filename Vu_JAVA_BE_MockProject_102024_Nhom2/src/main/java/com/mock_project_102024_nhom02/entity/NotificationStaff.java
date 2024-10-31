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
@Table(name = "notification_staff_")
public class NotificationStaff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_staff_")
    Staff staff;

    @Column(name = "title_")
    String title;

    @Column(name = "deription_")
    String description;

    @Column(name = "notice_date_")
    LocalDate noticeDate;

    @Column(name = "sender_")
    String sender;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;
}

