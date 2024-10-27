package com.example.Quan_Ly_Chung_Cu.exeption;

public class Exeption_custom extends RuntimeException{
    private Errcode err_code_;

    public Exeption_custom(Errcode err){
        this.err_code_ = err;
//        this.err_code_.setErr_code(err.getErr_code());
//        this.err_code_.setMess(err.getMess());
    }


    public Errcode getErr_code_() {
        return err_code_;
    }

    public void setErr_code_(Errcode err_code_) {
        this.err_code_ = err_code_;
    }
}
