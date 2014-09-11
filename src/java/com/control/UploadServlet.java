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
public class UploadServlet extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request,  HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

            String u_id = request.getParameter("id");
            System.out.println("Userid "+u_id);
            String title = request.getParameter("title");
            System.out.println("Title "+title);
            String typetemp = request.getParameter("selectoption");
            System.out.println("Title "+typetemp);
            String type;

            if(typetemp.equals("maths"))
                type = "Mathematics";
            else if(typetemp.equals("physics"))
                type = "Physics";
            else if(typetemp.equals("chemistry"))
                type = "Chemistry";
            else if(typetemp.equals("cse"))
                type = "Computer Science";
            else
                type = "Electronics";
            
            String subtypetemp = request.getParameter("selectsubtype");
            String subtype;

            if(subtypetemp.equals("la"))
                subtype = "Linear Algebra";
            else if(subtypetemp.equals("nt"))
                subtype = "Number Theory";
            else if(subtypetemp.equals("calculus"))
                subtype = "Calculus";
            else if(subtypetemp.equals("GT"))
                subtype = "Group Theory";
            else if(subtypetemp.equals("crypto"))
                subtype = "Cryptology";
            else if(subtypetemp.equals("oops"))
                subtype = "OOPS";
            else if(subtypetemp.equals("network"))
                subtype = "Networking";
            else if(subtypetemp.equals("sepm"))
                subtype = "Software Engineering";
            else if(subtypetemp.equals("dc"))
                subtype = "Distributed Computing";
            else if(subtypetemp.equals("bd"))
                subtype = "Big Data";
            else if(subtypetemp.equals("tcs"))
                subtype = "Theoritical CS";
            else if(subtypetemp.equals("algo"))
                subtype = "Algorithm";
            else if(subtypetemp.equals("systems"))
                subtype = "Systems";
            else if(subtypetemp.equals("ir"))
                subtype = "Information Retrieval";
            else if(subtypetemp.equals("dm"))
                subtype = "Data Mining";
            else if(subtypetemp.equals("comm"))
                subtype = "Communication";
            else if(subtypetemp.equals("vlsi"))
                subtype = "VLSI";
            else if(subtypetemp.equals("ns"))
                subtype = "Nano Science";
            else if(subtypetemp.equals("ecegen"))
                subtype = "ECE General";
            else if(subtypetemp.equals("pgen"))
                subtype = "Physics General";
            else if(subtypetemp.equals("cgen"))
                subtype = "Chemistry General";
            else
                subtype = "Others";

            String visibility = request.getParameter("visibility");
            int visi;
            if(visibility.equals("0"))
                visi = 0;
            else if(visibility.equals("1"))
                visi=1;
            else
                visi=2;
  /*      String saveFile="";
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
       */
            if(title == null)
            {
                out.print("<html><body>");
                               out.println("<script type=\"text/javascript\">");
                               out.println("alert('Please Enter correct Title!');");
                               out.println("window.location.href=\"upload.jsp\";");
                               out.println("");
                               out.println("</script></body></html>");
            }
            try
            {
                boolean result=false;
                UploadBean uploa = new UploadBean();
                System.out.println("sasasa");

              boolean result1=uploa.insert(title, type, subtype, visi, u_id);
      //         result = uploa.upload(saveFile);

                if(result1)
                {
                    RequestDispatcher rd=request.getRequestDispatcher("uploadpage.jsp");
                    rd.forward(request, response);
                }
            }
            catch(Exception ex)
            {

            }
        }

}
