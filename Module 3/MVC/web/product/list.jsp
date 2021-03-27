<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 3/26/2021
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <p><a href="${pageContext.request.contextPath}/products?action=create"></a> </p>
    <table>
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Supply</td>
        </tr>
        <c:forEach items='${requestScope["message"]}' var="product">
            <tr>
                <td><a href="${pageContext.request.contextPath}/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getSupply()}</td>
                <td><a href="${pageContext.request.contextPath}/products?action=edit&id=${product.getId()}">Edit</a> </td>
                <td><a href="${pageContext.request.contextPath}/products?action=delete&id=${product.getId()}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
