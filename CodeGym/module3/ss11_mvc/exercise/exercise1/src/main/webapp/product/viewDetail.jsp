<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 04/11/2022
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>View Page</h1>
<a href="/product?action=display">Return</a>
<form>
    <pre>ID :              ${id}</pre>
    <pre>Name :            ${name}</pre>
    <pre>Price :           ${price}</pre>
    <pre>Product Detail :  ${productDetail}</pre>
    <pre>Producer :        ${producer}</pre>
</form>
</body>
</html>
