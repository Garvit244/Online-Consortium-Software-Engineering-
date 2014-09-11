<!DOCTYPE HTML>
<html>
<head>
<title>Simple Login Form</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style_creategroup.css">
    
</head>

<body>
    
    <%
            String Uname = new String("Uname");
            Uname=(String)session.getAttribute("usr");
          %>
         
    <br/> <br/> <br/> <br/> <br/> <br/> <br/>       
    <div class="container">      
        <section class="register">
            <form  action="controllerservlet_group">
                <div class="reg_section personal_info">
                    <h3>Group Admin</h3>
                    
                    <input type="text" readonly name="group_admin" value=" <%out.print(Uname);
                   %>" >
                </div>
                <div class="reg_section personal_info">
                    <h3>Group Name</h3>
                    
                     <input type="text" required name="group_name">
                </div>
                                  
                  <br/> 
                  <input type="submit" class="btnLogin" value="Submit" tabindex="4">
                     
            </form>
        </section>          
    </div>          
</body>
</html>
