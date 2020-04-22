package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
                return "AdminStyklisteRefpage";
            case "register":
                return "register";
        }
        return nav + "page";
    }
}
