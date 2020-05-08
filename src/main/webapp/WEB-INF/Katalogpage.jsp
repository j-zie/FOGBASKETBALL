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


<div class="row">

    <div class="col s12 m4 l2" id="sidefilter"> <!-- Note that "m4 l3" was added -->

        <div class="section">
            <h5>Carport type</h5>
            <p><a style="cursor: pointer">Enkelt</a></p>
            <p><a style="cursor: pointer">Dobbelt</a></p>
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


        <div class="card" style="width: 220px; height: 260px; display: inline-block; margin: 15px; ">
            <div class="card-image waves-effect waves-block waves-light">
                <img class="activator" src="resources/Carporte/Carport1.png">
            </div>
            <div class="card-content">
                <span class="card-subtitle activator grey-text text-darken-4">Carport 3,60X7,20M med redskabsrum 3,20X2,20M</span>
                <p><a href="#">Læg i kurv </a></p>
            </div>
        </div>

        <div class="card" style="width: 220px; height: 260px; display: inline-block; margin: 15px; ">
            <div class="card-image waves-effect waves-block waves-light">
                <img class="activator" src="resources/Carporte/Carport2.png">
            </div>
            <div class="card-content">
                    <span class="card-subtitle activator grey-text text-darken-4">Carport enkelt 3,60X5,40M med Høj rejsning</span>
                <p><a href="#">Læg i kurv</a></p>
            </div>
        </div>

        <div class="card" style="width: 220px; height: 300px; display: inline-block; margin: 15px; ">
            <div class="card-image waves-effect waves-block waves-light">
                <img class="activator" src="resources/Carporte/Carport3.png">
            </div>
            <div class="card-content">
                <span class="card-subtitle activator grey-text text-darken-4">Carport 3,90X7,80M med redskabsrum 2,40X3,30M</span>
                <p>Pris: 300</p>
                <p><a href="#">Læg i kurv</a></p>
            </div>
        </div>

        <div class="card" style="width: 220px; height: 260px; display: inline-block; margin: 15px; ">
            <div class="card-image waves-effect waves-block waves-light">
                <img class="activator" src="resources/Carporte/Carport4.png">
            </div>
            <div class="card-content">
                    <span class="card-subtitle activator grey-text text-darken-4">Carport 3,60X8,10M med redskabsrum 3,05X3,20M</span>
                <p><a href="#">Læg i kurv</a></p>
            </div>
        </div>

        <div class="card" style="width: 220px; height: 260px; display: inline-block; margin: 15px; ">
            <div class="card-image waves-effect waves-block waves-light">
                <img class="activator" src="resources/Carporte/Carport5.png">
            </div>
            <div class="card-content">
                <span class="card-subtitle activator grey-text text-darken-4">Carport 3,00X4,80M med Fladt tag</span>
                <p><a href="#">Læg i kurv</a></p>
            </div>
        </div>

        <c:forEach var="ordre" items="${sessionScope.carportski}">
           Ordre: ${ordre.materialeNavn}
                
        </c:forEach>



    </div>

</div>



<br>
<br>
<br>
</body>
</html>
