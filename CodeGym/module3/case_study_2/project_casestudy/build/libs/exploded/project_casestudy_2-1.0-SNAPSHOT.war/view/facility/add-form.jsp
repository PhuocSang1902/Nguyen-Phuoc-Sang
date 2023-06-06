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
        <c:if test="${mess != null}">
            <h4 style="color: #ff0000">${mess}</h4>
        </c:if>
        <div class="my-5"><h1>Thêm mới dịch vụ</h1></div>
        <form class="my-5" action="/facility?action=add" method="post">
            <div class="form-group">
                <label for="formInput">Tên dịch vụ</label>
                <input type="text" class="form-control" name="name" id="formInput" value="${facility.getName()}"
                       placeholder="Chữ cái đầu viết hoa">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('facilityName') : ""}</p>
            <div class="form-group">
                <label for="formInput1">Diện tích</label>
                <input type="text" class="form-control" name="area" id="formInput1" value="${facility.getArea()}"
                       placeholder="Diện tích lớn hơn 0">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('area') : ""}</p>
            <div class="form-group">
                <label for="formInput2">Giá</label>
                <input type="text" class="form-control" id="formInput2" name="cost" value="${facility.getCost()}"
                       placeholder="Giá lớn hơn 0">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('cost') : ""}</p>
            <div class="form-group">
                <label for="formInput3">Số người</label>
                <input type="text" class="form-control" id="formInput3" name="maxPeople"
                       value="${facility.getMaxPeople()}" placeholder="Số nguyên lớn hơn 0">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('maxPeople') : ""}</p>
            <div class="form-group">
                <label for="formInput4">Kiểu thuê</label>
                <select class="form-select" aria-label="Default select example" id="formInput4" name="rentTypeId"
                        onmouseover="disappear()">
                    <option id="disappearId">-- Hãy chọn kiểu thuê --</option>
                    <c:forEach var="rentType" items="${rentTypeList}">
                        <option value="${rentType.getId()}"${facility.getRentTypeId() == rentType.getId() ? "selected" : ""}>
                                ${rentType.getName()}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('rentType') : ""}</p>
            <div class="form-group">
                <label for="formInput5">Loại dịch vụ</label>
                <input readonly type="text" class="form-control" name="facilityTypeName" id="formInput5"
                       value="${facilityTypeInput.getName()}">
            </div>
            <c:if test="${facilityType == 'House' || facilityType == 'Villa'}">
                <div class="form-group">
                    <label for="formInput6">Tiêu chuẩn phòng</label>
                    <select class="form-select" aria-label="Default select example" id="formInput6" name="standardRoom"
                            onmouseover="disappear()">
                        <option id="disappearId1">-- Hãy chọn tiêu chuẩn phòng --</option>
                        <option ${facility.getStandardRoom().equals('vip') ? "selected":""} value="vip">
                            Vip
                        </option>
                        <option ${facility.getStandardRoom().equals('normal') ? "selected":""} value="normal">
                            Normal
                        </option>
                    </select>
                </div>
                <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('standardRoom') : ""}</p>
            </c:if>
            <div class="form-group">
                <label for="formInput7">Mô tả</label>
                <input type="text" class="form-control" id="formInput7" name="description"
                       value="${facility.getDescription()}">
            </div>
            <c:if test="${facilityType == 'Villa'}">
                <div class="form-group">
                    <label for="formInput8">Dt hồ bơi</label>
                    <input type="text" class="form-control" id="formInput8" name="poolArea"
                           value="${facility.getPoolArea()}">
                </div>
                <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('area') : ""}</p>
            </c:if>

            <c:if test="${facilityType == 'House' || facilityType == 'Villa'}">
                <div class="form-group">
                    <label for="formInput9">Số tầng</label>
                    <select class="form-select" aria-label="Default select example" id="formInput9"
                            name="numberOfFloor" onmouseover="disappear()">
                        <option id="disappearId2">-- Hãy chọn số tầng --</option>
                        <option value="1" ${facility.getNumberOfFloor() == 1 ? "selected" : ""}>1</option>
                        <option value="2" ${facility.getNumberOfFloor() == 2 ? "selected" : ""}>2</option>
                        <option value="3" ${facility.getNumberOfFloor() == 3 ? "selected" : ""}>3</option>
                        <option value="3" ${facility.getNumberOfFloor() == 4 ? "selected" : ""}>4</option>
                    </select>
                </div>
                <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('numberOfFloor') : ""}</p>
            </c:if>

            <c:if test="${facilityType == 'Room'}">
                <div class="form-group">
                    <label for="formInput10">Dịch vụ miễn phí</label>
                    <input type="text" class="form-control" id="formInput10" name="facilityFree"
                           value="${facility.getFacilityFree()}">
                </div>
                <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('facilityFree') : ""}</p>
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
                    <a href="/index.jsp" style="text-decoration: none; color: #0dcaf0">Trang chủ</a>
                </button>
            </div>
        </form>
    </div>
</div>



</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script>
    function disappear() {
        document.getElementById("disappearId").style.display = "none";
        document.getElementById("disappearId1").style.display = "none";
        document.getElementById("disappearId2").style.display = "none";
    }
</script>
</html>
