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
        <title>Modify Document Details</title>
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
          <div class="container" name="content">
        <section class="register">
                <h1>Modify Document Details</h1>
                <form action="modifydocumentdetails.jsp">
                <%
                            String D_TITLE[] = D_View.getD_TITLE();
                            String D_ID[] = D_View.getD_ID();
                            int no_doc = D_View.index();
                            int index=0;
                    while(index != no_doc)
                    {
                        out.println("<input type='radio' name='radioselect' value="+D_ID[index]+"");
                        out.println("<h3>"+D_TITLE[index]+"</h3>");
                        out.print("<br><br/>");
                        out.println();
                        index++;
                    }
                %>

              <input type="submit" value="Modify" name="modify">
                </form>
            </section>
        </div>
    </body>
</html>
