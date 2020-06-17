<%@ page import="model.Attendee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--  Reg No - IT19075204 , Name - G.G.D.D Weerasinghe -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
 <!--  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css">  -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script src="bootstrap/js/jquery.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>



<title>Register Attendes</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<div style="padding:20px">


<h1 style="font-family:Leelawadee">Register Attendee</h1>
	<form method="POST" action="AddAttendee_dil" >
		
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
		
		
		%>
		
		<div class="form-group">
			UserID:<input type="text" name="userid" class="form-control"  style="width:400px"/>
			<br>
			Name:<input type="text" name="name" class="form-control" style="width:400px"/>
			<br>
			Address:<input type="text" name="address" class="form-control" style="width:400px"/>
			<br>
			Age:<input type="text" name="age" class="form-control" style="width:400px"/>
			<br>
			paymentMethod:<input type="text" name="pmethod" class="form-control" style="width:400px"/>
			<br>
			Gender:<input type="text" name="gender" class="form-control" style="width:400px"/>
			<br>									
			Email:<input type="text" name="email" class="form-control" style="width:400px"/>
			<br>									
			
			<input type="hidden" name="creatorId" value=<%=username %>>
			<input type="submit" name="submit" value="Add User" class="btn btn-primary"/>
		</div>
			
			

	
	</form>
	
	<br/>
	<br/>
	<div style="position:Absolute;left:50%;top:25px; padding-top:50px;">	
	
	<h1 style="font-family:Leelawadee">Update Attendee Information</h1>
	

	<form method="POST" action="GetAttendee_dil" >
	
	Insert UserID to update information:<input type="text" name="useridget" class="form-control" style="width:400px"/>
	<br>
	<input type="hidden" name="creatorId" value=<%=username %> >
	<input type="submit" name="Get" value="Get Attendee"  class="btn btn-primary"/>
	
	
	</form>
	
	<br>
	<br>
	
	<h1 style="font-family:Leelawadee">Delete Attendee Information</h1>
	<br>
	<form method="POST" action="DeleteAttendeeS_dil" >
	Insert User ID to Delete Attendee from the Database: <input type="text" name="useriddelete" class="form-control" style="width:400px"/>
	<br>
	<input type="hidden" name="creatorId" value=<%=username %> >
	<input type="submit" name="delete" value="Delete Attendee"  class="btn btn-primary"/>
	
	<br>
	
	</form>
	
	<br>
	<br>
	
	<form action="ListAttendees_dil" method="Post" >
	<input type="submit" name="ListUsers" value="Show All Attendees"  class="btn btn-primary"/>
	
	</form>
	
	<br>
	
	<!--  
	<form action="ListEvent_dil" method="Post" >
	
	<input type="submit" name="ListEvent" value="Assign Attendees to Events"  class="btn btn-primary"/>
	
	</form> -->
	
	</div>
	</div>

</body>
</html>