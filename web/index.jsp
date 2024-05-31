<%-- 
    Document   : index
    Created on : Feb 26, 2024, 6:28:25 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

            <!-- Guitar Section Begin -->
            <section class="hero">
                <div class="hero__slider owl-carousel">

                    <div class="hero__items set-bg" data-setbg="banner/bn2.jpg">  </div>   
                    <div class="hero__items set-bg" data-setbg="banner/bn3.jpg">  </div>     
                    <div class="hero__items set-bg" data-setbg="banner/bn1.jpg">  </div>   




                </div>
            </section>
            <!-- Hero Section End -->

            <!-- Banner Section Begin -->
            <section class="banner spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-7 offset-lg-4">
                            <div class="banner__item">
                                <div class="banner__item__pic">
                                    <img src="https://vietthuong.vn/image/cache/catalog/cordoba/cordoba-C1M-CE-01-450x471.jpg" alt="">
                                </div>
                                <div class="banner__item__text">
                                    <h2>Guitar classic</h2>
                                    <a href="category?id=1">Shop now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-5">
                            <div class="banner__item banner__item--middle">
                                <div class="banner__item__pic">
                                    <img src="https://vietmusic.vn/cdn/shop/files/dan-guitar-acoustic-yamaha-f370-f-series-viet-music.jpg?v=1694462610&width=823" alt="">

                                </div>
                                <div class="banner__item__text">
                                    <h2>Guitar acoustic</h2>
                                    <a href="category?id=3">Shop now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-7">
                            <div class="banner__item banner__item--last">
                                <div class="banner__item__pic">
                                    <img src="https://vietmusic.vn/cdn/shop/files/dan-guitar-dien-gibson-les-paul-standard-60s-figured-top-ocean-blue-qua-su-dung-viet-music.jpg?v=1696125692&width=823" alt="">

                                </div>
                                <div class="banner__item__text">
                                    <h2>Guitar electric</h2>
                                    <a href="category?id=2">Shop now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Banner Section End -->

            <!-- Product Section Begin -->
            <section class="product spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <ul class="filter__controls">
                                <li class="active" data-filter="*">Best Sellers</li>
                                <li data-filter=".new-arrivals">New Arrivals</li>
                                <li data-filter=".hot-sales">Hot Sales</li>
                            </ul>
                        </div>
                    </div>
                    <div class="row product__filter">
                    <c:set var ="n" value="${newProduct}"/>
                    <c:set var ="s" value="${saleProduct}"/>
                    <c:forEach var="i" begin="1" end="8">
                        <fmt:formatNumber var="nf" value="${n.get(i-1).price}" pattern="#,###"/>
                        <fmt:formatNumber var="sf"  value="${s.get(i-1).price}" pattern="#,###"/>
                        <c:if test="${i%2!=0}">
                            <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg">
                                        <a href="detail?id=${n.get(i-1).id}"><img src="${n.get(i-1).img}" alt="alt"/></a>
                                        <span class="label" style="background-color:orange;color:white">New</span>
                                        <ul class="product__hover">
                                            <li><a href="#"><img src="img/icon/heart.png" alt=""></a></li>
                                            <li><a href="#"><img src="img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                                            <li><a href="#"><img src="img/icon/search.png" alt=""></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6>${n.get(i-1).name}</h6>
                                        <a href="detail" class="add-cart">+ Add To Cart</a>
                                        <div class="rating">
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                        </div>
                                        <h5>${nf}đ</h5>
                                        <div class="product__color__select">
                                            <label for="pc-1">
                                                <input type="radio" id="pc-1">
                                            </label>
                                            <label class="active black" for="pc-2">
                                                <input type="radio" id="pc-2">
                                            </label>
                                            <label class="grey" for="pc-3">
                                                <input type="radio" id="pc-3">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${i%2==0}">
                            <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix hot-sales">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" >
                                        <a href="detail?id=${s.get(i-1).id}"><img src="${s.get(i-1).img}" alt="alt"/></a>
                                        <span class="label" style="background-color:brown;color:white">Sale</span>
                                        <ul class="product__hover">
                                            <li><a href="#"><img src="img/icon/heart.png" alt=""></a></li>
                                            <li><a href="#"><img src="img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                                            <li><a href="#"><img src="img/icon/search.png" alt=""></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6>${s.get(i-1).name}</h6>
                                        <a href="#" class="add-cart">+ Add To Cart</a>
                                        <div class="rating">
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                        </div>
                                        <h5>${sf}đ</h5>
                                        <div class="product__color__select">
                                            <label for="pc-4">
                                                <input type="radio" id="pc-4">
                                            </label>
                                            <label class="active black" for="pc-5">
                                                <input type="radio" id="pc-5">
                                            </label>
                                            <label class="grey" for="pc-6">
                                                <input type="radio" id="pc-6">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if >
                    </c:forEach>


                </div>
            </div>
        </section>
        <!-- Product Section End -->

        <!-- Categories Section Begin -->
        <section class="categories spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="categories__text">
                            <h2>Clothings Hot <br /> <span>Shoe Collection</span> <br /> Accessories</h2>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="categories__hot__deal">
                            <img src="img/big-sale/product-sale.png" alt="">
                            <div class="hot__deal__sticker">
                                <span>Sale</span>
                                <fmt:formatNumber var="formattedValue" type="number" pattern="#" value="${SaleProduct.discount*100}" />
                                <h5>${formattedValue}%</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 offset-lg-1">
                        <div class="categories__deal__countdown">
                            <span>Deal Of The Month</span>
                            <h2>${SaleProduct.name}</h2>
                            <fmt:formatNumber var="oldPrice" pattern="#,###" value="${SaleProduct.price}" />
                            <fmt:formatNumber var="newPrice" pattern="#,###" value="${SaleProduct.price-(SaleProduct.price*SaleProduct.discount)}" />
                            <del style="color:gray;font-size:20px">${oldPrice}đ</del>
                            <span style="display:inline ;color:black;font-size:30px">${newPrice}đ</span>

                            <div class="categories__deal__countdown__timer" id="countdown">
                                <div class="cd-item">
                                    <span>3</span>
                                    <p>Ngày</p>
                                </div>
                                <div class="cd-item">
                                    <span>1</span>
                                    <p>Giờ</p>
                                </div>
                                <div class="cd-item">
                                    <span>50</span>
                                    <p>Phút</p>
                                </div>
                                <div class="cd-item">
                                    <span>18</span>
                                    <p>Giây</p>
                                </div>
                            </div>
                            <a href="detail?id=${SaleProduct.id}" class="primary-btn">Mua ngay</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Instagram Section Begin -->

        <!-- Instagram Section End -->

        <!-- Latest Blog Section Begin -->

        <!-- Latest Blog Section End -->

        <!-- Footer Section Begin -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer Section End -->

        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>


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