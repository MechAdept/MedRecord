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
    <title>User update</title>
</head>

<body>
<script type="text/javascript">
    <%@include file="/resources/js/jquery-3.4.1.min.js"%>
    <%@include file="/resources/js/bootstrap.min.js"%>
</script>
<a href="/adminpanel" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Панель аминистратора</a>
<br>
<form:form method = "POST" action = "/adminpanel/user/update" modelAttribute="userDTOForm">
    <table>
        <tr>
            <td><form:hidden path = "id" value="${userDTO.id}"/></td>
        </tr>
        <tr>
            <td>Старый username: ${userDTO.username}</td>
            <td><form:input path = "username"/></td>
        </tr>
        <tr>
            <td>Новый пароль, оставьте пустым если не хотите изменить</td>
            <td><form:input path = "password"/></td>
        </tr>
        <tr>
            <form:select path="roles" items="${roleDTOSet}" multiple="true" itemLabel="name"/>
<%--            <form:checkboxes path="roles" items="${roleDTOSet}" itemLabel="name"/>--%>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>