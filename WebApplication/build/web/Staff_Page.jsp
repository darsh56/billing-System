<%-- 
    Document   : Staff
    Created on : Feb 16, 2015, 6:26:47 PM
    Author     : navkar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STAFF PAGE</title>
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
    <!--<div class="logo"><a href="#"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>-->    
    <div id="clock_a"></div>
    </div>    
    <div class="main_content">
    
                    <div class="menu">
                    <ul>
                        
                    <li><a class="current" href="Staff_Page.jsp">Staff Page</a></li>
                    <li><a href="Purchase_Order_Form.jsp" title="">Purchase Order Form</a></li>
                    <li><a href="./Select_DCN" title="">Delivery Challan Form</a></li>
                    <li><a href="Invoice.jsp">Invoice</a>
                        <ul>
                        <li><a href="Invoice.jsp" title="">Retail Invoice</a></li>
                        <li><a href="Invoice.jsp" title="">JobWork</a></li>
                        <li><a href="Invoice.jsp" title="">Tax Invoice</a></li>      
                        </ul>                    
                    </li> 
                    <li><a href="">Reports</a>
                        <ul>
                        <li><a href="Dcn_Report.jsp" title="">Delivery challan Report</a></li>
                        <li><a href="Invoice_Report.jsp" title="">Invoice Report</a></li>                        
                        </ul>                    
                    </li>
                    <!--<li><a href="">About Us</a></li>-->
                    <li><a href="Login.jsp">Logout</a></li>
                    
                    </ul>
                </div>
                    
    <div class="center_content">  
    
    
    
   <div class="left_content">
            <!--<div class="sidebar_search">
            <form>
            <input type="text" name="" class="search_input" value="search keyword" onclick="this.value=''" />
            <input type="image" class="search_submit" src="images/search.png" />
            </form>
            </div>--> 
            <div class="sidebarmenu">
            
                <a class="menuitem submenuheader menuitem_green" href=""> Forms </a>
                <div class="submenu">
                    <ul>
                        <li><a href="Purchase_Order_Form.jsp" title="">Purchase Order Form</a></li>
                        <li><a href="./Select_DCN" title="">Delivery Challan Form</a></li>
                        <li><a href="Invoice.jsp">Invoice</a></li> 
                    </ul>
                </div>
                <a class="menuitem submenuheader " href="" > Reports </a>
                <div class="submenu">
                    <ul>
                        <li><a href="Dcn_Report.jsp" title="">Delivery challan Report</a></li>
                        <li><a href="Invoice_Report.jsp" title="">Invoice Report</a></li>                        
                    </ul>                    
                </div>  
                <!--<a class="menuitem submenuheader " href="" > About Us </a>
                <div class="submenu">
                    <ul>
                        <li><a href="">About Us</a></li>
                    </ul>                    
                </div> --> 
                <a class="menuitem submenuheader " href="" > Logout </a>
                <div class="submenu">
                    <ul>
                        <li><a href="Login.jsp">Logout</a></li>
                    </ul>                    
                </div>  
            </div>
    </div>     
    <div class="right_content">            
  
       <div class="form">
        
         <%
            
             HttpSession ses = request.getSession();
             String username=(String)ses.getAttribute("UserName");
             if(username==null){
                response.sendRedirect("Login.jsp");
                 
        %>
        <%
             }
             else{
                 
            
        %>
        <h1> Welcome <%=username%></h1>
        <% }%><br><br><br>
        
     </div>
 </div>
 </div><!--Center Content -->
 <div class="clear"></div>            
 </div> <!--end of main content-->
 <div class="footer"> <div class="right_footer">Manufacturing Tools Billing System</div> </div>

</div><!--Main Container -->		
         
</body>
</html>
    
        