<%--
  Created by IntelliJ IDEA.
  User: soufiane
  Date: 01/10/2020
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="User" scope="request" class="fr.eilco.model.User" />

<html>
<head>
    <title>Hello JSP File</title>
</head>
<body>
    <h1>Hello JSP File</h1>
    Login: <jsp:getProperty name="User" property="login" />
    Email: <jsp:getProperty name="User" property="email" />

    <br>
    <br>

    Login (EJB): ${User}

    <br>
    <br>
    <c:forEach var = "i" begin = "1" end = "5">
        Item <c:out value = "${i}"/> <br>
    </c:forEach>
</body>
</html>
