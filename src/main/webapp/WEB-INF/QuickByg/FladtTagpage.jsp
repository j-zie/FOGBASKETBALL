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


<h3>QUICK-BYG TILBUD - CARPORT MED FLADT TAG</h3>
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


        <label for="bredde">Carport bredde   <c:if test="${requestScope.breddeError != null}">
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
    <option value="780">780 cm</option>
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

    <option value="1">Plasttrapezplader</option>
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
</select>

        </div>
        <input id="SubButton" type="submit" value="Send forespørgsel ">
<div id="seperator"></div>

    </form>


<%@ include file = "/includes/footer.jsp" %>