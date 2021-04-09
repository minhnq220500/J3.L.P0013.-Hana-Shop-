<%-- 
    Document   : home.jsp
    Created on : Jan 11, 2021, 2:46:21 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <jsp:useBean id="dao" class="minhnq.daos.ProductDAO" scope="request"></jsp:useBean>
        </head>
        <body>
            <!--begin of menu-->
        <jsp:include page="header_page_style.jsp"></jsp:include>
            <!--end of menu-->


            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="HomeController">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                            <ul class="list-group category_block">

                            <c:forEach items="${requestScope.LIST_CATE}" var="cate">
                                <li class="list-group-item text-white ${requestScope.CATE_ID == cate.categoryID? "active":"" } ">
                                    <a href="MainController?btnAction=cateButton&categoryID=${cate.categoryID}">${cate.categoryName}</a>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                    <p style="color: red">${requestScope.MESSAGE}</p>
                </div>

                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach var="product" items="${requestScope.LIST_PRODUCT}">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${product.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="MainController?btnAction=Detail&productName=${product.productName}" title="View Product">${product.productName}</a></h4>
                                        <p class="card-text show_txt">${product.description}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${product.price} $</p>
                                            </div>

                                            <div class="col">
                                                <c:if test="${sessionScope.LOGIN_USER!=null and sessionScope.LOGIN_USER.roleID=='AD'}">

                                                    <!--                                                    <form action="MainController">
                                                                                                            <input type="hidden" name="txtID" value="${product.productID}" />
                                                                                                            <input type="hidden" name="txtName" value="${product.productName}" />
                                                                                                            <input type="hidden" name="txtPrice" value="${product.price}" />
                                                                                                            <input type="hidden" name="txtQuantity" value="${product.quantity}" />
                                                                                                            <input type="hidden" name="txtImage" value="${product.image}" />
                                                                                                            <input type="hidden" name="txtDescription" value="${product.description}" />
                                                                                                            <input type="hidden" name="txtCategory" value="${product.categoryID}" />
                                                    
                                                                                                            <input type="hidden" name="txtSearchhh" value="${param.txtSearch}" />
                                                                                                            <input class="btn btn-success btn-block" type="submit" value="Update" name="btnAction" />
                                                                                                        </form>-->

                                                </c:if>

                                                <c:if test="${sessionScope.LOGIN_USER.roleID=='US'}">
                                                    <form action="MainController">
                                                        <input type="hidden" name="txtID" value="${product.productID}" />
                                                        <input type="submit" value="Add To Cart" name="btnAction" class="btn btn-success btn-block" />
                                                    </form>
                                                </c:if>

                                                <c:if test="${sessionScope.LOGIN_USER==null}">
                                                    <form action="MainController">
                                                        <a href="MainController?btnAction=Login_Account" class="btn btn-success btn-block" >Add To Cart</a>
                                                    </form>
                                                </c:if>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <nav>

                        </nav>
                    </div>
                </div>

            </div>

            <!-- paging -->    
            <nav style="margin: 20px auto; width: 500px" aria-label="...">
                <ul class="pagination pagination-lg">
                    <c:forEach begin="1" end="${requestScope.NUMBER_PAGE}" var="i">
                        <li class="page-item ${requestScope.INDEX==i? "active":""} ">
                            <a class="page-link" href="MainController?btnAction=${param.btnAction}&index=${i}&txtSearch=${param.txtSearch}&categoryID=${param.categoryID}&txtPriceFrom=${param.txtPriceFrom}&txtPriceTo=${param.txtPriceTo}">${i}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>

        </div>

        <!-- Footer -->
        <jsp:include page="footer_page_style.jsp"></jsp:include>
    </body>
</html>