<%-- 
    Document   : login
    Created on : Feb 29, 2024, 11:55:20 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Sign Up Form by Colorlib</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="sireform/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="sireform/css/style.css">
    </head>
    <body>

        <div class="main">

            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Sign up</h2>
                            <span style="text-align:center;color:red">${warning}</span>
                            <form method="POST" action="signup" class="register-form" id="register-form">
                                <div class="form-group">
    

                                    <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="username" value="${username}" id="name"  placeholder="Tên tài khoản"/>
                                    <span style="text-align:center;color:red">${warningUserName}</span>
                                </div>
                                <div class="form-group">

                                    <label for="email"><i class="zmdi zmdi-email"></i></label>
                                    <input type="email" name="email" value="${email}" id="email"  placeholder="Email cá nhân"/>
                                    <span style="text-align:center;color:red">${warningEmail}</span>
                                </div>
                                <div class="form-group">
                                    <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="pass" value="${pass}" id="pass"   placeholder="Mật khẩu"/>
                                    <span style="text-align:center;color:red">${warningPass}</span>
                                </div>
                                <div class="form-group">
                                    <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                    <input type="password" name="re_pass" value="${re_pass}" id="re_pass" placeholder="Xác nhận mật khẩu"/>
                                    <span style="text-align:center;color:red">${warningRePass}</span>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="agree-term" ${agree-term eq 1 ?"checked":""} id="agree-term" class="agree-term" />
                                    <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements  <a href="#" class="term-service">Terms of service</a></label>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                                </div>
                            </form>
                        </div>
                        <div class="signup-image">
                            <figure><img src="sireform/images/signup-image.jpg" alt="sing up image"></figure>
                            <a href="login.jsp" class="signup-image-link">Tôi đã có tài khoản</a>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Sing in  Form -->


        </div>

        <!-- JS -->
        <script src="sireform/vendor/jquery/jquery.min.js"></script>
        <script src="sireform/js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
