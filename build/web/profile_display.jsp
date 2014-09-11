<!DOCTYPE html>
<%@page import="com.model.Profile_view"%>
<%@page import="com.model.Profile_view"%>
<%@page import="java.sql.*"%>
<%@ page import="java.io.*,java.util.*" language="java" contentType="text/html;  charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Registration Form</title>
        <link rel="stylesheet" href="css/style_register.css">
    </head>

    <%
            String Uname = new String("Uname");
            Uname=(String)session.getAttribute("usr");
           //Profile_Display pd=new Profile_Display();
           Profile_view pd=new Profile_view(Uname);
           pd.access();
    %>
    <body>
    <div class="container">
        <section class="register">
            <h1>User Profile</h1>
            <form>
                <div class="reg_section personal_info">
                    <h3>User ID</h3>
                    <% out.print(pd.getid()); %>
                </div>
                <div class="reg_section personal_info">
                    <h3>User Name</h3>
                     <% out.print(pd.getname()); %>
                </div>
                <div class="reg_section password">
                    <h3>College Name</h3>
                    <% out.print(pd.getcollege()); %>
                </div>
                <div class="reg_section password">
                    <h3>Email Address</h3>
                    <% out.print(pd.getemail()); %>
                </div>
                <div class="reg_section password">
                    <h3>Contact No.</h3>
                    <% out.print(pd.getcontact()); %>
                </div>
                <div class="reg_section password">
                    <h3>Designation</h3>
                     <% out.print(pd.getdesignation()); %>
                </div>
            </form>
        </section>
    </div>
</body>
</html>
