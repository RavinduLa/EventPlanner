<%@ page import="model.Attendee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--  Reg No - IT19075204 , Name - G.G.D.D Weerasinghe -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> </link>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body style="padding:20px">

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	
	<% 
	Attendee attendee = new Attendee(); 	
	attendee = (Attendee)request.getAttribute("attendee");	
	%>
	
	
	<table border="3" cellpadding="10" class="table table-striped table-dark">

			<tr>
				<td>User ID</td>
				<td><%=attendee.getUserID() %></td>
			</tr>
			
			<tr>
				<td>Name</td>
				<td><%=attendee.getName() %></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td><%=attendee.getAddress() %></td>
			</tr>
			
			<tr>
				<td>Age</td>
				<td><%=attendee.getAge() %></td>
			</tr>
			
			<tr>
				<td>Payment Method</td>
				<td><%=attendee.getPaymentMethod() %></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td><%=attendee.getGender() %></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=attendee.getEmail() %></td>
			</tr>
			
	</table>
		
<br>
<a  style="text-decoration: none;" href="RegisterAttendees_dil.jsp">

	<h1 style="font-family:Leelawadee;color:#0066cc;text-align:center;font-size:25px">Go Back</h1>

</a>
<br>
	
	
	
</body>
</html>