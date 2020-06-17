<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Mismatch</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminOnlyValidation.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<h2> Entered passwords do not match!</h2>
	<a href="addUser.jsp">Try Again</a>
</body>
</html>