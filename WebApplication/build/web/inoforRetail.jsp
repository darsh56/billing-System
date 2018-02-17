<%-- 
    Document   : inoforRetail
    Created on : Apr 10, 2015, 12:09:11 PM
    Author     : navkar
--%>

<%@page import="com.Bean.Retail_Bean"%>
<%@page import="com.Bean.Tax_Bean"%>
<%@page import="com.Bean.Job_Bean"%>
<%@page import="com.Model.DBDCNForm"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DBactivation"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<html>
    <head>  
    </head>
<body>
    
<%
String ftype=request.getParameter("count");  
System.out.println("Form Type: "+ftype); 
 String buffer="<select name='InvoiceNo'><option value='-1'>Select Invoice Number.</option>";  
 try{
 Connection conn=DBactivation.getConnection();
 Statement stmt=conn.createStatement();  
 ResultSet rs = stmt.executeQuery("select Retailno from retailinvoice where Formtype='"+ftype+"'");  
 while(rs.next()){
 buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";  
 }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }
%>
</body>
</html>