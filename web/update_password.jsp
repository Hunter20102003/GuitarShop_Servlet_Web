<%-- 
    Document   : account
    Created on : Mar 3, 2024, 12:48:09 AM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Accounts - Product Admin Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="admin/css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="admin/css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="admin/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <<link rel="stylesheet" href="css/style.css"/>
    </head>
    <%@include file="header.jsp" %>
    <body id="reportsPage">
        <div class="" id="home">

            <div class="container mt-5">

                <div class="row tm-content-row d-flex justify-content-center">

                    <div class="tm-block-col tm-col-account-settings">
                        <div class="tm-bg-primary-dark tm-block tm-block-settings">
                            <div style="color:red">${error}</div>
                            <div style="color:green">${updatePassSuccess}</div>
                            <h2 class="tm-block-title">Đổi mật khẩu</h2>
                            <form action="update" method="post" class="tm-signup-form-repass row">
                                <div class="form-group col-lg-6">
                                    <div style="color:red">${wrongPass}</div>
                                    <label for="old">Mật khẩu</label>
                                    <input
                                        id="old"
                                        name="oldPass"
                                        type="text"
                                        class="form-control validate"
                                        />
                                </div>

                                <div class="form-group col-lg-6">
                                    <div style="color:red">${invalidPass}<div>
                                            <div style="color:red">${invalidNewPass}</div>
                                            <label for="newPass">Mật khẩu mới</label>
                                            <input
                                                id="newPass"
                                                name="newPass"
                                                type="password"
                                                class="form-control validate"
                                                />
                                        </div>

                                        <div class="form-group col-lg-6 reNewPass">
                                            <div style="color:red">${invalidReNewPass}</div>
                                            <label for="reNewPass">Nhập lại mật khẩu mới</label>
                                            <input
                                                id="reNewPass"
                                                name="reNewPass"
                                                type="text"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <input type="password" name="update" value="password" hidden>


                                        <div class="col-8">
                                            <button
                                                type="submit"
                                                class="btn btn-primary btn-block text-uppercase"
                                                >
                                                Đổi mật khẩu
                                            </button>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                        </div>
                    </div>

                </div>
            </div>
            <%@include file="footer.jsp" %>

            <script src="js/jquery-3.3.1.min.js"></script>
            <!-- https://jquery.com/download/ -->
            <script src="js/bootstrap.min.js"></script>
            <!-- https://getbootstrap.com/ -->
    </body>
</html>
