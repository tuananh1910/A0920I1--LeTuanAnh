<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/24/2021
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crreate Contract Details</title>
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
<p>
    <a href="http://localhost:8080"> Home </a> <br>
    <a href="/employees?action=contracts">List All Contracts</a>
</p>
<p>
<p>
    <c:if test="${requestScope['message']!= null}}">
        <span>${requestScope['message']}</span>
    </c:if>
</p>
</p>
<form method="post">
    <fieldset>
        <legend>Fill in contract details</legend>

        <input type="hidden" name="contract_id" value="<c:out value='${id}'/>">


        <div class="form" style="width: 50%">


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Attach Service </label>
                </div>
                <select class="custom-select" id="inputGroupSelect01" name="attach_serivce_id">
                    <option selected>Choose...</option>
                    <option value="1">Massage - 100$/10</option>
                    <option value="2">Karaoke - 200$/20</option>
                    <option value="3">Food and Drink - 300$/30</option>
                    <option value="4">Rent Vehicle - 400$/40</option>
                </select>
            </div>


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect02">Quality </label>
                </div>
                <select class="custom-select" id="inputGroupSelect02" name="quality">
                    <option selected>Choose...</option>
                    <option value="1">*</option>
                    <option value="2">**</option>
                    <option value="3">***</option>
                    <option value="4">****</option>
                    <option value="5">*****</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </fieldset>
</form>
</body>
</html>
