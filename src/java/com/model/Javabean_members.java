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
public class Javabean_members
{
    private String gname,uid,gid;
    private String G_ID[] = new String[50];
    private String U_ID[] = new String[50];
    int count=0,user_index=0;
    
    public void setUID(String uid)
    {
        this.uid=uid;
    }   
    
    public String[] getGID()
    {
        return G_ID;
    }        

    public int getcount()
    {
        return count;
    }        
    
    public int checkgroup()
        {
                String pwd = null;
                dBConnect connect = new dBConnect();    
                Connection con=null;
                ResultSet rs=null;
                Statement st = null;
                
                PreparedStatement stmt=null;
                
                try
                {
                    con = connect.Connect();
                    System.out.println("temo");
                    String query = "select count(*) from groupdetails WHERE G_ADMIN = '" + uid +"';";

                    st = con.createStatement();
                    rs = st.executeQuery(query);
		
                    System.out.println("adol");
                    
                    //System.out.println("Number of rows"+d2);
                    System.out.println("Number of groups:\n");

                    while(rs.next())
                    {
                        count= rs.getInt(1);
                        System.out.println("count:"+count);                       
                    }
                    
                    
                    if(count!=0)
                        return 1;
                    else
                        return 2;
                }
                
                catch(SQLException e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception\n");
                    return 0;
                }
                     
        }       
    
        public void display_group()
        {
            String pwd = null;
            dBConnect connect = new dBConnect();    
            Connection con=null;
            ResultSet rs=null;
            Statement st = null;
            String temp=null;
            PreparedStatement stmt=null;
            int index=0;
            int user_index=0;
            
            try
            {
                con = connect.Connect();
                System.out.println("Number of groups");
                String query = "select G_ID from groupdetails WHERE G_ADMIN = '" + uid +"';";
                
                st = con.createStatement();
                rs = st.executeQuery(query);
		
                System.out.println("Check number of groups");
                    
                    //System.out.println("Number of rows"+d2);
                System.out.println("Groups:\n");

                while(rs.next())
                {
                    temp= rs.getString(1);
                    System.out.println("Group:"+temp);  
                    G_ID[index]=temp;
                    index++;
                }
            }    
            
             catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("There is an exception in Group View");
            }

        }  
        
        public void display_user()
        {
            String pwd = null;
            dBConnect connect = new dBConnect();    
            Connection con=null;
            ResultSet rs=null;
            Statement st = null;
            String temp=null;
            PreparedStatement stmt=null;
            
            
            try
            {
                con = connect.Connect();
                System.out.println("Number of groups");
                String query = "select U_ID from user WHERE U_ID != '" + uid +"' and U_ID !='admin';";
                //String query2 = "select U_ID from "+query+" WHERE U_ID != 'admin';";
                
                st = con.createStatement();
                rs = st.executeQuery(query);
		
                System.out.println("Check number of Users");
                    
                    //System.out.println("Number of rows"+d2);
                System.out.println("Users:\n");

                while(rs.next())
                {
                    temp= rs.getString(1);
                    System.out.println("User:"+temp);  
                    U_ID[user_index]=temp;
                    user_index++;
                }
            }    
            
             catch(Exception e)
            {
                System.out.println(e);
                e.printStackTrace();
                System.out.println("There is an exception in User View");
            }
        }    
        
        public String[] getUID()
        {
            return U_ID;
        }           
        
        public int getuser_index()
        {
            return user_index;
        }        
        
        String id[]=new String[50];
        String gid2;
        
        public void setid(String[] id)
        {
            this.id=id;
        }    
        
        public void setgid(String gid2)
        {
            this.gid2=gid2;
        }        
        
        public boolean insertuser()
        {
            String pwd = null;
            dBConnect connect = new dBConnect();    
            Connection con=null;
            ResultSet rs=null;
            Statement st = null;
            String temp=null;
            PreparedStatement stmt=null;
            
            try
            {
                con = connect.Connect();
                System.out.println("Insert into groups");
                
                for(String temo:id)
                {    
                    String query = "insert into groupmember Values(?,?);";
                    stmt = con.prepareStatement(query);
                    System.out.println("Query"+query);
                    stmt.setString(1,gid2);
                    stmt.setString(2,temo);

                    System.out.println("Inserting into groupmembers.");
                    System.out.println("Query"+query);
                    System.out.println("stmt"+stmt);
                    stmt.executeUpdate();
                        //System.out.println("Number of rows"+d2);
                    //System.out.println("Users:\n");
                }
                
                return true;
            }  
            catch(Exception e)
            {
                System.out.println("There is an exception in User Group Entry View");
                System.out.println(e);
                return false;
                
            }
            
          
        }        
}
