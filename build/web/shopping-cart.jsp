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
                                <h4>Shopping Cart</h4>
                                <div class="breadcrumb__links">
                                    <a href="home">Trang chủ</a>
                                    <a href="shop">Sản phẩm</a>
                                    <span>Giỏ hàng</span>
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
                        <div class="col-lg-8">
                            <div class="shopping__cart__table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Giá</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <c:set var="listItem" value="${cart.items}"/>
                                <div> <c:if test="${listItem==null}">
                                        ${emptyProduct}
                                    </c:if>
                                </div>
                                <c:forEach var="i" items="${listItem}">
                                    <c:choose>
                                        <c:when test="${i.product.quantity==0}">
                                            <tr>

                                                <td class="product__cart__item">

                                                    <div class="product__cart__item__text">
                                                        <fmt:formatNumber var="price" pattern="#,###" value="${i.product.price}"/>
                                                        <h6>${i.product.name}<span style="color:red">(Hết hàng)</span></h6>
                                                        <h5>${price}đ</h5>
                                                    </div>

                                                </td>

                                                <td class="quantity__item">
                                                    <div class="quantity">
                                                        <div >
                                                            <a href="###"><button type="submit"> - </button></a>
                                                            0
                                                            <a href="###"><button type="submit"> +</button></a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <fmt:formatNumber var="pr" pattern="#,###" value="${i.price}"/>
                                                <td class="cart__price">0đ</td>
                                                <td class="cart__close"><a href="cartProcess?type=1&id=${i.product.id}"><i class="fa fa-close"></i></a></td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>

                                                <td class="product__cart__item">

                                                    <div class="product__cart__item__text">
                                                        <fmt:formatNumber var="price" pattern="#,###" value="${i.product.price}"/>
                                                        <h6>${i.product.name}</h6>
                                                        <h5>${price}đ</h5>
                                                    </div>

                                                </td>

                                                <td class="quantity__item">
                                                    <div class="quantity">
                                                        <div >
                                                            <a href="cartProcess?type=0&id=${i.product.id}&quantity=${i.quantity}&number=-1"><button type="submit"> - </button></a>
                                                            ${i.quantity}
                                                            <a href="cartProcess?type=0&id=${i.product.id}&quantity=${i.quantity}&number=+1"><button type="submit"> +</button></a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <fmt:formatNumber var="pr" pattern="#,###" value="${i.price}"/>
                                                <td class="cart__price">${pr}đ</td>
                                                <td class="cart__close"><a href="cartProcess?type=1&id=${i.product.id}"><i class="fa fa-close"></i></a></td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="continue__btn">
                                    <a href="shop">Tiếp tục mua sắm</a>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="cart__discount">
                            <h6>Mã giảm giá</h6>
                            <form action="cart">
                                <input type="text" name="code" placeholder="Coupon code">
                                <button type="submit">Áp mã</button>
                            </form>
                        </div>
                        <div class="cart__total">
                            <h6>Tổng</h6>
                            <ul>
                                <fmt:formatNumber var="total" pattern="#,###" value="${cart.getTotalMoney()}"/>
                                <li>Tổng tiền hàng<span>${total}đ</span></li>
                                <li>Giảm giá <span>0đ</span></li>
                                <li>Thành tiền <span>${total}đ</span></li>
                            </ul>
                            <c:choose>
                                <c:when test="${user ==null}"> 
                                    <a href="login.jsp" class="primary-btn">Thanh toán</a>
                                </c:when>
                                <c:otherwise>
                                     <a href="home" class="primary-btn">Thanh toán</a>
                                </c:otherwise>
                            </c:choose>
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
