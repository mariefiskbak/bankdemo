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
<h1>Velkommen, ${sessionScope.konto.navn}, er nu logget ind på din konto </h1>
<h2>Din saldo er: ${sessionScope.konto.saldo}</h2>
<h2>${requestScope.message}</h2>


<h2>Her kan du hæve</h2>
<form action="TransactionServlet">
    <label for="fname">Angiv beløb</label><br>
    <input type="number" id="fname" name="beløb" value="0"><br>

    <input type="submit" value="Hæv">
</form>

</body>
</html>
