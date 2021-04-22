<%-- 
    Document   : dataList
    Created on : 2021-04-04, 09:12:15
    Author     : kasia
--%>

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
        <a href="MainServlet?command=new"><button>Dodaj użytkownika</button></a>
        
        <% List<Data> users = (List<Data>)request.getAttribute("users"); %> 
        
        <table border>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                </tr>
            </thead>
            <tbody>
                <% for(Data user : users) { %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getLastName() %></td>
                        <td><%= user.getFirstName() %></td>
                        <td>
                            <a href="MainServlet?command=edit&id=<%= user.getId() %>"><button>Edytuj</button></a>
                        </td>
                        <td>
                            <a href="MainServlet?command=delete&id=<%= user.getId() %>"><button>Usuń</button></a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <a href="views/index.jsp">Strona główna</a>
    </body>
</html>
