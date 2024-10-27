package com.example.Quan_Ly_Chung_Cu.model.maper;
import com.example.Quan_Ly_Chung_Cu.model.entity.Nguoi_dung_entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Nguoi_dung_create {
    String name_;
    String mat_khau_;
    int tuoi_;
    String gioi_tinh_;
    Date time_;


    public Nguoi_dung_entity Mapp_nguoi_dung(Nguoi_dung_create data_create_){
        Nguoi_dung_entity nd = new Nguoi_dung_entity();
        nd.setName_(data_create_.getName_());
        nd.setMat_khau_(data_create_.getMat_khau_());
        nd.setTuoi_(data_create_.getTuoi_());
        nd.setGioi_tinh_(data_create_.getGioi_tinh_());
        nd.setTime_(data_create_.getTime_());

        return nd;
    }
}
