<%@page import="trongtoan.entity.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail Of Product</title>

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/stylemenu.css" >
    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/style1.css">
        
        
       
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
      
        <header>

    <input type="checkbox" name="" id="toggler">
    <label for="toggler" class="fas fa-bars"></label>

    <a href="HomeController" class="logo">Binzi<span>.</span></a>

    <nav class="navbar">
        <a href="checkRole">home</a>
        <a href="checkRole">about</a>
        <a href="checkRole">products</a>
        <a href="checkRole">review</a> 
    </nav>

    
    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div> 
                        <a class="btn btn-success btn-sm ml-3" href="viewCart.jsp">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${sessionScope.CART.getCart().size()}</span> 
                        </a>
                    </form>

</header>
        </br>   </br>    </br>    </br>   </br>   </br>   </br>   </br>   </br> 
        <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                            <ul class="list-group category_block">
                            <c:forEach items="${listCC}" var="o">
                                <li class="list-group-item text-white ${tag  == o.cid ? "active":""}"><a href="MainController?action=Category&cid=${o.cid}">${o.cname}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Lastest Product</div>
                        <ul class="list-group ">
                        <div class="card-body">
                            <li class="list-group-item text-white ">
                            <img class="img-responsive" src="${lastProduct.image}" />
                            <h4 class="card-title show_txt"><a href="#" title="View Product">${lastProduct.name}</a></h4>
                            <p class="123">${lastProduct.title}</p>
                            </li>
                            
                        </div>
                        </ul>   
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${detail.image}"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${detail.name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency"></span><span class="num">${detail.price}</span>
                                            </span> 
                                            <!--<span>/per kg</span>--> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Description</dt>
                                            <dd><p>${detail.description} </p></dd>
                                        </dl>
<!--                                        <dl class="param param-feature">
                                            <dt>Model#</dt>
                                            <dd>12345611</dd>
                                        </dl>   item-property-hor .// 
                                        <dl class="param param-feature">
                                            <dt>Color</dt>
                                            <dd>Black and white</dd>
                                        </dl>   item-property-hor .// 
                                        <dl class="param param-feature">
                                            <dt>Delivery</dt>
                                            <dd>Russia, USA, and Europe</dd>
                                        </dl>   item-property-hor .// -->

                                        <hr>
                                        <form action="MainController">
                                            <div class="row">
                                            <div class="col-sm-5">
                                                <dl class="param param-inline">
                                                    <dt>Quantity: </dt>
                                                    <dd>
                                                        <select name="quantity" class="form-control form-control-sm" style="width:70px;">
                                                            <option> 1 </option>
                                                            <option> 2 </option>
                                                            <option> 3 </option>
                                                            <option> 4 </option>
                                                            <option> 5 </option>
                                                        </select>
                                                    </dd>
                                                </dl>  <!-- item-property .// -->
                                            </div> <!-- col.// -->
                                            </br>
                                        
                                      
                                        </div> <!-- row.// -->
                                        <input type="submit" name="action" value="Add To Cart" class="btn btn-lg btn-primary text-uppercase" />
                                        <input type="hidden" name="pid" value="${detail.id}" /> 
                                        <input type="submit" name="action" value="Buy Now" class="btn btn-lg btn-primary text-uppercase" />
                                        </form>
                                        
                                        <hr>
                                        
                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->


                    </div>
                </div>
            </div>
        </div>
                                         <!-- Footer -->
        <jsp:include page="footer.jsp" ></jsp:include>
    </body>
</html>

