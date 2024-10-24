import { useEffect, useState } from "react"
import axios from "axios"
import Navbar from "./Navbar"
import Cookies from "universal-cookie"
import { CSVLink } from 'react-csv';

export default function RMPage(){
    /*varilabel
        state varilabel
    */
    

    const [payMent_,setPayMent_] = useState()
    const [user_,setUser_] = useState()
    const [service_,setService_] = useState()
    const [apartment_,setApartment_] = useState()
    const [paymentMethod_,setPaymentMethod_] = useState()
    const [paymentIdNow_,setPaymentIdNow_] = useState()
    const [paymentTotalCount_,setPaymentTotalCount_] = useState([0,0])

    const [userIDNow_,setUserIdNow_] = useState()
    const [checkWindowEdit_,setCheckWindowEdit_] = useState([true,true])
    const [checkWindowCreate_,setCheckWindowCreate_] = useState(true)
    const cookies_ = new Cookies
    const tokenParam_ = cookies_.get('jwtToken_') 
    

    function funcsearch(){
        
        
        /*Conect Backend and get api
            get page http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsServiece 
            give data user,payment,type payment, service
            post page http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsServiece
            give data search user,payment, type payment, service
        */ 


        let name_ = $(".itemsearch__input .itemsearch__input--item:nth-child(1) .item__input input").val()
        let nameApartment_ = $(".itemsearch__input .itemsearch__input--item:nth-child(2) .item__input select").val()
        let phone_ = $(".itemsearch__input .itemsearch__input--item:nth-child(3) .item__input input").val()
        let email_ = $(".itemsearch__input .itemsearch__input--item:nth-child(4) .item__input input").val()

        if(nameApartment_==0){nameApartment_= null}
        // console.log("test",nameApartment_,name_,phone_,email_)
        
        axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPayments", {
            method: 'POST',
            headers: {
                'Authorization': tokenParam_,
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                name_:name_,
                phone_:phone_,
                email_:email_,
                idApartment_:nameApartment_

            })

        }).then(data=>{
            console.log(data.data.api_result_)
            setPayMent_(data.data.api_result_.payment_)
            setUser_(data.data.api_result_.user_)
            setPaymentTotalCount_([data.data.api_result_.totalProceeds_,data.data.api_result_.totalReceivables_])
        })
    }


    function funcreloadDataUserAndPayment(){


        /**reload web page with data user anf payment then update
        */


        axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPayments", {
            method: 'GET',
            headers: {
                'Authorization': tokenParam_,
                'Content-Type': 'application/json'
            }
        }).then(data=>{
            setPayMent_(data.data.api_result_.payment_)
            setUser_(data.data.api_result_.user_)
            setService_(data.data.api_result_.service_)
            setService_(data.data.api_result_.service_)
            setPaymentMethod_(data.data.api_result_.paymentMethod_)
            setPaymentTotalCount_([data.data.api_result_.totalProceeds_,data.data.api_result_.totalReceivables_])
            setApartment_(data.data.api_result_.apartmentEntiries_)
            // console.log([data.data.api_result_.totalProceeds_,data.data.api_result_.totalReceivables_])
            // console.log(data.data.api_result_)
            console.log("reload")
        })
    }


    useEffect(()=>{


        /*load data the firts in website
            data user and payment
        */

        funcreloadDataUserAndPayment()
    },[])


    function funcUpdatePayment(){
        

        /*function update data user - payment  
            update data user - table user
            update data payment - table payment
        */


        let paymentUpdate_={
            id_:paymentIdNow_,
            idService_:$(".itemwindoweditpayment__item--input:nth-child(4) select").val(),
            idPaymentMethod_:$(".itemwindoweditpayment__item--input:nth-child(5) select").val(),
            paymentDateline_:$(".itemwindoweditpayment__item--input:nth-child(6) input").val(),
            status_:$(".itemwindoweditpayment__item--input:nth-child(7) input:text").val(),
            total_:parseFloat($(".itemwindoweditpayment__item--input:nth-child(8) input:text").val())
        }
        console.log(paymentUpdate_)

        axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsUpdatePayment",{
            method:"POST",
            headers:{
                Authorization:tokenParam_,
                "Content-Type":"application/json"
            },
            data:JSON.stringify(paymentUpdate_)
        }).then((data)=>{
            setUserIdNow_(null)
            // funcreloadDataUserAndPayment()
            funcsearch()
            togleWindowEditPayment(null,null)
            // console.log(data.data.api_result_)
        })

    }


    function funcUpdateUser(){
        let userUpdate_ = {
            id_:userIDNow_,
            name_:$(".itemwindowedituser__item--input:nth-child(3) input:text").val(),
            gender_:$(".itemwindowedituser__item--input:nth-child(4) input:text").val(),
            email_:$(".itemwindowedituser__item--input:nth-child(5) input:text").val(),
            start_day_:$(".itemwindowedituser__item--input:nth-child(6) input").val(),
            end_day_:$(".itemwindowedituser__item--input:nth-child(7) input").val(),
            phone_:$(".itemwindowedituser__item--input:nth-child(8) input:text").val(),
            total_payment_:parseFloat($(".itemwindowedituser__item--input:nth-child(9) input:text").val()),
            debt_:parseFloat($(".itemwindowedituser__item--input:nth-child(10) input").val()),
            status_:$(".itemwindowedituser__item--input:nth-child(11) select").val(),
            password_:$(".itemwindowedituser__item--input:nth-child(12) input").val(),
            ssn_:$(".itemwindowedituser__item--input:nth-child(13) input").val(),
            address_:$(".itemwindowedituser__item--input:nth-child(14) input").val()
        }


        axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsUpdateUser", {
            method: 'POST',
            headers: {
                'Authorization': tokenParam_,
                'Content-Type': 'application/json'
            },
            data:JSON.stringify(userUpdate_)
        }).then(data=>{
            setUserIdNow_(null)
            // funcreloadDataUserAndPayment()
            funcsearch()
            togleWindowEditUser(null,null,null)
            // console.log(data.data.api_result_)
        })
        // console.log(userUpdate_)
        // console.log(userIDNow_)
    }


    function updatePayment(){
        console.log(checkWindowEdit_)
    }


    function funcDeleteUser(){
        
        
        /*Delete user 
            convert a delete status to 0 and hide table
        */


        if(userIDNow_){
            axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsDeleteUser", {
                method: 'POST',
                headers: {
                    'Authorization': tokenParam_,
                    'Content-Type': 'application/string'
                },
                data:userIDNow_
            }).then(data=>{
                setUserIdNow_(null)
                // funcreloadDataUserAndPayment()
                funcsearch()
                togleWindowEditUser(null,null)
                console.log(data.data.api_result_)
                // console.log(userIDNow_)
            })
        }
    }
    
    
    function funcDeletePayment(){
        
        
        /*Delete payment 
            convert a delete status to 0 and hide table
        */


        if(paymentIdNow_){
            axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsDeletePayment", {
                method: 'POST',
                headers: {
                    'Authorization': tokenParam_,
                    'Content-Type': 'application/string'
                },
                data:paymentIdNow_
            }).then(data=>{
                setUserIdNow_(null)
                // funcreloadDataUserAndPayment()
                funcsearch()
                togleWindowEditPayment(null,null)
                // console.log(data.data.api_result_)
                // console.log(paymentIdNow)
            })
        }
    }


    function funcCreateUser(){
        let userCreate_ = {
            id_:userIDNow_,
            name_:$(".itemwindowcreateuser__item--input:nth-child(3) input:text").val(),
            gender_:$(".itemwindowcreateuser__item--input:nth-child(4) input:text").val(),
            email_:$(".itemwindowcreateuser__item--input:nth-child(5) input:text").val(),
            start_day_:$(".itemwindowcreateuser__item--input:nth-child(6) input").val(),
            end_day_:$(".itemwindowcreateuser__item--input:nth-child(7) input").val(),
            phone_:$(".itemwindowcreateuser__item--input:nth-child(8) input:text").val(),
            total_payment_:parseFloat($(".itemwindowcreateuser__item--input:nth-child(9) input:text").val()),
            debt_:parseFloat($(".itemwindowcreateuser__item--input:nth-child(10) input").val()),
            status_:$(".itemwindowcreateuser__item--input:nth-child(11) select").val(),
            password_:$(".itemwindowcreateuser__item--input:nth-child(12) input").val(),
            ssn_:$(".itemwindowcreateuser__item--input:nth-child(13) input").val(),
            address_:$(".itemwindowcreateuser__item--input:nth-child(14) input").val(),
            delete_status_ : '1'
        }
        console.log(userCreate_)

        axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsCreateUser",{
            method:"POST",
            headers:{
                'Authorization':tokenParam_,
                "Content-Type":"application/json"
            },
            data:JSON.stringify(userCreate_)
        }).then((data)=>{
            console.log(data.data.api_result_)
        })
    }
   

   function togleWindowEditUser (e,userEventEdit_){


        /*animetion web page
            togle in edit podup page user anf payment
        */


       if(checkWindowEdit_[0]){
           let heightScreen_ = jQuery(window).height()
           $(".main__body--itemwindowedituser").css("height",heightScreen_)
           $(".main__body--itemwindowedituser").css("display","flex")
           $(".itemwindowedituser__item--input:nth-child(3) input:text").val(userEventEdit_.name_)
           $(".itemwindowedituser__item--input:nth-child(4) input:text").val(userEventEdit_.gender_)
           $(".itemwindowedituser__item--input:nth-child(5) input:text").val(userEventEdit_.email_)
           $(".itemwindowedituser__item--input:nth-child(6) input").val(userEventEdit_.start_day_?.split("T")[0])
           $(".itemwindowedituser__item--input:nth-child(7) input").val(userEventEdit_.end_day_?.split("T")[0])
           $(".itemwindowedituser__item--input:nth-child(8) input:text").val(userEventEdit_.phone_)
           $(".itemwindowedituser__item--input:nth-child(9) input:text").val(userEventEdit_.total_payment_)
           $(".itemwindowedituser__item--input:nth-child(10) input:text").val(userEventEdit_.debt_)
           $(".itemwindowedituser__item--input:nth-child(11) select").val(userEventEdit_.status_).change()
           $(".itemwindowedituser__item--input:nth-child(12) input:text").val(userEventEdit_.password_)
           $(".itemwindowedituser__item--input:nth-child(13) input:text").val(userEventEdit_.ssn_)
           $(".itemwindowedituser__item--input:nth-child(14) input:text").val(userEventEdit_.address_)
           setCheckWindowEdit_([false,checkWindowEdit_[1]])
           setUserIdNow_(userEventEdit_.id_)
        }else{
            $(".main__body--itemwindowedituser").css("display","none")
            setUserIdNow_(null)
            setCheckWindowEdit_([true,checkWindowEdit_[1]])
        }
    }


    function togleWindowEditPayment (e,paymentEventEdit_){
        if(checkWindowEdit_[1]){
            setCheckWindowEdit_([checkWindowEdit_[0],false])
            setPaymentIdNow_(paymentEventEdit_.id_)
            $(".main__body--itemwindoweditpayment").css("height",jQuery(window).height())
            $(".main__body--itemwindoweditpayment").css("display","flex")
            $(".itemwindoweditpayment__item--input:nth-child(3) p:nth-child(2)").text(paymentEventEdit_.name_)
            $(".itemwindoweditpayment__item--input:nth-child(4) select").val(paymentEventEdit_.id_service_).change()
            $(".itemwindoweditpayment__item--input:nth-child(5) select").val(paymentEventEdit_.id_payment_method_).change()
            $(".itemwindoweditpayment__item--input:nth-child(6) input").val(paymentEventEdit_.payment_dateline_.split("T")[0])
            $(".itemwindoweditpayment__item--input:nth-child(7) input:text").val(paymentEventEdit_.status_)
            $(".itemwindoweditpayment__item--input:nth-child(8) input:text").val(paymentEventEdit_.total_)
            
        }else{
            $(".main__body--itemwindoweditpayment").css("display","none")
            setCheckWindowEdit_([checkWindowEdit_[0],true])
        }
    }


    function togleWindowCreateUser(e){
        if(checkWindowCreate_){
            $(".main__body--itemwindowcreateuser").css("height",jQuery(window).height())
            $(".main__body--itemwindowcreateuser").css("display","flex")
            setCheckWindowCreate_(false)
        }else{
            $(".main__body--itemwindowcreateuser").css("display","none")
            setCheckWindowCreate_(true)
        }
        setCheckWindowEdit_()
    }


    function exportExelFile(){
        
    }
    



{/* <div  class="main">
    <div  class="main__body">

    </div> 
</div> */}

    return (<div className="main">
        <Navbar ></Navbar>
        <div className="main__body">
            <div className="main__body--itemtitle_1">
            <p>Apartment management in the United States</p>
            </div>
            <div className="main__body--itemtitle_2">
                <p>Resident management and payments</p>
            </div>
            <div className="main__body--itemsearch">
                <form action="">
                    <div className="itemsearch__input">
                        <div className="itemsearch__input--item">
                            <div className="item__title">
                                <p>Tenant</p>
                            </div>
                            <div className="item__input">
                                <p></p><input  type="text"/>
                            </div>
                        </div>
                        <div className="itemsearch__input--item">
                            <div className="item__title">
                                <p>Apartment</p>
                            </div>
                            <div className="item__input">
                                <select>
                                    <option value="0">none</option>
                                    {
                                        apartment_?.map((item,i)=>(
                                            <option key={i} value={item.id_}>{item.num_apartment_}</option>
                                        ))
                                    }
                                </select>
                            </div>
                        </div>
                        <div className="itemsearch__input--item">
                            <div className="item__title">
                                <p>Phone</p>
                            </div>
                            <div className="item__input">
                                <p></p><input
                                 type="text" />
                            </div>
                        </div>
                        <div className="itemsearch__input--item">
                            <div className="item__title">
                                <p>Email</p>
                            </div>
                            <div className="item__input">
                                <p></p><input
                                 type="text"/>
                            </div>
                        </div>
                    </div>
                    <div className="itemsearch__btn">
                       <a onClick={funcsearch}>Search</a> 
                    </div>
                </form>
            </div>
            <div className="main__body--itemuser">
                <div className="itemuser__tile">
                    <p>User information</p>
                    <p onClick={togleWindowCreateUser}>Create</p>
                    <p>{user_?.length &&
                                <CSVLink
                                    data={user_}
                                    filename="results.csv"
                                    target="_blank"
                                >
                                    Export
                                </CSVLink>
                                }</p>
                </div>
                <div className="itemuser__table">
                    <div className="itemuser__table--tile">
                        <div className="tile__name">
                            <p onClick={updatePayment}>name user</p>
                        </div>
                        <div className="tile__name">
                            <p>Address</p>
                        </div>
                        <div className="tile__name">
                            <p>Email</p>
                        </div>
                        <div className="tile__name">
                            <p>Start Day Contract</p>
                        </div>
                        <div className="tile__name">
                            <p>End Day Contract</p>
                        </div>
                        <div className="tile__name">
                            <p>Debt</p>
                        </div>
                        <div className="tile__name">
                            <p>Total Payment</p>
                        </div>
                        <div className="tile__name">
                            <p>Phone</p>
                        </div>
                        <div className="tile__name">
                            <p>Status</p>
                        </div>
                        <div className="tile__name">
                            <p>SSN</p>
                        </div>
                        <div className="tile__name">
                            <p>Password</p>
                        </div>
                    </div>
                    
                        {
                            user_?.map((item,i)=>(
                                <div key={i} className="itemuser__table--item">
                                    <div className="item__name">
                                    <p onClick={(e)=>togleWindowEditUser(e,item)}>{item.name_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.address_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.email_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.start_day_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.end_day_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.debt_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.total_payment_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.phone_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.status_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.ssn_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.password_}</p>
                                </div>
                                </div>

                            ))
                        }
                        
                </div>
            </div>
            <div className="main__body--itempyament">
                <div className="itempyament__tile">
                    <p>Payment information</p>
                    <p></p>
                    <p>{payMent_?.length &&
                                <CSVLink
                                    data={payMent_}
                                    filename="results.csv"
                                    target="_blank"
                                >
                                    Export
                                </CSVLink>
                                }</p>
                </div>
                <div className="itempyament__table">
                    <div className="itempyament__table--tile">
                        <div className="tile__name">
                            <p>Name user</p>
                        </div>
                        <div className="tile__name">
                            <p>Payment dateline</p>
                        </div>
                        <div className="tile__name">
                            <p>Status</p>
                        </div>
                        <div className="tile__name">
                            <p>Total Payment</p>
                        </div>
                    </div>
                    {
                        payMent_?.map((item,i)=>(
                            <div key={i} className="itempyament__table--item">
                                <div className="item__name">
                                    <p onClick={(e)=>{togleWindowEditPayment(e,item)}}>{item.name_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.payment_dateline_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.status_}</p>
                                </div>
                                <div className="item__name">
                                    <p>{item.total_}</p>
                                </div>
                            </div>
                        ))
                    }
                </div>
                <div className="itempyament__total">
                    <div className="itempyament__total--text">
                        <div className="text__title">
                            <p>Total amount collected </p>
                            <p>Additional fees </p>
                        </div>
                        <div className="text__item">
                            <p>{paymentTotalCount_[0]} USD</p>
                            <p>{paymentTotalCount_[1]} USD</p>
                        </div>
                    </div>
                    <div className="itempyament__total--btn">
                        <div className="btn__item">
                        </div>
                    </div>
                </div>
            </div>
            <div className="main__body--itemwindowedituser">
                    <div className="itemwindowedituser__item">
                        <div className="itemwindowedituser__item--btnexit" onClick={(e)=>togleWindowEditUser(e,null)}>
                            <span></span>
                            <span></span>
                        </div>
                        <div className="itemwindowedituser__item--title">
                            <p>Edit user</p>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Name</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Gender</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Email</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Start day</p>
                            <input type="date" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>End day</p>
                            <input type="date" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Phone</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Total payment</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Debt</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Status</p>
                            <select>
                                <option value="1">unactive</option>
                                <option value="2">active</option>
                                <option value="3">lock</option>
                            </select>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Password</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>SSn</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--input">
                            <p>Address</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowedituser__item--btn">
                            <p onClick={funcDeleteUser}>Delete</p>
                            <p onClick={funcUpdateUser}>Update</p>
                        </div>

                    </div>
            </div>
            <div className="main__body--itemwindowcreateuser">
                    <div className="itemwindowcreateuser__item">
                        <div className="itemwindowcreateuser__item--btnexit" onClick={(e)=>togleWindowCreateUser(e,null)}>
                            <span></span>
                            <span></span>
                        </div>
                        <div className="itemwindowcreateuser__item--title">
                            <p>create user</p>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Name</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Gender</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Email</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Start day</p>
                            <input type="date" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>End day</p>
                            <input type="date" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Phone</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Total payment</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Debt</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Status</p>
                            <select>
                                <option value="1">unactive</option>
                                <option value="2">active</option>
                                <option value="3">lock</option>
                            </select>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Password</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>SSn</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--input">
                            <p>Address</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindowcreateuser__item--btn">
                            <span></span>
                            <p onClick={funcCreateUser}>Create</p>
                        </div>

                    </div>
            </div>
            <div className="main__body--itemwindoweditpayment">
                    <div className="itemwindoweditpayment__item">
                        <div className="itemwindoweditpayment__item--btnexit" onClick={(e)=>togleWindowEditPayment(e,null)}>
                            <span></span>
                            <span></span>
                        </div>
                        <div className="itemwindoweditpayment__item--title">
                            <p>Edit Payment</p>
                        </div>
                        <div className="itemwindoweditpayment__item--input">
                            <p>Name User</p>
                            <p></p>
                        </div>
                        <div className="itemwindoweditpayment__item--input">
                            <p>Serviece</p>
                            <select name="" id="">
                                {
                                    service_?.map((item,i)=>(
                                        <option key={i} value={item.id_}>{item.name_}</option>
                                    ))
                                }
                            </select>
                        </div>
                        <div className="itemwindoweditpayment__item--input">
                            <p>Type Payment</p>
                            <select name="" id="">
                            {
                                    paymentMethod_?.map((item,i)=>(
                                        <option key={i} value={item.id_}>{item.name_method_}</option>
                                    ))
                                }
                            </select>
                        </div>
                        <div className="itemwindoweditpayment__item--input">
                            <p>Date Dateline</p>
                            <input type="date" ></input>
                        </div>
                        <div className="itemwindoweditpayment__item--input">
                            <p>Status</p>
                            <input type="text" ></input>
                        </div>
                        <div className="itemwindoweditpayment__item--input">
                            <p>Total payment</p>
                            <input type="text" ></input>
                        </div>
                        
                        <div className="itemwindoweditpayment__item--btn">
                            <p onClick={funcDeletePayment}>Delete</p>
                            <p onClick={funcUpdatePayment}>Submit</p>
                        </div>

                    </div>
            </div>
        </div>
    </div> 
    )    
}


