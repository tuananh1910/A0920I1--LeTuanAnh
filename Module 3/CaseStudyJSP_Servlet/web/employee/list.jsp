<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/19/2021
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Empoyee</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: gray">
<div align="center" >
    <h1>List Employee</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>
        <a href="/employees?action=create" class="badge badge-light">Add New Empoyee</a>
    </p>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">ID Card</th>
            <th scope="col">Salary</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Position ID</th>
            <th scope="col">Education Degree ID</th>
            <th scope="col">Division ID</th>
            <th scope="col">Username</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employees" items="${employees}">
            <tr>
                <td scope="row"><c:out value="${employees.employee_id}"/></td>
                <td><c:out value="${employees.employee_name}"/></td>
                <td><c:out value="${employees.employee_birthday}"/></td>
                <td><c:out value="${employees.employee_id_card}"/></td>
                <td><c:out value="${employees.employee_salary}"/></td>
                <td><c:out value="${employees.employee_phone}"/></td>
                <td><c:out value="${employees.employee_email}"/></td>
                <td><c:out value="${employees.employee_address}"/></td>
                <td><c:out value="${employees.position_id}"/></td>
                <td><c:out value="${employees.education_degree_id}"/></td>
                <td><c:out value="${employees.division_id}"/></td>
                <td><c:out value="${employees.username}"/></td>
                <td><a href="/employees?action=edit&id=${employees.employee_id}">Edit</a></td>
                <td><a href="/employees?action=delete&id=${employees.employee_id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

