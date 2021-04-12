<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/12/2021
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
<div align="center">
    <h1>List User</h1>
    <table border="1" cellpadding="5" width="80%">
        <tr>
            <th>ID</th>
            <th>Type id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <c:forEach var="customers" items="${customers}">
            <tr>
                <td><c:out value="${customers.customer_id}"/></td>
                <td><c:out value="${customers.customer_type_id}"/></td>
                <td><c:out value="${customers.customer_name}"/></td>
                <td><c:out value="${customers.customer_birthday}"/></td>
                <td><c:out value="${customers.customer_gender}"/></td>
                <td><c:out value="${customers.customer_id_card}"/></td>
                <td><c:out value="${customers.customer_phone}"/></td>
                <td><c:out value="${customers.customer_emnai}"/></td>
                <td><c:out value="${customers.customer_address}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
