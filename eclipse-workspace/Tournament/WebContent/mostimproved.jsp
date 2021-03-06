<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
<link rel="stylesheet" type="text/css" href="css/display.css">
<title>Most Improved Player</title>
</head>
<body>
	<%@ page import="com.zilker.dto.*"%>
	<%@ page import="java.util.ArrayList"%>
	<c:forEach var="p" items="${player}">
		<p class="caption">${p.getPlayerName()} is most improved and has improvement of
			${p.getNew() - p.getOrig()} points</p>
	</c:forEach>


	<br>
	<br>
	<br>
	<form method="post" action="home.jsp" class="button-form-home">
		<input class="homeButton" type="submit" value="Home">
	</form>
	<form method="post" action="LogoutServlet" class="button-form-logout">
		<input class="logoutButton" type="submit" value="Logout">
	</form>
</body>
</html>