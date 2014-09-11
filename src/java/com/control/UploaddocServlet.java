/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.control;

import com.model.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author striker
 */
public class UploaddocServlet extends HttpServlet
{
    @Override
 public void doPost(HttpServletRequest request,  HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         String saveFile="";
         String d_id = request.getParameter("d_id");
        
         String group = request.getParameter("groupselect");
         
         System.out.println("group "+group);
         
        String contentType = request.getContentType();

        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
        {
            DataInputStream in = new DataInputStream(request.getInputStream());
            int formDataLength = request.getContentLength();
            byte dataBytes[] = new byte[formDataLength];
            int byteRead = 0;
            int totalBytesRead = 0;

            while (totalBytesRead < formDataLength)
            {
               // System.out.println("result");
                byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
                totalBytesRead += byteRead;
            }

            String file = new String(dataBytes);System.out.println("result");
            saveFile = file.substring(file.indexOf("filename=\"") + 10);
            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
            saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));

            int lastIndex = contentType.lastIndexOf("=");
            String boundary = contentType.substring(lastIndex + 1,contentType.length());

            int pos;
            pos = file.indexOf("filename=\"");
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;

            int boundaryLocation = file.indexOf(boundary, pos) - 4;
            int startPos = ((file.substring(0, pos)).getBytes()).length;
            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

            File ff = new File(saveFile);
            FileOutputStream fileOut = new FileOutputStream(ff);
            fileOut.write(dataBytes, startPos, (endPos - startPos));
            fileOut.flush();
            fileOut.close();

             try
            {
                boolean result=false;
                UploadBean uploa = new UploadBean();
                System.out.println("sasasa");

                result = uploa.upload(saveFile);

                if(result)
                {
                                                       out.print("<html><body>");
                                    out.println("<script type=\"text/javascript\">");
                                    out.println("alert('Uploaded Successfully!!');");
                                    out.println("window.location.href=\"Register_User.jsp\";");
                                    out.println("");
                                    out.println("</script></body></html>");
                }
            }
            catch(Exception ex)
            {

            }
        }
 }
}
