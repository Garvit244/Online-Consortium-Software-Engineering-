/* This file contains the controller servlet for registration of a new account */

	package com.control; 
        import com.model.Javabean_reg;
	import java.io.IOException;  
	import java.io.PrintWriter;  
	import javax.servlet.RequestDispatcher;  
	import javax.servlet.ServletException;  
	import javax.servlet.http.HttpServlet;  
	import javax.servlet.http.HttpServletRequest;  
	import javax.servlet.http.HttpServletResponse;  
        import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
	
	public class controllerservlet_registration extends HttpServlet
	{
	
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{  
			response.setContentType("text/html");  
			PrintWriter out=response.getWriter();  
			
                        String uid=request.getParameter("uid");
			String name=request.getParameter("name");  
			String password=request.getParameter("password");  
			String confirm=request.getParameter("confirm");
			String phone_no=request.getParameter("phone_no");
			String designation=request.getParameter("designation");
			String college=request.getParameter("college");
                        String email_id=request.getParameter("email");
			
                        uid=uid.replaceAll("\\s+","");
                            
                        Javabean_reg bean=new Javabean_reg();  
                        bean.setUID(uid);
                        bean.setName(name);  
                        bean.setPassword(password);  
                        bean.setConfirm(confirm);
                        bean.setPhone(phone_no);
                        bean.setDesignation(designation);
                        bean.setCollege(college);
                        bean.setEmail(email_id);
                        request.setAttribute("bean",bean);
                        
                   //     System.out.println(password);
                    //    System.out.println(confirm);
          
                        boolean status_pass=bean.validate_pass(); 
                        System.out.println("Status_pass"+status_pass);
                        boolean status_phone=bean.validate_phone();  
                        System.out.println("Status_phone"+status_phone);
                        boolean status_email=bean.validate_email();
                        System.out.println("Status_email"+status_email);
                        boolean status_uid=bean.validate_uid();
                        System.out.println("Status_UID"+status_uid);
                        
                        if(!status_pass || !status_phone || !status_email || !status_uid)
                        {
                            if(!status_pass & !status_uid & !status_email & !status_phone)
                            {
                                //if(!status_uid)
                                {    
                                    //if(!status_email)
                                    {
                                        //if(!status_phone)
                                        {    

                                            //out.println("<html><script language=javascript>window.alert('Click Ok to go to Index.jsp')</script></html>");
                                            //PrintWriter out=response.getWriter();
                                            out.print("<html><body>");
                                            out.println("<script type=\"text/javascript\">"); 
                                            out.println("alert('1.User Name already exists!\\n2.Please enter correct password\\n3.Please Enter a valid Email Id.\n4.Please enter a valid phone no. (13 digits)');");
                                            out.println("window.location.href=\"register.jsp\";");
                                            out.println("");
                                            out.println("</script></body></html>");

                                                                            //request.setAttribute("Staus_Pass","error") ;
                                                                            //response.sendRedirect("error_reg.jsp");
                                        }
                                    }    
                                }    
                           }
                            
                                           
                            else if(!status_uid & !status_phone & !status_email)
                            {
                                //if(!status_phone)
                                {
                                    //if(!status_email)
                                    {    
                                        out.print("<html><body>");
                                        out.println("<script type=\"text/javascript\">"); 
                                        out.println("alert('1.User Id already exists!\\n2.Please Enter a valid Email Id.\\n3.Please enter a valid phone no. (13 digits)');");
                                        out.println("window.location.href=\"register.jsp\";");
                                        out.println("");
                                        out.println("</script></body></html>");
                                    }    
                                }    
                            }    
                            //response.sendRedirect("register.jsp");
                            
                            else if(!status_uid & !status_pass & !status_email)
                            {
                                //if(!status_pass)
                                {    
                                    //if(!status_email)
                                    {    
                                        System.out.println("Tempupe");
                                        out.print("<html><body>");
                                        out.println("<script type=\"text/javascript\">"); 
                                        out.println("alert('1.User Id already exists!\\n2.Please Enter a valid Email Id.\\n3.Please enter a valid password!');");
                                        out.println("window.location.href=\"register.jsp\";");
                                        out.println("");
                                        out.println("</script></body></html>");
                                    }
                                }    
                            }
                            
                            else if(!status_uid & !status_phone & !status_pass)
                            {
                                //if(!status_phone)
                                {
                                    //if(!status_pass)
                                    {    
                                    
                                        out.print("<html><body>");
                                        out.println("<script type=\"text/javascript\">"); 
                                        out.println("alert('1.User Id already exists!\\n2.Please Enter a valid Password!\\n3.Please enter a valid phone no. (13 digits)');");
                                        out.println("window.location.href=\"register.jsp\";");
                                        out.println("");
                                        out.println("</script></body></html>");
                                    }
                                }    
                            }
                            
                            else if(!status_pass & !status_phone & !status_email)
                            {
                                //if(!status_phone)
                                {    
                                    //if(!status_email)
                                    {    
                                        out.print("<html><body>");
                                        out.println("<script type=\"text/javascript\">"); 
                                        out.println("alert('1.Please enter correct password\\n2.Please Enter a valid Email Id.\\n3.Please enter a valid phone no. (13 digits)');");
                                        out.println("window.location.href=\"register.jsp\";");
                                        out.println("");
                                        out.println("</script></body></html>");
                                    }
                                }    
                            }
                            
                            else if(!status_pass & !status_uid & !status_email)
                            {
                                //if(!status_uid)
                                {
                                    //if(!status_email)
                                    {
                                        System.out.println("pue");
                                        out.print("<html><body>");
                                        out.println("<script type=\"text/javascript\">"); 
                                        out.println("alert('1.Please enter correct password\\n2.User Id already exists.\\n3.Please enter a valid phone no. (13 digits)');");
                                        out.println("window.location.href=\"register.jsp\";");
                                        out.println("");
                                        out.println("</script></body></html>");
                                    }    
                                }    
                                
                            }
                            
                            else if(!status_pass & !status_phone & !status_email)
                            {
                                //if(!status_phone)
                                {
                                    //if(!status_email)
                                    {    
                                        out.print("<html><body>");
                                        out.println("<script type=\"text/javascript\">"); 
                                        out.println("alert('1.Please enter correct password!\\n2.Please Enter a valid Email ID!\\n3.Please enter a valid phone no. (13 digits)');");
                                        out.println("window.location.href=\"register.jsp\";");
                                        out.println("");
                                        out.println("</script></body></html>");
                                    }
                                }    
                            }
                            
                            else if(!status_uid & !status_pass)
                            {
                                //if(!status_pass)
                                {
                                    System.out.println("kushl");
                                    out.print("<html><body>");
                                    out.println("<script type=\"text/javascript\">"); 
                                    out.println("alert('1.User Id already exists!\\n2.Please enter correct password!');");
                                    out.println("window.location.href=\"register.jsp\";");
                                    out.println("");
                                    out.println("</script></body></html>");
                                }    
                            }    
                            
                            else if(!status_uid & !status_phone)
                            {
                                //if(!status_phone)
                                {    
                                    out.print("<html><body>");
                                    out.println("<script type=\"text/javascript\">"); 
                                    out.println("alert('1.User Id already exists!\\n2.Please enter a valid Phone No.(13 digits).');");
                                    out.println("window.location.href=\"register.jsp\";");
                                    out.println("");
                                    out.println("</script></body></html>");
                                }    
                            }    
                            
                            else if(!status_uid & !status_email)
                            {
                                //if(!status_email)
                                {    
                                    out.print("<html><body>");
                                    out.println("<script type=\"text/javascript\">"); 
                                    out.println("alert('1.User Id already exists!\\n2.Please enter a valid E-mail.');");
                                    out.println("window.location.href=\"register.jsp\";");
                                    out.println("");
                                    out.println("</script></body></html>");
                                }    
                            }    
                            
                            else if(!status_pass & !status_email)
                            {
                                //if(!status_email)
                                {    
                                    out.print("<html><body>");
                                    out.println("<script type=\"text/javascript\">"); 
                                    out.println("alert('1.Please Enter a Valid Password!\\n2.Please enter a valid E-mail.');");
                                    out.println("window.location.href=\"register.jsp\";");
                                    out.println("");
                                    out.println("</script></body></html>");
                                }    
                            }
                            
                            else if(!status_pass & !status_phone)
                            {
                                //if(!status_phone)
                                {    
                                    out.print("<html><body>");
                                    out.println("<script type=\"text/javascript\">"); 
                                    out.println("alert('1.Please enter a valid password!\\n2.Please enter a valid Phone No.(13 digits).');");
                                    out.println("window.location.href=\"register.jsp\";");
                                    out.println("");
                                    out.println("</script></body></html>");
                                }    
                            }
                            
                            else if(!status_phone & !status_email)
                            {
                                
                                {    
                                    out.print("<html><body>");
                                    out.println("<script type=\"text/javascript\">"); 
                                    out.println("alert('1.Please enter a valid E-Mail ID!\\n2.Please enter a valid Phone No.(13 digits).');");
                                    out.println("window.location.href=\"register.jsp\";");
                                    out.println("");
                                    out.println("</script></body></html>");
                                }    
                            }    
                            
                            else if(!status_phone)
                            {
                                out.print("<html><body>");
                                out.println("<script type=\"text/javascript\">"); 
                                out.println("alert('Please enter a valid Phone No.(13 digits).');");
                                out.println("window.location.href=\"register.jsp\";");
                                out.println("");
                                out.println("</script></body></html>");
                            }  
                            
                            else if(!status_email)
                            {
                                out.print("<html><body>");
                                out.println("<script type=\"text/javascript\">"); 
                                out.println("alert('Please enter a valid E-Mail ID!');");
                                out.println("window.location.href=\"register.jsp\";");
                                out.println("");
                                out.println("</script></body></html>");
                            }    
                            
                            else if(!status_uid)
                            {
                                out.print("<html><body>");
                                out.println("<script type=\"text/javascript\">"); 
                                out.println("alert('User Id already exists!');");
                                out.println("window.location.href=\"register.jsp\";");
                                out.println("");
                                out.println("</script></body></html>");
                            }  
                            
                            else if(!status_pass)
                            {
                                out.print("<html><body>");
                                out.println("<script type=\"text/javascript\">"); 
                                out.println("alert('Please enter correct password!');");
                                out.println("window.location.href=\"register.jsp\";");
                                out.println("");
                                out.println("</script></body></html>");
                            }  
                            
                        }
                                       
                        else
                        {   
                            boolean status_db = bean.enterdatabase();
                            System.out.println("Status:"+status_db);
                            if(status_db)
                            {    
                                out.print("<html><body>");
                                out.println("<script type=\"text/javascript\">"); 
                                out.println("alert('Registered Successfully!');");
                                out.println("window.location.href=\"index.jsp\";");
                                out.println("");
                                out.println("</script></body></html>");
                            }
                        }
                }
                    /*@Override
                    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                     doPost(req, resp);
                    }*/
        }