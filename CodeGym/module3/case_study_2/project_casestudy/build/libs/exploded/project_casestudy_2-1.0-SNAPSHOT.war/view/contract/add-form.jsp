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
    <title>HỢp đồng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="d-flex justify-content-center">
    <div class="col-6">
        <c:if test="${mess != null}">
            <h4 style="color: #ff0000">${mess}</h4>
        </c:if>
        <div class="my-5"><h1>Thêm mới hợp đồng</h1></div>
        <form class="my-5" action="/contract?action=add" method="post">
            <div class="form-group">
                <label for="formInput">Ngày bắt đầu</label>
                <input type="date" class="form-control" id="formInput" name="startDate"
                       value="${contract != null ? contract.getStartDate() : nowDate}"
                       min="1920-01-01" max="${nowDateEndYear}">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('startDate') : ""}</p>
            <div class="form-group">
                <label for="formInput1">Ngày kết thúc</label>
                <input type="date" class="form-control" id="formInput1" name="endDate"
                       value="${contract != null ? contract.getEndDate() : nowDate}"
                       min="1920-01-01" max="${nowDateEndYear}">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('endDate') : ""}</p>
            <div class="form-group">
                <label for="formInput2">Đặt cọc</label>
                <input type="text" class="form-control" id="formInput2" name="deposit" value="${contract.getDeposit()}"
                       placeholder="Đặt cọc không nhỏ hơn 0">
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('cost') : ""}</p>
            <c:if test="${contractDetail != null}">
                <div class="form-group">
                    <label for="formInput3">Tổng tiền</label>
                    <input type="text" class="form-control" id="formInput3" name="totalValue"
                           value="${totalValue}"
                           placeholder="Đặt cọc không nhỏ hơn 0">
                </div>
            </c:if>
            <div class="form-group">
                <label for="formInput4">Khách hàng thuê dịch vụ</label>
                <select class="form-select" aria-label="Default select example" id="formInput4" name="customer" onmouseover="disappear()">
                    <option id="disappearId1">Hãy chọn khách hàng</option>
                    <c:forEach var="customer" items="${customerList}">
                        <option value="${customer.getId()}" ${customer.getId()==customerId ? "selected" : ""}>
                                ${customer.getName()}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('customer') : ""}</p>
            <div class="form-group">
                <label for="formInput5">Dịch vụ</label>
                <select class="form-select" aria-label="Default select example" id="formInput5" name="facility" onmouseover="disappear()">
                    <option id="disappearId1">Hãy chọn dịch vụ</option>
                    <c:forEach var="facility" items="${facilityList}">
                        <option value="${facility.getId()}" ${facility.getId()==facilityId ? "selected" : ""}>
                                ${facility.getName()}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('facility') : ""}</p>
            <div class="form-group">
                <label for="formInput6">Nhân viên</label>
                <select class="form-select" aria-label="Default select example" id="formInput6" name="employee" onmouseover="disappear()">
                    <option id="disappearId2">Hãy chọn nhân viên</option>
                    <c:forEach var="employee" items="${employeeList}">
                        <option value="${employee.getId()}" ${employee.getId()==employeeId ? "selected" : ""}>
                                ${employee.getName()}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('employee') : ""}</p>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput7">
                    <a href="/contract?action=display" style="text-decoration: none; color: #0dcaf0">Hủy</a>
                </button>
                <input style="width: 30%" type="submit" class="form-control btn btn-outline-success mx-5"
                       id="formInput8" value="Lưu thông tin">
            </div>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput9">
                    <a href="/index.jsp" style="text-decoration: none; color: #0dcaf0">Trang chủ</a>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    function disappear() {
        document.getElementById("disappearId").style.display = "none";
        document.getElementById("disappearId1").style.display = "none";
        document.getElementById("disappearId2").style.display = "none";
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
