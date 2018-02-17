package com.Conttroller;

import com.Bean.Retail_Bean;
import com.Model.DBDCNForm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert_Retail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       try{
             
            String invno = request.getParameter("invoiceno");
            System.out.println("Invoice No:"+invno);
            
            String dcno = request.getParameter("dcnno1");
            System.out.println("DCN No:"+dcno);
            
            String cname = request.getParameter("compname");
            System.out.println("Company Name:"+cname);
            
            String invdate = request.getParameter("InvoiceDate");
            System.out.println("Invoice Date:"+invdate);
            
            String beno = request.getParameter("beno");
            System.out.println("BE No:"+beno);
            
            String ccharge = request.getParameter("couriercharge");
            System.out.println("Courier Charge:"+ccharge);
            
            String bedate = request.getParameter("BeDate");
            System.out.println("Be Date:"+bedate);
            
            String tamount = request.getParameter("totalamount");
            System.out.println("Total Amount:"+tamount);
            
            String trchno = request.getParameter("trchno");
            System.out.println("Tr.Ch.No:"+trchno);
            
            String ftype = request.getParameter("Form Type");
            System.out.println("Form Type:"+ftype);
            
            String tcdate = request.getParameter("Tr.Ch.Date");
            System.out.println("Tr.Ch.Date:"+tcdate);
            
            String cst1 = request.getParameter("cst1");
            System.out.println("Cst:"+cst1);
            
            String cst2 = request.getParameter("cst2");
            System.out.println("Cst:"+cst2);
                        
            String addduty = request.getParameter("addduty");
            System.out.println("Add Duty:"+addduty);
            
            String addamount = request.getParameter("addamount");
            System.out.println("Add Amount:"+addamount);
            
            String roundoff = request.getParameter("roundoff");
            System.out.println("Round off:"+roundoff);
            
            String netamount = request.getParameter("netamount");
            System.out.println("Net Amount:"+netamount);
            
            String nword = request.getParameter("netword");
            System.out.println("Netword:"+nword);

            
            Retail_Bean rb = new Retail_Bean();
            rb.setRetailno(invno);
            rb.setDcno(dcno);
            rb.setClient_id(cname);
            rb.setInvodate(invdate);
            rb.setBeno(beno);
            rb.setCourchar(ccharge);
            rb.setBedate(bedate);
            rb.setTotamo(tamount);
            rb.setTrchno(trchno);
            rb.setFormtype(ftype);
            rb.setTrchdate(tcdate);
            rb.setCst1_vat1(cst1);
            rb.setCst2_vat2(cst2);
            rb.setAddduty(addduty);
            rb.setAffamount(addamount);
            rb.setRdoff(roundoff);
            rb.setNetamount(netamount);
            rb.setNetamword(nword);

            DBDCNForm.insertRetail(rb);
            request.getRequestDispatcher("Invoice.jsp").forward(request, response);
        }
       catch(Exception e)
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
