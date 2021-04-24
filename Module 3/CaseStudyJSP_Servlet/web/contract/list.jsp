<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/22/2021
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Contract</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: gray">
<div align="center" >
    <h1>List Contract</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>
        <a href="/contracts?action=create" class="badge badge-light">Add New Contract</a>
    </p>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Start Day</th>
            <th scope="col">End Day</th>
            <th scope="col">Deposit</th>
            <th scope="col">Total Money</th>
            <th scope="col">Employee ID</th>
            <th scope="col">Customer ID</th>
            <th scope="col">Service ID</th>
            <th scope="col">Details</th>
            <th scope="col">Add Contract Details</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contracts" items="${contracts}">
            <tr>
                <td scope="row"><c:out value="${contracts.contract_id}"/></td>
                <td><c:out value="${contracts.contract_start_date}"/></td>
                <td><c:out value="${contracts.contract_end_date}"/></td>
                <td><c:out value="${contracts.contract_deposit}"/></td>
                <td><c:out value="${contracts.contract_total_money}"/></td>
                <td><c:out value="${contracts.employee_id}"/></td>
                <td><c:out value="${contracts.customer_id}"/></td>
                <td><c:out value="${contracts.service_id}"/></td>
                <td><a href="/contracts?action=details&id=${contracts.contract_id}">Details</a> </td>
                <td><a href="/contracts?action=contract_details&id=${contracts.contract_id}">Add Contract Details</a> </td>
                <td><a href="/contracts?action=edit&id=${contracts.contract_id}">Edit</a></td>
                <td><a href="/contracts?action=delete&id=${contracts.contract_id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
