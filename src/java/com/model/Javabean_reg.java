package com.model;
import java.io.*;
import java.sql.*;

public class Javabean_reg
{  
	private String name,password,confirm,phone_no,designation,college,email_id,uid;  
  
        public void setUID(String uid)
        {
            this.uid=uid;
        }
        
        public String getUID()
        {
            return uid;
        }        
        
	public String getName() 
	{  
		return name;  
	}  
	
	public String getConfirm() 
	{  
		return confirm;  
	}  
	
	public void setConfirm(String confirm) 
	{  
		this.confirm = confirm;  
	} 

	public void setName(String name) 
	{  
		this.name = name;  
	}  
	
	public String getPassword() 
	{  
		return password;  
	}  
        
	public void setPassword(String password) 
	{  
		this.password = password;  
	}  

    public String getDesignation() 
	{  
		return designation;  
	}  
	
	public void setDesignation(String designation) 
	{  
		this.designation = designation;  
	} 
	
	public String getPhone() 
	{  
		return phone_no;  
	}  
	
	public void setPhone(String phone_no) 
	{  
		this.phone_no = phone_no;  
	} 
	
	public String getCollege() 
	{  
		return college;  
	}  
	
	public void setCollege(String college) 
	{  
		this.college = college;  
	} 
        
    public void setEmail(String email_id)
    {
            this.email_id=email_id;
    }
        
    public String getEmail()
    {
		return email_id;
    }
        
	public boolean validate_email()
	{ 
            if(email_id.indexOf('@')>0)
            {
                return true;
            }
			
            else
            {
                return false;
            }
	}  
        
    /**
     *
     * @return
     */
    public boolean validate_pass()
        {
            return password.equals(confirm); 
        }
        
        public boolean validate_phone()
        {
            return phone_no.length() <= 13;
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

                 /*   st = con.createStatement();
                    rs = st.executeQuery(query);
		
                    //System.out.println("loda");
                    
                    //System.out.println("Number of rows"+d2);
                    //System.out.println("Records from database:\n");

                    while(rs.next())
                    {
                        count= rs.getInt(1);
                        System.out.println("count:"+count);                       
                    }
                    
                    uid="U";
                    if(count!=0)
                    {
                        query = "SELECT U_ID FROM user ORDER BY U_ID LIMIT 1 OFFSET "+(count-1)+"";
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
                        uid=uid+number;
                        
                        System.out.println("User Id:"+uid);
                    }
                    else
                        uid="U1";
                   */ 
                        System.out.println("User Id:"+uid);
                        System.out.println("Name:"+name);
                        System.out.println("Password:"+password);
                        System.out.println("Email_id:"+email_id);
                        System.out.println("Phone_No:"+phone_no);
                        System.out.println("Designation:"+designation);
                        System.out.println("College:"+college);
                        
                        query = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";
                        stmt = con.prepareStatement(query);
                        System.out.println("Query"+query);
                        stmt.setString(1,uid);
                        stmt.setString(2,name);
                        stmt.setString(3,password);
                        stmt.setString(4,email_id);
                        stmt.setString(5,phone_no);
                        stmt.setString(6,designation);
                        stmt.setString(7,college);
                        System.out.println("Query"+query);
                        System.out.println("stmt"+stmt);
                        stmt.executeUpdate();
                        //st = con.createStatement();
                        System.out.println("Connection check!");
                        //rs = st.executeQuery(query);    
                    
                    return true;
                }   
               
                catch(SQLException e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception\n");
                    return false;
                }
        }
        
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
                    
                    if(temp!=null)
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

    }  