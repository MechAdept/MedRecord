<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/adminpanel/visit/create/" var="create"/>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.visitCreate"/></title>
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
            <a href="<c:url value="/adminpanel/ticket"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.tickets"/></a>
        </div>
        <div class="col-xs-6"></div>
    </div>
    <h3><spring:message code="text.header.userCreate"/></h3>
    <div class="container" style="margin-top: 20px;">
        <form:form method="POST" action="${create}" modelAttribute="visitDTOForm">
            <div class="row">
                <div class="col-xs-2">
                    <td><form:label path="ticket"><spring:message code="text.label.ticket"/></form:label></td>
                </div>
                <div class="col-xs-2">
                    <td><form:label path="password"><spring:message code="login.password"/></form:label></td>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-2">
                    <td><form:hidden path="ticket" value="${ticketDataDTO.id}"/></td>
                </div>
                <div class="col-xs-2">
                    <td><form:input path="datetime" type="datetime-local"/></td>
                </div>
                <div class="col-xs-2">
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-2">
                    <form:label path="password"><spring:message code="text.label.roles"/></form:label>
                </div>
                <div class="col-xs-2">
                    <form:select path="">
                        <form:options items="${roleDTOList}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <input type="submit" value="<spring:message code="button.create"/>"/>
                </div>
                <div class="clearfix"></div>
            </div>
        </form:form>

    </div>
    <div class="navbar-fixed-bottom row-fluid">
        <div class="navbar-inner">
            <div class="panel-footer">
            </div>
        </div>
    </div>
</div>
</body>
</html>