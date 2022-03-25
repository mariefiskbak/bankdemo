<%--
  Created by IntelliJ IDEA.
  User: marie_t5vmzpd
  Date: 25-03-2022
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Skift Password</title>
</head>
<body>
<h1 style="color: red">${requestScope.fejlSkiftPassword}</h1>
<form action="SkiftPasswordServlet" method="post">
    <label for="nytPassword1">Nyt password</label><br>
    <input type="password" id="nytPassword1" name="nytPassword1" value=""><br>
    <label for="nytPassword2">Gentag password</label><br>
    <input type="password" id="nytPassword2" name="nytPassword2" value=""><br><br>
    <input type="submit" value="Skift password">
</form>
</body>
</html>
