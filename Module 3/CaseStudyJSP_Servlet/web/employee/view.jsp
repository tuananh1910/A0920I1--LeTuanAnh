<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/19/2021
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: gray">
<div align="center" >
    <h1>Details Employee</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>
        <a href="/employees?action=create" class="badge badge-light">Add New Empoyee</a><br>
        <a href="employees?action=employees" class="badge badge-light">Back To List</a>
    </p>
    <table class="table table-dark">

        <tr>
            <td scope="col">ID</td>
            <td scope="row"><c:out value="${employee.employee_id}"/></td>
        </tr>
        <tr>
            <td scope="col">Name</td>
            <td scope="col"><c:out value="${employee.employee_name}"/></td>

        </tr>
        <tr>
            <td scope="col">Birthday</td>
            <td scope="col"><c:out value="${employee.employee_birthday}"/></td>

        </tr>
        <tr>
            <td scope="col">ID Card</td>
            <td scope="col"><c:out value="${employee.employee_id_card}"/></td>

        </tr>
        <tr>
            <td scope="col">Salary</td>
            <td scope="col"><c:out value="${employee.employee_salary}"/></td>

        </tr>
        <tr>
            <td scope="col">Phone</td>
            <td scope="col"><c:out value="${employee.employee_phone}"/></td>

        </tr>
        <tr>
            <td scope="col">Email</td>
            <td scope="col"><c:out value="${employee.employee_email}"/></td>

        </tr>
        <tr>
            <td scope="col">Address</td>
            <td scope="col"><c:out value="${employee.employee_address}"/></td>

        </tr>
        <tr>
            <td scope="col">Position ID</td>
            <td scope="col"><c:out value="${employee.position_id}"/></td>

        </tr>
        <tr>
            <td scope="col">Education Degree ID</td>
            <td scope="col"><c:out value="${employee.education_degree_id}"/></td>

        </tr>
        <tr>
            <td scope="col">Division ID</td>
            <td scope="col"><c:out value="${employee.division_id}"/></td>

        </tr>
        <tr>
            <td scope="col">Username</td>
            <td scope="col"><c:out value="${employee.username}"/></td>

        </tr>


    </table>
</div>
</body>
</html>
