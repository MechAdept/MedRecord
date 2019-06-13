<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reply</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST"
           action="/medrecord/" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="login">Name</form:label></td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="mail">
                Contact Number</form:label></td>
            <td><form:input path="mail"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<%--<c:forEach items="${userList}" var="user">--%>
<%--    ${user.id} + 1--%>
<%--</c:forEach>--%>
    1-${user.login}-1

</body>
</html>

<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Reply</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table>--%>
<%--    <c:forEach var="person" items="${User.user}">--%>
<%--        <tr>--%>
<%--            <td>${user.id}</td>--%>
<%--            <td>${user.login}</td>--%>
<%--            <td>${user.password}</td>--%>
<%--            <td>${user.mail}</td>--%>
<%--            <td>${user.type}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>