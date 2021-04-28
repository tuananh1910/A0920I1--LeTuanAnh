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
    <title>Edit Employee</title>
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
<div align="center">
    <h1>Edit Employee</h1>
    <p>
        <a href="http://localhost:8080">Home</a> <br>
        <a href="/employees?action=employees">List All Employee</a>
    </p>
    <p>
        <c:if test="${requestScope['message']!= null}}">
            <span>${requestScope['message']}</span>
        </c:if>
    </p>
    <form method="post">
        <table>h c
            <c:if test="${employee!=null}">
                <input type="hidden" name="employee_id" value="<c:out value='${employee.employee_id}'/>">
            </c:if>

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
                <td>
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Position ID</label>
                    </div>
                </td>
                <td>
                    <select class="custom-select" id="inputGroupSelect01" name="position_id">
                        <option selected><c:out value="position.position_name"/></option>
                        <option value="1">Le Tan</option>
                        <option value="2">Phuc Vu</option>
                        <option value="3">Chuyen Vien</option>
                        <option value="4">Giam Sat</option>
                        <option value="5">Quan Li</option>
                        <option value="6">Giam Doc</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect02">Education Degree ID</label>
                    </div>
                </td>
                <td>
                    <select class="custom-select" id="inputGroupSelect02" name="education_degree_id">
                        <option selected><c:out value="education_degree.education_degree_name"></c:out></option>
                        <option value="1">Trung Cap</option>
                        <option value="2">Cao Dang</option>
                        <option value="3">Dai Hoc</option>
                        <option value="4">Sau Dai Hoc</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect03">Division ID</label>
                    </div>
                </td>
                <td>
                    <select class="custom-select" id="inputGroupSelect03" name="division_id">
                        <option selected><c:out value="division.division_name"></c:out></option>
                        <option value="1">Sale-Marketing</option>
                        <option value="2">Hanh Chinh</option>
                        <option value="3">Phuc Vu</option>
                        <option value="4">Quan Li</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Username :</td>
                <td>
                    <input type="text" value="<c:out value="${employee.username}"/>" readonly>
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
