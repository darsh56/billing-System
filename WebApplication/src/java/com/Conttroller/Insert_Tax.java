package com.Conttroller;

import com.Bean.Tax_Bean;
import com.Model.DBDCNForm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert_Tax extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       try{
             
            String taxno = request.getParameter("Taxno");
            System.out.println("Tax No:"+taxno);
            
            String Dcnno = request.getParameter("dcnno");
            System.out.println("DCNNo:"+Dcnno);
            
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
            
            String vat1 = request.getParameter("vat1");
            System.out.println("Vat1:"+vat1);
            
            String vat2 = request.getParameter("vat2");
            System.out.println("Vat2:"+vat2);
            
            String tcdate = request.getParameter("Tr.Ch.Date");
            System.out.println("Tr.Ch.Date:"+tcdate);
            
            String addvat1 = request.getParameter("addvat1");
            System.out.println("ADDVat1:"+addvat1);
            
            String addvat2 = request.getParameter("addvat2");
            System.out.println("ADDVat2:"+addvat2);
                        
            String addduty = request.getParameter("addduty");
            System.out.println("Add Duty:"+addduty);
            
            String affamount = request.getParameter("affamount");
            System.out.println("Aff Amount:"+affamount);
            
            String roundoff = request.getParameter("roundoff");
            System.out.println("Round off:"+roundoff);
            
            String netamount = request.getParameter("netamount");
            System.out.println("Net Amount:"+netamount);
            
            String netword = request.getParameter("netword");
            System.out.println("Net Word:"+netword);
            
            Tax_Bean rb = new Tax_Bean();
            rb.setTaxno(taxno);
            rb.setDcno(Dcnno);
            rb.setCompName(cname);
            rb.setInvodate(invdate);
            rb.setBeno(beno);
            rb.setCourchar(ccharge);
            rb.setBedate(bedate);
            rb.setTotamo(tamount);
            rb.setTrchno(trchno);
            rb.setVat1(vat1);
            rb.setVat2(vat2);
            rb.setTrchdate(tcdate);
            rb.setAddvat1(addvat1);
            rb.setAddvat2(addvat2);
            rb.setAddduty(addduty);
            rb.setAffamount(affamount);
            rb.setRdoff(roundoff);
            rb.setNetamount(netamount);
            rb.setNetamword(netword);
            
            DBDCNForm.insertTax(rb);
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
