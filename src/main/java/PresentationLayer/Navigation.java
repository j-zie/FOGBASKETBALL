package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 * Navigation klassen er en del af command mønstret
 * Den modtager http requests og retunere strenge der repræsenere filstier til andre jsp pages.
 */
public class Navigation extends Command {
    /**
     * TODO(Jonathan) Til patrick: Hvis det er meningen du ikke vil have en default case, så skriv det som kommentar, det er standard. Tænkte det var almen viden.
     * Går til den jsp side som du giver som parametre i din request (kan være skjult.)
     * @return Retunere en streng til en gyldig jsp side
     * @param request fra jsp side med værdi "nav"
     * @param response header informationer
     **/

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        ServletContext applicationScope = request.getServletContext();
        String nav = request.getParameter("Nav");
        LavSelectFormHTML html = new LavSelectFormHTML();


        switch (nav) {
            case "katalog":
                MaterialeListe x = new MaterialeListe();
                ArrayList<Materiale> xs = x.getMatListe();
                applicationScope.setAttribute("matListeA", xs);
                session.setAttribute("matListe", xs);
                return "katalogpage";
            case "QuickByg":
                if (session.getAttribute("user") == null) {
                    return "QuickByg/loginOrSignuppage";
                }
                return "QuickByg/tagValgpage";
            case "productPage":

                MaterialeListe alom = new MaterialeListe();
                String product = request.getParameter("product");
                Materiale mater = alom.getMaterialeByNum(Integer.parseInt(product));
                session.setAttribute("product", mater);
                return "productpage";
            case "login":
                return "login";
            case "kurv":
                if
                (request.getParameter("item") != null) {
                    KurvItems.removeItem(request.getParameter("item"));
                   }
                return "kurvpage";
            case "ordrer":
                ArrayList<Ordre> alleOrdre = LogicFacade.hentAlleOrdre();
                session.setAttribute("alleOrdre", alleOrdre);
                return "ordre";
            case "admin":
                return "admin";
            case "register":
                return "register";
            case "skabMateriale":
                return "skabMateriale";
            case "sletMateriale":
                request.setAttribute("html",html.fåSelectFormForMaterialerpåID());
                return "QuickByg/sletMateriale";
            case "logud":
                session.invalidate(); // Log ud her. Ved ikke lige om det sådan..
                return "main";
            case "tilføjCarport":
                return "tilføjCarport";
            case "hjem":
                return "main";
            case "sletBruger":
                request.setAttribute("html",html.fåSelectFormForBrugerepåID());
                return "sletBruger";
        }

        return nav + "page";
    }
}
