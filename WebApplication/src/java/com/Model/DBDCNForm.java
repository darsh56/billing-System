
package com.Model;

import com.Bean.ClientForm_Bean;
import com.Bean.DCNForm_Bean;
import com.Bean.Job_Bean;
import com.Bean.PurchaseDetails_Bean;
import com.Bean.PurchaseOrderLines_Bean;
import com.Bean.Retail_Bean;
import com.Bean.Sales_Register_Bean;
import com.Bean.Tax_Bean;
//import com.google.common.collect.Table.Cell;
//import com.lowagie.text.Row;
import com.mysql.jdbc.Connection;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DBDCNForm 
{
    static int count;
    
    public static void insertdcndetails(DCNForm_Bean df)throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps;
        ResultSet rs=null;
        System.out.println("InsertDCNDetails()");
       
        try{     
       Connection con;
       con=(Connection) DBactivation.getConnection();
       
       String dcno=df.getDcno();
       String it = df.getInvoicetype();
       String cn = df.getComname();
       String dcnd = df.getDcndate();
       String pono = df.getPono();
       String partn = df.getPartname();
       String des = df.getDesc();
       String qua = df.getQut();
       String rate = df.getRate();
       String amou = df.getAmount();
       String en = df.getExicechano();
       String ed = df.getExicedate();
       
       System.out.println(dcno);      
       System.out.println(it);
       System.out.println(cn);
       System.out.println(dcnd);
       System.out.println(pono);
       System.out.println(partn);
       System.out.println(des);
       System.out.println(qua);
       System.out.println(rate);
       System.out.println(amou);
       System.out.println(en);
       System.out.println(ed);
       
       System.out.println("inserting");
       ps=con.prepareStatement("INSERT INTO challninvoice (Dcno,Invoicetype,Client_id,Dcndate,PO_No,Partname,Descr,Qut,Rate,Amount,Exicechano,Exicedate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"); 
       
       ps.setString(1,dcno);
       ps.setString(2,it);  
       ps.setString(3,cn);     
       ps.setString(4,dcnd);
       ps.setString(5,pono);
       ps.setString(6,partn);
       ps.setString(7,des);
       ps.setString(8,qua);
       ps.setString(9,rate);
       ps.setString(10,amou);
       ps.setString(11,en);
       ps.setString(12,ed);
       ps.executeUpdate();
    }catch(Exception e)
       {
           System.out.println("Exception:"+e);
       }
    }    
    public static ArrayList<PurchaseOrderLines_Bean> getDCN(String po) throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            Connection con;
            con=(Connection) DBactivation.getConnection();
            System.out.println("Inside GETPARTMASTER()");
            
            ArrayList<PurchaseOrderLines_Bean> al=new ArrayList<PurchaseOrderLines_Bean>();
            System.out.println("Purchase Order : " +po);
            String query = "SELECT PO_No,Serial_No,Part_Name,Part_desc,Line_No,Quantity,Rate,DueDate,Amount FROM purchaseorderline WHERE PO_No='"+po+"'";
            ps = con.prepareStatement(query);
            rs= ps.executeQuery();
                        
            while(rs.next())
            {
                PurchaseOrderLines_Bean pb = new PurchaseOrderLines_Bean();
                 pb.setPO_No(rs.getString("PO_No"));
                 pb.setSerial_No(rs.getInt("Serial_No"));
                 pb.setPart_Name(rs.getString("Part_Name"));
                 pb.setDescription(rs.getString("Part_desc"));
                 pb.setLine_No(rs.getInt("Line_No"));
                 pb.setQuantity(rs.getInt("Quantity"));
                 pb.setRate(rs.getInt("Rate"));
                 pb.setDueDate(rs.getString("DueDate"));
                 pb.setAmount(rs.getInt("Amount"));
                al.add(pb);
            }    
        return al;
        
    } 
   public static ArrayList<DCNForm_Bean> getDCNforinvoice() throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            ArrayList<DCNForm_Bean> al=new ArrayList<DCNForm_Bean>();    
            Connection con;
            con=(Connection) DBactivation.getConnection();
            System.out.println("Inside GETPARTMASTER()");
            
            String query = "select Dcno,Invoicetype,Client_id,Dcndate,PO_No,Partname,Descr,Qut,Rate,Amount,Exicechano,Exicedate  FROM challninvoice";
            ps = con.prepareStatement(query);
            rs= ps.executeQuery();
                        
            while(rs.next())
            {
                 DCNForm_Bean db = new DCNForm_Bean();
                 db.setDcno(rs.getString("Dcno"));
                 db.setInvoicetype(rs.getString("Invoicetype"));
                 db.setComname(rs.getString("Client_id"));
                 db.setDcndate(rs.getString("Dcndate"));
                 db.setPono(rs.getString("PO_No"));
                 db.setPartname(rs.getString("Partname"));
                 db.setDesc(rs.getString("Descr"));
                 db.setQut(rs.getString("Qut"));
                 db.setRate(rs.getString("Rate"));
                 db.setAmount(rs.getString("Amount"));
                 db.setExicechano(rs.getString("Exicechano"));
                 db.setExicedate(rs.getString("Exicedate"));
                 al.add(db);
            } 
            
        return al;
        
    }
   
public int isIncrement(){        
        int v=0;
        try{
        Connection con;
        con=(Connection) DBactivation.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select Dcno from challninvoice");
        
        while(rs.next()){
                v=rs.getInt(1);
                System.out.println("DCNO : " +v);
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return v;
    }
 public static ArrayList<ClientForm_Bean> getInfo() throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            Connection con;
            con=(Connection) DBactivation.getConnection();
            System.out.println("Inside GETINFO()");
            String id=null;
            String cn =null ;
           // String a =null;
            //String s =null;
            //String c =null;
            //String p =null;
            //String ph =null;
           // String f = null;
            String eid= null;
           // String t =null;
           // String v =null;
            String pd = null;
           // String sc = null;
           // String sd = null;           
            ArrayList<ClientForm_Bean> al=new ArrayList<ClientForm_Bean>();
            String query = "SELECT * From form_client"; 
            ps = con.prepareStatement(query);
            rs= ps.executeQuery();
            
            while(rs.next())
            {
                ClientForm_Bean cf = new ClientForm_Bean();
                cf.setClient_id(rs.getString("Client_id"));
                cf.setCompany_Name(rs.getString("Company_Name"));
               /* cf.setAddress(rs.getString("Address"));
                cf.setState(rs.getString("State"));
                cf.setCity(rs.getString("City"));
                cf.setPincode(rs.getString("Pincode"));
                cf.setPhoneNo(rs.getString("PhoneNo"));
                cf.setFax(rs.getString("Fax"));*/
                cf.setEmailid(rs.getString("Emailid"));
                /*cf.setTinNo(rs.getString("TinNo"));
                cf.setVatNo(rs.getString("VatNo"));*/
                cf.setPolicy_Deal_Days(rs.getString("Policy_Deal_Days"));
                /*cf.setSTC_code(rs.getString("STC_code"));
                cf.setSTC_Date(rs.getString("STC_Date"));*/
                System.out.println(cf);
                al.add(cf);
            }    
        return al;        
    }   
    public ArrayList<PurchaseDetails_Bean>getPurchaseOrderDetails_View()
        {
        ArrayList<PurchaseDetails_Bean> alist=new ArrayList<PurchaseDetails_Bean>();
        try
        {
            Connection con;
            con=(Connection) DBactivation.getConnection();   
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from purchase_details");
            while(rs.next())
            {
                PurchaseDetails_Bean pod=new PurchaseDetails_Bean();
                pod.setPO_No(rs.getString(1));
                pod.setClient_id(rs.getString(2));
                pod.setDate(rs.getString(3));               
                alist.add(pod);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return alist;
        
        }
     public static void insertRetail(Retail_Bean df)throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps;
        ResultSet rs=null;
        System.out.println("Insertretailinvoice()");
        try{     
            Connection con;
            con=(Connection) DBactivation.getConnection();
            
            String retailno = df.getRetailno();
            String dcno = df.getDcno();
            String cid = df.getClient_id();
            String idate = df.getInvodate();
            String beno = df.getBeno();
            String cour = df.getCourchar();
            String bedate = df.getBedate();
            String totamo = df.getTotamo();
            String trchno = df.getTrchno();
            String form = df.getFormtype();
            String trchdate = df.getTrchdate();
            String cst1 = df.getCst1_vat1();
            String cst2 = df.getCst2_vat2();
            String duty = df.getAddduty();
            String addamou = df.getAffamount();
            String rdoff = df.getRdoff();
            String netamou = df.getNetamount();
            String netamword = df.getNetamword();
            
            System.out.println(retailno);      
            System.out.println(dcno);      
            System.out.println(cid);      
            System.out.println(idate);      
            System.out.println(beno);      
            System.out.println(cour);      
            System.out.println(bedate);      
            System.out.println(totamo);      
            System.out.println(trchno);      
            System.out.println(form);      
            System.out.println(trchdate);      
            System.out.println(cst1);      
            System.out.println(cst2); 
            System.out.println(duty);      
            System.out.println(addamou);      
            System.out.println(rdoff);      
            System.out.println(netamou);  
            System.out.println(netamword);      
            
            System.out.println("inserting");
            ps=con.prepareStatement("INSERT INTO retailinvoice (Retailno,Dcno,CompanyName,Invodate,Beno,Courchar,Bedate,Amount,Trchno,Formtype,Trchdate,Cst_vat1,Cst_vat2,Addduty,Affamount,Rdoff,Netamount,Netamword) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
       
            ps.setString(1,retailno);
            ps.setString(2,dcno);
            ps.setString(3,cid);
            ps.setString(4,idate);
            ps.setString(5,beno);
            ps.setString(6,cour);
            ps.setString(7,bedate);
            ps.setString(8,totamo);
            ps.setString(9,trchno);
            ps.setString(10,form);
            ps.setString(11,trchdate);
            ps.setString(12,cst1);
            ps.setString(13,cst2);
            ps.setString(14,duty);
            ps.setString(15,addamou);
            ps.setString(16,rdoff);
            ps.setString(17,netamou);
            ps.setString(18,netamword);
            ps.executeUpdate();
        }catch(Exception e)
            {
                System.out.println("Exception:"+e);
            }
    }
      public static void insertJob(Job_Bean df)throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps;
        ResultSet rs=null;
        System.out.println("Insertretailinvoice()");
        try{     
            Connection con;
            con=(Connection) DBactivation.getConnection();
            
            String jobno = df.getJobno();
            String dcno = df.getDcno();
            String cname = df.getCompName();
            String idate = df.getInvodate();
            String beno = df.getBeno();
            String cour = df.getCourchar();
            String bedate = df.getBedate();
            String totamo = df.getTotamo();
            String trchno = df.getTrchno();
            String sertax1 = df.getSertax1();
            String sertax2 = df.getSertax2();
            String trchdate = df.getTrchdate();
            String edu1 = df.getEducess1();
            String edu2 = df.getEducess2();
            String duty = df.getAddduty();
            String hitax1 = df.getHieducess1();
            String hitax2 = df.getHieducess2();
            String addamou = df.getAffamount();
            String rdoff = df.getRdoff();
            String netamou = df.getNetamount();
            String netamword = df.getNetamword();
            
            System.out.println(jobno);      
            System.out.println(dcno);      
            System.out.println(cname);      
            System.out.println(idate);      
            System.out.println(beno);      
            System.out.println(cour);      
            System.out.println(bedate);      
            System.out.println(totamo);      
            System.out.println(trchno);      
            System.out.println(sertax1);      
            System.out.println(sertax2);      
            System.out.println(trchdate);      
            System.out.println(edu1);      
            System.out.println(edu2); 
            System.out.println(duty); 
            System.out.println(hitax1); 
            System.out.println(hitax2); 
            System.out.println(addamou);      
            System.out.println(rdoff);      
            System.out.println(netamou);  
            System.out.println(netamword);      
            
            System.out.println("inserting");
            ps=con.prepareStatement("INSERT INTO jobwork (Jobno,Dcno,Compnm,Invodate,Beno,Courchar,Bedate,Totamo,Trchno,Sertax1,Sertax2,Trchdate,Educess1,Educess2,Addduty,Hieducess1,Hieducess2,Affamount,Rdoff,Netamount,Netamword) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
       
            ps.setString(1,jobno);
            ps.setString(2,dcno);
            ps.setString(3,cname);
            ps.setString(4,idate);
            ps.setString(5,beno);
            ps.setString(6,cour);
            ps.setString(7,bedate);
            ps.setString(8,totamo);
            ps.setString(9,trchno);
            ps.setString(10,sertax1);
            ps.setString(11,sertax2);
            ps.setString(12,trchdate);
            ps.setString(13,edu1);
            ps.setString(14,edu2);
            ps.setString(15,duty);
            ps.setString(16,hitax1);
            ps.setString(17,hitax2);
            ps.setString(18,addamou);
            ps.setString(19,rdoff);
            ps.setString(20,netamou);
            ps.setString(21,netamword);
            ps.executeUpdate();
        }catch(Exception e)
            {
                System.out.println("Exception:"+e);
            }
    }
 public static void insertTax(Tax_Bean df)throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps;
        ResultSet rs=null;
        System.out.println("Insertretailinvoice()");
        try{     
            Connection con;
            con=(Connection) DBactivation.getConnection();
            
            String taxno = df.getTaxno();
            String dcno = df.getDcno();
            String cname = df.getCompName();
            String idate = df.getInvodate();
            String beno = df.getBeno();
            String cour = df.getCourchar();
            String bedate = df.getBedate();
            String totamo = df.getTotamo();
            String trchno = df.getTrchno();
            String vat1 = df.getVat1();
            String vat2 = df.getVat2();
            String trchdate = df.getTrchdate();
            String addvat1 = df.getAddvat1();
            String addvat2 = df.getAddvat2();
            String duty = df.getAddduty();
            String addamou = df.getAffamount();
            String rdoff = df.getRdoff();
            String netamou = df.getNetamount();
            String netamword = df.getNetamword();
            
            System.out.println(taxno);      
            System.out.println(dcno);      
            System.out.println(cname);      
            System.out.println(idate);      
            System.out.println(beno);      
            System.out.println(cour);      
            System.out.println(bedate);      
            System.out.println(totamo);      
            System.out.println(trchno);      
            System.out.println(vat1);     
            System.out.println(vat2);      
            System.out.println(trchdate);      
            System.out.println(addvat1);      
            System.out.println(addvat2); 
            System.out.println(duty);      
            System.out.println(addamou);      
            System.out.println(rdoff);      
            System.out.println(netamou);  
            System.out.println(netamword);      
            
            System.out.println("inserting");
            ps=con.prepareStatement("INSERT INTO taxinvoice (Taxno,Dcno,Compnm,Invodate,Beno,Courchar,Bedate,Totamo,Trchno,Vat1,Vat2,Trchdate,Addvat1,Addvat2,Addduty,Affamount,Rdoff,Netamount,Netamword) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
       
            ps.setString(1,taxno);
            ps.setString(2,dcno);
            ps.setString(3,cname);
            ps.setString(4,idate);
            ps.setString(5,beno);
            ps.setString(6,cour);
            ps.setString(7,bedate);
            ps.setString(8,totamo);
            ps.setString(9,trchno);
            ps.setString(10,vat1);
            ps.setString(11,vat2);
            ps.setString(12,trchdate);
            ps.setString(13,addvat1);
            ps.setString(14,addvat2);
            ps.setString(15,duty);
            ps.setString(16,addamou);
            ps.setString(17,rdoff);
            ps.setString(18,netamou);
            ps.setString(19,netamword);            
            ps.executeUpdate();
        }catch(Exception e)
            {
                System.out.println("Exception:"+e);
            }
    }      
 public int IsRINO_Auto_Increment(){
        
       int v=0;
       try{
       Connection con;
       con=(Connection) DBactivation.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select count(*) no from retailinvoice");
        
        while(rs.next()){
                v=rs.getInt(1);
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return v;
    }
 public int IsTINO_Auto_Increment(){
        
            int v=0;
        try{
       Connection con;
       con=(Connection) DBactivation.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select count(*) from taxinvoice ");
        
        while(rs.next()){
                v=rs.getInt(1);
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return v;
    }
  public int IsJBINO_Auto_Increment(){
        
            int v=0;
        try{
       
        Connection con;
        con=(Connection) DBactivation.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select count(*) from jobwork ");
        
        while(rs.next()){
                v=rs.getInt(1);
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return v;
    }
public ArrayList<DCNForm_Bean> get_Invoice_Type_CName_DCN(String DCNNo)
{
    ArrayList<DCNForm_Bean> dcn=new ArrayList<DCNForm_Bean>();
        try {
            Connection con;
            con=(Connection) DBactivation.getConnection();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT Dcno,f.Company_Name FROM challninvoice c,form_client f WHERE f.Client_id=c.Client_id AND c.Dcno='"+DCNNo+"'");
            while(rs.next())
            {
                DCNForm_Bean dcb=new DCNForm_Bean();
                dcb.setDcno(rs.getString(1));
                dcb.setComname(rs.getString(2));
                dcn.add(dcb);
            }                     
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return dcn;
}
 public ArrayList<DCNForm_Bean> get_Total_Amount_DCN(String DCNNo)
 {
     //ArrayList<PurchaseOrderLines_Bean> listno=new ArrayList<PurchaseOrderLines_Bean>();
    ArrayList<DCNForm_Bean> dcn=new ArrayList<DCNForm_Bean>();
        try {
            Connection con;
            con=(Connection) DBactivation.getConnection();
            Statement stmt=con.createStatement();
            //int id=bean.getPurchase_order_no();
            System.out.println("Inside Total Amount");
            ResultSet rs=stmt.executeQuery("SELECT SUM(Amount) total  FROM challninvoice  WHERE Dcno='"+DCNNo+"'");
            while(rs.next())
            {
               //PurchaseOrderLines_Bean cm=new PurchaseOrderLines_Bean();
               DCNForm_Bean dcb=new DCNForm_Bean();
                //dcb.setDcno(rs.getString("Dcno"));
                //cm.setPO_No(rs.getString("PO_No"));
                dcb.setAmount(rs.getString(1));
                //listno.add(cm);
                dcn.add(dcb);
            }                     
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return dcn;
 }
 public ArrayList<Retail_Bean>getRetails_Invoice_View()
 {
      ArrayList<Retail_Bean> alist=new ArrayList<Retail_Bean>();
        try
        {
            Connection con;
            con=(Connection) DBactivation.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from retailinvoice");
            while(rs.next())
            {
                Retail_Bean ppdb=new Retail_Bean();
                ppdb.setRetailno(rs.getString(1));
                ppdb.setDcno(rs.getString(2));
                ppdb.setClient_id(rs.getString(3));
                ppdb.setInvodate(rs.getString(4));
                ppdb.setBeno(rs.getString(5));
                ppdb.setCourchar(rs.getString(6));
                ppdb.setBedate(rs.getString(7));
                ppdb.setTotamo(rs.getString(8));
                ppdb.setTrchno(rs.getString(9));
                ppdb.setFormtype(rs.getString(10));
                ppdb.setTrchdate(rs.getString(11));
                ppdb.setCst1_vat1(rs.getString(12));
                ppdb.setCst2_vat2(rs.getString(13));
                ppdb.setAddduty(rs.getString(14));
                ppdb.setAffamount(rs.getString(15));
                ppdb.setRdoff(rs.getString(16));
                ppdb.setNetamount(rs.getString(17));
                ppdb.setNetamword(rs.getString(18));
                alist.add(ppdb);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return alist;
 }  
 public ArrayList<Job_Bean>getJobWork_Invoice_View()
{
        ArrayList<Job_Bean> alist=new ArrayList<Job_Bean>();
        try
        {
           Connection con;
            con=(Connection) DBactivation.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from jobwork");
            while(rs.next())
            {
                Job_Bean ppdb=new  Job_Bean();
                ppdb.setJobno(rs.getString(1));
                ppdb.setDcno(rs.getString(2));
                ppdb.setCompName(rs.getString(3));
                ppdb.setInvodate(rs.getString(4));
                ppdb.setBeno(rs.getString(5));
                ppdb.setCourchar(rs.getString(6));
                ppdb.setBedate(rs.getString(7));
                ppdb.setTotamo(rs.getString(8));
                ppdb.setTrchno(rs.getString(9));
                ppdb.setSertax1(rs.getString(10));
                ppdb.setSertax2(rs.getString(11));
                ppdb.setTrchdate(rs.getString(12));
                ppdb.setEducess1(rs.getString(13));
                ppdb.setEducess2(rs.getString(14));
                ppdb.setAddduty(rs.getString(15));
                ppdb.setHieducess1(rs.getString(16));
                ppdb.setHieducess2(rs.getString(17));
                ppdb.setAffamount(rs.getString(18));
                ppdb.setRdoff(rs.getString(19));
                ppdb.setNetamount(rs.getString(20));
                ppdb.setNetamword(rs.getString(21));              
                alist.add(ppdb);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return alist;
}
 public ArrayList<Tax_Bean>getTax_Invoice_View()
{
        ArrayList<Tax_Bean> alist=new ArrayList<Tax_Bean>();
        try
        {
           Connection con;
            con=(Connection) DBactivation.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from taxinvoice");
            while(rs.next())
            {
                Tax_Bean ppdb=new  Tax_Bean();
                ppdb.setTaxno(rs.getString(1));
                ppdb.setDcno(rs.getString(2));
                ppdb.setCompName(rs.getString(3));
                ppdb.setInvodate(rs.getString(4));
                ppdb.setBeno(rs.getString(5));
                ppdb.setCourchar(rs.getString(6));
                ppdb.setBedate(rs.getString(7));
                ppdb.setTotamo(rs.getString(8));
                ppdb.setTrchno(rs.getString(9));
                ppdb.setVat1(rs.getString(10));
                ppdb.setVat2(rs.getString(11));
                ppdb.setTrchdate(rs.getString(12));
                ppdb.setAddvat1(rs.getString(13));
                ppdb.setAddvat2(rs.getString(14));
                ppdb.setAddduty(rs.getString(15));
                ppdb.setAffamount(rs.getString(16));
                ppdb.setRdoff(rs.getString(17));
                ppdb.setNetamount(rs.getString(18));
                ppdb.setNetamword(rs.getString(19));              
                alist.add(ppdb);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return alist;
}
  public ArrayList<Job_Bean> get_Invoice_Type_Jobwork()
   {
     ArrayList<Job_Bean> Dcnno=new ArrayList<Job_Bean>();
        try {
            Connection con;
            con=(Connection) DBactivation.getConnection();
            Statement stmt=con.createStatement();
            //int id=bean.getPurchase_order_no();
            ResultSet rs=stmt.executeQuery("select Jobno from jobwork");
            while(rs.next())
            {
               Job_Bean cm=new Job_Bean();
                cm.setJobno(rs.getString("Jobno"));
                //cm.setPurchase_order(rs.getInt("podno"));
                Dcnno.add(cm);
            }                     
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return Dcnno;    
   }
 public ArrayList<Tax_Bean> get_Invoice_Type_Tax()
   {
       ArrayList<Tax_Bean> Dcnno=new ArrayList<Tax_Bean>();
        try {
            Connection con;
            con=(Connection) DBactivation.getConnection();
            Statement stmt=con.createStatement();
            //int id=bean.getPurchase_order_no();
            ResultSet rs=stmt.executeQuery("select Taxno from taxinvoice ");
            while(rs.next())
            {
               Tax_Bean cm=new Tax_Bean();
                cm.setTaxno(rs.getString("Taxno"));
                //cm.setPurchase_order(rs.getInt("podno"));
                Dcnno.add(cm);
            }                     
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return Dcnno;
   }
public ArrayList<Retail_Bean> get_Invoice_Type_Retails()
    {
    ArrayList<Retail_Bean> Dcnno=new ArrayList<Retail_Bean>();
        try {
            Connection con;
            con=(Connection) DBactivation.getConnection();
            Statement stmt=con.createStatement();
            //int id=bean.getPurchase_order_no();
            ResultSet rs=stmt.executeQuery("select Retailno from retailinvoice");
            while(rs.next())
            {
               Retail_Bean cm=new Retail_Bean();
                cm.setRetailno(rs.getString("Retailno"));
                //cm.setPurchase_order(rs.getInt("podno"));
                Dcnno.add(cm);
            }                     
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return Dcnno; 
}
public ArrayList<Sales_Register_Bean>getSale_Register()
      
    {
        ArrayList<Sales_Register_Bean> RSBean=new ArrayList<Sales_Register_Bean>();
        try
        {
            Connection con1=(Connection) DBactivation.getConnection();
            Statement stmt=con1.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT DISTINCT d.Dcndate 'Date',d.Dcno 'DCN NO',COALESCE(r.Retailno,jw.Jobno,t.Taxno)'Bill No',f.Company_Name 'Partys Name',jw.Totamo 'Gross JobWork',jw.Sertax2 'ServiceTax',jw.Netamount 'Net JobWork',(SELECT r.Cst_vat2 FROM retailinvoice r WHERE r.Formtype='Against H Form') 'Against H Form',r.Amount 'OGS Sales',(SELECT r.Cst_vat2 FROM retailinvoice r WHERE r.Formtype='Against C Form') 'Against C Form',(SELECT r.Cst_vat2 FROM retailinvoice r WHERE r.Formtype='W/O Against C Form') 'Not AgainstCForm',r.Netamount 'TOTAL OGS',t.Totamo 'TAXGross_Sales',t.Vat2 'TAX VAT AMT',t.Addvat2 'TAX Add_VAT AMT',t.Netamount 'Net Sales',COALESCE(r.Netamount,t.Netamount,jw.Netamount) 'TOTALAMOUNT' FROM challninvoice d LEFT JOIN form_client f ON f.Client_id=d.Client_id LEFT JOIN retailinvoice r ON r.Dcno=d.Dcno LEFT JOIN taxinvoice t ON  t.Dcno=d.Dcno LEFT JOIN jobwork jw ON jw.Dcno=d.Dcno;");
            while(rs.next())
            { 
                    Sales_Register_Bean Sr=new Sales_Register_Bean();
                
                Sr.setDate1(rs.getString("Date"));
                Sr.setDCNNO(rs.getInt("DCN NO"));
                Sr.setBillNo(rs.getString("Bill No"));
                Sr.setPartyName(rs.getString("Partys Name"));
                Sr.setGrossJobwork(rs.getFloat("Gross JobWork"));
                Sr.setServiceTax(rs.getFloat("ServiceTax"));
                Sr.setNetJobWork(rs.getFloat("Net JobWork"));
                Sr.setAgainst_From_H(rs.getFloat("Against H Form"));
                Sr.setOGSSales_Retails(rs.getFloat("OGS Sales"));
                Sr.setAgainst_C_From(rs.getFloat("Against C Form"));
                Sr.setNot_Against_C_From(rs.getFloat("Not AgainstCForm"));
                Sr.setTotalOGS(rs.getFloat("TOTAL OGS"));
                Sr.setGrossSale_Tax(rs.getFloat("TAXGross_Sales"));
                Sr.setVat_Tax(rs.getFloat("TAX VAT AMT"));
                Sr.setAdd_Vat_Tax(rs.getFloat("TAX Add_VAT AMT"));
                Sr.setNet_Sale_Tax(rs.getFloat("Net Sales"));
                Sr.setTotal_Amount(rs.getFloat("TOTALAMOUNT"));
                 RSBean.add(Sr);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return RSBean;
    }
 public ArrayList<Sales_Register_Bean>getSale_Register_Excel()
      
    {
        ArrayList<Sales_Register_Bean> RSBean=new ArrayList<Sales_Register_Bean>();
        try
        {
                Workbook wb = new HSSFWorkbook();
                Sheet personSheet = wb.createSheet("saleRegister");
                             
                Row headerRow = (Row) personSheet.createRow(0);
                headerRow.createCell(0).setCellValue("Date");
                headerRow.createCell(1).setCellValue("DCNNo");
                headerRow.createCell(2).setCellValue("BillNo");
                headerRow.createCell(3).setCellValue("Party's Name");
                headerRow.createCell(4).setCellValue("Gross JobWork");
                headerRow.createCell(5).setCellValue("Service Tax");
                headerRow.createCell(6).setCellValue("Net JobWork");
                headerRow.createCell(7).setCellValue("Against H Form");
                headerRow.createCell(8).setCellValue("OGS Sales");
                headerRow.createCell(9).setCellValue("Against C Form");
                headerRow.createCell(10).setCellValue("Not Against C Form");
                headerRow.createCell(11).setCellValue("TOTAL OGS");
                headerRow.createCell(12).setCellValue("TAXGross_Sales");
                headerRow.createCell(13).setCellValue("TAX VAT AMT");
                headerRow.createCell(14).setCellValue("TAX Add_VAT AMT");
                headerRow.createCell(15).setCellValue("Net Sales");
                headerRow.createCell(16).setCellValue("TOTALAMOUNT");
                
                //String sql = "select name, address from person_table";
                //PrepareStatement ps =  connection.prepareStatement(sql);
                //ResultSet resultSet = ps.executeQuery();  
            Connection con1=(Connection) DBactivation.getConnection();
            Statement stmt=con1.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT DISTINCT d.Dcndate 'Date',d.Dcno 'DCN NO',COALESCE(r.Retailno,jw.Jobno,t.Taxno)'Bill No',f.Company_Name 'Partys Name',jw.Totamo 'Gross JobWork',jw.Sertax2 'ServiceTax',jw.Netamount 'Net JobWork',(SELECT r.Cst_vat2 FROM retailinvoice r WHERE r.Formtype='Against H Form') 'Against H Form',r.Amount 'OGS Sales',(SELECT r.Cst_vat2 FROM retailinvoice r WHERE r.Formtype='Against C Form') 'Against C Form',(SELECT r.Cst_vat2 FROM retailinvoice r WHERE r.Formtype='W/O Against C Form') 'Not AgainstCForm',r.Netamount 'TOTAL OGS',t.Totamo 'TAXGross_Sales',t.Vat2 'TAX VAT AMT',t.Addvat2 'TAX Add_VAT AMT',t.Netamount 'Net Sales',COALESCE(r.Netamount,t.Netamount,jw.Netamount) 'TOTALAMOUNT' FROM challninvoice d LEFT JOIN form_client f ON f.Client_id=d.Client_id LEFT JOIN retailinvoice r ON r.Dcno=d.Dcno LEFT JOIN taxinvoice t ON  t.Dcno=d.Dcno LEFT JOIN jobwork jw ON jw.Dcno=d.Dcno;");
               
            int row = 1;
                    while(rs.next()) {
                        //String name = rs.getString("name");
                        //String address = rs.getString("address");
                                //Sale_Register Sr=new Sale_Register();
                               String DATE=rs.getString("Date");
                               int dcnno=rs.getInt("DCN NO");
                               String billno=rs.getString("Bill No");
                               String pname=rs.getString("Partys Name");
                               float gjw=rs.getFloat("Gross JobWork");
                               float stax=rs.getFloat("ServiceTax");
                               float netje=rs.getFloat("Net JobWork");
                               float Hform=rs.getFloat("Against H Form");
                               float ogssale=rs.getFloat("OGS Sales");
                               float cform=rs.getFloat("Against C Form");
                               float notcform=rs.getFloat("Not AgainstCForm");
                               float totalogs=rs.getFloat("TOTAL OGS");
                               float taxgsale=rs.getFloat("TAXGross_Sales");
                               float taxvat=rs.getFloat("TAX VAT AMT");
                               float addvat=rs.getFloat("TAX Add_VAT AMT");
                               float netsale=rs.getFloat("Net Sales");
                               float totalamount=rs.getFloat("TOTALAMOUNT");
                              
                        Row dataRow = personSheet.createRow(row);

                        Cell dateCell = dataRow.createCell(0);
                        dateCell.setCellValue(DATE);
                        Cell dcnnoCell = dataRow.createCell(1);
                         dcnnoCell.setCellValue(dcnno);                        
                        Cell billnoCell = dataRow.createCell(2);
                        billnoCell.setCellValue(billno);
                        Cell pnameCell = dataRow.createCell(3);
                        pnameCell.setCellValue(pname);
                        Cell gjwCell = dataRow.createCell(4);
                        gjwCell.setCellValue(gjw);
                        Cell staxCell = dataRow.createCell(5);
                        staxCell.setCellValue(stax);
                        Cell netjeCell = dataRow.createCell(6);
                        netjeCell.setCellValue(netje);
                        Cell HformCell = dataRow.createCell(7);
                        HformCell.setCellValue(Hform);
                        Cell ogssaleCell = dataRow.createCell(8);
                        ogssaleCell.setCellValue(ogssale);
                        Cell cformCell = dataRow.createCell(9);
                        cformCell.setCellValue(cform);
                        Cell notcformCell = dataRow.createCell(10);
                        notcformCell.setCellValue(notcform);
                        Cell totalogsCell = dataRow.createCell(11);
                        totalogsCell.setCellValue(totalogs);
                        Cell taxgsaleCell = dataRow.createCell(12);
                        taxgsaleCell.setCellValue(taxgsale);
                        Cell taxvatCell = dataRow.createCell(13);
                        taxvatCell.setCellValue(taxvat);
                        Cell addvatCell = dataRow.createCell(14);
                        addvatCell.setCellValue(addvat);
                        Cell netsaleCell = dataRow.createCell(15);
                        netsaleCell.setCellValue(netsale);
                        Cell totalamountCell = dataRow.createCell(16);
                        totalamountCell.setCellValue(totalamount);

                        row = row + 1;
                    }
            String outputDirPath = "D:/SaleRegister.xls";
            FileOutputStream fileOut = new FileOutputStream(outputDirPath);
            wb.write(fileOut);
            fileOut.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return RSBean;
    }
}
