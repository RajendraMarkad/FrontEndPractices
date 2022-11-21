<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<style type="text/css">
	body {
	  background-image: url('https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
	  background-repeat: no-repeat;

background-size: cover;
	}
    
#error {
	color: red;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<h3 style="color: white;">Welcome, Admin</h3>
		<form:form action="/adminLogin" method="get" modelAttribute="doctor">
			<div style="margin-left: 60rem">
				<input name="login" id="login" class="btn btn-primary" type="submit"
					value="Logoff">
			</div>
		</form:form>
		

	</nav>
	<div class="container" style="margin-left:45%; margin-top:5%;font-size=2rem;float:left">
		<div class="dropdown">
					<button type="button" class="btn btn-primary dropdown-toggle" style="width:20%;"
						data-toggle="dropdown">Approve/Deny Request</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/patientADetails">Patient</a> <a
							class="dropdown-item" href="/doctorADetails">Doctor</a> <a
							class="dropdown-item" href="/clerkADetails">Clerk</a> 
					</div>
			<br><br>
    <a href="/patientDetails">Patient Details</a><br><br>
    <a href="/listofTest">Update Test Results</a><br><br>
    <a href="/patientSDetail">Create in Patient Records</a><br><br>
    <a href="/patientIdsub">Create Bill</a><br><br>
	</div>

</body>
</html>