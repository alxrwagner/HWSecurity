<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alxrw
  Date: 28.02.2023
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Public Room</title>
</head>
<body>
<h1>Public Room</h1>

<br>
<br>
<security:authorize access="hasAnyRole('IT', 'SECURITY', 'DIRECTOR')">
    <input type="button" value="IT"
           onclick="window.location.href='servers_room'">
    Only for IT
</security:authorize>

<br>
<br>
<security:authorize access="hasAnyRole('SECURITY', 'DIRECTOR')">
    <input type="button" value="Security"
           onclick="window.location.href='security_room'">
    Only for Security
</security:authorize>

<br>
<br>

<security:authorize access="hasRole('DIRECTOR')">
    <input type="button" value="Director"
           onclick="window.location.href='director_room'">
    Only for Director
</security:authorize>

</body>
</html>
