
package com.Model;
import com.Bean.PurchaseOrderLines_Bean;
import com.Bean.PartMaster_Bean;
import com.Bean.PurchaseDetails_Bean;
import static com.Model.DBmethod.count;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *s
 * @author navkar
 */
public class DBPurchaseOrderForm { 
    
    public static void insertpurchaseDetails(PurchaseDetails_Bean pb)throws SQLException, ClassNotFoundException {
       PreparedStatement ps;
       System.out.println("InsertPurchaseDetails()");
       try{     
       Connection con;
       con=DBactivation.getConnection();
       System.out.println(pb.getPO_No()+" "+pb.getClient_id()+" "+pb.getDate());
       System.out.println("inserting");
       ps=con.prepareStatement("INSERT INTO purchase_details(PO_No,Client_id,DATE) VALUES (?,?,?)"); 
       ps.setString(1,pb.getPO_No());
       ps.setString(2,pb.getClient_id());
       ps.setString(3,pb.getDate());     
       ps.executeUpdate();
       }catch(Exception e)
       {
           System.out.println("Exception:"+e);
       }
    }

    public static void insertpurchaseOrderLines(PurchaseOrderLines_Bean polb)throws SQLException, ClassNotFoundException {
       PreparedStatement ps;
       ResultSet rs=null;
       System.out.println("insertpurchaseOrderLines()");
       
       Connection con;
       con=DBactivation.getConnection();
       String pono = polb.getPO_No();
       int sno =polb.getSerial_No();
       String pname=polb.getPart_Name();
       String des=polb.getDescription();
       int lno = polb.getLine_No();
       String duedate = polb.getDueDate();
       int qua = polb.getQuantity();
       int rate = polb.getRate();
       int amount = polb.getAmount();
       
       System.out.println("inserting");
       ps=con.prepareStatement("INSERT INTO purchaseorderline (PO_No,Serial_No,Part_Name,Part_desc,Line_No,DueDate,Quantity,Rate,Amount) VALUES(?,?,?,?,?,?,?,?,?)"); 
       ps.setString(1,polb.getPO_No());
       ps.setInt(2,polb.getSerial_No());
       ps.setString(3,polb.getPart_Name());
       ps.setString(4,polb.getDescription());
       ps.setInt(5,polb.getLine_No());
       ps.setString(6,polb.getDueDate());
       ps.setInt(7,polb.getQuantity());
       ps.setInt(8,polb.getRate());
       ps.setInt(9,polb.getAmount());
       ps.executeUpdate();
    }

    public static boolean insertpartmaster(PartMaster_Bean pmb)
    { 
       PreparedStatement ps;
       ResultSet rs=null;
       boolean flag=false;
       System.out.println("InsertPartmaster()");
       try
       {
       Connection con;
       con=DBactivation.getConnection();
       System.out.println("inserting");
       ps=con.prepareStatement("INSERT into PartMaster(PartNo,PartName,Description) values(?,?,?)"); 
       ps.setString(1,pmb.getPartNo());
       ps.setString(2,pmb.getPartName());   
       ps.setString(3,pmb.getDescription());
       ps.executeUpdate();
       flag=true;
       }
       catch(Exception e){
       System.out.println("Error Exception : " +e.getMessage());
       }
       return flag;
    }

    public static ArrayList<PartMaster_Bean> getpartmaster() throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            Connection con;
            con=DBactivation.getConnection();
            System.out.println("Inside GETPARTMASTER()");
            ArrayList<PartMaster_Bean> al=new ArrayList<PartMaster_Bean>();
            String query = "SELECT * From partmaster"; 
            ps = con.prepareStatement(query);
            rs= ps.executeQuery();
            
            while(rs.next())
            {
                PartMaster_Bean pb = new PartMaster_Bean();
                pb.setPartid(rs.getString("Partid"));
                pb.setPartNo(rs.getString("PartNo"));
                pb.setPartName(rs.getString("PartName"));
                pb.setDescription(rs.getString("Description"));
                System.out.println(pb);
                al.add(pb);
            }    
        return al;
        
    }   

    public boolean deletepartmaster(PartMaster_Bean bean){
        boolean checkid = false;
        try{
            Connection con = DBactivation.getConnection();
            String sql = "DELETE FROM partmaster WHERE Partid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,bean.getPartid());
            ps.executeUpdate();
            System.out.println("state delete");
            checkid=true;
            ps.close();
        }
        catch(Exception e){
            System.out.println("Error Exception : " +e.getMessage());
        }
        return checkid;
    }    

       public static boolean updatepartmaster(PartMaster_Bean bean){
        boolean check_id = false;
        try
        {
            Connection con = DBactivation.getConnection();
            String sql = "UPDATE partmaster SET PartNo=?,PartName=?,Description=? WHERE Partid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bean.getPartNo());
            ps.setString(2, bean.getPartName());
            ps.setString(3, bean.getDescription());
            ps.setString(4, bean.getPartid());
            System.out.println(bean.getPartNo()+" "+bean.getPartName()+" "+bean.getDescription()+" "+bean.getPartid());
            ps.executeUpdate();
            System.out.println("executeUpdate();");
            check_id=true;
            System.out.println("after check_id=true");
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println("Error Exception : " +e.getMessage());
        }
        return check_id;
     }
     public static ArrayList<PurchaseDetails_Bean> getPono(String po) throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            com.mysql.jdbc.Connection con;
            con=(com.mysql.jdbc.Connection) DBactivation.getConnection();
            System.out.println("Inside GETPARTMASTER()");
            
            ArrayList<PurchaseDetails_Bean> al=new ArrayList<PurchaseDetails_Bean>();
            System.out.println("Purchase Order : " +po);
            String query = "SELECT purchase_details.PO_No,form_client.Company_Name,purchase_details.Date FROM purchase_details INNER JOIN form_client ON form_client.Client_id=purchase_details.Client_id WHERE purchase_details.PO_No='"+po+"'";
            ps = con.prepareStatement(query);
            rs= ps.executeQuery();
                        
            while(rs.next())
            {
                PurchaseDetails_Bean pdb = new PurchaseDetails_Bean();
                pdb.setPO_No(rs.getString(1));
                pdb.setClient_id(rs.getString(2));
                pdb.setDate(rs.getString(3));
                 
                al.add(pdb);
            }    
        return al;
        
    } 
        
    }   

    
