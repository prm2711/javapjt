<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student form</title>
<!-- <link rel="stylesheet" type="text/css" href="css/format.css"> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
${msg}
		
		<div align="center" class="inner_container">
			<form id="loginForm" action="save"
				onsubmit="return validateForm()" >

				<h1 class="heading">Student Details</h1>
				<p class="label1">Student Roll Number:</p>
				<br> <input class="text-box1" type="text" name="roll_no"
					id="roll_no"><br> <br>
				<p class="label2">Student Name:</p>
				<br> <input class="text-box2" type="text" name="student_name"
					id="student_name"><br> <br>
				<p class="label3">Student Marks in Math:</p>
				<br> <input class="text-box3" type="text" name="marks"
					id="marks"><br> <br>
				<p class="label4">Student Marks in Physics:</p>
				<br> <input class="text-box4" type="text" name="marksphy"
					id="marksphy"><br> <br>
				<p class="label5">Student Marks in Chemistry:</p>
				<br> <input class="text-box5" type="text" name="markschem"
					id="markschem"><br> <br> 
					<input class="submitButton" type="submit" value="Submit">

			</form>
		</div>
		<div class="bottom_container"></div>

	<!-- <script src="js/insertdata.js"></script> -->
</body>
</html>