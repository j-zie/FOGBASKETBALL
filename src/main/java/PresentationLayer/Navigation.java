package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Ordre;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Navigation extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        String nav = request.getParameter("Nav");


        switch (nav) {

            case "Katalog":
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
        }
        return nav + "page";
    }
}
