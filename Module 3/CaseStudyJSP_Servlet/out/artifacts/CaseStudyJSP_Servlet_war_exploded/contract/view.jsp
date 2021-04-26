<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/24/2021
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details Contract</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: gray">
<div align="center" >
    <h1>Details Contract</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>

        <a href="/contracts?action=create" class="badge badge-light">Add New Contract</a>
        <a href="contracts?action=contracts "class="badge badge-light">Back To List</a>
    </p>


    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <div class="container bootdey flex-grow-1 container-p-y">

        <div class="media align-items-center py-3 mb-3" >
            <div class="media-body ml-4">
                <a href="/contracts?action=edit" class="btn btn-primary btn-sm" >Edit</a>&nbsp;
                <a href="/contracts?action=Delete" class="btn btn-default btn-sm">Delete</a>&nbsp;
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-body">
                <table class="table user-view-table m-0">
                    <tbody>
                    <tr>
                        <td>ID :</td>
                        <td><c:out value="${contract.contract_id}"/></td>
                    </tr>
                    <tr>
                        <td>Start Date:</td>
                        <td><c:out value="${contract.contract_start_date}"/></td>
                    </tr>
                    <tr>
                        <td>End Date:</td>
                        <td><c:out value="${contract.contract_end_date}"/></td>
                    </tr>
                    <tr>
                        <td>Deposit</td>
                        <td><c:out value="${contract.contract_deposit}"/></td>
                    </tr>
                    <tr>
                        <td>Total Money:</td>
                        <td><c:out value="${contract.contract_total_money}"/></td>
                    </tr>
                    <tr>
                        <td>Total Money:</td>
                        <td><c:out value="${contract.contract_total_money}"/></td>
                    </tr>
                    <tr>
                        <td>Employee ID:</td>
                        <td><c:out value="${contract.employee_id}"/></td>
                    </tr>
                    <tr>
                         <td>Customer ID: </td>
                         <td><c:out value="${contract.customer_id}"/></td>
                    </tr>
                    <tr>
                        <td>Service ID: </td>
                        <td><c:out value="${contract.service_id}"/></td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    <h1>Contract Details</h1>
    <div class="card mb-4">
        <div class="card-body">
            <table class="table user-view-table m-0">
                <tbody>
                <tr>
                    <td>Contract Details ID :</td>
                    <td><c:out value="${contract_details.contract_deteails_id}"/></td>
                </tr>
                <tr>
                    <td>Contract ID:</td>
                    <td><c:out value="${contract_details.contrac_id}"/></td>
                </tr>
                <tr>
                    <td>Attach Service ID:</td>
                    <td><c:out value="${contract_details.attach_service_id}"/></td>
                </tr>
                <tr>
                    <td>Quality</td>
                    <td><c:out value="${contract_details.quality}"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <h1>Attach Service</h1>
    <div class="card mb-4">
        <div class="card-body">
            <table class="table user-view-table m-0">
                <tbody>
                <tr>
                    <td>Attach Service ID :</td>
                    <td><c:out value="${attach_service.attach_service_id}"/></td>
                </tr>
                <tr>
                    <td>Attach Service Name:</td>
                    <td><c:out value="${attach_service.attach_service_name}"/></td>
                </tr>
                <tr>
                    <td>Attach Service Cost:</td>
                    <td><c:out value="${attach_service.attach_service_cost}"/></td>
                </tr>
                <tr>
                    <td>Attach Service Unit</td>
                    <td><c:out value="${attach_service.attach_service_unit}"/></td>
                </tr>
                <tr>
                    <td>Attach Service Status</td>
                    <td><c:out value="${attach_service.attach_service_status}"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    </div>
</div>
</body>
</html>