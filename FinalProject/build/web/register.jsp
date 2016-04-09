<%-- 
    Document   : register
    Created on : Dec 15, 2015, 4:33:36 PM
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

                <div class="logo"><a href=""><img src="" alt="" border="0" /></a></div> 
                <div id="menu">
                    <ul>
                        <li><a href="ProductServlet?action=sale">Home</a></li> 
                        <li><a href="ProductServlet?action=products">Products</a></li>
                        <li><a href="ProductServlet?action=cart">Cart</a></li>
                        <li><a href="register.jsp">Register</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="about.jsp">About us</a></li>
                        <li><a href="contact.jsp">Contact</a></li>
                    </ul>
                </div>
            </div>

            <div class="center_content">
                <div class="left_content">

                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" /></span>Sales</div>
                    <div class="feat_prod_box">
                        <div class="prod_det_box">
                            <div class="box_top"></div>
                            <div class="box_center">
                                <form action="ProductServlet?action=newUser" method="post" name="register">
                                    <div class="form_row">
                                        <label>First Name:</label>  
                                        <input type="text" name="firstName" value="">
                                    </div>
                                    <div class="form_row">
                                        <label>Last Name:</label>
                                        <input type="text" name="lastName" value="">
                                    </div>
                                    <div class="form_row">
                                        <label>Email:</label> 
                                        <input type="email" name="email" value="">
                                    </div>
                                    <div class="form_row">
                                        <label> Username:</label> 
                                        <input type="text" name="userName" value="">
                                    </div>
                                    <div class="form_row">
                                        <label>Password:</label>  
                                        <input type="password" name="password" value="">
                                    </div>
                                    <div class="form_row">
                                        <label>Address:</label>
                                        <input type="text" name="address" value="">
                                    </div>
                                    <div class="form_row">
                                        <label>City:</label>
                                        <input type="text" name="city" value="">
                                    </div>
                                    <div class="form_row">
                                        <label>State:</label> 
                                        <input type="text" name="state" value="">
                                    </div>
                                    <div class="form_row">
                                        <label>Zip Code:</label> 
                                        <input type="text" name="zipCode" value="">
                                    </div>

                                    <input type="submit" value="Register" class="margin_left">

                                </form>
                            </div>
                            <div class="box_bottom"></div>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <!--<div class="title"><span class="title_icon"><img src="images/bullet2.gif" alt="" /></span>New products</div>-->
                    <!--                    <div class="new_products">
                                            <div class="new_prod_box"> <a href="">product name</a>
                                                <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" /></span> <img src="images/thumb1_1.gif" alt="" class="thumb" border="0" /> 
                                                </div>
                                            </div>
                                            <div class="new_prod_box"> <a href="">product name</a>
                                                <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" /></span> <img src="images/pottery.gif" alt="" class="thumb" border="0" /> 
                                                </div>
                                            </div>
                                            <div class="new_prod_box"> <a href="">product name</a>
                                                <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" /></span> <img src="images/thumb3.gif" alt="" class="thumb" border="0" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clear"></div>-->
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
