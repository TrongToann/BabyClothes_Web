<%-- 
    Document   : tesst
    Created on : Jun 10, 2022, 4:42:18 PM
    Author     : DELL
--%>

<%@page import="trongtoan.entity.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

        <c:if test="${sessionScope.listP == null}">

            <div class="table_section">
                <table>
                    <thead>
                        <tr>
                            <th>S No.</th>
                            <th>P ID</th>
                            <th>P.No</th>
                            <th>Name Product</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                    </thead>

                </table>
            </div>
        </c:if>
        <c:if test="${sessionScope.listP != null}">
            <div class="table">
                <div class="table_header">
                    <p>Order Details</p>
                    <nav class="navbar">
                       <a href="MainController?action=AdminHome"><i class="fa-solid fa-house"></i>HOME</a>
                    </nav>

                    <form action="MainController" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${txtSearch}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search Product Name...">
                            <div class="input-group-append">
                                <button type="submit" name="action" value="SearchUpdateProduct" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div> 
                    </form>
                </div>
                <div class="table_section">
                    <table>
                        <thead>
                            <tr>
                                <th>S No.</th>
                                <th>P ID</th>
                                <th>P.No</th>
                                <th>Name Product</th>
                                <th>Price</th>
                                <th>Title</th>
                                <th>Quantity</th>

                            </tr>
                        <h3 style="color: red  " > ${requestScope.ERROR_SEARCH}</h3>    
                        </thead>
                        <tbody>
                            <c:forEach var="bibo" varStatus="counter" items="${sessionScope.listP}">
                        <form action="MainController"> 
                            <tr>

                                <td>
                                    <input type="text" name="" value="${counter.count}" readonly="" />
                                </td> 
                                <td >
                                    <input type="text" name="id" value="${bibo.id}" readonly=""/>
                                </td> 
                                <td>
                                    <img src= ${bibo.image} readonly=""/> 
                                </td> 
                                <td>
                                    <input type="text" name="name" value=" ${bibo.name} " />
                                </td>
                                <td>
                                    <input type="text" name="price" value="${bibo.price}" />
                                </td> 
                                <td>
                                    <input type="text" name="title" value="${bibo.title}" />
                                </td> 
                                <td>
                                    <input class="description" type="text" name="quantity" value=" ${bibo.quantity}" />
                                </td> 
                                <td>
                                    <button style="background-color: rgb(103, 103, 241)" name="action" value="updateProduct"><i class="fa-solid fa-pen-to-square" ></i></button>   
                                </td> 
                                <td>
                                    <button style="background-color: rgb(103, 103, 241)" name="action" value="deleteProduct"><i class="fa-solid fa-trash-can" ></i></button>            
                                    <input type="hidden" name="id" value="${bibo.id}" />
                                </td> 
                            </tr>
                        </form>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>

            </div>

            <a href="createProduct.jsp" class="btn btn-outline-primary">Create New Product</a>

        </c:if>
    </body>

</html>