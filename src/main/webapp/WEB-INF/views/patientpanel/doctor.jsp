<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
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
                        <a href="<c:url value="/patientpanel/profile"/>">
                            <button type="button" class="btn btn-success"><spring:message
                                    code="button.profile"/></button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value="/patientpanel/health"/>">
                            <button type="button" class="btn btn-info ml-3"><spring:message
                                    code="text.header.card"/></button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value="/patientpanel/tickets"/> ">
                            <button type="button" class="btn btn-info ml-3"><spring:message
                                    code="button.tickets"/></button>
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
            <div class="profile mt-5 ml-5">
                <div class="row justify-content-center">
                    <div class="col-4 text-center">
                        <div class="profile_photo" width="334" heigth="334"
                             style="background-image: url('/resources/img/emptyProfile.png'); background-size: cover">
                            <img id="blah" width="334" height="334" src="/resources/img/${userDataDTO.img}"
                                 style="border-radius: 10px; background-size: contain;"
                                 onerror="this.style.visibility = 'hidden'">
                        </div>
                    </div>
                    <div class="col-7">
                        <div class="profile_info">
                            <h4><spring:message code="text.label.fullname"/>:
                                <p>${userDataDTO.surname} ${userDataDTO.name} ${userDataDTO.patronymic}</p>
                            </h4>
                            <h4><spring:message code="text.label.telephone"/>: <p>${userDataDTO.telephone}</p>
                            </h4>
                            <h4><spring:message code="text.label.birth"/>: <p>${formatter.format(userDataDTO.birth)}</p>
                            </h4>
                            <c:if test="${userDataDTO.sex == true}">
                            <h4><spring:message code="text.label.sex"/>: <p><spring:message code="user.sex.male"/></p>
                                </c:if>
                                <c:if test="${userDataDTO.sex == false}">
                                <h4><spring:message code="text.label.sex"/>: <p><spring:message
                                        code="user.sex.female"/></p>
                                    </c:if>
                                </h4>
                            </h4>
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                                <spring:message code="collapse.updatePassword"/>
                                            </a>
                                        </h5>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-xs-2">
                                                </div>
                                                <div class="col-xs-8">
                                                    <form:form method="post" modelAttribute="userFormDTO"
                                                               action="${changePass}">
                                                        <form:hidden path="id" value="${userDataDTO.id}"/>
                                                        <form:input type="password" path="password" class="form-control"
                                                                    placeholder="Password"/>
                                                        <form:errors path="password" cssStyle="color: red;"/>
                                                        <br>
                                                        <form:input type="passwordConfirm" path="passwordConfirm"
                                                                    class="form-control"
                                                                    placeholder="Confirm"/>
                                                        <form:errors path="passwordConfirm" cssStyle="color: red;"/>
                                                        <br>
                                                        <input type="submit" class="form-control"
                                                               value="<spring:message code="button.save"/>"/>
                                                    </form:form>
                                                </div>
                                                <div class="col-xs-2">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
<script>
</script>
</body>
</html>