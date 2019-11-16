<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/logout" var="logout"/>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.authorization"/></title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6"></div>
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
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="row">
            <div class="row">
                <div class="col-xs-3">
                </div>
                <div class="col-xs-6">
                    <div class="img-thumbnail су" width="400" height="300" style="background-color: #fff">
                        <h2><spring:message code="text.header.welcome"/> ${pageContext.request.userPrincipal.name}</h2>
                        <br>
                        <div class="center-block">
                            <c:if test="${roles.contains(ROLE_ADMIN)}">
                                <a href="<c:url value="/adminpanel"/>"><spring:message
                                        code="text.header.adminPanel"/></a>
                            </c:if>
                            <br>
                            <c:if test="${roles.contains(ROLE_PATIENT)}">
                                <a href="<c:url value="/patientpanel"/>"><spring:message
                                        code="text.header.patientPanel"/></a>
                            </c:if>
                            <br>
                            <c:if test="${roles.contains(ROLE_MEDIC)}">
                                <a href="<c:url value="/medicpanel"/>"><spring:message
                                        code="text.header.medicPanel"/></a>
                            </c:if>
                            <br>
                            <c:if test="${roles.contains(ROLE_RECEPTIONIST)}">
                                <a href="<c:url value="/receptionistpanel"/>"><spring:message
                                        code="text.header.receptionistpanel"/></a>
                            </c:if>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                </div>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>