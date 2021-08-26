<!DOCTYPE html>
<html lang="tr">
 <head>
     <meta charset="utf-8">
     <title>
     Login
    </title>   
    <link rel="stylesheet" href="css/loginStyle.css">
 </head>
 <body>


<div class="login">
  <h1>Login</h1>
  <h3>${message}</h3>
    <form method="post" action="login">
      <input type="text" name="u" placeholder="Username" required="required" />
        <input type="password" name="p" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
    <a href="registration.jsp" style="color: white;">Registration</a>
</div>

   
 </body>

</html>