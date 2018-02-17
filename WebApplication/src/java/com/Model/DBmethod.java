
package com.Model;

import com.Bean.City_Bean;
import com.Bean.Login_Bean;
import com.Bean.State_Bean;
import static com.Model.DBactivation.con;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static java.lang.System.out;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
public class DBmethod 
{ 
    
    static int count;
   
    public static boolean insert(State_Bean ub) throws SQLException, ClassNotFoundException
    {
         PreparedStatement ps;
         ResultSet rs=null;
         System.out.println("INSERT()");
         boolean flag=false;
   
        Connection con;
        con=DBactivation.getConnection();
        String n= ub.getState_Name();
        System.out.println(n);
        System.out.println("inserting");
        ps=con.prepareStatement("INSERT into state_entry values (null,?)"); 
        ps.setString(1,n);
        count=ps.executeUpdate();
        flag=true;
        return flag;
       
    }
    public static ArrayList<State_Bean> getstate() throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            Connection con;
            con=DBactivation.getConnection();
            System.out.println("Inside GETSTATE()");
            ArrayList<State_Bean> al=new ArrayList<State_Bean>();
            String query = "select State_id,State_Name from state_entry";
            ps = con.prepareStatement(query);
            rs= ps.executeQuery();
            
            while(rs.next())
            {
                State_Bean sb=new State_Bean();
                sb.setState_id(rs.getString("State_id"));
                sb.setState_Name(rs.getString("State_Name"));
                al.add(sb);
            }    
        return al;
        
    } 
     public boolean IsUpdateState(State_Bean bean){
        boolean check_id = false;
        try
        {
            Connection con = DBactivation.getConnection();
            String sql = "UPDATE state_entry SET State_Name=? WHERE State_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, bean.getState_id());
            ps.setString(1, bean.getState_Name());
            ps.executeUpdate();
            check_id=true;
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println("Error Exception : " +e.getMessage());
        }
        return check_id;
    }

    public boolean IsDeleteState(State_Bean bean){
        boolean checkid = false;
        try{
            Connection con = DBactivation.getConnection();
            String sql = "DELETE FROM state_entry WHERE State_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,bean.getState_id());
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

    public static boolean insertCity(City_Bean cb) throws SQLException, ClassNotFoundException
    {
         PreparedStatement ps;
         ResultSet rs=null;
         System.out.println("INSERT()");
         boolean flag=false;
   
        Connection con;
        con=DBactivation.getConnection();
        String sid=cb.getState_id();
        String n= cb.getCity_Name();
        System.out.println(sid);
        System.out.println(n);
        System.out.println("inserting");
        ps=con.prepareStatement("INSERT into city_entry values (null,?,?)"); 
        ps.setString(1,sid);
        ps.setString(2,n);
        count=ps.executeUpdate();
        flag=true;
        return flag;
       
    }
    public static ArrayList<City_Bean> getCity() throws SQLException, ClassNotFoundException
    {
            ResultSet rs=null;
            PreparedStatement ps;
            System.out.println("Inside GETCITY()");
            int idc=0;
            int ids=0;
            String name=null;
            ArrayList<City_Bean> al=new ArrayList<City_Bean>();
            Connection con;
            con=DBactivation.getConnection();            
            
            String query = "SELECT * FROM city_entry"; 
            
            ps = con.prepareStatement(query);
            rs= ps.executeQuery();
            
            while(rs.next())
            {
                City_Bean cb=new City_Bean();
                cb.setCity_id(rs.getString("City_id"));
                cb.setState_id(rs.getString("State_id"));
                cb.setCity_Name(rs.getString("City_Name"));
                System.out.println(cb);
                al.add(cb);
            }    
        return al;        
    }       
    
    public boolean IsDeleteCity(City_Bean bean){
        boolean checkid=false;
        try{
            Connection con = DBactivation.getConnection();
            String sql = "DELETE FROM city_entry WHERE City_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bean.getCity_id());
            ps.executeUpdate();
            checkid=true;
            ps.close();
        }
        catch(Exception e){
            System.out.println("Erro Exception : " +e.getMessage());
        }
        return checkid;
    }
    public boolean IsUpdateCity(City_Bean bean){
        boolean checkid=false;
        try{
            Connection con = DBactivation.getConnection();
            String sql = "UPDATE city_entry SET State_id=?,City_Name=? WHERE City_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,bean.getState_id());
            ps.setString(2,bean.getCity_Name());
            ps.setString(3,bean.getCity_id());
            ps.executeUpdate();
            checkid=true;
            ps.close();
        }
        catch(Exception e){
            System.out.println("Error Exception : " +e.getMessage());
        }
        return checkid;
    }
    public boolean isAutho(Login_Bean bean)
    {
        boolean check_connection=false;
        try
        {     
           System.out.println("inside isAutho()");
           Connection conn=DBactivation.getConnection();
            
            String sql="SELECT Username,Password FROM logintab WHERE Username='admin'";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                String unm=rs.getString("username");
                String pass=rs.getString("password");
                
                if(unm.equals(bean.getUsername()) && pass.equals(bean.getPassword()))
                        {
                            check_connection=true; 
                            System.out.println("Hello ...");
                        }
            }  
        }catch(Exception e)
        {
           System.out.println(""+e);
        }
       return check_connection;
     }  
    
    public boolean isStaff(Login_Bean bean)
    {
        boolean check_connection=false;
        try
        {     
           System.out.println("inside isAutho()");
           Connection conn=DBactivation.getConnection();
            
            String sql="SELECT Username,Password FROM logintab WHERE Username='staff'";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                String unm=rs.getString("username");
                String pass=rs.getString("password");
                
                if(unm.equals(bean.getUsername()) && pass.equals(bean.getPassword()))
                        {
                            check_connection=true; 
                            System.out.println("Hello ...");
                        }
            }  
        }catch(Exception e)
        {
           System.out.println(""+e);
        }
       return check_connection;
     }  
}