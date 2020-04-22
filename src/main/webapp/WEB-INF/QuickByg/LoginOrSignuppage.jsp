<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 22/04/2020
  Time: 20.13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "/includes/header.jsp" %>
<body>


<div id="index-banner" class="parallax-container">
    <div class="section no-pad-bot">
        <div class="container">
            <br><br>
            <h3 class="header center black-text text-lighten-2" style="font-weight: bolder;"> For at kunne få et quickbyg tilbud
                skal du logge ind eller registrer dig først</h3>
            <div class="row center">

                <a class="waves-effect waves-light btn-large blue hoverable" href="FrontController?target=nav&Nav=login">Login</a>
                <a class="waves-effect waves-light btn-large blue hoverable" href="FrontController?target=nav&Nav=register">Signup</a>
            </div>
        </div>
    </div>
    <div class="parallax"><img src="resources/background4.jpg" alt="Unsplashed background img 1"></div>
</div>

<div class="container center">
    <br>
<h4>Hvad er et quickbyg tilbud?</h4>
<h6 style="width: 80%; margin-left: auto; margin-right: auto">Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen
    og udskrive en skitsetegning på en carport indenfor vores standardprogram,
    der tilpasses dine specifikke ønsker.
    Du kan altså selv designe din drømme carport, som passe lige til det du mangler. Det eneste du skal gøre er
    blot at indtaste dine ønskede mål.
</h6>
<br><br><br><br>
</div>

<%@ include file = "/includes/footer.jsp" %>