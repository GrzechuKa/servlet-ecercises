<%@ page import="pl.sdacademy.registration.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: MGK
  Date: 2019-02-03
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
</head>
<body>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
            <% UserDTO userDTO = (UserDTO) request.getAttribute("userProfile"); %>
    </tr>
      <tr>
        <th><%= userDTO.getFirstName() %></th>
        <th><%= userDTO.getLastName()%></th>
        <th><%= userDTO.getAddress()%></th>
    </tr>

</table>


</body>
</html>
