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
    <title>Health Details</title>
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
    <c:if test="${healthDTO.id != null}">
    <h3>Подробно о карте пациента ${healthDTO.patient.username}</h3>
    <div class="container" style="margin-top: 20px;">
        <div class="row">
            <div class="col-xs-2">
                <label>id</label>
            </div>
            <div class="col-xs-2">
                <label>name</label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <label>связанные элементы</label>
            </div>
            <div class="col-xs-3" style="text-align: center">
                <label>действия</label>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <label>${healthDTO.id}</label>
            </div>
            <div class="col-xs-2">
                <label>${healthDTO.patient.id}</label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <a href="<c:url value="/adminpanel/health/details/${healthDTO.id}/patient"/>" class="btn-sm btn-primary"
                   role="button"
                   aria-pressed="true">Пациент</a>
            </div>
            <div class="col-xs-3" style="text-align: center"><a
                    href="<c:url value="/adminpanel/health/delete/${healthDTO.id}"/>" class="btn btn-link" role="button"
                    aria-pressed="true">delete</a>
                <a href="<c:url value="/adminpanel/health/edit/${healthDTO.id}"/>"
                   class="btn btn-link" role="button" aria-pressed="true">edit</a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    </c:if>
    <c:if test="${healthDTO.id == null}">
    <h3> У пользователя ${userDTO.username} нет карты</h3>
    <div class="row" style="margin-top: 15px">
        <div class="col-xs-4">
            <form:form modelAttribute="userDTO">
                <form:hidden path="id" value="${userDTO.id}"/>
            </form:form>
            <a href="<c:url value="/adminpanel/health/create${userDTO.id}"/>" class="btn-lg btn-success" role="button"
               aria-pressed="true">Создать</a>
        </div>
        <div class="clearfix"></div>
        </c:if>
        <div class="navbar-fixed-bottom row-fluid">
            <div class="navbar-inner">
                <div class="panel-footer">
                </div>
            </div>
        </div>
    </div>
</body>
</html>