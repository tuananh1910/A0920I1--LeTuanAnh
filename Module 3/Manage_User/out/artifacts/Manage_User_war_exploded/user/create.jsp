<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 3/28/2021
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New User</title>
</head>
<body>
<div align="center">
    <h1>Create New User</h1>
    <p>
        <a href="/users?action=users">List All Users</a>
    </p>
    <p>
        <c:if test='${requestScope["message"]!=null}'>
            <span>${requestScope["message"]}</span>
        </c:if>
    </p>
    <form method="post">

        Name : <input type="text" name="name"/>

        Email : <input type="text" name="email"/>

        Country : <input type="text" name="country"/> <br>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
