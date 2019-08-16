<%--
  Created by IntelliJ IDEA.
  User: classpath
  Date: 16-Aug-19
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of All employees</title>
</head>
<body>

<h2>All Employees in System</h2>

<table border="1">
    <tr>
        <th>Employee Id</th>
        <th> Name</th>

    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.empId}</td>
            <td>${employee.name}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
