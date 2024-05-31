<%-- 
    Document   : add_product
    Created on : Mar 3, 2024, 12:48:46 AM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Add Product - Dashboard HTML Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="/GuitarShop/admin/jquery-ui-datepicker/jquery-ui.min.css" type="text/css" />
        <!-- http://api.jqueryui.com/datepicker/ -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container tm-mt-big tm-mb-big">
                <div class="row">
                    <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                        <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="tm-block-title d-inline-block">Thêm sản phẩm</h2>
                                </div>
                            </div>
                            <h6 style="color:red">${pExist}</h6>

                        <div class="row tm-edit-product-row">
                            <div class="col-xl-6 col-lg-6 col-md-12">

                                <form action="/GuitarShop/add" method="post" class="tm-edit-product-form" enctype="multipart/form-data">

                                    <div class="form-group mb-3">
                                        <label
                                            for="name"
                                            >Tên sản phẩm
                                        </label>
                                        <input
                                            id="name"
                                            value="${name}"
                                            name="name"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <h6 style="color: red">${numError}</h6>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="price"
                                                >Giá tiền
                                            </label>
                                            <input
                                                id="price"
                                                name="price"
                                                type="text"
                                                value="${price}"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="description"
                                            >Mô tả</label
                                        >
                                        <textarea
                                            id="description"
                                            name="des"

                                            class="form-control validate"
                                            value="${des}"
                                            rows="3"
                                            required
                                            ></textarea>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="supplier"
                                            >Nhà cung cấp</label>
                                        <select
                                            class="custom-select tm-select-accounts"
                                            id="supplier"
                                            name="idSup"
                                            >
                                            <c:forEach var ="i" items="${listSup}">
                                                <option value="${i.id}" ${i.id eq idSup?"selected":""}>${i.name}</option>
                                            </c:forEach>

                                        </select>
                                    </div>

                                    <div class="form-group mb-3">
                                        <label
                                            for="category"
                                            >Thể loại</label>
                                        <select
                                            class="custom-select tm-select-accounts"
                                            id="category"
                                            name="idCate"
                                            >
                                            <c:forEach var ="i" items="${listCate}">
                                                <option value="${i.id}" ${i.id eq idCate?"selected":""}>${i.name}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                    <h6 style="color: red">${numError1}</h6>
                                    <div class="row">

                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="discount"
                                                >Giảm giá
                                            </label>
                                            <input
                                                id="discount"
                                                name="discount"
                                                value="${discount}"
                                                type="text"
                                                class="form-control validate"
                                                data-large-mode="true"
                                                required

                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="stock"
                                                >Số lượng
                                            </label>
                                            <input
                                                id="stock"
                                                name="quantity"
                                                type="number"
                                                value="${quantity}"
                                                class="form-control validate"
                                                min="0"
                                                required
                                                />
                                        </div>
                                    </div>

                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                <h6 style="color:red">${null_img}</h6>
                                <div class="tm-product-img-dummy mx-auto">
                                    <i class="fas fa-cloud-upload-alt tm-upload-icon" onclick="document.getElementById('fileInput').click();"></i>
                                </div>
                                <div class="custom-file mt-3 mb-3">
                                    <input id="fileInput" type="file" name="file" style="display:none;" accept="image/*" onchange="previewImage(event);">
                                    <input type="button" name="file" class="btn btn-primary btn-block mx-auto" value="Thêm ảnh" onclick="document.getElementById('fileInput').click();">
                                </div>
                            </div>
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary btn-block text-uppercase">Thêm sản phẩm</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="tm-footer row tm-mt-small">
            <jsp:include page="footer.jsp"></jsp:include>
        </footer> 
        <script>
            function previewImage(event) {
                var file = event.target.files[0];
                var reader = new FileReader();

                reader.onload = function (event) {
                    var img = document.createElement('img');
                    img.src = event.target.result;
                    img.alt = "Preview Image";
                    img.style.maxWidth = "350px";
                    img.style.maxHeight = "350px";

                    var dummyDiv = document.querySelector('.tm-product-img-dummy');
                    dummyDiv.innerHTML = ''; // Xóa nội dung cũ đi
                    dummyDiv.appendChild(img); // Thêm ảnh mới vào
                };

                reader.readAsDataURL(file);
            }
        </script>
        <script src="/GuitarShop/admin/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="/GuitarShop/admin/jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="/GuitarShop/admin/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->

    </body>
</html>

