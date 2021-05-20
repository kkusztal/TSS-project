<%-- 
    Document   : login
    Created on : 2021-04-22, 15:40:16
    Author     : kasia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Strona logowania</h1>

        <form method="post" action="j_security_check">
            <p align="center">Login:&nbsp;
                <input type="text" name="j_username" value="tomcatDB">
            </p>
            <p align="center">Hasło:&nbsp;
                <input type="password" name="j_password" value="tomcatDB">
            </p>
            <p align="center">
                <input type="submit" value="Zaloguj się">
            </p>
        </form>
    </body>
</html>
