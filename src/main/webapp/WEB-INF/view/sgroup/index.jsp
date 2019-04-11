<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />

    <title>Учебные группы</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${success == false}">
            <div class="bg-error">Error: ${message}</div>
        </c:when>
        <c:otherwise>
            <h2>Список учебных групп</h2>
            <hr />
            <div style="margin-bottom: 2em" class="row">
                <div class="col-12">
                    <a href="/sgroup/add" class="btn btn-primary">Добавить учебную группу</a>
                </div>
            </div>
            <table class="table table-hovered table-border">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th colspan="2">Operations</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sgroups}" var="sGroup">
                    <tr>
                        <td>${sGroup.id}</td>
                        <td>${sGroup.name}</td>
                        <td><a href="/sgroup/edit/${sGroup.id}">edit</a></td>
                        <td><a href="/sgroup/delete/${sGroup.id}">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
