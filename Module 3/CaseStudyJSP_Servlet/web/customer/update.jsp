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
    <title>Edit Customer</title>
</head>
<body>
<div align="center">
    <h1>Edit Customer</h1>
    <p>
        <a href="http://localhost:8080">Home</a> <br>
        <a href="/customers?action=customers">List All Customer</a>
    </p>
    <form method="post">
        <table>
            <p>
                <c:if test="${requestScope['message']!=null}">
                    <span>${requestScope['message']}</span>
                </c:if>
            </p>
            <c:if test="${customer!=null}">
                <input type="hidden" name="customer_id" value="<c:out value='${customer.customer_id}'/>">
            </c:if>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Customer Type</label>
                    </div>
                </td>
                <td>
                    <select class="custom-select" id="inputGroupSelect01" name="customer_type">
                        <option selected>Choose...</option>
                        <option value="Member">Member</option>
                        <option value="Silver">Silver</option>
                        <option value="Gold">Gold</option>
                        <option value="Platinum">Platinum</option>
                        <option value="Diamond">Diamond</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Customer Name :</td>
                <td>
                    <input type="text" name="customer_name" value="<c:out value="${customer.customer_name}"/>">
                </td>
            </tr>
            <tr>
                <td>Customer Birthday :</td>
                <td>
                    <input type="text" name="customer_birthday" value="<c:out value="${customer.customer_birthday}"/>">
                </td>
            </tr>
            <tr>
                <td>Customer Gender :</td>
                <td>
                    <input type="text" name="customer_gender" value="<c:out value="${customer.customer_gender}"/>">
                </td>
            </tr>
            <tr>
                <td>Customer ID Card :</td>
                <td>
                    <input type="text" name="customer_id_card" value="<c:out value="${customer.customer_id_card}"/>">
                </td>
            </tr>
            <tr>
                <td>Customer Phone :</td>
                <td>
                    <input type="text" name="customer_phone" value="<c:out value="${customer.customer_phone}"/>">
                </td>
            </tr>
            <tr>
                <td>Customer Email :</td>
                <td>
                    <input type="text" name="customer_email" value="<c:out value="${customer.customer_email}"/>">
                </td>
            </tr>
            <tr>
                <td>Customer Address :</td>
                <td>
                    <input type="text" name="customer_address" value="<c:out value="${customer.customer_address}"/>">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
