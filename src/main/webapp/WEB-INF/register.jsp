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
            <form class="row s12" action="FrontController" method="POST">
                <input type="hidden" name="target" value="register" >

                <div class="col s12">
                    <div class="input-field">
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