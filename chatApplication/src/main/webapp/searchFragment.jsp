<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DAO.UserDAO"%>
    <%@ page import="model.User"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%@ taglib uri="/struts-tags" prefix="s" %>

<s:if test="userList.size() > 0">
<span class="close-btn1" id="close1" onclick="closePop()">&times;</span>
    <s:iterator value="userList" var="u">
        <div id="container">
        <img src="upload/<s:property value="#u.imagePath" />" style="height:50px;width:50px;float:left;border-radius:25px;margin-top:-10px">
		<div id="searchDiv">
			<p id="searchUser" style="margin-left:20px;margin-top:-20px;" ><s:property value="#u.name"/></p>
		</div>
		<%
		User user = UserDAO.getInstance().getUser();	
		%>
		<s:if test="#u.friendStatus == 'accepted'">
		
		 <form action="chat">
            <input type="hidden" name="senderId" value="<%= user.getId() %>">
            <input type="hidden" name="receiverId" value="<s:property value='#u.id'/>">
            <button id="req">Chat</button>
        </form>
        </s:if>
		<s:elseif test="#u.friendStatus == 'pending'">
			
		 <form action="request">
            <input type="hidden" name="senderId" value="<%= user.getId() %>">
            <input type="hidden" name="receiverId" value="<s:property value='#u.id'/>">
            <button id="req">Pending</button>
        </form>
       </s:elseif>
       <s:else>
		<form action="request">
			<input type="hidden" name="senderId" value="<%=user.getId()%>">
			<input type="hidden" name="receiverId" value="<s:property value='#u.id'/>">
			<button id="req">request</button>
		</form>
		</s:else>
	</div>
    </s:iterator>
</s:if>
<s:else>
    <p>No users found.</p>
</s:else>

</body>
</html>