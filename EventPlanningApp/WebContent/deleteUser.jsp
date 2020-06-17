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
<title>Delete User</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<table class="table table-bordered table-striped table-hover">

<%
IUserService iuserService =  new UserServiceImplementation();
ArrayList<User> arrayList =  iuserService.getUserDetailsById(request.getParameter("userId"));

for(User user: arrayList)
{
%>


<tr><td>Username </td> <td> <%=user.getUsername() %> </tr>
<tr><td>Full Name </td> <td> <%=user.getName() %> </tr>
<tr><td>Date Of Birth </td> <td> <%=user.getDateOfBirth() %> </tr>
<tr><td>Age </td> <td> <%=user.getAge() %> </tr>
<tr><td>Phone </td> <td> <%=user.getPhone() %> </tr>
<tr><td>Email </td> <td> <%=user.getEmail() %> </tr>

<%} %>
</table>

<form method="post" action="DeleteUserServlet">
	<input type="hidden" name="userId" value="<%=request.getParameter("userId") %>">
	<input type="submit" value="Confirm Delete" class="btn btn-danger">
</form>
</body>
</html>