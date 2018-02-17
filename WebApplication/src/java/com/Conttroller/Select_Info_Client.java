
package com.Conttroller;

import com.Bean.ClientForm_Bean;
import com.Bean.State_Bean;
import com.Bean.City_Bean;
import com.Model.DBclientinfo;
import com.Model.DBmethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author navkar
 */
public class Select_Info_Client extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            String cn = null ;
            String a = null;
            String s = null;
            String c = null;
            String p = null;
            String ph =null;
            String f = null;
            String eid= null;
            String t = null;
            String v = null;
            String pd = null;
            String sc = null;
            String sd = null;
            
        try
        {
            ClientForm_Bean cf = new ClientForm_Bean();
            cf.getClient_id();
            cf.getCompany_Name();
           /* cf.getAddress();
            cf.getState();
            cf.getCity();
            cf.getPincode();
            cf.getPhoneNo();
            cf.getFax();*/
            cf.getEmailid();
            /*cf.getTinNo();
            cf.getVatNo();*/
            cf.getPolicy_Deal_Days();
            /*cf.getSTC_code();
            cf.getSTC_Date();*/
            DBclientinfo o = new DBclientinfo();
            ArrayList info = o.getInfo();            
            System.out.println("returned successfully");
            if(info!=null)
            {
            request.setAttribute("clientinfo",info);
            request.getRequestDispatcher("ClientForm.jsp").forward(request, response);
            }
            else
            {
                System.out.println("Record Not View");
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
