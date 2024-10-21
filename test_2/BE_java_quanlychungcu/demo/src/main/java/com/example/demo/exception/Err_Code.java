package com.example.demo.exception;




public enum Err_Code {
    ERR_CODE_password_not_create_token_("Err request","not create token"),
    ERR_CODE_password_login_("Err request","password false"),
    ERR_CODE_phone_login_("Err request","password false");


    private String err_code_;
    private String mess_; 

    Err_Code(String err_code,String mess){
        this.err_code_ = err_code;
        this.mess_ = mess;
    }

    public String getErr_code() {
        return err_code_;
    }

    public void setErr_code(String err_code) {
        this.err_code_ = err_code;
    }

    public String getMess() {
        return mess_;
    }

    public void setMess(String mess) {
        this.mess_ = mess;
    }

}
