<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 20/04/2020
  Time: 12.03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
        <option selected="selected" value="${requestScope.Bredde}"> ${requestScope.Bredde} cm </option>
    <option value="240">240 cm</option>
    <option value="270">270 cm</option>
    <option value="300">300 cm</option>
    <option value="330">330 cm</option>
    <option value="360">360 cm</option>
    <option value="390">390 cm</option>
    <option value="420">420 cm</option>
    <option value="450">450 cm</option>
    <option value="480">480 cm</option>
    <option value="510">510 cm</option>
    <option value="540">540 cm</option>
    <option value="570">570 cm</option>
    <option value="600">600 cm</option>
    <option value="630">630 cm</option>
    <option value="660">660 cm</option>
    <option value="690">690 cm</option>
    <option value="720">720 cm</option>
    <option value="750">750 cm</option>
</select>
<c:if test="${requestScope.breddeError != null}">
<h4>${requestScope.breddeError}</h4>
</c:if>

<label for="længde">Carport længde </label>
<select id="længde" name="Længde">
    <option selected="selected" value="${requestScope.Længde}"> ${requestScope.Længde} cm </option>
    <option value="240">240 cm</option>
    <option value="270">270 cm</option>
    <option value="300">300 cm</option>
    <option value="330">330 cm</option>
    <option value="360">360 cm</option>
    <option value="390">390 cm</option>
    <option value="420">420 cm</option>
    <option value="450">450 cm</option>
    <option value="480">480 cm</option>
    <option value="510">510 cm</option>
    <option value="540">540 cm</option>
    <option value="570">570 cm</option>
    <option value="600">600 cm</option>
    <option value="630">630 cm</option>
    <option value="660">660 cm</option>
    <option value="690">690 cm</option>
    <option value="720">720 cm</option>
    <option value="750">750 cm</option>
</select>
        <c:if test="${requestScope.længdeError != null}">
            <h4>${requestScope.længdeError}</h4>
        </c:if>

<label for="tag">Tag type </label>
<select id="tag" name="tagtype">
    <option selected="selected" value="${requestScope.tagtype}"> ${requestScope.tagtype} </option>
    <option value="plast">plast</option>
    <option value="træ">træ</option>
    <option value="sten">sten</option>
</select>
        <c:if test="${requestScope.tagError != null}">
            <h4>${requestScope.tagError}</h4>
        </c:if>


<label for="redskabsRumBredde">Redskabsrum bredde</label>
<select id="redskabsRumBredde" name="Redskabsrum_bredde">
    <option selected="selected" value="${requestScope.Redskabsrum_bredde}"> ${requestScope.Redskabsrum_bredde} cm </option>
    <option value="240">240 cm</option>
    <option value="270">270 cm</option>
    <option value="300">300 cm</option>
    <option value="330">330 cm</option>
    <option value="360">360 cm</option>
    <option value="390">390 cm</option>
    <option value="420">420 cm</option>
    <option value="450">450 cm</option>
    <option value="480">480 cm</option>
    <option value="510">510 cm</option>
    <option value="540">540 cm</option>
    <option value="570">570 cm</option>
    <option value="600">600 cm</option>
    <option value="630">630 cm</option>
    <option value="660">660 cm</option>
    <option value="690">690 cm</option>
    <option value="720">720 cm</option>
    <option value="750">750 cm</option>

</select>


<label for="redskabsRumLængde">Redskabsrum bredde</label>
<select id="redskabsRumLængde" name="Redskabsrum_længde">
    <option selected="selected" value="${requestScope.Redskabsrum_længde}"> ${requestScope.Redskabsrum_længde} cm </option>
    <option value="240">240 cm</option>
    <option value="270">270 cm</option>
    <option value="300">300 cm</option>
    <option value="330">330 cm</option>
    <option value="360">360 cm</option>
    <option value="390">390 cm</option>
    <option value="420">420 cm</option>
    <option value="450">450 cm</option>
    <option value="480">480 cm</option>
    <option value="510">510 cm</option>
    <option value="540">540 cm</option>
    <option value="570">570 cm</option>
    <option value="600">600 cm</option>
    <option value="630">630 cm</option>
    <option value="660">660 cm</option>
    <option value="690">690 cm</option>
    <option value="720">720 cm</option>
    <option value="750">750 cm</option>
</select>




<!-- Kundens oplysninger -->
        Navn:<br>
        <input type="text" name="Navn" value="${requestScope.Navn}">
        <c:if test="${requestScope.navnError != null}">
            <h4>${requestScope.navnError}</h4>
        </c:if>
        <br>
        Adresse:<br>
        <input type="text" name="Adresse" value="${requestScope.Adresse}">
        <c:if test="${requestScope.adresseError != null}">
            <h4>${requestScope.adresseError}</h4>
        </c:if>
        <br>
        Postnummer og by:<br>
        <input type="text" name="Postnummer" value="${requestScope.Postnummer}">
        <c:if test="${requestScope.byError != null}">
            <h4>${requestScope.byError}</h4>
        </c:if>
        <br>
        Telefon:<br>
        <input type="text" name="Telefon" value="${requestScope.Telefon}">
        <c:if test="${requestScope.telefonError != null}">
            <h4>${requestScope.telefonError}</h4>
        </c:if>
        <br>
        E-email adresse:<br>
        <input type="text" name="Email" value="${requestScope.Email}">
        <c:if test="${requestScope.emailError != null}">
            <h4>${requestScope.emailError}</h4>
        </c:if>
        <br>

        <input type="submit" value="Send forespørgsel ">

    </form>



</body>
</html>
