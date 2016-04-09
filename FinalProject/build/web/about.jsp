<%-- 
    Document   : about
    Created on : Dec 17, 2015, 12:38:00 AM
    Author     : viniciuscustodio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <title>About Us</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <link rel="stylesheet" type="text/css" href="styles/style.css" />
    </head>
    <body>
        <div id="wrap">
            <div class="header">
                <div class="logo"></div>
                <div id="menu">
                    <ul>
                        <li><a href="ProductServlet?action=sale">Home</a></li> 
                        <li><a href="ProductServlet?action=products">Products</a></li>
                        <li><a href="ProductServlet?action=cart">Cart</a></li>
                        <li><a href="register.jsp">Register</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        <li class="selected"><a href="about.jsp">About us</a></li>
                        <li><a href="contact.jsp">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="center_content">
                <div class="left_content">
                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" /></span>About us</div>
                    <div class="feat_prod_box_details">
                        <p class="details">  This website is an e-commerce website for pottery n art pieces. </p>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="right_content">
                    <div class="cart">
                        <div hidden>${cart}</div>
                        <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" /></span> My cart</div>
                        <div class="home_cart_content"> ${cartSize} x items | <span class="red">SUBTOTAL: ${cartTotal}</span> </div>
                        <a href="ProductServlet?action=cart" class="view_cart">view cart</a> 
                    </div>

                </div>
                <!--end of right content-->
                <div class="clear"></div>

                <div class="footer"><a href="http://csscreme.com"><img src="" alt="" border="0" /></a></div>
            </div>
        </div>
    </body>
</html>
