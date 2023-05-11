<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 06/11/2022
  Time: 19:27
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
        <div class="my-5" style="text-align: center"><h1>Chỉnh sửa thông tin khách hàng</h1></div>
        <form class="my-5" method="post" action="/customer?action=edit&id=${customer.getId()}">
            <div class="form-group">
                <label for="formInput">Tên khách hàng</label>
                <input type="text" class="form-control" id="formInput" name="name" value="${customer.getName()}">
            </div>
            <div class="form-group">
                <label>Loại khách hàng</label>
                <select class="form-control" id="formInput1" name="customerType" id="customerType">
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
                       value="${customer.getBirthday()}"
                       min="1920-01-01" max="${nowDateEndYear}">

            </div>
            <div class="form-group">
                <label for="formInput3">Giới tính</label>
                <select class="form-control" id="formInput3" name="gender">
                    <option value="Nữ" ${customer.getGender()=='Nữ' ? "selected" : ""} >Nữ</option>
                    <option value="Nam" ${customer.getGender()=='Nam' ? "selected" : ""}>Nam</option>
                </select>
            </div>
            <div class="form-group">
                <label for="formInput4">Số CCCD</label>
                <input type="text" class="form-control" id="formInput4" name="idCard" value="${customer.getIdCard()}">
            </div>
            <div class="form-group">
                <label for="formInput5">Số điện thoại</label>
                <input type="text" class="form-control" id="formInput5" name="phoneNumber"
                       value="${customer.getPhoneNumber()}">
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
                <button style="width: 30%" type="button" class="form-control btn btn-outline-warning mx-5"
                        id="formInput12">
                    <a style="text-decoration: none; color: #ffc107" href="/customer?action=display">Hủy</a>
                </button>
                <button style="width: 30%" type="submit" class="form-control btn btn-outline-success mx-5"
                        id="formInput11">
                    Lưu thông tin
                </button>
            </div>

            <div class="form-group d-flex align-items-center justify-content-center"
                 style="margin-top: 25px; margin-bottom: 25px">
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
