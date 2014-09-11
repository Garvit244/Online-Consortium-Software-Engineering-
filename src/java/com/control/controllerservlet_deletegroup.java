
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
	
	public class controllerservlet_deletegroup extends HttpServlet
	{
             @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{  
                    response.setContentType("text/html");  
			PrintWriter out=response.getWriter();  
			String uid=request.getParameter("uid");    
                        System.out.println("Inside deletegroup:"+uid);
                        
                        Javabean_members bean=new Javabean_members();
                        bean.setUID(uid);
                        int status_checkgroup=bean.checkgroup();
                        System.out.println("Status_Checkgroup:"+status_checkgroup);
                        
                        HttpSession session = request.getSession(true);
                        session.setAttribute("usr",uid);

                        
                        if(status_checkgroup == 1)
                        {
                            RequestDispatcher rd=request.getRequestDispatcher("delete_group.jsp");  
                            rd.forward(request, response); 
                        }   
                        
                        else if(status_checkgroup == 2)
                        {
                            out.print("<html><body>");
                            out.println("<script type=\"text/javascript\">"); 
                            out.println("alert('Please Create a group before deleting it!');");
                            out.println("window.location.href=\"Register_User.jsp\";");
                            out.println("");
                            out.println("</script></body></html>");
                        }    
                        
                        else
                        {
                                 out.print("<html><body>");
                                 out.println("<script type=\"text/javascript\">"); 
                                 out.println("alert('Exception in fetching group details.');");
                                 out.println("window.location.href=\"delete_group.jsp\";");
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
	