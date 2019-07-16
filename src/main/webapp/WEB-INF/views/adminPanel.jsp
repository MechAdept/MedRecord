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
    <title>AdminPanel</title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
    </script>
</head>

<body>
<a href="/adminpanel/role"  class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Роли</a>
<a href="/adminpanel/user" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Пользователи</a>
<a href="/adminpanel/ticket" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Талоны</a>
<a href="/adminpanel/visit" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Посещения</a>
<a href="/adminpanel/health" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Карты здоровья</a>
<br>
</body>
</html>


<%--<script type="text/javascript">--%>
<%--    $(function() {--%>
<%--        $('a').on('click', function(e){--%>
<%--            e.preventDefault();--%>
<%--            $('div').show().not($(this).data('rel')).hide();--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

<%--</div>--%>
<%--<a href="" data-rel=".nomer1">Фильтр1</a>--%>
<%--<a href="" data-rel=".nomer2">Фильтр2</a>--%>

<%--<div class="nomer1" >КОНТЕНТ, группа 1</div>--%>
<%--<div class="nomer1" >КОНТЕНТ, группа 1</div>--%>
<%--<div class="nomer2" >КОНТЕНТ, группа 2</div>--%>
<%--</div>--%>