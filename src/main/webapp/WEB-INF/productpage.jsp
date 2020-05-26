<%--
  Created by IntelliJ IDEA.
  User: zie
  Date: 4/23/20
  Time: 3:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../includes/header.jsp" %>
<div class="col s12 m8 l10" style="margin-top: 20px;">
        <div class="card" style="width: 240px; height: 300px; display: inline-block; margin: 15px; ">
            <div class="card-image waves-effect waves-block waves-light">
                <img class="activator" style="height: 131px; width: 100%; object-fit: cover;" src="../resources/artsy.jpg">
            </div>
            <div class="card-content">
                <span class="card-subtitle activator grey-text text-darken-4">${Formatter.fixedStrLength(ordre.materialeNavn)}</span>
                <p>Pris: ${ordre.pris.toString()}</p>
                <form action="FrontController" method="POST">
                    <input type="hidden" name="target" value="lægIkurv" >
                    <input  type="hidden" name="beskrivelse" value="${ordre.materialeNavn}">
                    <input  type="hidden" name="billede" value=${ordre.path}>
                    <input  type="hidden" name="pris" value=${ordre.pris.toString()}>
                    <input  type="hidden" name="tag" value=${ordre.tag}>
                    <button type="submit" value="Submit" class="btn btn-small waves-effect waves-light blue">Læg i kurv</button>
                </form>
            </div>
        </div>
</div>

heheheheh:
${sessionScope.product}


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
