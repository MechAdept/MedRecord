<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Reply</title>
</head>
<body>
<table>
    <c:forEach var="person" items="${User.user}">
        <tr>
            <td>${person.name}</td>
            <td>${person.age}</td>
            <td>${person.height}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
