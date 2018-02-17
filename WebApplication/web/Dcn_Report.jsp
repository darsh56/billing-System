<%-- 
    Document   : Dcn_Report
    Created on : Mar 20, 2015, 3:02:54 PM
    Author     : navkar
--%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML                                                                                                                                                                                                                                1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Model.DBactivation"%>
<%@page import="com.Bean.PurchaseDetails_Bean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DCN Report</title>
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
<script language="javascript" type="text/javascript">  
      var xmlHttp  
      function Showdcn(str){
          //alert(str);
      if (typeof XMLHttpRequest != "undefined"){
          
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request")
      return;
      } 
      var url="Showdcn.jsp";
      url +="?st=" +str;
      xmlHttp.onreadystatechange = stateChange;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }
      function stateChange(){   
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      document.getElementById("DCN_No").innerHTML=xmlHttp.responseText   
      }   
      }
  </script>
<script language="javascript" type="text/javascript">  
      var xmlHttp  
      var xmlHttp
      function shoshwInvoice(str){
      if (typeof XMLHttpRequest != "undefined"){
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request")
      return;
      } 
      var url="./Select_Invoice_type_dcn.jsp";
      url +="?count=" +str;
      xmlHttp.onreadystatechange =selectinvloice;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }

      function selectinvloice(){   
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      document.getElementById("DCNInvoiceType").innerHTML=xmlHttp.responseText   
      }   
      }
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
                    <li><a href="Invoice.jsp">Invoice</a></li> 
                    <li><a href="">Reports</a>
                        <ul>
                        <li><a href="Dcn_Report.jsp" title="">Delivery challan Report</a></li>
                        <li><a href="Invoice_Report.jsp" title="">Invoice Report</a></li>                        
                        </ul>                    
                    </li>
                    <!--<li><a href="AboutUs.jsp">About Us</a></li>-->
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
                <!--<a class="menuitem submenuheader " href="" > About Us </a>-->
                <!--<div class="submenu">
                    <ul>
                        <li><a href="AboutUs.jsp">About Us</a></li>
                    </ul>                    
                </div>-->  
                <a class="menuitem submenuheader " href="" > Logout </a>
                <div class="submenu">
                    <ul>
                        <li><a href="Login.jsp">Logout</a></li>
                    </ul>                    
                </div>  
            </div>
</div>     
<div class="right_content">                    
        
         <h1> DCN Report </h1>          
            
         <div class="form">
         <form action="./Report_DCN" method="post">             
                   <table>                       
                    <tr>
                        <td><label for="I_Type"> Invoice Type: </label></td>
                        <td>
                            <select name="I_Type" id="I_Type" style="width:200px;height:30px;" required="" onchange="Showdcn(this.value)">
                                <option value=""> Select Invoice Type </option>
                                <option value="Retail"> Retail </option>
                                <option value="JobWork"> Job Work </option>
                                <option value="Tax"> Tax </option>
                           </select>
                        </td>
                    </tr>             
                    <tr>
                    <td><label for="DCN_No"> DCN NO: </label> </td>
                    <td>
                        <select name="DCN_No" id="DCN_No" style="width:200px;height:30px;" required="">
                            <option value=""> Select DCN Number </option>
                        </select>
                    </td>
                   </tr>
             <tr>
                 <td></td>
                 <td class="continue"><input type="submit" name="Submit"  value="Submit" /></td>
             </tr>
                   </table>
         </form>
         </div>
</div>
</div><!--Center Content -->
<div class="clear"></div>            
</div> <!--end of main content-->
<div class="footer"> <div class="right_footer"></div> </div>

</div><!--Main Container -->		
</body>
</html>    
         