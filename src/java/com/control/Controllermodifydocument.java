/* This file is the control servlet for the modify the details of the document
 * 
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

/**
 *
 * @author striker
 */
public class Controllermodifydocument extends HttpServlet
    {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
        {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();

            String D_ID = request.getParameter("did");
            String D_TITLE = request.getParameter("dtitle");
            String D_TYPE = request.getParameter("dtype");
            String D_SUBTYPE = request.getParameter("dsubtype");
            String D_VISIBILITY = request.getParameter("dvisibility");

            ModifyDocument bean = new ModifyDocument();
            bean.setTitle(D_TITLE);
            bean.setType(D_TYPE);
            bean.setSubtype(D_SUBTYPE);
            bean.setVisibility(D_VISIBILITY);

            request.setAttribute("bean",bean);

            boolean result = bean.UpdateDocumentDetails(D_ID,D_TITLE, D_TYPE, D_SUBTYPE, D_VISIBILITY);

            if(result)
            {
                out.print("<html><body>");
                                        out.println("<script type=\"text/javascript\">");
                                        out.println("alert('Updated Successfully!!');");
                                        out.println("window.location.href=\"Register_User.jsp\";");
                                        out.println("");
                                        out.println("</script></body></html>");
            }
            else
            {
                out.println("Error");
            }
        }

}
