import { NavLink, Outlet } from "react-router-dom";
import "./style.scss";
import bgr from"../../component/img/bgr_header.png";

function LayoutDefault(){
  return(
    <>
    <div className="layout-default">
      <header className="layout-default__header">
        <div className="menu">
          <ul>
            <li>
              <NavLink to="/">
                Home
              </NavLink>
            </li>
            <li>
              <NavLink to="/properties">
                Properties
              </NavLink>
            </li>
            <li>
              <NavLink to="/owner">
                Owner
              </NavLink>
            </li>
            <li>
              <NavLink to="/resident">
                Resident
              </NavLink>
            </li>
            <li>
              <NavLink to="/blog">
                Blog
              </NavLink>
            </li>
            <li>
              <NavLink to="/about">
                About
              </NavLink>
            </li>
            <li>
              <NavLink to="/contact">
                Contact
              </NavLink>
            </li>
            <li>
              <NavLink to="/login">
                Login
              </NavLink>
            </li>
          </ul>
        </div>
        <img src={bgr} />
      </header>
      <main className="layout-default__main">
        <Outlet/>
      </main>
    </div>
    </>
    
  )
}

export default LayoutDefault;