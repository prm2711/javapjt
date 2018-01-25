<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Players Matches</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
<link rel="stylesheet" type="text/css" href="css/insertpage.css">
</head>
<body>
	<form method="post" action="TwoPlayerMatchServlet" class="insert-form" onsubmit="return validateForm()">
		<input type="text" name="player1" id="player1" placeholder="Enter Player1 Name" /><br>
		<input type="text" name="player2" id="player2" placeholder="Enter Player2 Name " /><br>
		<input class="submitButton" type="submit" value="View Matches">
	</form>
	
	<form method="post" action="home.jsp" class="button-form-home">
		<input class="homeButton" type="submit" value="Home">
	</form>
    <form method="post" action="LogoutServlet" class="button-form-logout">
		<input class="logoutButton" type="submit" value="Logout">
	</form>
<script src="js/validateplayers.js"></script>
</body>
</html>