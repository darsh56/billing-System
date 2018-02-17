<%-- 
    Document   : Add_City
    Created on : Oct 29, 2014, 2:07:57 PM
    Author     : navkar
--%>

<%@page import="com.Bean.PartMaster_Bean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Model.DBactivation"%>
<%@page import="com.Bean.ClientForm_Bean"%>
<%@page import="com.Bean.City_Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bean.State_Bean"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part Master</title>
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
<script language=JavaScript>
var datePickerDivID = "datepicker";
var iFrameDivID = "datepickeriframe";
var dayArrayShort = new Array('Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa');
var dayArrayMed = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
var dayArrayLong = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday');
var monthArrayShort = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec');
var monthArrayMed = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'June', 'July', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec');
var monthArrayLong = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
var defaultDateSeparator = "/"; // common values would be "/" or "-"
var defaultDateFormat = "dmy" // valid values are "mdy", "dmy", and "ymd"
var dateSeparator = defaultDateSeparator;
var dateFormat = defaultDateFormat;
function displayDatePicker(dateFieldName, displayBelowThisObject, dtFormat, dtSep)
{
var targetDateField = document.getElementsByName (dateFieldName).item(0);

// if we weren't told what node to display the datepicker beneath, just display it
// beneath the date field we're updating
if (!displayBelowThisObject)
displayBelowThisObject = targetDateField;

// if a date separator character was given, update the dateSeparator variable
if (dtSep)
dateSeparator = dtSep;
else
dateSeparator = defaultDateSeparator;

// if a date format was given, update the dateFormat variable
if (dtFormat)
dateFormat = dtFormat;
else
dateFormat = defaultDateFormat;

var x = displayBelowThisObject.offsetLeft;
var y = displayBelowThisObject.offsetTop + displayBelowThisObject.offsetHeight ;

// deal with elements inside tables and such
var parent = displayBelowThisObject;
while (parent.offsetParent) {
parent = parent.offsetParent;
x += parent.offsetLeft;
y += parent.offsetTop ;
}

drawDatePicker(targetDateField, x, y);
}

function drawDatePicker(targetDateField, x, y)
{
var dt = getFieldDate(targetDateField.value );

if (!document.getElementById(datePickerDivID)) {
var newNode = document.createElement("div");
newNode.setAttribute("id", datePickerDivID);
newNode.setAttribute("class", "dpDiv");
newNode.setAttribute("style", "visibility: hidden;");
document.body.appendChild(newNode);
}
// move the datepicker div to the proper x,y coordinate and toggle the visiblity
var pickerDiv = document.getElementById(datePickerDivID);
pickerDiv.style.position = "absolute";
pickerDiv.style.left = x + "px";
pickerDiv.style.top = y + "px";
pickerDiv.style.visibility = (pickerDiv.style.visibility == "visible" ? "hidden" : "visible");
pickerDiv.style.display = (pickerDiv.style.display == "block" ? "none" : "block");
pickerDiv.style.zIndex = 10000;

// draw the datepicker table
refreshDatePicker(targetDateField.name, dt.getFullYear(), dt.getMonth(), dt.getDate());
}
/**
This is the function that actually draws the datepicker calendar.
*/
function refreshDatePicker(dateFieldName, year, month, day)
{
// if no arguments are passed, use today's date; otherwise, month and year
// are required (if a day is passed, it will be highlighted later)
var thisDay = new Date();

if ((month >= 0) && (year > 0)) {
thisDay = new Date(year, month, 1);
} else {
day = thisDay.getDate();
thisDay.setDate(1);
}

var crlf = "\r\n";
var TABLE = "<table cols=7 class='dpTable'>" + crlf;
var xTABLE = "</table>" + crlf;
var TR = "<tr class='dpTR'>";
var TR_title = "<tr class='dpTitleTR'>";
var TR_days = "<tr class='dpDayTR'>";
var TR_todaybutton = "<tr class='dpTodayButtonTR'>";
var xTR = "</tr>" + crlf;
var TD = "<td class='dpTD' onMouseOut='this.className=\"dpTD\";' onMouseOver=' this.className=\"dpTDHover\";' "; // leave this tag open, because we'll be adding an onClick event
var TD_title = "<td colspan=5 class='dpTitleTD'>";
var TD_buttons = "<td class='dpButtonTD'>";
var TD_todaybutton = "<td colspan=7 class='dpTodayButtonTD'>";
var TD_days = "<td class='dpDayTD'>";
var TD_selected = "<td class='dpDayHighlightTD' onMouseOut='this.className=\"dpDayHighlightTD\";' onMouseOver='this.className=\"dpTDHover\";' "; // leave this tag open, because we'll be adding an onClick event
var xTD = "</td>" + crlf;
var DIV_title = "<div class='dpTitleText'>";
var DIV_selected = "<div class='dpDayHighlight'>";
var xDIV = "</div>";

// start generating the code for the calendar table
var html = TABLE;

// this is the title bar, which displays the month and the buttons to
// go back to a previous month or forward to the next month
html += TR_title;
html += TD_buttons + getButtonCode(dateFieldName, thisDay, -1, "&lt;") + xTD;
html += TD_title + DIV_title + monthArrayLong[ thisDay.getMonth()] + " " + thisDay.getFullYear() + xDIV + xTD;
html += TD_buttons + getButtonCode(dateFieldName, thisDay, 1, "&gt;") + xTD;
html += xTR;

// this is the row that indicates which day of the week we're on
html += TR_days;
for(i = 0; i < dayArrayShort.length; i++)
html += TD_days + dayArrayShort[i] + xTD;
html += xTR;

// now we'll start populating the table with days of the month
html += TR;

// first, the leading blanks
for (i = 0; i < thisDay.getDay(); i++)
html += TD + " " + xTD;

// now, the days of the month
do {
dayNum = thisDay.getDate();
TD_onclick = " onclick=\"updateDateField('" + dateFieldName + "', '" + getDateString(thisDay) + "');\">";

if (dayNum == day)
html += TD_selected + TD_onclick + DIV_selected + dayNum + xDIV + xTD;
else
html += TD + TD_onclick + dayNum + xTD;

// if this is a Saturday, start a new row
if (thisDay.getDay() == 6)
html += xTR + TR;

// increment the day
thisDay.setDate(thisDay.getDate() + 1);
} while (thisDay.getDate() > 1)

// fill in any trailing blanks
if (thisDay.getDay() > 0) {
for (i = 6; i > thisDay.getDay(); i--)
html += TD + " " + xTD;
}
html += xTR;

// add a button to allow the user to easily return to today, or close the calendar
var today = new Date();
var todayString = "Today is " + dayArrayMed[today.getDay()] + ", " + monthArrayMed[ today.getMonth()] + " " + today.getDate();
html += TR_todaybutton + TD_todaybutton;
html += "<button class='dpTodayButton' onClick='refreshDatePicker(\"" + dateFieldName + "\");'>this month</button> ";
html += "<button class='dpTodayButton' onClick='updateDateField(\"" + dateFieldName + "\");'>close</button>";
html += xTD + xTR;

// and finally, close the table
html += xTABLE;
document.getElementById(datePickerDivID).innerHTML = html;
// add an "iFrame shim" to allow the datepicker to display above selection lists
adjustiFrame();
}
/**
Convenience function for writing the code for the buttons that bring us back or forward
a month.
*/
function getButtonCode(dateFieldName, dateVal, adjust, label)
{
var newMonth = (dateVal.getMonth () + adjust) % 12;
var newYear = dateVal.getFullYear() + parseInt((dateVal.getMonth() + adjust) / 12);
if (newMonth < 0) {
newMonth += 12;
newYear += -1;
}

return "<button class='dpButton' onClick='refreshDatePicker(\"" + dateFieldName + "\", " + newYear + ", " + newMonth + ");'>" + label + "</button>";
}
/**
Convert a JavaScript Date object to a string, based on the dateFormat and dateSeparator
variables at the beginning of this script library.
*/
function getDateString(dateVal)
{
var dayString = "00" + dateVal.getDate();
var monthString = "00" + (dateVal.getMonth()+1);
dayString = dayString.substring(dayString.length - 2);
monthString = monthString.substring(monthString.length - 2);

switch (dateFormat) {
case "dmy" :
return dayString + dateSeparator + monthString + dateSeparator + dateVal.getFullYear();
case "ymd" :
return dateVal.getFullYear() + dateSeparator + monthString + dateSeparator + dayString;
case "mdy" :
default :
return monthString + dateSeparator + dayString + dateSeparator + dateVal.getFullYear();
}
}
/**
Convert a string to a JavaScript Date object.
*/
function getFieldDate(dateString)
{
var dateVal;
var dArray;
var d, m, y;

try {
dArray = splitDateString(dateString);
if (dArray) {
switch (dateFormat) {
case "dmy" :
d = parseInt(dArray[0], 10);
m = parseInt(dArray[1], 10) - 1;
y = parseInt(dArray[2], 10);
break;
case "ymd" :
d = parseInt(dArray[2], 10);
m = parseInt(dArray[1], 10) - 1;
y = parseInt(dArray[0], 10);
break;
case "mdy" :
default :
d = parseInt(dArray[1], 10);
m = parseInt(dArray[0], 10) - 1;
y = parseInt(dArray[2], 10);
break;
}
dateVal = new Date(y, m, d);
} else if (dateString) {
dateVal = new Date(dateString);
} else {
dateVal = new Date();
}
} catch(e) {
dateVal = new Date();
}

return dateVal;
}
/**
Try to split a date string into an array of elements, using common date separators.
If the date is split, an array is returned; otherwise, we just return false.
*/
function splitDateString(dateString)
{
var dArray;
if (dateString.indexOf("/") >= 0)
dArray = dateString.split("/");
else if (dateString.indexOf(".") >= 0)
dArray = dateString.split(".");
else if (dateString.indexOf("-") >= 0)
dArray = dateString.split("-");
else if (dateString.indexOf("\\") >= 0)
dArray = dateString.split("\\");
else
dArray = false;

return dArray;
}

function updateDateField(dateFieldName, dateString)
{
var targetDateField = document.getElementsByName (dateFieldName).item(0);
if (dateString)
targetDateField.value = dateString;

var pickerDiv = document.getElementById(datePickerDivID);
pickerDiv.style.visibility = "hidden";
pickerDiv.style.display = "none";

adjustiFrame();
targetDateField.focus();

if ((dateString) && (typeof(datePickerClosed) == "function"))
datePickerClosed(targetDateField);
}
function adjustiFrame(pickerDiv, iFrameDiv)
{
var is_opera = (navigator.userAgent.toLowerCase().indexOf("opera") != -1);
if (is_opera)
return;

// put a try/catch block around the whole thing, just in case
try {
if (!document.getElementById(iFrameDivID)) {
var newNode = document.createElement("iFrame");
newNode.setAttribute("id", iFrameDivID);
newNode.setAttribute("src", "javascript:false;");
newNode.setAttribute("scrolling", "no");
newNode.setAttribute ("frameborder", "0");
document.body.appendChild(newNode);
}

if (!pickerDiv)
pickerDiv = document.getElementById(datePickerDivID);
if (!iFrameDiv)
iFrameDiv = document.getElementById(iFrameDivID);

try {
iFrameDiv.style.position = "absolute";
iFrameDiv.style.width = pickerDiv.offsetWidth;
iFrameDiv.style.height = pickerDiv.offsetHeight ;
iFrameDiv.style.top = pickerDiv.style.top;
iFrameDiv.style.left = pickerDiv.style.left;
iFrameDiv.style.zIndex = pickerDiv.style.zIndex - 1;
iFrameDiv.style.visibility = pickerDiv.style.visibility ;
iFrameDiv.style.display = pickerDiv.style.display;
} catch(e) {
}

} catch (ee) {
}

}
</script>
<style>
body {
font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
font-size: .8em;
}
/* the div that holds the date picker calendar */
.dpDiv {
}
/* the table (within the div) that holds the date picker calendar */
.dpTable {
font-family: Tahoma, Arial, Helvetica, sans-serif;
font-size: 12px;
text-align: center;
color: #505050;
background-color: #ece9d8;
border: 1px solid #AAAAAA;
}
/* a table row that holds date numbers (either blank or 1-31) */
.dpTR {
}
/* the top table row that holds the month, year, and forward/backward buttons */
.dpTitleTR {
}
/* the second table row, that holds the names of days of the week (Mo, Tu, We, etc.) */
.dpDayTR {
}
/* the bottom table row, that has the "This Month" and "Close" buttons */
.dpTodayButtonTR {
}
/* a table cell that holds a date number (either blank or 1-31) */
.dpTD {
border: 1px solid #ece9d8;
}
/* a table cell that holds a highlighted day (usually either today's date or the current date field value) */
.dpDayHighlightTD {
background-color: #CCCCCC;
border: 1px solid #AAAAAA;
}
/* the date number table cell that the mouse pointer is currently over (you can use contrasting colors to make it apparent which cell is being hovered over) */
.dpTDHover {
background-color: #aca998;
border: 1px solid #888888;
cursor: pointer;
color: red;
}
/* the table cell that holds the name of the month and the year */
.dpTitleTD {
}
/* a table cell that holds one of the forward/backward buttons */
.dpButtonTD {
}
/* the table cell that holds the "This Month" or "Close" button at the bottom */
.dpTodayButtonTD {
}
/* a table cell that holds the names of days of the week (Mo, Tu, We, etc.) */
.dpDayTD {
background-color: #CCCCCC;
border: 1px solid #AAAAAA;
color: white;
}
/* additional style information for the text that indicates the month and year */
.dpTitleText {
font-size: 12px;
color: gray;
font-weight: bold;
}
/* additional style information for the cell that holds a highlighted day (usually either today's date or the current date field value) */ 
.dpDayHighlight {
color: 4060ff;
font-weight: bold;
}
/* the forward/backward buttons at the top */
.dpButton {
font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
font-size: 10px;
color: gray;
background: #d8e8ff;
font-weight: bold;
padding: 0px;
}
/* the "This Month" and "Close" buttons at the bottom */
.dpTodayButton {
font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
font-size: 10px;
color: gray;
background: #d8e8ff;
font-weight: bold;
}

</style>
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
            String id = (String)request.getAttribute("id");
            String no = (String)request.getAttribute("no");
            String nm = (String)request.getAttribute("nm");
            String de = (String)request.getAttribute("de");
            if(id!=null){
         %>
        <form action="Update_PartMaster" method="post">
            <input type="hidden" name="txtpid" value="<%=id%>" />
            <table>
                    <tr>
                        <td><label for="PartNO">PartNO:</label></td>
                        <td><input type="integer" name="partno" id="" style="width:200px;height:30px;" required pattern="[A-Za-z0-9]{1,10}"/></td>
                    </tr>                    
                    <tr>
                        <td><label for="PartName">PartName:</label></td>
                        <td><input type="text" name="partname" id=""  style="width:200px;height:30px;" required pattern="[A-Za-z]{1,20}"/></td>
                    </tr>                    
                    <tr>
                        <td><label for="Description">Description:</label></td>
                        <td><input type="text" name="description" id=""  style="width:200px;height:30px;" required pattern="[A-Za-z]{1,20}"/></td>
                    </tr>  
                    <tr>
                        <td> </td>    
                        <td> <input type="submit" value="Update"/></td>
                        <td> </td>    
                    </tr>               
         </form>
        <%
            }
            else{
        %>   
         <form action="Insert_PartMaster" method="post">
            <table>
                    <tr>
                        <td><label for="PartNO">PartNO:</label></td>
                        <td><input type="integer" name="PartNo" id=""  style="width:200px;height:30px;" required pattern="[A-Za-z0-9]{1,10}"/></td>
                    </tr>                    
                    <tr>
                        <td><label for="PartName">PartName:</label></td>
                        <td><input type="text" name="PartName" id=""  style="width:200px;height:30px;" required pattern="[A-Za-z]{1,20}"/></td>
                    </tr>                    
                    <tr>
                        <td><label for="Description">Description:</label></td>
                        <td><input type="text" name="Description" id=""  style="width:200px;height:30px;" required pattern="[A-Za-z]{1,20}"/></td>
                    </tr>                 
                    <tr>
                        <td> </td>    
                        <td> <input type="submit" value="Insert"/></td>
                        <td> </td>    
                    </tr>                    
                   </table>
         </form>
        <br>
        <table border="1">
            <tr>
                <td>Partid</td>
                <td>PartNo</td>
                <td>PartName</td>
                <td>Description</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <%
                ArrayList<PartMaster_Bean> acoublist = (ArrayList<PartMaster_Bean>)request.getAttribute("part");
                if(acoublist!=null)
                {
                    Iterator<PartMaster_Bean> itr = acoublist.iterator();
                    while(itr.hasNext()){
                        PartMaster_Bean cb = (PartMaster_Bean)itr.next();
                        String pid = cb.getPartid();
                        String pno = cb.getPartNo();
                        String pname = cb.getPartName();
                        String des = cb.getDescription();
            %>
            <tr>
                <td><%=pid%></td>
                <td><%=pno%></td>
                <td><%=pname%></td>
                <td><%=des%></td>
                <td><a href="Edit_PartMaster?pid=<%=pid%>&pno=<%=pno%>&pname=<%=pname%>&des=<%=des%>">Edit</a></td>
                <td><a href="Delete_PartMaster?pid=<%=pid%>">Delete</a></td>
            </tr>
            <%
                    }
                }
            }
            %>
        </table>       
</div>
</div>
</div><!--Center Content -->
<div class="clear"></div>            
</div> <!--end of main content-->
<div class="footer"> <div class="right_footer"></div> </div>

</div><!--Main Container -->		
</body>
</html>