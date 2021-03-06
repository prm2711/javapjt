<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Players List</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
<link rel="stylesheet" type="text/css" href="css/display.css">
</head>
<body>
	<%@ page import="com.zilker.dto.*"%>
	<%@ page import="java.util.ArrayList"%>
	<table>
		<tr>
			<th>Player Name</th>
			<th>Country</th>
			<th>Original Points</th>
			<th>New Points</th>
			<th>Number of Matches</th>
			<th>Won</th>
			<th>Lost</th>
			<th>Draw</th>
		</tr>
		<c:forEach var="p" items="${play}">
		<tr>
			<td>${p.getPlayerName()}</td>
			<td>${p.getCountry()}</td>
			<td>${p.getOrig()}</td>
			<td>${p.getNew()}</td>
			<td>${p.getNumber()}</td>
			<td>${p.getWon()}</td>
			<td>${p.getLost()}</td>
			<td>${p.getDraw()}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%
		if (session.getAttribute("name").equals("admin")) {
	%>
	<form method="post" action="home.jsp" class="button-form-home">
		<input class="homeButton" type="submit" value="Home">
	</form>
	<%
		} else if (session.getAttribute("name").equals("user")) {
	%>
	<form method="post" action="userhome.jsp" class="button-form-home">
		<input class="homeButton" type="submit" value="Home">
	</form>
	<%
		}
	%>
	<form method="post" action="LogoutServlet" class="button-form-logout">
		<input class="logoutButton" type="submit" value="Logout">
	</form>
</body>
</html>