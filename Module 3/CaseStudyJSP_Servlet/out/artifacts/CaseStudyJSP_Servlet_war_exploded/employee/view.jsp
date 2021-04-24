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

        <a href="/employees?action=create" class="badge badge-light">Add New Employee</a>
        <a href="/employees?action=employees "class="badge badge-light">Back To List</a>
    </p>


    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <div class="container bootdey flex-grow-1 container-p-y">

        <div class="media align-items-center py-3 mb-3" >
            <div class="media-body ml-4">
                <a href="/employees?action=edit" class="btn btn-primary btn-sm" >Edit</a>&nbsp;
                <a href="/employees?action=Delete" class="btn btn-default btn-sm">Delete</a>&nbsp;
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-body">
                <table class="table user-view-table m-0">
                    <tbody>
                    <tr>
                        <td>ID :</td>
                        <td><c:out value="${employee.employee_id}"/></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><c:out value="${employee.employee_name}"/></td>
                    </tr>
                    <tr>
                        <td>BithDay :</td>
                        <td><c:out value="${employee.employee_birthday}"/></td>
                    </tr>
                    <tr>
                        <td>ID Card</td>
                        <td><c:out value="${employee.employee_id_card}"/></td>
                    </tr>
                    <tr>
                        <td>Salary:</td>
                        <td><c:out value="${employee.employee_salary}"/></td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td><c:out value="${employee.employee_phone}"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><c:out value="${employee.employee_email}"/></td>
                    </tr>
                    <tr>
                        <td>Address : </td>
                        <td><c:out value="${employee.employee_address}"/></td>
                    </tr>
                    <tr>
                        <td>Position ID: </td>
                        <td><c:out value="${employee.position_id}"/></td>
                    </tr>
                    <tr>
                        <td>Education Degree ID: </td>
                        <td><c:out value="${employee.education_degree_id}"/></td>
                    </tr>
                    <tr>
                        <td>Division ID: </td>
                        <td><c:out value="${employee.division_id}"/></td>
                    </tr>
                    <tr>
                        <td>Username: </td>
                        <td><c:out value="${employee.username}"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
