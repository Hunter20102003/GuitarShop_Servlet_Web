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
    </head>
    <%@include file="header.jsp" %>
    <body id="reportsPage">
        <div class="" id="home">

            <div class="container mt-5">

                <div class="row tm-content-row">
                    <div class="tm-block-col tm-col-avatar">
                        <div class="tm-bg-primary-dark tm-block tm-block-avatar">
                            
                            
                            <h2 class="tm-block-title">Ảnh</h2>
                            <div class="tm-avatar-container">
                                <img src="${requestScope.img}" alt="Avatar" class="tm-avatar img-fluid mb-4" />
                            </div>
                            <form id="uploadForm" action="update" method="post" enctype="multipart/form-data">
                                <input type="text"  name="update" value="img" style="display: none;" />
                                <input type="file" id="fileInput" name="fileInput" style="display: none;" />
                                <label for="fileInput" class="btn btn-primary btn-block text-uppercase">
                                    Chọn ảnh đại diện
                                </label>
                                <button type="submit" class="btn btn-success btn-block text-uppercase" style="display: none;">
                                    Tải lên
                                </button>
                            </form>
                        </div>
                    </div>

                    <div class="tm-block-col tm-col-account-settings">
                        <div class="tm-bg-primary-dark tm-block tm-block-settings">
                            <div style="color:green">${updateInfoSuccess}</div>
                            <h2 class="tm-block-title">Thông tin cá nhân</h2>
                            <form action="update" method="post" class="tm-signup-form row">

                                <div class="form-group col-lg-6">
                                    <div style="color:red">${invalidName}</div>
                                    <label for="name">Tên</label>
                                    <input
                                        id="name"
                                        name="name"
                                        type="text"
                                        value="${name}"
                                        class="form-control validate"
                                        />
                                </div>
                                <div class="form-group col-lg-6">
                                    <div style="color:red">${invalidEmail}</div>
                                    <label for="email">Email</label>
                                    <input
                                        id="email"
                                        name="email"
                                        type="email"
                                        value="${email}"
                                        class="form-control validate"
                                        />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="dob">Ngày sinh</label>
                                    <input
                                        id="dob"
                                        name="dob"
                                        value="${dob}"
                                        type="date"
                                        class="form-control validate"
                                        />
                                </div>

                                <div class="form-group col-lg-6">
                                    <div style="color:red">${invalidPhone}</div>
                                    <label for="phone">Số điện thoại</label>
                                    <input
                                        id="phone"
                                        name="phone"
                                        type="tel"
                                        value="${phone}"
                                        class="form-control validate"
                                        />
                                </div>
                                <input type="text" name="update" value="info" hidden>

                                <div class="col-12">
                                    <button
                                        type="submit"
                                        class="btn btn-primary btn-block text-uppercase"
                                        >
                                        Lưu thông tin
                                    </button>
                                </div>
                            </form>
                            <div class="form-group col-lg-6">
                                <label class="tm-hide-sm">&nbsp;</label>

                                <a href="update_password.jsp"><button
                                        type="submit"
                                        class="btn btn-primary btn-block text-uppercase"
                                        >Đổi mật khẩu</button></a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="footer.jsp" %>
        <script>// Gán sự kiện onchange cho input type="file"
            document.getElementById("fileInput").addEventListener("change", function () {
                // Gửi biểu mẫu khi người dùng chọn một tệp ảnh
                document.getElementById("uploadForm").submit();
            });</script>
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
