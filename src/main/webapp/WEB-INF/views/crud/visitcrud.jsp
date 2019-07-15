<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title>Visit Crud</title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
    </script>
</head>

<body>
<a href="/adminpanel/role" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Роли</a>
<a href="/adminpanel/user" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Пользователи</a>
<a href="/adminpanel/ticket" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Талоны</a>
<a href="/adminpanel/visit" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Посещения</a>
<a href="/adminpanel/health" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Карты здоровья</a>
<br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">complaint</th>
        <th scope="col">examination</th>
        <th scope="col">diagnosis</th>
        <th scope="col">treatment</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${visitDTOList}" var="visit">
        <tr>
            <th scope="row">${visit.id}</th>
            <th scope="row">${visit.complaint}</th>
            <th scope="row">${visit.examination}</th>
            <th scope="row">${visit.diagnosis}</th>
            <th scope="row">${visit.treatment}</th>
            <th scope="row">${visit.ticket}</th>
            <th scope="row">${visit.datetime}</th>
                <%--            <th scope="row">${visit.photo}</th>--%>
                <%--        <td><input type="text"${role.name}" value="></td>--%>
            <td><a href="/adminpanel/visit/delete/${visit.id}" class="btn btn-link" role="button" aria-pressed="true">delete</a>
            </td>
            <td><a href="/adminpanel/visit/update/${visit.id}" class="btn btn-link" role="button" aria-pressed="true">update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form:form method="POST" action="/adminpanel/visit/create" modelAttribute="visitDTOForm">
    <table>
        <tr>
            <td><form:input path="ticket" label="birth"/></td>
            <td><form:input path="datetime" label="datetime"/></td>
            <td><form:input path="complaint" label="complaint"/></td>
            <td><form:input path="examination" label="complaint"/></td>
            <td><form:input path="diagnosis" label="complaint"/></td>
            <td><form:input path="treatment" label="complaint"/></td>
            <td><input type="submit" value="Create visit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>