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
                        <li class="selected"> <a href="OldIndex.html">Home</a></li> 
                        <li><a href="about.html">About us</a></li>
                        <li><a href="category.html">Products</a></li>
                        <li><a href="specials.html">Register</a></li>
                        <li><a href="details.html">Login</a></li>
                        <li><a href="contact.html">Contact</a></li>
                    </ul>
                </div>
            </div>

            <div class="center_content">
                <div class="left_content">

                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" /></span>Sales</div>
                    <%--<c:forEach var="product" items="${product}">--%>
                        <div class="feat_prod_box">
                            <div class="prod_img"><a href="https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=just%20do%20it"><img src="images/cat_pic.jpg" alt="" class="thumb" width="109" height="122"/></a></div>
                            <div class="prod_det_box">
                                <div class="box_top"></div>
                                <div class="box_center">
                                    <div class="prod_title">Product name</div>
                                    <p class="details">you can type if you want</p>

                                    <div class="clear"></div>
                                </div>
                                <div class="box_bottom"></div>
                            </div>
                            <div class="clear"></div>
                        </div>
                    <%--</c:forEach>--%>

                    <div class="title"><span class="title_icon"><img src="images/bullet2.gif" alt="" /></span>New products</div>
                    <div class="new_products">
                        <div class="new_prod_box"> <a href="http://all-free-download.com/free-website-templates/">product name</a>
                            <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" /></span> <img src="images/thumb1_1.gif" alt="" class="thumb" border="0" /> 
                            </div>
                        </div>
                        <div class="new_prod_box"> <a href="http://all-free-download.com/free-website-templates/">product name</a>
                            <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" /></span> <img src=Òimages/pottery.gifÓ alt="" class="thumb" border="0" /> 
                            </div>
                        </div>
                        <div class="new_prod_box"> <a href="http://all-free-download.com/free-website-templates/">product name</a>
                            <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" /></span> <img src="images/thumb3.gif" alt="" class="thumb" border="0" />
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <!--end of left content-->

                <div class="cart">
                    <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" /></span> My cart</div>
                    <div class="home_cart_content"> 3 x items | <span class="red">TOTAL: 100$</span> </div>
                    <a href="cart.html" class="view_cart">view cart</a> 
                </div>

                <div class="right_box">
                    <div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" /></span>Promotions
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
                    </div>
                </div>
            </div>

            <!--end of right content-->

            <div class="clear"></div>
        </div>




</html>
