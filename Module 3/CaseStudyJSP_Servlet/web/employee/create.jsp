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
    <title>Create Employee</title>
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
    <a href="/employees?action=employees">List All Employee</a>
</p>
<form method="post">
    <fieldset>
        <legend>Fill Information Customer</legend>

        <div class="form" style="width: 50%">

            <%--     employee_name--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_name">Employee Name</label>
                </div>
                <input type="text" class="form-control" id="employee_name" name="employee_name">
            </div>
            <%--      employee_birthday--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_birthday">Employee BirthDay</label>
                </div>
                <input type="text" class="form-control" id="employee_birthday" name="employee_birthday">
            </div>

            <%--            employee_id_card--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_id_card">Employee ID Card</label>
                </div>
                <input type="text" class="form-control" id="employee_id_card" name="employee_id_card">
            </div>

            <%--   employee_salary--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_salary">Employee Salary</label>
                </div>
                <input type="text" class="form-control" id="employee_salary" name="employee_salary">
            </div>

            <%--   employee_phone--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_phone">Employee Phone</label>
                </div>
                <input type="text" class="form-control" id="employee_phone" name="employee_phone">
            </div>

            <%--  employee_email--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_email">Employee Email</label>
                </div>
                <input type="text" class="form-control" id="employee_email" name="employee_email">
            </div>

            <%--  employee_address--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_address">Employee Address</label>
                </div>
                <input type="text" class="form-control" id="employee_address" name="employee_address">
            </div>

            <%--            position education division username     --%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Position </label>
                </div>
                <select class="custom-select" id="inputGroupSelect01" name="position_id">
                    <option selected>Choose...</option>
                    <option value="1">Le Tan</option>
                    <option value="2">Phuc Vu</option>
                    <option value="3">Chuyen Vien</option>
                    <option value="4">Giam Sat</option>
                    <option value="5">Quan Li</option>
                    <option value="6">Giam Doc</option>
                </select>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect02">Education Degree </label>
                </div>
                <select class="custom-select" id="inputGroupSelect02" name="education_degree_id">
                    <option selected>Choose...</option>
                    <option value="1">Trung Cap</option>
                    <option value="2">Cao Dang</option>
                    <option value="3">Dai Hoc</option>
                    <option value="4">Sau Dai Hoc</option>

                </select>
            </div>


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect03">Division</label>
                </div>
                <select class="custom-select" id="inputGroupSelect03" name="division_id">
                    <option selected>Choose...</option>
                    <option value="1">Sale-Marketing</option>
                    <option value="2">Hanh Chinh</option>
                    <option value="3">Phuc Vu</option>
                    <option value="4">Quan Li</option>

                </select>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="username">Username</label>
                </div>
                <input type="text" class="form-control" id="username" name="username">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="password">Password</label>
                </div>
                <input type="password" class="form-control" id="password" name="password">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </fieldset>
</form>
</body>
</html>
