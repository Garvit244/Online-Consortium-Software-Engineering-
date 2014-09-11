/*
 * Model Class to view all the documents of the looged in user
 * and open the template in the editor.
 */

package com.model;

/**
 *
 * @author Garvit Bansal
 * @signature: caffrey
 */
import java.sql.*;

public class Documentview
{
    private String U_ID;
    private Connection con;
    private ResultSet rs;
    private String D_ID[] = new String[50];
    private String D_TITLE[] = new String[50];
    private String D_TYPE[] = new String[50];
    private String D_SUBTYPE[] = new String[50];
    private int VISI[] = new int[50];
    private String VISIBILITY[] = new String[50];
    private int index=0;
    private String d_id;
    private String d_title;
    private String d_type;
    private String d_subtype;
    private String visibility;
    private int visi;

    public int index()
    {
        return index;
    }
    
    public String[] getD_ID()
    {
        return D_ID;
    }

    public String getd_title()
    {
        return d_title;
    }

    public String[] getD_TITLE()
    {
        return D_TITLE;
    }

    public String[] getD_TYPE()
    {
        return D_TYPE;
    }

    public String[] getD_SUBTYPE()
    {
        return D_SUBTYPE;
    }

    public String[] getVISIBILITY()
    {
        return VISIBILITY;
    }

     public String getd_id()
    {
        return d_id;
    }

    public String getd_type()
    {
        return d_type;
    }

    public String getd_subtype()
    {
        return d_subtype;
    }

    public String getvisibility()
    {
        return visibility;
    }

    public Documentview(String u_id)
    {
        U_ID=u_id;
    }

    public void display()
    {
        try
        {
            dBConnect connect = new dBConnect();
            con = connect.Connect();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM document WHERE U_ID='"+U_ID+"' ORDER BY D_ID DESC");
            rs = pst.executeQuery();

            while(rs.next())
            {
                D_ID[index] = rs.getString(1);
                D_TITLE[index] = rs.getString(2);
                D_TYPE[index] =  rs.getString(3);
                VISI[index] = rs.getInt(4);
                if(VISI[index] == 0)
                    VISIBILITY[index] = "Public";
                else if(VISI[index] == 1)
                    VISIBILITY[index] = "Private";
                else
                    VISIBILITY[index] = "Group";
                
                D_SUBTYPE[index] = rs.getString(6);
                index++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("There is an exception in Document View");
        }
    }

    public void modifydisplay(String d_id)
    {
        try
        {
            dBConnect connect = new dBConnect();
            con = connect.Connect();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM document WHERE D_ID='"+d_id+"'");
            rs = pst.executeQuery();

            while(rs.next())
            {
                d_id = rs.getString(1);
                d_title = rs.getString(2);
                d_type =  rs.getString(3);
                visi = rs.getInt(4);
                if(visi == 0)
                    visibility = "Public";
                else if(visi == 1)
                    visibility = "Private";
                else
                    visibility = "Group";

                d_subtype = rs.getString(6);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("There is an exception in Modify Document View");
        }
    }
}
