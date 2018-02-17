
package com.Conttroller;
import com.Bean.PurchaseOrderLines_Bean;
import com.Bean.PurchaseDetails_Bean;
import com.Model.DBPurchaseOrderForm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author navkar
 */
public class Insert_PurchaseDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String pono = request.getParameter("PO_No");
            System.out.println("PO_No:"+pono);
            
            String cname = request.getParameter("CompanyName");
            System.out.println("CompanyName:"+cname);
            
            String date= request.getParameter("Date");
            System.out.println("Date:"+date);
            
            String pono1 = request.getParameter("PO_No");            
            System.out.println("PO_No:"+pono1);
            
            int sno =Integer.parseInt(request.getParameter("Serial_No"));            
            System.out.println("Serial_No:"+sno);
            
            String pname = request.getParameter("seldesc");            
            System.out.println("PartName:"+pname);
            
            String des= request.getParameter("selenm");
            System.out.println("Description:"+des);
            
            int lno =Integer.parseInt(request.getParameter("Line_NO"));
            System.out.println("Line_No:"+lno);
            
            String duedate = request.getParameter("DueDate");
            System.out.println("DueDate:"+duedate);
            
            int qua=Integer.parseInt(request.getParameter("Quantity"));
            System.out.println("Quantity:"+qua);
            
            int rate=Integer.parseInt(request.getParameter("Rate"));
            System.out.println("Rate:"+rate);
            
            int amount=Integer.parseInt(request.getParameter("Amount"));
            System.out.println("Amount:"+amount);
            
            PurchaseDetails_Bean pb = new PurchaseDetails_Bean();
            pb.setPO_No(pono);
            pb.setClient_id(cname);
            pb.setDate(date);
            DBPurchaseOrderForm.insertpurchaseDetails(pb);
            
            PurchaseOrderLines_Bean polb = new PurchaseOrderLines_Bean();            
            polb.setPO_No(pono1);
            polb.setSerial_No(sno);
            polb.setPart_Name(pname);
            polb.setDescription(des);
            polb.setLine_No(lno);
            polb.setDueDate(duedate);
            polb.setQuantity(qua);
            polb.setRate(rate);
            polb.setAmount(amount);
            DBPurchaseOrderForm.insertpurchaseOrderLines(polb);
            
            RequestDispatcher rd = request.getRequestDispatcher("Purchase_Order_Form.jsp");
            rd.forward(request, response);
           
        }catch(Exception e)
        {
            out.println("Exception is:"+e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
