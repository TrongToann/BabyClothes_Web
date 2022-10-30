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
       
        <h4 > ${requestScope.ERROR} </h4>
        <c:if test="${sessionScope.listOrder == null}">
        <div class="table_section">
            <table>
                <thead>
                    <tr>
                        <th>S No.</th>
                        <th>Order ID</th>
                        <th>Account ID</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <h3> Đơn Hàng Hiện Tại Đang Trống </h3>
            </table>
        </div>
        </c:if>
        <c:if test="${sessionScope.listOrder != null}">
        <div class="table">
            <div class="table_header">
                <p>Order Details</p>
                <nav class="navbar">
                    <a href="MainController?action=orderMainMain"><i class="fa-solid fa-house"></i>RETURN</a>
                </nav>

            </div>
            <div class="table_section">
                <table>
                    <thead>
                        <tr>
                            <th>S No.</th>
                            <th>Order ID</th>
                            <th>Account ID</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" varStatus="counter" items="${sessionScope.listOrder}">
                    <form action="MainController"> 
                        <tr>
                            <td>
                                <input type="text" name="" value="${counter.count}" readonly="" /> 
                            </td> 
                            <td >
                                <input type="text" name="id" value="${order.orderID}" readonly=""/>
                            </td> 
                            <td>
                                <input type="text" name="rid" value="${order.rID}" readonly=""/>
                            </td> 
                            <td>
                                <input type="text" name="total" value="${order.total} "  readonly=""/>

                            </td>
                            <td>
                                <a href="orderDetail.jsp?orderID=${order.orderID}" >OrderDetail</a> 
                            </td> 
                            <td>
                                <button name="action" value="deleteOrder"><i class="fa-solid fa-trash-can" ></i></button>   

                                <input type="hidden" name="orderID" value="${order.orderID}"
                            </td> 
                    </form>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
        </c:if>
    </body>

</html>