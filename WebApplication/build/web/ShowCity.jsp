<%-- 
    Document   : ShowState
    Created on : Dec 18, 2014, 12:42:04 PM
    Author     : TP
--%>

<%@page import="com.Model.DBactivation"%>
<%@page import="java.sql.*"%>
<%
String sid = request.getParameter("st");
System.out.println("State id : " +sid); 
 String buffer="<select name='selenm'><option value='-1'>Select City</option>";  
 try{
 Connection conn=DBactivation.getConnection();
  Statement stmt=conn.createStatement();  
 ResultSet rs = stmt.executeQuery("SELECT City_id,City_Name FROM city_entry WHERE State_id='"+sid+"'");  
   while(rs.next()){
   buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>";  
   }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }
 %>
