<%--
  Created by IntelliJ IDEA.
  User: TY
  Date: 4/10/2021
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/app-ajax.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css.css">
  </head>
  <body style="background: gray">
  <div class="contain">
    <div class="header">
      <img src="logo.png" height="150" width="600">
    </div>
    <div class="nav">
      <nav class="navbar navbar-expand-lg navbar-light bg-light" style="width: 100%">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto" style="margin-left: 100px">
            <li class="nav-item active" style="margin-left: 20px">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>


            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="http://localhost:8080/employees" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Employee
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="http://localhost:8080/employees?action=create">Add New Employee</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="http://localhost:8080/employees?action=employees">List Employee</a>
              </div>
            </li>


            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" id="btn-customer" href="http://localhost:8080/customers" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Customer
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="http://localhost:8080/customers?action=create">Add New Customer</a>

                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="http://localhost:8080/customers?action=customers">List Customer</a>
              </div>
            </li>


            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="http://localhost:8080/services" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Service
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="http://localhost:8080/services?action=create">Add New Service</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="http://localhost:8080/services?action=services">List Service</a>
              </div>
            </li>


            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="http://localhost:8080/contracts" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Contract
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="http://localhost:8080/contracts?action=create">Add New Contract</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="http://localhost:8080/contracts?action=contracts">List Contrat</a>
              </div>
            </li>


          </ul>


          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          </form>
        </div>
      </nav>
    </div>
    <div class="section" style="background: whitesmoke;">
      <ul>
        <li>Item 1</li>
        <li>Item 2</li>
        <li>Item 3</li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>




      </ul>
    </div>
    <div class="main" style="background: aquamarine;" id="content">

    </div>
    <div class="footer" style="font-size: 10px;">

        <div class="splitter"></div>
        <div class="bar">
          <div class="bar-wrap" >

              <a href="#">Home</a>
              <a href="#">License</a>
              <a href="#">Contact Us</a>
              <a href="#">Advertise</a>
              <a href="#">About</a>


            <div class="social">
              <!-- social icons are here -->
            </div>
            <div class="clear"></div>
            <div class="copyright">&copy;  2021 All Rights Reserved</div>
          </div>
        </div>

    </div>
  </div>
  <script  >
    $(document).ready(function () {
      $('#btn-customer').click(function () {
        $.ajax({
          type:'GET',
          url:'customers',
          success :function (result) {
            $('#content').html(result);
          }
        })
      })
    })
  </script>


  </body>
</html>



