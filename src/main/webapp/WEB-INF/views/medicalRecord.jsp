<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Report</title>
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
</head>
<style>
      body {
        background-image: url('https://image.shutterstock.com/image-vector/green-color-abstract-healthy-medical-260nw-1393364825.jpg');
        background-repeat: no-repeat;
background-attachment: fixed;
background-size: cover;
      }
      h1 {
        margin: auto;
text-align: center;
color: whitesmoke;

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
<body>
  <div id="wrapper">
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
			<h3 style="color: white;">Medical Report</h3>
		</nav>
		<form:form action="/medicalReport" Method="post" modelAttribute="patient">
			<table style="margin-left: 42%; margin-top: 5%;">
				<tr>
					<td><label for="patientId">Patient Id</label></td>
					<td><form:input path="patientId" size="20" id="patientId" oninvalid="alert('You must fill Patient Id!');"  required="true" value="${name}"/></td>
				</tr>
				<tr>
					<td><label for="appointmentDate">Appointment Date</label></td>
					<td><form:input path="appointmentDate" type="date" oninvalid="alert('You must fill appointment date!');"  required="true"/></td>
				</tr>
				<tr>
					<td><label for="Prescription">Prescription</label></td>
					<td><form:textarea col="50" rows="8" path="prescription" oninvalid="alert('You must fill prescription details!');"  required="true"/></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="Add" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>		
</body>
</html>