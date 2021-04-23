<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/19/2021
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All Service</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body style="background: gray">
<div align="center" >
    <h1>List Service</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>
        <a href="/services?action=create" class="badge badge-light">Add New Service</a>
    </p>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Area</th>
            <th scope="col">Cosst</th>
            <th scope="col">Max People</th>
            <th scope="col">Rent Type ID</th>
            <th scope="col">Service Type ID</th>
            <th scope="col">Standard Room</th>
            <th scope="col">Description Orther Convenience</th>
            <th scope="col">Pool Area</th>
            <th scope="col">Number Of Floors</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="services" items="${services}">
            <tr>
                <td scope="row"><c:out value="${services.service_id}"/></td>
                <td><c:out value="${services.service_name}"/></td>
                <td><c:out value="${services.service_area}"/></td>
                <td><c:out value="${services.service_cost}"/></td>
                <td><c:out value="${services.service_max_people}"/></td>
                <td><c:out value="${services.rent_type_id}"/></td>
                <td><c:out value="${services.service_type_id}"/></td>
                <td><c:out value="${services.standard_room}"/></td>
                <td><c:out value="${services.description_orther_convenience}"/></td>
                <td><c:out value="${services.pool_area}"/></td>
                <td><c:out value="${services.number_of_floors}"/></td>

                <td><a href="/employees?action=edit&id=${services.service_id}">Edit</a></td>
                <td><a href="/employees?action=delete&id=${services.service_id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
