<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/adminpanel/user/download" var="download"/>

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
        <%--        <%@include file="/resources/js/profile.js"%>--%>
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
    <%--END OF HEADER--%>
    <h3><spring:message code="text.header.userDetails"/></h3>
    <div class="container" style="margin-top: 20px">

        <%--        Avatar --%>
        <div class="row">
            <div class="col-2">
            </div>
            <%--            AVATAR END--%>
            <div class="col-6 mg">
            </div>
        </div>
    </div>
    <div class="container" style="background-color: #fff">
        <div class="row">
            <div class="col-xs-3">
                <div class="row">
                    <div class="img-thumbnail" width="200" height="200" style="margin-left: 10px; margin-top: 10px;">
                        <img src="<c:url value="/resources/img/${userDataDTO.img}"/>" height="200" width="200"
                             style="border-radius: 10px; background-size: contain"
                             onerror="this.style.visibility = 'hidden'">
                    </div>
                </div>
                <div class="row" style="margin-left: 50px; margin-top: 10px; margin-bottom: 10px;">
                    <a href="<c:url value="/adminpanel/user/photo/${userDataDTO.id}"/>" class="btn-sm btn-info align-content-center" role="button"
                       aria-pressed="true"><spring:message code="button.changePhoto"/></a>
                </div>
            </div>
            <div class="col-xs-9">
                <div class="row"></div>
                <div class="row">
                    <h4><b>ФИО: ${userDataDTO.surname} ${userDataDTO.name} ${userDataDTO.patronymic}</b></h4>
                </div>
                <div class="row">
                    <h4><b>Телефон: ${userDataDTO.telephone}</b></h4>
                </div>
                <div class="row">
                    <h4><b>Дата рождения: ${userDataDTO.birth.format(formatter)}</b></h4>
                </div>
                <div class="row">
                    <c:if test="${userDataDTO.sex == true}">
                        <h4><b>Пол: мужской</b></h4>
                    </c:if>
                    <c:if test="${userDataDTO.sex == false}">
                        <h4><b>Пол: женский</b></h4>
                    </c:if>
                </div>
                <br>
                <div class="row">
                    <a href="<c:url value="/adminpanel/user/edit/${userDataDTO.id}"/>" class="btn btn-warning align-content-center" role="button"
                       aria-pressed="true"><spring:message code="button.edit"/></a>
                    <a href="<c:url value="/adminpanel/user/delete/${userDataDTO.id}"/>" class="btn btn-danger align-content-center" role="button"
                       aria-pressed="true"><spring:message code="button.delete"/></a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

<%--            <div style="margin-top: 10px;">--%>
<%--                <input type="file" class="text-center center-block file-upload" size="10">--%>
<%--            </div>--%>

<%--        <div class="text-center">--%>
<%--            <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img- img-thumbnail" alt="avatar">--%>
<%--            <h6>Upload a different photo...</h6>--%>
<%--            <input type="file" class="text-center center-block file-upload">--%>
<%--        </div>--%>

<%--        <form:form method="post" action="${download}" enctype="multipart/form-data" modelAttribute="userDataDTO">--%>
<%--            <input type="file" name="file">--%>
<%--            <form:input path=""--%>
<%--            <button type="submit">Сохранить</button>--%>
<%--        </form:form>--%>