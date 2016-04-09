<%-- 
    Document   : products
    Created on : Oct 28, 2015, 5:11:03 PM
    Author     : viniciuscustodio
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        
    </head>
    <body>

        <h1>CD list</h1>

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th class="right">Price</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.description}</td>
                    <td class="right">${product.priceCurrencyFormat}</td>

                    <td><a href="ProductServlet?action=remove&amp;productCode=${product.code}"> Remove </a></td> 

                    <td><a href="ProductServlet?action=edit&amp;productCode=${product.code}"> Edit </a></td>
                </tr>
            </c:forEach>

        </table>
        <form action="ProductServlet?action=add" method="post">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Add Product">
        </form>

    </body>
</html>