<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 20/04/2020
  Time: 12.03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fladt tag</title>
</head>
<body>


    <form name="kundeInfo" action="FrontController" method="POST">
        <input type="hidden" name="target" value="quickByg">
        <input type="hidden" name="to" value="ordrebekræft">

<!-- Dimensioner på carport -->
<label for="bredde">Carport bredde </label>
<select id="bredde" name="Bredde">
    <option selected="selected"> Vælg bredde </option>
    <option value="200 cm">200 cm</option>
    <option value="300 cm">300 cm</option>
    <option value="400 cm">400 cm</option>
</select>

<label for="længde">Carport længde </label>
<select id="længde" name="længde">
    <option selected="selected"> Vælg længde </option>
    <option value="200 cm">200 cm</option>
    <option value="300 cm">300 cm</option>
    <option value="400 cm">400 cm</option>
</select>

<label for="tag">Tag type </label>
<select id="tag" name="tagtype">
    <option selected="selected"> Vælg tag </option>
    <option value="plast">plast</option>
    <option value="træ">træ</option>
    <option value="sten">sten</option>
</select>


<label for="redskabsRumBredde">Redskabsrum bredde</label>
<select id="redskabsRumBredde" name="Redskab_bredde">
    <option selected="selected">Ønsker ikke redskabsrum </option>
    <option value="200 cm">200 cm</option>

</select>

<label for="redskabsRumLængde">Redskabsrum bredde</label>
<select id="redskabsRumLængde" name="Redskab_længde">
    <option selected="selected">Ønsker ikke redskabsrum </option>
    <option value="300 cm">300 cm</option>
</select>




<!-- Kundens oplysninger -->

        Navn:<br>
        <input type="text" name="Navn" value="">
        <br>
        Adresse:<br>
        <input type="text" name="Adresse" value="">
        <br>
        Postnummer og by:<br>
        <input type="text" name="Postnummer" value="">
        <br>
        Telefon:<br>
        <input type="text" name="Telefon" value="">
        <br>
        E-email adresse:<br>
        <input type="text" name="Email" value="">
        <br>

        <input type="submit" value="Submit">

    </form>



</body>
</html>
