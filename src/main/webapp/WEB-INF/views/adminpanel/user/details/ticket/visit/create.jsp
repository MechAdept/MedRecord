<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/adminpanel/visit/create" var="create"/>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.userCreate"/></title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
        <%@include file="/resources/js/jquery.maskedinput.min.js"%>
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
    <h3><spring:message code="text.header.starVisit"/> ${ticketDataDTO.id}</h3>
    <div class="container" style="margin-top: 20px;">
        <form:form method="POST" action="${create}" modelAttribute="visitFormDTO">
            <form:hidden path="ticketId" value="${ticketDataDTO.id}"/>
            <form:hidden path="datetime" value="${visitFormDTO.datetime}"/>
            <br>
            <div class="row">
                <div class="col-xs-2"></div>
                <div class="col-xs-1">
                    <form:label path="complaint"><spring:message code="text.label.complaint"/></form:label>
                </div>
                <div class="col-xs-5">
                    <form:textarea type="text" onkeyup="textAreaAdjust(this)" path="complaint" class="form-control"
                                   rows="4" placeholder="Username"
                                   autofocus="true"/>
                    <form:errors path="complaint" cssStyle="color: red"/>
                </div>
                <div class="clearfix"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-2"></div>
                <div class="col-xs-1">
                    <form:label path="examination"><spring:message code="text.label.examination"/></form:label>
                </div>
                <div class="col-xs-5">
                    <form:textarea type="text" path="examination" onkeyup="textAreaAdjust(this)" class="form-control"
                                   rows="4" placeholder="examination"
                                   autofocus="true"/>
                    <form:errors path="examination" cssStyle="color: red"/>
                </div>
                <div class="clearfix"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-2"></div>
                <div class="col-xs-1">
                    <form:label path="diagnosis"><spring:message code="text.label.diagnosis"/></form:label>
                </div>
                <div class="col-xs-5">
                    <form:textarea type="text" path="diagnosis" onkeyup="textAreaAdjust(this)" class="form-control" rows="4" placeholder="diagnosis"
                                   autofocus="true"/>
                    <form:errors path="diagnosis" cssStyle="color: red"/>
                </div>
                <div class="clearfix"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-2"></div>
                <div class="col-xs-1">
                    <form:label path="treatment"><spring:message code="text.label.treatment"/></form:label>
                </div>
                <div class="col-xs-5">
                    <form:textarea type="text" path="treatment" onkeyup="textAreaAdjust(this)" class="form-control" rows="4" placeholder="treatment"
                                   autofocus="true"/>
                    <form:errors path="treatment" cssStyle="color: red"/>
                </div>
                <div class="clearfix"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-4"></div>
                <div class="col-xs-3">
                    <td><input type="submit" class="form-control" value="<spring:message code="button.save"/>"/></td>
                </div>
                <div class="clearfix"></div>
            </div>
        </form:form>
    </div>
</div>
</body>
<script>
    function textAreaAdjust(o) {
        o.style.height = "1px";
        o.style.height = (25 + o.scrollHeight) + "px";
    }
</script>
</html>