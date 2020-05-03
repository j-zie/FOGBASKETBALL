package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialeListe;
import MaterialeBeregning.StykListePrinter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * lavStykListe bruger command til at få oplysninger til styklisten hvorefter den returner styklisten
 */

public class lavStykListe extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String ordernumber = request.getParameter("ordrenr");
        StykListePrinter printer = new StykListePrinter(Integer.parseInt(ordernumber));
        String msg = printer.roofPicker();
        MaterialeListe xs = new MaterialeListe();
        xs.debugPrint();
        session.setAttribute("page", msg);
        return "stykliste";
    }
}
