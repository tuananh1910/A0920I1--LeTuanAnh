<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 3/25/2021
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Customer</title>
  </head>
  <body>
  <form method="get" action="${pageContext.request.contextPath}/customer">

    <label> Text
      <input type="text" name="action"/>
    </label>
    <input type="submit">
  </form>
  </body>
</html>
