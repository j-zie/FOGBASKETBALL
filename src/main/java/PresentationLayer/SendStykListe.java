package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendStykListe extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        // Send til DB

        LogicFacade.sendStykliste(Integer.parseInt(request.getParameter("oid")), Integer.parseInt(request.getParameter("bid")));

        return "ordre";
    }
}
