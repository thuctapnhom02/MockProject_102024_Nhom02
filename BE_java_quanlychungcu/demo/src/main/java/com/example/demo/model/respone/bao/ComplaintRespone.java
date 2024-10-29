package com.example.demo.model.respone.bao;

import com.example.demo.model.entity.bao.StaffEntity;
import com.example.demo.model.entity.bao.custom.ComplaintCustomNameUserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplaintRespone {
    List<ComplaintCustomNameUserEntity> complaintCustomNameUserEntities_;
    List<StaffEntity> staffEntities;
}
