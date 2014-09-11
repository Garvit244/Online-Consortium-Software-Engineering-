<%@page import="com.model.HomeDocument_List"%>
<!--
    @author: Sega
-->

<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Search</title>
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
            String Uname ="guest";
          %>
<div id="container">

<div id="menu" style="width:240px;float:left;">
<div id='cssmenu'>
<ul name="lg">
   <li class='active'><a href='Guest.jsp'><span>Home</span></a></li>
   
</ul>
</div>
</div>
	<div id="content" style="background-color:#FFFFFF;height:800px;width:950px;border-top:5pt;padding:10pt;float:left;">
		<div id="selectbutton" style="background-color:#7FB0FA;width:940px;height:40px;">
			<div style="border-top:3pt;padding:6pt;">
            <table style="width:700px">
                
            <tr>
                <td><form action="subject.jsp"><input type="submit" style="font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;" value="Mathematics" name="type"></form></td>
		<td><form action="subject.jsp"><input type="submit" style="font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;" value="Physics and Science" name="type"></form></td>
		<td><form action="subject.jsp"><input type="submit" style="font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;" value="Computer Science" name="type"></form></td>
		<td><form action="subject.jsp"><input type="submit" style="font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;" value="Electronics and Communication" name="type"></form></td>
                <td><form action="subject.jsp"><input type="submit" style="font-face: 'Comic Sans MS'; color: #FFFFFF; background-color: #3D5BF1;" value="Chemistry" name="type"></form></td>
            </tr>
            </table>
	</div>
        <% HomeDocument_List doclist=new HomeDocument_List(Uname);
           doclist.display();
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
                        out.print("<h3>No Document Found to Display </h3>");
                    }
                    else
                    {
                        out.print("<tr><th>Document ID</th><th>Title</th><th>Owner</th><th>Type</th><th>Subtype</th></tr>");
                        int index=0;
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
                    %>
                    </table>
    </div>
</div>
</body>
</html>

