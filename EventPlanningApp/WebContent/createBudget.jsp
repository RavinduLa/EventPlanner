<%--IT19000268 --%>

<%--LIYANAGE S.M.H.--%>

<%@ page import = "model.Budget" %>
<%@ page import = "service.budgetServiceImplementation"%>
<%@ page import = "service.IBudgetService"%>
<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*, java.util.*" %>
    
    
  
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> </link>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>


<meta charset="ISO-8859-1">
<title>Create New Budget</title>

<%
    //String eventId = request.getParameter("eventId");
    //String budget = request.getParameter("budget");
  	Connection conn = null;
    try{
    	Class.forName("com.mysql.jdbc.driver").newInstance();
    	conn = DriverManager.getConnection("jdbc:mysql://localhost:1433/test", "ss", "event123");
    	Statement st = conn.createStatement();
    	
    	String query = "CREATE TABLE budget ( eventId CHAR(10), eventname CHAR(20), venue CHAR(40), budget INTEGER ));";
    	
    	st.executeUpdate(query);
    	
    	out.println("TABLE BUDGET CREATED SUCCCESSFULLY.");
    }
    catch(Exception e)
    {
    	System.out.println(e);
    	e.printStackTrace();
    }
    
    %>

</head>
<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<body style="background-color:powderblue;"><br>

	<h3 style = text-align:center;> CREATE NEW BUDGET</h3><hr>
	<form method = "POST" action = "createBudget">
	
	<div class = "form-group">
	<label for = "eventId">Event Id</label>
	<input type = "text" name = "eventId" class = "form-control" id = "eventId">
	</div>
	<br>
	<div class = "form-group">
	<label for = "budget">Budget</label>
	<input type = "text" name = "budget" class = "form-control" id = "budget">
	</div>
	<br>
	
	<a href = "viewCurrentbudget.jsp" >Submit</a>
	</form>

	<br>
	<div>
	<ul>
	<li><a href=budget.jsp>HOME</a></li><br>
	<li><a href ="updateBudget.jsp" >UPDATE BUDGET</a></li><br>
	<li><a href = "deleteBudget.jsp">DELETE BUDGET</a></li><br>
	<li><a href = "viewCurrenbudget.jsp">VIEW CURRENT BUDGET TABLE</a></li>
	</ul>
	</div>
	<hr>	
</body>
</html>