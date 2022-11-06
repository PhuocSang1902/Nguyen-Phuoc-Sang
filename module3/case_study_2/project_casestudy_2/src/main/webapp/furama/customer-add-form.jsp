<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 06/11/2022
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="d-flex justify-content-center">
    <div class="col-6">
        <div class="my-5"><h1>Thêm mới khách hàng</h1></div>
        <form class="my-5">
            <div class="form-group">
                <label for="formInput">Tên khách hàng</label>
                <input type="text" class="form-control" id="formInput">
            </div>
            <div class="form-group">
                <label for="formInput1">Loại khách hàng</label>
                <input type="text" class="form-control" id="formInput1">
            </div>
            <div class="form-group">
                <label for="formInput2">Ngày sinh</label>
                <input type="text" class="form-control" id="formInput2">
            </div>
            <div class="form-group">
                <label for="formInput3">Giới tính</label>
                <input type="text" class="form-control" id="formInput3">
            </div>
            <div class="form-group">
                <label for="formInput4">Số CCCD</label>
                <input type="text" class="form-control" id="formInput4">
            </div>
            <div class="form-group">
                <label for="formInput5">Số điện thoại</label>
                <input type="text" class="form-control" id="formInput5">
            </div>
            <div class="form-group">
                <label for="formInput6">Email</label>
                <input type="text" class="form-control" id="formInput6">
            </div>
            <div class="form-group">
                <label for="formInput7">Địa chỉ</label>
                <input type="text" class="form-control" id="formInput7">
            </div>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <input style="width: 30%" type="button" class="form-control btn btn-outline-warning mx-5" id="formInput12" value="Hủy">
                <input style="width: 30%" type="button" class="form-control btn btn-outline-success mx-5" id="formInput11" value="Lưu thông tin">
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
