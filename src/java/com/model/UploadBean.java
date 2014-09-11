/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author striker
 */
public class UploadBean
{
            private Connection con=null;
            private ResultSet rs,rs1;
            private Statement st,st1;

    public UploadBean()
    {
        dBConnect connect = new dBConnect();
        con = connect.Connect();
    }

    public int count() throws SQLException
    {
        st = con.createStatement();
        rs = st.executeQuery("select D_ID from document ORDER BY D_ID DESC LIMIT 1;");
        String count = null;
        while(rs.next())
        {
            count = rs.getString(1);
        }

        int d_id;
        if(count == null)
        {
              d_id=0;
              return d_id;
        }
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(count);

        String id=null;
        while(m.find())
        {
            id = m.group(1);
        }

        d_id = Integer.parseInt(id);
        d_id++;

        System.out.println("count+"+d_id);
        return d_id;
    }

    public boolean insert(String title, String type,String subtype, int visibility, String u_id)
    {
        try
        {
           // visibility=1;
            st1 = con.createStatement();
            String d="D_";
            String d_id = d+count();
            System.out.println("Document ID:"+d_id);
            String query = "INSERT INTO document VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
          //  PreparedStatement stmt = con.prepareStatement(query);
                        stmt.setString(1, d_id);

                        stmt.setString(2,title);
                        stmt.setString(3,type);
                        stmt.setInt(4, visibility);
                        stmt.setString(5,u_id);
                        stmt.setString(6,subtype);
                        stmt.setInt(7, 0);
                        System.out.println("subtype"+subtype);
                    int executeUpdate = stmt.executeUpdate();


                    PreparedStatement pst = con.prepareStatement("INSERT INTO uploaddocument(D_ID) VALUES(?)");
                    pst.setString(1, d_id);
                    pst.executeUpdate();

                    
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
              return false;
        }

    }

    public boolean upload(String saveFile)
    {
        try
        {

            System.out.println("Upload");
            File f = new File(saveFile);
            Statement stat = con.createStatement();
          //  PreparedStatement pst = con.prepareStatement("SELECT * FROM uploaddocument order by D_ID DESC LIMIT 1");
            ResultSet res = stat.executeQuery("SELECT * FROM uploaddocument order by D_ID DESC LIMIT 1");
            String D_ID=null;
            System.out.println("Upload");
            while(res.next())
            {
                D_ID = res.getString(1);
            }
            System.out.println("Uplaod Bean "+D_ID);

            PreparedStatement prt = con.prepareStatement("DELETE FROM uploaddocument where D_ID='"+D_ID+"'");
            prt.executeUpdate();
            System.out.println("Uplaod Bean "+D_ID);

  /*           if(groupid != "null")
            {
                 PreparedStatement psup = con.prepareStatement("insert into groupdocument(D_ID,G_ID) values(?,?)");
                 psup.setString(1, D_ID);
                 psup.setString(2, groupid);
                 int rest = psup.executeUpdate();
                 System.out.println("In group it is insertted");
            }
*/
           PreparedStatement psmnt = con.prepareStatement("insert into uploaddocument(D_ID,Document) values(?,?)");
            FileInputStream fis = new FileInputStream(f);
            psmnt.setString(1, D_ID);
            //System.out.println("The inbean d_id "+d_id);
            psmnt.setBinaryStream(2, (InputStream)fis, (int)(f.length()));
            int s = psmnt.executeUpdate();
            if(s >0)
                return true;
            else
                return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
}
