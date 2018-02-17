<%-- 
    Document   : AboutUs
    Created on : Apr 23, 2015, 5:44:44 PM
    Author     : navkar
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Model.DBactivation"%>
<%@page import="com.Bean.City_Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bean.State_Bean"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Us</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/clockp.js"></script>
<script type="text/javascript" src="js/clockh.js"></script> 
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddaccordion.js"></script>
<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>

<script type="text/javascript" src="js/jconfirmaction.jquery.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
	
</script>
<script language="javascript" type="text/javascript" src="js/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="niceforms-default.css" />
</head>
<body>
<div id="main_container">

    <div class="header">
        <div class="logo"><a href="#"><img src="images/Mechatronics_logo.jpg" alt="" title="" border="0" /></a></div>
        <!--<h1><color="yellow">Manufacturing Tools Billing System</color></h1>-->
    <div id="clock_a"></div>
    </div>    
    <div class="main_content">
    
                    <div class="menu">
                     <ul>
                    <li><a class="current" href="Admin_Page.jsp">Admin Home</a></li>
                    <li><a href="">Masters</a>
                        <ul>
                        <li><a href="./Select_Conttroller" title="">State Master</a></li>
                        <li><a href="./Select_City_Conttroller" title="">City Master</a></li>
                        <li><a href="./Select_Info_Client" title="">Client Master</a></li>  
                        <li><a href="./Select_PartMaster" title="">Part Master</a></li>          
                        </ul>                    
                    </li> 
                    <li><a href="Sales_Register.jsp">Sales Register</a></li>
                    <li><a href="AboutUs.jsp">About Us</a></li>
                    <li><a href="Login.jsp">Logout</a></li>
                    </ul>
                    </div>                                        
                    
    <div class="center_content">     
       
    <div class="left_content">
    
    	   <div class="left_content">
            	<!--<div class="sidebar_search">
            <!--<form>
            <input type="text" name="" class="search_input" value="search keyword" onclick="this.value=''" />
            <input type="image" class="search_submit" src="images/search.png" />
            </form>            
            </div>-->
    
            <div class="sidebarmenu">
            
                <a class="menuitem submenuheader menuitem_green" href=""> Masters</a>
                <div class="submenu">
                    <ul>
                        <li><a href="./Select_Conttroller" title="">State Master</a></li>
                        <li><a href="./Select_City_Conttroller" title="">City Master</a></li>
                        <li><a href="./Select_Info_Client" title="">Client Master</a></li>      
                        <li><a href="./Select_PartMaster" title="">Part Master</a></li>          
                    </ul>    
                </div>
                <a class="menuitem submenuheader " href="Sales_Register.jsp">Sales Register</a>
                <div class="submenu">
                    <ul>
                        <li><a href="Sales_Register.jsp">Sales Register</a></li>
                    </ul>
                </div>
                <a class="menuitem submenuheader menuitem_green" href="">About Us</a>
                <div class="submenu">
                    <ul>
                        <li><a href="AboutUs.jsp">About Us</a></li>
                    </ul>    
                </div>
                <a class="menuitem submenuheader " href="">Logout</a>
                <div class="submenu">
                    <ul>
                        <li><a href="Login.jsp">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>    
    </div>
        </div>
   <div class="right_content">           
        
       <div class="form" style="text-align: right;">
       
           <h1>
               <marquee direction="up" scrolldelay="250"><p style="font-size:100%;text-align: justify">Ours is Today Well Established Group Made its Mark in the field of 5 Axis and 3 Axis Stone & Wood Engraving Machine as well as for Design, Development and Manufacturing of Machine tool & Precision Engineering Components.               
                Started with Small Engineering Company , XYZ Mechatronics Pvt. Ltd is a now a Name for Small and Large Indian Company as well as foreign Company for Carving CNC Machine Solutions,Designing and Manufacturing Solutions. With our highly educated Techno-commercial Management and Strongly Motivated Team of Skilled Professionals,We Always Endeavor our Best to Provide Everlasting value to our Customers. We Always Looking towards new Technology with Highly Efficient Machinery As Well As Measuring or Calibrating Facility to Provide True Satisfaction to our Customer to increase their Efficiency and Profitability.</p>
                
               <p style="font-size:100%;text-align: justify">Our Mission is to Provide Efficient Quality Engineering Services with our Existing Technical know-how as well as Human Capital and Thereby Understand, Satisfy & Commemorate our Customers.</p>
                
               <p style="font-size:100%;text-align: justify">Our Vision urges us Towards implementing our Research and innovation in a Delighting our present Patrons and Prospective Clients. In coming times, XYZ Mechatronics is all set to Achieve new Milestones in Costumer Services and Developing Technologically Competent Products in the Mechanical Field.</p>
                
               <p style="font-size:100%;text-align: justify">XYZ Mechatronics is a Breeding Ground for innovation. It Gives Wings to imagination and Helps You Carve your Dreams into Reality. At XYZ, We Believe,it is not only important to realize your Product ideas, but it is Wonderful to shape them into world class Products. Thus, we Develop Engraving edge Technology Machines and Products that Facilitate You in Carving Your imagination on the Face of World.</p></marquee>
          </h1>
           
        </div>
   </div>
<div class="clear"></div>
 <!--end of main content-->
<div class="footer_login">
    
        <div class="left_footer_login">  <!--<a href="http://indeziner.com">INDEZINER</a> --></div>
    <!--	<div class="right_footer_login"><a href="http://indeziner.com"><img src="images/indeziner_logo.gif" alt="" title="" border="0" /></a></div> -->
    
</div>
</div><!--Main Container-->		
</body>
</html>