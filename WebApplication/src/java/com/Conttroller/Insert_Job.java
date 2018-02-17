package com.Conttroller;

import com.Bean.Job_Bean;
import com.Model.DBDCNForm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert_Job extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       try{
             
            String jno = request.getParameter("jobno");
            System.out.println("Job No:"+jno);
            
            String dcnno = request.getParameter("dcnno");
            System.out.println("Job No:"+dcnno);
            
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
            
            String sertax1 = request.getParameter("sertax1");
            System.out.println("ServiceTax1:"+sertax1);
            
            String sertax2 = request.getParameter("sertax2");
            System.out.println("ServiceTax2:"+sertax2);
            
            String tcdate = request.getParameter("Tr.Ch.Date");
            System.out.println("Tr.Ch.Date:"+tcdate);
            
            String cess1 = request.getParameter("Educess1");
            System.out.println("Cst:"+cess1);
            
            String cess2 = request.getParameter("Educess2");
            System.out.println("Cst:"+cess2);
                        
            String addduty = request.getParameter("addduty");
            System.out.println("Add Duty:"+addduty);
            
            String hicess1 = request.getParameter("HiEducess1");
            System.out.println("Cst:"+hicess1);
            
            String hicess2 = request.getParameter("HiEducess2");
            System.out.println("Cst:"+hicess2);
            
            String affamount = request.getParameter("Affamount");
            System.out.println("Aff Amount:"+affamount);
            
            String roundoff = request.getParameter("roundoff");
            System.out.println("Round off:"+roundoff);
            
            String netamount = request.getParameter("netamount");
            System.out.println("Net Amount:"+netamount);
            
            String netword = request.getParameter("netword");
            System.out.println("NetWord:"+netword);
            
            Job_Bean rb = new Job_Bean();
            rb.setJobno(jno);
            rb.setDcno(dcnno);
            rb.setCompName(cname);
            rb.setInvodate(invdate);
            rb.setBeno(beno);
            rb.setCourchar(ccharge);
            rb.setBedate(bedate);
            rb.setTotamo(tamount);
            rb.setTrchno(trchno);
            rb.setSertax1(sertax1);
            rb.setSertax2(sertax2);
            rb.setTrchdate(tcdate);
            rb.setEducess1(cess1);
            rb.setEducess2(cess2);
            rb.setAddduty(addduty);
            rb.setHieducess1(hicess1);
            rb.setHieducess2(hicess2);
            rb.setAffamount(affamount);
            rb.setRdoff(roundoff);
            rb.setNetamount(netamount);
            rb.setNetamword(netword);
            
            DBDCNForm.insertJob(rb);
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
