<%@page import="com.model.Javabean_members"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
               <link rel="stylesheet" href="css/style_register.css">
        <title>Add Members to Group</title>
    </head>
        <%
            String Uid = new String("Uid");
            Uid=(String)session.getAttribute("usr");
			out.println("UserID:"+Uid);
          %>
    <body>

        <%
            Javabean_members bean = new Javabean_members();
            bean.setUID(Uid);
            bean.display_group();

        %>
		
		 <div class="container" name="content">
        <section class="register">
                <h1>Add Members To Group</h1>
                <br/>
                <form action="controllerservlet_addmember">
                <%
                        String G_ID[] = bean.getGID();
							
			int temp=bean.checkgroup();
                        int no_group = bean.getcount();
							
                        int index=0;
                        
                    out.println("Please Select a group:");    
                    out.println("<br/><br/>");
                    while(index != no_group)
                    {
                        
                        out.println("<input type='radio' name='groupselect' value="+G_ID[index]+"");
                        out.println("<h3>"+G_ID[index]+"</h3>");
                        out.print("<br><br/>");
                        out.println();
                        index++;
                    }
                    
                    out.println("<br/><br/>");
                    out.println("Select Users:");    
                    out.println("<br/><br/>");
                    bean.display_user();
                    String U_ID[]=bean.getUID();
                    int no_user=bean.getuser_index();
    
                    index=0;
                    
                    while(index != no_user)
                    {
                        out.print("<input type='checkbox' name='userselect' value="+U_ID[index]+">"+U_ID[index]+"");
                        out.print("<br>");       
                        
                        
                        index++;
                    }    
                    
                %>
              <br/><br/>
              <input type="submit" value="Submit" name="Submit">
                </form>
            </section>
        </div>  
    </body>
</html>
