<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Админка</title>
</head>
<body>
<form action="reply.jsp" method="POST">
    login: <input login="login" />
    password: <input password="password" />
    mail: <input mail="mail" />
    role: <select name="role">
    <option>Пациент</option>
    <option>Врач</option>
    <option>Админ</option>
</select>
</form>
</body>
</html>