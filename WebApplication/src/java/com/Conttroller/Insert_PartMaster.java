
package com.Conttroller;

import com.Bean.PartMaster_Bean;
import com.Model.DBPurchaseOrderForm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author navkar
 */
public class Insert_PartMaster extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("This is servlet");
        
       try {
            String pono = request.getParameter("PartNo");
            System.out.println("PartNo:"+pono);
            
            String pname = request.getParameter("PartName");
            System.out.println("PartName:"+pname);

            String des = request.getParameter("Description");
            System.out.println("Description:"+des);

            PartMaster_Bean pmb = new PartMaster_Bean(); 
            pmb.setPartNo(pono);
            pmb.setPartName(pname);
            pmb.setDescription(des);            
            boolean b = DBPurchaseOrderForm.insertpartmaster(pmb);
            request.getRequestDispatcher("./Select_PartMaster").forward(request, response);
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
