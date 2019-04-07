<%--
    Document   : index.jsp
    Created on : 26.03.2019, 15:53:23
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    <title>Фильмы</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${success == false}">
            <div class="bg-error">Ошибка: ${message}</div>
        </c:when>
        <c:otherwise>
            <h2>Список студентов</h2>
            <hr />
            <div style="margin-bottom: 2em" class="row">
                <div class="col-12">
                    <a href="/student/add" class="btn btn-primary">Добавить студента</a>
                </div>
            </div>
            <table class="table table-hovered table-border">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>День рождения</th>
                    <th>Группа</th>
                    <th colspan="2">Операции</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.last_Name}</td>
                        <td>${student.birthday}</td>
                        <td>${student.SGroup.name}</td>
                        <td><a href="/student/edit/${student.id}">редактировать</a></td>
                        <td><a href="/student/delete/${student.id}">удалить</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
