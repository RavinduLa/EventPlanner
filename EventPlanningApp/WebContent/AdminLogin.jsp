<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.io.Writer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Admin Login</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<br/> <br/>

	<%
		
		JspWriter write = pageContext.getOut();
		
		try
		{
			if( (session.getAttribute("adminUsername") != null)  && (session.getAttribute("normalUsername") == null ))
			{
				String name=(String)session.getAttribute("adminUsername");
				
				write.print("<center>");
				write.print("<div class='container'>");
				write.print("<div class='justify-content-center'> ");
				write.print("<div class='card' style='width: 20rem;'>");
				write.print("<div class='card-header'>");
				write.print("<h3>Logged in as"+ name + " </h3>");
				write.print("</div>");
				write.print("<div class='card-body'>");
				write.print("<form method='post' action='LogoutServlet'>");
				write.print("<div class='form-group'>");
				write.print("<input class='form-control btn btn-danger' type='submit' value='Logout'>");
				write.print("</div>");
				write.print("<a href='userDashboard.jsp' class='form-control btn btn-secondary'>Cancel</a>");
				write.print("</form>");
				write.print("</div> </div> </div> </div> </div>");
				write.print("</center");
			}
			else if(session.getAttribute("normaUsername") != null)
			{
				response.setContentType("text/html");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/normalLogin.jsp");
				dispatcher.forward(request, response);
			}
			else if ( (session.getAttribute("adminUsername") == null) && (session.getAttribute("normalUsername") == null ))
			{
				write.print("<br/><br/>");
				
				write.print("<center>");
				write.print("<div class='container'>");
				write.print("<div class='justify-content-center'> ");
				write.print("<div class='card' style='width: 20rem;'>");
				write.print("<div class='card-header'>");
				write.print("<h3>Admin Login</h3>");
				write.print("</div>");
				write.print("<div class='card-body'>");
				write.print("<form method='post' action='AdminLoginServlet'>");
				write.print("<div class='input-group form-group'>");
				write.print("<input type='text' name='adminUsername' class='form-control' placeholder='Admin Username'>");
				write.print("</div>");
				write.print("<div class='input-group form-group'>");
				write.print("<input type='password' name='password' class='form-control' placeholder='Password'>");
				write.print("</div>");
				write.print("<div class='form-group'>");
				write.print("<input type='submit' value='Login' class='btn btn-primary'>");
				write.print("</div>");
				write.print("</form>");
				write.print("</div> </div> </div> </div> </div>");
				write.print("</center>");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in write");
		}
		%>
		
	
	

</body>
</html>