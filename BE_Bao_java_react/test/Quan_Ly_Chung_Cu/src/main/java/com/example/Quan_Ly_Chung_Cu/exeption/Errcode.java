package com.example.Quan_Ly_Chung_Cu.exeption;




public enum Errcode {
    Not_Create_token_(100001,"not create token");


    private  int err_code;
    private  String mess;

    Errcode(int err_code,String mess){
        this.err_code = err_code;
        this.mess = mess;
    }

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
