<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
          background-image: url('http://educationcareerarticles.com/wp-content/uploads/2014/08/Healthcare-Administrator1.jpg');
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
    <h3 style="color: white;">Welcome, ${doctorname}</h3>
  
  <form:form action="/doctorLogin" method="get" modelAttribute="doctor">
			<div style="margin-left: 60rem">
				<input name="login" id="login" class="btn btn-primary" type="submit"
					value="Logoff">
			</div>
		</form:form>
    </nav>
    <div class="container">  
    <button type="button" class="btn btn-primary"><a href="/patientTests">View Test Results</a></button><br><br>
    <button type="button" class="btn btn-primary"><a href="/medicalReport">Patient Record</a></button><br><br>
    <button type="button" class="btn btn-primary"><a href="/updateDiet">Update Diet/Excerise</a></button><br><br>
    <button type="button" class="btn btn-primary"><a href="/maintainHist">Maintain History</a></button>	<br><br>
        </div>  
 
</body>
</html>