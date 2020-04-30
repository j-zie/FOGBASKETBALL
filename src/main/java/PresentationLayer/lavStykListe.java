package PresentationLayer;

import FunctionLayer.LoginSampleException;
import MaterialeBeregning.StykListePrinter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class lavStykListe extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String ordernumber = request.getParameter("ordrenr");
        StykListePrinter printer = new StykListePrinter(Integer.parseInt(ordernumber));
        String msg = printer.roofPicker();
        session.setAttribute("page", msg);
        return "stykliste";
    }
}
