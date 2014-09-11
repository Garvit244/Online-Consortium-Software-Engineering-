/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;
import java.io.*;
import java.sql.*;

/**
 *
 * @author Tortuga
 */
public class Javabean_group
{
    private String gname,uid,gid;
    
    public void setUID(String uid)
    {
        this.uid=uid;
    }   
    
    public void setgname(String gname)
    {
        this.gname=gname;
    }
    
    public String getUID()
    {
        return uid;
    }
    
    public String getgname()
    {
        return gname;
    }        
    
    public boolean enterdatabase()
        {
                String pwd = null;
                dBConnect connect = new dBConnect();    
                Connection con=null;
                ResultSet rs;
                Statement st = null;
                int count=0;
                PreparedStatement stmt=null;
                
                try
                {
                    con = connect.Connect();
                    System.out.println("temo");
                    String query = "select count(*) from groupdetails;";

                    st = con.createStatement();
                    rs = st.executeQuery(query);
		
                    
                    
                    //System.out.println("Number of rows"+d2);
                    System.out.println("Records from database:\n");

                    while(rs.next())
                    {
                        count= rs.getInt(1);
                        System.out.println("count:"+count);                       
                    }
                    
                    gid="G";
                    if(count!=0)
                    {
                        query = "SELECT G_ID FROM groupdetails ORDER BY G_ID LIMIT 1 OFFSET "+(count-1)+"";
                        st = con.createStatement();
                        rs = st.executeQuery(query);
                        String temp1=null;
                        
                        while(rs.next())
                        {
                            temp1= rs.getString(1);
                            //System.out.println("count:"+count);                       
                        }
                        
                        String temp2=temp1.substring(1);
                        int number=Integer.parseInt(temp2);
                        number++;
                        gid=gid+number;
                        
                        System.out.println("Group Id:"+gid);
                    }
                    else
                        gid="G1";
                   
                    query = "INSERT INTO groupdetails VALUES (?,?,?)";
                    stmt = con.prepareStatement(query);
                    System.out.println("Query"+query);
                    stmt.setString(1,gid);
                    stmt.setString(2,gname);
                    stmt.setString(3,uid);
                    System.out.println("Query"+query);
                    System.out.println("stmt"+stmt);
                    int i=stmt.executeUpdate();
                    
                    return true;
                }
                
                catch(SQLException e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception\n");
                    return false;
                }
        }        
    
        public void setgid(String gid)
        {
            this.gid=gid;
        }        
    
        public boolean deletegroup()
        {
                String pwd = null;
                dBConnect connect = new dBConnect();    
                Connection con=null;
                ResultSet rs;
                Statement st = null;
                int count=0;
                PreparedStatement stmt=null;
                
                try
                {
                    con = connect.Connect();
                    System.out.println("temo");
                    String query =  "delete from groupdetails WHERE G_ID = '" + gid +"';";

                    st = con.createStatement();
                    st.executeUpdate(query);
	                   
                    
                    //System.out.println("Number of rows"+d2);
                    System.out.println("Records from database:\n");
                  
                    return true;
                }
                
                catch(SQLException e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception in delete group\n");
                    return false;
                }
        }        
}
