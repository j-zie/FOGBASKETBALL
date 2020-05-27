<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 20/04/2020
  Time: 22.32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "/includes/header.jsp" %>
<%@ page import="FunctionLayer.MaterialeListe" %>
<%@ page import="FunctionLayer.Formatter" %>

<c:if test="${requestScope.popUp != null}">
<div style="position: absolute; z-index: 10; width: 100%; height: 130%; background-color: rgba(0,0,0,0.55) ">
<div style="width: 40%; height: 20%; background-color: white; text-align: center; margin-left: auto; margin-right: auto; margin-top: 40px;">
    <h3 style="margin-top: 20px;"> Carport tilføjet til kurv</h3>
    <a href="FrontController?target=nav&Nav=Katalog" class="waves-effect waves-light btn blue" style="margin: 20px">Shop videre</a>
    <a href="FrontController?target=nav&Nav=kurv" class="waves-effect waves-light btn blue" style="margin: 20px">Gå til kurv </a>
</div>

</div>
</c:if>
<div class="row">

    <div class="col s12 m4 l2" id="sidefilter"> <!-- Note that "m4 l3" was added -->

        <div class="section">
            <h5>Carport type</h5>
            <p><a style="cursor: pointer">Enkelt</a></p>
            <p><a style="cursor: pointer">Dobbelt</a></p>
        </div>

        <div class="section">
            <h5>Carport type</h5>
            <p><a href="FrontController?target=filter&filter=default_spær" style="cursor: pointer">Vis spær</a></p>
            <p><a href="FrontController?target=filter&filter=default_stolpe" style="cursor: pointer">Vis Stolper</a></p>
            <p><a href="FrontController?target=filter&filter=bekældning"style="cursor: pointer">Vis Beklædning</a></p>
            <p><a href="FrontController?target=filter&filter=carport"style="cursor: pointer">Vis Carporte</a></p>


        </div>

        <div class="divider"></div>
        <div class="section">
            <h5>Bredde</h5>
            <form action="#">
            <label>
                <input type="checkbox" class="filled-in"  />
                <span>200 Centimeter</span>
            </label>
            <label>
                <input type="checkbox" class="filled-in"  />
                <span>250 Centimeter</span>
            </label>
            <label>
                <input type="checkbox" class="filled-in"  />
                <span>300 Centimeter</span>
            </label>
            <label>
                <input type="checkbox" class="filled-in"  />
                <span>400 Centimeter</span>
            </label>
                </form>

        </div>
        <div class="divider"></div>
        <div class="section">
            <h5>Længde</h5>
            <form action="#">
                <label>
                    <input type="checkbox" class="filled-in"  />
                    <span>200 Centimeter</span>
                </label>
                <label>
                    <input type="checkbox" class="filled-in"  />
                    <span>250 Centimeter</span>
                </label>
                <label>
                    <input type="checkbox" class="filled-in"  />
                    <span>300 Centimeter</span>
                </label>
                <label>
                    <input type="checkbox" class="filled-in"  />
                    <span>400 Centimeter</span>
                </label>
            </form>
        </div>
    </div>

    <div class="col s12 m8 l10" style="margin-top: 20px;">

        <c:forEach var="ordre" items="${sessionScope.matListe}">
            <div class="card" style="width: 240px; height: 300px; display: inline-block; margin: 15px; ">
                <div class="card-image waves-effect waves-block waves-light">
                    <a href="FrontController?target=nav&Nav=productPage&product=${ordre.materialeID}">
                        <img class="activator" style="height: 131px; width: 100%; object-fit: cover;" src=${ordre.path}>
                    </a>
                </div>
                <div class="card-content">
                    <span class="card-subtitle activator grey-text text-darken-4">
                        <a href="FrontController?target=nav&Nav=productPage&product=${ordre.materialeID}">
                            ${Formatter.fixedStrLength(ordre.materialeNavn)}
                        </a>
                    </span>
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
        </c:forEach>
    </div>

</div>



<br>
<br>
<br>
</body>
</html>
