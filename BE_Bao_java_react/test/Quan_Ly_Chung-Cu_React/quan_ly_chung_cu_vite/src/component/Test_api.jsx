import React from 'react';
import axios from "axios";
import { useEffect ,useState} from 'react';
import "../assets/js/jq.js"

function photo(){
    
}







const Test_api = ()=>{
    const [test_api_,set_test_api_] = useState()
    const [test_api_2_,set_test_api_2_] = useState()

    // useEffect(()=>{
    //     axios("http://127.0.0.1:9090/home", {
    //         method: 'GET',
    //         // headers: {
    //         //     'Authorization': ""
    //         // }
    //     }).then(data=>{
    //         // console.log(data.data,1)
    //         set_test_api_(data.data.datas)
    //     })
    // },[])
    // useEffect(()=>{
    //     axios("http://127.0.0.1:9090/get_nguoi_dung", {
    //         method:"POST",
    //         headers: {
    //             Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ0ZW5fZG9tYWluIiwic3ViIjoidGVzdCBuYW1lIDIiLCJleHAiOjE3MjkxODI3NDMsImlhdCI6MTcyOTE3NTU0Mywic2NvcGUiOiJhZG1pbiJ9.F1gYR1NuO0QgF3LSWxhW2pNEXaWq3gR65ELtE1Qun0UygJrun3EcZQxIrXnar8M0TwXMJLQu4dmFqcXG2i0Ufg"
    //         }
    //     }).then(data=>{
    //         console.log(data.data,"get data")
    //         set_test_api_2_(data.data.data)
    //     })
    // },[])
        
    function test_click_get_api(){
        axios("http://127.0.0.1:9090/get_nguoi_dung", {
            method:"POST",
            headers: {
                Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ0ZW5fZG9tYWluIiwic3ViIjoidGVzdCBuYW1lIDIiLCJleHAiOjE3MjkxODI3NDMsImlhdCI6MTcyOTE3NTU0Mywic2NvcGUiOiJhZG1pbiJ9.F1gYR1NuO0QgF3LSWxhW2pNEXaWq3gR65ELtE1Qun0UygJrun3EcZQxIrXnar8M0TwXMJLQu4dmFqcXG2i0Ufg"
            }
        }).then(data=>{
            set_test_api_(data.data.datas)
            console.log(data.data.datas)
        })
    }
    console.log(test_api_,"get data gl")
    // console.log(test_api_2_,"get data gl")

    function test_click_create_api(){
        axios("http://127.0.0.1:9090/Login", {
            method:"POST",
            headers: {
                Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ0ZW5fZG9tYWluIiwic3ViIjoiU1QwMDAwMDAxIiwiZXhwIjoxNzI5MjY4NTYwLCJpYXQiOjE3MjkyNjEzNjAsInNjb3BlIjoiQWRtaW4ifQ.VZP7UTrrqTr_OvWLkR23oFOQi5F89sTyJQ24l1KtJ7N-lckjs3lO8oymTbhHdOYQtJV5QD5pVIot1tdRXZDvZA",
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                phone_:"0981000001",
                password_:"admin123"
            })
        }).then(data=>{
            console.log(data.data,"create data")
            set_test_api_2_(data.data.data)
        })
    }

    return (<div>
        {
            // test_api_2_?.map((item,index)=>(
            //     <div key={index}>{item.name_}</div>
            // ))
            <div>
                <div onClick={test_click_create_api}>
                    test create api
                </div>
                <div onClick={test_click_get_api}>
                    test get api
                </div>
                <div>___________________________________________________________________________</div>
                <div>
                    <p>api create : </p>
                    <p>{test_api_2_?.id_}</p>
                </div>
                <div>___________________________________________________________________________</div>
                <div>
                    {test_api_?.map((item,index)=>(
                        <div key={index}>{item.id_}</div>
                    ))}
                </div>
            </div>
        }
    </div>)
}

export default Test_api