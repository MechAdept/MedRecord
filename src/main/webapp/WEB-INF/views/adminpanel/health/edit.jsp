<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<c:url value="/adminpanel/health/edit" var="edit"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.healthEdit"/></title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <a href="<c:url value="/adminpanel/role"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.roles"/></a>
            <a href="<c:url value="/adminpanel/user"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.users"/></a>
            <a href="<c:url value="/adminpanel/ticket"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.tickets"/></a>
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
    <h3><spring:message code="text.header.healthEdit"/> ${healthDTO.patient.username}</h3>
    <c:if test="${healthDTO.patient.id eq null}">
        <h3><spring:message code="text.header.notPatient"/></h3>
    </c:if>
    <%--    <c:if test="${healthDTO.patient.id eq not null}">--%>
    <div class="container" style="margin-top: 20px;">
        <form:form method="POST" action="${edit}" modelAttribute="healthDTO">
        <div class="row">
            <div class="col-xs-2">
                <label><spring:message code="text.label.patient"/></label>
            </div>
            <div class="col-xs-2" style="text-align: left">
                <label><spring:message code="text.label.birth"/></label>
            </div>
            <div class="col-xs-2" style="text-align: left;">
                <label><spring:message code="text.label.photo"/></label>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <form:hidden path="id" value="${healthDTO.id}"/>
                <form:hidden path="patientId" value="${healthDTO.patient.id}"/>
                    ${healthDTO.patient.username}
            </div>
            <div class="col-xs-2" style="text-align: left;">
                <form:input path="birthString" type="date"/>
            </div>
            <div class="col-xs-2" style="text-align: left;">
                <form:input path="photo" value="${healthDTO.photo}"/>
                <form:errors path="photo" cssStyle="color: red"/>
            </div>
            <div class="col-xs-2">
                <input type="submit" value="<spring:message code="button.save"/>"/>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    </form:form>
    <%--    </c:if>--%>
</div>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="panel-footer">
        </div>
    </div>
</div>
</body>
</html>
