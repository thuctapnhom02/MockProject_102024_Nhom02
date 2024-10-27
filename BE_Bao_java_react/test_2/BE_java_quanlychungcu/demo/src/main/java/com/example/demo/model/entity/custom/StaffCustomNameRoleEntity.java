package com.example.demo.model.entity.custom;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffCustomNameRoleEntity {
    String id_;
    String name_;
    String phone_;
    String gender_;
    Date start_day_;
    Date end_day_;
    String status_;
    String password_;
    String address_;
    String id_role_;
    String name_role_;
}
