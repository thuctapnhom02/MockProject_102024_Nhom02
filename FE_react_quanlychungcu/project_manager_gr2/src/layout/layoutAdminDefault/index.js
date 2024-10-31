import { NavLink, Outlet } from "react-router-dom";
import "./style.scss";

function LayoutAdminDefault() {
  return (
    <>
      <header className="layout-admin-default__header">
        Apartment managerment in the United States
      </header>
      <div className="layout-admin-default">
        <div className="layout-admin-default__sidebar">
          <div className="menu">
            <ul>
              <li>
                <NavLink to="/admin/">Home</NavLink>
              </li>
              <li>
                <NavLink to="/admin/account">Account managerment</NavLink>
              </li>
              <li>
                Financial Management
                <ul>
                  <li>
                    <NavLink to="/admin/financial/income">Income</NavLink>
                  </li>
                  <li>
                    <NavLink to="/admin/financial/outcome">Outcome</NavLink>
                  </li>
                </ul>
              </li>
              <li>
                <NavLink to="/admin/resident">Resident managerment</NavLink>
              </li>
              <li>
                <NavLink to="/admin/personnel">personnel managerment</NavLink>
              </li>
              <li>
                <NavLink to="/admin/asset">Asset managerment</NavLink>
              </li>
              <li>
                <NavLink to="/admin/contract">Contract managerment</NavLink>
              </li>
              <li>
                <NavLink to="/admin/complaint">Complaint managerment</NavLink>
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
          <Outlet />
        </main>
      </div>
    </>
  );
}

export default LayoutAdminDefault;
