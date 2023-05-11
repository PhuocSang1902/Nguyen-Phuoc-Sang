<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 06/11/2022
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhân viên</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="datatables/scc/dataTables.bootstrap5.min.css">
</head>
<body>

<div class="vh-100">

    <header class="row d-flex justify-content-between align-items-center" style="height: 19%">
        <div class="col-1">
            <div class="card m-3" style="width: 4rem;">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" class="card-img-top"
                     alt="Furama resort">
            </div>
        </div>
        <div class="col-9">

        </div>
        <div class="d-flex col-2">
            <button type="button" class="btn btn-success my-5 mx-1">Login</button>
            <button type="button" class="btn btn-warning my-5 mx-1">Sign-up</button>
        </div>

    </header>

    <div class="row sticky-top" style="height: 50px;">
        <nav class="navbar navbar-expand-lg navbar-light bg-success" style="height: 50px;">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarSupportedContent d-md">
                    <div class="col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3"></div>

                    <%@ include file="/nav.jsp" %>

                    <form class="d-flex col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3 mt-4" style="height: 50px;"
                          action="/employee">
                        <div class="d-flex align-items-center" style="height: 40px;">
                            <input type="text" hidden name="action" value="search">
                            <input class="form-control me-2" name="search" type="search"
                                   placeholder="Tim tên và địa chỉ"
                                   aria-label="Tìm kiếm">
                        </div>
                        <div class="d-flex align-items-center" style="height: 40px;">
                            <button class="btn btn-info" type="submit" style="height: 40px;">Tìm</button>
                        </div>
                    </form>

                </div>
            </div>
        </nav>
    </div>

    <div>
        <div class="row text-center align-items-center" style="border-bottom: 2px black solid">
            <div class="col-1">
                <button type="button" class="btn btn-outline-success">
                    <a style="text-decoration: none; color: #198754" href="/index.jsp">Trờ lại</a>
                </button>
            </div>
            <div class="col-10">
                <h1>DANH SÁCH NHÂN VIÊN</h1>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-outline-success" data-bs-toggle="modal"
                        data-bs-target="#addEmployee">
                    Thêm mới
                </button>
            </div>
        </div>
        <table class="table table-striped table-hover" style="width: 100%" id="tableCustomer">
            <thead>
            <tr class="align-middle text-center">
                <th scope="col">Stt</th>
                <th scope="col">Tên nhân viên</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Số CCCD</th>
                <th scope="col">Lương</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Email</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Vị trí</th>
                <th scope="col">Trình độ</th>
                <th scope="col">Phụ trách</th>
                <th scope="col">Sửa</th>
                <th scope="col">Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employeeList}" varStatus="status">
                <tr class="align-middle text-center">
                    <th>${status.count}</th>
                    <td>${employee.getName()}</td>
                    <td>${employee.getBirthday()}</td>
                    <td>${employee.getIdCard()}</td>
                    <td>${employee.getSalary()}</td>
                    <td>${employee.getPhoneNumber()}</td>
                    <td>${employee.getEmail()}</td>
                    <td>${employee.getAddress()}</td>
                    <td>${employee.getPositionName()}</td>
                    <td>${employee.getEducationDegreeName()}</td>
                    <td>${employee.getDivisionName()}</td>
                    <td>
                        <button onclick="getEditEmployee('${employee.getId()}','${employee.getName()}','${employee.getBirthday()}','${employee.getIdCard()}','${employee.getSalary()}','${employee.getPhoneNumber()}','${employee.getEmail()}','${employee.getAddress()}','${employee.getPositionId()}','${employee.getEducationDegreeId()}','${employee.getDivisionId()}')"
                                type="button"
                                class="btn btn-outline-danger" data-bs-toggle="modal"
                                data-bs-target="#editEmployee">Sửa
                        </button>
                    </td>
                    <td>
                        <button onclick="getId('${employee.getId()}','${employee.getName()}')" type="button"
                                class="btn btn-outline-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteEmployee">Xóa
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <form action="/employee?action=add" method="post">
            <div class="modal fade" id="addEmployee" tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Thêm mới nhân viên</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="formInput">Tên nhân viên</label>
                                <input type="text" class="form-control" id="formInput" name="name"
                                       value="${employee.getName()}">
                            </div>
                            <div class="form-group">
                                <label for="formInput1">Ngày sinh</label>
                                <input type="date" class="form-control" id="formInput1" name="birthday"
                                       value="${employee.getBirthday()}"
                                       min="1920-01-01" max="${nowDateEndYear}">

                            </div>
                            <div class="form-group">
                                <label for="formInput2">Số CCCD</label>
                                <input type="text" class="form-control" id="formInput2" name="idCard"
                                       value="${employee.getIdCard()}">
                            </div>
                            <div class="form-group">
                                <label for="formInput3">Lương</label>
                                <input type="text" class="form-control" id="formInput3" name="salary"
                                       value="${employee.getIdCard()}">
                            </div>
                            <div class="form-group">
                                <label for="formInput4">Số điện thoại</label>
                                <input type="text" class="form-control" id="formInput4" name="phoneNumber"
                                       value="${employee.getPhoneNumber()}">
                            </div>
                            <div class="form-group">
                                <label for="formInput6">Email</label>
                                <input type="text" class="form-control" id="formInput6" name="email"
                                       value="${employee.getEmail()}">
                            </div>
                            <div class="form-group">
                                <label for="formInput7">Địa chỉ</label>
                                <input type="text" class="form-control" id="formInput7" name="address"
                                       value="${employee.getAddress()}">
                            </div>
                            <div class="form-group">
                                <label for="formInput8">Vị trí</label>
                                <select class="form-control" id="formInput8" name="educationDegreeId">
                                    <option id="disappearId">Hãy chọn chức vụ</option>
                                    <option value="1" ${employee.setPositionId() == '1' ? "select" : ""}>Quản lý
                                    </option>
                                    <option value="2" ${employee.setPositionId() == '2' ? "select" : ""}>Nhân viên
                                    </option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="formInput9">Trình độ</label>
                                <select class="form-control" id="formInput9" name="educationDegreeId">
                                    <option id="disappearId1">Hãy chọn Trình độ</option>
                                    <option value="1" ${employee.getEducationDegreeId() == '1' ? "select" : ""}>Sau đại
                                        học
                                    </option>
                                    <option value="2" ${employee.getEducationDegreeId() == '2' ? "select" : ""}>Đại
                                        học
                                    </option>
                                    <option value="3" ${employee.getEducationDegreeId() == '3' ? "select" : ""}>Cao
                                        đẵng
                                    </option>
                                    <option value="4" ${employee.getEducationDegreeId() == '4' ? "select" : ""}>Trung
                                        cấp
                                    </option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="formInput10">Phòng ban</label>
                                <select class="form-control" id="formInput10" name="divisionId">
                                    <option id="disappearId2">Hãy chọn phòng</option>
                                    <option value="1" ${employee.getDivisionId() == '1' ? "select" : ""}>Bán hàng
                                    </option>
                                    <option value="2" ${employee.getDivisionId() == '2' ? "select" : ""}>Hành chính
                                    </option>
                                    <option value="3" ${employee.getDivisionId() == '3' ? "select" : ""}>Phục vụ
                                    </option>
                                    <option value="4" ${employee.getDivisionId() == '4' ? "select" : ""}>Quản lý
                                    </option>
                                </select>
                            </div>
                            <div class="form-group d-flex align-items-center justify-content-center"
                                 style="margin-top: 25px">
                                <button style="width: 30%" type="button"
                                        class="form-control btn btn-outline-warning mx-5"
                                        id="formInput11">
                                    <a style="text-decoration: none; color: #ffc107"
                                       href="/employee?action=display">Hủy</a>
                                </button>
                                <button style="width: 30%" type="submit"
                                        class="form-control btn btn-outline-success mx-5"
                                        id="formInput12">
                                    Lưu thông tin
                                </button>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy
                            </button>

                            <button class="btn btn-primary">Xóa</button>

                        </div>
                    </div>
                </div>
            </div>
        </form>

        <form action="/employee" method="post">
            <div class="modal fade" id="deleteEmployee" tabindex="-1"
                 aria-labelledby="exampleModalLabel1"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel1">XÓA NHÂN VIÊN</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="text" hidden name="action" value="remove">
                            <input type="text" hidden id="deleteId" name="deleteId">
                            <p>Bạn có chắc chắn muốn xóa?</p>
                            <p id="deleteName"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy
                            </button>

                            <button class="btn btn-primary">Xóa</button>

                        </div>
                    </div>
                </div>
            </div>
        </form>

        <form action="/employee?action=edit" method="post">
            <div class="modal fade" id="editEmployee" tabindex="-1"
                 aria-labelledby="exampleModalLabel2"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel2">Chỉnh sửa nhân viên</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="name">Tên nhân viên</label>
                                <input type="text" class="form-control" id="name" name="name">
                                <input type="text" hidden id="id" name="id">
                            </div>
                            <div class="form-group">
                                <label for="birthday">Ngày sinh</label>
                                <input type="date" class="form-control" id="birthday" name="birthday"
                                       min="1920-01-01" max="${nowDateEndYear}">

                            </div>
                            <div class="form-group">
                                <label for="idCard">Số CCCD</label>
                                <input type="text" class="form-control" id="idCard" name="idCard">
                            </div>
                            <div class="form-group">
                                <label for="salary">Lương</label>
                                <input type="text" class="form-control" id="salary" name="salary">
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber">Số điện thoại</label>
                                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" id="email" name="email">
                            </div>
                            <div class="form-group">
                                <label for="address">Địa chỉ</label>
                                <input type="text" class="form-control" id="address" name="address">
                            </div>
                            <div class="form-group">
                                <label for="positionId">Vị trí</label>
                                <select class="form-control" id="positionId" name="positionId">
                                    <option value="1" ${positionId2 == 1 ? "selected" : ""}  id="positionId1" name="positionId1">Quản lý
                                    </option>
                                    <option value="2" ${positionId2 == 2 ? "selected" : ""} id="positionId2" name="positionId2">Nhân viên
                                    </option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="educationDegreeId">Trình độ</label>
                                <select class="form-control" id="educationDegreeId" name="educationDegreeId">
                                    <option value="4">Sau đại
                                        học
                                    </option>
                                    <option value="3">Đại
                                        học
                                    </option>
                                    <option value="2">Cao
                                        đẵng
                                    </option>
                                    <option value="1">Trung
                                        cấp
                                    </option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="divisionId">Phòng ban</label>
                                <select class="form-control" id="divisionId" name="divisionId">
                                    <option value="1">Bán hàng
                                    </option>
                                    <option value="2">Hành chính
                                    </option>
                                    <option value="3">Phục vụ
                                    </option>
                                    <option value="4">Quản lý
                                    </option>
                                </select>
                            </div>
                            <div class="form-group d-flex align-items-center justify-content-center"
                                 style="margin-top: 25px">
                                <button style="width: 30%" type="button"
                                        class="form-control btn btn-outline-warning mx-5"
                                        id="form11">
                                    <a style="text-decoration: none; color: #ffc107"
                                       href="/employee?action=display">Hủy</a>
                                </button>
                                <button style="width: 30%" type="submit"
                                        class="form-control btn btn-outline-success mx-5"
                                        id="form12">
                                    Lưu thông tin
                                </button>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy
                            </button>

                            <button class="btn btn-primary">Xóa</button>

                        </div>
                    </div>
                </div>
            </div>
        </form>

    </div>

    <footer class=" bg-light text-center text-lg-start fixed-bottom" style="height: 50px">
        <div class="text-center p-3" style="background-color: #157347;">
            © 2022 Copyright:
            <a class="text-dark" href="/index.jsp">Furama Resort</a>
        </div>

    </footer>

</div>

</body>

<script>
    function getEditEmployee(id, name, birthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId) {
        document.getElementById("id").value = id;
        document.getElementById("name").value = name;
        document.getElementById("birthday").value = birthday;
        document.getElementById("idCard").value = idCard;
        document.getElementById("salary").value = salary;
        document.getElementById("phoneNumber").value = phoneNumber;
        document.getElementById("email").value = email;
        document.getElementById("address").value = address;
        document.getElementById("positionId").value = positionId;
        document.getElementById("educationDegreeId").value = educationDegreeId;
        document.getElementById("divisionId").value = divisionId;
    }

    function getId(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }

    function disappear() {
        document.getElementById("disappearId").style.display = "none";
        document.getElementById("disappearId1").style.display = "none";
        document.getElementById("disappearId2").style.display = "none";
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });

    });

</script>
</html>
