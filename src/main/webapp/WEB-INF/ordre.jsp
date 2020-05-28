<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 22/04/2020
  Time: 16.28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../includes/adminheader.jsp" %>

</body>
<h2 class="light-blue-text center"> Ordre oversigt </h2>
<div class="collection" style="width: 60%; margin-right: auto; margin-left: auto">

    <c:forEach var="ordre" items="${sessionScope.alleOrdre}">
        <a href="#!" class="collection-item center">Ordre: ${ordre.ordreNr} ${ordre.user.navn}
                <form action="FrontController" method="post" style="text-align:center">
                    <input type="hidden" name="target" value="stykliste" >
                    <input type="hidden" name="bid" value="${ordre.user.id}" >
                    <button class="waves-effect waves-teal btn-flat" name="ordrenr" value="${ordre.ordreNr}">Vis Styk-liste</button>

                </form>


            <form action="FrontController" method="post" style="text-align:center">
            <input type="hidden" name="target" value="sletOrdre" >
        <button class="waves-effect waves-teal btn-flat" name="ordrenr" value="${ordre.ordreNr}">Slet Ordre</button>
            </form> </a>
    </c:forEach>





    </div>
</div>

<br>
<br>
<br>
<br>
<br>

<%@ include file = "../includes/footer.jsp" %>
