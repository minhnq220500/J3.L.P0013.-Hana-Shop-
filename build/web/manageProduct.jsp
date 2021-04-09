<%-- 
    Document   : manageProduct
    Created on : Jan 11, 2021, 2:52:26 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <c:if test="${sessionScope.LOGIN_USER==null or sessionScope.LOGIN_USER.roleID!='AD'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Product Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>

        <jsp:useBean id="dao" class="minhnq.daos.ProductDAO" scope="request"></jsp:useBean>

        </head>
        <body>
            <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage <b>Product</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="MainController?btnAction=Add New"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                                <!--                            <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						-->
                            </div>
                        </div>
                    </div>

                    <form action="MainController">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Product ID</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Status</th>
                                    <th>Image</th>
                                    <th>Description</th>
                                    <th>Create Date</th>
                                    <th>Category ID</th>

                                    <th>Update</th>

                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_PRODUCT}">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${product.productID}</td>
                                    <td>${product.productName}</td>
                                    <td>${product.price} $</td>
                                    <td>${product.quantity}</td>
                                    <td>
                                        <select name="cbkStatus">
                                            <option >True</option>
                                            <option ${product.status=='False'? "selected":""} >False</option>
                                        </select>
                                    </td>
                                    <td>
                                        <img src="${product.image}">
                                    </td>
                                    <td>${product.description}</td>
                                    <td>${product.createDate}</td>
                                    <td>
                                        <select name="cbkCateID">
                                            <option>D</option>
                                            <option ${product.categoryID=='F'? "selected":""} >F</option>
                                        </select>
                                    </td>

                                    <td>
                                        <a href="MainController?btnAction=Update&txtID=${product.productID}&txtName=${product.productName}&txtPrice=${product.price}&txtQuantity=${product.quantity}&txtImage=${product.image}
                                           &txtDescription=${product.description}&txtCategory=${product.categoryID}&txtStatus=${product.status}"  
                                           class="edit" data-toggle="modal">Update</a>
                                        <!--                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>-->
                                    </td>

                                    <td>
                                        <input type="checkbox" name="ckbDel" value="${product.productID}" />
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>


                    <div>
                        <input type="submit" value="Delete Selected Product" name="btnAction" onclick="return confirm('Are you sure want to remove these products?')"/>
                        <p style="color: #ff0000">${requestScope.MESSAGE}</p></br>
                    </div>

                </form>

                <div class="clearfix">
                    <ul class="pagination">
                        <c:forEach begin="1" end="${dao.numberPageNoCondition}" var="i">
                            <li class="page-item ${requestScope.INDEX==i? "active":""} "><a class="page-link" href="PagingController?index=${i}">${i}</a></li>
                            </c:forEach>
                    </ul>
                </div>



            </div>
            <a href="HomeController"><button type="button" class="btn btn-primary">Back to home</button></a>

            <a href="MainController?btnAction=Product History"><button type="button" class="btn btn-primary">Product History</button></a>

        </div>


        <!-- Add New Modal HTML  -->

        <!--        <div id="addEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="#" method="post">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Add Product</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">					
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input name="name" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Image</label>
                                        <input name="image" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input name="price" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title</label>
                                        <textarea name="title" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea name="description" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Category</label>
                                        
                                        <select name="cmbCate">
        <c:forEach var="category" items="${dao.listCategory}">
            <option value="${category.categoryID}">${category.categoryName}</option>
        </c:forEach>
    </select>
    
</div>

</div>
<div class="modal-footer">
<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
<input type="submit" class="btn btn-success" value="Add">
</div>
</form>
</div>
</div>
</div>-->

        <!-- Edit Modal HTML -->

        <!--        <div id="editEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="MainController">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Update Product</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">	
                                    <div class="form-group">
                                        <label>Product ID</label>
                                        <input type="text" class="form-control" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label>Product Name</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input type="email" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Quantity</label>
                                        <textarea class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Image Link</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-info" value="Confirm Update">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>-->

        <!-- Delete Modal HTML -->

        <!--        <div id="deleteEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">						
                                    <h4 class="modal-title">Delete Product</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">					
                                    <p>Are you sure you want to delete these Records?</p>
                                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-danger" value="Delete">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>-->

        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>

