<%-- 
    Document   : Add_City
    Created on : Oct 29, 2014, 2:07:57 PM
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
        <title>City Master</title>
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
    
    <div class="right_content">            
        
       <div class="form">
        <%
            String cid = (String)request.getAttribute("cid");
            String sid = (String)request.getAttribute("sid");
            String citynm = (String)request.getAttribute("citynm");
            if(cid!=null){
        %>
        <form action="Update_City" method="post" >
            <table>
            <tr>
             <td><input type="hidden" name="txtcid" value="<%=cid%>" /></td>
             <td><select name="selstate" style="width:260px;" class="text-combobox" required="Select State Name">
                 <option value="<%=sid%>"><%=sid%></option>
                <%
                    Connection conn=DBactivation.getConnection();
                    PreparedStatement ps1=conn.prepareStatement("SELECT State_id,State_Name FROM state_entry");
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next())
                    {
                        String sid1=rs1.getString(1);
                        String sname=rs1.getString(2);
                %>
                <option value="<%=sid1%>"><%=sname%></option>
                <%}%> 
                 </select></td>
                 <td><input type="text" name="txtcitynm" value="<%=citynm%>" style="width:260px;" required/></td>
                 <td><input type="submit" value="Update"/></td>
            </tr>
            </table>
         </form>
        <%
            }
            else{
        %>     
         <form action="Insert_City_Conttroller" method="post">
             <table>
             <tr>    
             <td><select name="selstate" style="width:260px;" class="text-combobox">
                 <option value="defualt">Select State</option>
                <%
                    Connection conn=DBactivation.getConnection();
                    PreparedStatement ps1=conn.prepareStatement("SELECT State_id,State_Name FROM state_entry");
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next())
                    {
                        String stateid=rs1.getString(1);
                        String statename=rs1.getString(2);
                %>
                <option value="<%=stateid%>"><%=statename%></option>
                <%}%> 
                 </select></td>
                 <td><input type="text" name="txtcitynm" placeholder="City Name" style="width:260px;" required/></td>
                 <td><input type="submit" value="Save"/></td>
             </tr>
            </table>
         </form>
        <br>
        <table border="1">
            <tr>
                <td>State Id</td>
                <td>City Id</td>
                <td>City Name</td>
                <td> </td>
                <td> </td>
            </tr>
            <%
                ArrayList<City_Bean> acoublist = (ArrayList<City_Bean>)request.getAttribute("citydata");
                if(acoublist!=null)
                {
                    Iterator<City_Bean> itr = acoublist.iterator();
                    while(itr.hasNext()){
                        City_Bean cb = (City_Bean)itr.next();
                        String cityid = cb.getCity_id();
                        String stateid = cb.getState_id();
                        String citynm1 = cb.getCity_Name();
            %>
            <tr>
                <td><%=stateid%></td>
                <td><%=cityid%></td>
                <td><%=citynm1%></td>
                <td><a href="Edit_City?cid=<%=cityid%>&sid=<%=stateid%>&citynm=<%=citynm1%>">Edit</a></td>
                <td><a href="Delete_City?cid=<%=cityid%>">Delete</a></td>
            </tr>
            <%
                    }
                }
            }
            %>
        </table>
        </div>
        </div>
</div>
<div class="clear"></div>
</div> <!--end of main content-->
<div class="footer_login">
    
        <div class="left_footer_login">  <!--<a href="http://indeziner.com">INDEZINER</a> --></div>
    <!--	<div class="right_footer_login"><a href="http://indeziner.com"><img src="images/indeziner_logo.gif" alt="" title="" border="0" /></a></div> -->
    
</div>
</div><!--Main Container-->		
</body>
</html>