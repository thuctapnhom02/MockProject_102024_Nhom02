import { NavLink, Outlet } from "react-router-dom";
import "./style.scss";

function LayoutAdminDefault(){
  return(
    <>
    <div className="layout-admin-default">
      <header className="layout-admin-default__header">Apartment managerment in the United States</header>
      <div className="layout-admin-default__sidebar">
        <div className="menu">
          <ul>
            <li>
              <NavLink to="/admin/">
                Home
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/account">
                Account managerment
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/financial">
                Financial managerment
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/resident">
                Resident managerment
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/personnel">
                personnel managerment
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/asset">
                Asset managerment
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/contract">
                Contract managerment
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/complaint">
                Complaint managerment
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin/repair">
                Repair requests managerment
              </NavLink>
            </li>
            <button>Sign out</button>
          </ul>
        </div>
      </div>
      <main className="layout-admin-default__main">
        <Outlet/>
      </main>
    </div>
    </>
    
  )
}

export default LayoutAdminDefault;