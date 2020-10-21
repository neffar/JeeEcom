<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template title="Hello JSP File">

    <jsp:attribute name="header">
        <div class="jumbotron text-center">
            <h1>Ma Boutique</h1>
        </div>
    </jsp:attribute>

    <jsp:attribute name="body">
        <div class="text-center">
            <h1>Welcome to Ma Boutique</h1>
        </div>
    </jsp:attribute>

    <jsp:attribute name="footer">
      <p id="copyright">Copyright 2020, EILCO</p>
    </jsp:attribute>
</t:template>
