<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

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

<script src="bootstrap/js/jquery-3.4.1.min.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>

<title>Logout</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<h2>Logout</h2>

<%
		
		if(session != null)
		{
			String name=(String)session.getAttribute("normalUsername"); %>
			<p>Logged in as <%=name %> </p>
			
			<form method="post" action="LogoutServlet">
				<input type="hidden" name="normalUsername" value=<%=name %> >
				<input type="submit" value="Logout">
			</form>
			
	<% 
		}
	%>
</body>
</html>