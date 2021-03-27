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
    <title>View Product</title>
</head>
<body>
    <h1>Product Details</h1>
    <p>
        <a href="${pageContext.request.contextPath}/products">Back to products list</a>
    </p>
    <table>
        <tr>
            <td>Name: </td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Description: </td>
            <td>${requestScope["product"].getDescription()}</td>
        </tr>
        <tr>
            <td>Supply: </td>
            <td>${requestScope["product"].getSupply()}</td>
        </tr>
    </table>
</body>
</html>
