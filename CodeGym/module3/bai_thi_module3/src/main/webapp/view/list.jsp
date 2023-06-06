<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 16/11/2022
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách bệnh án</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="datatables/scc/dataTables.bootstrap5.min.css">
</head>
<body>
<div class="vh=100">
    <c:import url="/header.jsp"></c:import>
    <c:import url="/nav.jsp"></c:import>
    <form class="form-inline my-2 my-lg-0">
        <div class="row my-3">
            <div class="col-2">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            </div>
            <div class="col-1">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm</button>
            </div>
            <div class="col-1">
                <button class="btn btn-outline-success my-2 my-sm-0" type="button">
                    <a href="/benhAn?action=displayAddForm" style="text-decoration: none; color: #198754">Thêm</a>
                </button>
            </div>
        </div>
    </form>
    <c:if test="${mess != null}">
        <h5>${mess}</h5>
    </c:if>
    <div>
        <table class="table" id="tableCustomer">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã bệnh án</th>
                <th scope="col">Mã bệnh nhân</th>
                <th scope="col">Tên bệnh nhân</th>
                <th scope="col">Ngày nhập viện</th>
                <th scope="col">Ngày ra viện</th>
                <th scope="col">Lý do</th>
                <th scope="col">Sửa</th>
                <th scope="col">Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="benhAn" items="${benhAnList}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${benhAn.getMaBenhAn()}</td>
                    <td>${benhAn.getBenhNhan().getMa()}</td>
                    <td>${benhAn.getBenhNhan().getTen()}</td>
                    <td>${benhAn.getNgayNhapVien()}</td>
                    <td>${benhAn.getNgayRaVien()}</td>
                    <td>${benhAn.getLyDo()}</td>
                    <td>
                        <button type="button" class="btn btn-outline-warning"><a
                                style="text-decoration: none; color: #ffc107"
                                href="/benhAn?action=displayEditForm&maBenhAn=${benhAn.getMaBenhAn()}">Sửa</a>
                        </button>
                    </td>
                    <td>
                        <button onclick="getId('${benhAn.getMaBenhAn()}')" type="button"
                                class="btn btn-outline-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteProduct">Xóa
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="/benhAn" method="post">
            <div class="modal fade" id="deleteProduct" tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">XÓA BỆNH ÁN</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="text" hidden name="action" value="remove">
                            <input type="text" hidden id="deleteId" name="maBenhAn">
                            <p>Bạn có chắc chắn muốn xóa bệnh án?</p>
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
    function getId(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = id;
    }
</script>
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
