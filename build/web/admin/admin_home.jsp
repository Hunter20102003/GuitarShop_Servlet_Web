<%-- 
    Document   : admin_home
    Created on : Mar 3, 2024, 12:52:59 AM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Product Admin - Dashboard HTML Template</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/fontawesome.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/bootstrap.min.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="/GuitarShop/admin/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        >
        -->
        <style>.tm-block {
    padding: 40px;
    -webkit-box-shadow: 1px 1px 5px 0 #455c71;
    -moz-box-shadow: 1px 1px 5px 0 #455c71;
    box-shadow: 1px 1px 5px 0 #455c71;
    min-height: 160px;
    height: 100%;
    max-height: 450px;
}</style>
    </head>

    <body id="reportsPage">
        <div class="" id="home">
            <jsp:include page="header.jsp"></jsp:include>
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <p class="text-white mt-5 mb-5">Welcome back, <b>Admin</b></p>
                        </div>
                    </div>
                    <!-- row -->
                    <div class="row tm-content-row">


                        <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                            <div class="tm-bg-primary-dark tm-block tm-block-taller">
                            <fmt:formatNumber var="i" pattern="#,###" value="${total}"/>
                            <div style="text-align: center;">
                                <h1 class="tm-block-title">Tổng doanh số</h1>
                                <h2 class="tm-block-title">${i}đ</h2>
                            </div>


                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-overflow">
                            <div style="text-align: center;">
                                <h1 class="tm-block-title">Lượt mua</h1>
                                <h2 class="tm-block-title">${purchases}</h2>
                            </div>

                        </div>
                    </div>
                    <div class="col-12 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                            <h2 class="tm-block-title">Danh sách đặt hàng</h2>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">Tài khoản</th>
                                        <th scope="col">Địa chỉ</th>
                                        <th scope="col">Số điện thoại</th>
                                        <th scope="col">Phương thức</th>
                                        <th scope="col">Ngày đặt hàng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="o" items="${orders}">
                                        <tr>
                                            <th scope="row"><b>${o.id}</b></th>
                                            <td>


                                                </div>${o.status}
                                            </td>
                                            <td><b>${o.user.username}</b></td>
                                            <td><b>${o.address}</b></td>
                                            <td><b>${o.phone}</b></td>
                                            <td>${o.payment}</td>
                                            <td>${o.orderDate}</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="tm-footer row tm-mt-small">
                <jsp:include page="footer.jsp"></jsp:include>
            </footer>


        </div>

        <script src="/GuitarShop/admin/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="/GuitarShop/admin/js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="/GuitarShop/admin/js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="/GuitarShop/admin/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="/GuitarShop/admin/js/tooplate-scripts.js"></script>
        <script>
            Chart.defaults.global.defaultFontColor = 'white';
            let ctxLine,
                    ctxBar,
                    ctxPie,
                    optionsLine,
                    optionsBar,
                    optionsPie,
                    configLine,
                    configBar,
                    configPie,
                    lineChart;
            barChart, pieChart;
            // DOM is ready
            $(function () {
                drawLineChart(); // Line Chart
                drawBarChart(); // Bar Chart
                drawPieChart(); // Pie Chart

                $(window).resize(function () {
                    updateLineChart();
                    updateBarChart();
                });
            })
        </script>
    </body>

</html>
