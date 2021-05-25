<%-- 
    Document   : addData
    Created on : 2021-04-04, 09:12:58
    Author     : kasia
--%>

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
            <h3 class="text-center mb-3">Dodanie danych użytkownika</h3>
            <hr>
            <div class="form-user">
                <form class="form" method="post" action="MainServlet?command=add">
                    <input type="text" class="form-control" name="firstName" placeholder="Imię"/>
                    <input type="text" class="form-control" name="lastName" placeholder="Nazwisko"/>
                    <hr>
                    <button type="submit" class="btn btn-lg btn-success btn-block">Zatwierdź</button>
                </form>
            </div>
        </div>
    </body>
</html>
