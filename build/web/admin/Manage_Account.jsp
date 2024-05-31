<%-- 
    Document   : product
    Created on : Mar 3, 2024, 12:52:20 AM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib    prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Account Page - Admin HTML Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/templatemo-style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" /><body>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />    </head>

<body id="reportsPage">
    <jsp:include page="header.jsp"></jsp:include>

        <div class="container mt-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-8 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="tm-product-table-container">
                            <table class="table table-hover tm-table-small tm-product-table">
                                <thead>
                                    <tr>


                                        <th scope="col" style="width: 5%;">ID</th>                                    
                                        <th scope="col">Tài khoản</th>  
                                        <th scope="col" >Mật khẩu</th> 
                                        <th scope="col" >Email</th>
                                        <th scope="col" >Tên</th>  
                                        <th scope="col">Ngày sinh</th>                                       
                                        <th scope="col">Số điện thoại</th>  
                                        <th scope="col">Trạng thái</th> 
                                        <th scope="col">Ngày tạo</th> 
                                        <th scope="col">Khóa</th>
                                        <th scope="col">Xóa</th>
                                        <th scope="col">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                ${listUserEmpty}

                                <c:forEach var="s" items="${listUser}">

                                    <tr>
                                        <td >${s.id}</td>
                                        <td>${s.username}</td>
                                        <td style="width:250px">${s.password}</td>
                                        <td>${s.email}</td>
                                        <td style="width:250px">${s.name}</td>
                                        <td style="width:250px">${s.DOB }</td> 
                                        <td>${s.phone}</td>
                                        <td><input type="radio"  ${s.status==1?"checked":""}/></label></td>
                                        <td>${s.created_at}</td>
                                        <td>
                                            <a href="controllerAccount?idUser=${s.id}&type=lock"><i style="color:white" class="material-symbols-outlined">
                                                    lock
                                                </i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="controllerAccount?idUser=${s.id}&type=delete" >
                                                <i class="material-symbols-outlined tm-product-delete-icon">
                                                    delete
                                                </i>

                                            </a>
                                        </td>


                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <!-- table container -->


                </div>
            </div>




        </div>
    </div>


</div>
</div>
<footer class="tm-footer row tm-mt-small">
    <jsp:include page="footer.jsp"></jsp:include>

    </footer>

    <script src="/GuitarShop/admin/js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="/GuitarShop/admin/js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
    <script>
//            $(function () {
//                $(".tm-product-name").on("click", function ()
//                {
//                    window.location.href = "editProduct?idProduct=${s.id}";
//                });
//            });

        document.addEventListener("DOMContentLoaded", function () {
            var deleteLink = document.querySelector(".deleteLink");

            deleteLink.addEventListener("click", function (event) {
                event.preventDefault();

                var checkedCheckboxes = document.querySelectorAll('.productCheckbox:checked');
                var queryString = '';

                for (var i = 0; i < checkedCheckboxes.length; i++) {
                    queryString += 'idProduct=' + checkedCheckboxes[i].value;

                    // Thêm dấu & nếu chưa phải là giá trị cuối cùng
                    if (i < checkedCheckboxes.length - 1) {
                        queryString += '&';
                    }
                }

                var newUrl = "deleteProduct?" + queryString; // Thay thế 'deleteProducts' bằng đường dẫn của servlet hoặc trang xử lý

                window.location.href = newUrl;
            });
        });


</script>
</body>
</html>
