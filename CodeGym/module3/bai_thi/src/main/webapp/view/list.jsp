<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 15/11/2022
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="datatables/scc/dataTables.bootstrap5.min.css">
</head>
<body>
<div class="vh-100">
    <c:import url="/header.jsp"></c:import>
    <c:import url="/nav.jsp"></c:import>
        <form class="form-inline my-2 my-lg-0">
            <div class="row my-3">
                <div class="col-2">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                </div>
                <div class="col-1">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </div>
                <div class="col-1">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="button">
                        <a href="/motel?action=displayAddForm" style="text-decoration: none; color: #198754">Thêm</a>
                    </button>
                </div>
            </div>
        </form>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Tên người thuê</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Ngày bắt đầu</th>
                <th scope="col">Hình thức thanh toán</th>
                <th scope="col">Sửa</th>
                <th scope="col">Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="motel" items="${motelList}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${motel.getName()}</td>
                    <td>${motel.getPhoneNumber()}</td>
                    <td>${motel.getRentDate()}</td>
                    <td>${motel.getPaymentType().getName()}</td>
                    <td>
                        <button type="button" class="btn btn-outline-warning"><a
                                style="text-decoration: none; color: #ffc107"
                                href="/motel?action=edit&id=${motel.getId()}">Sửa</a>
                        </button>
                    </td>
                    <td>
                        <button onclick="getId('${motel.getId()}','${motel.getName()}')" type="button"
                                class="btn btn-outline-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteProduct">Xóa
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="/motel" method="post">
            <div class="modal fade" id="deleteProduct" tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">XÓA NGƯỜI THUÊ</h5>
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
</div>
</body>
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
<script>
    function getId(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>
</html>
