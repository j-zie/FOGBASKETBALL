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
                        <input type="text" id="materialeNavn" name="materialeNavn" placeholder="Trykimprægnerede stolpe 100x100mm">
                        <label class="active" for="materialeNavn">Materiale Navn:</label>
                        <p id="errorteksttt">${requestScope.errorNavn}</p>
                    </div>
                </div>
                <div class="col s12">
                    <div class="input-field">
                        <input type="text" id="materialeBeskrivelse" name="materialeBeskrivelse" placeholder="Imprægneret stolpe til hegn, plankeværk eller andre udendørs byggeprojekter der kræver modstandsdygtigt og slidstærkt træ.'">
                        <label class="active" for="materialeBeskrivelse">Materiale Beskrivelse:</label>
                        <p id="errortekst">${requestScope.errorBeskrivelse}</p>

                    </div>
                </div>


                <div class="input-field col s6">
                    <input id=pris type="number" name="pris" min="0" step="0.01" placeholder="76.99" >
                    <i>Kr.</i>
                    <label class="active" for="pris">Indtast pris pr. styk</label>
                </div>
                <div class="col s6 center">
                    <div class="input-field">
                        <input type="text" id="tag" name="tag" placeholder="Spær, Stolpe, Beklædning osv.">
                        <label class="active" for="tag">Materialegruppering:</label>
                        <p id="errortekstt">${requestScope.errorTag}</p>

                    </div>
                </div>

                <div class="col s12 center">
                    <button type="submit" value="Submit" class="btn btn-large waves-effect waves-light blue">Send til DB<i class="material-icons right">send</i></button>
                </div>

                <form>
                    <div class="form-group">
                        <label for="fil">Indsæt Billede til Materialet</label>
                        <input type="file" class="form-control-file" id="fil">
                    </div>
                </form>


            </form>
        </div>
    </div>
</div>

</body>
</html>
