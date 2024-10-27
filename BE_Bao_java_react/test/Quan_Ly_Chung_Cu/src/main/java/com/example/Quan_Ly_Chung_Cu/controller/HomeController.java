package com.example.Quan_Ly_Chung_Cu.controller;

import com.example.Quan_Ly_Chung_Cu.Api.Api_repo;
import com.example.Quan_Ly_Chung_Cu.model.entity.Nguoi_dung_entity;
import com.example.Quan_Ly_Chung_Cu.model.maper.Nguoi_dung_create;
import com.example.Quan_Ly_Chung_Cu.seviece.Nguoi_dung_sviece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    Nguoi_dung_sviece nguoi_dung_sviece;

    @RequestMapping("/home")
    private String home(){

        return "test api 1";
    }


    @PostMapping("/create_nguoi_dung")
    private Api_repo<Nguoi_dung_entity> create_user(@RequestBody Nguoi_dung_create data){
        Api_repo<Nguoi_dung_entity> api = nguoi_dung_sviece.add_nguoi_dung(data);
        return api;
    }


    @RequestMapping("/get_nguoi_dung")
    private Api_repo<Nguoi_dung_entity> get_user(){
        Api_repo<Nguoi_dung_entity> api = nguoi_dung_sviece.get_all_nguoi_dung();
        return api;
    }
}
