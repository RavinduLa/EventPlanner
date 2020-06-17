<%@ page import="model.Attendee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--  Reg No - IT19075204 , Name - G.G.D.D Weerasinghe -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Update Attendees</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

	<%
	Attendee attendee = new Attendee();
	attendee = (Attendee)request.getAttribute("attendee");
	%>
	
	<div class="form-group" style="padding:10px">
	
	<form method="POST" action="UpdateAttendees_dil" >
		<br>
			User ID:<input type="text" name="useridupdate" class="form-control" style="width:400px" value="<%=attendee.getUserID() %>"/>
			<br>
			Name:<input type="text" name="nameud" class="form-control" style="width:400px" value="<%=attendee.getName() %>"/>
			<br>
			Address:<input type="text" name="addressud" class="form-control" style="width:400px" value="<%=attendee.getAddress() %>"/>
			<br>
			Age:<input type="text" name="ageud" class="form-control" style="width:400px" value="<%=attendee.getAge() %>"/>
			<br>
			paymentMethod:<input type="text" name="pmethodud" class="form-control" style="width:400px" value="<%=attendee.getPaymentMethod() %>"/>
			<br>
			Gender:<input type="text" name="genderud" class="form-control" style="width:400px" value="<%=attendee.getGender() %>"/>
			<br>
			Email:<input type="text" name="emailud" class="form-control" style="width:400px" value="<%=attendee.getEmail() %>"/>
			<br>
	
		<input type="submit" name="update" value="Update Attendee"  class="btn btn-primary"/>
	<br>
	<br>
	<br>
	
	</form>
	</div>
	
	
	
</body>
</html>