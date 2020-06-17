<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid Admin Login</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<br/> <br/>

<center>
<div class='container'>
	<div class='justify-content-center'>
		<div class='card' style='width: 30rem;'> 
		
			<div class='card-header'> 
				<h3>Invalid Admin Login</h3>
			</div>
			
			<div class='card-body'> 
			<form>
				<div class='form-group'> 
					<a href='AdminLogin.jsp' class='form-control btn btn-primary'>Try again</a> 
				</div>
				
				<div class='form-group'> 
					<a href='index.jsp' class='form-control btn btn-secondary'>Cancel</a>
				</div>
			</form>
			</div>
			
		</div>
	</div>
</div>
</center>
</body>
</html>