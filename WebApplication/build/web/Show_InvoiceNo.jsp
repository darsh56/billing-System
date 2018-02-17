<%-- 
    Document   : Show_InvoiceNo
    Created on : Mar 28, 2015, 11:36:12 AM
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
 String Invoicetype=request.getParameter("count");  
 String buffer="<select name='InvoiceNo'><option value='-1'>Select Invoice Number.</option>";  
 try{
    if(Invoicetype.equals("JobWork"))
       {
                DBDCNForm impl=new DBDCNForm();
                ArrayList<Job_Bean> poid=impl.get_Invoice_Type_Jobwork();  
                System.out.println("poid="+poid);
                if(!poid.isEmpty()){
                    Iterator<Job_Bean> pitr=poid.iterator();
                    while(pitr.hasNext()){
                        Job_Bean pdet=(Job_Bean)pitr.next();
                         String pod=pdet.getJobno();
                        buffer+="<option value='"+pod+"'>"+pod+"</option>";
                    }
                }
                buffer=buffer+"</select>"; 
                response.getWriter().println(buffer); 
        }
       else if(Invoicetype.equals("Tax"))
               {
                DBDCNForm impl=new DBDCNForm();
                ArrayList<Tax_Bean> poid=impl.get_Invoice_Type_Tax();  
                System.out.println("poid="+poid);
                if(!poid.isEmpty()){
                    Iterator<Tax_Bean> pitr=poid.iterator();
                    while(pitr.hasNext()){
                        Tax_Bean pdet=(Tax_Bean)pitr.next();
                         String pod=pdet.getTaxno();
                        buffer+="<option value='"+pod+"'>"+pod+"</option>";
                    }
                }
                buffer=buffer+"</select>"; 
                response.getWriter().println(buffer); 
              }
          /*else if(Invoicetype.equals("Retail"))
              {
                DBDCNForm impl=new DBDCNForm();
                ArrayList<Retail_Bean> poid=impl.get_Invoice_Type_Retails();  
                System.out.println("poid="+poid);
                if(!poid.isEmpty()){
                    Iterator<Retail_Bean> pitr=poid.iterator();
                    while(pitr.hasNext()){
                        Retail_Bean pdet=(Retail_Bean)pitr.next();
                         String pod=pdet.getRetailno();
                        buffer+="<option value='"+pod+"'>"+pod+"</option>";
                    }
                }
                buffer=buffer+"</select>"; 
                response.getWriter().println(buffer); 
              }*/
          else
           {
                System.out.println("Select Invoice Type is not found");
          }
       }
           
 catch(Exception e){
     out.println(e);
 }

 %>
    </body>
 </html>