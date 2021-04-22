<%-- 
    Document   : index
    Created on : 2021-04-04, 08:57:09
    Author     : kasia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    public void jspInit() {
        getServletContext().setAttribute("sWersjaAplikacji", "20210404.01");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Widok główny aplikacji</h1>
        <h2>Autor: Kusztal Katarzyna</h2>
        
        <a href="<%= request.getContextPath() %>/MainServlet?command=list">Lista użytkowników</a>
        
        <p align="center">Wersja aplikacji: <%= (String)getServletContext().getAttribute("sWersjaAplikacji") %> (metoda jspInit())</p>
        <jsp:useBean id="applicationparameters" class="pl.webapplicationKK.data.ApplicationParameters" scope="application">
            <jsp:setProperty name="applicationparameters" property="wersjaaplikacji" value="20210404.01" />
        </jsp:useBean>
        <p align="center">Wersja aplikacji: <jsp:getProperty name="applicationparameters" property="wersjaaplikacji" /> (komponent JavaBean)</p>

        <h3>Obraz modyfikowany przez servlet ImageServlet</h3>
        <img src="<%= request.getContextPath() %>/ImageServlet" alt="image" width="320" height="200">
        
        <br><br>
        <h4>Wymaga implementacji:</h4>
        <p>Mechanizm logowania</p>
        <a href="#">REST JSON</a>
        <br>
        <a href="#">WebSocket bez JSON</a>
        <br>
        <a href="#">WebSocket z użyciem JSON</a>
        <br>
        <a href="#">Wylogowanie</a>
    </body>
</html>
