import PrivateRoute from "../component/privateRoutes";
import Login from "../page/login";
import SignUp from "../page/signup";

import LayoutDefault from "../layout/layoutDefault";
import Home from "../page/home/home";
import Owner from "../page/home/owner";
import Properties from "../page/home/properties";
import About from "../page/home/about";
import Blog from "../page/home/blog";
import Contact from "../page/home/contact";
import Resident from "../page/home/resident";

import LayoutAdminDefault from "../layout/layoutAdminDefault";
import Asset from "../page/admin/asset";
import Complaint from "../page/admin/complaint";
import Contract from "../page/admin/contract";
import Financial from "../page/admin/financial";
import Personnel from "../page/admin/personnel";
import RepairReq from "../page/admin/repair";
import ResidentManagerment from "../page/admin/resident";
import AdminHome from "../page/admin/home";
import Account from "../page/admin/account";

import LayoutResidentDefault from "../layout/layoutResidentDefault";
import ResidentHome from "../page/resident/home";
import Information from "../page/resident/information";
import Request from "../page/resident/request";
import Payment from "../page/resident/payment";
import Notification from "../page/resident/notification";
import Complains from "../page/resident/complaints";
import LayoutStaffDefault from "../layout/layoutStaffDefault";
import StaffHome from "../page/staff/home";
import Assignment from "../page/staff/assignment";
import System from "../page/staff/system";
import RequestRepair from "../page/staff/reqRepair";
import WorkContract from "../page/staff/workContract";
import Profile from "../page/staff/profile";

export const routes = [
  {
    path:"login",
    element: <Login/>
  },
  {
    path:"signup",
    element: <SignUp/>
  },
  {
    path:"/",
    element: <LayoutDefault/>,
    children: [
      {
        path:"/",
        element: <Home />
      },
      {
        path:"owner",
        element: <Owner />
      },
      {
        path:"resident",
        element: <Resident />
      },
      {
        path:"properties",
        element: <Properties />
      },
      {
        path:"about",
        element: <About />
      },
      {
        path:"blog",
        element: <Blog />
      },
      {
        path:"contact",
        element: <Contact />
      },
      {
        element: <PrivateRoute />
      }
    ]
  },
  {
    path:"/admin",
    element: <LayoutAdminDefault/>,
    children: [
      {
        path:"/admin/",
        element: <AdminHome />
      },
      {
        path:"/admin/account",
        element: <Account />
      },
      {
        path:"/admin/asset",
        element: <Asset />
      },
      {
        path:"/admin/complaint",
        element: <Complaint />
      },
      {
        path:"/admin/contract",
        element: <Contract />
      },
      {
        path:"/admin/financial",
        element: <Financial />
      },
      {
        path:"/admin/personnel",
        element: <Personnel />
      },
      {
        path:"/admin/repair",
        element: <RepairReq />
      },
      {
        path:"/admin/resident",
        element: <ResidentManagerment />
      }
    ]  
  },
  {
    path:"/resident",
    element: <LayoutResidentDefault/>,
    children: [
      {
        path:"/resident/",
        element: <ResidentHome />
      },
      {
        path:"/resident/information",
        element: <Information />
      },
      {
        path:"/resident/request",
        element: <Request />
      },
      {
        path:"/resident/payment",
        element: <Payment />
      },
      {
        path:"/resident/notification",
        element: <Notification />
      },
      {
        path:"/resident/complains",
        element: <Complains />
      },
    ]
  },
  {
    path:"/staff",
    element: <LayoutStaffDefault/>,
    children: [
      {
        path:"/staff/",
        element: <StaffHome />
      },
      {
        path:"/staff/assignment",
        element: <Assignment />,
        children:[
          {
            path:"/staff/assignment/system",
            element: <System />
          },
          {
            path:"/staff/assignment/request_repair",
            element: <RequestRepair />
          },
        ]
      },
      {
        path:"/staff/workcontract",
        element: <WorkContract />
      },
      {
        path:"/staff/profile",
        element: <Profile />
      },
      
    ]
  }
]