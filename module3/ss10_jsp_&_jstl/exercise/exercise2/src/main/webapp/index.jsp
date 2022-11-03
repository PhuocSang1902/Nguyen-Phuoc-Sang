<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 03/11/2022
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body style="font-family: 'Averia Serif Libre';
  margin: auto;
  margin-top: 25vh;
  width: 320px; height: 320px;">
<fieldset>
    <legend>Calculator</legend>
    <form method="post" action="/calculator">
        <table>
            <tr>
                <td style="">First operand</td>
                <td>
                    <div class="input-group flex-nowrap">
                        <input type="text" class="form-control" placeholder="First operand"
                               aria-describedby="addon-wrapping" name="fOperand" style="border: solid black 1px">
                    </div>
                </td>
            </tr>
            <tr>
                <td>Second operand</td>
                <td>
                    <div class="input-group flex-nowrap">
                        <input type="text" class="form-control" placeholder="Second operand"
                               aria-describedby="addon-wrapping" name="sOperand" style="border: solid black 1px">
                    </div>
                </td>
            </tr>
            <tr>
                <td>Operator</td>
                <td>
                    <select class="form-select" name="math" aria-label="Default select example">
                        <option selected>Open this select menu</option>
                        <option value="Addition">Addition</option>
                        <option value="Subtraction">Subtraction</option>
                        <option value="Multiplication">Multiplication</option>
                        <option value="Division">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="calculate">
                </td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
