<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clerk Home</title>
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
#error {
	color: red;
}

body {
	  background-image: url('http://images.unsplash.com/photo-1596541223130-5d31a73fb6c6?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9');
	  background-repeat: no-repeat;
background-attachment: fixed;
background-size: cover;
	}
	
.container {  
margin-top: 200px;
width: 300px;  
height: 300px;  
display: grid;  
}  
.btn{
margin-top: 5px;
}
.btn a{
text-decoration: none;
color: whitesmoke;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<h3 style="color: white;">Welcome, ${clerkname}</h3>
		<form:form action="/clerkLogin" method="get" modelAttribute="clerk">
			<div style="margin-left: 60rem">
				<input name="login" id="login" class="btn btn-primary" type="submit"
					value="Logoff">
			</div>
		</form:form>
	</nav>
	<div class="container" >
        <button type="button" class="btn btn-primary"><a href="/patientDetails1">Patient Details</a></button><br><br><br><br>
        <button type="button" class="btn btn-primary"><a href="/patientIdsub1">Create Bill</a></button><br><br><br><br>
    </div>
	

</body>
</html>