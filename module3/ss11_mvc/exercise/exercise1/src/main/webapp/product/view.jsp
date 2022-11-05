<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 04/11/2022
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>product-manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="data:image/png;base64,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" alt=""></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="/product?action=display">Display</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/product?action=add">Add</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/product?action=display">Edit</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
