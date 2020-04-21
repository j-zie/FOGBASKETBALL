<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

  <!-- Nav bar -->
    <nav class="nav-extended" style="background-color: white">
      <div class="nav-wrapper">
        <a href="#" class="brand-logo"><img src="logo.jpg"></a>
        <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
          <li><a href="sass.html">emailHer@måske.dk</a></li>
          <li><a href="badges.html">Kurv?</a></li>

        </ul>
      </div>
      <div class="nav-content">
        <ul class="tabs tabs-transparent">
          <li class="tab"><a class="active" href="index.jsp" style="color: orange">Hjem</a></li>
          <li class="tab"><a class="active" href="FrontController?target=nav&Nav=Katalog" style="color: orange">Katalog</a></li>
          <li class="tab"><a href="FrontController?target=nav&Nav=QuickByg" style="color: orange">QuickByg</a></li>
          <li class="tab"><a href="FrontController?target=nav&Nav=login" style="color: orange">LOGIN TESTER</a></li>
          <li class="tab"><a href="FrontController?target=nav&Nav=login" style="color: orange"> ${sessionScope.email}</a></li>

        </ul>
      </div>
    </nav>
  ${sessionScope.email}
    <ul class="sidenav" id="mobile-demo">
      <li><a href="sass.html">Sass</a></li>
      <li><a href="badges.html">Components</a></li>
      <li><a href="collapsible.html">JavaScript</a></li>
    </ul>
  <!-- Nav bar slut-->
