<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="model.MarkAttendee" %>
<%@page import="service.AttendeeServiceImplementation" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark Attendee</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>


	
	<div class="container-fluid">
	<div class="row">
	<div class="col-3">
	<h1> <font color = "blue"></>Mark Attendance</font> </h1> 
	<form action ="DisplayList"  method = "post">
	
	UserID <br>
	<input type = "text"  name ="UId" id = "UId" size = "30" class="form-control" ><br><br>
	
	Seat No <br>
	<input type = "text" name ="seatNo" id = "seatNo" class="form-control" size = "30" onkeyup="inputnumbers(cno)" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" ><br><br>
	
	Is the user on the seat ?<br>
		<input type="Radio" id="yes" name="seat" value = "Yes"><label for="Yes"> Yes</label>
		<input type="Radio" id ="No" name="seat" value = "No"><label for="No "> No</label><br><br>
		Were payments done correctly ? <br>
	 	<input type="Radio" id="yes" name="pay"  value = "Yes"><label for="Yes"> Yes</label>
		<input type="Radio" id= "No" name="pay"  value = "No"><label for="No "> No</label><br><br>
		<input type = "submit" name= "presence" value= "Mark attendance for the user" class="btn btn-success btn-lg"><br><br><br><br>
</form>
</div>
</div>
</div> <!-- closing container fluid -->

<%
		AttendeeServiceImplementation attendeeservice = new AttendeeServiceImplementation();
		ArrayList<MarkAttendee> attendees = attendeeservice.getAttendance();
	%>
	<style>
	table, th, td {
  	border: 1px solid black;
  	border-collapse: collapse;
}
	</style>
	
	
	
	
		<table class="table table-bordered table-striped table-hover" style = "width:100%">
			<col style="width:30%">
			<col style="width:30%">
			<col style="width:30%">
			<col style="width:20px">
			<tr>
			<th>User Id</th>
			<th>Seat No</th>
			<th>Attendance</th> 
			</tr>
			
		<% for (MarkAttendee Attendee : attendees ) { %>
			<tr>
			
			<td> <%= Attendee.getUSERID() %> </td>
			<td> <%= Attendee.getSEATNO() %></td>
			<td>
			<form action ="edit"  method = "post">
			<input type = "hidden"  name ="UId" id = "UId" size = "30" value = <%= Attendee.getUSERID() %> >
			<select id = "attendanceSelect" name = "attendanceSelect" class="btn btn-info dropdown-toggle">
			 <option value="none" selected disabled hidden> 
         	 <%= Attendee.getATTENDANCE() %></option> 
			<option value = "Presence">Presence</option>
			<option value = "Absence">Absence</option>
			</select>
			<input type = "submit" value = "Update"  class="btn btn-primary">
			</form></td>
			<td style="border-color:#FFFFFF;"><form action ="delete"  method = "post">
			<input type = "hidden"  name ="UId" id = "UId" size = "30" value = <%= Attendee.getUSERID() %> >
			
			<input type = "submit" value = "Delete"  class="btn btn-danger"> </form></td>
					
			</tr>
		
		<%} %>
		</table>




</body>
</html>