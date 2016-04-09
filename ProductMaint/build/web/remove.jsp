<%-- 
    Document   : remove
    Created on : Oct 29, 2015, 9:31:49 AM
    Author     : viniciuscustodio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="styles/main.css" type="text/css"/>

        <title>Remove</title>
    </head>
    <body>
        <h1><b>Product</b></h1>
        <label><b>Code:</b></label>
        <span>${product.code}</span><br>
        <label><b>Description:</b></label>
        <span>${product.description}</span><br>
        <label><b>Price:</b></label>
        <span>${product.price}</span><br>
        &nbsp;

        <form action="ProductServlet?action=list" method="post">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
        <form action="ProductServlet?action=remove_yes&amp;productCode=${product.code}" method="post">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
