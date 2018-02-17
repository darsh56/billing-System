
package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author navkar
 */
public class DBactivation {

    public static Connection con;


    public static Connection getConnection()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String URL ="jdbc:mysql://localhost:3306/billing"; 
        con = DriverManager.getConnection(URL,"root","root");  
        System.out.println("connected");
    }catch(Exception e)
    {
        
    }
    return con;   
    }
     

}
