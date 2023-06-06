<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 04/11/2022
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Page</h1>
<a href="/product">Return</a>
<c:if test="${mess!=null}">
    <span style="color: red">${mess}</span>
</c:if>
<form action="/product?action=edit" method="post">
    <pre>ID :              <input type="text" name="id" value="${id}"></pre>
    <pre>Name :            <input type="text" name="name" value="${name}"></pre>
    <pre>Price :           <input type="text" name="price" value="${price}"></pre>
    <pre>Product Detail :  <input type="text" name="productDetail" value="${productDetail}"></pre>
    <pre>Producer :        <input type="text" name="producer"  value="${producer}"></pre>
    <pre>                  <button>Save</button></pre>
</form>
</body>
</html>
