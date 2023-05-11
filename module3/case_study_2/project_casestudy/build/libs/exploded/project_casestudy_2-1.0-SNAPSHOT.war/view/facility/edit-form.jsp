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
        <div class="my-5"><h1>Chỉnh sửa dịch vụ</h1></div>
        <form class="my-5" action="/facility?action=edit&id=${facility.getId()}" method="post">
            <div class="form-group">
                <label for="formInput">Tên dịch vụ</label>
                <input type="text" class="form-control" name="name" id="formInput" value="${facility.getName()}">
            </div>
            <div class="form-group">
                <label for="formInput1">Diện tích</label>
                <input type="text" class="form-control" name="area" id="formInput1" value="${facility.getArea()}">
            </div>
            <div class="form-group">
                <label for="formInput2">Giá</label>
                <input type="text" class="form-control" id="formInput2" name="cost" value="${facility.getCost()}">
            </div>
            <div class="form-group">
                <label for="formInput3">Số người</label>
                <input type="text" class="form-control" id="formInput3" name="maxPeople"
                       value="${facility.getMaxPeople()}">
            </div>
            <div class="form-group">
                <label for="formInput4">Kiểu thuê</label>
                <%--                <input type="text" class="form-control" id="formInput4" name="rentTypeName">--%>
                <select class="form-select" aria-label="Default select example" id="formInput4" name="rentTypeId"
                        value="${facility.getRentTypeId()}">
                    <c:forEach var="rentType" items="${rentTypeList}">
                        <c:if test="${facility.getRentTypeId() == rentType.getId()}">
                            <option selected value="${rentType.getId()}">${rentType.getName()}</option>
                        </c:if>
                        <c:if test="${facility.getRentTypeId() != rentType.getId()}">
                            <option value="${rentType.getId()}">${rentType.getName()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="formInput5">Loại dịch vụ</label>
                <input readonly type="text" class="form-control" name="facilityTypeName" id="formInput5" value="${facilityTypeInput.getName()}">
                <input hidden type="text" class="form-control" name="facilityTypeId" value="${facilityTypeInput.getId()}">
<%--                <select readonly="true" class="form-select" aria-label="Default select example" id="formInput5" name="facilityTypeId"--%>
<%--                        value="${facility.getFacilityTypeId()}">--%>
<%--                    <c:forEach var="facilityType" items="${facilityTypeList}">--%>
<%--                        <c:if test="${facility.getFacilityTypeId() == facilityType.getId()}">--%>
<%--                            <option selected value="${facilityType.getId()}">${facilityType.getName()}</option>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${facility.getFacilityTypeId() != facilityType.getId()}">--%>
<%--                            <option value="${facilityType.getId()}">${facilityType.getName()}</option>--%>
<%--                        </c:if>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
            </div>
            <c:if test="${facility.getFacilityTypeName() == 'House' || facility.getFacilityTypeName() == 'Villa'}">
                <div class="form-group">
                    <label for="formInput6">Tiêu chuẩn phòng</label>
                    <select class="form-select" aria-label="Default select example" id="formInput6" name="standardRoom"
                            value="${facility.getStandardRoom()}">
                        <option ${facility.getStandardRoom().equals('vip') ? "selected":""} value="vip">
                            Vip
                        </option>
                        <option ${facility.getStandardRoom().equals('normal') ? "selected":""} value="normal">
                            Normal
                        </option>
                    </select>
                </div>
            </c:if>

            <div class="form-group">
                <label for="formInput7">Mô tả</label>
                <input type="text" class="form-control" id="formInput7" name="description"
                       value="${facility.getDescription()}">
            </div>
            <c:if test="${facility.getFacilityTypeName() == 'House' || facility.getFacilityTypeName() == 'Villa'}">
                <div class="form-group">
                    <label for="formInput8">Dt hồ bơi</label>
                    <input type="text" class="form-control" id="formInput8" name="poolArea"
                           value="${facility.getPoolArea()}">
                </div>
            </c:if>
            <c:if test="${facility.getFacilityTypeName() == 'House' || facility.getFacilityTypeName() == 'Villa'}">
                <div class="form-group">
                    <label for="formInput9">Số tầng</label>
                    <select class="form-select" aria-label="Default select example" id="formInput9" name="numberOfFloor"
                            value="${facility.getNumberOfFloor()}">
                        <option value="1" ${facility.getNumberOfFloor() == 1 ? "selected" : ""}>1</option>
                        <option value="2" ${facility.getNumberOfFloor() == 2 ? "selected" : ""}>2</option>
                        <option value="3" ${facility.getNumberOfFloor() == 3 ? "selected" : ""}>3</option>
                        <option value="4" ${facility.getNumberOfFloor() == 4 ? "selected" : ""}>4</option>
                    </select>
                </div>
            </c:if>
            <c:if test="${facility.getFacilityTypeName() == 'Room'}">
                <div class="form-group">
                    <label for="formInput10">Dịch vụ miễn phí</label>
                    <input type="text" class="form-control" id="formInput10" name="facilityFree"
                           value="${facility.getFacilityFree()}">
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
