<%@page import="com.model.Profile_view"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>
Modify Profile
</title>
<!-- Meta Tags -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- JavaScript -->
<script type="text/javascript" src="js/wufoo.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="css/structure.css" type="text/css" />
<link rel="stylesheet" href="css/form.css" type="text/css" />
<link rel="stylesheet" href="css/theme.css" type="text/css" />
</head>
<body id="public">
    
    <%
            String Uid = new String("Uname");
            Uid=(String)session.getAttribute("usr");
           Profile_view pd=new Profile_view(Uid);
           pd.access();
%>

          %>
<div id="container">
<h1><a id="logo" href=""><% out.print(Uid); %></a></h1>
<form class="wufoo" action="ControllerServlet_Profile_Modify" method="post">
	<div class="info">
	<h2>Modify Profile</h2>
	</div>
	<ul>
	<li>	<label class="desc">User-ID</label>
		<div>
                    <input name="id" class="field text medium" type="text" readonly maxlength="255" value="<% out.print(pd.getid());%>">
		</div>	</li>
	<li>	<label class="desc">Name</label>
		<div>
		<input name="name" class="field text medium" type="text" maxlength="255" value="<% out.print(pd.getname());%> ">
		</div>	</li>
	<li>	<label class="desc">Old Password</label>
		<div>
		<input name="oldpass" class="field text medium" type="password" maxlength="255" value="" />
		</div>	</li>
	<li>	<label class="desc">New Password</label>
		<div>
		<input name="pass" class="field text medium" type="password" maxlength="255" value="" />
		</div>	</li>
	<li>	<label class="desc">Confirm New Password</label>
		<div>
		<input name="confirm" class="field text medium" type="password" maxlength="255" value="" />
		</div>	</li>
	<li>	<label class="desc">E-mail ID</label>
		<div>
		<input name="email" class="field text medium" type="text" maxlength="255" value="<% out.print(pd.getemail());%> ">
		</div>	</li>
	<li>	<label class="desc">Contact No.</label>
		<div>
		<input name="contact" class="field text medium" type="text" maxlength="255" value="<% out.print(pd.getcontact());%> ">
		</div>	</li>
	<li>	<label class="desc">College</label>
		<div>
		<input name="college" class="field text medium" type="text" maxlength="255" value="<% out.print(pd.getcollege());%> ">
		</div>	</li>
	<li>	<label class="desc">Designation</label>
		<div>
		<input name="designation" class="field text medium" type="text" maxlength="255" value="<% out.print(pd.getdesignation());%> ">
		</div></li>
	<li class="buttons">
		<input id="saveForm" class="btTxt" type="submit" value="Save" />
	</li>
	</ul>
</form>
</div>
</body>
</html>