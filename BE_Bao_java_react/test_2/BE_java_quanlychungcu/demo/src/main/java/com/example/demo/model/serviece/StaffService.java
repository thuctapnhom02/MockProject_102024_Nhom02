package com.example.demo.model.serviece;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.exception.ExceptionCustom;
import com.example.demo.model.entity.StaffEntity;
import com.example.demo.model.entity.custom.StaffCustomNameRoleEntity;
import com.example.demo.model.repo.RoleRepo;
import com.example.demo.model.repo.StaffRepo;
import com.example.demo.model.repo.custom.StaffCustomNameRoleRepo;
import com.example.demo.model.request.SearchStaffRequest;
import com.example.demo.model.request.UpdateComplaintRequest;
import com.example.demo.model.respone.StaffRespone;
import com.example.demo.model.respone.UpdateDeleteCreateRespone;
import jakarta.persistence.Tuple;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class StaffService {
    @Autowired
    StaffCustomNameRoleRepo staffCustomNameRoleRepo;
    @Autowired
    StaffRepo staffRepo;
    @Autowired
    RoleRepo roleRepo;

    public ApiRespone<StaffRespone> search(SearchStaffRequest searchStaffRequest){

        if(searchStaffRequest.getName_() == null){
            searchStaffRequest.setName_("%%");
        }else{
            if(searchStaffRequest.getName_().isEmpty()){
                searchStaffRequest.setName_("%%");
            }
        }
        if(searchStaffRequest.getStatus_() == null){
            searchStaffRequest.setStatus_("%%");
        }else{
            if(searchStaffRequest.getStatus_().isEmpty()){
                searchStaffRequest.setStatus_("%%");
            }
        }

        try {
            List<Tuple> t  = staffCustomNameRoleRepo.findByNameAndStatus("%"+searchStaffRequest.getName_()+"%",
                    "%"+searchStaffRequest.getStatus_()+"%");

            List<StaffCustomNameRoleEntity> staffCustomNameRoleEntities = t.stream()
                    .map(tuple -> new StaffCustomNameRoleEntity(
                            tuple.get("id_", String.class),
                            tuple.get("name_", String.class),
                            tuple.get("phone_", String.class),
                            tuple.get("gender_", String.class),
                            tuple.get("start_day_", Date.class),
                            tuple.get("end_day_", Date.class),
                            tuple.get("status_", String.class),
                            tuple.get("password_", String.class),
                            tuple.get("address_", String.class),
                            tuple.get("id_role_", String.class),
                            tuple.get("name_role_", String.class)
                    ))
                    .collect(Collectors.toList());

            return ApiRespone.<StaffRespone>builder()
                .api_result_(StaffRespone.builder()
                        .staffCustomNameRole(staffCustomNameRoleEntities)
                        .role(roleRepo.findAll())
                        .build())
                .api_desription_("search staff request")
                .api_respone_("200")
                .build();
        } catch (RuntimeException e) {
            throw new RuntimeException(new ExceptionCustom("Not Create get value staff","400"));
        }



    }

    public ApiRespone<UpdateDeleteCreateRespone> updateStaff(StaffEntity staffEntityRequest_){
        try {
            staffEntityRequest_.setDelete_status_(1);
            staffRepo.save(staffEntityRequest_);
            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("update staff request")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_("create submit")
                            .check_(true)
                            .build())
                    .build();
        } catch (RuntimeException e) {
            throw new RuntimeException(new ExceptionCustom("Not update staff","400"));
        }
    }


    public ApiRespone<UpdateDeleteCreateRespone> createStaff(StaffEntity staffEntityRequest_){
        try {
            staffEntityRequest_.setDelete_status_(1);
            System.out.println(staffEntityRequest_);
            staffRepo.save(staffEntityRequest_);
            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("create staff request")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(true)
                            .desription_("Create staff submit")
                            .build())
                    .build();
        } catch (RuntimeException e) {
            throw new RuntimeException(new ExceptionCustom("Not create staff","400"));
        }

    }


    public ApiRespone<UpdateDeleteCreateRespone> deleteStaff(String idStaff_){
        try {
            System.out.println(idStaff_);

            StaffEntity staffEntity = staffRepo.findById(idStaff_).get();
            staffEntity.setDelete_status_(0);
            staffEntity.setDay_delete_(new Date());
            staffRepo.save(staffEntity);

            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("delete staff request")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(true)
                            .desription_("Delete staff submit")
                            .build())
                    .build();
        } catch (RuntimeException e) {
            throw new RuntimeException(new ExceptionCustom("Not delete staff","400"));
        }


    }
}
