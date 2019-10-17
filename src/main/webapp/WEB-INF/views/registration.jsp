<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/registration" var="registration"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
        <%@include file="/resources/css/registration.css"%>
    </style>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
        <%@include file="/resources/js/jquery.maskedinput.min.js"%>
    </script>
    <title><spring:message code="text.title.authorization"/></title>
</head>
<body>
<div class="row">
    <div class="col-xs-6"></div>
    <div class="col-xs-3"></div>
    <div class="col-xs-3">
        <div class="row">
            <a href="?lang=pl">PL</a>
            <a href="?lang=en">EN</a>
            <a href="?lang=ru">RU</a>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-3"></div>
        <div class="col-xs-9">
            <h2 class="form-signin-heading"><spring:message code="text.header.createAccount"/></h2>
            <form:form method="POST" action="${registration}" modelAttribute="userFormDTO">
                <c:forEach items="${roleList}" var="role">
                    <c:if test="${role.name eq 'ROLE_PATIENT'}">
                        <form:hidden path="rolesId" value="${role.id}"/>
                    </c:if>
                </c:forEach>
                <br>
                <div class="row">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <form:label path="username"><spring:message code="text.label.username"/></form:label>
                    </div>
                    <div class="col-xs-3">
                        <form:input type="text" path="username" class="form-control" placeholder="Username"
                                    autofocus="true"/>
                        <form:errors path="username" cssStyle="color: red"/>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <form:label path="password"><spring:message code="login.password"/></form:label>
                    </div>
                    <div class="col-xs-3">
                        <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                        <form:errors path="password" cssStyle="color: red;"/>
                    </div>
                    <div class="col-xs-3">
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <b><form:label path="passwordConfirm"/><spring:message code="form.passwordConfirm"/></b>
                    </div>
                    <div class="col-xs-3">
                        <form:input type="password" path="passwordConfirm" class="form-control"
                                    placeholder="Confirm your password"/>
                        <form:errors path="passwordConfirm" cssStyle="color: red"/>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <form:label path="surname"><spring:message code="text.label.surname"/></form:label>
                    </div>
                    <div class="col-xs-3">
                        <div class="form-group">
                            <form:input path="surname" class="form-control" placeholder="Surname"/>
                            <form:errors path="surname" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="col-xs-3">
                        <td><form:label path="name"><spring:message code="text.label.name"/></form:label></td>
                    </div>
                    <div class="col-xs-3">
                        <div class="form-group">
                            <form:input path="name" class="form-control" placeholder="Name"/>
                            <form:errors path="name" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <td><form:label path="patronymic"><spring:message
                                code="text.label.patronymic"/></form:label></td>
                    </div>
                    <div class="col-xs-3">
                        <div class="form-group">
                            <form:input path="patronymic" class="form-control" placeholder="Patronymic"/>
                            <form:errors path="patronymic" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <td><form:label path="telephone"><spring:message code="text.label.telephone"/></form:label></td>
                    </div>
                    <div class="col-xs-3">
                        <div class="form-group">
                            <input id="telephone" class="form-control" name="telephone" type="text"
                                   placeholder="+375(__)___-__-__">
                            <form:errors path="telephone" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <td><form:label path="birth"><spring:message code="text.label.birth"/></form:label></td>
                    </div>
                    <div class="col-xs-3">
                        <div class="form-group">
                            <form:input path="birth" type="date"
                                        max="${formatter.format(currentDate)}"/>
                            <form:errors path="birth" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="clearfix"></div>
                    <div class="col-xs-3">
                        <td><form:label path="sex"><spring:message code="text.label.sex"/></form:label></td>
                    </div>
                    <div class="col-xs-3">
                        <div class="form-group">
                            <form:select path="sex" class="browser-default custom-select">
                                <form:option value=""><spring:message code="select.sex.disable"/></form:option>
                                <form:option value="0"><spring:message code="select.sex.female"/></form:option>
                                <form:option value="1"><spring:message code="select.sex.male"/></form:option>
                            </form:select>
                            <form:errors path="sex" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="row">
                    <div class="clearfix"></div>
                    <div class="col-xs-6">
                        <td>
                            <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message
                                    code="button.createAccount"/></button>
                        </td>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </form:form>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</body>
<script>
    $(function () {
        $("#telephone").mask("+375(99)999-99-99");
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }
    $("#imgInp").change(function () {
        readURL(this);
    });
</script>
</html>