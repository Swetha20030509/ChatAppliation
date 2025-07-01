<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<%@ page import="DAO.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.material-icons
{
 color:white;
}
#contactDetail
{
	height:500px;
	width:35%;
	
	
	 box-shadow: 5px 5px 10px #c4c8eb;
	float:left;
	overflow-y: scroll;
	border-radius:30px;
}
#messages
{
	height:350px;
	width:100%;
	
	float:left;
	overflow-y: scroll;
}
#sendMessage
{
	height:60px;
	width:100%;
	
	float:left;
	postion: absolute;
}
#contactBox
{
    height: 50px;
    width: 350px;
    padding: 20px;
    display: flex;
    align-items: center;
    margin-top: 20px;
    font-size: 20px;
    font-weight: bold;
    color: black; 
    cursor: pointer; 
}
#contactBox:hover
{
	background-color:#59597d;
}
#profile
{
	height:40px;
	width:40px;
	border-radius:20px;
	background-color:white;
}
#profile-img
{
	height:40px;
	width:40px;
	border-radius:20px;
}
#chatprofile-img
{
height:40px;
	width:40px;
	border-radius:20px;
}
#msgProfile
{
	height:40px;
	width:40px;
	border-radius:20px;
	margin-left:50px;
}
#msg
{
		height:40px;
		width:850px;
		border-radius:15px;
		margin-top:10px;
		
}

#send
{
	margin-left:10px;
	height:40px;
	width:40px;
	border-radius:20px;
}
#messagecontainer
{
	height:500px;
	width:930px;
	float:left;
	display:none;
}
#profileHead
{
	height:50px;
	width:100%;
	 box-shadow: 10px 10px 20px 0 rgba(0, 0, 0, 0.5);
	 background-color:white;
}
#messages1
{
background-color:#daf8da;
height:20px;
float:right;
padding:7px;
right:50px;
border-radius:9px;
}
#messages2
{
background-color:green;
height:20px;
float:left;
padding:7px;
border-radius:9px;
}
#containers1
{
	height:30px;
	width:98%;
	margin-top:10px;
	
}
#containers2
{
	height:30px;
	width:98%;
	margin-left:10px;
	margin-top:10px;
}
#senderMsg {
        background-color: #a7a7ce;
        float:right;
         border-radius: 5px;
          padding: 5px;
         max-width:40%;     
          word-wrap: break-word;  
    }
    #receiverMsg {
        background-color: #d2d7ef;
        float:left;
         border-radius: 5px;
          max-width:40%;
           padding: 5px;
           word-wrap: break-word; 
        
    }
    .message-container {
            width: 100%;
            
            margin-bottom: 10px;
            overflow: auto; /* Clearfix alternative */
            padding: 5px;
            box-sizing: border-box;
        }
        .time{
	
	padding:2px;
	font-size:15px;
}
#friends-bar
{
height:500px;
width:400px;
float:left;
background-color:#151546;
}
</style>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
function viewUser(recevierId,senderId)
{
	console.log("hi");
	

}
function sendmessage()
{
	const now = new Date();
	let hours = now.getHours();
	let minutes = now.getMinutes();
	const ampm = hours >= 12 ? 'PM' : 'AM';

	hours = hours % 12;
	hours = hours ? hours : 12; // 0 becomes 12
	minutes = minutes < 10 ? '0' + minutes : minutes;
	
	var containers1 = document.createElement("div");
	containers1.id = "containers1";
	var div = document.createElement("div");
	var msg = document.getElementById("msg").value;
	document.getElementById("msg").value="";
	div.innerHTML = msg+"<sub class='time'>" + hours+":"+minutes+" "+ampm + "</sub>";
	div.id = "messages1";
	containers1.appendChild(div);
	document.getElementById("messages").appendChild(containers1);

	var s = document.getElementById('sen').value; 
	var r = document.getElementById('rec').value; 
	$.ajax({
		
	    type: "GET",
	    url: "send",
	    data: {
	        senderId: s,
	        receiverId: r,
	        content: msg
	    },
	    
	    success: function(response) {
	        console.log("Message sent successfully!");
	    },
	    error: function(xhr, status, error) {
	    	
	        console.error("Error:", error);
	    }
	});

	
	
}
</script>
</head>
<body>
<div>
<div id="friends-bar">

       <s:if test="friendList.size() > 0">
 <s:iterator value="friendList" var="u">
   <%
    int currentUserId = UserDAO.getInstance().getUser().getId();
   User curruser=UserDAO.getInstance().getUser();
%>
<div>
   <span class="contactBox1" id="contactBox" onclick="viewUser('<s:property value="#u.id" />','<%= currentUserId %>','<s:property value="#u.imagePath" />','<s:property value="#u.name" />')">
    <div id="profile">
            <img src="upload/<s:property value="#u.imagePath" />" id="profile-img">
            </div>
            <p style="margin: 20px;color:white"><s:property value="#u.name" /></p>
   </span>
   </div>
   </s:iterator>
 </s:if>
 <s:else>
 <p>no user</p>
 </s:else>
 </div>
    <div id="messagecontainer">
    <div id="profileHead">
    <span id="msgProfile" style="float:left"> <img  id="chatprofile-img"></span>
    <p style="float:left;font-weight:bold;margin-left:20px" id="chatProfileName"></p>
   
    </div>
    
        <div id="messages">
    
       
                <div class="message-container">
                    <div id="senderMsg"><sub class="time"></sub></div>
                    </div>
                  
               
               <div class="message-container">
                    <div id="receiverMsg"><sub class="time"></sub></div>
                    </div>
 
</div>

    

        
        <div id="sendMessage"><input type="hidden" value=0 id="sen"><input type="hidden" value=0 id="rec">
        
        <input type="text" placeholder="Message" id="msg">
        <button onclick="sendmessage()"style="background-color:#151546" id="send"><i class="material-icons">&#xe163;</i></button>
        </div>
      
        
</div>
</div>
</div>
</div>
     
    
        
</body>
</html>