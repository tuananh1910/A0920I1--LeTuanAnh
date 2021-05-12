<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 5/3/2021
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Product</title>
</head>
<body>
<form method="post">
<fieldset>
    <legend>
        Fill Information Product
    </legend>
    <div class="form" style="width: 50%">
    <table>


        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="product_name">Name : </label>
            </div>
            <input type="text" class="form-control" id="product_name" name="product_name">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="product_price">Price : </label>
            </div>
            <input type="text" class="form-control" id="product_price" name="product_price">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Discount :  </label>
            </div>
            <select class="custom-select" id="inputGroupSelect01" name="product_discount">
                <option selected>Choose...</option>
                <option value="5">5%</option>
                <option value="10">10%</option>
                <option value="30">30%</option>
                <option value="50">50%</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

    </table>
    </div>
</fieldset>
</form>
</body>
</html>
