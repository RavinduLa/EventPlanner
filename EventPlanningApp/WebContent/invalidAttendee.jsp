<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid Attendee</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>


	
	
	<h4>Invalid Attendee</h4>
	The attendee id you entered either does not exist or not added by you.
	<a href="RegisterAttendees_dil.jsp">Try again</a>

</body>
</html>