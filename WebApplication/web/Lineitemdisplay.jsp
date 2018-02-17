<%-- 
    Document   : Lineitemdisplay
    Created on : Mar 12, 2015, 6:12:14 PM
    Author     : navkar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.Bean.PurchaseOrderLines_Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <table border="1" id="ord_no">
             <tr>
                            <!--<td><input type="Button" value="Select"</td>-->  
                <td>Select</td>
                <td>PO_NO</td> 
                <td>Serial_No</td>
                <td>Part_Name</td>
                <td>Decription</td>                
                <td>Line_No</td> 
                <td>Quantity</td>
                <td>Rate</td>
                <td>Duedate</td>
                <td>Amount</td>                
            </tr>  
             <%
                ArrayList<PurchaseOrderLines_Bean> cn = (ArrayList<PurchaseOrderLines_Bean>)request.getAttribute("lineitem");
                if(cn!=null)
                {
                    Iterator itr = cn.iterator();
                    while(itr.hasNext())
                    {
                        PurchaseOrderLines_Bean cn1= (PurchaseOrderLines_Bean)itr.next();   
                        
                                String pono = cn1.getPO_No();
                                int sno = cn1.getSerial_No();
                                String partname = cn1.getPart_Name();
                                String des = cn1.getDescription();
                                int lno = cn1.getLine_No();
                                int qua = cn1.getQuantity();
                                int rate = cn1.getRate();
                                String date = cn1.getDueDate();
                                int amount = cn1.getAmount();
             %>
              <tr>
                <td><a href="#" onclick="edit(this)">select</a></td>  
                <td style="text-align: center;"><%=pono%></td> 
                <td style="text-align: center;"><%=sno%></td>
                <td style="text-align: center;"><%=partname%></td>
                <td style="text-align: center;"><%=des%></td>                
                <td style="text-align: center;"><%=lno%></td> 
                <td style="text-align: center;"><%=qua%></td>
                <td style="text-align: center;"><%=rate%></td>
                <td style="text-align: center;"><%=date%></td>  
                <td style="text-align: center;"><%=amount%></td>
            </tr>  
             
            <%
                    }
                }
            
            %>     
           </table>
                    
    </body>
</html>
