<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><spring:message code="text.title.userCrud"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<section class="window">
    <div class="container">
        <div class="main_window">
            <div class="languages d-flex justify-content-end">
                <a href="?lang=pl">PL</a>
                <a href="?lang=en" class="ml-1">EN</a>
                <a href="?lang=ru" class="ml-1">RU</a>
            </div>
            <div class="top_bar">
                <ul class="nav">
                    <li class="nav-item">
                        <a href="<c:url value="/patientpanel/profile"/>">
                            <button type="button" class="btn btn-info"><spring:message
                                    code="button.profile"/></button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value="/patientpanel/health"/>">
                            <button type="button" class="btn btn-info ml-3"><spring:message
                                    code="text.header.card"/></button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value="/patientpanel/tickets"/> ">
                            <button type="button" class="btn btn-success ml-3"><spring:message
                                    code="button.tickets"/></button>
                        </a>
                    </li>
                    <li class="nav-item ml-auto">
                        <a href="<c:url value="/logout"/> ">
                            <button type="button" class="btn btn-danger"><spring:message
                                    code="button.logout"/></button>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="languages d-flex justify-content-end">
                <a href="<c:url value="/welcome"/>"><spring:message code="button.changeRole"/></a>
            </div>
            <div class="row" style="margin-top: 10px">
                <div class="col-xs-3">
                    <h3>
                        <spring:message code="text.header.selectDoctor"/>
                    </h3>
                </div>
            </div>
            <div class="row justify-content-between">
                <div class="col-xs-3 d-flex align-items-center">
                </div>
                <div class="col-xs-3 d-flex align-items-center">
                    <c:if test="${DTOList.size() != 0}">
                        <spring:message
                                code="text.info.shown"/> ${1+((pageNo-1)*pageSize)} - ${DTOList.size()+((pageNo-1)*pageSize)}
                        <spring:message code="text.info.from"/> ${elementsCount}             <spring:message
                            code="text.info.items"/>
                    </c:if>
                    <c:if test="${DTOList.size() == 0}">
                        <spring:message code="text.info.empty"/>
                    </c:if>
                </div>
                <div class="col-xs-3 col-xs-offset-3 d-flex align-items-center">
                    <spring:message code="button.dropdown.show"/>
                    <div class="dropdown m-2">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${pageSize}
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item"
                               href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${7}&desc${desc}&sort${sort}"/>">7</a>
                            <a class="dropdown-item"
                               href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${15}&desc${desc}&sort${sort}"/>">15</a>
                            <a class="dropdown-item"
                               href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${25}&desc${desc}&sort${sort}"/>">25</a>
                        </div>
                    </div>
                    <span>
                <spring:message code="text.info.items"/>
            </span>
                </div>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">
                        <c:if test="${desc == false}">
                            <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${pageSize}&desc=true&sort=id"/>"><spring:message
                                    code="text.label.id"/></a>
                        </c:if>
                        <c:if test="${desc == true}">
                            <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${pageSize}&desc=false&sort=id"/>"><spring:message
                                    code="text.label.id"/></a>
                        </c:if>
                    </th>
                    <th scope="col">
                        <c:if test="${desc == false}">
                            <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${pageSize}&desc=true&sort=name"/>"><spring:message
                                    code="text.label.name"/></a>
                        </c:if>
                        <c:if test="${desc == true}">
                            <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${pageSize}&desc=false&sort=name"/>"><spring:message
                                    code="text.label.name"/></a>
                        </c:if>
                    </th>
                    <th scope="col">
                        <c:if test="${desc == false}">
                            <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${pageSize}&desc=true&sort=surname"/>"><spring:message
                                    code="text.label.surname"/></a>
                        </c:if>
                        <c:if test="${desc == true}">
                            <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo}&pageSize=${pageSize}&desc=false&sort=surname"/>"><spring:message
                                    code="text.label.surname"/></a>
                        </c:if>
                    </th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${DTOList}" var="user">
                    <tr>
                        <th scope="row">${user.id}</th>
                        <th scope="row">${user.name}</th>
                        <th scope="row">${user.surname}</th>
                        <td><a href="<c:url value="/patientpanel/booking/${user.id}"/>"
                               class="btn-sm btn-primary"
                               role="button"
                               aria-pressed="true"><spring:message code="button.booking"/></a>
                        </td>
                        <td><a href="<c:url value="/patientpanel/doctor/${user.id}"/>"
                               class="btn-sm btn-primary"
                               role="button"
                               aria-pressed="true"><spring:message code="button.details"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="navbar-fixed-bottom row-fluid">
                <div class="navbar-inner">
                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-xs-4"></div>
                            <div class="col-xs-4">
                                <div style="text-align: center">
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <c:if test="${pageNo > 1 && DTOList.size() != 0}">
                                                <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo-1}&pageSize=${pageSize}&desc=${desc}"/>"
                                                   class="btn btn-outline-primary" role="button"
                                                   aria-pressed="true"><spring:message code="button.previously"/></a>
                                            </c:if>
                                            <c:if test="${DTOList.size() == 0 && elementsCount != 0}">
                                                <a href="<c:url value="/patientpanel/booking/doctors?pageNo=1&pageSize=${pageSize}&desc=${desc}"/>"
                                                   class="btn btn-outline-primary" role="button"
                                                   aria-pressed="true"><spring:message code="button.previously"/></a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4">
                                            <c:if test="${pageSize < elementsCount}">
                                                <c:forEach begin="1" end="${pageCount+1}" var="i">
                                                    <c:choose>
                                                        <c:when test="${pageNo eq i}">
                                                            <td>${i}</td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td>
                                                                <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${i}&pageSize=${pageSize}&desc=${desc}&sort=${sort}"/>">${i}</a>
                                                            </td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4">
                                            <c:if test="${(pageSize*pageNo)<elementsCount}">
                                                <a href="<c:url value="/patientpanel/booking/doctors?pageNo=${pageNo+1}&pageSize=${pageSize}&desc=${desc}&sort=${sort}"/>"
                                                   class="btn btn-outline-primary" role="button"
                                                   aria-pressed="true"><spring:message code="button.next"/></a>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-4"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>