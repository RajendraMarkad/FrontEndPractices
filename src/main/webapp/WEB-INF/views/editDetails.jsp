<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Registration</title>
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
            <h3 style="color: white;">Update Patient Registration</h3>
            
        </nav>
         <br>
        <h2 style="text-align: center">Update Patient Registration</h2>
        <form:form action="/editDetails/${pId}" method="post" modelAttribute="patient">
            <table style="margin-left: 35%; margin-top: 5%;">
                 <tr>
       <td>
         <label for="fname">First Name</label>
       </td>
       <td>  
         <form:input path="firstName" size="25" id="fname" placeholder="Enter the first Name" autocomplete="off" oninvalid="alert('You must fill first name!');" required="true" value="${firstName}" />
       </td>
     </tr>     
         
     <tr>
       <td>
         <label for="lname">Last Name</label>
       </td>
       <td>  
         <form:input path="lastName" size="25" id="lname" placeholder="Enter the last Name" autocomplete="off" oninvalid="alert('You must fill last name!');" required="true" value="${secondName}"/>
       </td>
     </tr> 
     <tr>
       <td>
         <label for="dob">DOB</label>
       </td>
       <td>  
        <form:input path="dob" size="25" id="dob" type="date" placeholder="Enter the date of birth" class="date" autocomplete="off" oninvalid="alert('You must fill DOB!');" required="true" value="${dob}"/>
       </td>
     </tr> 
       <tr>
       <td>
         <label for="contactNo">Contact No</label>
       </td>
       <td>  
         <form:input path="contactNo" size="25" id="cntNo" placeholder="Enter the contactNo" autocomplete="off" oninvalid="alert('You must fill Contact Number!');" required="true" value="${contactNo}"/>
       </td>
     </tr> 
     <tr>
                    <td><label for="patientId">Patient Id</label></td>
                    <td><form:input path="patientId" size="25" id="patientId" placeholder="Enter patient Id" autocomplete="off" oninvalid="alert('You must fill Patient Id!');" required="true" value="${patientId}"/></td>
                </tr>

      <tr>
       <td>
         <label for="address">Address</label>
       </td>
       <td>  
          <form:textarea path="address" placeholder="Address" value="${address}"/>
       </td>
     </tr> 
                
                <tr><td></td><td></td></tr>
                <tr>
                    <td colspan=2 align=center><input class="btn btn-primary" type=submit value="Update" style="width:40%"/>
                    </td>
                </tr>
            </table>
        </form:form>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
    </div>
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