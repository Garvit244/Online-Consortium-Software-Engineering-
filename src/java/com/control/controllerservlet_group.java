
        package com.control; 
        import com.model.Javabean_group;
import com.mysql.jdbc.StringUtils;
import java.io.*;
	import java.io.IOException;  
	import java.io.PrintWriter;  
        import java.util.logging.Level;
        import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;        
	
	public class controllerservlet_group extends HttpServlet
	{
             @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{  
                    response.setContentType("text/html");  
			PrintWriter out=response.getWriter();  
			String uid=request.getParameter("group_admin");
                        String gname=request.getParameter("group_name");
                        
                        uid=uid.replaceAll("\\s+","");
                        System.out.println("UID:"+uid);
                        
                        Javabean_group bean=new Javabean_group();
                        bean.setUID(uid);
                        bean.setgname(gname);  
                        
                        boolean status_group=bean.enterdatabase();
                        System.out.println("Status_Group"+status_group);
                        
                        if(status_group)
                        {
                            out.print("<html><body>");
                            out.println("<script type=\"text/javascript\">"); 
                            out.println("alert('Group successfully created!');");
                            out.println("window.location.href=\"Register_User.jsp\";");
                            out.println("");
                            out.println("</script></body></html>");
                        }    
                        
                        else
                        {
                            out.print("<html><body>");
                            out.println("<script type=\"text/javascript\">"); 
                            out.println("alert('Error in creating group!');");
                            out.println("window.location.href=\"Register_User.jsp\";");
                            out.println("");
                            out.println("</script></body></html>");
                        }    
		}
                
                @Override
                    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                     doPost(req, resp);
                    }
                        
                public static void main()
                {
                    System.out.println("kushal");
                }        
		
	}
	