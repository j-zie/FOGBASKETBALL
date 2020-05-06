package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Ordre;

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
                System.out.println(request.getPathInfo());
                System.out.println(request.getContextPath());
                System.out.println(request.getRequestURI());


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
                return "Kurvpage";
            case "admin":
                ArrayList<Ordre> alleOrdre = LogicFacade.hentAlleOrdre();
                session.setAttribute("alleOrdre", alleOrdre);
                return "AdminStyklisteRefpage";
            case "register":
                return "register";
            case "SkabMateriale":
                return "SkabMateriale";
            case "logud":
                session.invalidate(); // Log ud her. Ved ikke lige om det sådan..
                return "main";
        }
        return nav + "page";
    }
}
