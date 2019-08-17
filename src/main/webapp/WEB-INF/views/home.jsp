<%--
  Created by IntelliJ IDEA.
  User: classpath
  Date: 17-Aug-19
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to User Management Page</title>
</head>
<body>
    <h1>Welcome to Twitter!!</h1>
    <ul>
        <c:forEach var="user" items="${users}">
            <li>${user.name}</li>
        </c:forEach>
        </ul>
</body>
</html>
