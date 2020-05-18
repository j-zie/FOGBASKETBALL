<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 20/04/2020
  Time: 11.36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "/includes/header.jsp" %>


<body>

<h3 class="center header">QUICKBYG</h3>
<h5 class="center grey-text">Vælg hvilken type tag din carport skal have</h5>

<div style="text-align: center">
    <div class="col s12 m7" style=" margin: 20px; display: inline-block;">
        <div class="card" style="width: 300px; top: 0; ">
            <div class="card-image" style="width: 300px; ">
                <img src="resources/FladtagIcon.png">
                <span class="card-title"></span>
            </div>
            <div class="card-content">
                <h5> Fladt tag</h5>
                <p> Billigere end med rejsning</p>
                <p>  Nem at sætte op</p>
            </div>
            <div class="card-action center">
                <a class="btn-small" href="FrontController?target=quickByg&to=Fladt" style="margin-top: auto; margin-bottom: auto"> Select </a>
            </div>
        </div>
    </div>

<div class="col s12 m7" style=" margin: 20px; display: inline-block;" >
    <div class="card" style="width: 300px; top: 0;">
        <div class="card-image" style="width: 300px; ">
            <img src="resources/RejsningtagIcon.png">
            <span class="card-title"></span>
        </div>
        <div class="card-content">
            <h5> Tag med Rejsning</h5>
            <p> Ser skide godt ud</p>
            <p> Flere slags tagsten</p>
        </div>
        <div class="card-action center">
            <a class="btn-small"  href="FrontController?target=quickByg&to=Rejsning" style="margin-top: auto; margin-bottom: auto"> Select </a>
        </div>
    </div>
</div>

</div>




</body>
</html>
