<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 3/28/2021
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<div align="center">
    <h1>Delete User</h1>
    <p>
        <a href="/users?action=users">List All User</a>
    </p>
    <form method="post">
        <fieldset>
            <p>
                <c:if test="${requestScope['message']!= null}}">
                    <span>${requestScope['message']}</span>
                </c:if>
            </p>
            <table border="1" cellpadding="5">
                <c:if test="${user!=null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
                </c:if>
                <tr>
                    <td>User Name :</td>
                    <td>
                        <c:out value="${user.name}"/>
                    </td>
                </tr>
                <tr>
                    <td>User Email :</td>
                    <td>
                        <c:out value="${user.email}"/>
                    </td>
                </tr>
                <tr>
                    <td>User Country :</td>
                    <td>
                        <c:out value="${user.country}"/>
                    </td>
                </tr>
                <tr>
                    <input type="submit" value="Delete"/>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
