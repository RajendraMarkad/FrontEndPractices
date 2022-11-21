<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script> 
</head>
<body>
<div id="wrapper">
  <nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<h3 style="color: white;">Reset Password</h3>
	</nav>
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
	<br>
	<h2 style="text-align:center">Reset Password</h2>
	
  <form:form action="/resetPassword/${patientId}" Method="post" modelAttribute="patient">
    <table style="margin-left: 42%; margin-top: 5%; font-size=40px;">
     <tr>
			<td><label for="reset">Reset Password:&nbsp;&nbsp;&nbsp;</label></td>
			<td><form:input path="password" size="25" id="password" oninvalid="alert('You must fill Password with atleast 6 charcters, one number and special characters(@#!)!');" placeholder="Enter the New Password: " pattern="((?=.*\d)(?=.*[!@#$%]).{6,})" required="true"/></td>
	 </tr> 
     <tr>
         <td colspan=2 align=center><input class="btn btn-primary" type=submit value="Submit" style="width:40%"/>
         </td>
      </tr>
    </table>
  </form:form> 
  <br>
  <br>
   <h2 style="margin-left:40rem;">${msg}</h2>
  </div>
  <br>
  <br>
  
  <script> 
        $(document).ready(function() { 
            $("input").focusout(function() { 
                if($(this).val()=='') { 
                    $(this).css('border', 'solid 2px red'); 
                } 
                else
            	{
            	$(this).css('border', 'solid 2px black');
            	}
            }) .trigger("focusin");
        }); 
    </script> 
</body>
</html>