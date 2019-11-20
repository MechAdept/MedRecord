<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/login.bootstrap.css"%>
    </style>
    <title><spring:message code="text.title.medrecord"/></title>
</head>

<body>
<header class="header">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand mx-auto" href="#">MedRecord</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Empty</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Static</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Inside</a>
                    </li>
                </ul>
                <div class="col-xs-3">
                    <div class="row">
                        <ul class="navbar-nav">
                            <li class="nav-item" style="margin-left: 5px">
                                <a href="?lang=pl">PL</a>
                            </li>
                            <li class="nav-item" style="margin-left: 5px">
                                <a href="?lang=en">EN</a>
                            </li>
                            <li class="nav-item" style="margin-left: 5px">
                                <a href="?lang=ru">RU</a>
                            </li>
                        </ul>
                    </div>
                    <sec:authorize access="isAuthenticated()">
                        <div class="row">
                            <a href="<c:url value="/logout"/>" type="button" class="btn btn-danger"><spring:message
                                    code="button.logout"/>
                            </a>
                        </div>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </nav>
</header>
<section class="main mt-5">
    <div class="container">
        <div class="row">
            <div class="jumbotron col-md-8 mr-5">
                <h1 class="display-4">Lorem ipsum</h1>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. <span class="badge badge-info">Info</span>
                </p>
                <hr class="my-4">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque nec odio non felis interdum
                    luctus sit amet nec dolor. Donec imperdiet venenatis ex eu bibendum. Interdum et malesuada fames ac
                    ante ipsum primis in faucibus. Maecenas euismod tellus magna, eu tempus ligula ullamcorper a.
                    Quisque rutrum tempus eros sit amet commodo. Cras sit amet neque porta, vulputate enim vel,
                    fringilla enim. Integer mattis dapibus tempor. Quisque scelerisque metus id sem faucibus, in
                    condimentum lacus iaculis. Aliquam pellentesque efficitur sem, ut facilisis justo sodales
                    imperdiet.</p>
                <p>Praesent nec ipsum sit amet neque vulputate luctus vel eget ex. Nullam aliquet ligula nisl, in
                    sagittis nisl mattis tempor. Phasellus elit neque, molestie vitae viverra aliquam, consequat ac
                    diam. Maecenas eleifend, erat a rhoncus malesuada, urna mi aliquet libero, vitae pulvinar ipsum
                    ligula a est. Suspendisse potenti. Mauris sollicitudin eget eros vel consequat. Vestibulum vitae
                    viverra eros. Donec metus dolor, sodales vitae est vitae, lobortis hendrerit augue. In nisi turpis,
                    convallis in lorem eu, dapibus ultrices purus. Donec id vulputate magna, vel ornare libero.</p>
                <p>Praesent nec ipsum sit amet neque vulputate luctus vel eget ex. Nullam aliquet ligula nisl, in
                    sagittis nisl mattis tempor. Phasellus elit neque, molestie vitae viverra aliquam, consequat ac
                    diam. Maecenas eleifend, erat a rhoncus malesuada, urna mi aliquet libero, vitae pulvinar ipsum
                    ligula a est. Suspendisse potenti. Mauris sollicitudin eget eros vel consequat. Vestibulum vitae
                    viverra eros. Donec metus dolor, sodales vitae est vitae, lobortis hendrerit augue. In nisi turpis,
                    convallis in lorem eu, dapibus ultrices purus. Donec id vulputate magna, vel ornare libero.</p>
                <p>Praesent nec ipsum sit amet neque vulputate luctus vel eget ex. Nullam aliquet ligula nisl, in
                    sagittis nisl mattis tempor. Phasellus elit neque, molestie vitae viverra aliquam, consequat ac
                    diam. Maecenas eleifend, erat a rhoncus malesuada, urna mi aliquet libero, vitae pulvinar ipsum
                    ligula a est. Suspendisse potenti. Mauris sollicitudin eget eros vel consequat. Vestibulum vitae
                    viverra eros. Donec metus dolor, sodales vitae est vitae, lobortis hendrerit augue. In nisi turpis,
                    convallis in lorem eu, dapibus ultrices purus. Donec id vulputate magna, vel ornare libero.</p>
                <p>Praesent nec ipsum sit amet neque vulputate luctus vel eget ex. Nullam aliquet ligula nisl, in
                    sagittis nisl mattis tempor. Phasellus elit neque, molestie vitae viverra aliquam, consequat ac
                    diam. Maecenas eleifend, erat a rhoncus malesuada, urna mi aliquet libero, vitae pulvinar ipsum
                    ligula a est. Suspendisse potenti. Mauris sollicitudin eget eros vel consequat. Vestibulum vitae
                    viverra eros. Donec metus dolor, sodales vitae est vitae, lobortis hendrerit augue. In nisi turpis,
                    convallis in lorem eu, dapibus ultrices purus. Donec id vulputate magna, vel ornare libero.</p>
            </div>
            <div class="login col-auto">
                <form method="POST" action="login" class="form-signin">
                    <h2 class="form-heading"><spring:message code="login.form.title"/></h2>
                    <div class="form-group ${error != null ? 'has-error' : ''}">
                        <span>${message}</span>
                        <input name="username" type="text" id="username" class="form-control" placeholder="Username"
                               autofocus="true"/>
                        <input name="password" type="password" id="password" class="form-control" placeholder="Password"
                               style="margin-top: 20px"/>
                        <span>${error}</span>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top: 20px">
                            <spring:message code="button.login"/></button>
                        <h4 class="text-center"><a href="<c:url value="/registration"/>"><spring:message
                                code="text.header.createAccount"/></a></h4>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<footer class="footer mt-auto py-3">
    <div class="panel-footer">
        <div class="footer-copyright text-center py-3">
            2019 Copyright:
            <p>Vlad Brazovskiy, 2019</p>
        </div>
    </div>
</footer>
</body>
</html>
