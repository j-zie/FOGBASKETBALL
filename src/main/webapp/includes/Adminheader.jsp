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
    <nav class="nav-extended" style="background-image: linear-gradient(to right, #164886, #00B0FF);  position: -webkit-sticky; position: sticky; top: 0; z-index: 9;">
      <div class="nav-wrapper">
        <a href="#" class="brand-logo"><img src="resources/fog.png"></a>
        <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
          <li><a class="tab white-text" href="#email">${sessionScope.user.email}</a></li>
        </ul>
      </div>
      <div class="nav-content">
        <ul class="tabs tabs-transparent">
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=admin">Admin</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=ordrer">Ordrer</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=SkabMateriale">Tilføj Carport</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=SkabMateriale">Tilføj materiale</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=SletMateriale">Slet materiale</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=register" >Register admin</a></li>
          <li class="tab hoverable"><a class="active" href="FrontController?target=nav&Nav=logud">Log ud</a></li>


        </ul>
      </div>
    </nav>



  <!-- Nav bar slut-->
