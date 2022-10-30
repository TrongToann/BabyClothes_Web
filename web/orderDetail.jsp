<%-- 
    Document   : updateOrder
    Created on : Jun 13, 2022, 2:28:50 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="trongtoan.entity.UserDTO"%>
<%@page import="trongtoan.entity.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="trongtoan.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Updating</title>
        <link rel="stylesheet" href="css/index.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/stylemenu.css" >
        <link rel="stylesheet" href="css/style1.css">
    </head>

    <body>
        
        <h4 > ${requestScope.ERROR}</h4>

        <c:if test="${sessionScope.listOrderDetail==null}">
            <div class="table_section">
                <table>
                    <thead>
                        <tr class="col d-flex justify-content-center">
                            <th class="col d-flex justify-content-center">S No.</th>
                            <th class="col d-flex justify-content-center">Detail ID</th>
                            <th class="col d-flex justify-content-center">Order ID</th>
                            <th class="col d-flex justify-content-center">Product ID</th>
                            <th class="col d-flex justify-content-center">Price</th>
                            <th class="col d-flex justify-content-center">Quantity</th>
                        </tr>
                    </thead>
                    <h3> Đơn Hàng Hiện Tại Đang Trống </h3>
                </table>
            </div>
        </c:if>
        <c:if test="${sessionScope.listOrderDetail!=null}">  
            <div class="table">
                <div class="table_header">
                    <p>Order Details</p>
                    <nav class="navbar">
                        <a href="MainController?action=orderMain"><i class="fa-solid fa-house"></i>RETURN</a>
                    </nav>

                </div>
                <div class="table_section">
                    <table>
                        <thead>
                            <tr >
                                <th>S No.</th>
                                <th>Detail ID</th>
                                <th>Order ID</th>
                                <th>Product ID</th>
                                <th>Price</th>
                                <th>Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="order" varStatus="counter" items="${sessionScope.listOrderDetail}">  
                                <c:if test="${param.orderID == order.orderID}" >
                                <form action="MainController"> 
                                    <tr>
                                        <td>${counter.count}</td> 
                                        <td >
                                            <input type="text" name="id" value="${order.detailID}" readonly=""/>
                                        </td> 
                                        <td>
                                            <input type="text" name="rid" value=" ${order.orderID}" readonly=""/>
                                        </td> 
                                        <td>
                                            <c:forEach var="user" varStatus="counter" items="${sessionScope.listP}">
                                                <c:if test="${user.id == order.productID}" > 
                                                    <img src= ${user.image} readonly=""/>  
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <input type="text" name="rid" value="${order.price}" readonly=""/>
                                        </td> 
                                        <td>
                                            <input type="text" name="total" value="${order.quantity} " />

                                        </td>
                                    </c:if> 
                            </form>
                        </c:forEach>             


                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </c:if>          


    </body>

</html>