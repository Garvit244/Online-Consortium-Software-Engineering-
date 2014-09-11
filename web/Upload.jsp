<!--
    This file is the Upload page for the registered user
    @author: Garvit Bansal
    @signature: caffrey
-->
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" language="java" contentType="text/html;  charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Upload Document</title>
        <link rel="stylesheet" href="css/style_register.css">
    </head>
         <%
            String Uname = new String("Uname");
            Uname=(String)session.getAttribute("usr");
        %>
    <body>
    <div class="container">
        <section class="register">
            <h1>Upload Document</h1>
            <form action="UploadServlet" method="post" >
                <div class="reg_section personal_info">
                    <h3>U_ID:</h3>
                    <input type="text" name="id" value ="<% out.println(Uname); %>" readonly>
                </div>
               <div class="reg_section personal_info">
                    <h3>Title:</h3>
                    <input type="text" name="title" value="" placeholder="Document Title" required>
                </div>
                <div class="reg_section password">
                    <h3>Type:</h3>
                    <select name="selectoption">
                       <option value="maths">Mathematics</option>
                        <option value="physics">Physics</option>
                        <option value="chemistry">Chemistry</option>
                        <option value="cse">Computer Science and Engineering</option>
                        <option value="ece">Electronic and Communications</option>
                    </select>
                </div>
                <div class="reg_section password">
                    <h3>Sub Type:</h3>
                    <select name="selectsubtype">
               <option value="la">Mathematics - Linear Algebra</option>
                <option value="nt">Mathematics - Number Theory</option>
                <option value="calculus">Mathematics - Calculus</option>
                <option value="GT">Mathematics - Graph Theory</option>
                <option>----------------------</option>
                 <option value="crypto">CS - Cryptology</option>
                <option value="oops">CS - OOPS</option>
                <option value="network">CS - Networking</option>
                <option value="sepm">CS - Software Engineering</option>
                <option value="dc">CS - Distributed Computing</option>
                   <option value="bd">CS - Big Data</option>
                <option value="tcs">CS - Theoritical Computer Science</option>
                <option value="algo">CS - Algorithms</option>
                <option value="systems">CS - Systems</option>
                                <option value="ir">CS - Informational Retrieval</option>
                <option value="dm">CS - Data Mining</option>
                <option>----------------------</option>
                  <option value="comm">ECE - Communications</option>
                <option value="vlsi">ECE - VLSI</option>
                <option value="ns">ECE - Nano Science</option>
                <option value="ecegen">ECE - General</option>
                 <option>----------------------</option>
                  <option value="pgen">Physics - General</option>
                <option value="cgen">Chemistry - General</option>
                <option value="others">Others</option>

            </select>
                </div>
                <div class="reg_section password">
                    <h3>Visibility:</h3>
                    <select id="Visbility" name="visibility">
                <option value="0">Public</option>
                <option value="1">Private</option>
                <option value="2">Group</option>
            </select>
                </div>
        
                <p class="submit"><input type="submit" name="commit" value="Next"></p>
            </form>
        </section>
    </div>
</body>
</html>
