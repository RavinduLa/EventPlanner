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

<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> </link>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>


<title>Add New Event</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<h2>Add New Event</h2>
	<form method="POST" action="AddEventServlet" > 
		
		<div class="form-group">
		<label for="eventName">Event Name</label>
		<input type="text" name="eventName" class="form-control" id="eventName" required> 
		</div>
		
		<div class="form-group">
		<label for="startingDateTime">Starting Date and Time</label>
		<input type="datetime-local" name="startingDateTime" class="form-control" id="startingDateTime" required>
		 <small  class="form-text text-muted">Enter the date and time in yyyy-mm-dd HH:MM AM/PM format </small>
		</div>
		
		<div class="form-group">
		<label for="endingDateTime">Ending Date and Time</label>
		<input type="datetime-local" name="endingDateTime"  class="form-control" id="endingDateTime" required>
		<small  class="form-text text-muted">Enter the date and time in yyyy-mm-dd HH:MM AM/PM format </small>
		</div>
		
		<div class="form-group">
		<label for="venue" >Venue of the event</label>
		<input type="text" name="venue" class="form-control" id="venue" required>
		</div>
		
	
	  
	  <div class="form-group">
	  <label for="atendeeLimit" >Atendee Limit</label>
	  <input type="number" name="atendeeLimit" class="form-control" id="atendeeLimit" required> 
	  </div>
	  
	  
	  
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
	  <div class="form-group">
	  Your creator ID: <%=creatorId %>
	  <input type="hidden" name="creatorID" id="creatorID" value=<%=creatorId %>> <br/>
	  </div>
	  
	  <input type="Submit" value="Submit" class="btn btn-primary">
	  
	</form>
	
</body>
</html>