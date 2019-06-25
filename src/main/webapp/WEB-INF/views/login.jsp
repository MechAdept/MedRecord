<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title>Log in with your account</title>
</head>

<body>
<script type="text/javascript">
    <%@include file="/resources/js/jquery-3.4.1.min.js"%>
    <%@include file="/resources/js/bootstrap.min.js"%>
</script>
<div class="container">

    <form method="POST" action="login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>

</div>
</body>
</html>