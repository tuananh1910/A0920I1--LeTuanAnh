<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/23/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Contract</title>
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
    <a href="/employees?action=contracts">List All Contracts</a>
</p>
<form method="post">
    <fieldset>
        <legend>Fill Information Contract</legend>

        <div class="form" style="width: 50%">

            <%--     contract_start_date--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="contract_start_date">Contract Start Date</label>
                </div>
                <input type="text" class="form-control" id="contract_start_date" name="contract_start_date">
            </div>
            <%--      contract_end_date--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="contract_end_date">Contract End Date</label>
                </div>
                <input type="text" class="form-control" id="contract_end_date" name="contract_end_date">
            </div>

            <%--            contract_deposit--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="contract_deposit">Contract Deposite</label>
                </div>
                <input type="text" class="form-control" id="contract_deposit" name="contract_deposit">
            </div>

            <%--   contract_total_money--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="contract_total_money">Contract Total Money</label>
                </div>
                <input type="text" class="form-control" id="contract_total_money" name="contract_total_money">
            </div>

            <%--   employee_id--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="employee_id">Employee ID</label>
                </div>
                <input type="text" class="form-control" id="employee_id" name="employee_id">
            </div>

            <%--  customer_id--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customer_id">Customer ID</label>
                </div>
                <input type="text" class="form-control" id="customer_id" name="customer_id">
            </div>

            <%--  service_id--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="service_id">Service ID</label>
                </div>
                <input type="text" class="form-control" id="service_id" name="service_id">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </fieldset>
</form>
</body>
</html>
