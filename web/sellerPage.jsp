
<%@page import="trongtoan.entity.UserDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html >

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Seller Page</title>

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/stylemenu.css" >
        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style1.css">

    </head>
    <body>
        
         
        <!-- header section starts  -->

        <header>

            <input type="checkbox" name="" id="toggler">
            <label for="toggler" class="fas fa-bars"></label>

            <a href="#" class="logo">Binzi<span>.</span></a>

            <nav class="navbar">
                <a href="MainController?action=orderMain">Today Order</a>
                <a href="#">Hello ${sessionScope.LOGIN_USER.fullName }</a>
                <a href="#review">review</a> 
            </nav>


            <form action="MainController" method="post" class="form-inline my-2 my-lg-0">
                <a class="btn btn-success btn-sm ml-3" href="MainController?action=Logout">
                    Logout
                </a>
            </form>


        </header>
        </br></br>  </br></br> </br></br> 


        <!-- header section ends -->

        <!-- home section starts  -->

        <section class="home" id="home">
            </br></br>  </br></br> </br></br> 
            <div class="content">
                <h3>fresh milktea</h3>
                <span> Its time for Tea! </span>
                <p>___The Binzi create the amazing stories of your lives.
                    Replay your good memories now!___</p>
               
            </div>

        </section>

        <!-- home section ends -->

        <!-- about section starts  -->

        <!-- about section ends -->

        <!-- icons section starts  -->

        <section class="icons-container">
            </br></br>  </br></br> </br></br> 
            <div class="icons">
                <img src="images/icon-1.png" alt="">
                <div class="info">
                    <h3>free delivery</h3>
                    <span>on all orders</span>
                </div>
            </div>

            <div class="icons">
                <img src="images/icon-2.png" alt="">
                <div class="info">
                    <h3>10 days returns</h3>
                    <span>moneyback guarantee</span>
                </div>
            </div>

            <div class="icons">
                <img src="images/icon-3.png" alt="">
                <div class="info">
                    <h3>offer & gifts</h3>
                    <span>on all orders</span>
                </div>
            </div>

            <div class="icons">
                <img src="images/icon-4.png" alt="">
                <div class="info">
                    <h3>secure paymens</h3>
                    <span>protected by paypal</span>
                </div>
            </div>

        </section>

        <!-- icons section ends -->

        <!-- prodcuts section starts  -->



        <!-- prodcuts section ends -->

        <!-- review section starts  -->

        <section class="review" id="review">
            </br></br>  </br></br> </br></br> 
            <h1 class="heading"><span> customer's review</span> </h1>

            <div class="box-container">

                <div class="box">
                    <div class="stars">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti asperiores laboriosam praesentium enim maiores? Ad repellat voluptates alias facere repudiandae dolor accusamus enim ut odit, aliquam nesciunt eaque nulla dignissimos.</p>
                    <div class="user">
                        <img src="images/pic-1.png" alt="">
                        <div class="user-info">
                            <h3>john deo</h3>
                            <span>happy customer</span>
                        </div>
                    </div>
                    <span class="fas fa-quote-right"></span>
                </div>

                <div class="box">
                    <div class="stars">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti asperiores laboriosam praesentium enim maiores? Ad repellat voluptates alias facere repudiandae dolor accusamus enim ut odit, aliquam nesciunt eaque nulla dignissimos.</p>
                    <div class="user">
                        <img src="images/pic-2.png" alt="">
                        <div class="user-info">
                            <h3>john deo</h3>
                            <span>happy customer</span>
                        </div>
                    </div>
                    <span class="fas fa-quote-right"></span>
                </div>

                <div class="box">
                    <div class="stars">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti asperiores laboriosam praesentium enim maiores? Ad repellat voluptates alias facere repudiandae dolor accusamus enim ut odit, aliquam nesciunt eaque nulla dignissimos.</p>
                    <div class="user">
                        <img src="images/pic-3.png" alt="">
                        <div class="user-info">
                            <h3>john deo</h3>
                            <span>happy customer</span>
                        </div>
                    </div>
                    <span class="fas fa-quote-right"></span>
                </div>

            </div>

        </section>

        <!-- review section ends -->

        <!-- contact section starts  -->



        <!-- contact section ends -->

        <!-- footer section starts  -->

        <jsp:include page="footer.jsp" ></jsp:include>


            <!-- footer section ends -->
            <script>
                let navbar = document.querySelector('.navbar');

                document.querySelector('#menu-bar').onclick = () => {
                    navbar.classList.toggle('active');
                };

                document.querySelector('#close').onclick = () => {
                    navbar.classList.remove('active');
                };

                window.onscroll = () => {

                    navbar.classList.remove('active');

                    if (window.scrollY > 100) {
                        document.querySelector('header').classList.add('active');
                    } else {
                        document.querySelector('header').classList.remove('active');
                    }

                };

                let themeToggler = document.querySelector('#theme-toggler');

                themeToggler.onclick = () => {
                    themeToggler.classList.toggle('fa-sun');
                    if (themeToggler.classList.contains('fa-sun')) {
                        document.querySelector('body').classList.add('active');
                    } else {
                        document.querySelector('body').classList.remove('active');
                    }
                    ;
                };

                document.querySelectorAll('.small-image-1').forEach(images => {
                    images.onclick = () => {
                        document.querySelector('.big-image-1').src = images.getAttribute('src');
                    };
                });

                document.querySelectorAll('.small-image-2').forEach(images => {
                    images.onclick = () => {
                        document.querySelector('.big-image-2').src = images.getAttribute('src');
                    };
                });

                document.querySelectorAll('.small-image-3').forEach(images => {
                    images.onclick = () => {
                        document.querySelector('.big-image-3').src = images.getAttribute('src');
                    };
                });

                let countDate = new Date('aug 1, 2021 00:00:00').getTime();

                function countDown() {

                    let now = new Date().getTime();
                    gap = countDate - now;

                    let seconds = 1000;
                    let minutes = seconds * 60;
                    let hours = minutes * 60;
                    let days = hours * 24;

                    let d = Math.floor(gap / (days));
                    let h = Math.floor((gap % (days)) / (hours));
                    let m = Math.floor((gap % (hours)) / (minutes));
                    let s = Math.floor((gap % (minutes)) / (seconds));

                    document.getElementById('days').innerText = d;
                    document.getElementById('hours').innerText = h;
                    document.getElementById('minutes').innerText = m;
                    document.getElementById('seconds').innerText = s;

                }

                setInterval(function () {
                countDown()
                }, 1000;

                var swiper = new Swiper(".product-slider", {
                slidesPerView: 3,
                        loop: true,
                        spaceBetween: 10,
                        autoplay: {
                        delay: 4000,
                                disableOnInteraction: false,
                        },
                        navigation: {
                        nextEl: ".swiper-button-next"
                                prevEl: ".swiper-button-prev"
                        },
                        breakpoints: {
                        0: {
                        slidesPerView: 1
                        },
                                550: {
                                slidesPerView: 2
                                },
                                800: {
                                slidesPerView: 3
                                },
                                1000: {
                                slidesPerView: 3,
                                }
                        });

                var swiper = new Swiper(".review-slider", {
                    slidesPerView: 3,
                    loop: true,
                    spaceBetween: 10,
                    autoplay: {
                        delay: 4000,
                        disableOnInteraction: false
                    },
                    breakpoints: {
                        0: {
                            slidesPerView: 1
                        },
                        550: {
                            slidesPerView: 2
                        },
                        800: {
                            slidesPerView: 3
                        },
                        1000: {
                            slidesPerView: 3
                        }
                    }
                });
            </script>

















    </body>
</html>
