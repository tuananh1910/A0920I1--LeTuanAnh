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
    <h1>Details Service</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>

<%--        <a href="/contracts?action=create" class="badge badge-light">Add New Contract</a>--%>
        <a href="/services?action=services "class="badge badge-light">Back To List</a>
    </p>


    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <div class="container bootdey flex-grow-1 container-p-y">

<%--        <div class="media align-items-center py-3 mb-3" >--%>
<%--            <div class="media-body ml-4">--%>
<%--                <a href="/contracts?action=edit" class="btn btn-primary btn-sm" >Edit</a>&nbsp;--%>
<%--                <a href="/contracts?action=Delete" class="btn btn-default btn-sm">Delete</a>&nbsp;--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="card mb-4">
            <div class="card-body">
                <table class="table user-view-table m-0">
                    <tbody>
                    <tr>
                        <td>Service ID :</td>
                        <td><c:out value="${service.service_id}"/></td>
                    </tr>
                    <tr>
                        <td>Service Name:</td>
                        <td><c:out value="${service.service_name}"/></td>
                    </tr>
                    <tr>
                        <td>Service Area:</td>
                        <td><c:out value="${service.service_area}"/></td>
                    </tr>
                    <tr>
                        <td>Service Cost</td>
                        <td><c:out value="${service.service_cost}"/></td>
                    </tr>
                    <tr>
                        <td>Service Max People:</td>
                        <td><c:out value="${service.service_max_people}"/></td>
                    </tr>
                    <tr>
                        <td>Rent Type ID:</td>
                        <td><c:out value="${service.rent_type_id}"/></td>
                    </tr>
                    <tr>
                        <td>Service Type ID:</td>
                        <td><c:out value="${service.service_type_id}"/></td>
                    </tr>
                    <tr>
                        <td>Standard Room: </td>
                        <td><c:out value="${service.standard_room}"/></td>
                    </tr>
                    <tr>
                        <td>Description Orther Convenience: </td>
                        <td><c:out value="${service.description_orther_convenience}"/></td>
                    </tr>
                    <tr>
                        <td>Pool Area: </td>
                        <td><c:out value="${service.pool_area}"/></td>
                    </tr>
                    <tr>
                        <td>Service Number Of Floors: </td>
                        <td><c:out value="${service.number_of_floors}"/></td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
        <h1>Service Type</h1>
        <div class="card mb-4">
            <div class="card-body">
                <table class="table user-view-table m-0">
                    <tbody>
                    <tr>
                        <td>Service Type ID :</td>
                        <td><c:out value="${service_type.service_type_id}"/></td>
                    </tr>
                    <tr>
                        <td>Service Type Name:</td>
                        <td><c:out value="${service_type.service_type_name}"/></td>
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
                        <td>Rent Type ID :</td>
                        <td><c:out value="${rent_type.rent_type_id}"/></td>
                    </tr>
                    <tr>
                        <td>Rent Type Name :</td>
                        <td><c:out value="${rent_type.rent_type_name}"/></td>
                    </tr>
                    <tr>
                        <td>Rent Type Cost :</td>
                        <td><c:out value="${rent_type.rent_type_cost}"/></td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>