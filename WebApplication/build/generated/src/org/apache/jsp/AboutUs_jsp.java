package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.Model.DBactivation;
import com.Bean.City_Bean;
import java.util.ArrayList;
import com.Bean.State_Bean;
import java.util.Iterator;

public final class AboutUs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>About Us</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n");
      out.write("        <script src=\"js/jquery-1.11.1.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/clockp.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/clockh.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/ddaccordion.js\"></script>\n");
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
      out.write("<script type=\"text/javascript\" src=\"js/jconfirmaction.jquery.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t$('.ask').jConfirmAction();\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"js/niceforms.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"niceforms-default.css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"main_container\">\n");
      out.write("\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <div class=\"logo\"><a href=\"#\"><img src=\"images/Mechatronics_logo.jpg\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n");
      out.write("        <!--<h1><color=\"yellow\">Manufacturing Tools Billing System</color></h1>-->\n");
      out.write("    <div id=\"clock_a\"></div>\n");
      out.write("    </div>    \n");
      out.write("    <div class=\"main_content\">\n");
      out.write("    \n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                     <ul>\n");
      out.write("                    <li><a class=\"current\" href=\"Admin_Page.jsp\">Admin Home</a></li>\n");
      out.write("                    <li><a href=\"\">Masters</a>\n");
      out.write("                        <ul>\n");
      out.write("                        <li><a href=\"./Select_Conttroller\" title=\"\">State Master</a></li>\n");
      out.write("                        <li><a href=\"./Select_City_Conttroller\" title=\"\">City Master</a></li>\n");
      out.write("                        <li><a href=\"./Select_Info_Client\" title=\"\">Client Master</a></li>  \n");
      out.write("                        <li><a href=\"./Select_PartMaster\" title=\"\">Part Master</a></li>          \n");
      out.write("                        </ul>                    \n");
      out.write("                    </li> \n");
      out.write("                    <li><a href=\"Sales_Register.jsp\">Sales Register</a></li>\n");
      out.write("                    <li><a href=\"AboutUs.jsp\">About Us</a></li>\n");
      out.write("                    <li><a href=\"Login.jsp\">Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    </div>                                        \n");
      out.write("                    \n");
      out.write("    <div class=\"center_content\">     \n");
      out.write("       \n");
      out.write("    <div class=\"left_content\">\n");
      out.write("    \n");
      out.write("    \t   <div class=\"left_content\">\n");
      out.write("            \t<!--<div class=\"sidebar_search\">\n");
      out.write("            <!--<form>\n");
      out.write("            <input type=\"text\" name=\"\" class=\"search_input\" value=\"search keyword\" onclick=\"this.value=''\" />\n");
      out.write("            <input type=\"image\" class=\"search_submit\" src=\"images/search.png\" />\n");
      out.write("            </form>            \n");
      out.write("            </div>-->\n");
      out.write("    \n");
      out.write("            <div class=\"sidebarmenu\">\n");
      out.write("            \n");
      out.write("                <a class=\"menuitem submenuheader menuitem_green\" href=\"\"> Masters</a>\n");
      out.write("                <div class=\"submenu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"./Select_Conttroller\" title=\"\">State Master</a></li>\n");
      out.write("                        <li><a href=\"./Select_City_Conttroller\" title=\"\">City Master</a></li>\n");
      out.write("                        <li><a href=\"./Select_Info_Client\" title=\"\">Client Master</a></li>      \n");
      out.write("                        <li><a href=\"./Select_PartMaster\" title=\"\">Part Master</a></li>          \n");
      out.write("                    </ul>    \n");
      out.write("                </div>\n");
      out.write("                <a class=\"menuitem submenuheader \" href=\"Sales_Register.jsp\">Sales Register</a>\n");
      out.write("                <div class=\"submenu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"Sales_Register.jsp\">Sales Register</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <a class=\"menuitem submenuheader menuitem_green\" href=\"\">About Us</a>\n");
      out.write("                <div class=\"submenu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"AboutUs.jsp\">About Us</a></li>\n");
      out.write("                    </ul>    \n");
      out.write("                </div>\n");
      out.write("                <a class=\"menuitem submenuheader \" href=\"\">Logout</a>\n");
      out.write("                <div class=\"submenu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"Login.jsp\">Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
      out.write("    </div>\n");
      out.write("        </div>\n");
      out.write("   <div class=\"right_content\">           \n");
      out.write("        \n");
      out.write("       <div class=\"form\" style=\"text-align: right;\">\n");
      out.write("       \n");
      out.write("           <h1>\n");
      out.write("               <marquee direction=\"up\" scrolldelay=\"250\"><p style=\"font-size:100%;text-align: justify\">Ours is Today Well Established Group Made its Mark in the field of 5 Axis and 3 Axis Stone & Wood Engraving Machine as well as for Design, Development and Manufacturing of Machine tool & Precision Engineering Components.               \n");
      out.write("                Started with Small Engineering Company , XYZ Mechatronics Pvt. Ltd is a now a Name for Small and Large Indian Company as well as foreign Company for Carving CNC Machine Solutions,Designing and Manufacturing Solutions. With our highly educated Techno-commercial Management and Strongly Motivated Team of Skilled Professionals,We Always Endeavor our Best to Provide Everlasting value to our Customers. We Always Looking towards new Technology with Highly Efficient Machinery As Well As Measuring or Calibrating Facility to Provide True Satisfaction to our Customer to increase their Efficiency and Profitability.</p>\n");
      out.write("                \n");
      out.write("               <p style=\"font-size:100%;text-align: justify\">Our Mission is to Provide Efficient Quality Engineering Services with our Existing Technical know-how as well as Human Capital and Thereby Understand, Satisfy & Commemorate our Customers.</p>\n");
      out.write("                \n");
      out.write("               <p style=\"font-size:100%;text-align: justify\">Our Vision urges us Towards implementing our Research and innovation in a Delighting our present Patrons and Prospective Clients. In coming times, XYZ Mechatronics is all set to Achieve new Milestones in Costumer Services and Developing Technologically Competent Products in the Mechanical Field.</p>\n");
      out.write("                \n");
      out.write("               <p style=\"font-size:100%;text-align: justify\">XYZ Mechatronics is a Breeding Ground for innovation. It Gives Wings to imagination and Helps You Carve your Dreams into Reality. At XYZ, We Believe,it is not only important to realize your Product ideas, but it is Wonderful to shape them into world class Products. Thus, we Develop Engraving edge Technology Machines and Products that Facilitate You in Carving Your imagination on the Face of World.</p></marquee>\n");
      out.write("          </h1>\n");
      out.write("           \n");
      out.write("        </div>\n");
      out.write("   </div>\n");
      out.write("<div class=\"clear\"></div>\n");
      out.write(" <!--end of main content-->\n");
      out.write("<div class=\"footer_login\">\n");
      out.write("    \n");
      out.write("        <div class=\"left_footer_login\">  <!--<a href=\"http://indeziner.com\">INDEZINER</a> --></div>\n");
      out.write("    <!--\t<div class=\"right_footer_login\"><a href=\"http://indeziner.com\"><img src=\"images/indeziner_logo.gif\" alt=\"\" title=\"\" border=\"0\" /></a></div> -->\n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("</div><!--Main Container-->\t\t\n");
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
