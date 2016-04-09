<%-- 
    Document   : login
    Created on : Dec 16, 2015, 10:06:02 AM
    Author     : viniciuscustodio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
    <head>
        <title>The Pottery Shop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <link rel="stylesheet" type="text/css" href="styles/style.css" />
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div id="wrap">
            <div class="header">

                <div class="logo"><a href=""><img src="" alt="" border="0" /></a></div> <!Ñ //LOGO FOR THE WEBSITE ->
                <div id="menu">
                    <ul>
                        <li><a href="ProductServlet?action=sale">Home</a></li> 
                        <li><a href="ProductServlet?action=products">Products</a></li>
                        <li><a href="ProductServlet?action=cart">Cart</a></li>
                        <li><a href="register.jsp">Register</a></li>
                        <li class="selected"><a href="login.jsp">Login</a></li>
                        <li><a href="about.jsp">About us</a></li>
                        <li><a href="contact.jsp">Contact</a></li>
                    </ul>
                </div>
            </div>

            <div class="center_content">
                <div class="left_content">

                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" /></span>Login</div>

                    <div class="feat_prod_box_details">

                        <p class="details"> Please Enter your Details for Secure Login.</p>

                        <div class="contact_form">


                            <form action="ProductServlet?action=login" method="post" name="register"> 
                                <p>Password right</p>
                            </form>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <!--end of left content-->

                <div class="cart">
                    <div hidden>${cart}</div>
                    <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" /></span> My cart</div>
                    <div class="home_cart_content"> ${cartSize} x items | <span class="red">SUBTOTAL: ${cartTotal}</span> </div>
                    <a href="ProductServlet?action=cart" class="view_cart">view cart</a> 
                </div>

                <div class="right_box">
                    <!--                    <div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" /></span>Promotions
                                        </div> 
                    
                                        <div class="new_prod_box"> <a href="http://all-free-download.com/free-website-templates/">product name</a>
                                            <div class="new_prod_bg"> <span class="new_icon"><img src="images/promo_icon.gif" alt="" /></span> <a href="http://all-free-download.com/free-website-templates/"><img src="images/thumb1.gif" alt="" class="thumb" border="0" /></a> 
                                            </div>
                                        </div>
                    
                                        <div class="new_prod_box"> <a href="http://all-free-download.com/free-website-templates/">product name</a>
                                            <div class="new_prod_bg"> <span class="new_icon"><img src="images/promo_icon.gif" alt="" /></span> <a href="http://all-free-download.com/free-website-templates/"><img src="images/thumb2.gif" alt="" class="thumb" border="0" /></a>	
                                            </div>
                                        </div>
                    
                                        <div class="new_prod_box"> <a href="http://all-free-download.com/free-website-templates/">product name</a>
                                            <div class="new_prod_bg"> <span class="new_icon"><img src="images/promo_icon.gif" alt="" /></span> <a href="http://all-free-download.com/free-website-templates/"><img src="images/thumb3.gif" alt="" class="thumb" border="0" /></a> 
                                            </div>
                                        </div>-->
                </div>
            </div>

            <!--end of right content-->

            <div class="clear"></div>
        </div>




</html>
