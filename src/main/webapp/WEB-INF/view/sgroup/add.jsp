<%--
    Document   : add
    Created on : 27.03.2019, 14:03:19
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />


    <title>Группа</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${sgroup.id == 0}">
            Создание новой учебной группы
        </c:when>
        <c:otherwise>
            Редактирование учебной группы: <c:out value="${sgroup.name}" />
        </c:otherwise>
    </c:choose>
    <div class="row" style="margin-top: 2em">
        <div class="col-6">
            <form:form modelAttribute="sgroup" method="POST" action="${action}">
                <form:hidden path="id" />
                <div class="form-group">
                    <form:input class="form-control" path="name" placeholder="Наименование" />
                </div>
                <div class="form-group">
                    <input class="btn btn-primary" type="submit" value="Сохранить" />
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
