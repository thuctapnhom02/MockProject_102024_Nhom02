$(document).ready(function(){
    main_navbar_itemtog_btn_length = $(".main .main__navbar .main__navbar--itemtog").length
    main_navbar_itemtog_btn = ".main .main__navbar .main__navbar--itemtog:nth-child("
    
    list_check_tog = [0,0,0,0,0,0,0,0]
    for (let index = 3; index < main_navbar_itemtog_btn.length+3; index++) {

        $(main_navbar_itemtog_btn + index.toString()+ ")").click(()=>{

            number_item_child_tog_ = $(main_navbar_itemtog_btn + index.toString()+ ") .itemtog__linkpage .itemtog__linkpage--item .item").length

            if(list_check_tog[index-3] == 0){
                $(main_navbar_itemtog_btn + index.toString()+ ") .itemtog__linkpage").css("height",(50*number_item_child_tog_).toString()+"px")
                list_check_tog[index-3] = 1
            }else{
                $(main_navbar_itemtog_btn + index.toString()+ ") .itemtog__linkpage").css("height","0px")
                list_check_tog[index-3] = 0
            }
        })


    }

    btn_respone_ = ".main .main__responebtn"
    nav_bar_ = ".main .main__navbar"
    check_tog_respone_ = true
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

})

