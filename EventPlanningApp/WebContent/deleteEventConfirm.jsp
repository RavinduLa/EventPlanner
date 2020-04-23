<%@ page import="model.Event" %>
<%@ page import="service.IEventService"%>
<%@ page import="service.EventServiceImplementation"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>
<title>Confirm Delete Event</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<h2>Event to delete</h2>
	
	<%
		String eventID = request.getParameter("eventId");
		IEventService ieventService = new EventServiceImplementation();
		ArrayList<Event> arrayList =  ieventService.getEventById(eventID);
		
		for(Event event: arrayList)
		{
	%>
	
	<h3>Are you sure you want to delete the following event?</h3>
	<table class="table table-bordered table-striped table-hover">
	<tr>
		<td>Event ID </td>
		<td> <%=event.getEventId() %> </td>
	</tr>
	
	<tr>
		<td>Event Name</td>
		<td> <%=event.getEventName() %> </td>
	</tr>
	
	<tr>
		<td>Starting Date and Time</td>
		<td> <%=event.getStartingDateTime() %> </td>
	</tr>
	
	<tr>
		<td>Ending Date and Time </td>
		<td> <%=event.getEndingDateTime() %> </td>
	</tr>
	
	<tr>
		<td>Duration </td>
		<td> <%=event.getDuration() %> </td>
	</tr>
	
	<tr>
		<td>Venue </td>
		<td> <%=event.getVenue() %> </td>
	</tr>
	
	<tr>
		<td>Atendee Limit </td>
		<td> <%=event.getAtendeeLimit() %> </td>
	</tr>
	
	
	</table>
	
	
	<%} %>
	
	<form method="POST" action="DeleteEventServlet">
	<input type="hidden" name="eventId" value=<%=eventID %> >
		<td> <input type="submit" value="Confirm Delete" class="btn btn-danger"> </td>
	</form>
	
</body>
</html>