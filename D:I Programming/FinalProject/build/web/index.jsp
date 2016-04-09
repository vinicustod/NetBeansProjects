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
                        <li class="selected"><a href="ProductServlet?action=sale">Home</a></li> 
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
                            <c:forEach var="product" items="${products}">
                        <div class="feat_prod_box">
                            <div class="prod_img"><a href="ProductServlet?action=product&amp;productCode=${product.pictureId}"><img src="${product.location}" alt="" height="103" width="118"/></a></div>
                            <div class="prod_det_box">
                                <div class="box_top"></div>
                                <div class="box_center">
                                    <div class="prod_title"><b>Artist: </b>${product.artist}</div>
                                    <p class="details">${product.description}</p>
                                    <p class="details"><b>Price: </b>${product.priceCurrencyFormat} - ${product.percentage} %</p>
                                    <div class="clear"></div>
                                </div>
                                <div class="box_bottom"></div>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </c:forEach>

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
