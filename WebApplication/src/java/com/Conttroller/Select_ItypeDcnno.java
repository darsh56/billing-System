package com.Conttroller;

import com.Bean.DCNForm_Bean;
import com.Bean.Job_Bean;
import com.Bean.PurchaseOrderLines_Bean;
import com.Bean.Retail_Bean;
import com.Model.DBDCNForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Select_ItypeDcnno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try {
            String ino = request.getParameter("invoiceno");
            System.out.println("ino : " +ino);
            String jordno = request.getParameter("JInvoiceNo");
            System.out.println("jordno : " +jordno);
            
            String dcnno=request.getParameter("DCN_No");
            String itype=request.getParameter("I_Type");
            System.out.println("DCN No. : "+dcnno);
            System.out.println("Invoice Type : "+itype);
            //out.println("dcnno"+dcnno);
            DBDCNForm impl=new DBDCNForm();
             //String r= impl.IsRINO_Auto_Increment();
                 int r= impl.IsRINO_Auto_Increment();
                 out.println(r);
                 if(r==0){
                        r=1;
                    }
                    else{
                        r++;                        
                    }            
                 int t= impl.IsTINO_Auto_Increment();
                    if(t==0){
                        t=1;
                     }
                    else{
                        t++;
                    }
                 int jb = impl.IsJBINO_Auto_Increment();
                    if(jb==0){
                        jb=1;
                     }
                    else{
                        jb++;
                    }
           ArrayList<DCNForm_Bean> dcbcname=impl.get_Invoice_Type_CName_DCN(dcnno);
           //ArrayList<DCNForm_Bean> lisn=impl.getDCNforinvoice();
           ArrayList<DCNForm_Bean> tamount=impl.get_Total_Amount_DCN(dcnno);
           ArrayList<Retail_Bean> ri=impl.getRetails_Invoice_View();
           ArrayList<Job_Bean> jbi=impl.getJobWork_Invoice_View();
            if(itype.equals("JobWork"))
            {

                    if(!dcbcname.isEmpty() && !tamount.isEmpty()&&!jbi.isEmpty())
                    {
                        request.setAttribute("incr", String.valueOf("JB"+jb));
                        request.setAttribute("dcnno",dcnno);
                        request.setAttribute("itype",itype);
                        //request.setAttribute("dcn",lisn);
                        request.setAttribute("tamount",tamount);
                        request.setAttribute("dcbcname",dcbcname );
                        RequestDispatcher rd=request.getRequestDispatcher("Jobwork.jsp");
                        rd.forward(request,response);    
                    }
                    else
                    {
                         out.println("Records Are Not availables");
                         request.setAttribute("incr", String.valueOf("JB"+jb));
                         request.setAttribute("dcnno",dcnno);
                         request.setAttribute("itype",itype);
                         //request.setAttribute("dcn",lisn);
                         request.setAttribute("tamount",tamount);
                         request.setAttribute("dcbcname",dcbcname );
                         RequestDispatcher rd=request.getRequestDispatcher("Jobwork.jsp");
                         rd.forward(request,response);
                    }
            } else if(itype.equals("Tax"))
            {
                        if(!dcbcname.isEmpty() && !tamount.isEmpty())
                        {
                            request.setAttribute("incr", String.valueOf("T"+t));
                            request.setAttribute("dcnno",dcnno);
                            request.setAttribute("itype",itype);
                            //request.setAttribute("dcn",lisn);
                            request.setAttribute("tamount",tamount);
                            request.setAttribute("dcbcname",dcbcname );
                            RequestDispatcher rd=request.getRequestDispatcher("Tax_Invoice.jsp");
                            rd.forward(request,response);    
                        }
                        else
                        {
                                
                             out.println("Records Are Not availables");
                             request.setAttribute("incr", String.valueOf("T"+t));
                             request.setAttribute("dcnno",dcnno);
                             request.setAttribute("itype",itype);
                       //      request.setAttribute("dcn",lisn);
                             request.setAttribute("tamount",tamount);
                             request.setAttribute("dcbcname",dcbcname );
                             RequestDispatcher rd=request.getRequestDispatcher("Tax_Invoice.jsp");
                             rd.forward(request,response);
                        }
                
            }else if(itype.equals("Retail"))
            {
                System.out.println("Retail");      
                if(!dcbcname.isEmpty() && !tamount.isEmpty() &&!ri.isEmpty())
                        {
                            System.out.println("hello");
                            request.setAttribute("incr", String.valueOf("R"+r));
                            request.setAttribute("dcnno",dcnno);
                            request.setAttribute("itype",itype);
                   //         request.setAttribute("dcn",lisn);
                            request.setAttribute("tamount",tamount);
                            request.setAttribute("dcbcname",dcbcname );
                            RequestDispatcher rd=request.getRequestDispatcher("Retail_Invoice.jsp");
                            rd.forward(request,response);    
                        }
                        else
                        {
                             out.println("Records Are Not availables");
                             request.setAttribute("dcnno",dcnno);
                             request.setAttribute("incr", String.valueOf("R"+r));
                             request.setAttribute("itype",itype);
                     //        request.setAttribute("dcn",lisn);
                             request.setAttribute("tamount",tamount);
                             request.setAttribute("dcbcname",dcbcname );
                             RequestDispatcher rd=request.getRequestDispatcher("Retail_Invoice.jsp");
                             rd.forward(request,response);
                        }
                        
            }
            else
            {
                 out.println("Records Are Not availables");
            }
        }
        catch(Exception e){
            System.out.println("Exception:"+e);
        }
        finally {            
            out.close();
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
