<%-- 
    Document   : index
    Created on : 2021-04-04, 08:57:09
    Author     : kasia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
        <c:set var="title" value="widok główny aplikacji"/>  
        <h1>${fn:toUpperCase(title)}</h1>
        <h2>Autor: Kusztal Katarzyna</h2>
        
        <a href="<c:url value="/MainServlet?command=list"/>">Lista użytkowników</a>
        <br>
        <a href="<c:url value="/websockets/index.jsp"/>">WebSocket bez JSON</a>
        <br>
        <a href="<c:url value="/websockets/indexJSON.jsp"/>">WebSocket z użyciem JSON</a>
        <br>
        <a href="<c:url value="/LogoutServlet"/>">Wylogowanie</a>
        
        <p align="center">Wersja aplikacji: <%=(String)getServletContext().getAttribute("sWersjaAplikacji")%> (metoda jspInit())</p>
        <jsp:useBean id="applicationparameters" class="pl.webapplicationKK.data.ApplicationParameters" scope="application">
            <jsp:setProperty name="applicationparameters" property="wersjaaplikacji" value="20210404.01"/>
        </jsp:useBean>
        <p align="center">Wersja aplikacji: <jsp:getProperty name="applicationparameters" property="wersjaaplikacji"/> (komponent JavaBean)</p>

        <p align="center">Zalogowany użytkownik: <c:out value="${pageContext.request.userPrincipal.name}"/></p>
        
        <h3>Obraz modyfikowany przez servlet ImageServlet</h3>
        <img src="<c:url value="/ImageServlet"/>" alt="image" width="320" height="200">
        
        <br><br>
        <h4>Wymaga implementacji:</h4>
        <a href="#">REST JSON</a>
    </body>
</html>
