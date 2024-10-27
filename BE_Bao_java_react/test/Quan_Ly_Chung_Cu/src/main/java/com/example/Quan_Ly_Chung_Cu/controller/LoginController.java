package com.example.Quan_Ly_Chung_Cu.controller;

import com.example.Quan_Ly_Chung_Cu.Api.Api_repo;
import com.example.Quan_Ly_Chung_Cu.request.Token_request;
import com.example.Quan_Ly_Chung_Cu.model.entity.Nguoi_dung_entity;
import com.example.Quan_Ly_Chung_Cu.respone.Token_respone;
import com.example.Quan_Ly_Chung_Cu.seviece.Login_seviece;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/login")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginController {

    @Autowired
    Login_seviece loginSeviece;

    @PostMapping("/test_1")
    Api_repo<Token_respone> test_1(@RequestBody Nguoi_dung_entity nd){
        Api_repo<Token_respone> check_api = loginSeviece.login(nd);
        return check_api;
    }

    @PostMapping("/test_2")
    Api_repo<Token_respone> test_2(@RequestBody Token_request tr) throws ParseException, JOSEException {
        Api_repo<Token_respone> check_api = loginSeviece.verify_token(tr);
        return check_api;
    }
}
