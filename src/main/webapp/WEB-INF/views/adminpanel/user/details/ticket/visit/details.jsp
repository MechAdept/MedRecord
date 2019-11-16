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
    <title><spring:message code="text.title.visitDetails"/></title>
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
    <h3>
        <div class="row"><spring:message code="text.title.visitDetails"/></div>
    </h3>
    <br>
    <div class="row">
        <div class="col-xs-8">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                               aria-controls="collapseOne1">
                                <spring:message code="text.label.complaint"/>
                            </a>
                        </h5>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="row">
                            <span>
                                ${visitDataDTO.complaint}
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                               aria-controls="collapseOne1">
                                <spring:message code="text.label.examination"/>
                            </a>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="row">
                            <span>
                                ${visitDataDTO.examination}
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                               aria-controls="collapseOne1">
                                <spring:message code="text.label.diagnosis"/>
                            </a>
                        </h5>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="row">
                            <span>
                                ${visitDataDTO.diagnosis}
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour"
                               aria-controls="collapseOne1">
                                <spring:message code="text.label.treatment"/>
                            </a>
                        </h5>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="row">
                            <span>
                                ${visitDataDTO.treatment}
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-4">
            <div class="row">
                <label><spring:message code="text.label.ticket"/>: </label>
            </div>
            <div class="row">
                <a href="/adminpanel/ticket/${ticketDataDTO.id}">${ticketDataDTO.id}</a>
            </div>
            <br>
            <div class="row">
                <label><spring:message code="text.label.patient"/>: </label>
            </div>
            <div class="row">
                <a href="/adminpanel/user/details/${ticketDataDTO.patient.id}">${ticketDataDTO.patient.surname} ${ticketDataDTO.patient.name} ${ticketDataDTO.patient.patronymic}</a>
            </div>
            <br>
            <div class="row">
                <label><spring:message code="text.label.doctor"/>:</label>
            </div>
            <div class="row">
                <a href="/adminpanel/user/details/${ticketDataDTO.doctor.id}">${ticketDataDTO.doctor.surname} ${ticketDataDTO.doctor.name} ${ticketDataDTO.doctor.patronymic}</a>
            </div>
            <br>
            <div class="row">
                <label><spring:message code="text.label.datetime"/>:</label>
            </div>
            <div class="row">
                ${ticketDataDTO.datetime.format(formatter)}
            </div>
        </div>
    </div>
</div>
</body>
</html>