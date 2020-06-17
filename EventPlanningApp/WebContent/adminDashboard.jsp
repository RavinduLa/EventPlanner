<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.io.Writer" %>   

<%@ page import="model.User" %>
<%@ page import="service.IUserService"%>
<%@ page import="service.UserServiceImplementation"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>

<style>
body {
  background-image: url('images/serverRoom.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminOnlyValidation.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	
	<br/> <br/>
	<div class="container-fluid">
	<div class="row">
	<%
	IUserService iuserService = new UserServiceImplementation();
	int numberOfUsers = iuserService.getNumberOfUsers();
	%>
	
	<div class="col-3">
		<div class="jumbotron">
			<h1 class="display-8">Active users</h1>
			<hr class="my-4">
			
			<div class="row">
			<div class="col-3">
			<h1 class="display-8"><%=numberOfUsers %></h1>  </div>
			
			<div class="col-9">
			<a href="listAllUsers.jsp" class="btn btn-primary btn-lg btn-block">Manage users</a> </div>
			</div>
		</div>
	</div>
	
	<div class="col-6"> <!-- put a container fluid division here to fill entire column with col-9 division -->
	<a href="addUser.jsp" class="btn btn-secondary btn-lg btn-block">Add New User</a>
	<a href="listAllEventsAdmin.jsp"  class="btn btn-secondary btn-lg btn-block">List all events</a>
	<a href="listAllUsers.jsp"  class="btn btn-secondary btn-lg btn-block">List Users</a>
	</div>
		
	</div>	<!-- closing row -->
	</div> <!-- closing container fluid -->
	
	
</body>
</html>