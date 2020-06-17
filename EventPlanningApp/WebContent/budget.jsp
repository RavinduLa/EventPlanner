<%--IT19000268 --%>

<%--LIYANAGE S.M.H.--%>



<%@ page import = "model.Budget" %>
<%@ page import = "service.budgetServiceImplementation" %>
<%@ page import = "service.IBudgetService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    

<!DOCTYPE html>

<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String eventId = request.getParameter("eventId");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:1433/";
String database = "budget";
String userid = "ss";
String password = "event123";

try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<html>
<head>

<meta charset="ISO-8859-1">
<title>BUDGET ALLOCATION TABLE</title>

<style>
table, th, td {
  border: 1px solid black;
}

th, td {
  padding: 15px;
}
</style>
</head>

<h2 style = text-align:center;>BUDGET ALLOCATION TABLE</h2><br><hr><br>
<body style="background-color:LightBlue;">
<table style="width:100%">
<tr>
<th>eventId</th>
<th>eventName</th>
<th>venue</th>
<th>budget</th>
</tr>
<%
try{
	connection =  DriverManager.getConnection("jdbc:mysql://localhost:1433/test", "ss", "event123");
	
	statement=connection.createStatement();
	String sql ="select * from budget";
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
	

%>

<tr>
<td><%=resultSet.getString("eventId") %></td>
<td><%=resultSet.getString("eventName") %></td>
<td><%=resultSet.getString("venue") %></td>
<td><%=resultSet.getString("budget") %></td>
<td><a href="updatebudget.jsp?id=<%=resultSet.getString("eventId")%>">update</a></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
<tr>
<td>E001</td>
<td>Spectra</td>
<td>BMICH</td>
<td>100000</td>
</tr>

<tr>
<td>E002</td>
<td>Astral</td>
<td>Hall de Galle</td>
<td>30000</td>
</tr>

<tr>
<td>E003</td>
<td>Robefest</td>
<td> SLIIT Main Auditorium</td>
<td>45000</td>
</tr>

</table>
<br>
<br>

<%--<a href="${pageContext.request.contextPath}/jsp/createBudget.jsp" >click</a>--%>
<div>
<ul>

<li><a href='createBudget.jsp'>CREATE BUDGET</a></li><br>
<li><a href='updateBudget.jsp'>UPDATE BUDGET</a></li><br>
<li><a href = 'deleteBudget.jsp'>DELETE BUDGET</a></li><br>
<li><a href = "viewCurrentbudget.jsp">VIEW CURRENT BUDGET LIST</a></li>
</ul>
</div>
<hr>

</body>
</html>