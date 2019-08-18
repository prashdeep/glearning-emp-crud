<%--
  Created by IntelliJ IDEA.
  User: classpath
  Date: 16-Aug-19
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Success</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">

    <form:form action="/submit" method="post" modelAttribute="user">
        <label>Name</label>
        <form:input path="name" placeholder="Enter your name"/>
        <form:errors path="name" cssClass="error"/></small>
        <label>Age</label>
        <form:input path="age" placeholder = "Enter your age"/>
        <form:errors path="age" cssClass="error"/></small>
        <button type="submit">Submit</button>
    </form:form>
    <%--<form:form action="/submit" method="POST" >--%>
        <%--<div class="form-group">--%>
            <%--<label>Name:</label>--%>
              <%--<form:input path="name" size="30" cssClass="form-control" placeholder="Enter name"/>--%>
              <%--<small><form:errors path="name" cssClass="error"/></small>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label>Age:</label><form:input path="age" cssClass="form-control" placeholder="Enter age"/>--%>
            <%--<small><form:errors path="age" cssClass="error"/></small>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<button type="submit">Submit</button>--%>
        <%--</div>--%>
    <%--</form:form>--%>
</div>

</body>
</html>
