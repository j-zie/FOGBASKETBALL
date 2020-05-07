<%--
  Created by IntelliJ IDEA.
  User: zie
  Date: 4/21/20
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ include file = "includes/header.jsp" %>

<div class="container">
    <h1 class="header center blue-text" style="font-weight: bolder ">Fog trælast og byggemarked</h1>
</div>



<h6 class="center">fra NIV (1967)</h6>
<div class="container">
        <div class="card blue-grey darken-1 center">
            <div class="card-content white-text">
                <span class="card-title">The Way of the Cross</span>
                <p> "Then he called the crowd to him along with his disciples and said: “Whoever wants to be my disciple must deny themselves and take up their cross and follow me.
                    35 For whoever wants to save their life will lose it, but whoever loses their life for me and for the gospel will save it. 36 What good is it for someone to
                    gain the whole world, yet forfeit their soul? 37 Or what can anyone give in exchange for their soul? 38 If anyone is ashamed of me and my words in this adulterous
                    and sinful generation, the Son of Man will be ashamed of them when he comes in his Father’s glory with the holy angels.”</p>
        </div>
    </div>
</div>

<div class="row">
    <div style="float: left; width: 33.33%; padding:5px;">
        <img src="resources/choppingboard.jpg" alt="Snow" style="width:100%">
    </div>
    <div style="float: left; width: 33.33%; padding:5px;">
        <img src="resources/powertool.jpg" alt="Forest" style="width:100%">
    </div>
    <div style="float: left; width: 33.33%; padding:5px; height: 60%">
        <img src="resources/knife.jpg" alt="Mountains" style="width:100%">
    </div>
</div>


<form action="uploadd" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<%@ include file = "includes/footer.jsp" %>
