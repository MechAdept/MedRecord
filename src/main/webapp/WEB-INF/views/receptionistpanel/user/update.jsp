<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="/receptionistpanel/user/update/pass" var="changePass"/>
<c:url value="/receptionistpanel/user/update/photo" var="changeImage"/>
<c:url value="/receptionistpanel/user/update" var="changeProfile"/>
<c:url value="/receptionistpanel/user/update/roles" var="changeRoles"/>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><spring:message code="text.title.userEdit"/></title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
        <%@include file="/resources/js/jquery.maskedinput.min.js"%>
        <%@include file="/resources/js/js.cookie.min.js"%>
    </script>
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <a href="<c:url value="/receptionistpanel/user/profile"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.profile"/></a>
            <a href="<c:url value="/receptionistpanel/user"/>" class="btn btn-success" role="button"
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
                <a href="<c:url value="/logout"/>" type="button" class="btn btn-danger"><spring:message
                        code="button.logout"/></a>
            </div>
            <div class="row">
                <sec:authorize access="hasAnyRole('ROLE_MEDIC','ROLE_PATIENT','ROLE_ADMIN')">
                    <a href="<c:url value="/welcome"/>"><spring:message code="button.changeRole"/></a>
                </sec:authorize>
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
                <form method="post" action="${changeImage}" enctype="multipart/form-data">
                    <input type="hidden" value="${userDataDTO.id}" name="id"/>
                    <input type="file" id="imgInp" name="file"/>
                    <br>
                    <td><input type="submit" class="form-control btn btn-warning"
                               value="<spring:message code="button.changePhoto"/>"/></td>
                </form>
            </div>
            <div class="col-xs-6">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h5 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    <spring:message code="collapse.updatePassword"/>
                                </a>
                            </h5>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-2">
                                    </div>
                                    <div class="col-xs-8">
                                        <form:form method="post" modelAttribute="userFormDTO"
                                                   action="${changePass}">
                                            <form:hidden path="id" value="${userDataDTO.id}"/>
                                            <form:input type="password" path="password" class="form-control"
                                                        placeholder="Password"/>
                                            <form:errors path="password" cssStyle="color: red;"/>
                                            <br>
                                            <form:input type="passwordConfirm" path="passwordConfirm"
                                                        class="form-control"
                                                        placeholder="Confirm"/>
                                            <form:errors path="passwordConfirm" cssStyle="color: red;"/>
                                            <br>
                                            <input type="submit" class="form-control"
                                                   value="<spring:message code="button.save"/>"/>
                                        </form:form>
                                    </div>
                                    <div class="col-xs-2">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h5 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                    <spring:message code="collapse.updateRoles"/>
                                </a>
                            </h5>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                                <div class="col-xs-3"></div>
                                <div class="col-xs-6">
                                    <form:form modelAttribute="userFormDTO" method="post" action="${changeRoles}">
                                        <form:hidden path="id" value="${userDataDTO.id}"/>
                                        <form:select path="rolesId">
                                            <c:forEach items="${roleDTOList}" var="role">
                                                <c:choose>
                                                    <c:when test="${userDataDTO.roles.contains(role)}">
                                                        <form:option value="${role.id}"
                                                                     selected="selected">${role.name}</form:option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <form:option value="${role.id}">${role.name}</form:option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </form:select>
                                        <form:errors path="rolesId" cssStyle="color: red;"/>
                                        <input type="submit" class="form-control"
                                               value="<spring:message code="button.save"/>"/>
                                    </form:form>
                                </div>
                                <div class="col-xs-3"></div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h5 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                                   aria-expanded="true" aria-controls="answerThree">
                                    <spring:message code="collapse.updateProfile"/>
                                </a>
                            </h5>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <form:form method="post" modelAttribute="userFormDTO" action="${changeProfile}">
                                    <form:hidden path="id" value="${userDataDTO.id}"/>
                                    <div class="col-xs-2"></div>
                                    <div class="col-xs-8">
                                        <div class="row">
                                            <div class="col-xs-5">
                                                <form:label path="name"><spring:message
                                                        code="text.label.name"/></form:label>
                                            </div>
                                            <div class="col-xs-7">
                                                <form:input path="name" value="${userDataDTO.name}" placeholder="Name"
                                                            cssClass="form-control"/>
                                                <form:errors path="name" cssStyle="color: red;"/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-xs-5">
                                                <form:label path="surname"><spring:message
                                                        code="text.label.surname"/></form:label>
                                            </div>
                                            <div class="col-xs-7">
                                                <form:input path="surname" value="${userDataDTO.surname}"
                                                            placeholder="Surname" cssClass="form-control"/>
                                                <form:errors path="surname" cssStyle="color: red;"/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-xs-5">
                                                <form:label path="patronymic"><spring:message
                                                        code="text.label.patronymic"/></form:label>
                                            </div>
                                            <div class="col-xs-7">
                                                <form:input path="patronymic" value="${userDataDTO.patronymic}"
                                                            placeholder="patronymic" cssClass="form-control"/>
                                                <form:errors path="patronymic" cssStyle="color: red;"/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-xs-5">
                                                <form:label path="telephone"><spring:message
                                                        code="text.label.telephone"/></form:label>
                                            </div>
                                            <div class="col-xs-7">
                                                <input id="telephone" class="form-control" name="telephone" type="text"
                                                       placeholder="${userDataDTO.telephone}"
                                                       value="${userDataDTO.telephone}">
                                                <form:errors path="telephone" cssStyle="color: red;"/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-xs-5">
                                                <form:label path="birth"><spring:message
                                                        code="text.label.birth"/></form:label>
                                            </div>
                                            <div class="col-xs-7">
                                                <form:input path="birth" type="date"
                                                            max="${formatter.format(currentDate)}"
                                                            value="${formatter.format(userDataDTO.birth)}"/>
                                                <form:errors path="birth" cssStyle="color: red"/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-xs-5">
                                                <form:label path="sex"><spring:message
                                                        code="text.label.sex"/></form:label>
                                            </div>
                                            <div class="col-xs-7">
                                                <form:select path="sex" cssClass="form-control">
                                                    <c:if test="${userDataDTO.sex == false}">
                                                        <form:option value="0" selected="selected"><spring:message
                                                                code="select.sex.female"/></form:option>
                                                        <form:option value="1"><spring:message
                                                                code="select.sex.male"/></form:option>
                                                    </c:if>
                                                    <c:if test="${userDataDTO.sex == true}">
                                                        <form:option value="0"><spring:message
                                                                code="select.sex.female"/></form:option>
                                                        <form:option value="1" selected="selected"><spring:message
                                                                code="select.sex.male"/></form:option>
                                                    </c:if>
                                                    <c:if test="${userDataDTO.sex == null}">
                                                        <form:option value="0"><spring:message
                                                                code="select.sex.female"/></form:option>
                                                        <form:option value="1"><spring:message
                                                                code="select.sex.male"/></form:option>
                                                    </c:if>
                                                </form:select>
                                                <form:errors path="sex" cssStyle="color: red" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-xs-5">

                                            </div>
                                            <div class="col-xs-5">
                                                <input type="submit" class="form-control"
                                                       value="<spring:message code="button.save"/>"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-2"></div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
        $("#telephone").mask("+375 (99) 999-99-99");
    });

    $("#imgInp").change(function () {
        readURL(this);
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
                $('#blah').css('visibility', 'visible')
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $(document).ready(function () {
        //when a group is shown, save it as the active accordion group
        $("#accordion").on('shown.bs.collapse', function () {
            var active = $("#accordion .in").attr('id');
            $.cookie('activeAccordionGroup', active);
            //  alert(active);
        });
        $("#accordion").on('hidden.bs.collapse', function () {
            $.removeCookie('activeAccordionGroup');
        });
        var last = $.cookie('activeAccordionGroup');
        if (last != null) {
            //remove default collapse settings
            $("#accordion .panel-collapse").removeClass('in');
            //show the account_last visible group
            $("#" + last).addClass("in");
        }
    });
</script>
</html>
