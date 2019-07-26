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
    <title>Ticket Crud</title>
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
        <th scope="col">patient</th>
        <th scope="col">doctor</th>
        <th scope="col">datetime</th>
        <th scope="col">attendance</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ticketDTOList}" var="ticket">
        <tr>
            <th scope="row">${ticket.id}</th>
            <th scope="row">${ticket.patient.username}</th>
            <th scope="row">${ticket.doctor.username}</th>
            <th scope="row">${ticket.datetime}</th>
            <th scope="row">${ticket.attendance}</th>
            <td><a href="/adminpanel/ticket/delete/${ticket.id}" class="btn btn-link" role="button" aria-pressed="true">delete</a>
            </td>
            <td><a href="/adminpanel/ticket/update/${ticket.id}" class="btn btn-link" role="button" aria-pressed="true">update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form:form method="POST" action="/adminpanel/ticket/create" modelAttribute="ticketDTOForm">
    <table>
        <tr>
            <td><form:label path="patient">Patient</form:label></td>
            <td><form:input path="patient"/></td>
        </tr>
        <tr>
            <td><form:label path="doctor">Doctor</form:label></td>
            <td><form:input path="doctor"/></td>
        </tr>
        <tr>
            <td><form:label path="datetime"/>Photo</td>
            <td><form:input path="datetime"/></td>
            <td><form:hidden path="attendance"/></td>
        </tr>
        <td><input type="submit" value="Create ticket"/></td>
    </table>
</form:form>
</body>
</html>