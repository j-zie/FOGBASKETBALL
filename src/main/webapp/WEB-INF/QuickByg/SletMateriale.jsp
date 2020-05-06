<!DOCTYPE html>
<html>
<head>
    <title>Slet Materiale</title>
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
            width: 80%;

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
        /* invalid color */
        .input-field input[type=text].invalid {
            border-bottom: 1px solid #000;
            box-shadow: 0 1px 0 0 #000;
            background-color: red;
        }

        .input-field input[type=text].valid {
            border-bottom: 1px solid #000;
            box-shadow: 0 1px 0 0 #000;
            background-color: green;
        }
        #errortekst{
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row card hoverable">
        <div class="card-content ">
            <h4 class="center blue-text">Slet Materiale fra DB</h4>
            <form class="row s12" action="FrontController" method="POST">
                <input type="hidden" name="target" value="SletMateriale" >

                <div class="col s12">
                    <div class="input-field">
                        <input type="text" id="materialeNavn" name="materialeNavn" placeholder="Materiale Id / Varekode">
                        <label class="active" for="materialeNavn">Materiale Id:</label>
                        <p id="errorteksttt">${requestScope.errorNavn}</p>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
