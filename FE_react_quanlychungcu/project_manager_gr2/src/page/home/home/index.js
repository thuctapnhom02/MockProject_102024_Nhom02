import "./style.scss";
import img_section from "../../../component/img/imageSection1.png";

function Home(){
  return(
    <>
    <div className="home">
      {/* ABOUT US START */}
      <div className="aboutus">
        <img src={img_section} className="aboutus__img"/>
        <div className="aboutus__content">
          <div className="aboutus__content__title">
            ABOUT US
          </div>
          <div className="aboutus__content__doc">
            <p>Welcome to ... a leading provider of comprehensive residential building 
              management services. With years of experience in managing condominium complexes,
              our mission is to create safe, comfortable, and well-maintained living environments 
              for all residents.Our team of dedicated professionals is committed to delivering 
              efficient, transparent, and responsive management solutions. We handle everything 
              from maintenance services, security, and financial management to resident communications 
              and community development. </p>
          </div>
        </div>
      </div>
      {/* ABOUT US END */}

      {/* MANAGERMENT SERVICES START */}
      <div className="manager_service">
        <div className="manager_service__title">MANAGERMENT SERVICES</div>
        <div className="manager_service__items">
          <div className="manager_service__item">
            <div className="manager_service__item__title">
              RENT INVOICING
            </div>
            <div className="manager_service__item__content">
              <p>In order to help your tenants stay on top of rent payments, 
                we send out monthly invoices (including a detailed breakdown 
                of charges to their account) to remind them to payment is coming due.</p>
            </div>
          </div>
          <div className="manager_service__item">
            <div className="manager_service__item__title">
              REPAIR & MAINTENANCE
            </div>
            <div className="manager_service__item__content">
              <p>Outside of responsiveness and organization, we thoroughly 
                screen all of the vendors we work with to ensure your property 
                is getting the best possible repair and/or maintenance work for 
                the best possible price.</p>
            </div>
          </div>
          <div className="manager_service__item">
            <div className="manager_service__item__title">
              FINANCIAL REPORTING
            </div>
            <div className="manager_service__item__content">
              <p>Running a property is no different than running a business. We provide 
              monthly, quarterly, and annual financial reports. Also, with our on-demand 
              system, our clients can access financial reports in a moment’s notice.</p>
            </div>
          </div>
          <div className="manager_service__item">
            <div className="manager_service__item__title">
              APARTMENT TURNOVER SERVICES
            </div>
            <div className="manager_service__item__content">
              <p>After a tenant notifies us of their intent to move, we reply by scheduling 
                a pre-move out inspection and we send them a Move Out Letter, which states 
                the expectations regarding the condition of the property.</p>
            </div>
          </div>
        </div>
      </div>
      {/* MANAGERMENT SERVICES END */}

      {/* FOOTER START */}
      <div className="footer">
        <div className="footer__form">
          <h2>Want to  recieve our awesome stories?</h2>
          <form>
            <input type="email" placeholder="Enter your email" className="email"/>
            <button type="submit" className="subcribe">Subcribe</button>
          </form>
        </div>
        <div className="footer__content">
          <div className="footer__content__item">
            <div className="title">Email</div>
            <div className="content">
              info@tho18.design 
            </div>
          </div>
          <div className="footer__content__item">
            <div className="title">About us</div>
            <div className="content">
              <p>How it works</p>
              <p>Pricing</p>
              <p>FAQs</p>
            </div>
          </div>
          <div className="footer__content__item">
            <div className="title"></div>
            <div className="content">

            </div>
          </div>

        </div>
      </div>
      {/* FOOTER END */}
    </div>
    </>
  )
}
export default Home;