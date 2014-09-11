
        package com.control; 
        import com.model.Javabean_members;
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
	
	public class controllerservlet_addmember extends HttpServlet
	{
             @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{  
                    System.out.println("Inside addmember servlet");
                    response.setContentType("text/html");  
                    PrintWriter out=response.getWriter();
                    String g_id=request.getParameter("groupselect");
                    System.out.print("Selected Group:"+g_id);
                    String u_id[]=request.getParameterValues("userselect");
                    //System.out.println("Selected User:"+u_id);
                    
                    Javabean_members bean=new Javabean_members();
                    bean.setid(u_id);
                    bean.setgid(g_id);
                    boolean enter_status=bean.insertuser();
                    System.out.println("Group Enter Status:"+enter_status);
                    
                    if(enter_status)
                    {    
                            out.print("<html><body>");
                            out.println("<script type=\"text/javascript\">"); 
                            out.println("alert('Members added to group!');");
                            out.println("window.location.href=\"Register_User.jsp\";");
                            out.println("");
                            out.println("</script></body></html>");
                    }
                    
                    else
                    {
                        out.print("<html><body>");
                        out.println("<script type=\"text/javascript\">"); 
                        out.println("alert('Error in adding members to the group!');");
                        out.println("window.location.href=\"select_group.jsp\";");
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
	