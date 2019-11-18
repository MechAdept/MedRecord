<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="SEC" uri="http://www.springframework.org/security/tags" %>
<c:url value="/logout" var="logout"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><spring:message code="text.title.medrecord"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<section class="window">
    <div class="container">
        <div class="main_window mt-5 w-25 text-center mx-auto">
            <div class="languages d-flex justify-content-end">
                <a href="?lang=pl">PL</a>
                <a href="?lang=en" class="ml-1">EN</a>
                <a href="?lang=ru" class="ml-1">RU</a>
            </div>
            <div class="choice_variants border border-dark p-3">
                <div class="greeting mb-4">
                    <h4><spring:message code="text.header.welcome"/> ${pageContext.request.userPrincipal.name}</h4>
                </div>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <div class="col-auto">
                        <a href="<c:url value="/adminpanel"/>">
                            <button type="button" class="btn btn-outline-dark mb-3">
                                <spring:message
                                        code="text.header.adminPanel"/></button>
                        </a>
                    </div>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_PATIENT')">
                    <div class="col-auto">
                        <a href="<c:url value="/patientpanel"/>">
                            <button type="button" class="btn btn-outline-dark mb-3">
                                <spring:message
                                        code="text.header.patientPanel"/></button>
                        </a>
                    </div>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_MEDIC')">
                    <div class="col-auto">
                        <a href="<c:url value="/medicpanel"/>">
                            <button type="button" class="btn btn-outline-dark mb-3">
                                <spring:message
                                        code="text.header.medicPanel"/></button>
                        </a>
                    </div>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_RECEPTIONIST')">
                    <div class="col-auto">
                        <a href="<c:url value="/receptionistpanel"/>">
                            <button type="button"
                                    class="btn btn-outline-dark mb-3"><spring:message
                                    code="text.header.receptionistpanel"/></button>
                        </a>
                    </div>
                </sec:authorize>
                <div class="col-auto">
                    <a href="<c:url value="/logout"/>">
                        <button type="button" class="btn btn-danger mb-2">
                            <spring:message
                                    code="button.logout"/></button>
                    </a>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>