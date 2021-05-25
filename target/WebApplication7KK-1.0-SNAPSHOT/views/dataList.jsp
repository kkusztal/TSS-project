<%-- 
    Document   : dataList
    Created on : 2021-04-04, 09:12:15
    Author     : kasia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
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
            <div class="row">
                <div class="col-12">
                    <h3 class="text-center mb-3">Lista użytkowników</h3>
                    <hr>
                    <a href="<c:url value="/MainServlet?command=processAdd"/>" class="btn btn-success mt-4 mb-4">Dodaj użytkownika</a>  
                    <br>
                    <table id="ejemplo" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nazwisko</th>
                                <th>Imię</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td class="align-middle"><c:out value="${user.id}"/></td>
                                    <td class="align-middle"><c:out value="${user.lastName}"/></td>
                                    <td class="align-middle"><c:out value="${user.firstName}" /></td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="MainServlet?command=processUpdate&id=<c:out value="${user.id}"/>"><button type="button" class="btn btn-primary mx-auto">Edytuj</button></a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="MainServlet?command=delete&id=<c:out value="${user.id}"/>"><button type="button" class="btn btn-danger mx-auto">Usuń</button></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
