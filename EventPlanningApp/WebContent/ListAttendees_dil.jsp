<%@page import="userServices.UserServices"%>
<%@page import="userServices.IuserServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Attendee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--  Reg No - IT19075204 , Name - G.G.D.D Weerasinghe -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="bootstrap/js/jquery.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>


<title>List All Attendees</title>
</head>
<body style="padding:20px">

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

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

	<div align="center">
	<h3>List of attendees that you have registered</h3>
        <table border="3" cellpadding="10" class="table table-striped table-dark" >
            
            <tr>
                <th>UserID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Age</th>
                <th>paymentMethod</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Creator Id</th>
            </tr>
  <% 
  IuserServices iu = new UserServices();
  ArrayList<Attendee> u = iu.ListU(username);
  
  for(Attendee attendee : u){	 
  %> 
                <tr>
                    <td> <%=attendee.getUserID() %> </td>
                    <td> <%=attendee.getName() %> </td>
                    <td><%=attendee.getAddress() %></td>
                    <td><%=attendee.getAge() %></td>
                    <td> <%=attendee.getPaymentMethod() %> </td>
                    <td><%=attendee.getGender() %></td>
                    <td><%=attendee.getEmail() %></td>
                    <td><%=attendee.getCreatorId() %>
                </tr>
  <% } %>
        </table>
    </div>	

<br>
<a  style="text-decoration: none;" href="RegisterAttendees_dil.jsp">

	<h1 style="font-family:Leelawadee;color:#0066cc;text-align:center;font-size:25px">Go Back</h1>

</a>
<br>

	
</body>
</html>