import { useEffect, useState } from "react"
import axios from "axios"
import { useParams } from "react-router-dom"
import Navbar from "./Navbar"
import Cookies from "universal-cookie"

export default function RMPage(){
    /*varilabel
        state varilabel
    */
    const [payMent_,setPayMent_] = useState()
    const [user_,setUser_] = useState()
    const [service_,setService_] = useState()
    const [typePayment_,setTypePayment_] = useState()
    // const tokenParam_ = useParams()
    const cookies_ = new Cookies
    const tokenParam_ = cookies_.get('jwtToken_') 
    console.log(tokenParam_)

    
    /*Conect Backend and get api
        get page http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsServiece 
            give data user,payment,type payment, service
        post page http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsServiece
            give data search user,payment, type payment, service
    */  


    function search(){
        axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsServiece", {
            method: 'POST',
            headers: {
                'Authorization': tokenParam_,
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                name_:"Alice Johnson",
                phone_:"",
                email_:""
            })

        }).then(data=>{
            setPayMent_(data.data.api_result_.payment_)
            setUser_(data.data.api_result_.user_)
        })
    }
    useEffect(()=>{
        axios("http://127.0.0.1:9090/admin/api/ResidentManagementAndPaymentsServiece", {
            method: 'GET',
            headers: {
                'Authorization': tokenParam_,
                'Content-Type': 'application/json'
            }
        }).then(data=>{
            setPayMent_(data.data.api_result_.payment_)
            setUser_(data.data.api_result_.user_)
            setService_(data.data.api_result_.service_)
            setTypePayment_(data.data.api_result_.typePayment_)
        })
    },[])


    /*animetion web page
        togle in edit podup page user anf payment
    */


    let checkWindowEditUser_ = true
    let checkWindowEditPayment_ = true
    function togleWindowEditUser (e,userEventEdit_){
        if(checkWindowEditUser_){
            let heightScreen_ = jQuery(window).height()
            $(".main__body--itemwindowedituser").css("height",heightScreen_)
            $(".main__body--itemwindowedituser").css("display","flex")
            $(".itemwindowedituser__item--input:nth-child(3) input:text").val(userEventEdit_.name_)
            $(".itemwindowedituser__item--input:nth-child(4) input:text").val(userEventEdit_.gender_)
            $(".itemwindowedituser__item--input:nth-child(5) input:text").val(userEventEdit_.email_)
            $(".itemwindowedituser__item--input:nth-child(6) input").val(userEventEdit_.start_day_.split("T")[0])
            $(".itemwindowedituser__item--input:nth-child(7) input").val(userEventEdit_.end_day_.split("T")[0])
            $(".itemwindowedituser__item--input:nth-child(8) input:text").val(userEventEdit_.phone_)
            $(".itemwindowedituser__item--input:nth-child(9) input:text").val(userEventEdit_.total_payment_)
            $(".itemwindowedituser__item--input:nth-child(10) input:text").val(userEventEdit_.debt_)
            $(".itemwindowedituser__item--input:nth-child(11) select").val(userEventEdit_.status_).change()
            checkWindowEditUser_=false
        }else{
            $(".main__body--itemwindowedituser").css("display","none")
            checkWindowEditUser_=true
        }
    }
    function togleWindowEditPayment (e,paymentEventEdit_){
        if(checkWindowEditPayment_){
            checkWindowEditPayment_=false

            $(".main__body--itemwindoweditpayment").css("height",jQuery(window).height())
            $(".main__body--itemwindoweditpayment").css("display","flex")
            $(".itemwindoweditpayment__item--input:nth-child(3) p:nth-child(2)").text(paymentEventEdit_.user_id_)
            $(".itemwindoweditpayment__item--input:nth-child(4) select").val(paymentEventEdit_.id_service_).change()
            $(".itemwindoweditpayment__item--input:nth-child(5) select").val(paymentEventEdit_.id_type_payment_).change()
            $(".itemwindoweditpayment__item--input:nth-child(6) input").val(paymentEventEdit_.payment_dateline_.split("T")[0])
            $(".itemwindoweditpayment__item--input:nth-child(7) input:text").val(paymentEventEdit_.status_)
            $(".itemwindoweditpayment__item--input:nth-child(8) input:text").val(paymentEventEdit_.total_)
            
        }else{
            $(".main__body--itemwindoweditpayment").css("display","none")
            checkWindowEditPayment_=true
        }
    }




{/* <div  class="main">
    <div  class="main__body">

    </div> 
</div> */}

    return (<div className="main">
        <Navbar item_={tokenParam_}></Navbar>
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
                                <p></p><input
                                 type="text"/>
                            </div>
                        </div>
                        <div className="itemsearch__input--item">
                            <div className="item__title">
                                <p>Flor</p>
                            </div>
                            <div className="item__input">
                                <select>
                                    <option value="">flor 1</option>
                                    <option value="">flor 2</option>
                                    <option value="">flor 3</option>
                                    <option value="">flor 4</option>
                                    <option value="">flor 5</option>
                                    <option value="">flor 6</option>
                                    <option value="">flor 7</option>
                                    <option value="">flor 8</option>
                                    <option value="">flor 9</option>
                                </select>
                            </div>
                        </div>
                        <div className="itemsearch__input--item">
                            <div className="item__title">
                                <p>Apartment</p>
                            </div>
                            <div className="item__input">
                                <select>
                                    <option value="">001</option>
                                    <option value="">002</option>
                                </select>
                            </div>
                        </div>
                        <div className="itemsearch__input--item">
                            <div className="item__title">
                                <p>Phone</p>
                            </div>
                            <div className="item__input">
                                <p></p><input
                                 type="text"/>
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
                       <a onClick={search}>Search</a> 
                    </div>
                </form>
            </div>
            <div className="main__body--itemuser">
                <div className="itemuser__tile">
                    <p>User information</p>
                </div>
                <div className="itemuser__table">
                    <div className="itemuser__table--tile">
                        <div className="tile__name">
                            <p>name user</p>
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
                                </div>

                            ))
                        }
                        
                </div>
            </div>
            <div className="main__body--itempyament">
                <div className="itempyament__tile">
                    <p>Payment information</p>
                </div>
                <div className="itempyament__table">
                    <div className="itempyament__table--tile">
                        <div className="tile__name">
                            <p>name user</p>
                        </div>
                        <div className="tile__name">
                            <p>Payment dateline</p>
                        </div>
                        <div className="tile__name">
                            <p>Status</p>
                        </div>
                        <div className="tile__name">
                            <p>Payment method</p>
                        </div>
                        <div className="tile__name">
                            <p>Serviece</p>
                        </div>
                        <div className="tile__name">
                            <p>total</p>
                        </div>
                        <div className="tile__name">
                            <p>Phone</p>
                        </div>
                        <div className="tile__name">
                            <p>Status</p>
                        </div>
                    </div>
                    {
                        payMent_?.map((item,i)=>(
                            <div key={i} className="itempyament__table--item">
                                <div className="item__name">
                                    <p onClick={(e)=>{togleWindowEditPayment(e,item)}}>name user</p>
                                </div>
                                <div className="item__name">
                                    <p>Address</p>
                                </div>
                                <div className="item__name">
                                    <p>1234567890</p>
                                </div>
                                <div className="item__name">
                                    <p>Start dayssss duafghksja safhdouaho jfn </p>
                                </div>
                                <div className="item__name">
                                    <p>End Day</p>
                                </div>
                                <div className="item__name">
                                    <p>Rntal</p>
                                </div>
                                <div className="item__name">
                                    <p>Pyament method</p>
                                </div>
                                <div className="item__name">
                                    <p>Status</p>
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
                            <p>26.000 USD</p>
                            <p>26.000 USD</p>
                        </div>
                    </div>
                    <div className="itempyament__total--btn">
                        <div className="btn__item">
                            <a href="">Export</a>
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
                        <div className="itemwindowedituser__item--btn">
                            <span></span>
                            <p>Submit</p>
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
                                    typePayment_?.map((item,i)=>(
                                        <option key={i} value={item.id_}>{item.name_type_}</option>
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
                            <span></span>
                            <p>Submit</p>
                        </div>

                    </div>
            </div>
        </div>
    </div> 
    )    
}


