<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 19/11/2022
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="mb-3">
    <form action="check" method="post">
        <label for="email" class="form-label">Email</label>
        <input type="text" class="form-control" id="email" placeholder="name@example.com" name="email">
        <input class="btn btn-success" type="submit" value="check">
    </form>
    <c:if test="${mess != null}">
        <p>${mess}</p>
    </c:if>
</div>
</body>
</html>
