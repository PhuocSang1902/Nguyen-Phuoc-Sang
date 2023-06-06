<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 21/11/2022
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Email Config</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="d-flex justify-content-center">
    <div class="col-6">
<%--        <c:if test="${mess != null}">--%>
<%--            <h4 style="color: #ff0000">${mess}</h4>--%>
<%--        </c:if>--%>
        <div class="my-5"><h1>SETTINGS</h1></div>
        <form:form cssClass="my-5" action="edit" method="post" modelAttribute="emailConfig">
            <div>
                <form:hidden path="account"/>
                <form:label path="language">Language</form:label>
                <form:select path="language">
                    <form:option value="english" label="English"/>
                    <form:option value="vietnam" label="Vietnamese"/>
                    <form:option value="japanese" label="Japanese"/>
                    <form:option value="chinese" label="Chinese"/>
                </form:select>
            </div>
            <div >
                <form:label path="pageSize">Page Size</form:label>
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="20">20</form:option>
                    <form:option value="25">25</form:option>
                </form:select>
            </div>
            <div>
                <form:label path="spamsFilter">Spams fillter</form:label>
                <form:checkbox path="spamsFilter" value="true"/>
            </div>
            <div>
                <form:label path="signature">Signature</form:label>
                <form:textarea path="signature"/>
            </div>
            <div class="form-group d-flex align-items-center justify-content-center" style="margin-top: 25px">
                <button style="width: 30%" type="button" class="form-control btn btn-outline-info mx-5"
                        id="formInput110">
                    <a href="/list" style="text-decoration: none; color: #0dcaf0">Hủy</a>
                </button>
                <input style="width: 30%" type="submit" class="form-control btn btn-outline-success mx-5"
                       id="formInput11" value="Lưu thông tin">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
