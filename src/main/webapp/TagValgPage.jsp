<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 20/04/2020
  Time: 11.36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quick byg</title>

    <style>
        .Overskrift1 {
            color:dodgerblue;
            margin: 20px;
        }

        .tagvalg {
            margin: 30px;
        }
    </style>


</head>



<body>

<h1 class="Overskrift1"> QUICKBYG</h1>

<div class="tagvalg">
    <h2> Tag med fladt tag</h2>
    <a href="FrontController?target=quickByg&to=Fladt"><img src="Images/Fladttag.png" ></a>
</div>

<div class="tagvalg">
    <h2> Tag med rejsning</h2>
    <a href="FrontController?target=quickByg&to=Rejsning"> <img src="Images/Rejsning.png"></a>
</div>

</body>
</html>
