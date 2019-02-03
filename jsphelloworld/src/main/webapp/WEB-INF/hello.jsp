<%@ page import="java.time.LocalDateTime" %>
<%@ page import="pl.sdacademy.Counter" %><%--
  Created by IntelliJ IDEA.
  User: MGK
  Date: 2019-02-02
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
        <p>Dzisiaj jest:
            <%= request.getParameter("name")%>
        <% out.print("Licznik odwiedzin: " + Counter.INSTANCE.getCount()); %>
        </p>

</body>
</html>
