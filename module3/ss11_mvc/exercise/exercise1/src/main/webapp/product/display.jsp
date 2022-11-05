<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 04/11/2022
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="row" style="align-items: center; text-align: center">
    <div class="col-1">
        <button class="btn btn-success">
            <a style="text-decoration: none; color: black" href="/product">Return</a>
        </button>
    </div>
    <h1 class="col-10">PRODUCT LIST</h1>
    <div class="col-1">
        <button class="btn btn-success">
            <a style="text-decoration: none; color: black" href="/product?action=add">Add</a>
        </button>
    </div>
</div>
<table class="table table-dark">
    <tr>
        <th>Status</th>
        <th>Name</th>
        <th>Price</th>
        <th>Product Detail</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Detail</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getProductDetail()}</td>
            <td>${product.getProducer()}</td>
            <td>
                <form>
                    <button class="btn btn-warning">
                        <a style="text-decoration: none; color: black"
                           href="/product?action=edit&id=${product.getId()}">edit</a>
                    </button>
                </form>
            </td>
            <td>
                <form action="">
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteProduct${product.getId()}">
                    Delete
                </button></form>
            </td>
            <td>
                <form>
                    <button class="btn btn-info">
                        <a style="text-decoration: none; color: black"
                           href="/product?action=viewDetail&id=${product.getId()}">view</a>
                    </button>
                </form>
            </td>
        </tr>
        <%-- REMOVE--%>
        <div class="modal fade" id="deleteProduct${product.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Are you sure to delete???
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                        </button>
                        <form action="/product?action=remove&id=${product.getId()}"
                              method="post">
                            <button  class="btn btn-primary" >Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
