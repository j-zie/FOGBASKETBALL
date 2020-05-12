<%@ include file = "/includes/Adminheader.jsp" %>
<style>
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

<div class="container">
    <div class="row card hoverable">
        <div class="card-content ">
            <h4 class="center blue-text">Slet Materiale</h4>
            <p>Vælg MaterialeID og slet et Materiale</p>
            <form class="row s12" action="FrontController" method="POST">
                <input type="hidden" name="target" value="SletMateriale">
                ${requestScope.html}

                <button class="btn waves-effect waves-light blue" type="submit" name="action">Slet
                    <i class="material-icons right">send</i>
                </button>

            </form>
        </div>
    </div>
</div>

</body>
</html>
