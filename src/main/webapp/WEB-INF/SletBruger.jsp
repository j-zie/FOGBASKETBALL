<%@ include file = "/includes/Adminheader.jsp" %>
    <title>Slet Materiale</title>

            <form class="row s12" action="FrontController" method="POST">
                <input type="hidden" name="target" value="SletBruger">
                ${requestScope.html}

                <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>

            </form>

</body>
</html>
