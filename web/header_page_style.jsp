<%-- 
    Document   : menu
    Created on : Jan 11, 2021, 7:40:56 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="HomeController">Food & Drink</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">

                <c:if test="${sessionScope.LOGIN_USER!=null and sessionScope.LOGIN_USER.roleID=='AD'}">
                    <li class="nav-item">
                        <a class="nav-link" href="MainController?btnAction=Manage Product">Manage Product</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.LOGIN_USER!=null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#"> Hello ${sessionScope.LOGIN_USER.name}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="MainController?btnAction=Logout">Logout</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.LOGIN_USER==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="MainController?btnAction=Login_Account">Login Account</a>
                    </li>
                </c:if>

            </ul>

            <!--search form-->
            <form action="MainController" method="GET" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <p style="color: white"> Search by name  </p>
                    <input name="txtSearch" value="${requestScope.SEARCH}" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search..." required="">
                    <div class="input-group-append">
                        
                        <input type="hidden" name="index" value="1" required="" />
                        
                        <button type="submit" class="btn btn-secondary btn-number" name="btnAction"value="Search" >
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
            <!--search form-->

            <!--            search form
            -->
            <form action="MainController" method="GET" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <p style="color: white">Search by price  </p>
                    <p></p>
                    <input name="txtPriceFrom" value="${requestScope.PRICE_FROM}" type="number" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="From..." required="" >
                    <input name="txtPriceTo" value="${requestScope.PRICE_TO}" type="number" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="To..." required="">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number" name="btnAction"value="Search By Price" >
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form><!--
                        search form-->


            <c:if test="${sessionScope.LOGIN_USER==null or sessionScope.LOGIN_USER.roleID!='AD'}">
                <a class="btn btn-success btn-sm ml-3" href="MainController?btnAction=View">
                    <i class="fa fa-shopping-cart"></i> View Cart
<!--                    <span class="badge badge-light">3</span>-->
                </a>
            </c:if>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Welcome to Hana Shop</h1>
    </div>
</section>
<!--end of menu-->

