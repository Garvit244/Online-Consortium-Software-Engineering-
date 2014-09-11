<%-- 
    Document   : index
    Created on : 1 Apr, 2014, 10:30:40 PM
    Author     : Tortuga
--%>

<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" language="java" contentType="text/html;  charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Registration Form</title>
        <link rel="stylesheet" href="css/style_register.css">
    </head>
    <body>
    <div class="container">
        <section class="register">
            <h1>Register on Knowledge Consoritum</h1>
            <form action="controllerservlet_registration" method="post" >
                <div class="reg_section personal_info">
                    <h3>User ID</h3>
                    <input type="text" name="uid" value="" placeholder="Your User Name" required>
                </div>
                <div class="reg_section personal_info">
                    <h3>Your Name</h3>
                    <input type="text" name="name" value="" placeholder="Your Name" required>
                </div>
                <div class="reg_section password">
                    <h3>Your Password</h3>
                    <input type="password" name="password" value="" placeholder="Your Password" required>
                    &nbsp;&nbsp;&nbsp;<input type="password" name="confirm" value="" placeholder="Confirm Password" required>
                </div>
                <div class="reg_section password">
                    <h3>Email Address</h3>
                    <input type="email" name="email" value="" placeholder="Your Email" class="validate-email" required>
                </div>
                <div class="reg_section password">
                    <h3>Phone No.</h3>
                    <input type="text" name="phone_no" value="" placeholder="Your Contact No." required>
                </div>
                <div class="reg_section password">
                    <h3>Designation</h3>
                    <input type="text" name="designation" value="" placeholder="Your Designation" required>
                </div>
                <div class="reg_section password">
                    <h3>College Name</h3>
                    <input type="text" name="college" value="" placeholder="Your Insititute" required>
                </div>
                <p class="terms">
                    <label>
                        <input type="checkbox" name="remember_me" id="remember_me" required>
                        I accept  <a href="terms.html">Consortium </a>Terms & Condition
                    </label>
                </p>
                <p class="submit"><input type="submit" name="commit" value="Sign Up"></p>
            </form>
        </section>
    </div>
</body>
</html>
