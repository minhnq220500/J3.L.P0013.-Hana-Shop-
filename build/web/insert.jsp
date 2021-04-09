<%-- 
    Document   : insert
    Created on : Jan 14, 2021, 5:20:10 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
        <style>
            input[type=text], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type=number], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type=submit] {
                width: 100%;
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            div {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
        </style>

        <jsp:useBean id="dao" class="minhnq.daos.ProductDAO" scope="request"></jsp:useBean>
        </head>
        <body>
            <h1>Insert Product Form</h1>
        <c:if test="${sessionScope.LOGIN_USER==null or sessionScope.LOGIN_USER.roleID!='AD'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>

        <form action="MainController">
            Product ID: <input type="text" name="txtProductID" required="" style="width: 500px"/> 
            <p style="color: #ff0000">${requestScope.ERROR_PRODUCT.productIDError}</p></br>

            Product Name: <input type="text" name="txtProductName" required="" style="width: 500px"/></br>

            Price: <input type="number" min="0" name="txtPrice" required="" style="width: 500px"/></br>

            Quantity: <input type="number" min="0" name="txtQuantity" required="" style="width: 500px"/></br>

            Image link: <input type="text" name="txtImage" required="" style="width: 500px"/></br>

            Description: <input type="text" name="txtDesscription" required="" style="width: 500px" /></br>

            Category:
            <select name="ckbCate" style="width: 500px">
                <c:forEach var="category" items="${dao.listCategory}">
                    <option value="${category.categoryID}">${category.categoryName}</option>
                </c:forEach>
            </select></br>

            <input type="submit" value="Confirm Insert" name="btnAction" style="width: 300px" />
            
        </form>
        </br>
        <form action="MainController">
            <input type="submit" value="Manage Product" name="btnAction" style="width: 300px" />
        </form>
    </body>
</html>
