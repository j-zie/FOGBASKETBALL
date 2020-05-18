<!DOCTYPE html>
<html>
<head>
    <title>Indsæt Materiale</title>
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
            <h4 class="center blue-text">Tilføj ny carport til katalog</h4>
            <form class="row s12" action="upload" enctype="multipart/form-data" method="post">
                <input type="hidden" name="bool" value="car" >
                <div class="col s12">
                    <div class="input-field">
                        <input type="text" id="materialeNavn" name="carportNavn" placeholder="Carport 3,60X7,20M med redskabsrum 3,20X2,20M">
                        <label class="active" for="materialeNavn">Carport beskrivelse:</label>
                        <p id="errortekst">${requestScope.errorNavn}</p>
                    </div>
                </div>

                <div class="input-field col s6">
                    <input id=pris type="number" name="pris" min="0" step="0.01" placeholder="76.99" >
                    <i>Kr.</i>
                    <label class="active" for="pris">Indtast pris pr. styk</label>
                    <p id="errortekst">${requestScope.errorPris}</p>

                </div>

                <div class="form-group">
                    <label for="fil">Indsæt Billede af carport</label>
                    <input type="file" name="billede" class="form-control-file" id="fil">
                </div>

                <div class="col s12 center">
                    <button type="submit" value="Submit" class="btn btn-large waves-effect waves-light blue">Tilføj<i class="material-icons right">send</i></button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>