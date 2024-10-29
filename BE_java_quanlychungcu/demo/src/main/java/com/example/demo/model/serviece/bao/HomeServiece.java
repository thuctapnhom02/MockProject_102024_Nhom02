package com.example.demo.model.serviece.bao;

import com.example.demo.model.entity.bao.StaffEntity;
import com.example.demo.model.repo.bao.StaffRepo;
import com.nimbusds.jose.JOSEException;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;


@Builder
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeServiece {

    @Autowired
    LoginServiece loginServiece;

    @Autowired
    StaffRepo staffRepo;

//    @PreAuthorize("hasAnyRole('Admin', 'StaffRepair')")
    public String homeserviece(){
        StaffEntity a = staffRepo.findByPhone("0981000002");
        System.out.println(a);
        return "home page";
    }

//    @PreAuthorize("hasRole('Admin')")
    public void gettokenuser(String token) throws ParseException, JOSEException {
        loginServiece.verify_token(token);
    }

}
