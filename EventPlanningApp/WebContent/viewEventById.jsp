<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.Event" %>
<%@ page import="service.IEventService"%>
<%@ page import="service.EventServiceImplementation"%>
<%@page import="java.util.ArrayList"%>

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
<title>View Event</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<%
String eventId = request.getParameter("eventId");
String creatorId = request.getParameter("username");
IEventService ieventService = new EventServiceImplementation();
//ArrayList<Event> arrayList =  ieventService.getEventById(eventId);
ArrayList<Event> arrayList =  ieventService.searchEventByUser(creatorId, eventId);

if( arrayList.isEmpty())
{
	response.setContentType("text/html");
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/noSearchResults.jsp");
	dispatcher.forward(request, response);
}

else{
for(Event event: arrayList)
{
	String eventID =event.getEventId();

%>
	<br/>
	<div class='container-fluid'>
	<div class="row">
	
	<div class="col-3">
	
	<ul class="list-group" >
	  <li class="list-group-item active"><%=event.getEventName() %>
	  <li class="list-group-item"> Event Id:  <%=event.getEventId() %> 
	  <li class="list-group-item">Start: <%=event.getStartingDateTime() %></li>
	  <li class="list-group-item">End: <%=event.getEndingDateTime() %></li>
	  <li class="list-group-item">Duration in minutes: <%=event.getDuration() %></li>
	  <li class="list-group-item">Venue: <%=event.getVenue() %></li>
	  <li class="list-group-item">Attendee Limit: <%=event.getAtendeeLimit() %></li>
	</ul>
	
	</div> <!-- close division for list -->
	
	
	<div class="col-3">
		<form method="POST" action="editEvent.jsp">
			<input type="hidden" name="eventId" value=<%=eventID %> >
			<input type="submit" value="Edit Event Details" class="btn btn-warning btn-lg btn-block">
		</form>
		<br/>
		
		<form method="POST" action="deleteEventConfirm.jsp">
		<input type="hidden" name="eventId" value=<%=eventID %> >
			<input type="submit" value="Delete event" class="btn btn-danger btn-lg btn-block">
		</form>
		<br/>
		<form method='post' action='eventdetails_dil'>
			<input type='hidden' value=<%=eventID %> name='eventdetails'>
			<input type="submit" value="View Attendees for this event" class="btn btn-primary btn-lg btn-block">
		</form>


	</div> <!-- close division for buttons -->
	
	
	<div class="col-3">
			<div class="card" style="width: 18rem;">
			
			  <div class="card-header">
			    Assign Attendees to your event
			  </div>			  
			  <ul class="list-group list-group-flush">
			  
			  	<form method="POST"  action="AssignAttendees_dil">
			  	
			    <li class="list-group-item">Attendee ID: <input type="text" name="userid" required> 
			    
			    <input type="hidden" value=<%=eventID %>  name="Eventid">
				<input type="hidden" value=<%=creatorId %>>
				
				</li>
	
			    <li class="list-group-item"><input type="submit" value="Assign Attendee" class="btn btn-primary"></li>
			    
			    </form>
			  </ul>
			  
			  
			</div>
		</div>
		
		
		<div class="col-3">
			<div class="card" style="width: 18rem;">
			  <div class="card-header">
			    Deassign Attendees from your event
			  </div>
			  
			  <ul class="list-group list-group-flush">
			  <form method="POST"  action="deleteAttendee_dil">
			    <li class="list-group-item">Attendee ID: <input type="text" name="useriddelete" required ></li>
			    <input type="hidden" value=<%=eventID %>  name="Eventiddelete">
			    <li class="list-group-item"><input type="submit" value="Deassign Attendee" class="btn btn-danger"></li>
			   </form>
			  </ul>
			</div>
		</div>
		
		
		
	
	</div> <!-- close division for row -->
	</div> <!-- close division for container-fluid -->
	
	
	<br/>
	
	<% }
	}
	%>

</body>
</html>