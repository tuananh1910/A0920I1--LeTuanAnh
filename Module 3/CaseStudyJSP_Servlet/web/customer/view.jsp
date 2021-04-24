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
    <title>Details</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: gray">
<div align="center" >
    <h1>Details Customer</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>

        <a href="/customers?action=create" class="badge badge-light">Add New Customer</a>
        <a href="customers?action=customers "class="badge badge-light">Back To List</a>
    </p>

    <table class="table table-dark">
        <thead>
        <tr>
            <td scope="row">ID</td>
            <td scope="row"><c:out value="${customer.customer_id}"/></td>
        </tr>
        <tr>
            <td scope="row">Type id</td>
            <td scope="row"><c:out value="${customer.customer_type_id}"/></td>
        </tr>
        <tr>
            <td scope="row">Name</td>
            <td scope="row"><c:out value="${customer.customer_name}"/></td>
        </tr>
        <tr>
            <td scope="row">Birthday</td>
            <td><c:out value="${customer.customer_birthday}"/></td>
        </tr>
        <tr>
            <td scope="row">Gender</td>
            <td scope="row"><c:out value="${customer.customer_gender}"/></td>
        </tr>
        <tr>
            <td scope="row">ID Card</td>
            <td scope="row"><c:out value="${customer.customer_id_card}"/></td>
        </tr>
        <tr>
            <td scope="row">Phone</td>
            <td scope="row"><c:out value="${customer.customer_phone}"/></td>
        </tr>
        <tr>
            <td scope="row">Email</td>
            <td scope="row"><c:out value="${customer.customer_email}"/></td>
        </tr>
        <tr>
            <td scope="row">Address</td>
            <td scope="row"><c:out value="${customer.customer_address}"/></td>
        </tr>

    </table>
</div>
</body>
</html>
