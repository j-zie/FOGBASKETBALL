<%--
  Created by IntelliJ IDEA.
  User: zie
  Date: 4/23/20
  Time: 3:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../includes/header.jsp" %>

<h4 style="color: darkslategrey">${sessionScope.product.materialeNavn}</h4>
<h6>Varenr: ${sessionScope.product.materialeID}</h6>
<div class="row">
    <div class="col s6">
        <h6>Varenr: ${sessionScope.product.materialeID}</h6>
        <img src="${sessionScope.product.path}" style="width:400px;height:400px;">
    </div>
    <div class="col s6">
        <h5>${sessionScope.product.pris}</h5>/stk
        <p style="text-decoration: underline; font-size: small;">Lev. omkom.tillægges </p>
        <p class="flow-text">${sessionScope.product.beskrivelse}</p>

        <div class="card small">
            <i class="large material-icons">sentiment_very_satisfied</i> På lager!
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
<br>
<br>

<%@ include file = "../includes/footer.jsp" %>
