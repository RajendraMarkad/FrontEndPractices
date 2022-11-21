<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Bill</title>
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
	<style>
        body {
          background-image: url('https://image.shutterstock.com/image-vector/abstract-geometric-shape-medicine-science-260nw-767767987.jpg');
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
text-color: white
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
<div id="wrapper">
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
			<h3 style="color: white;">Bill Generation</h3>
		</nav>
		<div class="container" style="margin-left:10%; margin-top:5%;font-size=10rem;float:left">	
		   <a href="/consultation" >Consultation</a><br><br>
           <a href="/stay">Stay</a><br><br>
           <a href="/prescription">Prescription</a><br><br>
           <a href="/labCharges">Lab Charges</a><br><br>
           <a href="/nursingCharges">Nursing Charges</a><br><br>
           <br>
           <br>
           <a href="/adminhHome">Go back to admin Home</a>
	   </div>
	   <br>
</div>
	  <br>
	 
	<%-- <form action="/selectedBill" method="POST">
        <input type="checkbox" name="bill" value="consultation">Consultation<br/>
        <input type="checkbox" name="bill" value="stay">Stay<br/>
        <input type="checkbox" name="bill" value="prescription">Prescription<br/>
        <input type="checkbox" name="bill" value="labCharges">Lab Charges<br/>
        <input type="checkbox" name="bill" value="nursingCharges">Nursing Charges<br/>
        <input type="submit" value="Submit">
    </form>	
    <select  id="option" class="chosen" multiple>
<option selected disabled>Select Bank</option>
<option value="/consultation">consultation</option>
<option value="/stay" >stay</option>
</select><br/>--%>
 	
</body>
</html>