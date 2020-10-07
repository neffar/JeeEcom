<%--
  Created by IntelliJ IDEA.
  User: soufiane
  Date: 01/10/2020
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="User" scope="request" class="fr.eilco.model.User" />

<t:genericpage title="Hello JSP File">
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="body">

        <h1>Hello JSP File</h1>
        <h2>Méthode 1</h2>
        Login: <jsp:getProperty name="User" property="login" /><br>
        Email: <jsp:getProperty name="User" property="email" />

        <br>
        <br>

        <h2>Méthode 2</h2>
        Login (EJB): ${User.login} <br>
        Email (EJB): ${User.email}

    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 2020, EILCO</p>
    </jsp:attribute>
</t:genericpage>
