<%-- 
    Document   : index
    Created on : Mar 16, 2017, 10:42:46 AM
    Author     : Hatta NR
--%>

<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<style>

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>


<c:url var="loginUrl" value="j_spring_security_check"/>
<!--
<form class="form-signin" action="j_spring_security_check" method="POST">-->
<form class="form-signin" action="j_spring_security_check" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <input type="text" name="j_username" class="form-control" placeholder="Name" required autofocus>   
    <input type="password" name="j_password" class="form-control" placeholder="Password" required>
    <div class="checkbox">
        <label>
            <input type="checkbox" value="remember-me"/> Remember me
        </label>
    </div>   
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
    
    

<!--<form action="j_spring_security_check" method="POST">
        <label for="username">User Name:</label>
        <input id="username" name="j_username" type="text"/>
        <label for="password">Password:</label>
        <input id="password" name="j_password" type="password"/>
        <input type="submit" value="Log In"/>
      </form>-->