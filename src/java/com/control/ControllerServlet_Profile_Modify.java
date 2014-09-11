package com.control;
import javax.swing.JOptionPane;
import com.model.Profile_modify;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// @author Sega
public class ControllerServlet_Profile_Modify extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {  
			response.setContentType("text/html");  
			PrintWriter out=response.getWriter();  
			
                        String uid=request.getParameter("id");
			String name=request.getParameter("name");  
			String oldpass=request.getParameter("oldpass");
			String pass=request.getParameter("pass");  
			String confirm=request.getParameter("confirm");
			String contact=request.getParameter("contact");
			String designation=request.getParameter("designation");
			String college=request.getParameter("college");
                        String email=request.getParameter("email");
			
                        Profile_modify bean=new Profile_modify();  
                        bean.setid(uid);
                        bean.setname(name);  
                        bean.setoldpass(oldpass);  
                        bean.setpass(pass);  
                        bean.setconfirm(confirm);
                        bean.setcontact(contact);
                        bean.setdesignation(designation);
                        bean.setcollege(college);
                        bean.setemail(email);
                        request.setAttribute("bean",bean);
                        
                        boolean status_oldpass=bean.validate_oldpass(); 
                        System.out.println("Status_oldpass ->   "+status_oldpass);
                        boolean status_pass=bean.validate_pass(); 
                        System.out.println("Status_pass ->  "+status_pass);
                        boolean status_phone=bean.validate_phone();  
                        System.out.println("Status_phone -> "+status_phone);
                        boolean status_email=bean.validate_email();
                        System.out.println("Status_email -> "+status_email);
                        boolean status_uid=bean.validate_uid();
                        System.out.println("Status_UID  ->  "+status_uid);
                        if(!status_oldpass || !status_pass || !status_phone || !status_email || !status_uid)
                        {
                            if(!status_uid)
                            {
                                            JOptionPane.showMessageDialog(null, "User ID is wrong");
                                            RequestDispatcher rd=request.getRequestDispatcher("profile_edit.jsp");  
                                            rd.forward(request, response);  
                                            
                           }
                            else if(!status_oldpass)
                            {
                                            System.out.println("OLD PASSWORD ERROR");
                                            JOptionPane.showMessageDialog(null, "OLD Password entered is WRONG !!");
                                            RequestDispatcher rd=request.getRequestDispatcher("profile_edit.jsp");  
                                            rd.forward(request, response);  
                           } 
                            else if(!status_pass)
                            {
                                            JOptionPane.showMessageDialog(null, "New Passwords do not MATCH !!");
                                            RequestDispatcher rd=request.getRequestDispatcher("profile_edit.jsp");  
                                            rd.forward(request, response);  
                                            
                           } 
                            else if(!status_phone)
                            {
                                            JOptionPane.showMessageDialog(null, "Enterd Contact number is INVALID !!");
                                            RequestDispatcher rd=request.getRequestDispatcher("profile_edit.jsp");  
                                            rd.forward(request, response);
                           } 
                            else if(!status_email)
                            {
                                            JOptionPane.showMessageDialog(null, "E-mail ID entere is INVALID !!");
                                            RequestDispatcher rd=request.getRequestDispatcher("profile_edit.jsp");  
                                            rd.forward(request, response);  
                            }
                        }          
                        else
                        {   
                            boolean status_db = bean.enterdatabase();
                            System.out.println("Status:"+status_db);
                            if(status_db)
                            {    
                                RequestDispatcher rd=request.getRequestDispatcher("Register_User.jsp");
                                rd.forward(request, response);  
                            }
                        }
                }
}
