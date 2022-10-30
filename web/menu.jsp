
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>

    <input type="checkbox" name="" id="toggler">
    <label for="toggler" class="fas fa-bars"></label>

    <a href="#" class="logo">Binzi<span>.</span></a>

    <nav class="navbar">
        <a href="#home">home</a>
        <a href="#about">about</a>
        <a href="#products">products</a>
        <a href="#review">review</a>
    </nav>

    
    <form action="MainController" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${txtSearch}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" name="action" value="Search" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div> 
                        <a class="btn btn-success btn-sm ml-3" href="viewCart.jsp">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${sessionScope.CART.getCart().size()}</span> 
                        </a>
                            <a class="btn btn-success btn-sm ml-3" href="MainController?action=Logout">
                                Logout
                        </a>
                    </form>
                            

</header>