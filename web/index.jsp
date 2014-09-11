<!--
    This file is the Login page
    @author: Garvit Bansal
    @signature: caffrey
-->
<!DOCTYPE html>

<html lang='en'>
<head>
    <meta charset="UTF-8" />
    <title>
        Open Knowledge Consortium
    </title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<center><font color="white"><H2>Open Knowledge Consortium </H2></font></center>
<div id="wrapper">

	<form name="login-form" class="login-form" action="ControllerServletlogin" method="post">

		<div class="header">
		<h1>Login Form</h1>
		<span>Fill out the form Details.</span>
		</div>

		<div class="content">
		<input name="username" type="text" class="input username" placeholder="Username" />
		<div class="user-icon"></div>
		<input name="password" type="password" class="input password" placeholder="Password" />
		<div class="pass-icon"></div>
		</div>
		<div class="footer">
		<input type="submit" name="action" value="Login" class="button" />
		<input type="submit" name="action" value="Register" class="register" />
		<input type="submit" name="action" value="Guest" class="button" />
		</div>

	</form>

</div>
<div class="gradient"></div>


</body>
</html>
