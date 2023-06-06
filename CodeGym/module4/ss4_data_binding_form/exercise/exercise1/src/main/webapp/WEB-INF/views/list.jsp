<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 22/11/2022
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome</h1>
<h3>Account: ${emailConfig.account}</h3>
<h3>Language: ${emailConfig.language}</h3>
<h3>Page Size: ${emailConfig.pageSize}</h3>
<h3>Spams Fillter : ${emailConfig.spamsFilter}</h3>
<h3>Signature : ${emailConfig.signature}</h3>
</body>
</html>
