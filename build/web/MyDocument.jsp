<!--
    This file display the Document of the Regsitered User
    @author: Garvit Bansal
    @signature: caffrey
-->
<%@page import="com.model.Documentview"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="css/style_register.css">
        <title>My Documents</title>
    </head>

        <%
            String Uname = new String("Uname");
            Uname=(String)session.getAttribute("usr");
          %>
    <body>

        <%
            Documentview D_View = new Documentview(Uname);
            D_View.display();

        %>

      <div class="container">
        <section class="register">
            <h1>My Documents</h1>
            <form>
                <%

                    String D_ID[] = D_View.getD_ID();
                    String D_TITLE[] = D_View.getD_TITLE();
                    String D_TYPE[] =D_View.getD_TYPE();
                    String D_SUBTYPE[] = D_View.getD_SUBTYPE();
                    String VISIBILITY[] = D_View.getVISIBILITY();

                    int no_doc = D_View.index();
                    int index=0;

                    while(index != no_doc)
                    {
                        out.print("<div class=\"reg_section personal_info\">");
                        out.print("<h3>Document ID</h3>");
                        out.print("<a href=DownloadFileServlet?id="+D_ID[index]+">");
                        out.print(D_ID[index]);
                        out.print("</a>");
                        out.print("</div>");

                        out.print("<div class=\"reg_section personal_info\">");
                        out.print("<h3>Document Title</h3>");
                        out.print(D_TITLE[index]);
                        out.print("</div>");

                        out.print("<div class=\"reg_section personal_info\">");
                        out.print("<h3>Document Type</h3>");
                        out.print(D_TYPE[index]);
                        out.print("</div>");

                        out.print("<div class=\"reg_section personal_info\">");
                        out.print("<h3>Document Sub Type</h3>");
                        out.print(D_SUBTYPE[index]);
                        out.print("</div>");

                        out.print("<div class=\"reg_section personal_info\">");
                        out.print("<h3>Document Visibility</h3>");
                        out.print(VISIBILITY[index]);
                        out.print("</div>");

                        out.print("<br>");
                        index++;
                    }
                  %>

                
            </form>
        </section>
    </div>

    </body>
</html>
