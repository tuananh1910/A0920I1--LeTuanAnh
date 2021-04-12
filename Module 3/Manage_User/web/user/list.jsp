<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 3/28/2021
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
</head>
<body>
<div align="center">
    <h1>List User</h1>
    <p><a href="/users?action=create">Create New User</a> </p>
    <p><a href="/users?action=find">Find User</a> </p>
    <table border="1" cellpadding="5" width="80%">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td><a href="/users?action=edit&id=${user.id}">Edit</a> </td>
                <td><a href="/users?action=delete&id=${user.id}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
