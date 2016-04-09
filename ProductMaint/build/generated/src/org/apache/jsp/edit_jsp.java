package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/music.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_mma_ifEmptyMark_field_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_mma_ifEmptyMark_field_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_mma_ifEmptyMark_field_nobody.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>PRODUCTS</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>PRODUCTS</h1>\n");
      out.write("        <p>");
      if (_jspx_meth_mma_ifEmptyMark_0(_jspx_page_context))
        return;
      out.write(" marks required fields</p>\n");
      out.write("        <form action=\"ProductServlet?action=update&amp;productCode=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"add\">    \n");
      out.write("            \n");
      out.write("            <label class=\"pad_top\">Code: </label>\n");
      out.write("            <input type=\"text\" name=\"newProductCode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            ");
      if (_jspx_meth_mma_ifEmptyMark_1(_jspx_page_context))
        return;
      out.write("<br>\n");
      out.write("            \n");
      out.write("            <label class=\"pad_top\">First Name: </label>\n");
      out.write("            <input type=\"text\" name=\"productDescription\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" ><br>\n");
      out.write("            ");
      if (_jspx_meth_mma_ifEmptyMark_2(_jspx_page_context))
        return;
      out.write("<br>\n");
      out.write("\n");
      out.write("            <label class=\"pad_top\">Last Name: </label>\n");
      out.write("            <input type=\"text\" name=\"productPrice\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" ><br>    \n");
      out.write("            ");
      if (_jspx_meth_mma_ifEmptyMark_3(_jspx_page_context))
        return;
      out.write("<br>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Update\" class=\"margin_left\">\n");
      out.write("        </form>\n");
      out.write("        <form action=\"ProductServlet?action=list\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"join\">\n");
      out.write("            <input type=\"submit\" value=\"Return\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_mma_ifEmptyMark_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mma:ifEmptyMark
    music.tags.IfEmptyMarkTag _jspx_th_mma_ifEmptyMark_0 = (music.tags.IfEmptyMarkTag) _jspx_tagPool_mma_ifEmptyMark_field_nobody.get(music.tags.IfEmptyMarkTag.class);
    _jspx_th_mma_ifEmptyMark_0.setPageContext(_jspx_page_context);
    _jspx_th_mma_ifEmptyMark_0.setParent(null);
    _jspx_th_mma_ifEmptyMark_0.setField("");
    int _jspx_eval_mma_ifEmptyMark_0 = _jspx_th_mma_ifEmptyMark_0.doStartTag();
    if (_jspx_th_mma_ifEmptyMark_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_0);
      return true;
    }
    _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_0);
    return false;
  }

  private boolean _jspx_meth_mma_ifEmptyMark_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mma:ifEmptyMark
    music.tags.IfEmptyMarkTag _jspx_th_mma_ifEmptyMark_1 = (music.tags.IfEmptyMarkTag) _jspx_tagPool_mma_ifEmptyMark_field_nobody.get(music.tags.IfEmptyMarkTag.class);
    _jspx_th_mma_ifEmptyMark_1.setPageContext(_jspx_page_context);
    _jspx_th_mma_ifEmptyMark_1.setParent(null);
    _jspx_th_mma_ifEmptyMark_1.setField((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_mma_ifEmptyMark_1 = _jspx_th_mma_ifEmptyMark_1.doStartTag();
    if (_jspx_th_mma_ifEmptyMark_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_1);
      return true;
    }
    _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_1);
    return false;
  }

  private boolean _jspx_meth_mma_ifEmptyMark_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mma:ifEmptyMark
    music.tags.IfEmptyMarkTag _jspx_th_mma_ifEmptyMark_2 = (music.tags.IfEmptyMarkTag) _jspx_tagPool_mma_ifEmptyMark_field_nobody.get(music.tags.IfEmptyMarkTag.class);
    _jspx_th_mma_ifEmptyMark_2.setPageContext(_jspx_page_context);
    _jspx_th_mma_ifEmptyMark_2.setParent(null);
    _jspx_th_mma_ifEmptyMark_2.setField((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_mma_ifEmptyMark_2 = _jspx_th_mma_ifEmptyMark_2.doStartTag();
    if (_jspx_th_mma_ifEmptyMark_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_2);
      return true;
    }
    _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_2);
    return false;
  }

  private boolean _jspx_meth_mma_ifEmptyMark_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mma:ifEmptyMark
    music.tags.IfEmptyMarkTag _jspx_th_mma_ifEmptyMark_3 = (music.tags.IfEmptyMarkTag) _jspx_tagPool_mma_ifEmptyMark_field_nobody.get(music.tags.IfEmptyMarkTag.class);
    _jspx_th_mma_ifEmptyMark_3.setPageContext(_jspx_page_context);
    _jspx_th_mma_ifEmptyMark_3.setParent(null);
    _jspx_th_mma_ifEmptyMark_3.setField((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_mma_ifEmptyMark_3 = _jspx_th_mma_ifEmptyMark_3.doStartTag();
    if (_jspx_th_mma_ifEmptyMark_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_3);
      return true;
    }
    _jspx_tagPool_mma_ifEmptyMark_field_nobody.reuse(_jspx_th_mma_ifEmptyMark_3);
    return false;
  }
}
