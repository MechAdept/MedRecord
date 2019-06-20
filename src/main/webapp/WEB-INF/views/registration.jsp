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

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<%--<form:form method="POST"--%>
<%--           action="/create-submit/" modelAttribute="user">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td><form:label path="login">login</form:label></td>--%>
<%--            <td><form:input path="login"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="password">password</form:label></td>--%>
<%--            <td><form:input path="password" value="${user.password}"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="mail">mail</form:label></td>--%>
<%--            <td><form:input path="mail"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="type">type</form:label></td>--%>
<%--            <td>--%>
<%--                <div id="group">--%>
<%--                <form:checkbox path="type" value="PATIENT" />PATIENT--%>
<%--                <form:checkbox path="type" value="DOCTOR" />DOCTOR--%>
<%--                <form:checkbox path="type" value="ADMIN" />ADMIN--%>
<%--                </div>--%>
<%--                <script>--%>
<%--                    $('#group input:checkbox').click(function(){--%>
<%--                        if ($(this).is(':checked')) {--%>
<%--                            $('#group input:checkbox').not(this).prop('checked', false);--%>
<%--                        }--%>
<%--                    });--%>
<%--                </script>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" value="Create user"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form:form>--%>

<%--<c:forEach items="${userList}" var="user">--%>
<%--    <tr>--%>
<%--    <td>${user.id}</td>--%>
<%--    <td><input name="login" type="text" value="${user.login}"></td>--%>
<%--    <td><input name="password" type="text" value="${user.password}"></td>--%>
<%--    <td><input name="mail" type="text" value="${user.mail}"></td>--%>
<%--    <td><input name="type" type="text" value="${user.type}"></td>--%>
<%--    <td><a href="/delete?id=${user.id}">Delete</a></td>--%>
<%--    <td><a href="/edit?id=${user.id}">Edit</a></td>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>



<%--<c:forEach items="${userList}" var="user" varStatus="index">--%>
<%--    <form:form method="post" action = "edit" commandName="user">--%>
<%--        <tr>--%>
<%--            <td><form:input path = "login" value = "${user.login}" /></td>--%>
<%--            <td><form:input path = "password" value = "${user.password}" /></td>--%>
<%--            <td><form:input path = "type" value = "${user.type}" /></td>--%>
<%--            <td><form:input path = "mail" value = "${user.mail}" /></td>--%>
<%--            <form:hidden path="id" value=""/>--%>
<%--&lt;%&ndash;            <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <a href="delete/${user.id}"><spring:message code="label.delete" /></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--        <input type="submit" value = "edit">--%>
<%--    </form:form>--%>
<%--</c:forEach>--%>
</body>
</html>