<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template title="Hello JSP File">

    <jsp:attribute name="body">
        <div class="text-center">
            <h1>Categories</h1>
            <button id="btn">CLICK ME</button>
            <h1>List of categories</h1>
            <div id="catList">
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">
    <script>
        const btn = document.querySelector("#btn")
        btn.addEventListener('click', () => {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/controller",
                headers: {
                    Accept: "application/json; charset=utf-8", "Content-Type": "application/json; charset=utf-8"
                },
                success: response => {
                    // let categories = $.parseJSON(response)

                    console.log(response)
                    $("#catList").html(response.id + ' ' + response['nom'])
                }
            })
        })
    </script>
    </jsp:attribute>
</t:template>
