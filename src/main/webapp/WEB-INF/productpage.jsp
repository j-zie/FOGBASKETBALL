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
        <img src="${sessionScope.product.path}" style="width:400px;height:400px;">
    </div>
    <div class="col s6">
        <h5>${sessionScope.product.pris}</h5>/stk
        <p style="text-decoration: underline; font-size: small;">Lev. omkom.tillægges </p>
        <p class="flow-text">${sessionScope.product.beskrivelse}</p>

        <div class="card" style="width: 450px; height: 150px; margin: 15px; ">
        <div style="padding-top: 50px; padding-left: 30px;">
                    <span class="card-subtitle activator grey-text text-darken-4">
                        <i class="small material-icons">check</i> På lager!     
                    </span>
            <div style="display: inline-block;">
            <form action="FrontController" method="POST">
                <input type="hidden" name="target" value="lægIkurv" >
                <input  type="hidden" name="beskrivelse" value="${sessionScope.product.materialeNavn}">
                <input  type="hidden" name="billede" value=${sessionScope.product.path}>
                <input  type="hidden" name="pris" value=${sessionScope.product.pris.toString()}>
                <input  type="hidden" name="tag" value=${sessionScope.product.tag}>
                <button type="submit" value="Submit" class="btn btn-large waves-effect waves-light blue">Læg i kurv</button>
            </form>
            </div>
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
<br>
<br>

<%@ include file = "../includes/footer.jsp" %>
