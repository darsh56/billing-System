
package com.Conttroller;

import com.Bean.ClientForm_Bean;
import com.Bean.State_Bean;
import com.Model.DBclientinfo;
import com.Model.DBmethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author navkar
 */
public class Insert_Info_Client extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try{
            String cn = request.getParameter("Company_Name");
            System.out.println("Company Name : " +cn);
            
            String a = request.getParameter("Address");
            System.out.println("Address:"+a);
            
            String s = request.getParameter("selstate");
            System.out.println("State:"+s);
            
            String c = request.getParameter("selenm");
            System.out.println("City:"+c);
            
            String p = request.getParameter("Pincode");
            System.out.println("Pincode:"+p);
            
            String ph = request.getParameter("PhoneNo");
            System.out.println("PhoneNo:"+ph);
            
            String f = request.getParameter("Fax");
            System.out.println("Fax:"+f);
            
            String eid= request.getParameter("Emailid");
            System.out.println("Emailid:"+eid);
            
            String t = request.getParameter("TinNo");
            System.out.println("TinNo:"+t);
            
            String v = request.getParameter("VatNo");
            System.out.println("VatNo:"+v);
            
            String pd = request.getParameter("Policy_Deal_Days");
            System.out.println("Policy_Deal_Days:"+pd);
            
            String sc = request.getParameter("STC_code");
            System.out.println("STC_code:"+sc);
            
            String sd = request.getParameter("STCdate");
            System.out.println("STC_Date:"+sd);  
            
            final String user = "bansarimpatel97@gmail.com";//change accordingly
            final String pass = "bmp240236";
            String subject = "Conform";
            String msg = "Your Information store in our database";
            
            //1st step) Get the session object	
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");//change accordingly
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
            try {
                ClientForm_Bean cf = new ClientForm_Bean();
            cf.setCompany_Name(cn);
            cf.setAddress(a);
            cf.setState(s);
            cf.setCity(c);
            cf.setPincode(p);
            cf.setPhoneNo(ph);
            cf.setFax(f);
            cf.setEmailid(eid);
            cf.setTinNo(t);
            cf.setVatNo(v);
            cf.setPolicy_Deal_Days(pd);
            cf.setSTC_code(sc);
            cf.setSTC_Date(sd);
            boolean b = DBclientinfo.insertInfo(cf);
            if(b){
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(eid));
            message.setSubject(subject);
            message.setText(msg);

            //3rd step)send message
            Transport transport = session.getTransport("smtp");
            Transport.send(message);
            transport.connect(user, pass);
            System.out.println("Done");
            request.getRequestDispatcher("./Select_Info_Client").forward(request, response);
            }
            else{
                response.sendRedirect("./Select_Info_Client");
            }
        } catch (MessagingException e) {
                System.out.println("NO Proper internet connection"+e);
        }
        }catch(Exception e)
        {
            System.out.println("Exception is:"+e);
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
