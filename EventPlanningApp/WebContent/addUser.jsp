<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New  User</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminOnlyValidation.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	
	<h3> Add new user</h3>
	<form method="POST" action = "AddUserServlet">
		Name: <input type="text" name="name" class="form-control" required> <br/>
		Date of Birth: <input type="date" name="dateOfBirth" class="form-control" required> <br/>
		Phone Number: <input type="text" name="phone" class="form-control" required> <br/>
		Email address: <input type="text" name="email" class="form-control" required> <br/>
		
		Password: <input type="password" name="password" class="form-control" required> <br/>
		Confirm Password: <input type="password" name="confPassword" class="form-control" required> <br/>
		<input type="submit" value="Register User" class="btn btn-success">
	</form>
</body>
</html>