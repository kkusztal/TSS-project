<%-- 
    Document   : login
    Created on : 2021-04-22, 15:40:16
    Author     : kasia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
    </head>
    <body>
        <div class="container">
            <h3 class="text-center mb-3">Strona logowania</h3>
            <h4 class="text-center mb-3">Autor projektu: Kusztal Katarzyna</h4>
            <hr>
            <div class="form-user">
                <form class="form" method="post" action="j_security_check">
                    <input type="text" class="form-control" name="j_username" placeholder="Login" value="tomcatDB"/>
                    <input type="password" class="form-control" name="j_password" placeholder="Hasło" value="tomcatDB"/>
                    <hr>
                    <button type="submit" class="btn btn-lg btn-primary btn-block">Zaloguj się</button>
                </form>
            </div>
        </div>
    </body>
</html>
