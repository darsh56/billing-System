package com.Model;

import com.Bean.ClientForm_Bean;
import static com.Model.DBactivation.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author navkar
 */
public class DBclientinfo {
        
       public static boolean insertInfo(ClientForm_Bean cf) throws SQLException, ClassNotFoundException
    {
         PreparedStatement ps;
         System.out.println("INSERTINFO()");
         boolean flag=false;
   try{
        Connection con;
        con=DBactivation.getConnection();
        System.out.println("inserting");
        ps=con.prepareStatement("INSERT INTO form_client(Company_Name,Address,State,City,Pincode,PhoneNo,Fax,Emailid,TinNo,VatNo,Policy_Deal_Days,STC_code,STC_Date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
        ps.setString(1,cf.getCompany_Name());
        ps.setString(2,cf.getAddress());
        ps.setString(3,cf.getState());
        ps.setString(4,cf.getCity());
        ps.setString(5,cf.getPincode());
        ps.setString(6,cf.getPhoneNo());
        ps.setString(7,cf.getFax());
        ps.setString(8,cf.getEmailid());
        ps.setString(9,cf.getTinNo());
        ps.setString(10,cf.getVatNo());
        ps.setString(11,cf.getPolicy_Deal_Days());
        ps.setString(12,cf.getSTC_code());
        ps.setString(13,cf.getSTC_Date());
        ps.executeUpdate();
        flag=true;
   }
   catch(Exception e){
       System.out.println("Error : " +e.getMessage());
   }
        return flag;
       
    }
    public static ArrayList<ClientForm_Bean> getInfo() throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            Connection con;
            con=DBactivation.getConnection();
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
    public static boolean updateInfo(ClientForm_Bean cf)
    {   
        boolean flag=false;
      try{
        System.out.println("Inside UPDATEINFO()");
        Connection con=DBactivation.getConnection();
        String sql = "UPDATE form_client SET Company_Name=?,Emailid=?,Policy_Deal_Days=? WHERE Client_id=?";
        PreparedStatement ps = con.prepareStatement(sql);       
        ps.setString(1,cf.getCompany_Name());
       /* ps.setString(2,cf.getAddress());
        ps.setString(3,cf.getState());
        ps.setString(4,cf.getCity());
        ps.setString(5,cf.getPincode());
        ps.setString(6,cf.getPhoneNo());
        ps.setString(7,cf.getFax());*/
        ps.setString(2,cf.getEmailid());
        /*ps.setString(9,cf.getTinNo());
        ps.setString(10,cf.getVatNo());*/
        ps.setString(3,cf.getPolicy_Deal_Days());
       /* ps.setString(12,cf.getSTC_code());
        ps.setString(13,cf.getSTC_Date());*/
        ps.setString(4,cf.getClient_id());
        System.out.println(cf.getCompany_Name()+" "+cf.getEmailid()+" "+cf.getPolicy_Deal_Days()+" "+cf.getClient_id());
        ps.executeUpdate();
        flag=true;
        ps.close();      
      }catch(Exception e)
        {
            System.out.println("Error Exception : " +e.getMessage());
        }
        return flag;       
    }
    public static boolean deleteinfo(ClientForm_Bean cf) throws SQLException, ClassNotFoundException
    {
       boolean checkid = false;
        try{
            Connection con = DBactivation.getConnection();
            String sql = "DELETE FROM form_client WHERE Client_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,cf.getClient_id());
            ps.executeUpdate();
            System.out.println("info delete");
            checkid=true;
            ps.close();
        }
        catch(Exception e){
            System.out.println("Error Exception : " +e.getMessage());
        }
        return checkid;
     
    }
}
