<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

<%@ page import="model.Event" %>
<%@ page import="service.IEventService"%>
<%@ page import="service.EventServiceImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
<!DOCTYPE html>
<html>
<head>

<!-- <meta charset="ISO-8859-1"> -->


<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>


<title>View Events </title>
</head>
<body>
<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<h4>Events</h4>

<table class="table table-bordered table-striped table-hover">
	<tr>
		<th>Event ID </th>
		<th>Event Name </th>
		<th>Date of event </th>
		<th>Starting Date and time </th>
		<th>Ending Date and time </th>
		<th>Duration in minutes </th>
		<th>Venue </th>
		<th>Creator ID </th>
		<th>Atendee Limit </th>
		
	</tr>
	
	<%
		String username = null;
		if( (session.getAttribute("normalUsername")!= null) && (session.getAttribute("adminUsername") == null))
		{
			username = (String)session.getAttribute("normalUsername");
		}
		else if (  (session.getAttribute("normalUsername")== null) && (session.getAttribute("adminUsername") != null) )
		{
			username = (String)session.getAttribute("adminUsername");
		}
		IEventService ieventService = new EventServiceImplementation();
		ArrayList<Event> arrayList =  ieventService.getEventForCreator(username);
		
		for(Event event: arrayList)
		{
			String eventID =event.getEventId();
		
	%>
	
	<tr>
	<td> <%=event.getEventId() %> </td>
	<td> <%=event.getEventName() %> </td>
	<td> <%=event.getDate() %> </td>
	<td> <%=event.getStartingDateTime() %> </td>
	<td> <%=event.getEndingDateTime() %> </td>
	<td> <%=event.getDuration() %> </td>
	<td> <%=event.getVenue() %> </td>
	<td> <%=event.getCreatorId() %> </td>
	<td> <%=event.getAtendeeLimit() %> </td>
	
	<form method="POST" action="viewEventById.jsp">
		<input type="hidden" name="eventId" value=<%=eventID %> >
		<input type='hidden' name='username' value=<%=username %> >
		<td> <input type="submit" value="View Event Details" class="btn btn-info"> </td>
	</form>
	
	<form method="POST" action="editEvent.jsp">
		<input type="hidden" name="eventId" value=<%=eventID %> >
		<td> <input type="submit" value="Edit Event Details" class="btn btn-warning"> </td>
	</form>
	
	<form method="POST" action="deleteEventConfirm.jsp">
	<input type="hidden" name="eventId" value=<%=eventID %> >
		<td> <input type="submit" value="Delete event" class="btn btn-danger"> </td>
	</form>
	</tr>
	<%} %>
	
</table>

</body>
</html>