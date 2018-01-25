<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Tournament Management</title>
</head>
<body onload="blink();">

	<div class="left-div">

		<h1>E-Tournica: A Badminton Tournament Portal</h1>
		<h2>
			<i>Your stop for badminton updates</i>
		</h2>
		<p id="para">
			<b> Missed a match? Don't worry! You can catch updates of Asian
				Open, Australian Open and French Open on E-Tournica!!</b>


		</p>

	</div>
	<div class="right-div">
		<div class="admin-form">
			<h1>Login</h1>
			<form method="post" action="UserValidationServlet"
				onsubmit="return validateForm()">
				<input type="text" name="username" id="username"
					placeholder="User Name" class="user" /><br> <input
					type="password" name="password" id="password"
					placeholder="Password" class="pass" /><br> <input
					type="submit" value="Login" class="submit" />
			</form>
		</div>
	</div>
	<script src="js/validate.js"></script>
</body>
</html>