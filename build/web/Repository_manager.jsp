<!--
    This file is the Home page of the Repository manager
    @author: Garvit Bansal
    @signature: caffrey
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
            <h1><center>Open Knowledge Consortium</center></h1>
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
   <li class='active'><a href='Repository_manager.jsp'><span>Home</span></a></li>
   <li class='has-sub'><a href='#'>
       <span>
           <%
           out.print(Uname);
           %>
       </span></a>
      <ul>
         <li><a href='#'><span>Edit Profile</span></a></li>
         <li id="viewprofile" class='last'><a href='#'><span>View Profile</span></a></li>
      </ul>
   </li>
   <li class='has-sub last'><a href='#'><span>Document</span></a>
      <ul name="doc">
         <li id=""><a href='#'><span>Validate</span></a></li>
         <li class='last'><a href='#'><span>Delete</span></a></li>
      </ul>
   </li>
</ul>
</div>
</div>

	<div id="content" style="background-color:#FFFFFF;height:800px;width:950px;border-top:5pt;padding:10pt;float:left;">
		


	</div>
</div>
</body>
</html>

