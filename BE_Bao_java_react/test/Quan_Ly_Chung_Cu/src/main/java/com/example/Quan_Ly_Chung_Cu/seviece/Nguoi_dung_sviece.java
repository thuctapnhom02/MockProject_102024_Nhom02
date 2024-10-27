package com.example.Quan_Ly_Chung_Cu.seviece;


import com.example.Quan_Ly_Chung_Cu.Api.Api_repo;
import com.example.Quan_Ly_Chung_Cu.model.entity.Nguoi_dung_entity;
import com.example.Quan_Ly_Chung_Cu.model.maper.Nguoi_dung_create;
import com.example.Quan_Ly_Chung_Cu.model.repo.Nguoi_dung_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Nguoi_dung_sviece {

    @Autowired
    Nguoi_dung_repo nguoi_dung_repo;

    @PreAuthorize("hasRole('admin')")
    public Api_repo<Nguoi_dung_entity>  add_nguoi_dung(Nguoi_dung_create data_){
        Nguoi_dung_create ndcr = new Nguoi_dung_create();
        Nguoi_dung_entity nd = ndcr.Mapp_nguoi_dung(data_);

        nguoi_dung_repo.save(nd);

        Api_repo<Nguoi_dung_entity> api = new Api_repo<>();
        api.setPing_(100001);
        api.setName_seviece_("create nguoi dung");
        api.setData(nd);

        return api;
    }

    @PreAuthorize("hasRole('admin')")
    public Api_repo<Nguoi_dung_entity> get_all_nguoi_dung(){
        Api_repo<Nguoi_dung_entity> api = new Api_repo<>();

        List<Nguoi_dung_entity> list_nguoi_dung =  nguoi_dung_repo.findAll().stream().toList();
        api.setPing_(1000002);
        api.setName_seviece_("get all nguoi dung");
        api.setDatas(list_nguoi_dung);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(api.getDatas().get(0).getMat_khau_()));
        return api;
    }

}
