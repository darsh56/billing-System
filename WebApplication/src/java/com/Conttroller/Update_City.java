
package com.Conttroller;

import com.Bean.City_Bean;
import com.Model.DBmethod;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update_City extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            System.out.println("This is Updateservlet");
            
            String cid = request.getParameter("txtcid");
            String sid = request.getParameter("selstate");
            String cnm = request.getParameter("txtcitynm");
            
            City_Bean cb = new City_Bean();
            cb.setCity_id(cid);
            cb.setState_id(sid);
            cb.setCity_Name(cnm);
            DBmethod imp = new DBmethod();
            boolean b = imp.IsUpdateCity(cb);            
            if(b){
                 RequestDispatcher rd = request.getRequestDispatcher("./Select_City_Conttroller");
                 rd.forward(request, response);
                 }
            else{
                System.out.println("Record Not Updated");
                }
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
