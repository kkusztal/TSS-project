<%-- 
    Document   : dataList
    Created on : 2021-04-04, 09:12:15
    Author     : kasia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="pl.webapplicationKK.model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>Lista użytkowników</h1>
        <a href="MainServlet?command=processAdd"><button>Dodaj użytkownika</button></a>
        
        <table border>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nazwisko</th>
                    <th>Imię</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.lastName}"/></td>
                        <td><c:out value="${user.firstName}" /></td>
                        <td>
                            <a href="MainServlet?command=processUpdate&id=<c:out value="${user.id}"/>"><button>Edytuj</button></a>
                        </td>
                        <td>
                            <a href="MainServlet?command=delete&id=<c:out value="${user.id}"/>"><button>Usuń</button></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>Zalogowany użytkownik: <c:out value="${pageContext.request.userPrincipal.name}"/></p>
        <a href="views/index.jsp">Strona główna</a>
    </body>
</html>
