<%-- 
    Document   : checkOut
    Created on : Jun 21, 2022, 9:48:20 PM
    Author     : DELL
--%>

<%@page import="trongtoan.entity.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/styleCheckOut.css">

    </head>

    <body>
        
        <div class="container">

            <form action="MainController">

                <div class="row">

                    <div class="col">

                        <h3 class="title">billing address</h3>

                        <div class="inputBox">
                            <span>Total Price :</span>
                            <input type="text" value="${param.total}"  readonly="" >  
                        </div>

                        <div class="inputBox">
                            <span>full name :</span>
                            <input type="text" name="fullNameEmail" placeholder="The Binzi." required="" >
                        </div>
                        <div class="inputBox">
                            <span>email :</span>
                            <input type="email" name="email" placeholder="example@gmail.com" required="" >
                        </div>
                        <div class="inputBox">
                            <span>address :</span>
                            <input type="text" name="address" placeholder="room - street - locality" required="" >
                        </div>
                        <div class="inputBox">
                            <span>city :</span>
                            <input type="text" name="city" placeholder="Tp HCM" required="">
                        </div>

                        <div class="flex">
                            <div class="inputBox">
                                <span>country :</span>
                                <input type="text" placeholder="VietNam" required="" > 
                            </div>
                            <div class="inputBox">
                                <span>Discount code :</span>
                                <input type="text" placeholder="GiamGia10%">
                            </div>
                        </div>

                    </div>

                    <div class="col">

                        <h3 class="title">payment</h3>

                        <div class="inputBox">
                            <span>cards accepted :</span>
                            <img src="images/card_img.png" alt="">
                        </div>
                        <div class="inputBox">
                            <span>name on card :</span>
                            <input type="text" placeholder="The Binzi.">
                        </div>
                        <div class="inputBox">
                            <span>credit card number :</span>
                            <input type="number" placeholder="1111-2222-3333-4444">
                        </div>
                        <div class="inputBox">
                            <span>exp month :</span>
                            <input type="text" placeholder="january">
                        </div>

                        <div class="flex">
                            <div class="inputBox">
                                <span>exp year :</span>
                                <input type="number" placeholder="2022">
                            </div>
                            <div class="inputBox">
                                <span>CVV :</span>
                                <input type="text" placeholder="1234">
                            </div>
                        </div>

                    </div>

                </div>

                <input type="submit" name="action" value="proceed to checkout" class="submit-btn"> 
                <input type="hidden" name="total" value="${param.total}" >  



            </form>

        </div>
    </body>

</html>