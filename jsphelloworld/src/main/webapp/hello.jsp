<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: MGK
  Date: 2019-02-02
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hellow World</title>
</head>
<body>
        <p>Dzisiaj jest: <%= LocalDateTime.now()%> </p>
</body>
</html>
