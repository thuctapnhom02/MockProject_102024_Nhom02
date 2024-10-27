package com.example.demo.model.respone;


import com.example.demo.model.entity.RoleEntity;
import com.example.demo.model.entity.custom.StaffCustomNameRoleEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class StaffRespone {
    List<StaffCustomNameRoleEntity> staffCustomNameRole;
    List<RoleEntity> role;
}
