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
    <nav class="nav-extended" style="background-image: linear-gradient(to right, #164886, #00B0FF); position: -webkit-sticky; position: sticky; top: 0; z-index: 9;">
      <div class="nav-wrapper">
        <a href="#" class="brand-logo"><img src="resources/fog.png"></a>
        <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
          <li><a class="tab white-text" href="#email">${sessionScope.user.email}</a></li>
          <li><a class="tab white-text" href="FrontController?target=nav&Nav=kurv"> <i class="material-icons">shopping_cart</i></a></li>

        </ul>
      </div>
      <div class="nav-content">
        <ul class="tabs tabs-transparent">
          <li class="tab hoverable"><a class="active" href="main.jsp" >Hjem</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=Katalog" >Katalog</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=QuickByg">QuickByg</a></li>
          <c:if test="${sessionScope.user == null}" >
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=login" >Login</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=register" >Registrer</a></li>
          </c:if>
          <c:if test="${sessionScope.user != null}" >
            <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=logud">Log ud</a></li>
          </c:if>





        </ul>
      </div>
    </nav>
    <ul class="sidenav" id="mobile-demo">
      <li><a href="sass.html">test</a></li>
      <li><a href="badges.html">test</a></li>
      <li><a href="collapsible.html">test</a></li>
    </ul>


  <!-- Nav bar slut-->
