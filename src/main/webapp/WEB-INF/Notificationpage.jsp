<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 11/05/2020
  Time: 23.06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "/includes/header.jsp" %>


<ul class="collection with-header shadow" style="width: 60%; margin-left: auto; margin-right: auto">
    <li class="collection-header"><h4>Notificationer</h4></li>

   <c:if test="${sessionScope.notificationer == null}">
       <h4 class="grey-text center" style="margin-top: 100px; margin-bottom: 100px;">Ingen nye notificationer</h4>
   </c:if>
    <c:if test="${sessionScope.notificationer != null}">
        <c:forEach var="item" items="${sessionScope.notificationer}">
            <a class="collection-item">${item.beskrivelse}  <i class="material-icons right">send</i></a>
        </c:forEach>

    </c:if>
</ul>

</body>
</html>
