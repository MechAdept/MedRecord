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
        <%@include file="/resources/css/logic.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title>Ticket Crud</title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
        <%@include file="/resources/js/logic.js"%>
    </script>
</head>6
<body>
<a href="<c:url value="/adminpanel/role"/>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Роли</a>
<a href="<c:url value="/adminpanel/user"/>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Пользователи</a>
<a href="<c:url value="/adminpanel/ticket"/>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Талоны</a>
<a href="<c:url value="/adminpanel/visit"/>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Посещения</a>
<a href="<c:url value="/adminpanel/health"/>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Карты здоровья</a>
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
    <c:forEach items="${ticketDTOSet}" var="ticket">
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
    <form:form method="POST" action="/adminpanel/ticket/create" modelAttribute="ticketDTOForm">
        <tr>
            <th scope="row"><form:hidden path="id"/></th>
            <th scope="row">
                <form:select path="patient">
                    <form:options items="${userDTOList}" itemValue="id" itemLabel="username"/>
                </form:select>
            </th>
            <th scope="row">
                <form:select path="doctor">
                    <form:options items="${userDTOList}" itemValue="id" itemLabel="username"/>
                </form:select>
            </th>
            <th scope="row">
                <form:input path="datetime" type="datetime-local"/>
            </th>
            <th>
                <div class="custom-control custom-radio custom-control-inline">
                    <input type="radio" class="custom-control-input" id="defaultInline1" name="inlineDefaultRadiosExample" value="">
                    <label class="custom-control-label" for="defaultInline1">null</label>
                </div>

                <div class="custom-control custom-radio custom-control-inline">
                    <input type="radio" class="custom-control-input" id="defaultInline2" name="inlineDefaultRadiosExample" value="0">
                    <label class="custom-control-label" for="defaultInline2">false</label>
                </div>

                <div class="custom-control custom-radio custom-control-inline">
                    <input type="radio" class="custom-control-input" id="defaultInline3" name="inlineDefaultRadiosExample" value="1">
                    <label class="custom-control-label" for="defaultInline3">true</label>
                </div>
                <form:radiobutton path="attendance" cssClass="custom-control-input" value="" label="null"/>
            </th>
        </tr>
        <td><input type="submit" value="Create ticket"/></td>
    </form:form>
    </tbody>
</table>
</body>
</html>