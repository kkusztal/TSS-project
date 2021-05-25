<%-- 
    Document   : udateData
    Created on : 2021-04-04, 09:13:15
    Author     : kasia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pl.webapplicationKK.model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../web-components/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h3 class="text-center mb-3">Edycja danych użytkownika</h3>
            <hr>
            <div class="form-user">
                <form class="form" method="post" action="MainServlet?command=update">
                    <input type="text" class="form-control" name="id" readonly value="<c:out value="${user.id}"/>">
                <input type="text" class="form-control" value="<c:out value="${user.firstName}"/>" placeholder="Imię" name="firstName"/>
                    <input type="text" class="form-control" value="<c:out value="${user.lastName}"/>" placeholder="Nazwisko"  name="lastName"/>
                    <hr>
                    <button type="submit" class="btn btn-lg btn-primary btn-block">Zatwierdź</button>
                </form>
            </div>
        </div>
    </body>
</html>
