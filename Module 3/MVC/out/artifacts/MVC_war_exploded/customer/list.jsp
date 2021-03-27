
<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 3/25/2021
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%-- javax.servlet:jstl:1.2--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <h1>Customer List</h1>
    <p><a href="${pageContext.request.contextPath}/customer?action=create"></a> </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["customer"]}' var="customer">
            <tr>
                <td><a href="${pageContext.request.contextPath}/customer?action=view&id=${customer.getId()}">${customer.getName()}</a> </td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getAddress()}</td>
                <td><a href="${pageContext.request.contextPath}/customer?action=edit&id=${customer.getId()}">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/customer?action=delete&id=${customer.getId()}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
