<%-- 
    Document   : login
    Created on : Jun 9, 2022, 12:36:10 PM
    Author     : DELL
--%>

<%@page import="trongtoan.entity.UserError"%>
<%@page import="trongtoan.entity.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login Web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
       
        
        <div class="limiter">

            <div class="container-login100">
                <div class="wrap-login100">

                    <span class="login100-form-title p-b-26">
                        New Product
                    </span>
                    <span class="login100-form-title p-b-48">
                        <i class="zmdi zmdi-font"></i>
                    </span>

                    <form action="MainController" method="Post" class="login100-form validate-form">
                        Name:
                        <div class="wrap-input100 validate-input" >
                            <input  type="text" name="name">                          
                        </div>
                        <h3 style="color: red" >${sessionScope.PRODUCT_ERROR.userIDError}</h3>    </br> </br> 
                        Image:
                        <div class="wrap-input100 validate-input" >
                            <input  type="text" name="image" >                            
                        </div>
                        Price:
                        <div class="wrap-input100 validate-input" >
                            <input  type="text" name="price" >                            
                        </div>
                        
                        <h3 style="color: red" >${sessionScope.PRODUCT_ERROR.roldeIDError}</h3>    </br> </br> 
                        Title:
                        <div class="wrap-input100 validate-input" >
                            <input  type="text" name="title" >                           
                        </div>
                        <h3 style="color: red" >${sessionScope.PRODUCT_ERROR.fullNameError}</h3>    </br> </br> 
                        Description:
                        <div class="wrap-input100 validate-input" >
                            <input  type="text" name="description" >                            
                        </div> 
                        CateID: 
                        <div class="wrap-input100 validate-input" >
                            <select name="cateID" >
                                <option value="1">Baby Shirt</option>
                                <option value="2">Baby Shorts</option>
                                <option value="3">Baby Balo</option>
                                <option value="4">Baby Shoes</option> 
                                
                            </select>
                        </div>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn" type="submit" name="action" value="createProduct">
                                    CREATE
                                </button>

                            </div>
                        </div>
                    </form>                              

                </div>
            </div>
        </div>



        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
    </body>
</html>
