<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.zilker.dto.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body onload="blink();">
	<center>
		<h1>Home Page</h1>
	</center>
	<h2 id="para">Welcome ${username}</h2>
	<form method="post" action="RetrievePlayerServlet"
		class="form-navigate insert">
		<input class="navigate" type="submit" value="Retrieve Players">
	</form>
	<form method="post" action="twoplayermatch.jsp"
		class="form-navigate player">
		<input class="navigate" type="submit"
			value="Find Matches between Players">
	</form>
	<form method="post" action="playertour.jsp" class="form-navigate match">
		<input class="navigate" type="submit"
			value="Find Player Results in Tournament">
	</form>
	<form method="post" action="SortPlayerServlet"
		class="form-navigate improve">
		<input class="navigate" type="submit" value="View Sorted List by Name">
	</form>
	<form method="post" action="LogoutServlet" class="button-form-logout">
		<input class="logoutButton" type="submit" value="Logout">
	</form>
	<div class="sponsor-div">
		<img
			src="https://static.wixstatic.com/media/6fddee_b56667a4759c4b8984c877fa4752ba81.gif"
			alt="Sponsor">
	</div>
	<div class="partner-div">
		<img
			src="http://bwfworldchampionships.com/wp-content/uploads/2014/07/BWF_logo_holding_device1.jpg"
			alt="Partner">
	</div>
<script src="js/home.js"></script>
</body>
</html>