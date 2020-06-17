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
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> </link>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>

<title>Edit Event Details</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<h4>Edit Event</h4>
<% 
String eventId = request.getParameter("eventId"); 
IEventService ieventService = new EventServiceImplementation();
ArrayList<Event> arrayList =  ieventService.getEventById(eventId);

for(Event event: arrayList)
{
%>
<%
	  String creatorId = null;
	  if( (session.getAttribute("adminUsername") != null) && (session.getAttribute("normalUsername") == null) )
	  {
		  creatorId = (String)session.getAttribute("adminUsername");
	  }
	  else if ((session.getAttribute("adminUsername") == null) && (session.getAttribute("normalUsername") != null))
	  {
		  creatorId = (String)session.getAttribute("normalUsername");
	  }
%>
<form method="POST" action="EditEventServlet">

<table class="table table-bordered table-striped table-hover">
	<tr> <th>Attribute </th> <th>Previous Details</th> <th>New Details</th>  </tr>
	<tr> <td>Event Name</td> <td><%=event.getEventName() %> </td> <td> <input type="text" name="eventName" class="form-control" required></td> </tr>
	<tr> <td>Starting Date and Time</td> <td><%=event.getStartingDateTime() %> </td> <td> <input type="datetime-local" name="startingDateTime" class="form-control" required></td> </tr>
	<tr> <td>Ending Date and Time</td> <td><%=event.getEndingDateTime() %> </td> <td> <input type="datetime-local" name="endingDateTime" class="form-control" required></td> </tr>
	<tr> <td>Venue</td> <td><%=event.getVenue() %> </td> <td> <input type="text" name="venue" class="form-control" required></td> </tr>
	<tr> <td>Creator ID</td> <td><%=event.getCreatorId() %> </td> <td> <%=creatorId %></td> </tr>
	<tr> <td>Atendee Limit</td> <td><%=event.getAtendeeLimit() %> </td> <td> <input type="number" name="atendeeLimit" class="form-control" required></td> </tr>
</table>

<input type="hidden" name="creatorID" id="creatorID" value=<%=creatorId %>> <br/>
<input type="hidden" name="eventId" value=<%=eventId %> >
<input type="Submit" value="Edit" class="btn btn-primary">


<%} %>
</form>

</body>
</html>