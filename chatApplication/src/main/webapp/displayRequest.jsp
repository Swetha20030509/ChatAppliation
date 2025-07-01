<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ page import="DAO.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%
int count=0;
%>
<s:if test="userList.size() > 0">
 <s:iterator value="userList" var="u">
 <div class="userDetail" id="div<%= count %>">
            <div style="height: 20px; width: 160px; font-size: 20px; color: blue; background-color: white; float: left; padding: 20px">
                <s:property value='#u.name'/>
            </div>
            <div  style="height: 20px; width: 150px; float: right; background-color: white; padding: 20px">
                <form id="form<%= count %>" action="acceptrequest" method="post">
     
                    <input type="hidden" name="receiverId" value="<s:property value='#u.id'/>">
                    <input type="hidden" name="senderId" value="<%= UserDAO.getInstance().getUser().getId() %>">
                    <button id="accept" onclick="acceptRequest('<%= count %>',"<s:property value='#u.id'/>",<%= UserDAO.getInstance().getUser().getId() %>)">Accept</button>
                </form>
                <button>Ignore</button>
            </div>
        </div>
 </s:iterator>
</s:if>
<s:else>
<p>not found</p>
</s:else>
</body>
</html>