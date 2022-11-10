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
                <div class="collapse navbar-collapse" id="navbarSupportedContent d-md" >
                    <div class="col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3"></div>
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 col-xxl-8 col-xl-8 col-lg-6 col-md-6 col-sm-6 justify-content-center">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="https://furamavietnam.com/the-resort/">THE
                                RESORT</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                DỊCH VỤ
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Danh sách dịch vụ</a></li>
                                <li><a class="dropdown-item" href="#">Thêm mới dịch vụ</a></li>
                                <li><a class="dropdown-item" href="#">Chỉnh sửa dịch vụ</a></li>
                                <li><a class="dropdown-item" href="#">Xóa dịch vụ</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown1" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                KHÁCH HÀNG
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Danh sách khách hàng</a></li>
                                <li><a class="dropdown-item" href="#">Thêm mới khách hàng</a></li>
                                <li><a class="dropdown-item" href="#">Chỉnh sửa khách hàng</a></li>
                                <li><a class="dropdown-item" href="#">Xóa khách hàng</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown2" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                NHÂN VIÊN
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Danh sách nhân viên</a></li>
                                <li><a class="dropdown-item" href="#">Thêm mới nhân viên</a></li>
                                <li><a class="dropdown-item" href="#">Chỉnh sửa nhân viên</a></li>
                                <li><a class="dropdown-item" href="#">Xóa nhân viên</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown3" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                HỢP ĐỒNG
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Danh sách hợp đồng</a></li>
                                <li><a class="dropdown-item" href="#">Thêm mới hợp đồng</a></li>
                                <li><a class="dropdown-item" href="#">Chỉnh sửa hợp đồng</a></li>
                                <li><a class="dropdown-item" href="#">Xóa hợp đồng</a></li>
                            </ul>
                        </li>
                    </ul>

                    <form class="d-flex col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3 mt-4" style="height: 50px;">
                        <div class="d-flex align-items-center" style="height: 40px;">
                            <input class="form-control me-2" type="search" placeholder="Tim kiếm" aria-label="Tiềm kiếm">
                        </div >
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
            <div class="col-1"></div>
            <div class="col-10">
                <h1>DANH SÁCH KHÁCH HÀNG</h1>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-outline-success" data-bs-toggle="modal"
                        data-bs-target="#addEmployee${product.getId()}">Thêm mới</button>
            </div>
            <div class="modal fade" id="addEmployee${product.getId()}" tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editProduct${product.getId()}">SỬA THÔNG TIN NHÂN VIÊN</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-footer d-flex justify-content-center">
                            <form class="my-2" action="/product?action=remove&id=${product.getId()}"
                                  method="post">
                                <div class="form-group">
                                    <label for="formAdd">Tên nhân viên</label>
                                    <input type="text" class="form-control" id="formAdd">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd1">Ngày sinh</label>
                                    <input type="text" class="form-control" id="formAdd1">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd4">Số CCCD</label>
                                    <input type="text" class="form-control" id="formAdd4">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd5">Lương</label>
                                    <input type="text" class="form-control" id="formAdd5">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd6">Số điện thoại</label>
                                    <input type="text" class="form-control" id="formAdd6">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd7">Email</label>
                                    <input type="text" class="form-control" id="formAdd7">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd8">Địa chỉ</label>
                                    <input type="text" class="form-control" id="formAdd8">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd9">Chức vụ</label>
                                    <input type="text" class="form-control" id="formAdd9">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd10">Trình độ học vấn</label>
                                    <input type="text" class="form-control" id="formAdd10">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd11">Phân công</label>
                                    <input type="text" class="form-control" id="formAdd11">
                                </div>
                                <div class="form-group">
                                    <label for="formAdd12">Tài khoản</label>
                                    <input type="text" class="form-control" id="formAdd12">
                                </div>
                                <div class="form-group d-flex align-items-center justify-content-center"
                                     style="margin-top: 25px">
                                    <input style="width: 30%" type="button"
                                           class="form-control btn btn-outline-warning mx-5" id="formAdd13"
                                           value="Hủy">
                                    <input style="width: 30%" type="button"
                                           class="form-control btn btn-outline-success mx-5 d-flex justify-content-center" id="formAdd14"
                                           value="Lưu thông tin">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
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
                <th scope="col">Chức vụ</th>
                <th scope="col">Trình độ học vấn</th>
                <th scope="col">Phân công</th>
                <th scope="col">Tài khoản</th>
                <th scope="col">Sửa</th>
                <th scope="col">Xóa</th>
            </tr>
            <tr class="align-middle text-center">
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>
                    <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                            data-bs-target="#editEmployee${product.getId()}">Sửa
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                            data-bs-target="#deleteEmployee${product.getId()}">Xóa
                    </button>
                </td>
            </tr>
            <div class="modal fade" id="editEmployee${product.getId()}" tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editEmployee${product.getId()}">SỬA THÔNG TIN NHÂN VIÊN</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-footer d-flex justify-content-center">
                            <form class="my-5" action="/product?action=remove&id=${product.getId()}"
                                  method="post">
                                <div class="form-group">
                                    <label for="formInput">Tên nhân viên</label>
                                    <input type="text" class="form-control" id="formInput">
                                </div>
                                <div class="form-group">
                                    <label for="formInput1">Ngày sinh</label>
                                    <input type="text" class="form-control" id="formInput1">
                                </div>
                                <div class="form-group">
                                    <label for="formInput4">Số CCCD</label>
                                    <input type="text" class="form-control" id="formInput4">
                                </div>
                                <div class="form-group">
                                    <label for="formInput5">Lương</label>
                                    <input type="text" class="form-control" id="formInput5">
                                </div>
                                <div class="form-group">
                                    <label for="formInput6">Số điện thoại</label>
                                    <input type="text" class="form-control" id="formInput6">
                                </div>
                                <div class="form-group">
                                    <label for="formInput7">Email</label>
                                    <input type="text" class="form-control" id="formInput7">
                                </div>
                                <div class="form-group">
                                    <label for="formInput8">Địa chỉ</label>
                                    <input type="text" class="form-control" id="formInput8">
                                </div>
                                <div class="form-group">
                                    <label for="formInput9">Chức vụ</label>
                                    <input type="text" class="form-control" id="formInput9">
                                </div>
                                <div class="form-group">
                                    <label for="formInput10">Trình độ học vấn</label>
                                    <input type="text" class="form-control" id="formInput10">
                                </div>
                                <div class="form-group">
                                    <label for="formInput11">Phân công</label>
                                    <input type="text" class="form-control" id="formInput11">
                                </div>
                                <div class="form-group">
                                    <label for="formInput12">Tài khoản</label>
                                    <input type="text" class="form-control" id="formInput12">
                                </div>
                                <div class="form-group d-flex align-items-center justify-content-center"
                                     style="margin-top: 25px">
                                    <input style="width: 30%" type="button"
                                           class="form-control btn btn-outline-warning mx-5" id="formInput13"
                                           value="Hủy">
                                    <input style="width: 30%" type="button"
                                           class="form-control btn btn-outline-success mx-5 d-flex justify-content-center" id="formInput14"
                                           value="Lưu thông tin">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="deleteEmployee${product.getId()}" tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="deleteProduct${product.getId()}">DELETE</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Bạn có chắc chắn muốn xóa?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy
                            </button>
                            <form action="/product?action=remove&id=${product.getId()}"
                                  method="post">
                                <button class="btn btn-primary">Xóa</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <tr class="align-middle text-center">
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>
                    <button type="button" class="btn btn-outline-warning">Sửa</button>
                </td>
                <td>
                    <button type="button" class="btn btn-outline-danger">Xóa</button>
                </td>
            </tr>
            <tr class="align-middle text-center">
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>
                    <button type="button" class="btn btn-outline-warning">Sửa</button>
                </td>
                <td>
                    <button type="button" class="btn btn-outline-danger">Xóa</button>
                </td>
            </tr>
        </table>
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
        crossorigin="anonymous"></script>

</html>
