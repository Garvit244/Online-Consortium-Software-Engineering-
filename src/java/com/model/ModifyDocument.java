/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;

/**
 *
 * @author Garvit Bansal
 * @signature: caffrey
 */
import java.sql.*;

public class ModifyDocument
{
        private String D_TITLE,D_TYPE,D_SUBTYPE,D_VISIBILITY;
        private Connection con;
        private ResultSet rs;

        public void setTitle(String title)
        {
            this.D_TITLE=title;
        }

        public void setType(String type)
        {
            this.D_TYPE=type;
        }

        public void setSubtype(String subtype)
        {
            this.D_SUBTYPE=subtype;
        }

        public void setVisibility(String visibility)
        {
            this.D_VISIBILITY=visibility;
        }

        public boolean UpdateDocumentDetails(String did, String title, String type, String subtype, String Visibility)
        {
            boolean result=false;
            int visi;
            try
            {
                dBConnect connect = new dBConnect();
                con = connect.Connect();

                if(Visibility.equals("Public"))
                    visi=0;
                else if(Visibility.equals("Private"))
                    visi=1;
                else
                    visi=2;

                String query = "UPDATE document "+ "SET D_Title='"+title+"' ,D_Detail='"+type+"', Visibility='"+visi+"', D_Subtype='"+
                        subtype+"' WHERE D_ID='"+ did+"';";
                PreparedStatement st = con.prepareStatement(query);

                int no_rows=st.executeUpdate();
                return true;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("There is an exception in Modify Document");
                return result;
            }
        }
}
