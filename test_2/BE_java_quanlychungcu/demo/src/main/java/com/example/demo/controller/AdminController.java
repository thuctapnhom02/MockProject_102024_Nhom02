package com.example.demo.controller;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.request.SMPRequest;
import com.example.demo.model.respone.RMPRespone;
import com.example.demo.model.serviece.RMPServiece;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminController {

    @Autowired
    RMPServiece rmpServiece;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPaymentsServiece")
    ApiRespone<RMPRespone> ResidentManagementAndPaymentsServiece(@RequestBody SMPRequest SMPRequest){
        ApiRespone<RMPRespone> apiRespone = rmpServiece.searchResidentManagementAndPayments(SMPRequest.getName_(),
                SMPRequest.getPhone_(),
                SMPRequest.getEmail_());

        return apiRespone;
    }

    @PreAuthorize("hasRole('Admin')")
    @RequestMapping("/ResidentManagementAndPaymentsServiece")
    ApiRespone<RMPRespone> ResidentManagementAndPaymentsGet(){
        ApiRespone<RMPRespone> apiRespone = rmpServiece.searchResidentManagementAndPayments(null, null, null);

        return apiRespone;
    }

}
