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
                        <li class="selected"><a href="ProductServlet?action=products">Products</a></li>
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

                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" /></span>Product</div>
                    <div class="feat_prod_box">
                        <div class="prod_img"><a href="index.jsp"><img src="${product.location}" alt="" height="300" width="500"/></a></div>
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

                        <a href="ProductServlet?action=add&amp;productCode=${product.pictureId}">Add Cart</a>


                        <div class="clear"></div>
                    </div>
                </div>
                <!--end of left content-->

                <div class="cart">
                    <div hidden>${cart}</div>
                    <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" /></span> My cart</div>
                    <div class="home_cart_content"> ${cartSize} x items | <span class="red">SUBTOTAL: ${cartTotal}</span> </div>
                    <a href="ProductServlet?action=cart" class="view_cart">view cart</a> 
                </div>
            </div>

            <!--end of right content-->

            <div class="clear"></div>
        </div>




</html>
