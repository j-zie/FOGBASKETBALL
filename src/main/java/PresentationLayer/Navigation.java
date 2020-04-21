package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Navigation extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String nav = request.getParameter("Nav");


        switch (nav) {
            case "Katalog":

                // Her kan der kaldes metode til evt. at hente alle carporte fra db.

                return "Katalogpage";

            case "QuickByg":
                return "QuickByg/TagValgpage";
        }



        return nav + "page";
    }
}
