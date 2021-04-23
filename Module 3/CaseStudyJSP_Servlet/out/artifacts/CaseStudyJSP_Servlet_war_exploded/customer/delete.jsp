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
    <title>Delete Customer</title>
</head>
<body>
<h1> Delete Customer </h1>
<p>
    <a href="http://localhost:8080"> Home </a> <br>
    <a href="/customers?action=customers">List All Customer</a>
</p>
<p>
    <c:if test="${requestScope['message']!= null}}">
        <span>${requestScope['message']}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>Delete Customer</legend>
        <h2> Information Of Customer </h2>

        <table>
            <tr>
                <td>Customer ID :</td>
                <td>
                    <input type="text" name="customer_id" value="<c:out value='${customer.customer_id}'/>">
                </td>
            </tr>


            <tr>
                <td>Customer Type ID :</td>
                <td>
                    <input type="text" name="customer_type_id" value="<c:out value="${customer.customer_type_id}"/>">
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
                    <input type="submit" value="Delete">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
