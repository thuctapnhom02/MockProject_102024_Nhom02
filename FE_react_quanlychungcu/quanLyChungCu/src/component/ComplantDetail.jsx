import { useParams } from 'react-router-dom'
import '../assets/css/complantDetail.css'
import Navbar from './Navbar'
import Cookies from 'universal-cookie'
import { useEffect, useState } from 'react'
import axios from 'axios'

export default function ComplantDetail(){
    const id_ = useParams()
    const cokk = new Cookies
    const tokenParam = cokk.get("jwtToken_")

    const [complaint_,setComplaint_] = useState()
    const [staff_,setStaff_] = useState()
    const [staffName_,setStaffName] = useState()


    function  funcLoadComplaint(){
        axios("http://127.0.0.1:9090/admin/api/complaintDetail",{
            method:"POST",
            headers:{
                Authorization:tokenParam,
                "Content-Type":"application/string"
            },
            data: String(id_.id)
        }).then((data)=>{
            data.data.api_result_.staffEntities?.map((item,i)=>{
                if(item.id_==data.data.api_result_.complaintCustomNameUserEntities_[0].id_staff_){
                    setStaffName(item.name_)
                }
            })
            setComplaint_(data.data.api_result_.complaintCustomNameUserEntities_)
            setStaff_(data.data.api_result_.staffEntities)
        })
    }
    

    function funcComplaintUpdate(){

        let updateComplaint = {
            idComplaint_ : complaint_[0].id_,
            status_:$(".main__body .main__body--itemassignstaff:nth-child(5) .itemassignstaff__item select").val(),
            idStaff_ : $(".main__body .main__body--itemassignstaff:nth-child(4) .itemassignstaff__item select").val()

        }
        console.log(updateComplaint)

        axios("http://127.0.0.1:9090/admin/api/complaintUpdate",{
            method:"POST",
            headers:{
                Authorization:tokenParam,
                "Content-Type":"application/json"
            },
            data: JSON.stringify(updateComplaint)
        }).then((data)=>{
            console.log(data.data.api_result_)
            
            funcLoadComplaint()
        })
    }

    useEffect(()=>{
        funcLoadComplaint()
    },[])





    return(
        <div className="main">
            <Navbar ></Navbar>
            <div className="main__body">
                <div className="main__body--itemtitle">
                    <p >COMLAINT DETAIL</p>
                </div>              
                <div className="main__body--itemdetail">
                    <div className="itemdetail__item">
                        <div className="itemdetail__item--input">
                            <div className="input__title">
                                <p>Name user </p>
                            </div>
                            <div className="input__item">
                                <p>{complaint_?.map((item,i)=>{return item.name_})}</p>
                            </div>
                        </div>
                        <div className="itemdetail__item--input">
                            <div className="input__title">
                                <p>Complaint date</p>
                            </div>
                            <div className="input__item">
                                <p>{complaint_?.map((item,i)=>{return item.complaint_date_})}</p>
                            </div>
                        </div>
                        <div className="itemdetail__item--input">
                            <div className="input__title">
                                <p>Expect date</p>
                            </div>
                            <div className="input__item">
                                <p>{complaint_?.map((item,i)=>{return item.expected_completion_date_})}</p>
                            </div>
                        </div>
                        <div className="itemdetail__item--input">
                            <div className="input__title">
                                <p>Status</p>
                            </div>
                            <div className="input__item">
                                <p>{complaint_?.map((item,i)=>{return item.status_})}</p>
                                {/* <select>
                                        <option value="Pending">Pending</option>
                                        <option value="Resolved">Resolved</option>
                                </select> */}
                            </div>
                        </div>
                        <div className="itemdetail__item--input">
                            <div className="input__title">
                                <p>Appartment</p>
                            </div>
                            <div className="input__item">
                                <p>{complaint_?.map((item,i)=>{return item.num_apartment_})}</p>
                            </div>
                        </div>
                        <div className="itemdetail__item--input">
                            <div className="input__title">
                                <p>Complaint content</p>
                            </div>
                            <div className="input__item">
                                <p>{complaint_?.map((item,i)=>{return item.content_of_complaint_})}</p>
                            </div>
                        </div>
                        <div className="itemdetail__item--input">
                            <div className="input__title">
                                <p>Staff</p>
                            </div>
                            <div className="input__item">
                                <p>{staffName_}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="main__body--itemdeription">
                    <div className="itemdeription__title">
                        <p>Note :</p>
                    </div>
                    <div className="itemdeription__item">
                        <p>
                            {complaint_?.map((item,i)=>{return item.note_})}
                        </p>
                    </div>
                </div>
                <div className="main__body--itemassignstaff">
                    <div className="itemassignstaff__title">
                        <p>Name Staff</p>
                    </div>
                    <div className="itemassignstaff__item">
                        <select>
                                    {staff_?.map((item,i)=>(
                                        <option key={i}  value={item.id_}>{item.name_}</option>
                                    ))}
                        </select>
                    </div>
                </div>
                <div className="main__body--itemassignstaff">
                    <div className="itemassignstaff__title">
                        <p>Status</p>
                    </div>
                    <div className="itemassignstaff__item">
                        <select>
                            <option value="Pending">Pending</option>
                            <option value="Resolved">Resolved</option>
                        </select>
                    </div>
                </div>
                <div className="main__body--itemupdate">
                    <div className="itemupdate__btn">
                        <button onClick={funcComplaintUpdate}>Update</button>
                    </div>
                </div>

            </div>
        </div>
    )
}