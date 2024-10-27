package com.example.demo.model.serviece;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.entity.custom.ComplaintCustomNameUserEntity;
import com.example.demo.model.repo.ComplaintRepo;
import com.example.demo.model.repo.StaffRepo;
import com.example.demo.model.repo.custom.ComplaintCustomNameUserRepo;
import com.example.demo.model.request.ComplaintSearchRequest;
import com.example.demo.model.request.UpdateComplaintRequest;
import com.example.demo.model.respone.ComplaintRespone;
import com.example.demo.model.respone.UpdateDeleteCreateRespone;
import jakarta.persistence.Tuple;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplaintService {


    @Autowired
    ComplaintCustomNameUserRepo complaintCustomNameUserRepo;
    @Autowired
    ComplaintRepo complaintRepo;
    @Autowired
    StaffRepo staffRepo;

    public ApiRespone<ComplaintRespone> getAllComplaint(ComplaintSearchRequest complaintSearchRequest){
        List<Tuple> tupleComplaint = new ArrayList<>();

        if(complaintSearchRequest.getNameUser_()==null||complaintSearchRequest.getNameUser_().isEmpty()){
                complaintSearchRequest.setNameUser_("");
        }if(complaintSearchRequest.getStatus_()==null||complaintSearchRequest.getStatus_().isEmpty()){
                complaintSearchRequest.setStatus_("");
        }

        tupleComplaint = complaintCustomNameUserRepo.findByNameUserAndStatus("%"+complaintSearchRequest.getNameUser_()+"%","%"+complaintSearchRequest.getStatus_()+"%");
        List<ComplaintCustomNameUserEntity> complaintCustomNameUserEntities = tupleComplaint.stream().map(t -> new ComplaintCustomNameUserEntity(
                t.get("id_",String.class),
                t.get("name_",String.class),
                t.get("status_",String.class),
                t.get("complaint_date_", Date.class),
                t.get("expected_completion_date_",Date.class),
                t.get("content_of_complaint_",String.class),
                t.get("note_",String.class),
                t.get("id_apartment_",String.class),
                t.get("num_apartment_",String.class),
                t.get("id_staff_",String.class)
        )).collect(Collectors.toList());
        ComplaintRespone complaintRespone =ComplaintRespone.builder()
                .complaintCustomNameUserEntities_(complaintCustomNameUserEntities)
                .build();

        return ApiRespone.<ComplaintRespone>builder()
                .api_respone_("200")
                .api_desription_("search complaint request")
                .api_result_(complaintRespone)
                .build();
    }


    public ApiRespone<UpdateDeleteCreateRespone> updateComplaint(UpdateComplaintRequest updateComplaintRequest){
            System.out.println(updateComplaintRequest);
        try {

            complaintRepo.updateCompalaint(updateComplaintRequest.getStatus_(),
                    updateComplaintRequest.getIdComplaint_(),
                    updateComplaintRequest.getIdStaff_());

            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("update complaint request")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(true)
                            .desription_("update submit")
                            .build())
                    .build();
        } catch (Exception e) {

            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("update complaint request err")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(false)
                            .desription_(e.toString())
                            .build())
                    .build();
        }
    }


    public ApiRespone<ComplaintRespone> getDtailComplaint(String idComplaint_){
        List<Tuple> tupleComplaint =  complaintCustomNameUserRepo.findByIDComplaint(idComplaint_);
        List<ComplaintCustomNameUserEntity> complaintCustomNameUserEntities = tupleComplaint.stream().map(t -> new ComplaintCustomNameUserEntity(
                t.get("id_",String.class),
                t.get("name_",String.class),
                t.get("status_",String.class),
                t.get("complaint_date_", Date.class),
                t.get("expected_completion_date_",Date.class),
                t.get("content_of_complaint_",String.class),
                t.get("note_",String.class),
                t.get("id_apartment_",String.class),
                t.get("num_apartment_",String.class),
                t.get("id_staff_",String.class)
        )).collect(Collectors.toList());

        return ApiRespone.<ComplaintRespone>builder()
                .api_desription_("get complaint detailt")
                .api_respone_("200")
                .api_result_(ComplaintRespone.builder()
                        .complaintCustomNameUserEntities_(complaintCustomNameUserEntities)
                        .staffEntities(staffRepo.findAll())
                        .build())
                .build();
    }
}
