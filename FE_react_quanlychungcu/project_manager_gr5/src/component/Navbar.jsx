import { useEffect } from "react"

export default function Navbar(){

    

    useEffect(()=>{
        let main_navbar_itemtog_btn_length = $(".main .main__navbar .main__navbar--itemtog").length
        let main_navbar_itemtog_btn = ".main .main__navbar .main__navbar--itemtog:nth-child("
        
        let list_check_tog = [0,0,0,0,0,0,0,0]
        for (let index = 3; index < main_navbar_itemtog_btn.length+3; index++) {

            $(main_navbar_itemtog_btn + index.toString()+ ")").click(()=>{

                let number_item_child_tog_ = $(main_navbar_itemtog_btn + index.toString()+ ") .itemtog__linkpage .itemtog__linkpage--item .item").length

                if(list_check_tog[index-3] == 0){
                    $(main_navbar_itemtog_btn + index.toString()+ ") .itemtog__linkpage").css("height",(50*number_item_child_tog_).toString()+"px")
                    list_check_tog[index-3] = 1
                }else{
                    $(main_navbar_itemtog_btn + index.toString()+ ") .itemtog__linkpage").css("height","0px")
                    list_check_tog[index-3] = 0
                }
            })


        }

        let btn_respone_ = ".main .main__responebtn"
        let nav_bar_ = ".main .main__navbar"
        let check_tog_respone_ = true
        $(btn_respone_).click(()=>{
            if(check_tog_respone_){
                console.log("11")
                $(nav_bar_).css("width","300px")
                $(nav_bar_).css("border-right","2px solid #747373")
                $(nav_bar_).css("border-left","2px solid #747373")
                $(btn_respone_).css("width","300px")
                check_tog_respone_=false
            }else{
                $(nav_bar_).css("width","0px")
                $(nav_bar_).css("border","none")
                $(btn_respone_).css("width","30px")
                check_tog_respone_=true
            }
    })
    },[])
    
    return(
        <>
            <div className="main__navbar">
          <div className="main__navbar--itemlogo">
              <div className="logo__img">
                  <img src="" alt=""/>
              </div>
              <div className="logo__homelink">
                  <a href="/">
                      Admin name
                  </a>
              </div>
          </div>
          <div className="main__navbar--item">
              <div className="item__linkpage">
                  <a href="/Login">Home</a>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Account management</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="/staff">
                              Staff Account
                              <span></span>
                          </a>
                      </div>
                      {/* <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div> */}
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Financial management</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Resident management and payments</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="/RMP">management
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Personnel management</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Asset management</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Contract management</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Complaint management</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="/complant">Complaint manager
                              <span></span>
                          </a>
                      </div>
                      {/* <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div> */}
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemtog">
              <div className="itemtog__btn">
                  <p>Repair requests management</p>
              </div>
              <div className="itemtog__linkpage">
                  <div className="itemtog__linkpage--item">
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                      <div className="item">
                          <a href="">test link page togle
                              <span></span>
                          </a>
                      </div>
                  </div>
              </div>
          </div>
          <div className="main__navbar--itemlogout">
              <div className="itemlogout__btn">
                  <a href="">Logout</a>
              </div>
          </div>
      </div>
      
      <div className="main__responebtn">
          <span></span>
          <span></span>
          <span></span>
      </div>
        </>
    )

}