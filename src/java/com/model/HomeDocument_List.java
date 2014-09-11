package com.model;
import java.sql.*;

//@author Sega

public class HomeDocument_List
{
    private String U_ID;
    private Connection con;
    private ResultSet rs;
    private String D_ID[] = new String[100];
    private String D_TITLE[] = new String[100];
    private String D_TYPE[] = new String[100];
    private String D_SUBTYPE[] = new String[100];
    private String OWNER[] = new String[100];
    private int VISI[] = new int[100];
    private String VISIBILITY[] = new String[100];
    private int index=0;
    private String d_id;
    private String d_title;
    private String d_type;
    private String d_subtype;
    private String visibility;
    private int visi;

    public int index()              {        return index;    }    
    public String[] getD_ID()       {        return D_ID;    }
    public String getd_title()      {        return d_title;    }
    public String[] getD_TITLE()    {        return D_TITLE;    }
    public String[] getD_TYPE()     {        return D_TYPE;    }
    public String[] getOWNER()     {        return OWNER;    }
    public String[] getD_SUBTYPE()  {        return D_SUBTYPE;    }
    public String[] getVISIBILITY() {        return VISIBILITY;    }
    public String getd_id()         {        return d_id;    }
    public String getd_type()       {        return d_type;    }
    public String getd_subtype()    {        return d_subtype;           }
    public String getvisibility()    {        return visibility;    }
    public HomeDocument_List(String u_id)    {        U_ID=u_id;    }
    public void display() throws SQLException
    {
        try
        {
            dBConnect connect = new dBConnect();
            con = connect.Connect();
            PreparedStatement pst;
            if(U_ID.equals("guest"))
                pst = con.prepareStatement("SELECT * FROM document where Visibility=0 ORDER BY D_ID DESC");
            else    
                pst = con.prepareStatement("SELECT * FROM document ORDER BY D_ID DESC");
            rs = pst.executeQuery();
            while(rs.next())
            {
                int restriction=1;
                int v=rs.getInt(4);
                if(U_ID.equals("guest"))
                    restriction=0;
                else
                {
                    if(v==0)
                        restriction=0;
                    else if(v==1)
                    {
                        String owner=rs.getString(5);
                        if(owner.equals(U_ID))
                            restriction=0;
                        else
                            restriction=1;
                    }
                    else if(v==2)
                    {
                        restriction=0;
                    }
                }
                if(restriction==0)
                {
                    D_ID[index] = rs.getString(1);
                    D_TITLE[index] = rs.getString(2);
                    D_TYPE[index] =  rs.getString(3);
                    OWNER[index] =  rs.getString(5);
                    VISI[index] =v;
                    if(v== 0)
                        VISIBILITY[index] = "Public";
                    else if(v== 1)
                        VISIBILITY[index] = "Private";
                    else
                        VISIBILITY[index] = "Group";
                    D_SUBTYPE[index] = rs.getString(6);
                    index++;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("There is an exception in Document View");
        }
    }
     public void display_type(int classification_type, String code_type) throws SQLException
    {
        try
        {
            dBConnect connect = new dBConnect();
            con = connect.Connect();
            PreparedStatement pst;
            if(U_ID.equals("guest"))
            {
                if(classification_type==1)
                pst = con.prepareStatement("SELECT * FROM document where D_Detail='"+code_type+"' and Visibility=0 ORDER BY D_ID DESC");
                else
                pst = con.prepareStatement("SELECT * FROM document where D_Subtype='"+code_type +"' and Visibility=0 ORDER BY D_ID DESC");
                
            }
            else
            {
                if(classification_type==1)
                pst = con.prepareStatement("SELECT * FROM document where D_Detail='"+code_type+"' ORDER BY D_ID DESC");
                else
                pst = con.prepareStatement("SELECT * FROM document where D_Subtype='"+code_type +"' ORDER BY D_ID DESC");
            }
            rs = pst.executeQuery();

            while(rs.next())
            {
                int v=rs.getInt(4);
                int restriction=1;
                if(U_ID.equals("guest"))
                    restriction=0;
                else
                {
                    if(v==0)
                        restriction=0;
                    else if(v==1)
                    {
                        String owner=rs.getString(5);
                        if(owner.equals(U_ID))
                            restriction=0;
                        else 
                            restriction=1;
                    }
                    else if(v==2)
                    {
                        restriction=0;
                    }
                }
                if(restriction==0)
                {
                    D_ID[index] = rs.getString(1);
                    D_TITLE[index] = rs.getString(2);
                    D_TYPE[index] =  rs.getString(3);
                    OWNER[index] =  rs.getString(5);
                    VISI[index] =v;
                    if(v== 0)
                        VISIBILITY[index] = "Public";
                    else if(v== 1)
                        VISIBILITY[index] = "Private";
                    else
                        VISIBILITY[index] = "Group";
                    D_SUBTYPE[index] = rs.getString(6);
                    index++;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("There is an exception in Document View");
        }
    }
}
