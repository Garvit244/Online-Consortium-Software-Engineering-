package com.control;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadFileServlet extends HttpServlet
{
    @Override
   public void doGet(HttpServletRequest request,  HttpServletResponse response)throws IOException, ServletException
   {

       PrintWriter out = response.getWriter();
       String id =  request.getParameter("id");
       System.out.println("ID is: " + id);
       String filename = "Document"+id;

       try
       {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consortium","root","");
            Statement st1=con.createStatement();

            System.out.println("Inside the download servlet");

            String strQuery = "select Document from uploaddocument where D_ID='"+id+"'";
            ResultSet rs1 = st1.executeQuery(strQuery);
            String imgLen="";
            
            if(rs1.next())
            {
              imgLen = rs1.getString(1);
            }

            rs1 = st1.executeQuery(strQuery);

            if(rs1.next())
            {
                  int len = imgLen.length();
                  byte [] rb = new byte[len];
                  InputStream readImg = rs1.getBinaryStream(1);
                  int index=readImg.read(rb, 0, len);
                  st1.close();
                  response.reset();
                  //response.setContentType("image/jpg");
                  response.setHeader("Content-disposition","attachment; filename=" +filename);
                  response.getOutputStream().write(rb,0,len);
                  response.getOutputStream().flush();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
   }
}