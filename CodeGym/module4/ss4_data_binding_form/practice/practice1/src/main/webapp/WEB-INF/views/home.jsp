<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Information</title>

</head>
<body>
<h2>Submitted Employee Information</h2>
<button><a href="showAddForm">ADD</a></button>
<table>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>Name:</td>
            <td>${employee.getName()}</td>
        </tr>
        <tr>
            <td>ID:</td>
            <td>${employee.getId()}</td>
        </tr>
        <tr>
            <td>Contact Number:</td>
            <td>${employee.getContractNumber()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
