<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Match</title>
<link rel="stylesheet" type="text/css" href="css/insertpage.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
</head>
<body>
	<form method="post" action="InsertMatchServlet" class="insert-form"
		onsubmit="return validateForm()">
		<h2>Insert a Match</h2>
		<input type="text" name="tourname" id="tourname"
			placeholder="Tournament Name" /> <br>
		<input type="text" name="player1" id="player1" placeholder="Player1" /><br>
		<input type="text" name="player2" id="player2" placeholder="Player2" /><br>
		<input type="text" name="winner" id="winner" placeholder="Winner" /><br>
		<input type="text" name="loser" id="loser" placeholder="Loser" /><br>
		<input type="text" name="status" id="status" placeholder="Status" /><br>
		<input type="text" name="score" id="score" placeholder="Score" /><br>
		<input class="submitButton" type="submit" value="Insert Match">
	</form>
	<form method="post" action="home.jsp" class="button-form-home">
		<input type="submit" value="Home" class="homeButton">
	</form>
	<br>
	<form method="post" action="LogoutServlet" class="button-form-logout">
		<input type="submit" value="Logout" class="logoutButton">
	</form>
	<script src="js/validateinsert.js"></script>
</body>
</html>