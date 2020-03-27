<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Web Curso - Escolhe Curso</title>
</head>
<body>
	<h1>Curso: ${curso}</h1>
	<ul>
	<c:forEach var="topico" items="${topicos}">
	<li>${topico}</li>
	</c:forEach>
	</ul>
</body>
</html>