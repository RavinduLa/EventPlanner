<%--IT19000268 --%>

<%--LIYANAGE S.M.H.--%>

<%@ page import = "model.Budget" %>
<%@ page import = "service.budgetServiceImplementation" %>
<%@ page import = "service.IBudgetService" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.sql.*, java.util.*" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETING BUDGET FROM THE TABLE</title>
<style>
table, th, td {
  border: 1px solid black;
}

th, td {
  padding: 20px;
}
</style>

</head>
<body style = "background-color:Lavender;">
<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<h3 style="font-size:20px; text-align:center;"> DELETE BUGET INFORMATION USING EVENT ID</h3><br><hr>

<%--<%--%>
	<%--String eventId = request.getParameter("eventId");--%>
	<%--IBudgetService ibudgetService = new budgetServiceImplementation();--%>
	<%--ArrayList<Budget> arrayList = ibudgetService.deleteBudgetbyId(eventId);--%>
	
	<%--for(Budget budget: arrayList)--%>
	
<% 
String eventId = request.getParameter("eventId");
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1433/budget","ss", "event123");
	Statement st = conn.createStatement();
	int i = st.executeUpdate("DELETE FROM budget WHERE id ="+eventId);
	System.out.println("DATA DELETED SUCCESSFULLY!");
		
}
catch(Exception e)
{
	System.out.println(e);
	e.printStackTrace();
}


%>		

<table style="border:4px solid black;margin-left:auto;margin-right:auto; width:50%;">
<tr>
<th>eventId</th>
<th>budget</th>
<th>budget deletion</th>
</tr>
<tr>
<td>E001</td>
<td>100000</td>
<td> <button type="button">DELETE</button></td>
</tr>

<tr>
<td>E002</td>
<td>30000</td>
<td><button type = "button">DELETE</button> </td>
</tr>

<tr>
<td>E002</td>
<td>45000</td>
<td><button type = "button">DELETE</button></td>
</tr>

</table>

<div>
<ul>

<li><a href = "budget.jsp">HOME</a></li><br>

<li><a href='createBudget.jsp'>CREATE BUDGET</a></li><br>

<li><a href = 'updateBudget.jsp'>UPDATE BUDGET</a></li><br>

<li><a href = "viewCurrentbudget.jsp">VIEW CURRENT BUDGET</a></li>
</ul>
</div>

<hr>

</body>
</html>









