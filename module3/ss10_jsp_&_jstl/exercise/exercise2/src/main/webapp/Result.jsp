<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 03/11/2022
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <p>Result</p>
            </td>
            <td>
                <c:choose>
                    <c:when test="${calculator.getMath().equals('Addition')}">
                        <p>${calculator.getFirstOperand() + calculator.getSecondOperand()}</p>
                    </c:when>
                    <c:when test="${calculator.getMath().equals('Subtraction')}">
                        <p>${calculator.getFirstOperand() - calculator.getSecondOperand()}</p>
                    </c:when>
                    <c:when test="${calculator.getMath().equals('Multiplication')}">
                        <p>${calculator.getFirstOperand() * calculator.getSecondOperand()}</p>
                    </c:when>
                    <c:when test="${calculator.getMath().equals('Division')}">
                        <p>${calculator.getFirstOperand() / calculator.getSecondOperand()}</p>
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </table>
</body>
</html>
