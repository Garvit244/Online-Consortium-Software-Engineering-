/**
 *
 * @author Sega
 */
package com.model;
import java.io.*;
import java.sql.*;

public class Profile_modify
{  
    private String uid;
    private String uname;
    private String oldpass;
    private String pass;
    private String confirm;
    private String email;
    private String contact;
    private String college;
    private String designation;
    public void setname( String value )             {uname = value;     }
    public String getname()                         {return uname;      }
    public void setoldpass( String value )             {oldpass = value;     }
    public String getoldpass()                         {return oldpass;      }
    public void setpass( String value )             {pass = value;     }
    public String getpass()                         {return pass;      }
    public void setconfirm( String value )             {confirm = value;     }
    public String getconfirm()                         {return confirm;      }
    public void setid( String value )               {uid = value;       }
    public String getid()                           {return uid;        }
    public void setemail( String value )            {email = value;     }
    public String getemail()                        {return email;      }
    public void setcontact( String value )          {contact = value;   }
    public String getcontact()                      {return contact;    }
    public void setcollege(String value)            {college= value;    }
    public String getcollege()                      {return college;    }
    public void setdesignation(String value)        {designation=value; }
    public String getdesignation()                  {return designation;}
    
    public boolean validate_email()
    { 
        if(email.indexOf('@')>0)
        {return true;}			
        else{return false;}
    }  
    public boolean validate_pass()      {System.out.println("New P >"+pass+"<Confirm P>"+confirm+"<");return pass.equals(confirm);}
    public boolean validate_phone()     {return contact.length() <= 13;  }        
    public boolean validate_uid()
        {
                String pwd = null;
                dBConnect connect = new dBConnect();
                Connection con=null;
                ResultSet rs;
                Statement st = null;
                
                try
                {
                    con = connect.Connect();
                    System.out.println("UIS"+uid);
                    String query = "select U_ID from USER where U_ID = '" + uid +"'";
                    st = con.createStatement();
                        // creating Query String
                        // excecuting query
                    rs = st.executeQuery(query);
                    
                    String temp=null;
                    
                    while (rs.next())
                    {
                        temp = rs.getString("U_ID");
                    }
                    
                    if(temp==null)
                        return false;
                    else
                        return true;
                }
               
                catch(SQLException e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception1\n");
                    return false;
                }
        }        
    public boolean validate_oldpass()
        {
                String pwd = null;
                dBConnect connect = new dBConnect();
                Connection con=null;
                ResultSet rs;
                Statement st = null;
                
                try
                {
                    con = connect.Connect();
                    String query = "select Password from USER where U_ID = '" + uid +"'";
                    st = con.createStatement();
                    rs = st.executeQuery(query);
                    String temp=null;
                    while (rs.next())
                    {
                        temp = rs.getString("Password");
                    }
                    System.out.println("Old Passowrd Entered=   START<"+oldpass+">END");
                    System.out.println("Actual Old Passowrd =   START<"+temp+">END");
                    System.out.println("OLD pass confirmation ->    "+temp.equals(oldpass));
                    return (oldpass.equals(temp));
                }
               
                catch(SQLException e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception1\n");
                    return false;
                }
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
                    String query = "select count(*) from user;";

                        System.out.println("User Id:"+uid);
                        System.out.println("Name:"+uname);
                        System.out.println("Password:"+pass);
                        System.out.println("Email_id:"+email);
                        System.out.println("Phone_No:"+contact);
                        System.out.println("Designation:"+designation);
                        System.out.println("College:"+college);
                        query = "Update user set U_Name=?,Password=?,E_Mail=?,Contact_No=?,Designation=?,College_Name=? where U_ID='"+uid+"'";
                        stmt = con.prepareStatement(query);
                        System.out.println("Query"+query);
                        //stmt.setString(1,uid);
                        stmt.setString(1,uname);
                        stmt.setString(2,pass);
                        stmt.setString(3,email);
                        stmt.setString(4,contact);
                        stmt.setString(5,designation);
                        stmt.setString(6,college);
                        System.out.println("Query"+query);
                        System.out.println("stmt"+stmt);
                        stmt.executeUpdate();
                    return true;
                }   
                catch(SQLException e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception\n");
                    return false;
                }
        }
    }  