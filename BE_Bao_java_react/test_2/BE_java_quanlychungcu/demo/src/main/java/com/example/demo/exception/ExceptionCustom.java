package com.example.demo.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ExceptionCustom extends RuntimeException{
    String desription_;
    String errCode_;

    public ExceptionCustom(String des,String code_) {
        this.desription_ = des;
        this.errCode_ = code_;
    }
}
