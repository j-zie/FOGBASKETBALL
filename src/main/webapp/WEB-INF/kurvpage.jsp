<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 21/04/2020
  Time: 21.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "/includes/header.jsp" %>

<h1 class="center " style="margin-top: 20px; margin-bottom: 20px;">Din kurv</h1>


<c:if test="${sessionScope.itemListe != null}">
    <c:forEach var="item" items="${sessionScope.itemListe}">
        <ul class="collection hoverable" style="width: 60%; margin-left: auto; margin-right: auto">
            <li class="collection-item avatar">
                <img src="${item.imgPath}" alt="" class="circle">
                <span class="title">${item.tag}</span>
                <p>${item.beskrivelse} <br>
                    Pris: ${item.pris} kr.
                </p>
                <a href="FrontController?target=nav&Nav=kurv&item=${item.imgPath}" class="secondary-content btn">Fjern </a>
            </li>

        </ul>

    </c:forEach>

</c:if>

<c:if test="${sessionScope.itemListe.size() < 1 || sessionScope.itemListe == null }">
    <h2 class="center grey-text" style="margin-top: 20px; margin-bottom: 20px;">Ingen varer er tilføjet</h2>
</c:if>

<br>
<c:if test="${sessionScope.itemListe.size() >= 1}">
<div style="text-align: center; margin-bottom: 40px;">
    <a class="btn center blue hoverable">Gå til betaling</a>
</div>
</c:if>
</body>
</html>
