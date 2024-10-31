import { NavLink } from "react-router-dom";
import { useState } from "react";
import "./style.scss";
import Facebook from '../../component/img/facebook_icon.png';
import Linkedin from '../../component/img/linkedin_icon.png';
import Google from '../../component/img/google_icon.png';
import hidePasswordIcon from '../../component/img/hide.png';
import showPasswordIcon from '../../component/img/eye.png';


function Login(){
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);

   
  const show_hide_password = (event) =>{
    event.preventDefault();
    const passwordInput = document.getElementById('password');
    const showPasswordButton = document.getElementsByClassName('show__password')[0];
    
    // Toggle password input type
    if (passwordInput.type === 'password') {
      passwordInput.type = 'text';
      showPasswordButton.style.backgroundImage = `url(${hidePasswordIcon})`;
    } else {
      passwordInput.type = 'password';
      showPasswordButton.style.backgroundImage = `url(${showPasswordIcon})`;
    }
    
  }

  return(
    <>
    {/* <!-- login page --> */}
    <div className="layout">
    <div class="login">
      <div class="container">
      {/* <!-- form login start --> */}
        <form action="" class="form">
          <h1 class="form__title">LOG IN</h1>
          <div class="form__input">
            <label for="email">Email address</label><br/>
            <input type="text" class="input" id="email" placeholder="Email address"/>
          </div>
          <div class="form__input">
            <label for="password">Password</label><br/>
            <input type="password" class="input" id="password" placeholder="Password"/> 
            <button class="show__password" onClick={show_hide_password} style={{
                    backgroundImage: `url(${showPasswordIcon})`}}></button>
          </div>
          <div class="form__remember-forgot">
            <label><input type="checkbox"/>Remember me</label> 
            <a href="#" class="forgot">Forgot password?</a>
          </div>
          <div class="form__button">
            <button type="submit" class="btn btn__login">Login</button>
            <a href="" class="btn btn__signup ">
              <NavLink to="/signup">
               Sign up
              </NavLink>
            </a>
          </div>
          <div class="form__acc-other">
            <p>Login with:</p>
            <ul>
              <li class="icon"><a href="https://facebook.com"><img src={Facebook} alt="Facebook" /></a></li>
              <li class="icon"><a href="#"><img src={Linkedin} alt="Linkedin" /></a></li>
              <li class="icon"><a href="#"><img src={Google} alt="Google" /></a></li> 
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
export default Login;