package PresentationLayer;

import FunctionLayer.*;
import javafx.application.Application;

import javax.faces.bean.ApplicationScoped;
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
        String nav = request.getParameter("Nav");

        switch (nav) {
            case "Katalog":
                MaterialeListe x = new MaterialeListe();
                ArrayList<Materiale> xs = x.getCarporte();
                session.setAttribute("carportski", xs);
              
                // Her kan der kaldes metode til evt. at hente alle carporte fra db.
                return "Katalogpage";
            case "QuickByg":
                if (session.getAttribute("user") == null) {
                    return "QuickByg/LoginOrSignuppage";
                }
                return "QuickByg/TagValgpage";
            case "login":
                return "login";
            case "kurv":
                if (request.getParameter("item") != null) {
                    KurvItems.removeItem(request.getParameter("item"));
                   }


                return "Kurvpage";
            case "ordrer":
                ArrayList<Ordre> alleOrdre = LogicFacade.hentAlleOrdre();
                session.setAttribute("alleOrdre", alleOrdre);
                return "ordre";
            case "admin":
                return "admin";
            case "register":
                return "register";
            case "SkabMateriale":
                return "SkabMateriale";
            case "SletMateriale":
                return "QuickByg/SletMateriale";
            case "logud":
                session.invalidate(); // Log ud her. Ved ikke lige om det sådan..
                return "main";
            case "tilføjCarport":
                return "TilføjCarport";
            case "hjem":
                return "main";
        }
        return nav + "page";
    }
}
