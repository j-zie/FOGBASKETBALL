<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 20/04/2020
  Time: 12.03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file = "/includes/header.jsp" %>






<div id="Oplysninger" style="display: block; width: 60%; margin-left: auto; margin-right: auto">


    <h3>QUICK-BYG TILBUD - CARPORT MED REJSNING</h3>
    <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
    </p>
    <p> Tilbud og skitsetegning fremsendes med post hurtigst muligt. Ved bestilling medfølger standardbyggevejledning.
    </p>
    <h6>
        Udfyld nedenstående omhyggeligt og klik på "Send forespørgsel"
    </h6>
</div>



<form id="holdingBox" name="kundeInfo" action="FrontController" method="POST">
    <input type="hidden" name="target" value="quickByg">
    <input type="hidden" name="to" value="FladtTagOrdrebekræft">



    <!-- Dimensioner på carport -->
    <div id="CarportDiv">


        <%--@declare id="taghældning"--%><label for="bredde">Carport bredde   <c:if test="${requestScope.breddeError != null}">
            <p style="color: red; display: inline"> ${requestScope.breddeError} </p>
        </c:if> </label>
        <select id="bredde" name="Bredde">
            <c:choose>
                <c:when test="${requestScope.Bredde != null}">
                    <option selected="selected" value="${requestScope.Bredde}"> ${requestScope.Bredde} cm </option>
                </c:when>
                <c:otherwise>
                    <option selected="selected" value="${requestScope.Bredde}"> Vælg bredde</option>
                </c:otherwise>
            </c:choose>
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




        <label for="længde">Carport længde   <c:if test="${requestScope.længdeError != null}">
            <p style="color: red; display: inline">${requestScope.længdeError} </p>
        </c:if> </label>
        <select id="længde" name="Længde">
            <c:choose>
                <c:when test="${requestScope.Bredde != null}">
                    <option selected="selected" value="${requestScope.Længde}"> ${requestScope.Længde} cm </option>
                </c:when>
                <c:otherwise>
                    <option selected="selected" value="${requestScope.Bredde}"> Vælg længde</option>
                </c:otherwise>
            </c:choose>
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


        <label for="tag">Tag type  <c:if test="${requestScope.tagError != null}"> <p style="color: red; display: inline">${requestScope.tagError} </p> </c:if></label>
        <select id="tag" name="tagtype">
            <c:choose>
                <c:when test="${requestScope.Bredde != null}">
                    <option selected="selected" value="${requestScope.tagtype}"> ${requestScope.tagtype} cm </option>
                </c:when>
                <c:otherwise>
                    <option selected="selected" value=""> Vælg tagtype</option>
                </c:otherwise>
            </c:choose>

            <option value="plast">plast</option>
            <option value="træ">træ</option>
            <option value="sten">sten</option>
        </select>


        <label for="Taghældning">Taghældning</label>
        <select id="taghældning" name="Taghældning">
            <option selected="selected" value="15"> 15 grader</option>
            <option value="25"> 20 grader</option>
            <option value="25">25 grader</option>
            <option value="30">30 grader</option>
            <option value="35">35 grader</option>
            <option value="40">40 grader</option>
            <option value="45">45 grader</option>
        </select>


        <label for="redskabsRumBredde">Redskabsrum bredde</label>
        <select id="redskabsRumBredde" name="Redskabsrum_bredde">
            <option selected="selected" value="0"> Ønsker ikke redskabsrum  </option>
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


        <label for="redskabsRumLængde">Redskabsrum længde</label>
        <select id="redskabsRumLængde" name="Redskabsrum_længde">
            <option selected="selected" value="0"> Ønsker ikke redskabsrum</option>
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

    </div>
    <input id="SubButton" type="submit" value="Send forespørgsel ">
    <div id="seperator"></div>

</form>
<!--
<div id="KundeDiv">


Navn: <c:if test="${requestScope.navnError != null}"> <p style="color: red; display: inline">${requestScope.navnError}</p> </c:if>
<br>
<input type="text" name="Navn" value="${requestScope.Navn}">
<br>
Adresse: <c:if test="${requestScope.adresseError != null}"> <p style="color: red; display: inline">${requestScope.adresseError}</p> </c:if>
<br>
<input type="text" name="Adresse" value="${requestScope.Adresse}">
<br>
Postnummer og by: <c:if test="${requestScope.byError != null}"> <p style="color: red; display: inline">${requestScope.byError}</p> </c:if>
<br>
<input type="text" name="Postnummer" value="${requestScope.Postnummer}">
<br>
Telefon: <c:if test="${requestScope.telefonError != null}"> <p style="color: red; display: inline">${requestScope.telefonError}</p> </c:if>
<br>
<input type="text" name="Telefon" value="${requestScope.Telefon}">
<br>
E-email adresse: <c:if test="${requestScope.emailError != null}"> <p style="color: red; display: inline">${requestScope.emailError}</p> </c:if>
<br>
<input type="text" name="Email" value="${requestScope.Email}">
<br>

<input id="SubButton" type="submit" value="Send forespørgsel ">
</div>

-->

<%@ include file = "/includes/footer.jsp" %>