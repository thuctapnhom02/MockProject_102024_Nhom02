<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/client/formLogin/fonts/icomoon/style.css">
    <link rel="stylesheet" href="/client/formLogin/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/client/formLogin/css/bootstrap.min.css">

    <!-- Style -->
    <link rel="stylesheet" href="/client/formLogin/css/style.css">

    <title> Đăng nhập </title>
</head>
<body>

<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="/client/formLogin/images/undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
            </div>
            <div class="col-md-6 contents">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="mb-4">
                            <h3>Đăng nhập</h3>
                        </div>
                        <form action="/login" method="post">
                            <c:if test="${param.error != null}">
                                <div class="my-2" style="color: red;">Nhập sai email hoặc password.</div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="my-2" style="color: rgb(0, 15, 230);">Đăng xuất thành công.</div>
                            </c:if>
                            <div class="form-group first">
                                <label for="inputEmail">Email</label>
                                <input type="text" class="form-control" name="username">
                            </div>
                            <div class="form-group last mb-4">
                                <label for="inputPassword">Mật khẩu</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </div>
                            <div class="d-flex mb-5 align-items-center">
                                <label class="control control--checkbox mb-0">
                                    <span class="caption">Ghi nhớ mật khẩu</span>
                                    <input type="checkbox" checked="checked"/>
                                    <div class="control__indicator"></div>
                                </label>
                                <span class="ml-auto"><a href="#" class="forgot-pass">Quên mật khẩu</a></span>
                            </div>
                            <button type="submit" value="Log In" class="btn btn-block btn-primary">Đăng nhập</button>
                            <span class="d-block text-left my-4 text-muted">&mdash; Đăng nhập với &mdash;</span>
                            <div class="social-login">
                                <a href="#" class="facebook"><span class="icon-facebook mr-3"></span></a>
                                <a href="#" class="twitter"><span class="icon-twitter mr-3"></span></a>
                                <a href="#" class="google"><span class="icon-google mr-3"></span></a>
                            </div>
                        </form>
                        <div class="mt-4 d-flex justify-content-center align-items-center" style="margin-right:50px;">
                            <p class="mb-0 me-2">Chưa có tài khoản?</p>
                            <a href="/register" class="btn btn-link" style="margin-top:13px">Đăng ký ngay</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/client/formLogin/js/jquery-3.3.1.min.js"></script>
<script src="/client/formLogin/js/popper.min.js"></script>
<script src="/client/formLogin/js/bootstrap.min.js"></script>
<script src="/client/formLogin/js/main.js"></script>
</body>
</html>
