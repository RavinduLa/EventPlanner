<!-- IT19014128 A.M.W.W.R.L. Wataketiya -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"   href="bootstrap/css/bootstrap.css"> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/jquery-3.4.1.min.js"> </script>
<script src="bootstrap/js/bootstrap.min.js"> </script>

<title>Login</title>
</head>
<body>


	<div class="container">
		<div class="d-flex justify-content-center h-100"> 
			<div class="card">
			
				<div class="card-header">
					<h3>Login</h3>
				</div>
				
				<div class="card-body">
					<form method="post" action="NormalLoginServlet">
					
					<div class="input-group form-group">
						<input type="text" name="normalUsername" class="form-control" placeholder="Username">
					</div>
					
					<div class="input-group form-group">
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
					
					<div class="form-group">
						<input type="submit" value="Login">
					</div>
	
					</form>
					
				</div>
			</div>
		</div>
	
	</div>

	

</body>
</html>