<%-- 
    Document   : account
    Created on : Mar 3, 2024, 12:48:09 AM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Accounts - Product Admin Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="admin/css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="admin/css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="admin/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            /* Ẩn checkbox */
            .star-checkbox {
                display: none;
            }

            /* Định dạng hình sao */
            .star-label {
                cursor: pointer;
                font-size: 24px;
            }

            /* Màu sao đã chọn */
            .star-checkbox:checked + .star-label {
                color: orange;
            }

        </style>
    </head>
    <%@include file="header.jsp" %>
    <body id="reportsPage">
        <div class="" id="home">

            <div class="container mt-5">

                <div class="row tm-content-row">


                    <div class="tm-block-col tm-col-account-settings">
                        <div class="tm-bg-primary-dark tm-block tm-block-settings">
                            <div style="color:green">${updateInfoSuccess}</div>
                             
                            <c:set var="product" value="${product}"/>
                           

                            <form action="review" method="post" class="tm-signup-form-review row">
                                <div class="form-group col-lg-6">
                                    <input type="text" name="idProduct" value="${product.id}" hidden>
                                    <div style="color:orange"> ${success} </div>
                                   
                                    <label for="review"> <h2 class="tm-block-title">Đánh giá sản phẩm</h2></label>
                                    <textarea id="myTextarea" class="form-control validate"  rows="4" cols="50" name="mess"></textarea>


                                    </textarea>

                                </div>

                                <div class="form-group col-lg-6">
                                    <div> <label> <h2 class="tm-block-title">Đánh giá số sao cho sản phẩm</h2></label></div>
                                    
                                        <div style="color:red">${starEmpty}</div>
                                    
                                  
                                    <input type="checkbox" id="star1" name="star" value="1" class="star-checkbox"/>
                                    <label for="star1" class="fa fa-star star-label"></label>

                                    <input type="checkbox" id="star2"  name="star" value="1" class="star-checkbox"/>
                                    <label for="star2" class="fa fa-star star-label"></label>

                                    <input type="checkbox" id="star3"  name="star" value="1" class="star-checkbox"/>
                                    <label for="star3" class="fa fa-star star-label"></label>

                                    <input type="checkbox" id="star4"  name="star" value="1" class="star-checkbox"/>
                                    <label for="star4" class="fa fa-star star-label"></label>

                                    <input type="checkbox" id="star5"  name="star" value="1" class="star-checkbox"/>
                                    <label for="star5" class="fa fa-star star-label"></label>

                                </div>

                                <div class="col-6">
                                    <button
                                        type="submit"
                                        class="btn btn-primary btn-block text-uppercase"
                                        >
                                        Xác nhận
                                    </button>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="footer.jsp" %>
        <script>
            // Lấy tất cả các ô chọn
            const checkboxes = document.querySelectorAll('.star-checkbox');

            checkboxes.forEach((checkbox, index) => {
                checkbox.addEventListener('click', function () {
                    // Lặp qua tất cả các ô chọn
                    checkboxes.forEach((cb, i) => {
                        if (i <= index) {
                            cb.checked = true;
                            cb.nextElementSibling.classList.add('checked');
                        } else {
                            cb.checked = false;
                            cb.nextElementSibling.classList.remove('checked');
                        }
                    });
                });
            });

            function submitForm() {
                var textareaValue = document.getElementById("myTextarea").value;
                document.getElementById("hiddenField").value = textareaValue;
                document.getElementById("myForm").submit();
            }
        </script>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
