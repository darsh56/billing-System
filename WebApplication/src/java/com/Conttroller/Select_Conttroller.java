
package com.Conttroller;

import com.Bean.State_Bean;
import static com.Model.DBactivation.con;
import com.Model.DBmethod;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author navkar
 */
public class Select_Conttroller extends HttpServlet 
{
    private ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();                   
        try
        {            
            State_Bean ub = new State_Bean();
            System.out.println("coming to selectconttroller");
            ArrayList<State_Bean> state=DBmethod.getstate();
            System.out.println("returned successfully");
            if(state!=null)
            {
            request.setAttribute("statedata",state);
            request.getRequestDispatcher("Add_State.jsp").forward(request, response);
            }
            else
            {
                System.out.println("Record Not View");
            }             
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
