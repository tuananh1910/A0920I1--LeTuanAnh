<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 3/24/2021
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <style type="text/css">
      .login {
          height:180px; width:230px;
          margin:0;
          padding:10px;
          border:1px #CCC solid;
      }
      .login input {
          padding:5px; margin:5px
      }
  </style>
  <body>
  <form method="post" action="${pageContext.request.contextPath}/dang-nhap">
      <div class="login">
          <h2>Login</h2>
          <input type="text" name="username" size="30"  placeholder="username" />
          <input type="password" name="password" size="30" placeholder="password" />
          <input type="submit" value="Sign in"/>
      </div>
  </form>
  <h2>Currency Converter</h2>
  <form method="post" action="${pageContext.request.contextPath}/chuyen-doi">
      <label>Rate: </label><br/>
      <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
      <label>USD: </label><br/>
      <input type="text" name="usd" placeholder="USD" value="0"/><br/>
      <input type = "submit" id = "submit" value = "Converter"/>
  </form>
  <h2>Vietnamese Dictionary</h2>
  <form method="post" action="${pageContext.request.contextPath}/translation">
      <input type="text" name="txtSearch" placeholder="Enter your word: "/>
      <input type = "submit" id = "submit_dictionary" value = "Search"/>
  </form>

  <h2>Product Discount Calculator</h2>
  <form method="post" action="${pageContext.request.contextPath}/discount-calculator">
      <input type="text" name="description" placeholder="Productiton description"/>
      <input type="text" name="list_price" placeholder="List Price"/>
      <input type="text" name="discount_percent" placeholder="Discount Percent"/>
      <input type="submit" value="Submit">
  </form>

  <form method="get" action="${pageContext.request.contextPath}/calculator">
      <h3>Calculator</h3>
      <input type="text" name="first number"/>
      <select name="operator">
          <option value="+">Addition</option>
          <option value="-">Subtract</option>
          <option value="*">Multiply</option>
          <option value="/">divide</option>
      </select>
      <input type="text" name="second number">
      <input type="submit" value="Submit">
  </form>
  </body>
</html>
