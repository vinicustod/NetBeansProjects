<%-- 
    Document   : edit
    Created on : Oct 29, 2015, 11:30:55 PM
    Author     : viniciuscustodio
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="mma" uri="/WEB-INF/music.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>PRODUCTS</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>PRODUCTS</h1>
        
        <p><mma:ifEmptyMark field=""/> marks required fields</p>
        <form action="ProductServlet?action=update&amp;productCode=${productOldCode}" method="post">
            <input type="hidden" name="action" value="add">    
            
            <label class="pad_top">Code: </label>
            <input type="text" name="newProductCode" value="${product.code}" >
            <mma:ifEmptyMark field="${product.code}"/><br>
            
            <label class="pad_top">Description: </label>
            <input type="text" name="productDescription" value="${product.description}" >
            <mma:ifEmptyMark field="${product.description}"/><br>

            <label class="pad_top">Price: </label>
            <input type="text" name="productPrice" value="${product.price}" >   
            <mma:ifEmptyMark field="${product.price}"/><br>

            <input type="submit" value="Update" class="margin_left">
        </form>
            
        <form action="ProductServlet?action=list" method="post">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
    </body>
</html>