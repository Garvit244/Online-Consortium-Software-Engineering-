    package com.model;
    import java.sql.*;
    
    public class LoginBean
    {
        private String name,password;

        public String getName()
        {
            return name;
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

            public boolean validate(String username, String password)
            {
                String pwd = null;
                dBConnect connect = new dBConnect();
                Connection con;
                ResultSet rs;
                Statement st;
                try
                {
                    con = connect.Connect();
                    System.out.println(username);
//                    String query = "select * from user where U_Name='" + username+ "'";

                    st = con.createStatement();
                    rs = st.executeQuery("select * from user where U_ID='" + username+ "'");

                    System.out.println("Records from database:\n");

                    System.out.println("daad");
                    while(rs.next())
                    {
                        System.out.println("sasasas");
                        String d2 = rs.getString(3);
                        System.out.println("Password:"+d2);
                        
                        if(d2.equals(password))
                        {
                            return true;
                        }
                    }
                    return false;
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    System.out.println("There is an exception\n");
                    return false;
                }

            }
    }