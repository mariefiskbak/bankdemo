<%--
  Created by IntelliJ IDEA.
  User: marie_t5vmzpd
  Date: 24-03-2022
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Din side</title>
</head>
<body>
<h1>Velkommen, du er nu logget ind på din konto ${sessionScope.konto.navn}</h1>
<h2>Din saldo er ${sessionScope.konto.saldo}</h2>
</body>
</html>
