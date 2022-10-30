<%-- 
    Document   : tesst
    Created on : Jun 10, 2022, 4:42:18 PM
    Author     : DELL
--%>

<%@page import="trongtoan.entity.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="trongtoan.entity.Product"%>
<%@page import="trongtoan.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Table Of Product</title>
        <link rel="stylesheet" href="css/index.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/stylemenu.css" >
    </head>

    <body>
        
        <c:if test="${sessionScope.CART == null}"> 
            <div class="table_section">
                <table>
                    <thead>
                        <tr>
                            <th>S No.</th>
                            <th>P.No</th>
                            <th>Name Product</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <h3> Giỏ Hàng Của Bạn Đang Trống </h3>
                </table>
                <a href="HomeController"  class="btn btn-lg btn-primary text-uppercase"> Continue Shopping </a>  
            </div>
        </c:if>
        <c:if test="${sessionScope.CART != null && sessionScope.CART.getCart().size() > 0}">
            <div class="table">
                <div class="table_header">
                    <p>Order Details</p>
                    <nav class="navbar">
                        <a href="HomeController"><i class="fa-solid fa-house"></i></a>
                    </nav>
                    <div> <input placeholder="search..." /> <button class="add_new">Search</button> </div>
                </div>
                <div class="table_section">
                    <table>
                        <thead>
                            <tr>
                                <th>S No.</th>
                                <th>P.No</th>
                                <th>Name Product</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="bibo" varStatus="counter" items="${sessionScope.CART.getCart().values()}">
                                <c:set var="total" value="${total + (bibo.price * bibo.quantity)}" />  
                            <form action="MainController"> 
                                <tr>
                                    <td>
                                        <input type="text" name="" value="${counter.count}" readonly="" />
                                    </td> 
                                    <td>
                                        <img src= ${bibo.image} readonly=""/> 
                                    </td> 
                                    <td>
                                        <input type="text" name="name" value="${bibo.name}" readonly="" />
                                    </td>
                                    <td>
                                        <input type="text" name="quantity" value="${bibo.quantity}"
                                    </td>
                                    <td>
                                        <input type="text" name="price" value="${bibo.price}" readonly="" />
                                    </td> 
                                    <td>
                                        ${bibo.quantity * bibo.price}
                                    </td>
                                    <td>
                                        <button name="action" value="updateCart"><i class="fa-solid fa-pen-to-square" ></i></button> 
                                        <input type="hidden" name="id" value="${bibo.id}" />
                                    </td> 
                                    <td>                             
                                        <a href="MainController?id=${bibo.id}&action=deleteCart">Delete</a> 
                                    </td> 
                            </form>
                        </c:forEach>

                        </tbody>
                    </table>
                    <h3> Total:${total} </h3>  
                </div> 

                <h5 style="color: red  " > ${requestScope.ERROR_QUANTITY} </h5>          
                <a href="MainController?action=CheckOut&total=${total}"  class="btn btn-lg btn-primary text-uppercase"> Check Out </a>        
                <a href="HomeController"  class="btn btn-lg btn-primary text-uppercase"> Continue Shopping </a>   
                <div class="pagination">
                    <div><i class="fa-brands fa-facebook"></i></div>
                    <div><i class="fa-brands fa-instagram"></i></div>
                    <div><i class="fa-solid fa-cart-shopping"></i></div>
                </div>
            </div>

        </c:if>
    </body>

</html>