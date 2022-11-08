<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 06/11/2022
  Time: 08:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Furama Resort</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div>

    <header class="row d-flex justify-content-between align-items-center">
        <div class="col-1">
            <div class="card m-3" style="width: 4rem;">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" class="card-img-top"
                     alt="Furama resort">
            </div>
        </div>
        <div class="col-9">

        </div>
        <div class="d-flex col-2">
            <button type="button" class="btn btn-success my-5 mx-1">Đăng nhập</button>
            <button type="button" class="btn btn-warning my-5 mx-1">Đăng ký</button>
        </div>

    </header>

    <div class="row sticky-top" style="height: 50px;">
      <nav class="navbar navbar-expand-lg navbar-light bg-success" style="height: 50px;">
        <div class="container-fluid">
          <div class="collapse navbar-collapse" id="navbarSupportedContent d-md" >
            <div class="col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3"></div>
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
                  <li><a class="dropdown-item" href="/facility?action=add">Thêm mới dịch vụ</a></li>
                  <li><a class="dropdown-item" href="/facility?action=edit">Chỉnh sửa dịch vụ</a></li>
                  <li><a class="dropdown-item" href="/facility?action=display">Xóa dịch vụ</a></li>
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
                  <li><a class="dropdown-item" href="/customer?action=display">Chỉnh sửa khách hàng</a></li>
                  <li><a class="dropdown-item" href="/customer?action=display">Xóa khách hàng</a></li>
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

    <div class="row">
        <aside class="col-xxl-2 col-xl-2 col-lg-2 col-md-2 col-sm-12 d-flex flex-column align-items-center justify-content-center">
            <div class="card m-3" style="width: 85%;">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/07/CULIRARY.jpg" class="card-img-top"
                     alt="...">
                <div class="card-body">
                    <img src="https://furamavietnam.com/wp-content/uploads/2020/02/logo-indochine-2-w500-new2.png"
                         class="card-img-top" alt="...">
                </div>
            </div>
            <div class="card m-3" style="width: 85%;">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo-the-DON-w500-F.jpg"
                     class="card-img-top" alt="...">
                <div class="card-body">
                    <img src="https://furamavietnam.com/wp-content/uploads/2019/04/logo-don-3-w500.png"
                         class="card-img-top" alt="...">
                </div>
            </div>
            <div class="card m-3" style="width: 85%;">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo-the-DANAK-w500-F.jpg"
                     class="card-img-top" alt="...">
                <div class="card-body">
                    <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo-the-DANAK-2-w500.png"
                         class="card-img-top" alt="...">
                </div>
            </div>
            <div class="card m-3" style="width: 85%;">
                <img src="https://furamavietnam.com/wp-content/uploads/2020/07/Vietnam_Danang_Furama-Resort_Lobby-Hai-Van-Lounge.jpg"
                     class="card-img-top" alt="...">
                <div class="card-body">
                    <img src="https://furamavietnam.com/wp-content/uploads/2019/04/logo-don-3-w500.png"
                         class="card-img-top" alt="...">
                </div>
            </div>
            <div class="card m-3" style="width: 85%;">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo-the-OCEAN-w500-F.jpg"
                     class="card-img-top" alt="...">
                <div class="card-body">
                    <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo-the-OCEAN-w500.png"
                         class="card-img-top" alt="...">
                </div>
            </div>
        </aside>
        <section class="col-xxl-10 col-xl-10 col-lg-10 col-md-10 col-sm-12 row d-flex justify-content-center h-50">
            <div id="carouselExampleDark" class="carousel carousel-dark slide col-10 my-5" data-bs-ride="carousel"
                 style="height: 80%">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="3"
                            aria-label="Slide 4"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="4"
                            aria-label="Slide 5"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="5"
                            aria-label="Slide 6"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="6"
                            aria-label="Slide 7"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval=500">
                        <img src="https://pix8.agoda.net/hotelImages/186/186566/186566_16093015410047181139.jpg?ca=6&ce=1&s=1024x768"
                             class="d-block w-100" alt="..." width="100%">
                    </div>
                    <div class="carousel-item" data-bs-interval="500">
                        <img src="https://pix8.agoda.net/hotelImages/186/186566/186566_16093015480047181702.jpg?ca=6&ce=1&s=1024x768"
                             class="d-block w-100" alt="..." width="100%">
                    </div>
                    <div class="carousel-item" data-bs-interval="500">
                        <img src="https://pix8.agoda.net/hotelImages/186/186566/186566_16093015300047180296.jpg?ca=6&ce=1&s=1024x768"
                             class="d-block w-100" alt="..." width="100%">
                    </div>
                    <div class="carousel-item" data-bs-interval="500">
                        <img src="https://pix8.agoda.net/hotelImages/186/186566/186566_16093015500047181828.jpg?ca=6&ce=1&s=1024x768"
                             class="d-block w-100" alt="..." width="100%">
                    </div>
                    <div class="carousel-item" data-bs-interval="500">
                        <img src="https://pix8.agoda.net/hotelImages/186/186566/186566_16093014470047175983.jpg?ca=6&ce=1&s=1024x768"
                             class="d-block w-100" alt="..." width="100%">
                    </div>
                    <div class="carousel-item">
                        <img src="https://pix8.agoda.net/hotelImages/186/186566/186566_16093015390047181047.jpg?ca=6&ce=1&s=1024x768"
                             class="d-block w-100" alt="..." width="100%">
                    </div>
                    <div class="carousel-item" data-bs-interval="500">
                        <img src="https://pix8.agoda.net/hotelImages/186/186566/186566_16093015300047180293.jpg?ca=6&ce=1&s=1024x768"
                             class="d-block w-100" alt="..." width="100%">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </section>
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
