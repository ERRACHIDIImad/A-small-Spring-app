<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clients</title>
</head>
<body>


	<form method="get" action="${pageContext.request.contextPath}/GetClientByFirstName">
		<label from="prenom">Prénom</label> <input type="text" id="prenom"  value="${Prénom}"
			name="prenom" /> <input type="submit" value="Chercher"/>
	</form>

<table border="1" >
<tr><th>Nom</th><th>PRENOM</th><th>TEL</th></tr>
<c:forEach  var="Client" items="${Clients}">
<tr><td>${Client.nom}</td><td>${Client.prenom}</td><td>${Client.tel}</td></tr>
</c:forEach>
</table>









</body>
</html>