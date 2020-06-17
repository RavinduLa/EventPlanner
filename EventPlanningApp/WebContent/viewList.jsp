<%@page import="model.MarkAttendee" %>
<%@page import="service.AttendeeServiceImplementation" %>
<%@page import="java.util.ArrayList" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
	<%
		AttendeeServiceImplementation attendeeservice = new AttendeeServiceImplementation();
		ArrayList<MarkAttendee> attendees = attendeeservice.getAttendance();
	%>
	<style>
	table, th, td {
  	border: 1px solid black;
  	border-collapse: collapse;
}
	</style>
	
	
	
	
		<table class="table table-bordered table-striped table-hover" style = "width:100%">
			<tr>
			<th>User Id</th>
			<th>Seat No</th>
			<th>Attendance</th> 
			</tr>
			
		<% for (MarkAttendee Attendee : attendees ) { %>
			<tr>
			
			<td> <%= Attendee.getUSERID() %> </td>
			<td> <%= Attendee.getSEATNO() %></td>
			<td> <%= Attendee.getATTENDANCE() %></td>
			
			</tr>
		
		<%} %>
		</table>


</body>
</html>