<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/WEB-INF/views/css/bootstrap.min.css"%>
    </style>
    <title>Reply</title>
</head>
<body>
<script type="text/javascript">
    <%@include file="/WEB-INF/views/js/jquery-3.4.1.min.js"%>
</script>
<script type="text/javascript">
    <%@include file="/WEB-INF/views/js/bootstrap.min.js"%>
</script>


<h3>CRUD user</h3>


<form:form method="POST"
           action="/create-submit/" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="login">login</form:label></td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td><form:label path="password">password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="mail">mail</form:label></td>
            <td><form:input path="mail"/></td>
        </tr>
        <tr>
            <td><form:label path="type">type</form:label></td>
            <td>
                <div id="group">
                <form:checkbox path="type" value="PATIENT" />PATIENT
                <form:checkbox path="type" value="DOCTOR" />DOCTOR
                <form:checkbox path="type" value="ADMIN" />ADMIN
                </div>
                <script>
                    $('#group input:checkbox').click(function(){
                        if ($(this).is(':checked')) {
                            $('#group input:checkbox').not(this).prop('checked', false);
                        }
                    });
                </script>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Create user"/></td>
        </tr>
    </table>
</form:form>
<table>
<c:forEach items="${userList}" var="user">
    <form:form method="POST"
               action="/delete-submit/" modelAttribute="user">
    <tr>
    <td>${user.id}</td>
    <td>${user.login}</td>
    <td>${user.password}</td>
    <td>${user.mail}</td>
    <td>${user.type}</td>
    <td><input type="submit" value="Delete user"/></td>
    </tr>
    </form:form>
</c:forEach>
</table>


</body>
</html>