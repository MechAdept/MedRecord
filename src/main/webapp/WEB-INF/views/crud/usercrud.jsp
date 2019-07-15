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
    <title>User Crud</title>
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
            <th scope="col">username</th>
            <th scope="col">roles</th>
            <th scope="col">action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userDTOList}" var="user">
            <tr>
                <th scope="row">${user.id}</th>
                <th scope="row">${user.username}</th>
                <th scope="row">
                        <c:forEach items="${user.roles}" var="role">
                            ${role.name},
                        </c:forEach>
                </th>
                <td><a href="/adminpanel/user/delete/${user.id}" class="btn btn-link" role="button" aria-pressed="true">delete</a></td>
                <td><a href="/adminpanel/user/update/${user.id}" class="btn btn-link" role="button" aria-pressed="true">update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form method="POST" action="/adminpanel/user/create" modelAttribute="userDTO">
        <table>
            <tr>
                <td><form:label path="username">Username</form:label></td>
                <td><form:input path="username"/></td>
                <td><form:label path="password">Password</form:label></td>
                <td><form:input path="password"/></td>
                <td><input type="submit" value="Create user"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>