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
    <title>User Tickets</title>
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
               aria-pressed="true">Роли</a>
            <a href="<c:url value="/adminpanel/user"/>" class="btn btn-info" role="button"
               aria-pressed="true">Пользователи</a>
            <a href="<c:url value="/adminpanel/ticket"/>" class="btn btn-success" role="button"
               aria-pressed="true">Талоны</a>
            <a href="<c:url value="/adminpanel/visit"/>" class="btn btn-info" role="button"
               aria-pressed="true">Посещения</a>
            <a href="<c:url value="/adminpanel/health"/>" class="btn btn-info" role="button"
               aria-pressed="true">Карты
                здоровья</a>
        </div>
        <div class="col-xs-6"></div>
    </div>
    <div class="row" style="margin-top: 10px">
        <div class="col-xs-4">
        </div>
        <div class="col-xs-4">
            <c:if test="${DTOList.size() != 0}">
                Показаны ${1+((pageNo-1)*pageSize)} - ${DTOList.size()+((pageNo-1)*pageSize)} из ${elementsCount} элементов
            </c:if>
            <c:if test="${DTOList.size() == 0}">
                Здесь пусто
            </c:if>
        </div>
        <div class="col-xs-4">
            Показывать по
            <div class="btn-group">
                <button type="button" class="btn btn-default">${pageSize}</button>
                <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle"><span
                        class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li>
                        <a href="<c:url value="/adminpanel/ticket?pageNo=${pageNo}&pageSize=${7}&desc${desc}&sort${sort}"/>">7</a>
                    </li>
                    <li>
                        <a href="<c:url value="/adminpanel/ticket?pageNo=${pageNo}&pageSize=${15}&desc${desc}&sort${sort}"/>">15</a>
                    </li>
                    <li>
                        <a href="<c:url value="/adminpanel/ticket?pageNo=${pageNo}&pageSize=${25}&desc${desc}&sort${sort}"/>">25</a>
                    </li>
                </ul>
            </div>
            элементов
        </div>
    </div>
    <div>
    </div>
    <h3>Талоны пользователя ${userDTO.username}</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">
                <c:if test="${desc == false}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${true}&sort=id"/>">id</a>
                </c:if>
                <c:if test="${desc == true}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${false}&sort=id"/>">id</a>
                </c:if>
            </th>
            <th scope="col">
                <c:if test="${desc == false}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${true}&sort=doctor"/>">doctor</a>
                </c:if>
                <c:if test="${desc == true}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${false}&sort=doctor"/>">doctor</a>
                </c:if>
            </th>
            <th scope="col">
                <c:if test="${desc == false}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${true}&sort=patient"/>">patient</a>
                </c:if>
                <c:if test="${desc == true}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${false}&sort=patient"/>">patient</a>
                </c:if>
            </th>
            <th scope="col">
                <c:if test="${desc == false}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${true}&sort=datetime"/>">datetime</a>
                </c:if>
                <c:if test="${desc == true}">
                    <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo}&pageSize=${pageSize}&desc=${false}&sort=datetime"/>">datetime</a>
                </c:if>
            </th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${DTOList.size() != 0}">
            <c:forEach items="${DTOList}" var="ticket">
                <tr>
                    <th scope="row">${ticket.id}</th>
                    <th scope="row">${ticket.doctor.username}</th>
                    <th scope="row">${ticket.patient.username}</th>
                    <th scope="row">${ticket.datetime.format(formatter)}</th>

                    <td><a href="<c:url value="adminpane/ticket/details/${ticket.id}"/>" class="btn btn-link"
                           role="button"
                           aria-pressed="true">details</a>
                    </td>
                    <td>
                        <a href="<c:url value="adminpanel/ticket/delete/${ticket.id}?pageNo=${pageNo-1}&pageSize=${pageSize}&desc=${desc}&sort=${sort}"/>"
                           class="btn btn-link" role="button"
                           aria-pressed="true">delete</a>
                    </td>
                    <td><a href="<c:url value="adminpanel/ticket/edit/${ticket.id}"/>" class="btn btn-link"
                           role="button"
                           aria-pressed="true">edit</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>

    <div class="navbar-fixed-bottom row-fluid">
        <div class="navbar-inner">
            <div class="panel-footer">
                <div class="row">
                    <div class="col-xs-4"></div>
                    <div class="col-xs-4">
                        <div style="text-align: center">
                            <c:if test="${elementsCount != 0}">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <c:if test="${pageNo > 1 && elementsCount > 0}">
                                            <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo-1}&pageSize=${pageSize}&desc=${desc}"/>"
                                               class="btn btn-outline-primary" role="button"
                                               aria-pressed="true">Предыдущая</a>
                                        </c:if>
                                        <c:if test="${pageCount != 0 && DTOList.size() == 0}">
                                            <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=1&pageSize=${pageSize}&desc=${desc}"/>"
                                               class="btn btn-outline-primary" role="button"
                                               aria-pressed="true">Предыдущая</a>
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
                                                            <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${i}&pageSize=${pageSize}&desc=${desc}&sort=${sort}"/>">${i}</a>
                                                        </td>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </c:if>
                                    </div>
                                    <div class="col-xs-4">
                                        <c:if test="${(pageSize*pageNo)<elementsCount}">
                                            <a href="<c:url value="/adminpanel/user/details/${userDTO.id}/tickets?pageNo=${pageNo+1}&pageSize=${pageSize}&desc=${desc}&sort=${sort}"/>"
                                               class="btn btn-outline-primary" role="button"
                                               aria-pressed="true">Следующая</a>
                                        </c:if>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-xs-4"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>