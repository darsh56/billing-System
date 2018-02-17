package com.Conttroller;

import com.Model.DBactivation;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author navkar
 */
public class Report_Invoice extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String itype=request.getParameter("I_Type");
        String ftype=request.getParameter("FormType");
      try 
        {
            
        if(itype.equals("Tax"))
          {
            JasperCompileManager.compileReportToFile("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\TaxInvoice.jrxml","C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\TaxInvoice.jasper");
            Connection con;
            con=DBactivation.getConnection();
            ServletOutputStream out = response.getOutputStream();
            File reportFile = new File("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\TaxInvoice.jasper");
            Map parameters = new HashMap();
            out.println(itype);
            parameters.put("tinvoiceno",request.getParameter("InvoiceNo"));
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, con);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
           }
          else if(itype.equals("JobWork"))
           {
               JasperCompileManager.compileReportToFile("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\Jobwork.jrxml","C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\Jobwork.jasper");
               Connection con;
               con=DBactivation.getConnection();
               ServletOutputStream out = response.getOutputStream();
               File reportFile = new File("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\Jobwork.jasper");
               Map parameters = new HashMap();
               parameters.put("jbinvoiceno",request.getParameter("InvoiceNo"));
               byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, con);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
            } 
           else if(itype.equals("Retail"))
            {
               if(ftype.equals("Against C Form"))
               {
               System.out.println("This is Against C Form");   
               JasperCompileManager.compileReportToFile("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicecst.jrxml","C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicecst.jasper");
               Connection con;
               con=DBactivation.getConnection();
               ServletOutputStream out = response.getOutputStream();
               File reportFile = new File("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicecst.jasper");
               Map parameters = new HashMap();
               parameters.put("rinvoiceno",(String)(request.getParameter("InvoiceNo")));
               byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, con);            
               response.setContentType("application/pdf");
               response.setContentLength(bytes.length);
               ServletOutputStream outStream = response.getOutputStream();
               outStream.write(bytes, 0, bytes.length);
               outStream.flush();
               outStream.close();
               }
               else if(ftype.equals("W/O Against C Form"))
               {
               System.out.println("This is W/O Against C Form");       
               JasperCompileManager.compileReportToFile("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicecst.jrxml","C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicecst.jasper");
               Connection con;
               con=DBactivation.getConnection();
               ServletOutputStream out = response.getOutputStream();
               File reportFile = new File("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicecst.jasper");
               Map parameters = new HashMap();
               parameters.put("rinvoiceno",(String)(request.getParameter("InvoiceNo")));
               byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, con);            
               response.setContentType("application/pdf");
               response.setContentLength(bytes.length);
               ServletOutputStream outStream = response.getOutputStream();
               outStream.write(bytes, 0, bytes.length);
               outStream.flush();
               outStream.close();
               }
               else if(ftype.equals("Against H Form")) 
               {
               System.out.println("This is Against H Form");           
               JasperCompileManager.compileReportToFile("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicevat.jrxml","C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicevat.jasper");
               Connection con;
               con=DBactivation.getConnection();
               ServletOutputStream out = response.getOutputStream();
               System.out.println("Goes To VAT");           
               File reportFile = new File("C:\\Users\\navkar\\Documents\\NetBeansProjects\\BillingProject\\web\\Report\\RetailInvoicevat.jasper");
               Map parameters = new HashMap();
               parameters.put("rinvoiceno",(String)(request.getParameter("InvoiceNo")));
               byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, con);            
               response.setContentType("application/pdf");
               response.setContentLength(bytes.length);
               ServletOutputStream outStream = response.getOutputStream();
               outStream.write(bytes, 0, bytes.length);
               outStream.flush();
               outStream.close();
               }
                     
            }           
        }
        catch (Exception e) {
            throw new ServletException(e);
            //System.out.println(e);
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
