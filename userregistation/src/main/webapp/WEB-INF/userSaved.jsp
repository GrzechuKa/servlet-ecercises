<%--
  Created by IntelliJ IDEA.
  User: MGK
  Date: 2019-02-03
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>User saved</title>
</head>
<body>
<%@include file="header.html"%>
        <p>User saved : <%= (request.getParameter("firstName") + " " + request.getParameter("lastName")) %></p>
        <a href="users">Show users</a>
</body>
</html>
