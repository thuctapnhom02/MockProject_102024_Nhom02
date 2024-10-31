import { NavLink, Outlet } from "react-router-dom";
import "./style.scss";

function LayoutStaffDefault(){
  return(
    <>
    <div className="layout-staff-default">
      <header className="layout-staff-default__header">Apartment managerment in the United States</header>
      <div className="layout-admin-default__sidebar">
        <div className="account">
          <img src="" alt="avata"/>
          <p className="name">Technical Staff</p>
        </div>
        <div className="menu">
          <ul>
            <li>
              <NavLink to="/staff/">
                Home
              </NavLink>
            </li>
            <li>
              <NavLink to="/staff/assignment">
                Assignment
              </NavLink>
              <ul>
                <li>
                  <NavLink to="/staff/assignment/system">
                    System Maintenance
                  </NavLink>
                </li>
                <li>
                  <NavLink to="/staff/assignment/request_repair">
                    Request a repair
                  </NavLink>
                </li>
              </ul>
            </li>
            <li>
              <NavLink to="/staff/workcontract">
                Work contract
              </NavLink>
            </li>
            <li>
              <NavLink to="/staff/profile">
                Edit profile
              </NavLink>
            </li>
            
            <button>Sign out</button>
          </ul>
        </div>
      </div>
      <main className="layout-staff-default__main">
        <Outlet/>
      </main>
    </div>
    </>
    
  )
}

export default LayoutStaffDefault;