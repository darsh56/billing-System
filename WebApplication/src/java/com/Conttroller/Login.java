package com.Conttroller;

import com.Bean.Login_Bean;
import com.Model.DBmethod;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String unm = request.getParameter("txtusername");
        String upass = request.getParameter("txtpass");
        
        try {
                Login_Bean lb = new Login_Bean();
                lb.setUsername(unm);
                lb.setPassword(upass);
            
                 DBmethod dbm = new DBmethod();
                 boolean b = dbm.isAutho(lb);
            
                if(b)
                {
                HttpSession sess = request.getSession();
                sess.setAttribute("UserName", unm);
                response.sendRedirect("Admin_Page.jsp");
                }
                /*else 
                {
                response.sendRedirect("Login.jsp");
                }*/
                
                boolean bs = dbm.isStaff(lb);
                if(bs)
                {
                HttpSession sess = request.getSession();
                sess.setAttribute("UserName", unm);
                response.sendRedirect("Staff_Page.jsp");
                }
                else 
                {
                response.sendRedirect("Login.jsp");
                }
        }
        catch(Exception e)
        {
            System.out.println(""+e);
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
