<%-- 
    Document   : index
    Created on : 2021-03-18, 21:55:09
    Author     : kasia
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Autor projektu: Kusztal Katarzyna</p>
        
        <%
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
        %>
        <p>Aktualna data: <%= dateFormat.format(calendar.getTime()) %></p>
        
        <form method="post" action="MainServlet">
            <p>Dane:&nbsp;
                <input type="text" name="userData">
            </p>
            <input type="submit" value="Wywołanie serwletu">
        </form>
    </body>
</html>
