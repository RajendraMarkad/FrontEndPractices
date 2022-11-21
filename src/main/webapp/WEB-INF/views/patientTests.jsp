<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient List</title>
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
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
			<h3 style="color: white;">Patient List</h3>
			
		</nav>
		<br><br>
        <div class="main">
            <div th:insert="header"></div>

 

            <table  border="1" width="90%" align="center" cellpadding="5" margin-top="30%">
            <tr>
                <td style="font-size: 20px; font-weight: bold;" align="center" colspan="7">Patients List</td>
            </tr>
            <tr>
              	
                <th>ID</th>
                <th>FIRSTNAME</th>
                <th>LASTNAME</th>
               
                                                              
            </tr>    
            <tr th:each="itr : ${patientList}">
            
           <c:forEach items="${patientList}" var="patient">
                <tr>
                  
                   <td><a href="/patientTest/${patient.p_Id}">${patient.p_Id}</a></td>
                    <td>${patient.firstName}</td>
                    <td>${patient.lastName}</td>
                    
                  
                   
                </tr>
                </tr>
            </c:forEach>
            
        </table>
        
        </div>
        
    </body>
</html>