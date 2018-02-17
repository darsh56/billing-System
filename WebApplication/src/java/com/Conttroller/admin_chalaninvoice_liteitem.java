package com.Conttroller;

import com.Bean.PurchaseOrderLines_Bean;
import com.Model.DBDCNForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_chalaninvoice_liteitem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String item = request.getParameter("dcn");
        System.out.println("Item : " +item);
        try
        {
                   
                            DBDCNForm adpii = new DBDCNForm();
                            ArrayList<PurchaseOrderLines_Bean> apob = adpii.getDCN(item);
                           
                            if(apob!=null){
                                request.setAttribute("lineitem", apob);
                                RequestDispatcher rd = request.getRequestDispatcher("Lineitemdisplay.jsp");
                                rd.forward(request, response);
                            }
                            else{
                                request.setAttribute("lineitem", "Record not display");
                                RequestDispatcher rd = request.getRequestDispatcher("Lineitemdisplay.jsp");
                                rd.forward(request, response);
                            }
                    
        }
        catch(Exception e)
        {
                        out.println(e);
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
