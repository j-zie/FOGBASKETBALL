<%@ page import="DBAccess.MaterialeMapper" %><%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 21/04/2020
  Time: 22.38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "/includes/header.jsp" %>


    <div class="row valign-wrapper">
        <div class="col s6 offset-s3 valign">
<div class="card center-align">
    <div class="card-image waves-effect waves-block waves-light">
        <img class="activator" src="resources/background4.jpg">
    </div>
    <div class="card-content">
        <span class="card-title activator grey-text text-darken-4">Din forespørgelse er sendt afsted til en Fog medarbejder. <i class="material-icons right">more_vert</i></span>
        <p>Tryk på Billedet for at gennemse din ordre</p>
    </div>
    <div class="card-reveal">
        <span class="card-title grey-text text-darken-4"> Din forespørgelse er sendt afsted til en Fog medarbejder.<i class="material-icons right">close</i></span>
        <p> Tillykke du har bestilt en carport.</p>
        <p> Med følgende dimensioner</p>
        <p> Bredde: ${requestScope.Bredde} cm</p>
        <p> Højde:  ${requestScope.Længde} cm</p>
        <p> Tagtype: ${requestScope.tagtypeNavn}</p>
        <c:if test="${requestScope.taghældning != null}">
            <p> Taghældning: ${requestScope.taghældning}&deg;</p>
        </c:if>
        <c:if test="${requestScope.Redskabsrum_bredde != 0}">
            <p> Redskabsrum Bredde: ${requestScope.Redskabsrum_bredde} cm</p>
        </c:if>
        <c:if test="${requestScope.Redskabsrum_længde != 0}">
            <p> Redskabsrum Længde: ${requestScope.Redskabsrum_længde} cm</p>
        </c:if>
        <p> Hvis disse informationer er forkert. Så oplys venligst dette til medarbejderen der snarest tager kontakt til dig.</p>
        <div> ${requestScope.svgCarport} </div>

    </div>
</div>

        </div>
    </div>
</div>
<br>
<br>


<br>
<br>
<br>
<br>
<br>

<%@ include file = "/includes/footer.jsp" %>
