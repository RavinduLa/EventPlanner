<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Payments</title>
</head>
<body>
<form action = "edit" method = "post">

Payments did correctly? 
		<input type="Radio" id="yes" name="pay" ><label for="Yes"> Yes</label>
		<input type="Radio" id= "No" name="pay"><label for="No "> No</label><br><br>
		
Attendance 
		<select id = "attendanceSelect" name = "attendanceSelect">
		<option value = "Presence">Presence</option>
		<option value = "absence">Absence</option>
		</select><br><br>
		
		<input type = "submit" name= "presence" value= "update Attendance">
		
</form>
</body>
</html>