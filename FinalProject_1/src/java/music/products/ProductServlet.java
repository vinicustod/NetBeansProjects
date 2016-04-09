package music.products;

/*package music.products;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import music.business.Product;
import music.data.ProductIO;
import music.data.ProductDB;

/**
 *
 * @author viniciuscustodio
 */
@WebServlet(urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();

        // get current action
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "products.html";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/products.jsp";
        if (action.equals("list")) {
            url = "/ProductServlet?action=products";    // the "index" page
        } else if (action.equals("add")) {

            HttpSession session = request.getSession();

            String productCode = request.getParameter("productCode");
            String path = sc.getRealPath("/WEB-INF/products.txt");
            ProductIO.init(path);
            Product product = new Product();
            session.setAttribute("product", product);
            url = "/edit.jsp";
        } else if (action.equals("products")) {

            String quantityString = request.getParameter("quantity");

            HttpSession session = request.getSession();

            List<Product> products = ProductDB.selectProducts();
            session.setAttribute("products", products);
            url = "/products.jsp";

        } else if (action.equals("edit")) {
            HttpSession session = request.getSession();

            String productCode = request.getParameter("productCode");
            String path = sc.getRealPath("/WEB-INF/products.txt");

            ProductIO.init(path);
            Product product = ProductDB.selectProduct(productCode);
            session.setAttribute("product", product);
            session.setAttribute("productOldCode", productCode);

            url = "/edit.jsp";
        } else if (action.equals("remove")) {
            HttpSession session = request.getSession();

            String productCode = request.getParameter("productCode");
            String path = sc.getRealPath("/WEB-INF/products.txt");

            ProductIO.init(path);
            Product product = ProductDB.selectProduct(productCode);

            session.setAttribute("product", product);
            url = "/remove.jsp";
        } else if (action.equals("remove_yes")) {
            String path = sc.getRealPath("/WEB-INF/products.txt");
            String productCode = request.getParameter("productCode");
            ProductIO.init(path);
            Product product = ProductDB.selectProduct(productCode);

            ProductDB.deleteProduct(product);
            url = "/ProductServlet?action=products";
        } else if (action.equals("update")) {
            String path = sc.getRealPath("/WEB-INF/products.txt");
            String productCode = request.getParameter("productCode");
            String newProductCode = request.getParameter("newProductCode");
            String productDescription = request.getParameter("productDescription");
            String productPrice = request.getParameter("productPrice");
            //ProductIO.init(path);
            HttpSession session = request.getSession();

            Product p = new Product();
            p.setCode(newProductCode);
            p.setDescription(productDescription);
            p.setPrice(Double.parseDouble(productPrice));

            session.setAttribute("product", p);
            session.setAttribute("productOldCode", productCode);

            if (newProductCode.isEmpty() || productDescription.isEmpty() || productPrice.isEmpty()) {
                // forward to the view to get missing parameters
                url = "/edit.jsp";
            } else {
                // write the User object to a file  if (productCode != null) {

                if (!productCode.equals("")) {
                    Product product = ProductDB.selectProduct(productCode);
                    ProductDB.deleteProduct(product);

                }
                ProductDB.insertProduct(p);
                url = "/ProductServlet?action=products";
            }
        }

        sc.getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
