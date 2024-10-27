package com.example.demo.model.respone;

import com.example.demo.model.entity.ApartmentEntity;
import com.example.demo.model.entity.StaffEntity;
import com.example.demo.model.entity.custom.ComplaintCustomNameUserEntity;
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
