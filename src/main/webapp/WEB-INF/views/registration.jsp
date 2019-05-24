<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="reply.jsp" method="POST">
    Login: <input login="login" />
    Password: <input password="password" />
    mail: <input mail="mail" />
    Role: <select name="role">
    <option>Пациент</option>
    <option>Врач</option>
    <option>Админ</option>
</select>
</form>
</body>
</html>
