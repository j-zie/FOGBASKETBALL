<%--
  Created by IntelliJ IDEA.
  User: zie
  Date: 4/22/20
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <style type="text/css">
        body{
            padding: 0;
            margin: 0;
            background: #ddd;
        }
        .btn{
            margin-top: 10px;

        }
        .container{
            margin:100px auto;
            width: 35%;

        }
        @media(max-width: 952px){
            .container{
                width: 60%;
            }
        }
        @media(max-width: 475px){
            .container{
                width: 80%;
            }
        }

    </style>
</head>
<body>

<div class="container">
    <div class="row card hoverable">
        <div class="card-content ">
            <h4 class="center blue-text">Register</h4>
            <c:if test="${requestScope.emptyError != null}"> <p style="color: red; display: inline">${requestScope.emptyError} </p> </c:if>

            <form class="row s12" action="FrontController" method="POST">
                <input type="hidden" name="target" value="register" >

                <div class="col s12">
                    <div class="input-field">
                        <c:if test="${requestScope.emailError != null}"> <p style="color: red; display: inline">${requestScope.emailError} </p> </c:if>
                        <input type="text" name="email" placeholder="Email*">
                    </div>
                </div>
                <div class="col s12">
                    <div class="input-field">
                        <input type="password" name="password1" placeholder="Password*">
                    </div>
                </div>
                <div class="col s12">
                    <div class="input-field">
                        <input type="password" name="password2" placeholder="Password again*">
                    </div>
                </div>

                <div class="col s12">
                    <div class="input-field">
                        <input type="text" name="navn" placeholder="Indtast navn*">
                    </div>
                </div>
                <div class="col s12">
                    <div class="input-field">
                        <input type="text" name="adresse" placeholder="Indtast adresse*">
                    </div>
                </div>


                <div class="col s12">
                    <div class="input-field">
                        <c:if test="${requestScope.postnrError != null}"> <p style="color: red; display: inline">${requestScope.postnrError} </p> </c:if>
                        <input type="text" name="postnr" placeholder="Indtast postnummer*">
                    </div>
                </div>
                <div class="col s12">
                    <div class="input-field">
                        <input type="text" name="telefon" placeholder="Intast Telefon*">
                    </div>
                </div>

                <div class="col s12">
                    <div class="input-field">
                        <input type="text" name="by" placeholder="Indtast by*">
                    </div>
                </div>


                <div class="col s12">
                    <p><label><input type="checkbox"></label></p>
                </div>
                <div class="col s12 center">
                    <button type="submit" value="Submit" class="btn btn-large waves-effect waves-light blue">Login<i class="material-icons right">send</i></button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>