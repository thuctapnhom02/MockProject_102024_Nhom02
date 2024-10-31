import { Navigate, Outlet } from "react-router-dom";

function PrivateRoute(){
  const isLogin = true;
  return(
    <>
    {isLogin? (<Outlet/>) : (<Navigate to="/login"/>)}
    </>    
  )
}

export default PrivateRoute;