import { useEffect, useState } from 'react'
import '../assets/css/staff.css'
import Navbar from './Navbar'
import axios from 'axios'
import Cookies from 'universal-cookie'

export default function Staff(){
    const cokk = new Cookies
    const tokenParam_ = cokk.get("jwtToken_")
    
    const [tog_,setTog_] = useState(true)
    const [role_,setRole_] = useState()
    const [staff_,setStaff_] = useState()
    const [idStaffNow_,setIdStaffNow_] = useState()
    


    function funcTogBtn(e,functionTog_,itemStaff_){
        if(tog_){
            setTog_(false)
            $(".main .main__body .main__body--staff .staff__detail").css("display","flex")
            if(functionTog_){
                setIdStaffNow_(itemStaff_.id_)

                $(".main .main__body .main__body--staff .staff__detail .staff__detail--item .item__btn .item__btn--item:nth-child(1)").css("display","none")
                $(".main .main__body .main__body--staff .staff__detail .staff__detail--item .item__btn .item__btn--item:nth-child(2)").css("display","block")
                $(".main .main__body .main__body--staff .staff__detail .staff__detail--item .item__btn .item__btn--item:nth-child(3)").css("display","block")
                $(".item__detail .item__detail--input:nth-child(1) .input__item input").val(itemStaff_.name_)
                $(".item__detail .item__detail--input:nth-child(2) .input__item input").val(itemStaff_.phone_)
                $(".item__detail .item__detail--input:nth-child(3) .input__item select").val(itemStaff_.id_role_).change()
                $(".item__detail .item__detail--input:nth-child(4) .input__item input").val(itemStaff_.password_)
                $(".item__detail .item__detail--input:nth-child(5) .input__item input").val(itemStaff_.gender_)
                if(itemStaff_.start_day_){
                    $(".item__detail .item__detail--input:nth-child(6) .input__item input").val(itemStaff_.start_day_.split("+")[0]).change()
                }
                if(itemStaff_.end_day_){
                    $(".item__detail .item__detail--input:nth-child(7) .input__item input").val(itemStaff_.end_day_.split("+")[0]).change()
                }
                $(".item__detail .item__detail--input:nth-child(8) .input__item select").val(itemStaff_.status_).change()
                $(".item__detail .item__detail--input:nth-child(9) .input__item input").val(itemStaff_.address_).change()
            }else{
                $(".main .main__body .main__body--staff .staff__detail .staff__detail--item .item__btn .item__btn--item:nth-child(1)").css("display","block")
                $(".main .main__body .main__body--staff .staff__detail .staff__detail--item .item__btn .item__btn--item:nth-child(2)").css("display","none")
                $(".main .main__body .main__body--staff .staff__detail .staff__detail--item .item__btn .item__btn--item:nth-child(3)").css("display","none")

                $(".item__detail .item__detail--input:nth-child(1) .input__item input").val(undefined)
                $(".item__detail .item__detail--input:nth-child(2) .input__item input").val(undefined)
                $(".item__detail .item__detail--input:nth-child(4) .input__item input").val(undefined)
                $(".item__detail .item__detail--input:nth-child(5) .input__item input").val(undefined)
                $(".item__detail .item__detail--input:nth-child(6) .input__item input").val(null).change()
                $(".item__detail .item__detail--input:nth-child(7) .input__item input").val(null).change()
                $(".item__detail .item__detail--input:nth-child(9) .input__item input").val(null).change()
            }
        }else{
            $(".main .main__body .main__body--staff .staff__detail").css("display","none")
            setTog_(true)
        }
    }


    useEffect(()=>{funcSearchStaff()},[])


    function funcSearchStaff(){
        let search_ = {
            name_ : $(".staff__search .staff__search--item:nth-child(1) .item__input input").val(),
            status_ : $(".staff__search .staff__search--item:nth-child(2) .item__input select").val()
        }

        axios("http://127.0.0.1:9090/admin/api/staff",{
            method:"POST",
            headers:{
                Authorization:tokenParam_,
                "Content-Type":'application/json'
            },
            data:JSON.stringify(search_)
        }).then((data)=>{
            setRole_(data.data.api_result_.role)
            setStaff_(data.data.api_result_.staffCustomNameRole)
        })
    }
    function funcAddStaff(){
        let addStaff = {
                name_:$(".item__detail .item__detail--input:nth-child(1) .input__item input").val(),
                phone_:$(".item__detail .item__detail--input:nth-child(2) .input__item input").val(),
                id_role_:$(".item__detail .item__detail--input:nth-child(3) .input__item select").val(),
                password_:$(".item__detail .item__detail--input:nth-child(4) .input__item input").val(),
                gender_:$(".item__detail .item__detail--input:nth-child(5) .input__item input").val(),
                start_day_:$(".item__detail .item__detail--input:nth-child(6) .input__item input").val(),
                end_day_:$(".item__detail .item__detail--input:nth-child(7) .input__item input").val(),
                status_:$(".item__detail .item__detail--input:nth-child(8) .input__item select").val(),
                address_:$(".item__detail .item__detail--input:nth-child(9) .input__item input").val()
        }

        if(addStaff.name_&&addStaff.phone_&&addStaff.id_role_&&addStaff.password_&&addStaff.gender_&&addStaff.start_day_&&addStaff.end_day_&&addStaff.status_&&addStaff.address_){
            axios("http://127.0.0.1:9090/admin/api/staff/create",{
                method:"POST",
                headers:{
                    Authorization:tokenParam_,
                    "Content-Type":'application/json'
               },
               data:JSON.stringify(addStaff)
            }).then((data)=>{
                funcTogBtn(null,null,null)
                funcSearchStaff()
            })
        }else{
            alert("the value is null")
        }



    }
    function funcDeleteStaff(){
        console.log(idStaffNow_)

        axios("http://127.0.0.1:9090/admin/api/staff/delete",{
            method:"POST",
            headers:{
                Authorization:tokenParam_,
                "Content-Type":'application/string'
            },
            data:String(idStaffNow_)
        }).then((data)=>{
            console.log(data.data.api_result_)
            funcTogBtn(null,null,null)
            funcSearchStaff()

        })
    }
    function funcUpdate(){
        let updateStaff_ = {
            id_ : idStaffNow_,
            name_:$(".item__detail .item__detail--input:nth-child(1) .input__item input").val(),
            phone_:$(".item__detail .item__detail--input:nth-child(2) .input__item input").val(),
            id_role_:$(".item__detail .item__detail--input:nth-child(3) .input__item select").val(),
            password_:$(".item__detail .item__detail--input:nth-child(4) .input__item input").val(),
            gender_:$(".item__detail .item__detail--input:nth-child(5) .input__item input").val(),
            start_day_:$(".item__detail .item__detail--input:nth-child(6) .input__item input").val(),
            end_day_:$(".item__detail .item__detail--input:nth-child(7) .input__item input").val(),
            status_:$(".item__detail .item__detail--input:nth-child(8) .input__item select").val(),
            address_:$(".item__detail .item__detail--input:nth-child(9) .input__item input").val()
    }
    axios("http://127.0.0.1:9090/admin/api/staff/update",{
        method:"POST",
        headers:{
            Authorization:tokenParam_,
            "Content-Type":'application/json'
        },
        data:JSON.stringify(updateStaff_)
    }).then((data)=>{
        console.log(data.data.api_result_)
        funcSearchStaff()
        funcTogBtn(null,null,null)
    })
        

    }
    
    return (
        <div className='main'>
            <Navbar></Navbar>
            <div className="main__body">
                <div className="main__body--staff">
                    <div className="staff__title">
                        <p>LIST OF STAFFS</p>
                    </div>
                    <div className="staff__search">
                        <div className="staff__search--item">
                            <div className="item__title">
                                <p>search</p>
                            </div>
                            <div className="item__input">
                                <input onChange={funcSearchStaff} type="text"/>
                            </div>
                        </div>
                        <div className="staff__search--item">
                            <div className="item__title">
                                <p>status</p>
                            </div>
                            <div className="item__input">
                                <select onChange={funcSearchStaff}>
                                    <option value="">all</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div className="staff__table">
                        <div className="staff__table--title">
                            <div className="title__item">
                                <p>Name</p>
                            </div>
                            <div className="title__item">
                                <p>Role</p>
                            </div>
                            <div className="title__item">
                                <p>status</p>
                            </div>
                            <div className="title__item">
                                <p>Start day</p>
                            </div>
                            <div className="title__item">
                                <p>End day</p>
                            </div>
                            <div className="title__item">
                                <p>password</p>
                            </div>
                            <div className="title__item">
                                <p>gender</p>
                            </div>
                            <div className="title__item">
                                <p>phone</p>
                            </div>
                        </div>
                        {staff_?.map((item,i)=>(
                            <div key={i} className="staff__table--item">
                                <div className="item__item">
                                    <p onClick={(e)=>funcTogBtn(e,true,item)}>{item.name_}</p>
                                </div>
                                <div className="item__item">
                                    <p>{item.name_role_}</p>
                                </div>
                                <div className="item__item">
                                    <p>{item.status_}</p>
                                </div>
                                <div className="item__item">
                                    <p>{item.start_day_}</p>
                                </div>
                                <div className="item__item">
                                    <p>{item.end_day_}</p>
                                </div>
                                <div className="item__item">
                                    <p>{item.password_}</p>
                                </div>
                                <div className="item__item">
                                    <p>{item.gender_}</p>
                                </div>
                                <div className="item__item">
                                    <p>{item.phone_}</p>
                                </div>
                            </div>
                        ))}
                        <div className="staff__table--btn">
                            <button onClick={(e)=>{funcTogBtn(e,false)}}>Add</button>
                        </div>
                    </div>
                    <div className="staff__detail">
                        <div className="staff__detail--item">
                            <div className="item__title">
                                <p>Staff detail</p>
                            </div>
                            <div className="item__detail">
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Name</p>
                                    </div>
                                    <div className="input__item">
                                        <input type="text"/>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Phone</p>
                                    </div>
                                    <div className="input__item">
                                        <input type="number"/>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Role</p>
                                    </div>
                                    <div className="input__item">
                                        <select>
                                            {role_?.map((item,i)=>(
                                                <option key={i} value={item.id_}>{item.name_role_}</option>
                                            ))}
                                            {/* <option value="test 2">test 2</option> */}
                                        </select>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Password</p>
                                    </div>
                                    <div className="input__item">
                                        <input type="text"/>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Gender</p>
                                    </div>
                                    <div className="input__item">
                                        <input type="text"/>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Start day</p>
                                    </div>
                                    <div className="input__item">
                                        <input type="datetime-local"/>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>End day</p>
                                    </div>
                                    <div className="input__item">
                                        <input type="datetime-local"/>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Status</p>
                                    </div>
                                    <div className="input__item">
                                        <select>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </div>
                                </div>
                                <div className="item__detail--input">
                                    <div className="input__title">
                                        <p>Address</p>
                                    </div>
                                    <div className="input__item">
                                        <input type="text"/>
                                    </div>
                                </div>
                            </div>
                            <div className="item__btn">
                                <div className="item__btn--item">
                                    <button onClick={funcAddStaff}>Add</button>
                                </div>
                                <div className="item__btn--item">
                                    <button onClick={funcDeleteStaff}>Delete</button>
                                </div>
                                <div className="item__btn--item">
                                    <button onClick={(e)=>funcUpdate(e,"test")}>Update</button>
                                </div>
                                <div className="item__btn--item">
                                    <button onClick={(e)=>funcTogBtn(e,null)}>Closs</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )
}