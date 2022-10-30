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
        <title>Account Updating</title>
        <link rel="stylesheet" href="css/index.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/stylemenu.css" >
        <link rel="stylesheet" href="css/style1.css">
    </head>

    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD' }" >
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
       <c:if test="${sessionScope.listA == null}" >
        <div class="table_section">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>UserID</th>
                        <th>Password</th>
                        <th>FullName</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <h3> Tài Khoản Hiện Tại Đang Trống </h3>
            </table>
        </div>
        </c:if>
        <c:if test="${sessionScope.listA != null}" >
        <div class="table">
            <div class="table_header">
                <p>Order Details</p>
                <nav class="navbar">
                    <a href="MainController?action=AdminHome"><i class="fa-solid fa-house"></i>HOME</a>
                </nav>
               <form action="MainController" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${txtSearch}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search By Name...">
                            <div class="input-group-append">
                                <button type="submit" name="action" value="SearchAccount" class="btn btn-secondary btn-number">
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
                            <th>ID</th>
                            <th>UserID</th>
                            <th>Password</th>
                            <th>FullName</th>
                            <th>Role</th>
                        </tr>
                    <h3 style="color: red  " > ${requestScope.ERROR_SEARCH} </h3>   
                    </thead>
                    <tbody>
                        <c:forEach var="user" varStatus="counter" items="${sessionScope.listA}">
                    <form action="MainController"> 
                        <tr>
                            <td >
                                <input type="text" name="rid" value=" ${user.rID} " readonly="" />
                            </td> 
                            <td>
                                <input type="text" name="id" value="${user.userID}" />
                            </td> 
                            <td>
                                <input type="text" name="name" value="${user.password}" />

                            </td>
                            <td>
                                <input type="text" name="fullName" value= "${user.fullName}" />

                            </td> 
                            <td>
                                <input type="text" name="role" value="${user.roleID} " />

                            
                            <td>

                                <button style="background-color: rgb(103, 103, 241)" name="action" value="updateAccount"><i class="fa-solid fa-pen-to-square" ></i></button> 
                            </td> 
                            <td>

                                <a href="MainController?id=${user.rID}&action=deleteAccount">Delete</a>  
                            </td> 
                    </form>
                            </c:forEach>



                    </tr>
 
                    </tbody>
                </table>
            </div>

        </div>
         </c:if>                   
        <a href="createAccount.jsp" class="btn btn-outline-primary">Create New Account</a>

    </body>

</html>