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
    <title>Add New</title>
</head>
<body>

<h1>Add Page</h1>
<a href="/product?action=display">Return</a>
<c:if test="${mess!=null}">
    <span style="color: red">${mess}</span>
</c:if>
<form action="/product?action=search" method="post">
    <pre>Name :            <input type="text" name="name"></pre>
    <pre>                  <button>Search</button></pre>
</form>
</body>
</html>
