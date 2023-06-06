<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 03/11/2022
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custumer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<table class="table table-dark">
    <tr>
        <th scope="col">Ten</th>
        <th scope="col">Ngay sinh</th>
        <th scope="col">Dia chi</th>
        <th scope="col">Anh</th>
    </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.getName()}</td>
                <td>${customer.getBirthday()}</td>
                <td>${customer.getAddress()}</td>
                <td width="200px"><img src="${customer.getImg()}" alt="anh the" width="100%"></td>
            </tr>
        </c:forEach>

</table>
</body>
</html>
