package com.example.demo.controller.bao;

import com.example.demo.model.request.bao.TokenRequest;
import com.example.demo.model.serviece.bao.HomeServiece;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.text.ParseException;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeController {

    @Autowired
    HomeServiece homeServiece;


    @RequestMapping("/index")
    String home(){
        return homeServiece.homeserviece();
    }

    @PostMapping("/index/gettoken")
    String home(@RequestBody TokenRequest tokenRequest) throws ParseException, JOSEException {
        homeServiece.gettokenuser(tokenRequest.getToken_());
        return "ok";
    }
    
}
