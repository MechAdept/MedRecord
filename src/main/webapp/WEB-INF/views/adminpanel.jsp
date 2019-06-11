<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Reply</title>
</head>
<body>
<table>
    <c:forEach var="person" items="${User.user}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.mail}</td>
            <td>${user.type}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
