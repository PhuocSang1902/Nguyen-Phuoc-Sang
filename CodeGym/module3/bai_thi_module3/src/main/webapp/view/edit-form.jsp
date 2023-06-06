<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 06/11/2022
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Benh an</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="d-flex justify-content-center">
    <div class="col-6">
        <div class="my-5" style="text-align: center"><h1>Chỉnh sửa thông tin benh an</h1></div>
        <form class="my-5" method="post" action="/benhAn?action=edit&maBenhAn=${benhAn.getMaBenhAn()}">
            <div class="form-group">
                <label for="maBenhAn">Mã bệnh án</label>
                <input type="text" readonly class="form-control" id="maBenhAn" name="maBenhAn" value="${benhAn.getMaBenhAn()}">
            </div>
            <div class="form-group">
                <label for="maBenhNhan">Mã bệnh nhan</label>
                <input type="text" readonly class="form-control" id="maBenhNhan" name="maBenhNhan" value="${benhAn.getBenhNhan().getMa()}">
            </div>
            <div class="form-group">
                <label for="tenBenhNhan">Tên bệnh nhan</label>
                <input type="text" pattern="^([A-Z0-9][a-z0-9]+[ ])*([A-Z0-9][a-z0-9]*)$" readonly class="form-control" id="tenBenhNhan" name="tenBenhNhan" value="${benhAn.getBenhNhan().getTen()}">
            </div>
            <div class="form-group">
                <label for="ngayNhapVien">Ngày nhập viện</label>
                <input type="date" class="form-control" id="ngayNhapVien" name="ngayNhapVien"
                       value="${benhAn.getNgayNhapVien()}"
                       min="1920-01-01" max="${nowDateEndYear}">
            </div>
            <div class="form-group">
                <label for="ngayRaVien">Ngày ra viện</label>
                <input type="date" class="form-control" id="ngayRaVien" name="ngayRaVien"
                       value="${benhAn.getNgayRaVien()}"
                       min="1920-01-01" max="${nowDateEndYear}">
            </div>

            <div class="form-group">
                <label for="lyDo">Lý do nhập viện</label>
                <input type="text" class="form-control" id="lyDo" name="lyDo" value="${benhAn.getLyDo()}">
            </div>
            <div class="form-group">
                <label for="phuongPhap">Phương pháp điều trị</label>
                <input type="text" class="form-control" id="phuongPhap" name="phuongPhap" value="${benhAn.getPhuongPhap()}">
            </div>
            <div class="form-group">
                <label for="bacSi">Bác sĩ điều trị</label>
                <input type="text" class="form-control" id="bacSi" name="bacSi" value="${benhAn.getBacSi()}">
            </div>

            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-warning mx-5"
                        id="formInput12">
                    <a style="text-decoration: none; color: #ffc107" href="/benhAn">Hủy</a>
                </button>
                <button style="width: 30%" type="submit" class="form-control btn btn-outline-success mx-5"
                        id="formInput11">
                    Lưu thông tin
                </button>
            </div>

            <div class="form-group d-flex align-items-center justify-content-center"
                 style="margin-top: 25px; margin-bottom: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput13">
                    <a href="/benhAn" style="text-decoration: none; color: #0dcaf0">Danh sách bệnh án</a>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</html>
