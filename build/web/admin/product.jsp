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
        <title>Product Page - Admin HTML Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
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
                                        <th scope="col">&nbsp;</th>

                                        <th scope="col" style="width: 25%;">Tên sản phẩm</th>                                    
                                        <th scope="col">Giá bán</th>  
                                        <th scope="col">Thể loại</th>  
                                        <th scope="col">Thương hiệu</th>  
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Giảm giá</th>
                                        <th scope="col">Trạng thái</th>                                 
                                        <th scope="col">Sửa</th>
                                        <th scope="col">Xóa</th>
                                        <th scope="col">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                ${listProEmpty}

                                <c:forEach var="s" items="${listPro}">
                                    <fmt:formatNumber var="a" pattern="#,###" value="${s.price}"/>

                                    <tr>
                                        <th scope="row"><input type="checkbox" class="productCheckbox" name="idProduct" value="${s.id}" /></th>
                                        <td >${s.name}</td>
                                        <td>${a}đ</td>
                                        <td>${s.category.name}</td>
                                        <td>${s.supplier.name}</td>
                                        <td>${s.quantity}</td>
                                        <td>${s.discount}</td>
                                        <td><input type="radio"  ${s.status==1?"checked":""}/></label></td>
                                        <td>
                                            <a href="editProduct?idProduct=${s.id}" > 
                                                <i class="material-symbols-outlined tm-product-delete-icon">
                                                    edit
                                                </i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="deleteProduct?idProduct=${s.id}" >
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
                    <a
                        href="add"
                        class="btn btn-primary btn-block text-uppercase mb-3">
                        Thêm sản phẩm mới
                    </a>
                    <a 
                        href="ok"
                        class="deleteLink btn btn-primary btn-block text-uppercase " >
                        Xóa các sản phẩm đã chọn
                    </a>

                </div>
            </div>

            <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
                <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
                    <h2 class="tm-block-title">Nhà cung cấp</h2>
                    <div class="tm-product-table-container">
                        <table class="table tm-table-small tm-product-table">
                            <tbody>
                                ${listSupEmpty}
                                <c:forEach var="i" items="${listSup}">
                                    <tr>
                                        <td class="tm-product-name">${i.name}</td>
                                        <td class="text-center">
                                            <a href="editProduct?idProduct=${s.id}" > 
                                                <i class="material-symbols-outlined tm-product-delete-icon">
                                                    edit
                                                </i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- table container -->
                    <form action="addcs" method="post">
                        <div class="form-group mb-3">

                            <input
                                name="name"
                                type="text"
                                class="form-control validate"
                                required
                                />
                        </div>
                        <input type="text" name="type"value="supplier" hidden>
                        
                        <input class="btn btn-primary btn-block text-uppercase mb-3" type="submit" value="Thêm nhà cung cấp mới">

                    </form>
                </div>
            </div> 

            <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
                <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
                    <h2 class="tm-block-title">Thể loại</h2>
                    <div class="tm-product-table-container">
                        <table class="table tm-table-small tm-product-table">
                            <tbody>
                                ${listCateEmpty}
                                <c:forEach var="i" items="${listCate}">
                                    <tr>

                                        <td class="tm-product-name">${i.name}</td>
                                        <td class="text-center">
                                            <a href="editProduct?idProduct=${s.id}" > 
                                                <i class="material-symbols-outlined tm-product-delete-icon">
                                                    edit
                                                </i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- table container -->
                    <form action="addcs" method="post">
                        <div class="form-group mb-3">

                            <input
                                name="name"
                                type="text"
                                class="form-control validate"
                                required
                                />
                        </div>
                        <input type="text" name="type" value="category" hidden>

                        <input class="btn btn-primary btn-block text-uppercase mb-3" type="submit" value="Thêm thể loại mới">

                    </form>

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
