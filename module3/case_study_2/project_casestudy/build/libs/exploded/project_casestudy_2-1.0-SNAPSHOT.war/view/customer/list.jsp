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
    <title>Khách hàng</title>

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

                    <%@ include file="/nav.jsp"%>

                    <form class="d-flex col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3 mt-4" style="height: 50px;"
                          action="/customer">
                        <div class="d-flex align-items-center" style="height: 40px;">
                            <input type="text" hidden name="action" value="searchCustomerUseFacility">
                            <input class="form-control me-2" name="search" type="search" placeholder="Tim tên và địa chỉ"
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
                <h1>DANH SÁCH KHÁCH HÀNG</h1>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-outline-success">
                    <a style="text-decoration: none; color: #198754" href="/customer?action=add ">Thêm mới</a>
                </button>
            </div>
        </div>
        <table class="table table-striped table-hover" style="width: 100%" id="tableCustomer">
            <thead>
            <tr class="align-middle text-center">
                <th scope="col">Stt</th>
                <th scope="col">Tên khách hàng</th>
                <th scope="col">Loại khách hàng</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Số CCCD</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Email</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Sửa</th>
                <th scope="col">Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customerList}" varStatus="status">
                <tr class="align-middle text-center">
                    <th>${status.count}</th>
                    <td>${customer.getName()}</td>
                    <td>${customer.getNameCustomerType()}</td>
                    <td>${customer.getBirthday()}</td>
                    <td>${customer.getGender()}</td>
                    <td>${customer.getIdCard()}</td>
                    <td>${customer.getPhoneNumber()}</td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getAddress()}</td>
                    <td>
                        <button type="button" class="btn btn-outline-warning"><a
                                style="text-decoration: none; color: #ffc107"
                                href="/customer?action=edit&id=${customer.getId()}">Sửa</a>
                        </button>
                    </td>
                    <td>
                        <button onclick="getId('${customer.getId()}','${customer.getName()}')" type="button"
                                class="btn btn-outline-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteProduct">Xóa
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <form action="/customer" method="post">
            <div class="modal fade" id="deleteProduct" tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">XÓA KHÁCH HÀNG</h5>
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
    function getId(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
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
