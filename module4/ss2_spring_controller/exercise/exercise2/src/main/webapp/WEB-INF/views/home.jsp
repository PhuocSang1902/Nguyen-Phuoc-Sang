<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 20/11/2022
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sandwich</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

</head>
<body>
<h3>Sandwich Condiments</h3>
<form action="save" method="post">
    <div class="form-check">
        <input class="form-check-input" type="radio" name="lettuce" id="lettuce" value="Lettuce">
        <label class="form-check-label" for="lettuce">
            Lettuce
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="tomato" id="tomato" value="Tomato">
        <label class="form-check-label" for="tomato">
            Tomato
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="mustard" id="mustard" value="Mustard">
        <label class="form-check-label" for="mustard">
            Mustard
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sprouts" id="sprouts" value="Sprouts">
        <label class="form-check-label" for="sprouts">
            Sprouts
        </label>
    </div>
    <input type="submit" class="btn btn-success">
</form>
<c:if test="${condiments != null}">
    <h3>Condiments is choice</h3>
    <c:forEach var="condiment" items="${condiments}">
        <p>${condiment}</p>
    </c:forEach>
</c:if>
</body>
<script>
    function submit(id) {
        document.getElementById(id).submit();
    }
</script>
</html>
