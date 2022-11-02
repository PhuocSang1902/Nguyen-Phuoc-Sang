<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 02/11/2022
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="\discount_amount" method="post">
    <div>
        <input type="text" name="productDescription" placeholder="Product Description"><br>
        <input type="number" name="listPrice" placeholder="Price"><br>
        <input type="number" name="discountPercent" placeholder="Discount Percent"><br>
        <button type="submit">Calculate Discount</button>
    </div>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</html>
