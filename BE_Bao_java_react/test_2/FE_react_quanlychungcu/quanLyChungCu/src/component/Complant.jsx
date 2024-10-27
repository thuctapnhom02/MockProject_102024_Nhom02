import { useEffect, useState } from 'react'
import '../assets/css/complant.css'
import NavBar from './Navbar'
import axios from 'axios'
import Cookies from 'universal-cookie'

export default function Complant(){
    const [complaint_,setComplaint_] = useState()
    const [staff_,setStaff_] = useState()
    const cokk =  new Cookies
    const tokenParam = cokk.get('jwtToken_')
    console.log(tokenParam)

    function funcserch(){

        let searchParam = {
            nameUser_:$(".main__body--itemsearch .itemsearch__input--item input").val(),
            status_:$(".main__body--itemsearch .itemsearch__input--item select").val()
        }
        console.log(searchParam)
        axios("http://127.0.0.1:9090/admin/api/complaint",{
            method:"POST",
            headers:{
                Authorization:tokenParam,
                "Content-Type":"application/json"
            },
            data:JSON.stringify(searchParam)

        }).then((data)=>{
            console.log(data.data.api_result_)
            setComplaint_(data.data.api_result_.complaintCustomNameUserEntities_)
        })

    }


    useEffect(()=>{
        funcserch()
    },[])




    return(
        <div className="main">
            <NavBar></NavBar>
            <div className="main__body">
                <div className="main__body--itemtitle">
                    <div className="itemtitle__item">
                        <p>LIST OF COMPLAINTS</p>
                    </div>
                </div>
                <div className="main__body--itemsearch">
                    <div className="itemsearch__input">
                        <div className="itemsearch__input--title">
                            <p>search:</p>
                        </div>
                        <div className="itemsearch__input--item">
                            <input type="text" onChange={funcserch} />
                        </div>
                    </div>
                    <div className="itemsearch__input">
                        <div className="itemsearch__input--title">
                            <p>Select status</p>
                        </div>
                        <div className="itemsearch__input--item">
                            <select onChange={funcserch}>
                                <option value="">all</option>
                                <option value="Resolved">Resolved</option>
                                <option value="Pending">Pending</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div className="main__body--itemtable">
                    <div className="itemtable__title">
                        <div className="itemtable__title--item">
                            <p>Name user</p>  
                        </div>
                        <div className="itemtable__title--item">
                            <p>Comlant status</p>  
                        </div>
                        <div className="itemtable__title--item">
                            <p>Day Complaint</p>  
                        </div>
                        <div className="itemtable__title--item">
                            <p>Expected Complant</p>  
                        </div>
                        <div className="itemtable__title--item">
                            <p>Complant Of Content</p>  
                        </div>
                    </div>
                    {complaint_?.map((item,i)=>(
                        <div key={i} className="itemtable__item">
                            <div className="itemtable__item--item">
                                <a href={"/complantDetail/"+item.id_}>{item.name_}
                                    <span></span>
                                    <span></span>
                                </a> 
                            </div>
                            <div className="itemtable__item--item">
                                <p>{item.status_}</p>  
                            </div>
                            <div className="itemtable__item--item">
                                <p>{item.complaint_date_}</p>  
                            </div>
                            <div className="itemtable__item--item">
                                <p>{item.expected_completion_date_}</p>  
                            </div>
                            <div className="itemtable__item--item">
                                <p>{item.content_of_complaint_}</p>  
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    )
}