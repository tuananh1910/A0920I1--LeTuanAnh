<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 5/3/2021
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>


</head>
<body style="background: gray">
<div align="center" >
    <h1>List User</h1>
    <p>
        <a href="http://localhost:8080" class="badge badge-light">Home</a> <br>
        <a href="/products?action=create" class="badge badge-light">Add New Product</a>
    </p>
        <p>
            <c:if test="${requestScope['message']!= null}}">
                <span>${requestScope['message']}</span>
            </c:if>
        </p>
    <table  id="table_id" class="display">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Discount</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="products" items="${products}">
            <tr>
                <td scope="row"><c:out value="${products.manager_product_id}"/></td>
                <td><c:out value="${products.product_name}"/></td>
                <td><c:out value="${products.product_price}"/></td>
                <td><c:out value="${products.product_discount}"/></td>
                <td><a href="/products?action=edit&id=${products.manager_product_id}">Edit</a></td>
                <td><a href="/products?action=delete&id=${products.manager_product_id}">Delete</a></td>
                    <%--                <td><button class="btn btn-info" data-toggle="modal" data-target="#deleteModal" >Delete</button> </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
