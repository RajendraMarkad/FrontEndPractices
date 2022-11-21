<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Details</title>
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
</style>
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
    <nav class="navbar navbar-expand-lg navbar-light bg-dark">
        <h3 style="color: white;">Patient Details</h3>
        <form:form action="/patientLogin" method="get" modelAttribute="patient">
            <div style="margin-left: 60rem">
                <input name="login" id="login" class="btn btn-primary" type="submit"
                    value="Logoff">
            </div>
        </form:form>
    </nav>
    <div class="container" style="margin-left:10%; margin-top:5%;font-size=2rem;float:left">
      <table align="center">
       <tr>
       <td>Patient Id:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.patientId}<td></tr>
       <tr>
       <td>Patient First Name:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.firstName}<td></tr>
       
       <tr>
       <td>Patient Last Name:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.lastName}<td></tr>
       <tr>
       <td>Date Of Birth:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.dob}<td></tr>
       <tr>
       <td>Gender:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.gender}<td></tr>
          <tr>
       <td>Contact No:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.contactNo}<td></tr>
          <tr>
       <td>Address:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.address}<td></tr>
          <tr>
       <td>Status:&nbsp;&nbsp;&nbsp;</td>
       <td>${patient.status}<td></tr>
       
       
</table>
<br>
<br>
 <a href="/adminhHome">Go back to admin Home</a>
    </div>
  
</body>
</html>