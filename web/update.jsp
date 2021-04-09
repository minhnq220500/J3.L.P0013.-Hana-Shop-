<%-- 
    Document   : update
    Created on : Jan 12, 2021, 10:21:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
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
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER==null or sessionScope.LOGIN_USER.roleID!='AD'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <h1 style="align-content: center">Update form</h1>

        Product ID: ${param.txtID}</br>

        <form action="MainController">
            <input type="hidden" name="txtProductID" value="${param.txtID}" />

            Product Name: <input type="text" name="txtProductName" value="${param.txtName}" required="" style="width: 500px"/>
            </br>
            Price: <input type="number" min="0" name="txtProductPrice" value="${param.txtPrice}" required="" style="width: 500px"/>
            </br>
            Quantity: <input type="number" min="0" name="txtProductQuantity" value="${param.txtQuantity}" required="" style="width: 500px"/>
            </br>
            Image Link: <input type="text" name="txtProductImage" value="${param.txtImage}" required="" style="width: 500px"/>
            </br>
            Description: <input type="text" name="txtProductDescription" value="${param.txtDescription}" required="" style="width: 500px"/>
            </br>
            Category:
            <c:if test="${param.txtCategory=='D'}">
                <select name="cmbCate" style="width: 500px">
                    <option selected value="D">Drink</option>
                    <option value="F">Food</option>
                </select>
            </c:if>

            <c:if test="${param.txtCategory=='F'}">
                <select name="cmbCate" style="width: 500px">
                    <option value="D">Drink</option>
                    <option selected value="F">Food</option>
                </select>
            </c:if>
            </br>
            
            Status:
            <c:if test="${param.txtStatus=='true'}">
                <select name="cmbStatus" style="width: 500px">
                    <option selected value="True">True</option>
                    <option value="False">False</option>
                </select>
            </c:if>

            <c:if test="${param.txtStatus=='false'}">
                <select name="cmbStatus" style="width: 500px">
                    <option value="True">True</option>
                    <option selected value="False">False</option>
                </select>
            </c:if>
            
            </br>
            <p></p>

            <input type="submit" value="Confirm Update" name="btnAction" style="width: 300px" />
        </form>
        </br>
        <form action="MainController">
            <input type="submit" value="Manage Product" name="btnAction" style="width: 300px" />
        </form>
    </body>
</html>