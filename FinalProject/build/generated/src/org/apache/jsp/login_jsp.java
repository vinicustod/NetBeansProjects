package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>The Pottery Shop</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrap\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div class=\"logo\"><a href=“”/>asdf</a></div>\n");
      out.write("                <div id=\"menu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"file:///Users/dixikagrewal/Downloads/HTML_Project/index.html\">Home</a></li>\n");
      out.write("                        <li><a href=\"about.html\">About us</a></li>\n");
      out.write("                        <li><a href=\"category.html\">Products</a></li>\n");
      out.write("                        <li><a href=\"register.html\">Register</a></li>\n");
      out.write("                        <li class=\"selected\"><a href=login.html>Login</a></li>\n");
      out.write("                        <li><a href=\"contact.html\">Contact</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"center_content\">\n");
      out.write("                <div class=\"left_content\">\n");
      out.write("\n");
      out.write("                    <div class=\"title\"><span class=\"title_icon\"><img src=\"images/bullet1.gif\" alt=\"\" /></span>Login</div>\n");
      out.write("\n");
      out.write("                    <div class=\"feat_prod_box_details\">\n");
      out.write("\n");
      out.write("                        <p class=\"details\"> Please Enter your Details for Secure Login.</p>\n");
      out.write("\n");
      out.write("                        <div class=\"contact_form\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <form name=\"register\"> \n");
      out.write("\n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("\n");
      out.write("                                    <label class=\"contact\"><strong>Username:</strong></label>\n");
      out.write("\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\" />\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>Password:</strong></label>\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\" />\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("\n");
      out.write("                                    <div class=\"terms\">\n");
      out.write("\n");
      out.write("                                        <input type=\"checkbox\" name=\"terms\" />\n");
      out.write("                                        Remember me </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <input type=\"submit\" class=\"register\" value=\"login\" />\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clear\"></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!--end of left content-->\n");
      out.write("\n");
      out.write("                <div class=\"right_content\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"cart\">\n");
      out.write("                        <div class=\"title\"><span class=\"title_icon\"><img src=\"images/cart.gif\" alt=\"\" /></span>My cart</div>\n");
      out.write("                        <div class=\"home_cart_content\"> 3 x items | <span class=\"red\">TOTAL: 100$</span> </div>\n");
      out.write("                        <a href=\"\">view cart</a> </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"right_box\">\n");
      out.write("\n");
      out.write("                        <div class=\"new_prod_box\"> \n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"new_prod_box\"> \n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!--end of right content-->\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("            </div>\n");
      out.write("            <!--end of center content-->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
