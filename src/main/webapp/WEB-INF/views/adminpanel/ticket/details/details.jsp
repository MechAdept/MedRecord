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
    <title>Ticket details</title>
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
    <div>
    </div>
    <h3>Подробно о талоне</h3>
    <div class="container" style="margin-top: 20px;">
        <div class="row">
            <div class="col-xs-1" style="text-align: center">
                <label>id</label>
            </div>
            <div class="col-xs-1">
                <label>patient</label>
            </div>
            <div class="col-xs-1">
                <label>doctor</label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <label>datetime</label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <label>связанные элементы</label>
            </div>
            <div class="col-xs-3" style="text-align: center">
                <label>действия</label>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1" style="text-align: center">
                <label>${ticketDTO.id}</label>
            </div>
            <div class="col-xs-1">
                <label>${ticketDTO.patient.username}</label>
            </div>
            <div class="col-xs-1">
                <label>${ticketDTO.doctor.username}</label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <label>${ticketDTO.datetime}</label>
            </div>
            <div class="col-xs-2" style="text-align: center">
                <a href="<c:url value="/adminpanel/ticket/details/${ticketDTO.id}/visit"/>" class="btn-sm btn-primary"
                   role="button"
                   aria-pressed="true">Посещение</a>
            </div>
            <div class="col-xs-3" style="text-align: center"><a
                    href="<c:url value="/adminpanel/ticket/delete/${ticketDTO.id}"/>" class="btn btn-danger" role="button"
                    aria-pressed="true">delete</a>
                <a href="<c:url value="/adminpanel/ticket/edit/${ticketDTO.id}"/>"
                   class="btn btn-link" role="button" aria-pressed="true">edit</a>
            </div>
            <div class="clearfix"></div>
        </div>

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