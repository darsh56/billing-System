/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Conttroller;

import com.Bean.ClientForm_Bean;
import com.Bean.State_Bean;
import com.Model.DBclientinfo;
import com.Model.DBmethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author navkar
 */
public class Update_Info_Client extends HttpServlet {
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String cid = request.getParameter("companyid");           
            String cn = request.getParameter("Company_Name");
            /*String a = request.getParameter("Address");
            String s = request.getParameter("selstate");
            String c = request.getParameter("selenm");
            String p = request.getParameter("Pincode");
            String ph = request.getParameter("PhoneNo");
            String f = request.getParameter("Fax");*/
            String eid= request.getParameter("Emailid");
           /* String t = request.getParameter("TinNo");
            String v = request.getParameter("VatNo");*/
            String pd = request.getParameter("Policy_Deal_Days");
            /*String sc = request.getParameter("STC_code");
            String sd = request.getParameter("STCdate");*/
            ClientForm_Bean cf = new ClientForm_Bean();
            cf.setClient_id(cid);
            cf.setCompany_Name(cn);
           /* cf.setAddress(a);
            cf.setState(s);
            cf.setCity(c);
            cf.setPincode(p);
            cf.setPhoneNo(ph);
            cf.setFax(f);*/
            cf.setEmailid(eid);
           /* cf.setTinNo(t);
            cf.setVatNo(v);*/
            cf.setPolicy_Deal_Days(pd);
            /*cf.setSTC_code(sc);
            cf.setSTC_Date(sd);*/
            System.out.println(cid+" "+cn+" "+eid+" "+pd);
            DBclientinfo obj = new DBclientinfo();
            boolean b = obj.updateInfo(cf);
            if(b){
                 RequestDispatcher rd = request.getRequestDispatcher("./Select_Info_Client");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Update_Info_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Update_Info_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
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
