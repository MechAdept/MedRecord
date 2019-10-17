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
        <%@include file="/resources/css/avatar.css"%>
    </style>
    <title><spring:message code="text.title.userDetails"/></title>
    <script>
        <%@include file="/resources/js/bootstrap.min.js"%>
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
    </script>
</head>
<body>
<div class="container">
    <%--START OF HEADER--%>
    <div class="row">
        <div class="col-xs-6">
            <a href="<c:url value="/adminpanel/role"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.roles"/></a>
            <a href="<c:url value="/adminpanel/user"/>" class="btn btn-success" role="button"
               aria-pressed="true"><spring:message code="button.users"/></a>
        </div>
        <div class="col-xs-3"></div>
        <div class="col-xs-3">
            <div class="row">
                <a href="?lang=pl">PL</a>
                <a href="?lang=en">EN</a>
                <a href="?lang=ru">RU</a>
            </div>
            <div class="row">
                <a href="<c:url value="/logout"/>" type="button" class="btn btn-default"><spring:message
                        code="button.logout"/></a>
            </div>
        </div>
    </div>
    <%--END OF HEADER--%>
    <h3><spring:message code="text.header.userDetails"/> <b>${userDataDTO.username}</b></h3>
    <div class="container" style="background-color: #fff; margin-top: 20px;">
        <div class="row">
            <div class="col-xs-3">
                <div class="row">
                    <div class="img-thumbnail" width="200" height="200"
                         style="margin-left: 10px; margin-top: 10px; background-image: url('/resources/img/emptyProfile.png');">
                        <img src="<c:url value="/resources/img/${userDataDTO.img}"/>" height="200" width="200"
                             style="border-radius: 10px; background-size: contain"
                             onerror="this.style.visibility = 'hidden'">
                    </div>
                </div>
            </div>
            <div class="col-xs-6">
                <div class="row"></div>
                <div class="row">
                    <h4><b><spring:message code="text.label.fullname"/>: ${userDataDTO.surname} ${userDataDTO.name} ${userDataDTO.patronymic}</b></h4>
                </div>
                <div class="row">
                    <h4><b><spring:message code="text.label.telephone"/>: ${userDataDTO.telephone}</b></h4>
                </div>
                <div class="row">
                    <h4><b><spring:message code="text.label.birth"/>: ${formatter.format(userDataDTO.birth)}</b></h4>
                </div>
                <div class="row">
                    <c:if test="${userDataDTO.sex == true}">
                        <h4><b><spring:message code="text.label.sex"/>: <spring:message code="user.sex.male"/></b></h4>
                    </c:if>
                    <c:if test="${userDataDTO.sex == false}">
                        <h4><b><spring:message code="text.label.sex"/>: <spring:message code="user.sex.female"/></b></h4>
                    </c:if>
                </div>
                <br>
                <div class="row">
                    <c:forEach items="${userDataDTO.roles}" var="role">
                        <c:if test="${role.name == 'ROLE_PATIENT'}">
                            <a href="<c:url value="/adminpanel/user/details/${userDataDTO.id}/health"/>"
                               class="btn btn-primary align-content-center" role="button"
                               aria-pressed="true"><spring:message code="button.health"/></a>
                        </c:if>
                    </c:forEach>
                    <a href="<c:url value="/adminpanel/user/edit/${userDataDTO.id}"/>"
                       class="btn btn-warning align-content-center" role="button"
                       aria-pressed="true"><spring:message code="button.edit"/></a>
                    <a href="<c:url value="/adminpanel/user/delete/${userDataDTO.id}"/>"
                       class="btn btn-danger align-content-center" role="button"
                       aria-pressed="true"><spring:message code="button.delete"/></a>
                </div>
            </div>
            <div class="col-xs-3">
                <h4><b><spring:message code="text.label.roles"/>:</b></h4>
                <c:forEach items="${userDataDTO.roles}" var="role">
                    <h4><b><spring:message code="${role.name}"/></b></h4>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>