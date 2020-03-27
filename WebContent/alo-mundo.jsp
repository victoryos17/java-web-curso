<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alo Mundo JSP</title>
</head>
<body>
<h1>Alo Mundo</h1>
<p>Contexto: <%= request.getContextPath() %></p>
<p>Data/hora: <%= LocalDateTime.now().format( DateTimeFormatter.ISO_LOCAL_DATE_TIME) %></p>
</body>
</html>