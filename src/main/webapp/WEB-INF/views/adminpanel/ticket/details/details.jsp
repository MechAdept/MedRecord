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
    </style>
    <title><spring:message code="text.title.ticketDetails"/></title>
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
            <a href="<c:url value="/adminpanel/user"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.users"/></a>
            <a href="<c:url value="/adminpanel/ticket"/>" class="btn btn-success" role="button"
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
    <div>
    </div>
    <h3><spring:message code="text.header.ticketDetails"/></h3>
    <div class="container" style="margin-top: 20px;">
        <div class="row">
            <div class="col-xs-1" style="text-align: center">
                <label><spring:message code="text.label.id"/></label>
            </div>
            <div class="col-xs-1">
                <label><spring:message code="text.label.patient"/></label>
            </div>
            <div class="col-xs-1">
                <label><spring:message code="text.label.doctor"/></label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <label><spring:message code="text.label.datetime"/></label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <label><spring:message code="text.label.relatedItems"/></label>
            </div>
            <div class="col-xs-3" style="text-align: center">
                <label><spring:message code="text.label.action"/></label>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1" style="text-align: center">
                <label>${ticketDataDTO.id}</label>
            </div>
            <div class="col-xs-1">
                <a href="<c:url value="/adminpanel/user/details/${ticketDataDTO.doctor.id}"/>" class="btn-sm btn-primary"
                   role="button"
                   aria-pressed="true">${ticketDataDTO.doctor.username}</a>
            </div>
            <div class="col-xs-1">
                <a href="<c:url value="/adminpanel/user/details/${ticketDataDTO.patient.id}"/>" class="btn-sm btn-primary"
                   role="button"
                   aria-pressed="true">${ticketDataDTO.patient.username}</a>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <label>${ticketDataDTO.datetime.format(formatter)}</label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <a href="<c:url value="/adminpanel/ticket/details/${ticketDataDTO.id}/visit"/>" class="btn-sm btn-primary"
                   role="button"
                   aria-pressed="true"><spring:message code="text.header.visit"/></a>
            </div>
            <div class="col-xs-3" style="text-align: center"><a
                    href="<c:url value="/adminpanel/ticket/delete/${ticketDataDTO.id}"/>" class="btn-sm btn-danger"
                    role="button"
                    aria-pressed="true"><spring:message code="button.delete"/></a>
                <a href="<c:url value="/adminpanel/ticket/edit/${ticketDataDTO.id}"/>"
                   class="btn-sm btn-warning" role="button" aria-pressed="true"><spring:message code="button.edit"/></a>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="navbar-fixed-bottom row-fluid">
            <div class="navbar-inner">
                <div class="panel-footer">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>