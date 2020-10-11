<%--
  Created by IntelliJ IDEA.
  User: soufiane
  Date: 11/10/2020
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new user</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/controller">
        <input type="text" name="login" required><br><br>
        <input type="text" name="email"><br><br>
        <input type="submit" name="submit" value="Send">
    </form>
</body>
</html>
