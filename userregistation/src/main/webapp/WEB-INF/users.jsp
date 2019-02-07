<%@ page import="java.util.Collection" %>
<%@ page import="pl.sdacademy.registration.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: MGK
  Date: 2019-02-03
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List users</title>
</head>
<body>

<table>
    <tr>
    <th>First name</th>
    <th>Last name</th>
    <th>Address</th>
    <th>Show user</th>
    <th>Edit user</th>

</tr>
   <% for (UserDTO user : (Collection<UserDTO>) request.getAttribute("userCollection")) {%>
        <tr>
        <th><%=user.getFirstName()%></th>
        <th><%=user.getLastName()%></th>
        <th><%=user.getAddress()%></th>
        <th><a href="userProfile?userId=<%=user.getId()%>" >Show user</a></th>
        <th><a href="userProfileEdit?userId=<%=user.getId()%>" >Edit user</a></th>
    </tr>
    <%} %>
</table>
</body>
</html>
