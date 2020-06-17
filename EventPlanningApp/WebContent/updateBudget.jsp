<%--IT19000268 --%>

<%--LIYANAGE S.M.H.--%>



<%@ page import = "model.Budget"%>
<%@ page import = "service.budgetServiceImplementation" %>
<%@ page import = "service.IBudgetService" %>
<%@ page import = "java.util.ArrayList" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATING BUDGET FROM THE TABLE</title>
<style>
table, th, td {
  border: 1px solid black;
}

th, td {
  padding: 20px;
}
</style>

</head>
<body style = "background-color:LightPink;">



<h3 style="font-size:20px; text-align:center;"> UPDATE BUGET INFORMATION USING EVENT ID</h3><br><hr><br>
<table style="margin-left:auto;margin-right:auto; width:50%;">
<tr>
<th>eventId</th>
<th>budget</th>
<th>budget updation</th>
</tr>
<tr>
<td>E001</td>
<td>100000</td>
<td> <button type="button">UPDATE</button></td>
</tr>

<tr>
<td>E002</td>
<td>30000</td>
<td><button type = "button">UPDATE</button> </td>
</tr>

<tr>
<td>E002</td>
<td>45000</td>
<td><button type = "button">UPDATE</button></td>
</tr>

</table>
<br>

<div>
<ul>

<li><a href = "budget.jsp">HOME</a></li><br>

<li><a href='createBudget.jsp'>CREATE BUDGET</a></li><br>

<li><a href = 'deleteBudget.jsp'>DELETE BUDGET</a></li><br>

<li><a href = "viewCurrentbudget.jsp">VIEW CURRENT BUDGET TABLE</a></li>
</ul>
</div>
<hr>

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
Connection conn = null;
Statement st = null;
ResultSet rs = null;
%>	
	
<%
try{
conn= DriverManager.getConnection("jdbc:mysql://localhost:1433/test", "ss", "event123");
st = conn.createStatement();
String sql ="select * from budget where eventId="+eventId;

}
catch(Exception e){
	e.printStackTrace();	
}
%>


</body>
</html>
