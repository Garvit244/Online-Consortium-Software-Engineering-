<%-- 
    Document   : subject
    Created on : 10 Apr, 2014, 1:59:13 PM
    Author     : Sega
--%>

<%@page import="com.model.HomeDocument_List"%>
<%@page import="com.model.HomeDocument_List"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
        <title>
            <%String type=request.getParameter("type");
        out.print(type);%>    
        </title>
	<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
	<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' />
	<script type='text/javascript' src='js/jquery.min.js'></script>
	<script type='text/javascript' src='js/menu_jquery.js'></script>
<link rel='stylesheet' type='text/css' href='css/stylesRegistereduser.css' />
<meta name="ROBOTS" content="NOINDEX, NOFOLLOW" />

<!-- JAVASCRIPT to clear search text when the field is clicked -->
<script type="text/javascript">
window.onload = function(){ 
	//Get submit button
	var submitbutton = document.getElementById("tfq");
	//Add listener to submit button
	if(submitbutton.addEventListener){
		submitbutton.addEventListener("click", function() {
			if (submitbutton.value == 'Search on website'){//Customize this text string to whatever you want
				submitbutton.value = '';
			}
		});
	}
}

$(document).ready(function() {
      $("#upload").click(function(event){
          $('#content').load('Upload.jsp');
      });
   });

   $(document).ready(function() {
      $("#viewprofile").click(function(event){
          $('#content').load('profile_display.jsp');
      });
   });

      $(document).ready(function() {
      $("#viewmydocument").click(function(event){
          $('#content').load('MyDocument.jsp');
      });
   });

         $(document).ready(function() {
      $("#modifydocument").click(function(event){
          $('#content').load('ModifyDocument.jsp');
      });
   });

            $(document).ready(function() {
      $("#creategroup").click(function(event){
          $('#content').load('create_group.jsp');
      });
   });

</script>
<!-- CSS styles for standard search box with placeholder text-->
<style type="text/css">
	#tfheader{
		background-color:#667DF0;
	}
	#tfnewsearch{
		float:left;
		padding:20px;
	}
	.tftextinput4{
		margin: 0;
		padding: 6px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		color:#666;
		border:1px solid #0076a3; border-right:0px;
		border-top-left-radius: 5px 5px;
		border-bottom-left-radius: 5px 5px;	
	}
	.tfbutton4 {
		margin: 0;
		padding: 0;
		width:30px;
		height:30px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		font-weight:bold;
		outline: none;
		cursor: pointer;
		text-align: center;
		text-decoration: none;
		color: #ffffff;
		border: solid 1px #0076a3; border-right:0px;
		border-top-right-radius: 5px 5px;
		border-bottom-right-radius: 5px 5px;
		background: #438db8 url('tf-search-icon.png');
	}
	/* Fixes submit button height problem in Firefox */
	.tfbutton4:-moz-focus-inner {
	  border: 0;
	}
	.tfclear{
		clear:both;
	}
</style>
</head>

<body bgcolor="#DAE8F9">

<div id ="container">
	<!-- HTML for SEARCH BAR -->
	<div id="tfheader">
        <div style="color:#FFFFFF;">
            <h1><center>Open Access Knowledge Consortium</center></h1>
        </div>
            <form id="tfnewsearch" method="get" action="http://www.google.com">
                <input type="text" id="tfq" class="tftextinput4" name="q" size="80" maxlength="120" value="Search on website">
                <input type="submit" value=" " class="tfbutton4">
            </form>

		<div class="tfclear"></div>
	</div>
</div>

        <%
            String Uname = new String("Uname");
            Uname=(String)session.getAttribute("usr");
          %>
<div id="container">

<div id="menu" style="width:240px;float:left;">
<div id='cssmenu'>
<ul name="lg">
   <% if((Uname.equals("Guest")))
   out.print("<li class='active'><a href='Guest.jsp'><span>Home</span></a></li>");
   else
   {
   out.print("<li class='active'><a href='Register_User.jsp'><span>Home</span></a></li>");
   out.print("<li class='has-sub'><a href='#'>");
   out.print("<span>"+Uname+"</span></a>");
   out.print("<ul>");
   out.print("      <li id=\"editprofile\"><a href='profile_edit.jsp'><span>Edit Profile</span></a></li>");
   out.print("      <li id=\"viewprofile\" class='last'><a href='#'><span>View Profile</span></a></li>");
   out.print("</ul>");
   out.print("</li>");
   out.print("<li class='has-sub'><a href='#'><span>Document</span></a>");
   out.print("<ul name=\"doc\">");
   out.print("      <li id=\"upload\"><a href='#'><span>Upload</span></a></li>");
   out.print("      <li id=\"viewmydocument\"><a href='#'><span>View Document</span></a></li>");
   out.print("      <li class='last' id=\"modifydocument\"><a href='#'><span>Modify Details</span></a></li>");
   out.print("   </ul>");
   out.print("</li>");
   out.print("<li class='has-sub last'><a href='#'><span>Group</span></a>");
   out.print("   <ul>");
   out.print("      <li class='#'><a href='#'><span>Create Group</span></a></li>");
   out.print("      <li class='#'><a href='#'><span>My Groups</span></a></li>");
   out.print("      <li class='last'><a href='#'><span>Delete Groups</span></a></li>");
   out.print("   </ul>");
   out.print("</li>");
   }
   %>
</ul>
</div>
</div>

	<div id="content" style="background-color:#FFFFFF;height:800px;width:950px;border-top:5pt;padding:10pt;float:left;">
		<div id="selectbutton" style="background-color:#7FB0FA;width:940px;height:80px;">
			<div style="border-top:3pt;padding:6pt;">
            <table style="width:700px">
                
                <% 
                int classification_type=0;
                String code_type="";
                String parent="";
                if(type.equals("Mathematics"))
                {
                    code_type="Mathematics";
                    classification_type=1;
                    out.print("<tr>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Linear Algebra\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Number Theory\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Graph Theory\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Calculus\" name=\"type\"></form></td>");
                    out.print("</tr>");
                }
                else 
                if(type.equals("Physics and Science"))
                {
                    code_type="Physics";
                    classification_type=1;
                }
                else 
                if(type.equals("Computer Science"))
                {
                    code_type="Computer Science";
                    classification_type=1;
                    out.print("<tr>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Cryptology\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"OOPS\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Networking\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Software Engineering\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"BIG Data\" name=\"type\"></form></td>");
                    out.print("</tr>");
                    out.print("<tr>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Algorithms\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Systems\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Theoritical CS\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Data Mining\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Information Retrieval\" name=\"type\"></form></td>");
                    out.print("</tr>");
                    
                }
                else 
                if(type.equals("Electronics and Communication"))
                {
                    code_type="Electronics and Communication";
                    classification_type=1;
                    out.print("<tr>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Nano Science\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"VLSI\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"Communication\" name=\"type\"></form></td>");
                    out.print("<td><form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\"General\" name=\"type\"></form></td>");
                    out.print("</tr>");
                }
                else 
                if(type.equals("Chemistry"))
                {
                    code_type="Chemistry";
                    classification_type=1;
                }
                else
                {
                    classification_type=2;
                    if(type.equals("Linear Algebra"))
                    {
                        parent="Mathematics";
                        code_type="Linear Algebra";
                    }
                    else if(type.equals("Number Theory"))
                    {
                        parent="Mathematics";
                        code_type="Number Theory";
                    }
                    else if(type.equals("Graph Theory"))
                    {
                        parent="Mathematics";
                        code_type="Graph Theory";
                    }
                    else if(type.equals("Calculus"))
                    {
                        parent="Mathematics";
                        code_type="Calculus";
                    }
                    else if(type.equals("Cryptology"))
                    {
                        parent="Computer Science";
                        code_type="Cryptology";
                    }
                    else if(type.equals("OOPS"))
                    {
                        parent="Computer Science";
                        code_type="OOPS";
                    }
                    else if(type.equals("Networking"))
                    {
                        parent="Computer Science";
                        code_type="Conputer Networking";
                    }
                    else if(type.equals("Software Engineering"))
                    {
                        parent="Computer Science";
                        code_type="Software Engineering";
                    }
                    else if(type.equals("BIG Data"))
                    {
                        parent="Computer Science";
                        code_type="Big Data";
                    }
                    else if(type.equals("Systems"))
                    {
                        parent="Computer Science";
                        code_type="Systems";
                    }
                    else if(type.equals("Algorithms"))
                    {
                        parent="Computer Science";
                        code_type="Algorithms";
                    }
                    else if(type.equals("Theoritical CS"))
                    {
                        parent="Computer Science";
                        code_type="Theoritical CS";
                    }
                    else if(type.equals("Data Mining"))
                    {
                        parent="Computer Science";
                        code_type="Data Mining";
                    }
                    else if(type.equals("Information Retrieval"))
                    {
                        parent="Computer Science";
                        code_type="Information Retrieval";
                    }
                    else if(type.equals("Nano Science"))
                    {
                        parent="Electronics and Communication";
                        code_type="Nano Science";
                    }
                    else if(type.equals("VLSI"))
                    {
                        parent="Electronics and Communication";
                        code_type="VLSI";
                    }
                    else if(type.equals("Communication"))
                    {
                        parent="Electronics and Communication";
                        code_type="Communication";
                    }
                    else if(type.equals("General"))
                    {
                        parent="Electronics and Communication";
                        code_type="ECE General";
                    }
                }
                %>
        </tr>
            </table>
	</div>
        <% HomeDocument_List doclist=new HomeDocument_List(Uname);
           doclist.display_type(classification_type,code_type);
        %>
        <div class="container">
                    <style type="text/css">
                    table.hovertable {
                            font-family: verdana,arial,sans-serif;
                            font-size:11px;
                            color:#333333;
                            border-width: 1px;
                            border-color: #999999;
                            border-collapse: collapse;
                    }
                    table.hovertable th {
                            background-color:#c3dde0;
                            border-width: 1px;
                            padding: 8px;
                            border-style: solid;
                            border-color: #a9c6c9;
                    }
                    table.hovertable tr {
                            background-color:#d4e3e5;
                    }
                    table.hovertable td {
                            border-width: 1px;
                            padding: 8px;
                            border-style: solid;
                            border-color: #a9c6c9;
                    }
                    </style>
                    <!-- Table goes in the document BODY -->
                    <div style="color:#0000FF;">
                    <h2><center> Consortium Documents</center></h2>
                    </div>
                    <table class="hovertable">
                    <%

                    String D_ID[] = doclist.getD_ID();
                    String D_TITLE[] = doclist.getD_TITLE();
                    String D_TYPE[] =doclist.getD_TYPE();
                    String OWNER[] =doclist.getOWNER();
                    String D_SUBTYPE[] = doclist.getD_SUBTYPE();
                    //String VISIBILITY[] = doclist.getVISIBILITY();
                    int no_doc = doclist.index();
                    if(no_doc==0)
                    {
                        out.print("<div style=\"color:#FF0000;\"><h3><centre>No Document Found to Display</centre></h3></div>");
                    }
                    else
                    {
                        int index=0;
                        out.print("<tr>");
                        out.print("<th>Document ID</th><th>Title</th><th>Owner</th><th>Type</th><th>Subtype</th></tr>");
                        while(index != no_doc)
                        {                
                            out.println("<tr onmouseover=\"this.style.backgroundColor='#ffff66';\"");
                            out.println("onmouseout=\"this.style.backgroundColor='#d4e3e5';\"><td>");
                            out.print("<a href=DownloadFileServlet?id="+D_ID[index]+">");
                        out.println(D_ID[index]);
                        out.print("</a>");
                            out.println("</td><td>");
                            out.println(D_TITLE[index]);
                            out.println("</td><td>");
                            out.println(OWNER[index]);
                            out.println("</td><td>");
                            out.println(D_TYPE[index]);
                            out.println("</td><td>");
                            out.println(D_SUBTYPE[index]);
                            out.println("</td></tr>");
                            index++;
                        }
                    }
                    if(classification_type==2)
                    out.print("<form action=\"subject.jsp\"><input type=\"submit\" style=\"font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;\" value=\""+parent+"\" name=\"type\"></form></td>");
                    %>
                    </table>
    </div>
</div>
</body>
</html>


