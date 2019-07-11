<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
        <%@include file="/resources/css/registration.css"%>
    </style>
    <title>AdminPanel</title>
</head>

<body>
<script type="text/javascript">
    <%@include file="/resources/js/jquery-3.4.1.min.js"%>
    <%@include file="/resources/js/bootstrap.min.js"%>
</script>
<a href="/adminPanel/role" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Роли</a>
<br>
<br>
<%--<a href="/adminPanel/user" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Пользователи</a>--%>
<br>
<table class="table">
<c:forEach items="${roleList}" var="role">
    <tr>
        <td>${role.id}</td>
        <td>${role.name}</td>
        <td><a href="/adminPanel/role/delete/${role.id}" methods="DELETE">Delete</a></td>
        <td><a href="/adminPanel/role/put/${role.id}">Edit</a></td>
    </tr>
</c:forEach>
</table>
<form:form method="POST"
           action="/adminPanel/role/create" modelAttribute="roleDTO">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
            <td><input type="submit" value="Create role"/></td>
        </tr>
    </table>
</form:form>
</body>
</html></title>
</head>
<body>

</body>
</html>
<%--<c:forEach items="${userList}" var="user">--%>
<%--    <tr>--%>
<%--        <td>${user.id}</td>--%>
<%--        <td>${user.username}</td>--%>
<%--        <td>${user.roles}</td>--%>
<%--        <td><a href="/adminPanel/user/delete/${user.id}">Delete</a></td>--%>
<%--        <td><a href="/adminPanel/user/put/${user.id}">Edit</a></td>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
