<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 5/10/2021
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Email Validate</title>
  </head>
  <body>
  <h1>Email Validate</h1>

  <p style="color:red">${message}</p>

  <form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
  </form>


  <h2>Current Local Times Around the World</h2>
  <span>Current time in ${city}: <strong>${date}</strong></span>
  <form id="locale" action="worldclock" method="get">
    <select name="city" onchange="document.getElementById('locale').submit()">
      <option value="Asia/Ho_Chi_Minh">Select a city</option>
      <option value="Asia/Ho_Chi_Minh" selected>Ho Chi Minh</option>
      <option value="Singapore">Singapore</option>
      <option value="Asia/Hong_Kong">Hong Kong</option>
      <option value="Asia/Tokyo">Tokyo</option>
      <option value="Asia/Seoul">Seoul</option>
      <option value="Europe/London">London</option>
      <option value="Europe/Madrid">Madrid</option>
      <option value="America/New_York">New York</option>
      <option value="Australia/Sydney">Sydney</option>
      <option value="Argentina/Buenos_Aires">Buenos Aires</option>
    </select>
  </form>

  <h1>Sandwich Condiments</h1>
  <span>SandWich with ${condiment}</span>
  <form id="sandwichCondiments" action="sandwich" method="get">
    <select name="condiments" onchange="document.getElementById('sandwichCondiments').submit()">
      <option value="chosse">chosse</option>
      <option value="lettuce">Lettuce</option>
      <option value="tomato">Tomato</option>
      <option value="mustard">Mustard</option>
    </select>
  </form>
  </body>
</html>
