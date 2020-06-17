<%--IT19000268 --%>

<%--LIYANAGE S.M.H.--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "model.Budget" %>
<%@ page import = "service.budgetServiceImplementation" %>
<%@ page import = "service.IBudgetService" %>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("eventId");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:1433/";
String database = "budget";
String userid = "sa";
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


<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>CURRENT BUDGET ALLOCATION TABLE(THIS IS AFTER ALL THE CHANGES DONE TO THE DATABASE)</title>

<style>
table, th, td {
  border: 1px solid black;
}

th, td {
  padding: 15px;
}

</style>
</head>
<body style="background-color:Pink;">

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from buudget";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<table>
<tr>
<td><%=resultSet.getString("eventId") %></td>
<td><%=resultSet.getString("eventName") %></td>
<td><%=resultSet.getString("venue") %></td>
<td><%=resultSet.getString("budget") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<h2 style = text-align:center;>VIEWING CURRENT BUDGET TABLE</h2><hr><br>

<table style="width:100%">
<tr>
<th>eventId</th>
<th>eventName</th>
<th>venue</th>
<th>budget</th>
</tr>

<tr>
<td>E001</td>
<td>Spectra</td>
<td>BMICH</td>
<td>120000</td>
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

<tr>
<td>E004</td>
<td>Wiramaya</td>
<td>Colombo Youth Center</td>
<td>35000</td>

</tr>

</table>
<br>
<br>


<div>
<ul>
<li><a href = "budget.jsp">HOME</a></li><br>
<li><a href='createBudget.jsp'>CREATE BUDGET</a></li><br>
<li><a href='updateBudget.jsp'>UPDATE BUDGET</a></li><br>
<li><a href = 'deleteBudget.jsp'>DELETE BUDGET</a></li>
</ul>
</div>

<hr>

</body>
</html>