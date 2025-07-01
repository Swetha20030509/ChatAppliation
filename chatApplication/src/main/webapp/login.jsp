<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Form</title>
  <style>
   #outer
{
height:500px;
	width:900px;
	
	margin:auto;
	margin-top:50px;
	
}
#loginOuter
{
	height:500px;
	width:400px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
	float:left;
	display: flex;
  flex-direction: column;      /* Items stack vertically */
  align-items: center;         /* Center horizontally */
  justify-content: center;  
   
   
}
#messageProfile
{
	height:100px;
	width:100px;
	
}
#chatApphead
{
	
	 font-family: Verdana, sans-serif;
	 font-size: 28px;
  margin: 10px 0;
}
#inputMobile
{
	font-color:black;
	font-weight:bold;
	height:40px;
	width:300px;
	border:1px solid gray;
	border-radius: 10px;
	 margin: 10px 0;
	  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
#inputPassword
{
	font-color:black;
	font-weight:bold;
	height:40px;
	width:300px;
	border:1px solid gray;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
  margin: 10px 0;
}
#login
{
	height:40px;
	width:300px;
	background-image:linear-gradient(to right,#4ebbec, #061ea0);
	border:1px solid #3690d8;
	color:white;
	font-size:16px;
	font-weight:bold;
	
}
#login:hover
{
	background-image:linear-gradient(to right,#061ea0,#4ebbec);
}
#loginImg
{
height:500px;
	width:400px;
	
	float:right;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
	
}
#sendImg
{
height:500px;
	width:400px;
}
a{
	 text-decoration: none;
  font-size: 18px;
  font-weight:bold;
  transition: color 0.3s ease;
}
a:hover
{
	color: #0056b3;
  text-decoration: underline;
}
  </style>
</head>
<body>
 <form class="login-form" action="Login" method="post">
		<div id="outer">
		<div id="loginOuter">
		<img src="messageLogin.jpg" id="messageProfile">
		<h1 id="chatApphead">Chat App</h1>
		<h1 id="chatApphead">Login</h1>
		
		<input type="text" placeholder="MobileNumber" id="inputMobile" name="mobileNo">
		<input type="text" placeholder="Password" id="inputPassword" name="password">
		<input type="submit" id="login" value="Login">
		<p>Don't have an account?</p>
		<a href="signup.jsp">SignUp</a>
		</div>
		<div id="loginImg">
			<img src="messagesend.jpg" id="sendImg">
		</div>
		</div>
		</form>
</body>
</html>
