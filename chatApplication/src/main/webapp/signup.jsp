<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign Up Form</title>
  <style>
   #signUpOuter
   {
   	background-color:white;
   	height:500px;
   	width:500px;
   	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.4);
   	margin:auto;
   	
  margin-top: 50px;    
  
   }
    input
    {
    height:40px;
	width:300px;
	 margin: 10px 0;
	
	border:1px solid white;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.4);
	border-radius: 10px;
	font-color:black;
	font-weight:bold;
    }
    #signupButton
    {
    	background-image:linear-gradient(to right,#4ebbec, #061ea0);
    	color:white;
	font-size:16px;
	font-weight:bold;
    	border:1px solid #4ebbec;
    }
    #signupButton:hover
    {
    	background-image:linear-gradient(to right,#061ea0,#4ebbec);
    }
    #titleSignup
    {
    	color:#1939ee;
    	 margin-left:180px;
    	
    	font-size:35px;
    	
    	
    	
    }
   #close
{
cursor:pointer;
position: absolute;
	margin-left:320px;
	cursor: pointer;
	font-size: 40px;
	margin-left:150px;
}
#container
{
   display: flex;
  flex-direction: column;      
  align-items: center; 
  height:500px;
   	width:500px;
   	margin-top:50px;
}
a{
	 text-decoration: none;
	 display: inline-block;
  font-size: 18px;
  font-weight:bold;
  transition: color 0.3s ease;
}
a:hover
{
	color: #0056b3;
  text-decoration: underline;
}
body
{
	background-color:#cfe0ee;
}
  </style>
</head>
<body>

<div class="container">
  
  <form action="SignUp" method="post">
  	
    	<div id="signUpOuter">
    	
    	<h1 id="titleSignup">Sign Up</h1>
    	
    	
    	<div id="container">
      <input type="text" id="username" name="username" placeholder="username" required>
   
      <input type="text" id="phonenumber" name="mobileNo" placeholder="phonenumber" required>
    
   
      <input type="text" id="name" name="name" placeholder="name" required>
    
      <input type="password" id="password" name="password" placeholder="password" required>
    
    
      <input type="submit" value="Sign Up" id="signupButton">
      <p>Already have an acccount ?</p>
		<a href="index.jsp">Login</a>
		</div>
      </div>
  </form>
</div>

</body>
</html>
