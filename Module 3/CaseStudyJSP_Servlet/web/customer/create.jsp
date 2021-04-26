<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/12/2021
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<p>
    <a href="http://localhost:8080"> Home </a> <br>
    <a href="/customers?action=customers">List All Customer</a>
</p>
<form method="post">
    <fieldset>
        <legend>Fill Information Customer</legend>
        <div class="form" style="width: 50%">
<%--            customer ID--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_id">Customer ID</label>
                </div>
                <input type="text" class="form-control" id="customer_id" name="customer_id" placeholder="KH-XXXX">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Customer Types</label>
                </div>
                <select class="custom-select" id="inputGroupSelect01" name="customer_type_id">
                    <option selected>Choose...</option>
                    <option value="1">Member</option>
                    <option value="2">Silver</option>
                    <option value="3">Gold</option>
                    <option value="4">Platinum</option>
                    <option value="5">Diamond</option>
                </select>
            </div>
<%--             name customer--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_name">Customer Name</label>
                </div>
                <input type="text" class="form-control" id="customer_name" name="customer_name">
            </div>
<%--            birthday--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_birthday">Customer BirthDay</label>
                </div>
                <input type="date" class="form-control" id="customer_birthday" name="customer_birthday">
            </div>

<%--            gender customer--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect02">Customer Gender</label>
                </div>
                <select class="custom-select" id="inputGroupSelect02" name="customer_gender">
                    <option selected>Choose...</option>
                    <option value="0">Male</option>
                    <option value="1">Female</option>
                </select>
            </div>

<%--            Customer ID card--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_id_card">Customer ID Card</label>
                </div>
                <input type="text" class="form-control" id="customer_id_card" name="customer_id_card">
            </div>

<%--            Customer Phone--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_phone">Customer Phone</label>
                </div>
                <input type="text" class="form-control" id="customer_phone" name="customer_phone">
            </div>

<%--            Email--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_email">Customer Email</label>
                </div>
                <input type="text" class="form-control" id="customer_email" name="customer_email">
            </div>

<%--            Address--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_address">Customer Address</label>
                </div>
                <input type="text" class="form-control" id="customer_address" name="customer_address">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </fieldset>
</form>
</body>
</html>
