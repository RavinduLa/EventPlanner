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

<style>
body {
  background-image: url('images/eventPhoto4.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>

<title>Dashboard</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>


	
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
		ArrayList<Event> arrayList =  ieventService.getTopEventForCreator(username);
		
		for(Event event: arrayList)
		{
			String eventID =event.getEventId();
		
	%>
	
	<br/>
	
 
	

	
	<br/>
	

	<%} %>
	 
	<br/>
	<div class='container' style='width: 30rem;'>
	<a href="listEvents.jsp" class='btn btn-outline-secondary btn-lg btn-block'>View all of your events</a>
	<a href="budget.jsp" class='btn btn-outline-info btn-lg btn-block'>View budgets for your events</a>
	<a href="RegisterAttendees_dil.jsp" class='btn btn-outline-secondary btn-lg btn-block'>Manage Your Attendees</a>
	<a href="presenceList.jsp" class='btn btn-outline-info btn-lg btn-block'>Mark Attendance</a>
	</div>
</body>
</html>