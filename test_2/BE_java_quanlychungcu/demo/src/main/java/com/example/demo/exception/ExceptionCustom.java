package com.example.demo.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionCustom extends RuntimeException{
    @Setter
    @Getter
    Err_Code err_code_;
    @Setter
    @Getter
    String desription_;

    public ExceptionCustom(Err_Code err_code_,String des) {
        this.err_code_ = err_code_;
        this.desription_ = des;
    }
}
