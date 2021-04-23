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
    <title>Title</title>
</head>
<body>
<h1> Delete Customer </h1>
<p>
    <a href="http://localhost:8080"> Home </a> <br>
    <a href="/employees?action=employees">List All Employee</a>
</p>
<p>
    <c:if test="${requestScope['message']!= null}}">
        <span>${requestScope['message']}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>Delete Employee</legend>
        <h2> Information Of Employee </h2>

        <table>
            <tr>
                <td>Employee ID :</td>
                <td>
                    <input type="text" name="employee_id" value="<c:out value='${employee.employee_id}'/>">
                </td>
            </tr>


            <tr>
                <td>Employee Name :</td>
                <td>
                    <input type="text" name="employee_name" value="<c:out value="${employee.employee_name}"/>">
                </td>
            </tr>
            <tr>
                <td>Employee Birthday :</td>
                <td>
                    <input type="text" name="employee_birthday" value="<c:out value="${employee.employee_birthday}"/>">
                </td>
            </tr>
            <tr>
                <td>Employee ID Card :</td>
                <td>
                    <input type="text" name="employee_id_card" value="<c:out value="${employee.employee_id_card}"/>">
                </td>
            </tr>
            <tr>
                <td>Employee Salary :</td>
                <td>
                    <input type="text" name="employee_salary" value="<c:out value="${employee.employee_salary}"/>">
                </td>
            </tr>
            <tr>
                <td>Employee Phone :</td>
                <td>
                    <input type="text" name="employee_phone" value="<c:out value="${employee.employee_phone}"/>">
                </td>
            </tr>
            <tr>
                <td>Employee Email :</td>
                <td>
                    <input type="text" name="employee_email" value="<c:out value="${employee.employee_email}"/>">
                </td>
            </tr>
            <tr>
                <td>Employee Address :</td>
                <td>
                    <input type="text" name="employee_address" value="<c:out value="${employee.employee_address}"/>">
                </td>
            </tr>

            <tr>
                <td>Position :</td>
                <td>
                    <input type="text" name="position_id" value="<c:out value="${position.position_name}"/>">
                </td>
            </tr>
            <tr>
                <td>Education Degree :</td>
                <td>
                    <input type="text" name="education_degree_id" value="<c:out value="${education_degree.education_degree_name}"/>">
                </td>
            </tr>
            <tr>
                <td> Division :</td>
                <td>
                    <input type="text" name="division_id" value="<c:out value="${division.division_name}"/>">
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
