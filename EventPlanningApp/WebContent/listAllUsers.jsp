<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.io.Writer" %>

<%@ page import="model.User" %>
<%@ page import="service.IUserService"%>
<%@ page import="service.UserServiceImplementation"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Users</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<table class="table table-bordered table-striped table-hover">
	<tr>
		<th>Username(id)</th>
		<th>Fullname</th>
		<th>Date of Birth </th>
		<th>Age </th>
		<th>Phone</th>
		<th>Email </th>
		
		
	</tr>

<%
	IUserService iuserService =  new UserServiceImplementation();
	ArrayList<User> arrayList =  iuserService.getAllUsers();
	
	for(User user: arrayList)
	{
		
	
%>

<tr>
	<td> <%=user.getUsername() %> </td>
	<td> <%=user.getName() %> </td>
	<td> <%=user.getDateOfBirth() %> </td>
	<td> <%=user.getAge() %> </td>
	<td> <%=user.getPhone() %> </td>
	<td> <%=user.getEmail() %> </td>
	
	<form method="POST" action="deleteUser.jsp">
		<input type="hidden" name="userId" value=<%=user.getUsername() %> >
		<td> <input type="submit" value="Delete User" class="btn btn-danger"> </td>
	</form>
	
</tr>

<%} %>
</table>

</body>
</html>