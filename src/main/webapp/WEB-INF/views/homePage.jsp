<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
          background-image: url('https://cdn.wallpapersafari.com/25/64/6jVwBz.jpg');
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
 
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <h1>Patient Tracker </h1>
  </nav>
  
    
    <div class="container">  
    <button type="button" class="btn btn-primary"> <a href="/adminLogin">Admin </a> </button><br>
    <button type="button" class="btn btn-primary"><a href="/patientReg">Patient </a></button><br>
    <button type="button" class="btn btn-primary"><a href="/clerkReg">Clerk </a></button><br>
    <button type="button" class="btn btn-primary"><a href="/doctorReg">Doctor</a></button><br>
        </div>  
 
</body>
</html>