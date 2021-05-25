<%-- 
    Document   : index
    Created on : 2021-04-04, 08:57:09
    Author     : kasia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../web-components/header.jsp"></jsp:include>
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
        
        <jsp:useBean id="applicationparameters" class="pl.webapplicationKK.data.ApplicationParameters" scope="application">
            <jsp:setProperty name="applicationparameters" property="wersjaaplikacji" value="20210404.01"/>
        </jsp:useBean>
        
        <section class="py-5 text-center">
            <h1 class="fw-light">${fn:toUpperCase(title)}</h1>
            <hr>
            <p class="lead text-muted">
                Wersja aplikacji: <%=(String)getServletContext().getAttribute("sWersjaAplikacji")%> (metoda jspInit())
                <br>
                Wersja aplikacji: <jsp:getProperty name="applicationparameters" property="wersjaaplikacji"/> (komponent JavaBean)
                <br>
                Zalogowany użytkownik: <c:out value="${pageContext.request.userPrincipal.name}"/>
            </p>
        </section>
        <div class="text-center">
            <h2 class="fw-light">Obraz modyfikowany przez servlet ImageServlet</h2>
            <img src="<c:url value="/ImageServlet"/>" alt="image" width="320" height="200">
        </div>
    </body>
</html>
