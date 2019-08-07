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
    <title>Health update</title>
</head>

<body>
<script type="text/javascript">
    <%@include file="/resources/js/jquery-3.4.1.min.js"%>
    <%@include file="/resources/js/bootstrap.min.js"%>
</script>
<a href="/adminpanel" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Панель аминистратора</a>
<br>

<form:form method="POST" action="/adminpanel/health/update" modelAttribute="healthDTOForm">
    <table>
        <form:hidden path="id" value="${healthDTO.id}"/>
        <form:select path="patient">
            <form:option value="">Можете выбрать нового пациента</form:option>
            <form:options items="${uniqueUsers}" itemValue="id" itemLabel="username"/>
        </form:select>
        <tr>
            <td><form:label path="birth">Birth</form:label></td>
            <td><form:input type="date" path="birth" value="${healthDTO.birth}"/></td>
        </tr>
        <tr>
            <td><form:label path="photo"/>Photo</td>
            <td><form:input path="photo" value="${healthDTO.photo}"/></td>
        </tr>
        <td><input type="submit" value="Update health"/></td>
    </table>
</form:form>
</body>
</html>