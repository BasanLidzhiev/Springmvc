<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    <title>Фильм</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${student.id != 0}">
            <h3>Редактировать описание фильма</h3>
        </c:when>
        <c:otherwise>
            <h2>Добавить описание фильма</h2>
        </c:otherwise>
    </c:choose>
    <div class="row">
        <div class="col-6">
            <form method="POST" action="insert">
                <input type="hidden" name="id" value="" />
                <div class="form-sGroup">
                    <input class="form-control" type="text" name="name" placeholder="Name" />
                </div>
                <div class="form-sGroup">
                    <input class="form-control" type="text" name="duration" placeholder="Duration" />
                </div>
                <div class="form-sGroup">
                    <input class="form-control" type="text" name="restriction" placeholder="Restriction" />
                </div>
                <div class="form-sGroup">
                    <input class="btn btn-primary" type="submit" value="Save" />
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
