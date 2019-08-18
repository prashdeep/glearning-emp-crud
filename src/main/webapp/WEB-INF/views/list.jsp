<%--
  Created by IntelliJ IDEA.
  User: classpath
  Date: 18-Aug-19
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of all Users</title>
</head>
<body>

<h1>List of all users</h1>

<h2>Number of Users accessing the Twitter application is ${users.size()}</h2>

<h2>Register new User</h2>
<a href="/register">Register New User !!</a>

    <ul>
        <c:forEach var="user" items="${users}">
         <li>${user.name}</li>
        </c:forEach>
    </ul>

<c:if test="${users.size() > 2}">
    <h2>Awesome !!. We have many users ....</h2>
</c:if>



</body>
</html>
