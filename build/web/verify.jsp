<%-- 
    Document   : signup
    Created on : Feb 29, 2024, 11:55:30 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="sireform/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="sireform/css/style.css">
</head>
<body>

    <div class="main">

        <!-- Sign up form -->
      <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="sireform/images/signin-image.jpg" alt="sing up image"></figure>
                        <a href="signup.jsp" class="signup-image-link">Back</a>
                        
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Verify</h2>
                        <p style="color:red">${error}</p> <br>
                        <form action="login" method="post" class="register-form" id="login-form">
                            
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="text" name="password" id="your_pass" placeholder="Code"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Gửi lại mã xác nhận</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Xác nhận"/>
                            </div>
                        </form>
                        
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