<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zilker.dto.*"%>
<%@ page import="com.zilker.dao.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player Matches List</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
<link rel="stylesheet" type="text/css" href="css/display.css">
</head>
<body>
	<table>
		<tr>
			<th>Tournament Name</th>
			<th>Player 1</th>
			<th>Player 2</th>
			<th>Winner</th>
			<th>Loser</th>
			<th>Status</th>
			<th>Score</th>
		</tr>
		<c:forEach var="m" items="${list}">
		<tr>
			
			<td>${m.tour}</td>
			<td>${m.play1 }</td>
			<td>${m.play2 }</td>
			<c:choose>
			<c:when test="${m.status == 'Complete'}">
			<td>${m.winner }</td>
			<td>${m.loser }</td>
			</c:when>
			<c:otherwise>
			<td>Nil</td>
			<td>Nil</td>
			</c:otherwise>
			</c:choose>
			<td>${m.status }</td>
			<td>${m.score}</td>
		
		</tr>
		</c:forEach>
	</table>
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