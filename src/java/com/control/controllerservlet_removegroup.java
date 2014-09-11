
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
import javax.servlet.http.HttpSession;
	
	public class controllerservlet_removegroup extends HttpServlet
	{
             @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{  
                    System.out.println("Inside addmember servlet");
                    response.setContentType("text/html");  
                    PrintWriter out=response.getWriter();
                    String g_id=request.getParameter("groupselect");
                    System.out.print("Selected Group:"+g_id);
                    //System.out.println("Selected User:"+u_id);
                    
                    Javabean_group bean=new Javabean_group();
                    bean.setgid(g_id);
                    boolean delete_status=bean.deletegroup();
                    System.out.println("Group Delete Status:"+delete_status);
                    
                    if(delete_status)
                    {    
                         out.print("<html><body>");
                            out.println("<script type=\"text/javascript\">"); 
                            out.println("alert('Group Removed Successfully!');");
                            out.println("window.location.href=\"Register_User.jsp\";");
                            out.println("");
                            out.println("</script></body></html>");
                    }
                    
                    else
                    {
                         out.print("<html><body>");
                            out.println("<script type=\"text/javascript\">"); 
                            out.println("alert('Exception in adding members!');");
                            out.println("window.location.href=\"Exception in deleting group!.jsp\";");
                            out.println("");
                            out.println("</script></body></html>");
                    }    
                        
	
                }
                
                 @Override
                    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                     doPost(req, resp);
                    }
        }    

       