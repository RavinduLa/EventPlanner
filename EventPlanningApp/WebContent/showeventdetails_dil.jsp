<%@page import="userServices.UserServices"%>
<%@page import="userServices.IuserServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Attendee"%>
<!--  Reg No - IT19075204 , Name - G.G.D.D Weerasinghe -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Assigned Attendees</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/normalValidation.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<h3>List of attendees for this event</h3>
<div align="center">
        <table border="3" cellpadding="10" class="table table-striped table-hover" >
            <!--  <caption><h2 style="font-family:Leelawadee;color:#0066cc;text-align:center;font-size:25px">List of attendees</h2></caption>-->
            <tr>
                <th>UserID</th>
                
            </tr>
  <% 
  ArrayList<Attendee> arr = (ArrayList<Attendee>)request.getAttribute("UserAr");
  
  for(Attendee attendee : arr){	 
  
  %> 
                <tr>
                    <td> <%=attendee.getUserID() %> </td>
                    <!-- added by RLW 
                    <form method="post" action="deleteAttendee_dil.java">
                    	<input type="hidden" name="useriddelete" value=<%=attendee.getUserID() %>>
                    	<input type="hidden" name="Eventiddelete">
                    	<input type="submit" value="Unassign user" class="btn btn=danger">
                    </form> -->
                </tr>
  <% } %>
        </table>
    </div>
    
    <br>
    
    <a href="listEvents.jsp">Back to event</a>
    
    <br/>
	<a  style="text-decoration: none;" href="ShowEvent_dil.jsp">
	
	<!--  <h1 style="font-family:Leelawadee;color:#0066cc;text-align:center;font-size:25px">Go Back</h1> -->

</a>
    


</body>
</html>