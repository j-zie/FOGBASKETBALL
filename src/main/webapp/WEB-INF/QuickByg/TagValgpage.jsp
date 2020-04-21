<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 20/04/2020
  Time: 11.36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "/includes/header.jsp" %>



<div style=" width: 50%; height: 100%; margin-right: auto; margin-left: auto">



    <h2 style="color: #00b0ff; display: block; text-align: center "> QUICK-BYG </h2>
<p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
</p>
 <p>   Tilbud og skitsetegning fremsendes med post hurtigst muligt.
    Ved bestilling medfølger standardbyggevejledning. </p>

   <p> Rekvirér tilbud - start med at vælge type: </p>
<div class="tagvalg" style="text-align: center">
    <h4> Carport med fladt tag</h4>
    <a href="FrontController?target=quickByg&to=Fladt"><img src="resources/Fladttag.png" ></a>
</div>

<div class="tagvalg" style="text-align: center">
    <h4> Carport med rejsning</h4>
    <a href="FrontController?target=quickByg&to=Rejsning"> <img src="resources/Rejsning.png"></a>
</div>
</div>
<%@ include file = "/includes/footer.jsp" %>