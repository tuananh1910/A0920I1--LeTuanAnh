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
    <title>List Customer</title>




<%--    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>

<%--    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">--%>
<%--    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>--%>


</head>
<body style="background: gray">
<div align="center" >
    <h1>List User</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>
        <a href="/customers?action=create" class="badge badge-light">Add New Customer</a>
    </p>
<%--    <p>--%>
<%--        <c:if test="${requestScope['message']!= null}}">--%>
<%--            <span>${requestScope['message']}</span>--%>
<%--        </c:if>--%>
<%--    </p>--%>
    <table  id="table_id" class="display">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Type id</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Gender</th>
            <th scope="col">ID Card</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Details</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customers" items="${customers}">
            <tr>
                <td scope="row"><c:out value="${customers.customer_id}"/></td>
                <td><c:out value="${customers.customer_type_id}"/></td>
                <td><c:out value="${customers.customer_name}"/></td>
                <td><c:out value="${customers.customer_birthday}"/></td>
                <td><c:out value="${customers.customer_gender}"/></td>
                <td><c:out value="${customers.customer_id_card}"/></td>
                <td><c:out value="${customers.customer_phone}"/></td>
                <td><c:out value="${customers.customer_email}"/></td>
                <td><c:out value="${customers.customer_address}"/></td>
                <td><a href="/customers?action=details&id=${customers.customer_id}">Details</a> </td>
<%--                <td><button class="btn btn-info" data-toggle="modal" data-target="#detailsModal">Details</button> </td>--%>
                <td><a href="/customers?action=edit&id=${customers.customer_id}">Edit</a></td>
                <td><a href="/customers?action=delete&id=${customers.customer_id}">Delete</a></td>
<%--                <td><button class="btn btn-info" data-toggle="modal" data-target="#deleteModal" >Delete</button> </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Are you sure delete ?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Bạn có chắc chắn muốn xoá ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="callServlet(
                   'GET')">Delete</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready( function () {
            $('#table_id').DataTable();
        } );
    </script>
    <script>
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus')
        })
    </script>

<%--    call method get 'delete--%>
    <script>
        function callServlet(methodType) {
            document.getElementById("table_id").actions = "/customers?action=delete";
            document.getElementById("table_id").method = methodType;
            document.getElementById("table_id").submit();
        }
    </script>
</div>
</body>
</html>
