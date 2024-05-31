<%-- 
    Document   : newjsp
    Created on : Feb 28, 2024, 11:43:37 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zxx">
    <head>
        <meta charset="UTF-8">
       
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
    


<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__option">
        <div class="offcanvas__links">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <a href="#">
                        <img src="${sessionScope.user.avatar}" alt="Avatar" style="width: 30px; height: 30px; border-radius: 50%; overflow: hidden;" />
                        ${sessionScope.user.username}


                    </a>

                </c:when>
                <c:otherwise>
                    <a href="login.jsp">Đăng nhập</a>

                </c:otherwise>
            </c:choose>





        </div>

    </div>
    <div class="offcanvas__nav__option">
        <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
        <a href="#"><img src="img/icon/heart.png" alt=""></a>
        <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
        <div class="price">Giỏ hàng</div>
    </div>
    <div id="mobile-menu-wrap"></div>
    <div class="offcanvas__text">
        <p>Miễn phí vận chuyển, đảm bảo hoàn trả hoặc hoàn tiền trong 30 ngày.</p>
    </div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7">
                    <div class="header__top__left">
                        <p>Miễn phí vận chuyển, đảm bảo hoàn trả hoặc hoàn tiền trong 30 ngày.</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <c:choose>
                                <c:when test="${sessionScope.user != null}">

                                    <div class="header__top__hover">
                                        <span><img src="${sessionScope.user.avatar}" alt="Avatar" style="width: 30px; height: 30px; border-radius: 50%; overflow: hidden;" />
                                            ${sessionScope.user.username}
                                        </span>
                                        <ul>
                                            <li><a href="info" style="color:black">Tài khoản</a></li>
                                            <li><a href="history" style="color:black">Đơn hàng</a></li>
                                            <li><a href="login?signout=1" style="color:black">Đăng xuất</a></li>
                                        </ul>
                                    </div>


                                </c:when>
                                <c:otherwise>
                                    <a href="login.jsp">Đăng nhập</a>
                                </c:otherwise>
                            </c:choose>


                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="home"><img src="img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>

                        <li class="${active eq "home" ? "active" : ''}"><a href="home">Trang chủ</a></li>
                        <li class="${active eq "shop" ? "active" : ''}"><a href="shop">Sản phẩm</a></li>
                        <li class="${active eq "page" ? 'active' : ''}"><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                <li><a href="./checkout.html">Check Out</a></li>

                            </ul>
                        </li>
                        <li class="${active eq "about" ? "active" : ''}"><a href="about.jsp">Giới thiệu</a></li>
                        <li class="${active eq "contact" ? "active" : ''}"><a href="./contact.jsp">Liên hệ</a></li>
                            <c:if test="${sessionScope.admin!=null}">
                            <li><a href="adminHome">Quản lý</a></li>
                            </c:if>

                    </ul>

                </nav>

            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                    <a href="#"><img src="img/icon/heart.png" alt=""></a>
                    <a href="cart"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
                    <div class="price">Giỏ hàng</div>
                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->

</html>