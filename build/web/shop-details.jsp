<%-- 
    Document   : shop-details
    Created on : Feb 26, 2024, 6:29:19 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sungha Jung Guitar Center</title>

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
        <style>.avatar {
                width: 35px; /* Đặt chiều rộng mong muốn */
                height: 35px; /* Đặt chiều cao mong muốn */
                border-radius: 50%; /* Đặt giá trị border-radius là 50% để biến hình chữ nhật thành hình tròn */
                overflow: hidden; /* Ẩn phần ảnh vượt ra khỏi hình tròn */
            }
     
            .checked {
                color: orange;
            }
            .avatar{
                margin-right: 20px;
            }
        
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Header Section End -->

            <!-- Shop Details Section Begin -->
            <section class="shop-details">
                <div class="product__details__pic">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="product__details__breadcrumb">
                                    <a href="home">Trang chủ</a>
                                    <a href="shop">Sản phẩm</a>
                                    <span>Chi tiết sản phẩm</span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        <c:set var="s" value="${productDetail}" />
                        <div class="col-lg-3 col-md-3">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">
                                        <div class="product__thumb__pic set-bg" data-setbg="">
                                            <img src="${s.img}" alt="alt"/>
                                        </div>
                                    </a>
                                </li>


                            </ul>
                        </div>
                        <div class="col-lg-6 col-md-9">
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__pic__item">
                                        <img src="${s.img}" alt="">
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-2" role="tabpanel">
                                    <div class="product__details__pic__item">
                                        <img src="img/shop-details/product-big-3.png" alt="">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="product__details__content">
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="col-lg-8">
                            <div class="product__details__text">
                                <h4>${s.name}</h4>
                                <c:set var="sumStar" value="0"/>
                                <c:set var="numFeedback" value="0"/>

                                <c:forEach var="i" items="${ProductFeedback}">
                                    <c:set var="sumStar" value="${sumStar+i.rating}"/>
                                    <c:set var="numFeedback" value="${numFeedback+1}"/>
                                </c:forEach>
                                <c:set var="average" value="${sumStar>0?sumStar/numFeedback:0}"/>
                                <div class="rating">
                                    <c:forEach var="star" begin="1" end="5">
                                        <c:choose >
                                            <c:when test="${star<=average}">
                                                <i class="fa fa-star"></i>
                                            </c:when>
                                            <c:otherwise>
                                                <i class="fa fa-star-o"></i>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <span> - ${numFeedback} Reviews</span>         
                                </div>



                                <fmt:formatNumber var="newPrice" pattern="#,###" value="${s.price-(s.price*s.discount)}" />

                                <h3>${newPrice}đ 
                                    <c:if test="${s.discount>0}">
                                        <fmt:formatNumber var="oldPrice" pattern="#,###" value="${s.price}" />

                                        <span>${oldPrice}đ</span>
                                    </c:if> </h3>


                                <div class="product__details__option">
                                    <div class="product__details__option__size">
                                        <c:if test="${s.quantity==0}"><div style="color: red;">(Hết hàng)</div></c:if>
                                            <span>Số lượng</span>
                                            <label >${s.quantity}                       
                                        </label>


                                    </div>


                                </div>
                                <c:choose>
                                    <c:when test="${s.quantity == 0}">

                                        <div class="product__details__cart__option">
                                            <form method="post" action="addCart">
                                                <div class="quantity">
                                                    <div class="pro-qt">
                                                        <input type="number" name="quantity"  value=0 min="0" max="0">
                                                    </div>
                                                </div>
                                                <input type="number" name="idProduct" value="${s.id}" hidden>
                                                <input type="submit" value="Thêm vào giỏ hàng" style="background-color: gray"class="primary-btn" disabled >

                                            </form>


                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="product__details__cart__option">
                                            <form method="post" action="addCart">
                                                <div class="quantity">
                                                    <div class="pro-qt">
                                                        <input type="number" name="quantity"  value=1 min="1" max=${s.quantity}>
                                                    </div>
                                                </div>
                                                <input type="number" name="idProduct" value="${s.id}" hidden>
                                                <input type="submit" value="Thêm vào giỏ hàng" class="primary-btn" >

                                            </form>


                                        </div>
                                    </c:otherwise>
                                </c:choose>

                                <div class="product__details__last__option">
                                    <h5><span>Phương thức thanh toán</span></h5>
                                    <img src="img/shop-details/details-payment.png" alt="">
                                    <ul>

                                        <li><span>Thể loại:</span> ${s.category.name}</li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product__details__tab">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" data-toggle="tab" href="#tabs-5"
                                           role="tab">Mô tả</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabs-6" role="tab">Đánh giá</a>
                                    </li>

                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tabs-5" role="tabpanel">
                                        <div class="product__details__tab__content">

                                            <div class="product__details__tab__content__item">
                                                <h5>Thông tin sản phẩm</h5>
                                                <p>${s.description}</p>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tabs-6" role="tabpanel">
                                        <div class="product__details__tab__content">
                                            <c:forEach var="i" items="${ProductFeedback}">
                                                <c:forEach var="j" items="${allUser}">
                                                    <c:if test="${i.idUser eq j.id}">
                                                        <table>
                                                            <tbody>
                                                                <tr>
                                                                    <td><img class="avatar" src="${j.avatar}" alt="alt"/></td>
                                                                    <td><span class="label">${j.username}</span></td>
                                                                </tr>
                                                                <tr>
                                                                    <td></td>
                                                                    <td><span class="product__details__text"><span class=" rating">
                                                                                <c:forEach var="o" begin="1" end="5">
                                                                                    <c:choose>
                                                                                        <c:when test="${o<=i.rating}">
                                                                                            <i class="fa fa-star"></i>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <i class="fa fa-star-o"></i>
                                                                                        </c:otherwise>
                                                                                    </c:choose>

                                                                                </c:forEach>
                                                                            </span> </span> 
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td></td>
                                                                    <td>${i.feedback}</td>
                                                                </tr>

                                                                <tr>
                                                                    <td></td>
                                                                    <td>${i.date}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>

                                                    </c:if>

                                                </c:forEach>
                                            </c:forEach>
                                            <div class="product__details__tab__content__item">

                                            </div>

                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Details Section End -->

        <!-- Related Section Begin -->
        <section class="related spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h3 class="related-title">Sản phẩm liên quan</h3>
                    </div>
                </div>
                <div class="row">
                    <c:forEach var="s" items="${listRelatedProduct}" begin="0" end="7">
                        <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                            <div class="product__item sale">
                                <div class="product__item__pic set-bg">
                                    <a href="detail?id=${s.id}"><img src="${s.img}" alt="alt"/></a>
                                        <c:if test="${s.discount>0}">
                                        <span class="label">Sale</span></c:if>

                                    </div>
                                    <div class="product__item__text">
                                        <h6>${s.name}</h6>
                                    

                                    <a href="addCart?idProduct=${s.id}&quantity=1" class="add-cart">+ Add To Cart</a>
                                    <c:set var="numOfStar" value="0"/>
                                    <c:set var="numOfReview" value="0"/>
                                    <c:forEach var="a" items="${allProductFeedback}">
                                        <c:if test="${s.id eq a.idProduct}">
                                            <c:set var="numOfStar" value="${numOfStar+a.rating}"/>
                                            <c:set var="numOfReview" value="${numOfReview+1}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:set var="average" value="${numOfStar!=0?numOfStar/numOfReview:0}"/>
                                    <div class="rating">
                                        <c:forEach var="j" begin="1" end="5">
                                            <c:choose>
                                                <c:when test="${j<=average}"><span class="fa fa-star checked"></span></c:when>
                                                <c:otherwise> <span class="fa fa-star "></span></c:otherwise>
                                            </c:choose> 
                                             

                                        </c:forEach>
                                        
                                    </div>
                                  
<!--                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star-o"></i>
                                    </div>-->
                                    <fmt:formatNumber var="format" pattern="#,###" value="${s.price}" />
                                    <h5>${format}đ </h5>


                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </section>
        <!-- Related Section End -->

        <!-- Footer Section Begin -->
        <jsp:include page="footer.jsp"></jsp:include>
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
