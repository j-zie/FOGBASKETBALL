package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuickByg extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

    String to = request.getParameter("to");
        switch (to) {

            case "Fladt":
                return "QuickByg/FladtTagpage";

            case "Rejsning":
                return "QuickByg/RejsningTagpage";

            case "ordrebekræft":

                // Lav stik liste osv.
                return "FAIL";
        }

        return "fail"; // Lav error handle
    }
}
