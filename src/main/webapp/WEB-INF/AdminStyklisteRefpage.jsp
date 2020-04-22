<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 22/04/2020
  Time: 16.28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../includes/header.jsp" %>

</body>
<h2 class="light-blue-text center"> Odrer oversigt </h2>
<div class="collection" style="width: 60%; margin-right: auto; margin-left: auto">

    <c:forEach var="ordre" items="${sessionScope.alleOrdre}">

        <a href="#!" class="collection-item center">Ordre: ${ordre.ordreNr} ${ordre.user.navn} </a>
    </c:forEach>

</div>

<br>
<br>
<br>
<br>
<br>

<%@ include file = "../includes/footer.jsp" %>
