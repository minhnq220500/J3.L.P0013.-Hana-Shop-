<%-- 
    Document   : cart
    Created on : Jan 11, 2021, 2:48:36 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop Homepage - Start Bootstrap Template</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <c:if test="${sessionScope.LOGIN_USER==null or sessionScope.LOGIN_USER.roleID!='US'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <jsp:useBean id="dao" class="minhnq.daos.ProductDAO" scope="request"></jsp:useBean>
        <c:set var="productID" value="${requestScope.PRODUCT_ID}"/>
    </head>

    <body>

        <!-- Navigation -->
        <%@include file="NavComponent.jsp" %>

        <!--container-->
        <div class="container" style="margin-top: 7rem;margin-bottom: 7rem">
            <div class="mt-3">
                <h4>Shopping Cart</h4>
                <a class="btn btn-primary" href="HomeController">Continues Shopping</a>
                <form id="formQuantity" action="EditController" method="get">
                    <table class="w-100 table table-striped mt-3">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Image</th>
                                <th>Name of Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total Price</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cart" varStatus="counter" items="${sessionScope.CART.cart.values()}">

                            <form action="MainController">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        <img src="${cart.image}" style="width: 100px">
                                    </td>
                                    <td>${cart.productName}</td>
                                    <td>
                                        <fmt:formatNumber type="currency" value="${cart.price}"/>
                                    </td>
                                    <td>
                                        <input type="number" min="1" max="${dao.getProductQuantityByID(cart.productID)}" name="txtQuantity" value="${cart.quantity}" class="pl-1" style="width: 60px"/>
                                        
                                    </td>
                                    <td>
                                        <fmt:formatNumber type="currency" value="${cart.quantity*cart.price}"/>
                                    </td>
                                    <td>
                                        <a href="MainController?btnAction=Remove&productID=${cart.productID}" class="btn btn-danger" onclick="return confirm('Are you sure want to remove these products?')" ><i class="fas fa-trash"></i></a>
                                    </td>
                                    <td>
                                        <input type="hidden" name="txtID" value="${cart.productID}"/>
                                        <input type="hidden" name="txtQuantity" value="${cart.quantity}" />
                                        <input class="btn btn-info ml-2" class="fas fa-sync-alt mr-2" type="submit" value="Edit" name="btnAction" />
                                    </td>
                                </tr>
                            </form>

                        </c:forEach>

                        </tbody>
                    </table>
                    <hr/>
                    <div class="text-right">
                        <h4>Total Money:<fmt:formatNumber type="currency" value="${sessionScope.TOTAL_PRICE}"/></h4>
                    </div>
                    <hr/>
                    <div class="text-right">
                        <!--                        <a href="MainController?btnAction=Remove&deleteAll=1" class="btn btn-danger"><i class="fas fa-trash mr-2"></i>Delete Cart</a>-->

                        <!--                        <button type="submit" class="btn btn-info ml-2"><i class="fas fa-sync-alt mr-2"></i>Update Cart</button>-->

                        <!--                        <a href="MainController?btnAction=Order" class="btn btn-success ml-2">Order
                                                    <i class="fas fa-arrow-right ml-2"></i>
                                                </a>-->
                        <!--                        <input type="submit" value="Order" name="btnAction" class="btn btn-success ml-2"/>-->
                        <a href="MainController?btnAction=Order" class="btn btn-success ml-2" id="order">Order
                            <i class="fas fa-arrow-right ml-2"></i>
                        </a>
                    </div>
                </form>

                <form action="MainController">
                    <input type="submit" value="Buying History" name="btnAction" />
                    <!--                    <a href="#">Buying History</a>-->
                </form>

            </div>
        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark mt-5">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
