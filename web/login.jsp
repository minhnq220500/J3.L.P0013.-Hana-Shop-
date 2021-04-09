<%-- 
    Document   : login
    Created on : Jan 11, 2021, 2:51:14 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Login Form</title>
    </head>
    <body>
        <div id="logreg-forms">
            <form class="form-signin" action="MainController" method="post">

                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>

                <p class="text-danger">${requestScope.MESSAGE}</p>

                <input name="txtUserID"  type="text" id="inputEmail" class="form-control" placeholder="Username" required="" autofocus="">
                <input name="txtPassword"  type="password" id="inputPassword" class="form-control" placeholder="Password" required="">

                <!--                <div class="form-group form-check">
                                    <input name="remember" value="1" type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                                </div>-->

                <button name="btnAction" value="Login" class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Login</button>

                <hr>

                <div class="social-login" style="text-align:center">
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Lab_Web_P0013/login-google&response_type=code&client_id=772114673702-8ae5u6l9gcknosn9bfmt57gnttjo8m4q.apps.googleusercontent.com&approval_prompt=force">
                        Login With Google+
                    </a>
                </div>

            </form>
            <br>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle() // display:block or none
                $('#logreg-forms .form-reset').toggle() // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $(() => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })
        </script>
    </body>
</html>
