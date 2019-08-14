<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<c:url value="/adminpanel/health/create" var="create"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title>Health Create</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <a href="<c:url value="/adminpanel/role"/>" class="btn btn-info" role="button"
               aria-pressed="true">Роли</a>
            <a href="<c:url value="/adminpanel/user"/>" class="btn btn-info" role="button"
               aria-pressed="true">Пользователи</a>
            <a href="<c:url value="/adminpanel/ticket"/>" class="btn btn-info" role="button"
               aria-pressed="true">Талоны</a>
            <a href="<c:url value="/adminpanel/visit"/>" class="btn btn-info" role="button"
               aria-pressed="true">Посещения</a>
            <a href="<c:url value="/adminpanel/health"/>" class="btn btn-success" role="button"
               aria-pressed="true">Карты
                здоровья</a>
        </div>
        <div class="col-xs-6"></div>
    </div>
    <h3>Создание карты</h3>
    <div class="container" style="margin-top: 20px;">
        <form:form method="POST" action="${create}" modelAttribute="healthDTOForm">
        <div class="row">
            <div class="col-xs-2" style="text-align: center">
                <form:label path="patient"/>Patient
            </div>
            <div class="col-xs-3">
                <div class="col-xs-6" style="text-align: center">
                    <form:label path="birth"/>birth
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <form:hidden path="patient" value="${healthDTOForm.patient}"/>
                <form:select path="patientId" class="form-control" placeholder="Patient">
                    <form:options items="${unregistered}" itemValue="id" itemLabel="username"/>
                </form:select>
            </div>
            <div class="col-xs-2">
                <div class="col-xs-9">
                    <form:input type="date" path="birthString" class="form-control" cssStyle="text-align: center; glyph-orientation-vertical: auto" placeholder="Birth"/>
                </div>
            </div>
            <div class="col-xs-2">
                <form:input type="text" path="photo" class="form-control"
                            placeholder="link to photo"/>
            </div>
            <div class="col-xs-2">
                <input type="submit" value="Create"/>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    </form:form>
</div>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="panel-footer">
        </div>
    </div>
</div>
</body>
</html>
