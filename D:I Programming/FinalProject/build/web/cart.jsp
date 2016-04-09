<!DOCTYPE>
<html>
    <head>
        <title>THE Pottery Shop Cart</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css" />
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div id="wrap">
            <div class="header">

                <div id="menu">
                    <ul>
                        <li><a href="ProductServlet?action=sale">Home</a></li> 
                        <li><a href="ProductServlet?action=products&amp;productCode=${cart}">Products</a></li>
                        <li class="selected"><a href="ProductServlet?action=cart">Cart</a></li>
                        <li><a href="register.jsp">Register</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="about.jsp">About us</a></li>
                        <li><a href="contact.jsp">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="center_content">
                <div class="left_content">

                    <div class="feat_prod_box_details">
                        <table class="cart_table">

                            <tr class="cart_title">
                                <td>Item name</td>
                                <td>Price</td>
                                <td>Discount</td>
                            </tr>
                            <c:forEach var="product" items="${products}">
                                <tr>
                                    <td>${product.pictureId}</td>
                                    <td>${product.priceCurrencyFormat}</td>
                                    <td>${product.percentage} %</td>
                                    <td><a href="ProductServlet?action=cartRemove&amp;productCode=${product.pictureId}">Remove</a></td>
                                </tr>
                            </c:forEach>
                                <td colspan="4" class="cart_total"><span class="red">SUBTOTAL:</span></td>
                                <td> ${cartTotal}</td>
                            </tr>
                            <tr>
                                <td colspan="4" class="cart_total"><span class="red">DISCOUNT:</span></td>
                                <td> ${cartDiscount}</td>
                            </tr>
                            <tr>
                                <td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
                                <td> ${cartFinalTotal}</td>
                            </tr>
                        </table>
                        <a href=""></a> <a href="" class="checkout">checkout &gt;</a> </div>
                    <div class="clear"></div>
                </div>
                <!--end of left content-->
                <div class="right_content">

                </div>
                <div class="cart">
                    <div hidden>${cart}</div>
                    <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" /></span> My cart</div>
                    <div class="home_cart_content"> ${cartSize} x items | <span class="red">SUBTOTAL: ${cartTotal}</span> </div>
                    <a href="ProductServlet?action=cart" class="view_cart">view cart</a> 
                </div>




                <!--end of right content-->
                <div class="clear"></div>
            </div>
            <!--end of center content-->

        </div>
    </body>
</html>
