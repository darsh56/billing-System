<%-- 
    Document   : ShowPONO
    Created on : Mar 7, 2015, 12:13:01 PM
    Author     : navkar
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DBactivation"%>
<%
String cnm = request.getParameter("st");
System.out.println("Company Name: " +cnm); 
 String buffer="<select name='PO_NO' onchange='showdata(this.value)'><option value='-1'>PO NO</option>";  
 try{
 Connection conn=DBactivation.getConnection();
 Statement stmt=conn.createStatement();  
 ResultSet rs = stmt.executeQuery("SELECT PO_No FROM purchase_details WHERE Client_id='"+cnm+"'");  
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
