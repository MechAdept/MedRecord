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
    <title><spring:message code="text.title.authorization"/></title>
</head>

<body>
<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading"><spring:message code="text.header.createAccount"/></h2>
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="username" class="form-control" placeholder="Username"
                        autofocus="true"/>
            <form:errors path="username" cssStyle="color: red"/>
        </div>

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="password" class="form-control" placeholder="Password"/>
            <form:errors path="password" cssStyle="color: red;"/>
        </div>

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="passwordConfirm" class="form-control"
                        placeholder="Confirm your password"/>
            <form:errors path="passwordConfirm" cssStyle="color: red"/>
        </div>


        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="button.createAccount"/></button>
    </form:form>
</div>
<ul class="navbar-nav">
    <li class="nav-item">
        <a href="?lang=pl">PL</a>
    </li>
    <li class="nav-item">
        <a href="?lang=en">EN</a>
    </li>
    <li class="nav-item">
        <a href="?lang=ru">RU</a>
    </li>
</ul>
</body>
</html>