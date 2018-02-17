<%-- 
    Document   : Showdcn
    Created on : Mar 13, 2015, 12:37:26 PM
    Author     : navkar
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DBactivation"%>
<%
String it = request.getParameter("st");
System.out.println("Invoice Type: " +it); 
 String buffer="<select name='DCN_No'><option value='-1'>DCNNo</option>";  
 try{
 Connection conn=DBactivation.getConnection();
 Statement stmt=conn.createStatement();  
 ResultSet rs = stmt.executeQuery("SELECT Dcno FROM challninvoice WHERE Invoicetype='"+it+"'");  
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
