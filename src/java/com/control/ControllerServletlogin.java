/* This file is the control servlet for the Login page
 * it show the home page according to the user
 * @author: Garvit Bansal
 * @signature: caffrey
 */

package com.control;

    import com.model.*;
    import java.io.IOException;
    import java.io.PrintWriter;
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

    public class ControllerServletlogin extends HttpServlet
    {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();

            String action = request.getParameter("action");

            if("Login".equals(action))
            {
                String name=request.getParameter("username");
                String password=request.getParameter("password");

                LoginBean bean=new LoginBean();
                bean.setName(name);
                bean.setPassword(password);
                request.setAttribute("bean",bean);

                boolean status=bean.validate(name,password);
                String admin = "admin";
                System.out.println(status);

                if(status)
                {
                    // to create the session for user
                    HttpSession session = request.getSession(true);
                    session.setAttribute("usr", name);

                    if(name.equals(admin))
                    {
                        RequestDispatcher rd=request.getRequestDispatcher("Repository_manager.jsp");
                        rd.forward(request, response);
                    }
                    else
                    {
                        RequestDispatcher rd=request.getRequestDispatcher("Register_User.jsp");
                        rd.forward(request, response);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "WRONG User-ID or Pssword !! Please enter again !!");
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            }
            else if("Register".equals(action))
            {
                    RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
                    rd.forward(request, response);
            }
            else if("Guest".equals(action))
            {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("usr","Guest");
                    JOptionPane.showMessageDialog(null, "You are entering the consortium as Guest User. You can only access PUBLIC Documents !!");
                    RequestDispatcher rd=request.getRequestDispatcher("Guest.jsp");
                    rd.forward(request, response);
            }
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException
        {
            doPost(req, resp);
        }
    }