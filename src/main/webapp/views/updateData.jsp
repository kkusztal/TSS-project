<%-- 
    Document   : udateData
    Created on : 2021-04-04, 09:13:15
    Author     : kasia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pl.webapplicationKK.model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edycja danych użytkownika</h1>

        <form method="post" action="MainServlet?command=update">
            <p>ID:&nbsp;
                <input type="text" name="id" readonly value="<c:out value="${user.id}"/>">
            </p>
            <p>Imię:&nbsp;
                <input type="text" value="<c:out value="${user.firstName}"/>" name="firstName">
            </p>
            <p>Nazwisko:&nbsp;
                <input type="text" value="<c:out value="${user.lastName}"/>" name="lastName">
            </p>
            <input type="submit" value="Zatwierdź">
        </form>
        <a href="views/index.jsp">Strona główna</a>
    </body>
</html>
