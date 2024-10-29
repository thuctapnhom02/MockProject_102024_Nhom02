package com.example.demo.controller.bao;

import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.request.bao.LoginRequest;
import com.example.demo.model.respone.bao.LoginRespone;
import com.example.demo.model.serviece.bao.LoginServiece;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.text.ParseException;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginController {

    @Autowired
    LoginServiece loginServiece;



    @PostMapping("/Login")
    ApiRespone<LoginRespone> login(@RequestBody LoginRequest loginRequest) throws ParseException, JOSEException {
        ApiRespone<LoginRespone> apiRespone = new ApiRespone<>();
        apiRespone = loginServiece.login_create_token(loginRequest);
        return apiRespone;
    }
    
        
}
