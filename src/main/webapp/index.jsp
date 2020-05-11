<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>Parallax Template - Materialize</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>

<body>
<nav style="background-image: linear-gradient(to right, #164886, #00B0FF)" >
  <a href="#" class="brand-logo"><img src="resources/fog.png">
  </a>
</nav>

  <div id="index-banner" class="parallax-container">
    <div class="section no-pad-bot">
      <div class="container">
        <br><br>
        <h1 class="header center white-text text-lighten-2" style="font-weight: bolder;">TRÆLAST <br>& BYGGECENTER</h1>
        <div class="row center">
          <a href="FrontController?target=nav&Nav=hjem" id="download-button" class="btn-large waves-effect waves-light blue lighten-1">Kig ind!</a>
        </div>
      </div>
    </div>
    <div class="parallax"><img src="resources/background1.jpg" alt="Unsplashed background img 1"></div>
  </div>

  <div class="card-panel orange lighten-2">
    <h3>CORONA | COVID-19 - STATUS: FORRETNINGERNE ER ÅBNE</h3>
    Alle vores forretninger i Johannes Fog holder åbent og følger de sædvanlige åbningstider, og vi vil gøre vores allerbedste for at betjene dig.
    <br />For at begrænse smitterisikoen for både kunder og ansatte har vi indført begrænsninger, som vi håber du vil bakke op om og hjælpe os med.
    <br /><strong><a href="/byggecenter/om-fog/aktuel-information/">Læs mere her</a></strong></div>
  </div>

  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">gavel</i></h2>
            <h5 class="center">Købsgaranti fra Pricerunner</h5>

            <p class="light">Når du handler hos Johannes Fog, er du omfattet af PriceRunner Købsgaranti. Dermed er du sikret op til 50.000 kroner, hvis noget skulle gå galt i forbindelse med dit køb. Købsgarantien koster intet og gælder for alle registrerede brugere på PriceRunner. <a href="/byggecenter/hvordan-kober-jeg/pricerunner-kobsgaranti/" target="_top"><strong>Se mere her</strong></a></p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">computer</i></h2>
            <h5 class="center">QUICK-BYG TILBUD</h5>

            <p class="light">Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">shopping_cart</i></h2>
            <h5 class="center">Online shop</h5>
            <p class="light">Hos Fog Trælast & Byggecenter har vi et sortiment som spænder bredt indenfor byggematerialer, bolig, have & fritid og værktøj. Danskerne er mestre i at gøre det selv, er det også gældende for dig?</p>
          </div>
        </div>
      </div>

    </div>
  </div>


  <div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
      <div class="container">
        <div class="row center">
          <h5 class="header col s12 light" style="color:gray">En gammeldags trælast som insistere på at følge tiderne</h5>
        </div>
      </div>
    </div>
    <div class="parallax"><img src="resources/background2.jpg" alt="Unsplashed background img 2"></div>
  </div>

  <div class="container">
    <div class="section">

      <div class="row">
        <div class="col s12 center">
          <h3><i class="mdi-content-send brown-text"></i></h3>
          <h4>Stil os et spørgsmål</h4>
          <p class="left-align light">En af vores kompetente medarbejdere vil hurtigst muligt besvare spørgsmålet. Ønsker du at få oplyst en pris eller få et tilbud, svarer vi dig gerne på mail eller telefon.
            Det er derfor vigtigt, at du oplyser navn, adresse, telefonnummer samt e-mail.</p>

            <div class="row">
              <form class="col s12">
                <div class="row">
                  <div class="input-field col s6">
                    <input placeholder="Placeholder" id="first_nae" type="text" class="validate">
                    <label for="first_name">First Name</label>
                  </div>
                    <div class="input-field col s6">
                    <input id="last_name" type="text" class="validate">
                    <label for="last_name">Last Name</label>
                  </div>
                <div class="input-field col s6">
                  <input placeholder="Placeholder" id="first_name" type="text" class="validate">
                  <label for="first_name">Telefonnummer</label>
                </div>
                <div class="input-field col s6">
                  <input id="last_nam" type="text" class="validate">
                  <label for="last_name">Email</label>
                </div>

                <div class="input-field col s6">
                  <i class="material-icons prefix">mode_edit</i>
                  <textarea id="icon_prefix2" class="materialize-textarea"></textarea>
                  <label for="icon_prefix2">Skriv besked her </label>
                </div>

              </div>
              </form>
            </div>
        </div>
      </div>
    </div>
  </div>
<%@ include file = "includes/footer.jsp" %>


