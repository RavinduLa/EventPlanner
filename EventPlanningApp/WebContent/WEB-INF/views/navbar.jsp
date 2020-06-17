<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.io.Writer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!--  
<link rel="stylesheet" type="text/css"   href="styles/navbarStyle1.css"> -->

<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery-3.4.1.min.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>


<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	
	<a class="navbar-brand" href="index.jsp">EPS</a> <!-- This part is out of collapse div so that EPS displays in small view -->
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  
	 <div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
		        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
		    </li>
		    
		    <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Events
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="listEvents.jsp">View Events</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="addEvent.jsp">Create Event</a>
		          		          
		        </div>
		     </li>
		     
		     <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          
		          
		          
		          <%
		          JspWriter write = pageContext.getOut();
		          if(session.getAttribute("adminUsername") != null)
		          {
		        	  String adminUsername =(String)session.getAttribute("adminUsername");
		        	  write.print(adminUsername);
		          }
		          else if (session.getAttribute("normalUsername") != null)
		          {
		        	  String normalUsername = (String)session.getAttribute("normalUsername");
		        	  write.print(normalUsername);
		          }
		          else
		          {
		        	  write.print("User Account");
		          }
		          %>
		          
		        </a>
		        
		        
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          
		          
		          
		          <%if (session.getAttribute("normalUsername") != null) {
		          write.print("<a class='dropdown-item' href='userDashboard.jsp'> Dashboard </a>");
		          write.print("<div class='dropdown-divider'></div>");
		          write.print("<form method='post' action='LogoutServlet'><input type='submit' value='Logout' class='dropdown-item'> </form>" );
		          }
		          %>
		          <% if (session.getAttribute("adminUsername") != null){           
		          write.print("<a class='dropdown-item' href='userDashboard.jsp'> Dashboard </a>");
		          write.print("<div class='dropdown-divider'> </div>");
		          write.print("<a class='dropdown-item' href='adminDashboard.jsp'>Admin Dashboard </a>");
		          write.print("<div class='dropdown-divider'> </div>");
		          write.print("<form method='post' action='LogoutServlet'><input type='submit' value='Logout' class='dropdown-item'> </form>");
		          }   %>
		          
		          <%
		          if( (  session.getAttribute("normalUsername") == null )  &&  (session.getAttribute("adminUsername") == null)  )  {
		        	  write.print("<a class='dropdown-item' href='normalLogin.jsp' >User Login</a>");
		        	  write.print("<div class='dropdown-divider'></div>");
		        	  write.print("<a class='dropdown-item' href='AdminLogin.jsp' >Admin Login</a>");
		          }
		          %>
		          
		          
		          		          
		        </div>
		     </li>
		     
		     <%
		          //JspWriter write = pageContext.getOut();
		          
		          if(session.getAttribute("adminUsername") != null)
		          {
		        	  //write.print("<jsp:include page=''/WEB-INF/views/adminLoggedIn.jsp'></jsp:include>");
		        	  String adminUsername =(String)session.getAttribute("adminUsername");
		        	  
		        	  
		        	  /*write.print("<li class='nav-item dropdown'");
		        	  write.print("<a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-wxpanded='false'>");
		        	  write.print("=adminUsername ");
		        	  write.print("</a>");
		        	  write.print("<div class='dropdown-menu' aria-labelledby='navbarDropdown'>");
		        	  write.print("<a class='dropdown-item' href='AdminLogin.jsp'> Log out </a>");
		        	  write.print("<div class='dropdown-divider'></div>");
		        	  write.print("<a class='dropdown-item' href='adminDashboard.jsp'>Admin Dashboard </a>");
		        	  write.print("</div");
		        	  write.print("</li>");*/
		          }
		      %>
		      
		     
		     
		    
		</ul>
		
		<%
		String username = "null";
		if (session.getAttribute("normalUsername") != null)
		{
			username= (String)session.getAttribute("normalUsername");
		}
		else if (session.getAttribute("adminUsername") != null)
		{
			username= (String)session.getAttribute("adminUsername");
		}
		%>
	<form class="form-inline my-2 my-lg-0" method="post" action="viewEventById.jsp">
		<input type='hidden' value=<%=username %> name='username'>
      <input class="form-control mr-sm-2" type="search" placeholder="Search Events" aria-label="Search" name='eventId'>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    
    <%
    /*
    if(session.getAttribute("normalUsername") != null)
    {
    	String username = (String)session.getAttribute("normalUsername");
    	write.print("<form class='form-inline my-2 my-lg-0' method='POST' action='viewEventById.jsp'>");
    	write.print("<input type='hidden'  value=username name='username'>");
    	write.print("<input type='text' name='eventId' placeholder='Event Id' class='form-control'>");
    	write.print("<input type='submit' class='btn  btn-outline-success' value='Search'>");
    	write.print("</form>");
    }*/
    %>
		
		
			
	</div>
	  
    
	</nav>
	
	
	
</body>
</html>