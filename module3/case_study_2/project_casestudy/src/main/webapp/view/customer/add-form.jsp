<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 06/11/2022
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${mess != null}">
            <h4 style="color: #ff0000">${mess}</h4>
        </c:if>
        <div class="my-5"><h1>Thêm mới khách hàng</h1></div>
        <form class="my-5" action="/customer?action=add" method="post">
            <div class="form-group">
                <label for="formInput">Tên khách hàng</label>
                <input type="text" class="form-control" name="name" id="formInput" value="${customer.getName()}">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('customerName') : ""}</p>
            <div class="form-group">
                <label for="formInput1">Loại khách hàng</label>
                <select class="form-select" aria-label="Default select example" id="formInput1" name="customerType" id="customerType">
                    <option value="chooseType">Hãy chọn loại khách hàng</option>
                    <c:forEach var="customerType" items="${customerTypeList}">
                        <c:if test="${customerType.getId()==customer.getCustomerType()}">
                            <option value="${customerType.getId()}" selected>${customerType.getName()}</option>
                        </c:if>
                        <c:if test="${customerType.getId()!=customer.getCustomerType()}">
                            <option value="${customerType.getId()}">${customerType.getName()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="formInput2">Ngày sinh</label>
                <input type="date" class="form-control" id="formInput2" name="birthday"
                       value="${customer != null ? customer.getBirthday() : nowDate}"
                       min="1920-01-01" max="${nowDateEndYear}">
            </div>
            <div class="form-group">
                <label for="formInput3">Giới tính</label>
                <select class="form-control" id="formInput3" name="gender" id="formInput3">
                        <option value="Hãy chọn giới tính">Hãy chọn giới tính</option>
                        <option value="Nam" ${customer.getGender()=='Nam' ? "selected" : ""}>Nam</option>
                        <option value="Nữ" ${customer.getGender()=='Nữ' ? "selected" : ""} >Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="formInput4">Số CCCD</label>
                <input type="text" class="form-control" id="formInput4" name="idCard" value="${customer.getIdCard()}">
            </div>
            <div class="form-group">
                <label for="formInput5">Số điện thoại</label>
                <input type="text" class="form-control" id="formInput5" name="phoneNumber" value="${customer.getPhoneNumber()}">
            </div>
            <div class="form-group">
                <label for="formInput6">Email</label>
                <input type="text" class="form-control" id="formInput6" name="email" value="${customer.getEmail()}">
            </div>
            <div class="form-group">
                <label for="formInput7">Địa chỉ</label>
                <input type="text" class="form-control" id="formInput7" name="address" value="${customer.getAddress()}">
            </div>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput110">
                    <a href="/customer?action=display" style="text-decoration: none; color: #0dcaf0">Hủy</a>
                </button>
                <input style="width: 30%" type="submit" class="form-control btn btn-outline-success mx-5"
                       id="formInput11" value="Lưu thông tin">
            </div>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput13">
                    <a href="/customer?action=display" style="text-decoration: none; color: #0dcaf0">Danh sách khách
                        hàng</a>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
