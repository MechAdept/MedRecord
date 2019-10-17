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
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.healthDetails"/></title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
    </script>
</head>
<body>
<div class="container">
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
    <c:choose>
    <c:when test="${healthDataDTO.id eq null}">
        <h3><spring:message code="text.header.userNotHaveCard1"/> ${userDataDTO.username} <spring:message
                code="text.header.userNotHaveCard2"/></h3>
        <div class="row" style="margin-top: 15px">
            <div class="col-xs-4">
                <a href="<c:url value="/adminpanel/health/${userDataDTO.id}/create"/>" class="btn-lg btn-success"
                   role="button"
                   aria-pressed="true"><spring:message code="button.create"/></a>
            </div>
            <div class="clearfix"></div>
        </div>
    </c:when>
    <c:otherwise>
    <h3><spring:message code="text.header.cardDetails"/> ${userDataDTO.username}</h3>
    <div class="container">
        <div class="col-xs-6" style="margin-top: 20px; background-color: white;">
            <div class="row">

                <div class="col-xs-6">
                    <label><spring:message code="health.label.height"/></label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.height}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.weight"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.weight}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.chest"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.chest}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.waist"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.waist}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.hips"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.hips}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.nervous"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.nervous}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.constitution"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.constitution}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.musculature"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.musculature}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.leye"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.leye}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.reye"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.reye}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.blood"/>:</label>
                </div>
                <div class="col-xs-6">
                        ${healthDataDTO.blood}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.alcohol"/>:</label>
                </div>
                <div class="col-xs-6">
                    <c:if test="${healthDataDTO.alcohol eq true}">
                        <spring:message code="health.alcohol.use"/>
                    </c:if>
                    <c:if test="${healthDataDTO.alcohol eq false}">
                        <spring:message code="health.alcohol.not"/>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.smoke"/>:</label>
                </div>
                <div class="col-xs-6">
                    <c:if test="${healthDataDTO.smoke eq true}">
                        <spring:message code="health.smoke.use"/>
                    </c:if>
                    <c:if test="${healthDataDTO.smoke eq false}">
                        <spring:message code="health.smoke.use"/>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <label><spring:message code="health.label.drugs"/>:</label>
                </div>
                <div class="col-xs-6">
                    <c:if test="${healthDataDTO.drugs eq true}">
                        <spring:message code="health.drugs.not"/>
                    </c:if>
                    <c:if test="${healthDataDTO.drugs eq false}">
                        <spring:message code="health.drugs.not"/>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <br>
            <a href="<c:url value="/adminpanel/health/${userDataDTO.id}/edit"/>"
               class="btn btn-warning align-content-center" role="button"
               aria-pressed="true"><spring:message code="button.edit"/></a>
            <a href="<c:url value="/adminpanel/health/${userDataDTO.id}/delete"/>"
               class="btn btn-danger align-content-center" role="button"
               aria-pressed="true"><spring:message code="button.delete"/></a>
        </div>
        <div class="col-xs-3"></div>
    </div>
</div>
</c:otherwise>
</c:choose>
</body>
</html>