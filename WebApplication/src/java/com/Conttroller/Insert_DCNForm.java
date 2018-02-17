package com.Conttroller;

import com.Bean.DCNForm_Bean;
import com.Model.DBDCNForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert_DCNForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            String dcno = request.getParameter("DCN_No");
            System.out.println("DCN NO:"+dcno);
            
            String pono = request.getParameter("PO_NO");
            System.out.println("PO NO:"+pono);
            
            String it = request.getParameter("I_Type");
            System.out.println("Invoice Type:"+it);
            
            String dcnd = request.getParameter("Date");
            System.out.println("DCN Date:"+dcnd);
            
            String cn = request.getParameter("CompanyName");
            System.out.println("Company Name:"+cn);
            
            String en = request.getParameter("Exicechano");
            System.out.println("Exicechano:"+en);

            String ed = request.getParameter("Exicedate");
            System.out.println("Exicedate:"+ed);
            
            String partn = request.getParameter("Part_Name");
            System.out.println("Part_NO:"+partn);
            
            String des = request.getParameter("Decription");
            System.out.println("Decription:"+des);

            String qua = request.getParameter("Quantity");
            System.out.println("Quantity:"+qua);
            
            String rate = request.getParameter("Rate");
            System.out.println("Rate:"+rate);
            
            String amou = request.getParameter("Amount");
            System.out.println("Amount:"+amou);            
                       
            System.out.println("DCN NO="+dcno);
            System.out.println(pono);
            System.out.println(it);
            System.out.println(dcnd);
            System.out.println(cn);
            System.out.println(en);
            System.out.println(ed);
            System.out.println(partn);
            System.out.println(des);
            System.out.println(qua);
            System.out.println(rate);
            System.out.println(amou);
          
                           
            DCNForm_Bean df = new DCNForm_Bean();
            df.setDcno(dcno);
            df.setInvoicetype(it);
            df.setComname(cn);
            df.setDcndate(dcnd);
            df.setPono(pono);
            df.setPartname(partn);
            df.setDesc(des);
            df.setQut(qua);
            df.setRate(rate);
            df.setAmount(amou);
            df.setExicechano(en);
            df.setExicedate(ed);
            
            DBDCNForm.insertdcndetails(df);
            request.getRequestDispatcher("Select_DCN").forward(request, response);
        }
        catch(Exception e)
        {
            out.println("Exception is:"+e);
        }
  }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
