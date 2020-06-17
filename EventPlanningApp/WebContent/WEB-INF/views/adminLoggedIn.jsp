<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.io.Writer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery-3.4.1.min.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>

<title>Admin Logged in</title>
</head>
<body>
	<%
	String adminUsername =(String)session.getAttribute("adminUsername");
	%>
	
	<li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          <%=adminUsername %>
		          
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="listEvents.jsp">View Events</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="addEvent.jsp">Create Event</a>
		          		          
		        </div>
		     </li>
	
</body>
</html>