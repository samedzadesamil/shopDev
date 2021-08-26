<!DOCTYPE html>
<html lang="tr">
<head>
<meta charset="utf-8">
<title>Login</title>
<link rel="stylesheet" href="css/loginStyle.css">
</head>
<body>

	<div class="login">
		<h1>Registartion</h1>
		<h3>${message}</h3>
		<form method="post" action="registration">
			<input type="text" name="nameR" placeholder="Full name"required="required" />
				 <input type="text" name="usernameR"placeholder="Username" required="required" />
				 <input type="password" name="passwordR" placeholder="Password"required="required" />
				 <input type="password" name="password2R"placeholder="Re-Type Password" required="required" />
				
			<button type="submit" class="btn btn-primary btn-block btn-large">Create
				Account.</button>
		</form>
		<a href="login.jsp" style="color: white;">Login</a>
	</div>


</body>

</html>