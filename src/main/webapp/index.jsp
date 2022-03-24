<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<h1>Kontiliste</h1>
<c:forEach items="${applicationScope.konti}" var="element">
    ${element.value.navn}: ${element.value.saldo} <br>

</c:forEach>
<h1>Her kan du logge ind på din konto</h1>

<h1>${requestScope.fejl }</h1>
<form action="LoginServlet">
    <label for="name">Navn:</label><br>
    <input type="text" id="name" name="name" value="John"><br>
    <label for="pass">Angiv kode:</label><br>
    <input type="password" id="pass" name="pass" value="kode"><br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>