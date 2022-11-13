<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 10/11/2022
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>navbar</title>
</head>
<body>
<ul class="navbar-nav me-auto mb-2 mb-lg-0 col-xxl-8 col-xl-8 col-lg-6 col-md-6 col-sm-6 justify-content-center">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/index.jsp">THE
            RESORT</a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button"
           data-bs-toggle="dropdown" aria-expanded="false">
            DỊCH VỤ
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/facility?action=display">Danh sách dịch vụ</a></li>
            <li><a class="dropdown-item" href="/facility?action=add&facilityType=Villa">Thêm mới villa</a></li>
            <li><a class="dropdown-item" href="/facility?action=add&facilityType=House">Thêm mới house</a></li>
            <li><a class="dropdown-item" href="/facility?action=add&facilityType=Room">Thêm mới room</a></li>
        </ul>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown1" role="button"
           data-bs-toggle="dropdown" aria-expanded="false">
            KHÁCH HÀNG
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/customer?action=display">Danh sách khách hàng</a></li>
            <li><a class="dropdown-item" href="/customer?action=add">Thêm mới khách hàng</a></li>
            <li><a class="dropdown-item" href="/customer?action=displayUseFacility">Khách hàng dùng dịch vụ</a></li>
        </ul>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown2" role="button"
           data-bs-toggle="dropdown" aria-expanded="false">
            NHÂN VIÊN
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/employee?action=display">Danh sách nhân viên</a></li>
            <li><a class="dropdown-item" href="#">Thêm mới nhân viên</a></li>
        </ul>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown3" role="button"
           data-bs-toggle="dropdown" aria-expanded="false">
            HỢP ĐỒNG
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/contract?action=display">Danh sách hợp đồng</a></li>
            <li><a class="dropdown-item" href="/contract?action=add">Thêm mới hợp đồng</a></li>
<%--            <li><a class="dropdown-item" href="#">Chỉnh sửa hợp đồng</a></li>--%>
<%--            <li><a class="dropdown-item" href="#">Xóa hợp đồng</a></li>--%>
        </ul>
    </li>
</ul>
</body>
</html>
