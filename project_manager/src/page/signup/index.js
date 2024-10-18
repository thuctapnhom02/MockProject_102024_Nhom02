import { NavLink } from "react-router-dom";


function SignUp(){
  return(
    <>
    <div className="layout">
      <div className="signup">
        <div className="container">
          {/* <!-- form sign up start --> */}
          <form action="" className="form">
            <h1 className="form__title">SIGN UP</h1>
            <div className="form__input">
              <label for="email">Email address</label><br/>
              <input type="text" className="input" id="email" placeholder="Email address"/>
            </div>
            <div className="form__input">
              <label for="password">Password</label><br/>
              <input type="password" className="input" id="password" placeholder="Password"/>
              <button className="show__password"></button>
            </div>
            <div className="form__input">
              <label for="password_re">Re-enter Password</label><br/>
              <input type="password" className="input" id="password_re" placeholder="Re-enter Password"/>
              <button className="show__password1"></button>
            </div>
            <div className="form__button">
              <button type="submit" className="btn btn__signup">Sign up</button>
            </div>
            <p>Have an account ?<a href="" className="forgot"><NavLink to="/login">Login now</NavLink></a></p>
            <div className="form__acc-other">
              <p>Login with:</p>
              <ul>
                <li className="icon"><a href="https://facebook.com"><img src="./img/facebook_icon.png" alt="Facebook" /></a></li>
                <li className="icon"><a href="#"><img src="./img/linkedin_icon.png" alt="Facebook" /></a></li>
                <li className="icon"><a href="#"><img src="./img/google_icon.png" alt="Facebook" /></a></li>
              </ul>
            </div>
          </form>
          {/* <!-- form login end --> */}
        </div>
      </div>
    </div>
    </>
  )
}
export default SignUp;