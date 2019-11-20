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
    <title><spring:message code="text.title.userDetails"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<section class="window">
    <div class="container">
        <div class="main_window">
            <div class="languages d-flex justify-content-end">
                <a href="?lang=pl">PL</a>
                <a href="?lang=en" class="ml-1">EN</a>
                <a href="?lang=ru" class="ml-1">RU</a>
            </div>
            <div class="top_bar">
                <ul class="nav">
                    <li class="nav-item">
                        <a href="<c:url value="/receptionistpanel/user/profile"/>">
                            <button type="button" class="btn btn-info"><spring:message
                                    code="button.profile"/></button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value="/receptionistpanel/user"/>">
                            <button type="button" class="btn btn-success ml-3"><spring:message
                                    code="button.users"/></button>
                        </a>
                    </li>
                    <li class="nav-item ml-auto">
                        <a href="<c:url value="/logout"/> ">
                            <button type="button" class="btn btn-danger"><spring:message
                                    code="button.logout"/></button>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="languages d-flex justify-content-end">
                <sec:authorize access="hasAnyRole('ROLE_MEDIC','ROLE_ADMIN','ROLE_RECEPTIONIST')">
                    <a href="<c:url value="/welcome"/>"><spring:message code="button.changeRole"/></a>
                </sec:authorize>
            </div>
            <div class="card-deck">
                <div class="col-md-1"></div>
                <div class="col-md-4">
                    <a href="<c:url value="/receptionistpanel/user/patients"/>">
                        <div class="card">
                            <img class="card-img-top" src="/resources/img/card-patients.jpg" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title"><spring:message code="card.label.patients"/></h5>
                                <p class="card-text text-dark"><spring:message code="card.desc.patients"/></p>
                            </div>
                            <div class="card-footer">
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-2">
                </div>
                <div class="col-md-4">
                    <a href="<c:url value="/receptionistpanel/user/doctors"/>">
                        <div class="card">
                            <img class="card-img-top" src="/resources/img/card-doctors.jpg" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title"><spring:message code="card.label.doctors"/></h5>
                                <p class="card-text text-dark"><spring:message code="card.desc.doctors"/></p>
                            </div>
                            <div class="card-footer">
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-1"></div>
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