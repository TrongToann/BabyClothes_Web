<%-- 
    Document   : createAccount
    Created on : Jun 23, 2022, 2:49:27 PM
    Author     : DELL
--%>

<%@page import="trongtoan.entity.UserDTO"%>
<%@page import="trongtoan.entity.UserError"%>
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
                        New Account
                    </span>
                    <span class="login100-form-title p-b-48">
                        <i class="zmdi zmdi-font"></i>
                    </span>
                    <form action="MainController" method="Post" class="login100-form validate-form">
                        UserID
                        <div class="wrap-input100 validate-input" >
                            <input  type="text" name="userID">   
                        </div>
                        <h3 style="color: red" >${requestScope.USER_ERROR.userIDError}</h3>    </br> </br> 
                        Password
                        <div class="wrap-input100 validate-input" >
                            <input  type="password" name="password" >   
                            
                        </div>
                        <h3 style="color: red"> ${requestScope.USER_ERROR.passwordError} </h3>  </br> </br>
                        Password Confirm 
                        <div class="wrap-input100 validate-input" >
                            <input  type="password" name="confirm" >   
                            
                        </div>
                        <h3 style="color: red">${requestScope.USER_ERROR.confirmError} </h3>  </br> </br>
                        FullName
                        <div class="wrap-input100 validate-input" >
                            <input  type="text" name="fullName" >  
                            
                        </div>
                        <h3 style="color: red">${requestScope.USER_ERROR.fullNameError}</h3>  </br>  </br> 
                        RoleID: 
                        <div class="wrap-input100 validate-input" >
                            <select name="roleID" >
                                <option value="AD">Admin</option>
                                <option value="US">User</option>
                                <option value="SEL">Seller</option>
                                
                            </select>
                        </div>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn" type="submit" name="action" value="createAccount">
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

