package picture.images;

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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.http.*;
import picture.business.Cart;
import picture.business.Picture;
import picture.business.Users;
import picture.data.PictureDB;
import picture.data.UserDB;

/**
 *
 * @author viniciuscustodio
 */
@WebServlet(urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    public Cart cCart = new Cart();
    public Users client = new Users();

    @Override

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();

        // get current action
        String action = request.getParameter("action");

        if (action == null) {
            action = "sale";  // default action

        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";

        if (action.equals("sale")) {

            Picture p = new Picture();
            HttpSession session = request.getSession();
            setCart(session, request);
            List<Picture> products = PictureDB.selectProductsSale();
            session.setAttribute("products", products);

            url = "/index.jsp";

        } else if (action.equals("products")) {

            HttpSession session = request.getSession();
            setCart(session, request);

            List<Picture> products = PictureDB.selectProducts();
            session.setAttribute("products", products);

            url = "/products.jsp";

        } else if (action.equals("product")) {
            HttpSession session = request.getSession();
            setCart(session, request);

            String productId = request.getParameter("productCode");
            Picture p = PictureDB.selectProduct(Integer.parseInt(productId));

            session.setAttribute("product", p);
            url = "/product.jsp";

        } else if (action.equals("add")) {

            HttpSession session = request.getSession();

            String productId = request.getParameter("productCode");
            Picture p = PictureDB.selectProduct(Integer.parseInt(productId));

            cCart.appendPicture(p);
            setCart(session, request);

            session.setAttribute("cartDiscount", cCart.getDiscount());

            float total = (cCart.getTotal() - cCart.getDiscount());
            String value = cCart.convertTotalCurrencyFormat(total);

            session.setAttribute("cartFinalTotal", value);
            session.setAttribute("products", cCart.getPictures());
            url = "/cart.jsp";

        } else if (action.equals("cart")) {

            HttpSession session = request.getSession();

            setCart(session, request);
            session.setAttribute("cartDiscount", cCart.getDiscount());

            float total = (cCart.getTotal() - cCart.getDiscount());
            String value = cCart.convertTotalCurrencyFormat(total);
            session.setAttribute("cartFinalTotal", value);
            session.setAttribute("products", cCart.getPictures());
            url = "/cart.jsp";
        } else if (action.equals("newUser")) {
            HttpSession session = request.getSession();
            setCart(session, request);

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");
            System.out.println("firstname");
            System.out.println(firstName);
            Users u = new Users(email, firstName, lastName, userName, address, city, state, zipCode, password);

            UserDB.insertProduct(u);
            url = "/ProductServlet?action=null";
        } else if (action.equals("login")) {
            HttpSession session = request.getSession();
            setCart(session, request);

            String pwd = request.getParameter("password");
            String user = request.getParameter("userName");
            Users u = new Users();
            u.setUserName(user);
            u.setPassword(pwd);
            List list = UserDB.checkPassword(u);
            if (list.isEmpty()) {
                url = "/login.jsp";
            } else {
                url = "/logged.jsp";
                this.client = u;
            }
        } else if (action.equals("cartRemove")) {
            HttpSession session = request.getSession();
            String id = request.getParameter("productCode");
            Long p = Long.parseLong(id);
            
            List listp = cCart.getPictures();
            Iterator i = listp.iterator();
            
            List<Picture> newList = new ArrayList();

            while (i.hasNext()) {
                Picture picture = (Picture) i.next();
                if (Objects.equals(picture.getPictureId(), p)) {
                    continue;
                } else {
                    newList.add(picture);
                }
            }
            cCart.setPictures(newList);
            setCart(session, request);

            url = "/ProductServlet?action=cart";
        }

        sc.getRequestDispatcher(url)
                .forward(request, response);
    }

    private void setCart(HttpSession session, HttpServletRequest request) {
        session.setAttribute("cart", cCart);
        session.setAttribute("cartSize", cCart.listSize());
        session.setAttribute("cartTotal", cCart.getTotalCurrencyFormat());
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
