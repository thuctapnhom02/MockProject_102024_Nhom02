$(document).ready(function(){
    height_ = $(window).height() +""
    $(".login__page").css("height",height_)
    $(".login__page--item").css("top","50%")
    $(".login__page--item").css("transform","translateY(-50%)")


    $(".login__page--item .item__left--loginform__email input").change(function(){
        data = $(".login__page--item .item__left--loginform__email input").val()
        if(data != ""){
            $(".login__page--item .item__left--loginform__email label").css("position","absolute")
            $(".login__page--item .item__left--loginform__email label").css("top","10px")
        }else{
            $(".login__page--item .item__left--loginform__email label").css("position","absolute")
            $(".login__page--item .item__left--loginform__email label").css("top","50%")
        }
      });
    $(".login__page--item .item__left--loginform__pw input").change(function(){
        data = $(".login__page--item .item__left--loginform__pw input").val()
        if(data != ""){
            $(".login__page--item .item__left--loginform__pw label").css("position","absolute")
            $(".login__page--item .item__left--loginform__pw label").css("top","-10px")
        }
        else{
            $(".login__page--item .item__left--loginform__pw label").css("position","absolute")
            $(".login__page--item .item__left--loginform__pw label").css("top","50%")
        }
      });
})