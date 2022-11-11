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
    <title>Dịch vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="d-flex justify-content-center">
    <div class="col-6">
        <div class="my-5"><h1>Thêm mới dịch vụ</h1></div>
        <form class="my-5" action="/facility?action=add" method="post">
            <div class="form-group">
                <label for="formInput">Tên dịch vụ</label>
                <input type="text" class="form-control" name="name" id="formInput">
            </div>
            <div class="form-group">
                <label for="formInput1">Diện tích</label>
                <input type="text" class="form-control" name="area" id="formInput1">
            </div>
            <div class="form-group">
                <label for="formInput2">Giá</label>
                <input type="text" class="form-control" id="formInput2" name="cost">
            </div>
            <div class="form-group">
                <label for="formInput3">Số người</label>
                <input type="text" class="form-control" id="formInput3" name="maxPeople">
            </div>
            <div class="form-group">
                <label for="formInput4">Kiểu thuê</label>
<%--                <input type="text" class="form-control" id="formInput4" name="rentTypeName" value="${facilityType}">--%>
                <select class="form-select" aria-label="Default select example" id="formInput4" name="rentTypeId">
                    <option value="-- Hãy chọn kiểu thuê --" selected>-- Hãy chọn kiểu thuê --</option>
                    <c:forEach var="rentType" items="${rentTypeList}">
                        <option value="${rentType.getId()}">${rentType.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="formInput5">Loại dịch vụ</label>
                <select class="form-select" aria-label="Default select example" id="formInput5" name="facilityTypeId">
                    <option value="-- Hãy chọn loại dịch vụ --" selected>-- Hãy chọn loại dịch vụ --</option>
                    <c:forEach var="facilityType1" items="${facilityTypeList}">
                        <c:if test="${facilityType.equals(facilityType1.getName()) }">
                            <option selected value="${facilityType1.getId()}">${facilityType1.getName()}</option>
                        </c:if>
                        <c:if test="${!facilityType.equals(facilityType1.getName())}">
                            <option value="${facilityType1.getId()}">${facilityType1.getName()}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <%--                <input type="text" class="form-control" id="formInput5" name="facilityTypeId">--%>
            </div>
            <div class="form-group">
                <label for="formInput6">Tiêu chuẩn phòng</label>
                <select class="form-select" aria-label="Default select example" id="formInput6" name="standardRoom">
                    <option value="-- Hãy chọn tiêu chuẩn phòng --" selected>-- Hãy chọn tiêu chuẩn phòng --</option>
                    <option value="vip">Vip</option>
                    <option value="normal">Normal</option>
                </select>
                <%--                <input type="text" class="form-control" id="formInput6" name="standardRoom">--%>
            </div>
            <div class="form-group">
                <label for="formInput7">Mô tả</label>
                <input type="text" class="form-control" id="formInput7" name="description">
            </div>
            <c:if test="${facilityType == 'House' || facilityType == 'Villa'}">
                <div class="form-group">
                    <label for="formInput8">Dt hồ bơi</label>
                    <input type="text" class="form-control" id="formInput8" name="poolArea">
                </div>
            </c:if>
            <c:if test="${facilityType == 'House' || facilityType == 'Villa'}">
                <div class="form-group">
                    <label for="formInput9">Số tầng</label>
                    <select class="form-select" aria-label="Default select example" id="formInput9" name="numberOfFloor">
                        <option value="-- Hãy chọn số tầng --" selected>-- Hãy chọn số tầng --</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="3">4</option>
                    </select>
                </div>
            </c:if>

            <c:if test="${facilityType == 'Room'}">
                <div class="form-group">
                    <label for="formInput10">Dịch vụ miễn phí</label>
                    <input type="text" class="form-control" id="formInput10" name="facilityFree">
                </div>
            </c:if>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput11">
                    <a href="/facility?action=display" style="text-decoration: none; color: #0dcaf0">Hủy</a>
                </button>
                <input style="width: 30%" type="submit" class="form-control btn btn-outline-success mx-5"
                       id="formInput12" value="Lưu thông tin">
            </div>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput13">
                    <a href="/facility?action=display" style="text-decoration: none; color: #0dcaf0">Danh sách dịch
                        vu</a>
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
