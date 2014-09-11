<%@page import="com.model.Documentview"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
            String did = request.getParameter("radioselect");
            Documentview D_View = new Documentview(Uname);
            D_View.modifydisplay(did);

         %>

     <div class="container">
        <section class="register">
            <h1>Modify Details of Document</h1>
            <form action="Controllermodifydocument" method="post" >
                <div class="reg_section personal_info">
                    <h3>Document ID</h3>
                    <input type="text" name="did" value="<% out.print(did);%>" readonly>
                </div>
                <div class="reg_section personal_info">
                    <h3>Document Title</h3>
                    <input type="text" name="dtitle" value="<% out.print(D_View.getd_title());%>" required>
                </div>
                <div class="reg_section personal_info">
                    <h3>Document Type</h3>
                    <input type="text" name="dtype" value="<% out.print(D_View.getd_type());%>" required>
                    
                </div>
                <div class="reg_section personal_info">
                    <h3>Document Sub Type</h3>
                    <input type="text" name="dsubtype" value="<% out.print(D_View.getd_subtype());%>" required>
                </div>
                <div class="reg_section personal_info">
                    <h3>Document Visibility</h3>
                    <input type="text" name="dvisibility" value="<% out.print(D_View.getvisibility());%>" required>
                </div>
                
                <p class="submit"><input type="submit" name="commit" value="Modify"></p>
            </form>
        </section>
    </div>
    
    </body>
</html>
