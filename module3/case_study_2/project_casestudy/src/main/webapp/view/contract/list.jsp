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
    <title>Hợp đồng</title>

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

                    <c:import url="/nav.jsp"></c:import>

                    <form class="d-flex col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3 mt-4" style="height: 50px;">
                        <div class="d-flex align-items-center" style="height: 40px;">
                            <input class="form-control me-2" type="search" placeholder="Tim kiếm"
                                   aria-label="Tiềm kiếm">
                        </div>
                        <div class="d-flex align-items-center" style="height: 40px;">
                            <button class="btn btn-info" type="submit" style="height: 40px;">Tìm</button>
                        </div>
                    </form>

                </div>
            </div>
        </nav>
    </div>

    <div style="height: 65%">
        <div class="row text-center align-items-center" style="border-bottom: 2px black solid">
            <div class="col-1">
                <button type="button" class="btn btn-outline-success">
                    <a style="text-decoration: none; color: #198754" href="/index.jsp">Trờ lại</a>
                </button>
            </div>
            <div class="col-10">
                <h1>DANH SÁCH HỢP ĐỒNG</h1>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-outline-success">
                    <a style="text-decoration: none; color: #198754" href="/contract?action=add ">Thêm mới</a>
                </button>
            </div>
        </div>
        <table class="table table-striped table-hover" id="tableContract">
            <thead>
            <tr class="align-middle text-center">
                <th scope="col">Stt</th>
                <th scope="col">Mã hđ</th>
                <th scope="col">Ngày bắt đầu</th>
                <th scope="col">Ngày kết thúc</th>
                <th scope="col">Đặt cọc</th>
                <th scope="col">Nhân viên</th>
                <th scope="col">Khách hàng</th>
                <th scope="col">Dịch vụ</th>
                <th scope="col">Giá trị</th>
                <th scope="col">Dịch vụ đi kèm</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${contractList}" varStatus="status">
                <tr class="align-middle text-center">
                    <th>${status.count}</th>
                    <td>${contract.getId()}</td>
                    <td>${contract.getStartDate()}</td>
                    <td>${contract.getEndDate()}</td>
                    <td>${contract.getDeposit()}</td>
                    <td>${contract.getEmployee().getName()}</td>
                    <td>${contract.getCustomer().getName()}</td>
                    <td>${contract.getFacility().getName()}</td>
                    <td>${contractMap.get(contract)}</td>
                    <td>
                        <button onclick="getId('${contract.getId()}')" type="button"
                                class="btn btn-outline-danger" data-bs-toggle="modal"
                                data-bs-target="#addAttachFacility">
                            +
                        </button>
                    </td>
                    <td>
                        <div class="d-flex justify-content-center">
                            <form action="/contract?action=displayListAttachFacility&contractId=${contract.getId()}"
                                  method="post">
                                <button onclick="getContractId('${contract.getId()}')" type="submit"
                                        class="btn btn-outline-danger" data-bs-toggle="modal"
                                        data-bs-target="#attachFacility">Dịch vụ đi kèm
                                </button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:if test="${contractDetailList != null}">
            <form action="/contract" method="get">
                <div class="modal d-block" id="attachFacility" tabindex="-1"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">DANH SÁCH DỊCH VỤ ĐI KÈM</h5>
                            </div>
                            <c:if test="${!contractDetailList.isEmpty()}">
                                <table class="table table-striped table-hover" style="width: 100%" id="tableFacility">
                                    <thead>
                                    <tr class="align-middle text-center">
                                        <th scope="col">Stt</th>
                                        <th scope="col">Dịch vụ đi kèm</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Đơn giá</th>
                                        <th scope="col">Đơn vị</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="contractDetail" items="${contractDetailList}" varStatus="status">
                                        <tr class="align-middle text-center">
                                            <th>${status.count}</th>
                                            <td>${contractDetail.getAttachFacility().getName()}</td>
                                            <td>${contractDetail.getQuantity()}</td>
                                            <td>${contractDetail.getAttachFacility().getCost()}</td>
                                            <td>${contractDetail.getAttachFacility().getUnit()}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                            <c:if test="${contractDetailList.isEmpty()}">
                                <p>Không có dịch vụ đi kèm.</p>
                            </c:if>
                            <input type="text" hidden name="action" value="display">
                                <%--                           <input type="text" hidden id="contractId" name="contractId">--%>
                            <div class="modal-footer">
                                <button style="width: 60px" class="btn btn-primary">Đóng</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </c:if>

        <form action="/contract" method="post">
            <div class="modal fade" id="addAttachFacility" tabindex="-1"
                 aria-labelledby="exampleModalLabel1"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel1">THÊM DỊCH VỤ ĐI KÈM</h5>
                        </div>
                        <div class="form-group">
                            <label for="formInput">Tên dịch vụ đi kèm</label>
                            <select class="form-select" aria-label="Default select example" id="formInput"
                                    name="attachFacilityId" onmouseover="disappear()">
                                <option id="disappearId">Hãy chọn dịch vụ đi kèm</option>
                                <c:forEach var="attachFacility" items="${attachFacilityList}">
                                    <option value="${attachFacility.getId()}" ${attachFacility.getId()==contractDetail.getAttachFacility().getId()? "selected" : ""}>
                                            ${attachFacility.getName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('facilityName') : ""}</p>
                        <div class="form-group">
                            <label for="formInput3">Số lượng</label>
                            <input type="text" class="form-control" id="formInput3" name="quantity"
                                   value="${contractDetail.getQuantity()}" placeholder="Số nguyên lớn hơn 0">
                        </div>
                        <p style="color: red">${!errorMap.isEmpty() ? errorMap.get('maxPeople') : ""}</p>
                        <input type="text" hidden name="action" value="addContractDetail">
                        <input type="text" hidden id="id" name="contractId">
                        <div class="modal-footer">
                            <button style="width: 60px" class="btn btn-primary">Lưu</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <footer class="bg-light text-center text-lg-start">
        <div class="text-center p-3" style="background-color: #157347;">
            © 2022 Copyright:
            <a class="text-dark" href="/index.jsp">Furama Resort</a>
        </div>

    </footer>
</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableContract').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });

    });

</script>
<script>
    function getContractId(id) {
        document.getElementById("contractId").value = id;
    }

    function getId(id) {
        document.getElementById("id").value = id;
    }

    function disappear() {
        document.getElementById("disappearId").style.display = "none";
    }
</script>

</html>
