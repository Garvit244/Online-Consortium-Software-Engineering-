package com.model;
import com.model.dBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;//@author Sega
public class Profile_view
{
    private String uid;
    private String uname;
    private String email;
    private String contact;
    private String college;
    private String designation;

    public void setname( String value )             {uname = value;     }
    public String getname()                         {return uname;      }
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
    public Profile_view(String value) 
    {uid=value;}
    public void access() throws Exception
    {
        try {
            
            dBConnect db = new dBConnect();
            PreparedStatement pst = db.Connect().prepareStatement("Select * from user where U_ID='"+uid+"'");
            //Profile_Display obj = new Profile_Display();
            ResultSet i = pst.executeQuery();
            while(i.next())
            {
                uname=(i.getString(2));
                email=(i.getString(4));
                contact=(i.getString(5));
                designation=(i.getString(6));
                college=(i.getString(7));
            }
    }
        catch (Exception e) {
             e.printStackTrace();
        }

    }

}
