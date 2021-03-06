<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.zilker.properties.ReadFromPropertiesFile"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/button-style.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
<title>Home</title>
</head>
<body onload="blink();">
	<center>
		<h1>Home Page</h1>
	</center>
	<h2 id="head">
		Welcome
		<%
		out.println(ReadFromPropertiesFile.getProperties("admin"));
	%>
	</h2>
	<form method="post" action="insertmatch.jsp"
		class="form-navigate insert">
		<input class="navigate" type="submit" value="Insert Match">
	</form>
	<form method="post" action="RetrievePlayerServlet"
		class="form-navigate player">
		<input class="navigate" type="submit" value="Retrieve Players">
	</form>
	<form method="post" action="RetrieveMatchServlet"
		class="form-navigate match">
		<input class="navigate" type="submit" value="Retrieve Matches">
	</form>
	<form method="post" action="MostImprovedServlet"
		class="form-navigate improve">
		<input class="navigate" type="submit"
			value="Find Most Improved Player">
	</form>
	<form method="post" action="playermatch.jsp"
		class="form-navigate player-match">
		<input class="navigate" type="submit" value="Find Matches of a Player">
	</form>
	<form method="post" action="twoplayermatch.jsp"
		class="form-navigate players">
		<input class="navigate" type="submit"
			value="Find Matches between Players">
	</form>
	<form method="post" action="playertour.jsp" class="form-navigate tour">
		<input class="navigate" type="submit"
			value="Find Player Results in Tournament">
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
	<%
		Locale aLocale = new Locale("en", "US");
		Locale frLocale = new Locale("fr", "FR");
		Locale dLocale =Locale.getDefault();
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", dLocale);
		out.println("<h2>" + messages.getString("greetings") + " from  " + dLocale.getDisplayCountry() + 
				"</h2>");
	%>
	<fmt:setBundle basename="MessagesBundle_fr_FR" var="lang" />
	<fmt:setLocale value="fr" />
	<fmt:message key="greetings" bundle="${lang}" />
	<br />
	<script src="js/home.js"></script>
</body>
</html>