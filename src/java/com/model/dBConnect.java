package com.model;
import java.sql.*;
/**
 *
 * @author Garvit
 */
public class dBConnect
{
        private Connection con;
        private Statement st;
        private ResultSet rs;

         public Connection Connect()
         {
             try
             {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consortium","root","");
             }
             catch(Exception ex)
             {
                 System.out.println("There is an Error in Database\n");
             }
             return con;
        }
}
