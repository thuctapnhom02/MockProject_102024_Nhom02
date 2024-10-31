import { useState } from 'react'
import Navbar from './Navbar'


export default function HomePage(){
    return(
        <div  className="main">
            <Navbar></Navbar>
            <div  className="main__body">
                <div>home page</div>
            </div> 
        </div>
    )
}