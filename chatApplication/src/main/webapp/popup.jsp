<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="action.Friendrequest"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#displayFriendReq {
	height: 500px;
	width: 500px;
	margin: auto;
	margin-top: 50px;
	overflow-y: scroll;
	background-color: white;
	box-shadow: 5px 10px 18px #888888;
}

#userDetail {
	height: 60px;
	width: 400px;
	margin-left: 50px;
	margin-top: 50px;
	background-color: white;
	box-shadow: 5px 10px 18px #888888;
}

.close-btn {
	position: absolute;
	top: 10px;
	right: 10px;
	cursor: pointer;
	font-size: 40px;
}

#displayDeatil {
	
}

body {
	background-color: #cecbd4;
}
</style>
<script>
function closePopup()
{
	document.getElementById("close").submit();
}
</script>
<body>
	<%
	Friendrequest fq = new Friendrequest();
	ArrayList<User> Request = fq.getUserList();
	%>
	<div id="displayFriendReq">
		
		<span class="close-btn" id="close" onclick="closePopup()">&times;</span>
		
		<%
		for (User user : Request) {
		%>
		<div id="userDetail">
			<div
				style="height: 20px; width: 160px; font-size: 20px; color: blue; background-color: white; float: left; padding: 20px"><%=user.getName()%></div>
			<div
				style="height: 20px; width: 150px; float: right; background-color: white; padding: 20px">
				<button>Accept</button>
				<button>Ignore</button>
			</div>
		</div>
		<%
		}
		%>
	</div>
	</div>
</body>
</html>