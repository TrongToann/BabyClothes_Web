<%-- 
    Document   : login
    Created on : Jun 9, 2022, 12:36:10 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login Web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/stylemenu.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
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
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id" content="262750476681-rpefl1gbl7hvucqa9rebfmcoo90135ue.apps.googleusercontent.com">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
    </head>
    <body>

        <div class="limiter">

            <div class="container-login100">
                <div class="wrap-login100">

                    <span class="login100-form-title p-b-26">
                        Welcome
                    </span>
                    <span class="login100-form-title p-b-48">
                        <i class="zmdi zmdi-font"></i>
                    </span>

                    <form action="MainController" method="Post" class="login100-form validate-form" id="form1"> 
                        UserID:
                        <div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
                            <input  type="text" name="userID" >
                            <span  data-placeholder="Email"></span>
                        </div>
                        Password:
                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <span class="btn-show-pass">
                                <i class="zmdi zmdi-eye"></i>
                            </span>
                            <input  type="password" name="password">
                            <span data-placeholder="Password"></span>
                        </div>
                        
                        <div class="g-recaptcha" data-sitekey="6LcWwY4gAAAAANa36ZF8_UGSQGj1lcBj-jBzfUc1"></div>
                                <div id="error123"> </div>
                                
                                <h5> ${sessionScope.ERROR} </h5>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                
                                <button class="login100-form-btn" type="submit" >
                                    Login
                                </button>
                                <input  type="hidden" name="action" value="Login">
                                    
                                

                            </div>
                        </div>
                    </form>                              

                    <div class="text-center p-t-115">

                        <span class="txt1">
                            Login With Social Account
                        </span> 
                        </br>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8084/Tester/LoginGoogleController&response_type=code
                           &client_id=262750476681-rpefl1gbl7hvucqa9rebfmcoo90135ue.apps.googleusercontent.com&approval_prompt=force">
                            <i class="fa-brands fa-google"></i>

                        </a>
                        </br></br></br>
                        <span class="txt1">
                            Don’t have an account?
                        </span>

                        <a class="txt2" href="createAccountUser.jsp">
                            Sign Up
                        </a>
                        

                    </div>

                    <!--                    <div class="g-signin2" data-theme="dark">
                                            
                                        </div>-->

                </div>
            </div>
        </div>





            <script src="https://www.google.com/recaptcha/api.js" async defer></script>
            <script>
                window.onload = function(){
                    let isValid = false ; 
                    const form = document.getElementById("form1") ;
                    const error = document.getElementById("error123") ;
                    
                    form.addEventListener("submit",function(event){
                        event.preventDefault() ;
                        const response = grecaptcha.getResponse() ;
                        if(response) {
                            form.submit() ; 
                        } else {
                            error.innerHTML = "Check This Please! " ;
                        }
                    });
                } ;
            </script>
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
