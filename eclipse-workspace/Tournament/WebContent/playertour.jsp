<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player in a Tournament</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
<link rel="stylesheet" type="text/css" href="css/insertpage.css">
</head>
<body>
	<form method="post" action="PlayerTournamentServlet"
		class="insert-form" onsubmit="return validateForm()">
		<input type="text" name="player" id="player"
			placeholder="Enter Player Name" /><br> <input type="text"
			name="tour" id="tour" placeholder="Enter Tournament Name" /><br>
		<input class="submitButton" type="submit" value="View Results">
	</form>

	<form method="post" action="home.jsp" class="button-form-home">
		<input class="homeButton" type="submit" value="Home">
	</form>
	<form method="post" action="LogoutServlet" class="button-form-logout">
		<input class="logoutButton" type="submit" value="Logout">
	</form>
	<script src="js/validateplayertour.js"></script>
</body>
</html>
