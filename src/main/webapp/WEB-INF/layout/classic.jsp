<%-- 
    Document   : classic
    Created on : Mar 16, 2017, 11:47:06 AM
    Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@include file="../layout/taglib.jsp" %>
<c:url var="logoutUrl" value="/logout"/>


<!DOCTYPE html>
<html>
    <head>
        <%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>

        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title"/></title>

        <!-------------------------------Firebase-------------------------------->
        <!-- Web Application Manifest -->
        <link rel="manifest" href="web-start/manifest.json">

        <!-- Add to homescreen for Chrome on Android -->

        <!-- Material Design Lite -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.orange-indigo.min.css">
        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>

        <!-- App Styling -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        
        <!-- -----------------------------------------------------------------------------       -->
    </head>
    <body>
        <%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
        <tilesx:useAttribute name="current"/>
        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="<spring:url value="/" />">Web Service</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="${current == 'index' ? 'active':''}"><a href="<spring:url value="/" />">Home</a></li>
                           
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                <li class="${current == 'users' ? 'active':''}"><a href="<spring:url value="/users.html"/>">Users</a></li>
                                <li class="${current == 'register' ? 'active':''}"><a href="<spring:url value="/register.html"/>">Register User</a></li>
                                </security:authorize>
                                <li class="${current == 'chat' ? 'active':''}"><a href="<spring:url value="/chat.html"/>">Message</a></li>
                                <security:authorize access=" isAuthenticated()">
                                <li class="${current == 'account' ? 'active':''}"><a href="<spring:url value="/account.html"/>">My Account</a></li>
                                </security:authorize>
                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <security:authorize access="! isAuthenticated()">
                                <li class="${current == 'register' ? 'active':''}"><a href="<spring:url value="/register.html"/>">Register</a></li>
                                <li class="${current == 'login' ? 'active':''}"><a href="<spring:url value="/login.html"/>">Login</a></li> 
                                </security:authorize>
                                <security:authorize access="isAuthenticated()">
                                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                                    <li><a href="#">Welcome, ${pageContext.request.userPrincipal.name}</a></li>
                                    </c:if>
                                <li class="dropdown">

                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> Profil</a>
                                    <ul class="dropdown-menu">                                   
                                        <!--                                    <li role="separator" class="divider"></li>                                   -->
                                        <li class=""><a href="<spring:url value="/account.html"/>">My Account</a></li>
                                        <br \>
                                    
                                        <li >
                                            <form id="my_form" action="${logoutUrl}" method="post">                              
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                <!--                                                <a href="javascript:{}" onclick="document.getElementById('my_form').submit();"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a>-->
                                                <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</button>
                                            </form>

                                        </li>
                                    </ul>
                                </li>
                            </security:authorize>
                        </ul>


                    </div><!--/.nav-collapse -->                    
                </div><!--/.container-fluid -->

            </nav>

            <tiles:insertAttribute name="body"/>
            <br><br>
            <center>
                <tiles:insertAttribute name="footer"/>
            </center>   
        </div>
    </body>
</html>
