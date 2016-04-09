package music;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import music.business.Cart;
import music.business.LineItem;
import music.business.Product;
import music.data.ProductIO;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/products.jsp";
        ServletContext sc = getServletContext();

        // get current action
        String action = request.getParameter("action");

        action = "cart";
        // perform action and set URL to appropriate page

        JOptionPane.showConfirmDialog(null, "Why is not working?");
        String productCode = request.getParameter("productCode");
        String quantityString = request.getParameter("quantity");

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

            //if the user enters a negative or invalid quantity,
        //the quantity is automatically reset to 1.
        String path = sc.getRealPath("/WEB-INF/products.txt");
        ArrayList<Product> products = ProductIO.getProducts(path);

        Iterator i = products.iterator();
        LineItem lineItem = new LineItem();
        System.out.println("Teste Teste");
        while (i.hasNext()) {
            Product p = (Product) i.next();
            lineItem.setProduct(p);
            cart.addItem(lineItem);
        }
        session.setAttribute("cart", cart);
        url = "/products.jsp";

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
