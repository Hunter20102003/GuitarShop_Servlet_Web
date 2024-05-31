<%-- 
   Document   : shopping-cart
   Created on : Feb 26, 2024, 6:29:30 PM
   Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sungha Jung Guitar</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Header Section End -->

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__text">
                                <h4>Lịch sử mua hàng</h4>
                                <div class="breadcrumb__links">
                                    <a href="home">Trang chủ</a>
                                    <a href="shop">Sản phẩm</a>
                                    <span>Đơn hàng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Shopping Cart Section Begin -->
            <section class="shopping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-11">
                            <div class="shopping__cart__table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Sản phẩm</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Giá</th>
                                            <th>Trạng thái</th>
                                            <th>Đánh giá</th>
                                            <th></th>

                                        </tr>
                                    </thead>
                                    <tbody>




                                    <c:forEach var="i" items="${listBought}">

                                        <c:forEach var="j" items="${i.listOrderDetail}">
                                            <fmt:formatNumber var ="fm" value="${j.total_price}" pattern="#,###"/>

                                            <tr>
                                                <td><img src="${j.product.img}" alt="alt" style="width:120px"/></td>
                                                <td>${j.product.name}</td>
                                                <td>${j.quantity}</td>
                                                <td>${fm}đ</td>
                                                <c:choose>
                                                    <c:when test="${i.status eq 'hoàn thành'}"><td style="color:green">${i.status}</td></c:when>
                                                    <c:when test="${i.status eq 'đang giao' }"><td style="color:orange">${i.status}</td></c:when>
                                                    <c:otherwise><td style="color:red">${i.status}</td></c:otherwise>

                                                </c:choose>
                                                <td>
                                                    <div class="row">
                                                        <div class="col-lg-8 col-md-8 col-sm-8">
                                                            <div class="continue__btn">
                                                                <a style="display: contents;" href="review?idPro=${j.product.id}"><u>Đánh giá</u></a>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </td>



                                            </tr>
                                        </c:forEach>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div style="color:red;margin-top: 20px ;text-align:center"> 
                                <c:if test="${listBought==null}">
                                    ${emptyProduct}
                                </c:if>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </section>
        <!-- Shopping Cart Section End -->

        <!-- Footer Section Begin -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer Section End -->

        <!-- Search Begin -->
        <!--    <div class="search-model">
                <div class="h-100 d-flex align-items-center justify-content-center">
                    <div class="search-close-switch">+</div>
                    <form class="search-model-form">
                        <input type="text" id="search-input" placeholder="Search here.....">
                    </form>
                </div>
            </div>-->
        <!-- Search End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>
