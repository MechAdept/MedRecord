<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/adminpanel/user/edit" var="edit"/>
<c:url value="/adminpanel/user/edit/setImage" var="setImage"/>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.userEdit"/></title>
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
    <h3><spring:message code="text.header.userEdit"/> ${userDataDTO.username}</h3>
    <div class="container" style="margin-top: 20px;">
        <div class="row">
            <div class="col-xs-3">
                <div class="img-thumbnail" width="200" height="200"
                     style="margin-left: 10px; margin-top: 10px; background-image: url('/resources/img/emptyProfile.png');">
                    <img id="blah" height="200" width="200" src="/resources/img/${userDataDTO.img}"
                         style="border-radius: 10px; background-size: contain;"
                         onerror="this.style.visibility = 'hidden'">
                </div>
                <br>
                <br>
                <form method="post" action="${setImage}" enctype="multipart/form-data">
                    <input type="file" id="imgInp" name="file"/>
                    <input type="hidden" value="${userDataDTO.id}" name="id"/>
                    <br>
                    <td><input type="submit" class="form-control btn btn-warning" value="<spring:message code="button.changePhoto"/>"/></td>
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
        <br>
        <form:form method="post" action="${edit}" modelAttribute="userFormDTO">
            <form:hidden path="id" value="${userDataDTO.id}"/>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-3">
                    <td><form:label path="password"><spring:message code="login.password"/></form:label></td>
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
                <div class="col-xs-3">
                    <b><form:label path="passwordConfirm"/><spring:message code="form.passwordConfirm"/></b>
                </div>
                <div class="col-xs-3">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"/>
                    <form:errors path="passwordConfirm" cssStyle="color: red"/>
                </div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-3">
                    <td><form:label path="rolesId"><spring:message code="text.label.roles"/></form:label></td>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <form:select path="rolesId">
                            <c:forEach items="${roleDTOList}" var="role">
                                <c:choose>
                                    <c:when test="${userDataDTO.roles.contains(role)}">
                                        <form:option value="${role.id}" selected="selected">${role.name}</form:option>
                                    </c:when>
                                    <c:otherwise>
                                        <form:option value="${role.id}">${role.name}</form:option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-3">
                    <td><form:label path="surname"><spring:message code="text.label.surname"/></form:label></td>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <form:input path="surname" class="form-control" placeholder="Surname"
                                    value="${userDataDTO.surname}"/>
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
                        <form:input path="name" class="form-control" placeholder="Name" value="${userDataDTO.name}"/>
                        <form:errors path="name" cssStyle="color: red"/>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-3">
                    <td><form:label path="patronymic"><spring:message code="text.label.patronymic"/></form:label></td>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <form:input path="patronymic" class="form-control" placeholder="Patronymic"
                                    value="${userDataDTO.patronymic}"/>
                        <form:errors path="patronymic" cssStyle="color: red"/>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-3">
                    <td><form:label path="telephone"><spring:message code="text.label.telephone"/></form:label></td>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <input id="telephone" class="form-control" name="telephone" type="text"
                               placeholder="+375(__)___-__-__" value="${userDataDTO.telephone}">
                        <form:errors path="telephone" cssStyle="color: red"/>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-3">
                    <td><form:label path="birth"><spring:message code="text.label.birth"/></form:label></td>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <form:input path="birth" type="date"
                                    max="${formatter.format(currentDate)}"
                                    value="${formatter.format(userDataDTO.birth)}"/>
                        <form:errors path="birth" cssStyle="color: red"/>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row" style="margin-top: 10px;">
                <div class="col-xs-3">
                    <td><form:label path="sex"><spring:message code="text.label.sex"/></form:label></td>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <form:select path="sex">
                            <c:if test="${userDataDTO.sex == false}">
                                <form:option value="0" selected="selected"><spring:message
                                        code="select.sex.female"/></form:option>
                                <form:option value="1"><spring:message code="select.sex.male"/></form:option>
                            </c:if>
                            <c:if test="${userDataDTO.sex == true}">
                                <form:option value="0"><spring:message code="select.sex.female"/></form:option>
                                <form:option value="1" selected="selected"><spring:message
                                        code="select.sex.male"/></form:option>
                            </c:if>
                            <c:if test="${userDataDTO.sex == null}">
                                <form:option value="0"><spring:message code="select.sex.female"/></form:option>
                                <form:option value="1"><spring:message code="select.sex.male"/></form:option>
                            </c:if>
                        </form:select>
                        <form:errors path="sex" cssStyle="color: red"/>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="row">
                <div class="col-xs-3">
                    <td><input type="submit" class="form-control" value="<spring:message code="button.save"/>"/></td>
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
