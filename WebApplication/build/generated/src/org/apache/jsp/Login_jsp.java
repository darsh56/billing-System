package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>Login Page</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"ddaccordion.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("ddaccordion.init({\n");
      out.write("\theaderclass: \"submenuheader\", //Shared CSS class name of headers group\n");
      out.write("\tcontentclass: \"submenu\", //Shared CSS class name of contents group\n");
      out.write("\trevealtype: \"click\", //Reveal content when user clicks or onmouseover the header? Valid value: \"click\", \"clickgo\", or \"mouseover\"\n");
      out.write("\tmouseoverdelay: 200, //if revealtype=\"mouseover\", set delay in milliseconds before header expands onMouseover\n");
      out.write("\tcollapseprev: true, //Collapse previous content (so only one open at any time)? true/false \n");
      out.write("\tdefaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content\n");
      out.write("\tonemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)\n");
      out.write("\tanimatedefault: false, //Should contents open by default be animated into view?\n");
      out.write("\tpersiststate: true, //persist state of opened contents within browser session?\n");
      out.write("\ttoggleclass: [\"\", \"\"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively [\"class1\", \"class2\"]\n");
      out.write("\ttogglehtml: [\"suffix\", \"<img src='images/plus.gif' class='statusicon' />\", \"<img src='images/minus.gif' class='statusicon' />\"], //Additional HTML added to the header when it's collapsed and expanded, respectively  [\"position\", \"html1\", \"html2\"] (see docs)\n");
      out.write("\tanimatespeed: \"fast\", //speed of animation: integer in milliseconds (ie: 200), or keywords \"fast\", \"normal\", or \"slow\"\n");
      out.write("\toninit:function(headers, expandedindices){ //custom code to run when headers have initalized\n");
      out.write("\t\t//do nothing\n");
      out.write("\t},\n");
      out.write("\tonopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed\n");
      out.write("\t\t//do nothing\n");
      out.write("\t}\n");
      out.write("})\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"jconfirmaction.jquery.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t$('.ask').jConfirmAction();\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"niceforms.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"niceforms-default.css\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"main_container\">\n");
      out.write("\n");
      out.write("    <div class=\"header\">\n");
      out.write("    <div class=\"logo\"><a href=\"#\"><img src=\"images/abc.png\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n");
      out.write("    <div id=\"clock_a\"></div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("     \n");
      out.write("         <div class=\"login_form\">\n");
      out.write("         \n");
      out.write("             <center><h1>Login Here</h1></center>\n");
      out.write("         \n");
      out.write("         <!--<a href=\"Login.jsp\" class=\"forgot_pass\">Forgot password</a> -->\n");
      out.write("         \n");
      out.write("         <form action=\"Login\" method=\"post\" class=\"niceform\">\n");
      out.write("         \n");
      out.write("                <fieldset>\n");
      out.write("                    <dl>\n");
      out.write("                        <dt><label for=\"email\">Username:</label></dt>\n");
      out.write("                        <dd><input type=\"text\" name=\"txtusername\" id=\"\" size=\"54\" /></dd>\n");
      out.write("                    </dl>\n");
      out.write("                    <dl>\n");
      out.write("                        <dt><label for=\"password\">Password:</label></dt>\n");
      out.write("                        <dd><input type=\"password\" name=\"txtpass\" id=\"\" size=\"54\" /></dd>\n");
      out.write("                    </dl>\n");
      out.write("                    \n");
      out.write("                    <!--<li><a href=\"list.html\">Social Media</a>\n");
      out.write("                        <ul>\n");
      out.write("                        <li><a href=\"\"> Gmail </a></li>\n");
      out.write("                        <li><a href=\"\"> Yahoo </a></li>\n");
      out.write("                        <li><a href=\"\"> Facebook </a></li>  \n");
      out.write("                        <li><a href=\"\"> Twitter </a></li>          \n");
      out.write("                        </ul>                    \n");
      out.write("                    </li>-->              \n");
      out.write("                    \n");
      out.write("                    <!--<dl>\n");
      out.write("                        <dt><label></label></dt>\n");
      out.write("                        <dd>\n");
      out.write("                    <input type=\"checkbox\" name=\"interests[]\" id=\"\" value=\"\" /><label class=\"check_label\">Remember me</label>\n");
      out.write("                        </dd>\n");
      out.write("                    </dl>-->\n");
      out.write("                    \n");
      out.write("                    <dl class=\"submit\">\n");
      out.write("                        <dd><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Login\" /></dd>\n");
      out.write("                    </dl>                    \n");
      out.write("                </fieldset>                \n");
      out.write("         </form>\n");
      out.write("         </div>  \n");
      out.write("    <div class=\"footer_login\">\n");
      out.write("    \n");
      out.write("        <div class=\"left_footer_login\">  <!--<a href=\"http://indeziner.com\">INDEZINER</a> --></div>\n");
      out.write("        <div class=\"right_footer_login\">Manufacturing Tools Billing System<!--<a href=\"http://indeziner.com\"><img src=\"images/indeziner_logo.gif\" alt=\"\" title=\"\" border=\"0\" /></a>--></div> \n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("</div>\t\t\n");
      out.write("</body>\n");
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
}
