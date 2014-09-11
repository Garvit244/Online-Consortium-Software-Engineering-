<!--
    This file is the Upload Page of the Registered User
    @author: Garvit Bansal
    @signature: caffrey
-->
<%@page import="com.model.Documentview"%>
<%@page import="com.model.Javabean_members"%>
<%@page import="java.sql.*"%>
<%@ page import="java.io.*,java.util.*" language="java" contentType="text/html;  charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <link rel="stylesheet" href="css/style_register.css">
        <title>JSP Page</title>
    </head>
            <%
            String Uname = new String("Uname");
            Uname=(String)session.getAttribute("usr");
            String visibility = request.getParameter("visibility");
          %>
    <body>

        <%
            Documentview D_View = new Documentview(Uname);
            D_View.display();
        %>

          <%
            Javabean_members bean = new Javabean_members();
            bean.setUID(Uname);
            bean.display_group();
        %>
        
            <div class="container">
        <section class="register">
            <h1>Select Document</h1>
        <form ENCTYPE="multipart/form-data" ACTION ="UploaddocServlet" METHOD="POST">
            <%
                String D_ID[] = D_View.getD_ID();
                String d_id = D_ID[0];
            %>
            <div class="reg_section personal_info">
                    <h3>Document ID:</h3>
                     <input type="text" name="d_id" value="<% out.print(d_id); %>" readonly>
                </div>
                <%
                    int temp=bean.checkgroup();
                    int no_group = bean.getcount();
                    int index=0;
                   // String temp2="dada";
                    String G_ID[] = bean.getGID();
                   // out.println(no_group);
                if(visibility.equals("2"))
                    {
                        out.println("<div class=\"reg_section personal_info\">");
                        out.println("<h3>Group ID:</h3>");
                        while(index != no_group)
                        {

                            out.println("<input type='radio' name='groupselect' value="+G_ID[index]+"");
                            out.println("<h3>"+G_ID[index]+"</h3>");
                            out.print("<br><br/>");
                            out.println();
                            index++;
                        }
                        out.println("</div>");
                    }
                %>
  
             <div class="reg_section personal_info">
                    <h3>Upload File:</h3>
                    <input type="file" name="file" required>
                </div>
                <p class="submit"><a href=UploaddocServlet?id=groupselect><input type="submit" name="commit" value="Upload"></a></p>
            
             </form>
        </section>
    </div>
    </body>
</html>
