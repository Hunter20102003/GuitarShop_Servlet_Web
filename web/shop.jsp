<%-- 
    Document   : shop
    Created on : Feb 26, 2024, 6:28:55 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style>
            .checked {
                color: orange;
            }
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__text">
                                <h4>Shop</h4>
                                <div class="breadcrumb__links">
                                    <a href="home">Trang chủ</a>
                                    <span>Sản phẩm</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Shop Section Begin -->
            <section class="shop spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="shop__sidebar">
                                <div class="shop__sidebar__search">
                                    <form action="search" method="get">
                                        <input type="text" name="search" placeholder="Search products">
                                        <button type="submit"><span class="icon_search"></span></button>
                                    </form>

                                </div>



                                <div class="shop__sidebar__accordion">
                                    <div class="accordion" id="accordionExample">

                                        <div class="card">
                                            <div class="card-heading">
                                                <a data-toggle="collapse" data-target="#collapseOne">Thể loại</a>
                                            </div>
                                            <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                                <div class="card-body">
                                                    <div class="shop__sidebar__categories">

                                                        <ul class="nice-scroll">
                                                        <c:forEach var="a" items="${listCategories}">
                                                            <li ><a href="category?id=${a.id}" style="${a.id ==cateActive?"font-weight: bold;color:brown;":""}">${a.name}  </a></li>

                                                        </c:forEach>
                                                    </ul>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseTwo">Hãng sản xuất</a>
                                        </div>
                                        <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__brand">
                                                    <ul>
                                                        <c:forEach var="a" items="${listSuppliers}">
                                                            <li><a href="supplier?id=${a.id}" style="${supActive ==a.id?"font-weight:bold;color:brown":""}">${a.name}</a></li>

                                                        </c:forEach>


                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseThree">Filter</a>
                                        </div>
                                        <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__price">
                                                    <form action="filter" method="get">
                                                        <label for="category">Thể loại</label> <br>
                                                        <input type="checkbox" id="checkAllCategory" name="idCate" value="0" ${fn:contains(listCateId, 0) ==true? "checked" : ""}> All  <br>
                                                        <c:forEach var="category" items="${listCategories}">
                                                            <input type="checkbox" class="checkboxItemCategory" name="idCate" value="${category.id}" ${fn:contains(listCateId, category.id) ==true? "checked" : ""}> ${category.name} <br>
                                                        </c:forEach>
                                                        <br>
                                                        <label for="supplier">Hãng đàn</label> <br>
                                                        <input type="checkbox" id="checkAllSupplier" name="idSup" value="0" ${fn:contains(listSupId, 0) ? "checked" : ""}> All  <br>
                                                        <c:forEach var="supplier" items="${listSuppliers}">
                                                            <input type="checkbox" class="checkboxItemSupplier" name="idSup" value="${supplier.id}" ${fn:contains(listSupId, supplier.id) ? "checked" : ""}> ${supplier.name} <br>
                                                        </c:forEach>
                                                        <br>
                                                        <label for="price">Giá tiền</label> <br>
                                                        <input type="checkbox" id="checkAllPrice" name="idPrice" value="0" ${fn:contains(listPriceId,0)?"checked":""}> All  <br>
                                                        <input type="checkbox" class="checkboxItemPrice" name="idPrice" value="1" ${fn:contains(listPriceId,1)?"checked":""}> Dưới 5 triệu  <br>
                                                        <input type="checkbox" class="checkboxItemPrice" name="idPrice" value="2" ${fn:contains(listPriceId,2)?"checked":""}> 5 - 10 triệu  <br>
                                                        <input type="checkbox" class="checkboxItemPrice" name="idPrice" value="3" ${fn:contains(listPriceId,3)?"checked":""}> 10 - 20 triệu  <br>
                                                        <input type="checkbox" class="checkboxItemPrice" name="idPrice" value="4" ${fn:contains(listPriceId,4)?"checked":""}> Trên 20 triệu  <br>
                                                        <input type="submit" value="Lọc">
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>




                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="shop__product__option">
                            <div class="row">

                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__right">

                                        <form action="order" method="get" id="myForm">
                                            <label for="mySelect">Sắp xếp theo</label>
                                            <select id="mySelect" name="option" onchange="this.form.submit()">
                                                <option disabled selected hidden>-- Chọn --</option>
                                                <option value="1" ${option eq 1 ?"selected":""}>Mới nhất</option>
                                                <option value="2" ${option eq 2 ?"selected":""}>Giá giảm dần</option>
                                                <option value="3" ${option eq 3 ?"selected":""}>Giá tăng dần</option>
                                            </select>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach var="n" items="${listProduct}">
                                <c:if test="${n.status==1}">
                                    <div class="col-lg-4 col-md-6 col-sm-6">
                                        <div class="product__item sale">
                                            <div class="product__item__pic set-bg" >
                                                <a href="detail?id=${n.id}"><img src="${n.img}" alt="alt"/></a>
                                                    <c:choose>
                                                        <c:when test="${n.quantity>0 and n.discount>0}">
                                                        <span class="label" style="background-color:brown">Sale</span>
                                                    </c:when>
                                                    <c:when test="${n.quantity==0}">
                                                        <span class="label" style="background-color:black">Sold</span>
                                                    </c:when>
                                                </c:choose>
                                                <ul class="product__hover">
                                                    <li><a href="#"><img src="img/icon/heart.png" alt=""></a></li>

                                                </ul>
                                            </div>
                                            <div class="product__item__text">
                                                <h6>${n.name}</h6>
                                                <c:if test="${n.quantity>0}">
                                                    <a href="addCart?idProduct=${n.id}&quantity=1" class="add-cart">+ Add To Cart</a>
                                                </c:if>
                                                <c:set var="numOfStar" value="0"/>
                                                <c:set var="numOfReview" value="0"/>
                                                <c:forEach var="a" items="${listFeedback}">
                                                    <c:if test="${n.id eq a.idProduct}">
                                                        <c:set var="numOfStar" value="${numOfStar+a.rating}"/>
                                                        <c:set var="numOfReview" value="${numOfReview+1}"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:set var="average" value="${numOfStar!=0?numOfStar/numOfReview:0}"/>
                                                <div class="rating">
                                                    <c:forEach var="j" begin="1" end="5">
                                                        <c:choose>
                                                            <c:when test="${j<=average}">
                                                                 <span class="fa fa-star checked"></span>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span class="fa fa-star"></span>
                                                            </c:otherwise>
                                                        </c:choose>
                                                       

                                                    </c:forEach>
                                                    
                                                </div>

                                                <fmt:formatNumber var="format" pattern="#,###" value="${n.price-(n.price*n.discount)}" />
                                                <h5>${format}đ </h5>
                                            </div>

                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                            <c:if test="${emptyProduct!=null}">
                                <p>${emptyProduct}</p>
                            </c:if>


                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="product__pagination">
                                    <c:forEach var="i" begin="1" end="${numberOfPage}">
                                        <a class="${i == idPage?"active":""}" href="pagging?idPage=${i}">${i}</a>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Section End -->

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
        <!-- Search End -->s


        <script>






            document.addEventListener('DOMContentLoaded', function () {
                function handleCheckAllCheckbox(checkAll, checkboxes) {
                    checkAll.addEventListener('change', function () {
                        checkboxes.forEach(function (item) {
                            item.checked = checkAll.checked;
                            item.disabled = checkAll.checked;
                        }
                        );
                    }
                    );

                    checkboxes.forEach(function (item) {
                        item.addEventListener('change', function () {
                            if (this.checked) {
                                checkAll.checked = false;
                            }
                        }
                        );
                    }
                    );
                }

                // Category checkboxes
                const checkAllCategory = document.getElementById('checkAllCategory');
                const checkboxItemsCategory = document.querySelectorAll('.checkboxItemCategory');
                handleCheckAllCheckbox(checkAllCategory, checkboxItemsCategory);

                // Supplier checkboxes
                const checkAllSupplier = document.getElementById('checkAllSupplier');
                const checkboxItemsSupplier = document.querySelectorAll('.checkboxItemSupplier');
                handleCheckAllCheckbox(checkAllSupplier, checkboxItemsSupplier);

                // Price checkboxes
                const checkAllPrice = document.getElementById('checkAllPrice');
                const checkboxItemsPrice = document.querySelectorAll('.checkboxItemPrice');
                handleCheckAllCheckbox(checkAllPrice, checkboxItemsPrice);
            }
            );




        </script>
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
