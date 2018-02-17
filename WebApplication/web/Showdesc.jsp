<%-- 
    Document   : Showdesc
    Created on : Feb 6, 2015, 11:27:03 AM
    Author     : navkar
--%>

<%@page import="com.Model.DBactivation"%>
<%@page import="java.sql.*"%>
<%
String pid = request.getParameter("st");
System.out.println("Partid : " +pid); 
 String buffer="";  
 try
 {
 Connection conn=DBactivation.getConnection();
  Statement stmt=conn.createStatement();  
 ResultSet rs = stmt.executeQuery("SELECT Description FROM partmaster WHERE Partid='"+pid+"'");  
   while(rs.next())
   {
   buffer = buffer+"<input type='integer' name='selenm' size=30 value ='"+rs.getString(1) +"'>" ; 
   }  
 buffer=buffer;  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }
 %>
