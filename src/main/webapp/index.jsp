<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Velkommen til demobanken" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<h1>Kontoliste</h1>
<c:forEach items="${applicationScope.konti}" var="element">
    ${element.value.navn}: ${element.value.saldo} <br>

</c:forEach>
<h1>Her kan du logge ind på din konto</h1>

<h1 style="color: red">${requestScope.fejlTilIndex }</h1>
<form action="LoginServlet">
    <label for="name">Navn:</label><br>
    <input type="text" id="name" name="name" value="otto"><br>
    <label for="pass">Angiv kode:</label><br>
    <input type="password" id="pass" name="pass" value="otto"><br><br>
    <input type="submit" value="Login"> <!-- TODO:logger otto direkte ind -->

</form>

<br><br><br><br>

<h1>Opet konto</h1>
<h3>Password skal indeholde min. 4 char.</h3>
<form action="LoginServlet" method="post">
    <label for="newName">Navn:</label><br>
    <input type="text" id="newName" name="newName" value="John"><br>
    <label for="pass1">Angiv kode:</label><br>
    <input type="password" id="pass1" name="pass1" value=""><br>
    <label for="pass2">Gentag kode:</label><br>
    <input type="password" id="pass2" name="pass2" value=""><br><br>
    <input type="submit" value="Opret bruger">
</form>
<br>
<br>
<h1>Slet bruger</h1>
<form style="color: red" action="SletBrugerServlet">
    <label for="name1"> Navn:</label><br>
    <input type="text" id="name1" name="brugernavn"><br><br>
    <input type="submit" value="Slet bruger">

</form>

</body>
</html>