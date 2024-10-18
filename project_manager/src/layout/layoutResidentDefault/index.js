import { NavLink, Outlet } from "react-router-dom";
import "./style.scss";

function LayoutResidentDefault(){
  return(
    <>
    <div className="layout-resident-default">
      <div className="layout-adresidentmin-default__sidebar">
        <div className="account">
          <img src="" alt="avata"/>
          <p className="name">Resident</p>
        </div>
        <div className="menu">
          <ul>
            <li>
              <NavLink to="/resident/">
                Home
              </NavLink>
            </li>
            <li>
              <NavLink to="/resident/information">
                Personal information, Contracts
              </NavLink>
            </li>
            <li>
              <NavLink to="/resident/request">
                Maintenance and Repair requests
              </NavLink>
            </li>
            <li>
              <NavLink to="/resident/payment">
                payment
              </NavLink>
            </li>
            <li>
              <NavLink to="/resident/notification">
                Notification
              </NavLink>
            </li>
            <li>
              <NavLink to="/resident/complains">
                Complains
              </NavLink>
            </li>
            <button>Sign out</button>
          </ul>
        </div>
      </div>
      <main className="layout-resident-default__main">
        <Outlet/>
      </main>
    </div>
    </>
    
  )
}

export default LayoutResidentDefault;