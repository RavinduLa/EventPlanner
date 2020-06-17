<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Normal Validation</title>
</head>
<body>
<%
if ( (session.getAttribute("adminUsername") == null) && (session.getAttribute("normalUsername") == null))
{
	response.setContentType("text/html");
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/normalLogin.jsp");
	dispatcher.forward(request, response);
}

%>
</body>
</html>