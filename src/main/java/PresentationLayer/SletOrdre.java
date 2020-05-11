package PresentationLayer;

import DBAccess.*;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Ordre;
import FunctionLayer.OrdreRetrivalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class SletOrdre extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        OrdreMapper ordreMapper = new OrdreMapper();
        HttpSession session = request.getSession();
        try {
            ordreMapper.sletOrdre(Integer.parseInt(request.getParameter("ordrenr" )));
        } catch (OrdreRetrivalException e) {
            e.printStackTrace();
        }
        ArrayList<Ordre> alleOrdre = LogicFacade.hentAlleOrdre();
        session.setAttribute("alleOrdre", alleOrdre);


        return "ordre";


    }
}




