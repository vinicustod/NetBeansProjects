package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>The Pottery Shop</title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <div id=\"wrap\">\r\n");
      out.write("            <div class=\"header\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"logo\"><a href=\"\"><img src=\"\" alt=\"\" border=\"0\" /></a></div> <!Ñ //LOGO FOR THE WEBSITE ->\r\n");
      out.write("                <div id=\"menu\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li class=\"selected\"> <a href=\"ProductServlet?action=products\">Home</a></li> \r\n");
      out.write("                        <li><a href=\"about.html\">About us</a></li>\r\n");
      out.write("                        <li><a href=\"category.html\">Products</a></li>\r\n");
      out.write("                        <li><a href=\"specials.html\">Register</a></li>\r\n");
      out.write("                        <li><a href=\"details.html\">Login</a></li>\r\n");
      out.write("                        <li><a href=\"contact.html\">Contact</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"center_content\">\r\n");
      out.write("                <div class=\"left_content\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"title\"><span class=\"title_icon\"><img src=\"images/bullet1.gif\" alt=\"\" /></span>Sales</div>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"title\"><span class=\"title_icon\"><img src=\"images/bullet2.gif\" alt=\"\" /></span>New products</div>\r\n");
      out.write("                    <div class=\"new_products\">\r\n");
      out.write("                        <div class=\"new_prod_box\"> <a href=\"\">product name</a>\r\n");
      out.write("                            <div class=\"new_prod_bg\"> <span class=\"new_icon\"><img src=\"images/new_icon.gif\" alt=\"\" /></span> <img src=\"images/thumb1_1.gif\" alt=\"\" class=\"thumb\" border=\"0\" /> \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"new_prod_box\"> <a href=\"\">product name</a>\r\n");
      out.write("                            <div class=\"new_prod_bg\"> <span class=\"new_icon\"><img src=\"images/new_icon.gif\" alt=\"\" /></span> <img src=\"images/pottery.gif\" alt=\"\" class=\"thumb\" border=\"0\" /> \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"new_prod_box\"> <a href=\"\">product name</a>\r\n");
      out.write("                            <div class=\"new_prod_bg\"> <span class=\"new_icon\"><img src=\"images/new_icon.gif\" alt=\"\" /></span> <img src=\"images/thumb3.gif\" alt=\"\" class=\"thumb\" border=\"0\" />\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clear\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--end of left content-->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"cart\">\r\n");
      out.write("                    <div class=\"title\"><span class=\"title_icon\"><img src=\"images/cart.gif\" alt=\"\" /></span> My cart</div>\r\n");
      out.write("                    <div class=\"home_cart_content\"> 3 x items | <span class=\"red\">TOTAL: 100$</span> </div>\r\n");
      out.write("                    <a href=\"cart.html\" class=\"view_cart\">view cart</a> \r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"right_box\">\r\n");
      out.write("                    <div class=\"title\"><span class=\"title_icon\"><img src=\"images/bullet4.gif\" alt=\"\" /></span>Promotions\r\n");
      out.write("                    </div> \r\n");
      out.write("\r\n");
      out.write("                    <div class=\"new_prod_box\"> <a href=\"http://all-free-download.com/free-website-templates/\">product name</a>\r\n");
      out.write("                        <div class=\"new_prod_bg\"> <span class=\"new_icon\"><img src=\"images/promo_icon.gif\" alt=\"\" /></span> <a href=\"http://all-free-download.com/free-website-templates/\"><img src=\"images/thumb1.gif\" alt=\"\" class=\"thumb\" border=\"0\" /></a> \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"new_prod_box\"> <a href=\"http://all-free-download.com/free-website-templates/\">product name</a>\r\n");
      out.write("                        <div class=\"new_prod_bg\"> <span class=\"new_icon\"><img src=\"images/promo_icon.gif\" alt=\"\" /></span> <a href=\"http://all-free-download.com/free-website-templates/\"><img src=\"images/thumb2.gif\" alt=\"\" class=\"thumb\" border=\"0\" /></a>\t\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"new_prod_box\"> <a href=\"http://all-free-download.com/free-website-templates/\">product name</a>\r\n");
      out.write("                        <div class=\"new_prod_bg\"> <span class=\"new_icon\"><img src=\"images/promo_icon.gif\" alt=\"\" /></span> <a href=\"http://all-free-download.com/free-website-templates/\"><img src=\"images/thumb3.gif\" alt=\"\" class=\"thumb\" border=\"0\" /></a> \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!--end of right content-->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"clear\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("product");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${products}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        <div class=\"feat_prod_box\">\r\n");
          out.write("                            ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                            <div class=\"prod_det_box\">\r\n");
          out.write("                                <div class=\"box_top\"></div>\r\n");
          out.write("                                <div class=\"box_center\">\r\n");
          out.write("                                    <div class=\"prod_title\"><b>Artist: </b>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.artist}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("                                    <p class=\"details\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                    <p class=\"details\"><b>Price: </b>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.priceCurrencyFormat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" - ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.percentage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" %</p>\r\n");
          out.write("\r\n");
          out.write("                                    <div class=\"clear\"></div>\r\n");
          out.write("                                </div>\r\n");
          out.write("                                <div class=\"box_bottom\"></div>\r\n");
          out.write("                            </div>\r\n");
          out.write("                            <div class=\"clear\"></div>\r\n");
          out.write("                        </div>\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.percentage == 10}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <div class=\"prod_img\"><span class=\"new_icon\"><img src=\"images/promo_icon.gif\" alt=\"\" /></span> <a href=\"index.jsp\"><img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.location}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" alt=\"\" height=\"103\" width=\"118\"/></a></div>\r\n");
        out.write("\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
