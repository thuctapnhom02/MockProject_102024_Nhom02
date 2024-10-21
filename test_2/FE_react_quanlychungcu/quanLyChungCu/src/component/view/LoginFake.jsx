import axios from "axios"
import '../../assets/css/Login.css'
import { useState } from "react"
import {useNavigate, useParams } from "react-router-dom"
import Navbar from "./Navbar"
import { jwtDecode } from "jwt-decode"
import Cookies from "universal-cookie"


const LoginFake = ()=>{
    const [token_,setToken_] = useState()
    const useParams_ = useParams()
    const navigate = useNavigate()
    const cookies_ = new Cookies 
    
    function loginFunc(){
        // let phone_value_ = $(".form__login--phone").val()
        // let password_value_ = $(".form__login--password").val()
        let phone_value_ = "0981000001"
        let password_value_ = "admin123"


        /*fake login and to page ResidentManagementAndPaymentsServiece
            Post api to http://127.0.0.1:9090/Login
                give token
        */


        axios("http://127.0.0.1:9090/Login",{
            method:"POST",
            headers:{
                'Authorization':"",
                'Content-Type':"application/json"
            },
            data:JSON.stringify({
                phone_:phone_value_,
                password_:password_value_
            })
        }).then(data=>{
            console.log(data.data)
            let data_ = data.data.api_result_.check_token_
            if(data_ == false){
                $(".form__login--notication").text(data.data.api_desription_)
            }else{
                setToken_(data.data.api_result_.token_)
                const token_ = jwtDecode(data.data.api_result_.token_)
                console.log(token_)
                cookies_.set("jwtToken_","Bearer "+data.data.api_result_.token_,{
                    expires: new Date(token_.exp*1000)
                })
                navigate("/RMP")
            }
        })
    }


    return(
        <div className="main">
            <Navbar item_ = {token_}></Navbar>
            <div className="main__body">
                <div className="form__login">
                    <input className="form__login--phone" type="text" placeholder="phone"/>
                    <input className="form__login--password" type="text" placeholder="password"/>
                    <p className="form__login--notication"></p>
                    <button onClick={loginFunc}>Login</button>
                </div>
            </div>
        </div>
    )
}

export default LoginFake