<%-- 
    Document   : index
    Created on : Oct 31, 2014, 10:34:37 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN PAGE</title>         
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
            
    <!--<div class="logo"><a href="#"><img src="images/abc.png" alt="" title="" border="0" /></a></div>-->
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
            <!--<div class="sidebar_search">
            <form>
            <input type="text" name="" class="search_input" value="search keyword" onclick="this.value=''" />
            <input type="image" class="search_submit" src="images/search.png" />
            </form>
            </div>--> 
             <div class="sidebarmenu">
            
                <a class="menuitem" href="./Select_Conttroller"> State </a>
                <a class="menuitem_green" href="./Select_City_Conttroller"> City </a>                
                <a class="menuitem" href="./Select_Info_Client"> Client Form </a>
                <a class="menuitem_green" href="./Select_PartMaster"> Part Master </a>
                <a class="menuitem" href="Sales_Register.jsp"> Sales Register  </a>    
                <a class="menuitem_green" href="AboutUs.jsp"> About Us  </a>                   
                    
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
        <h1>Welcome <%=username%></h1>
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
