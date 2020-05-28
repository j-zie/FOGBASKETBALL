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
System.out.println("hdhadshdahsddasd");
            // Hvad er det her?? Vi kan ikke bare hoppe fra presæntations laget til DB laget.
            // Det giver løst lavdelt-akitektur.

            ordreMapper.sletOrdre(Integer.parseInt(request.getParameter("ordrenr" )));
        } catch (OrdreRetrivalException e) {
            e.printStackTrace();
            System.out.println("OrdreRetrivalE");
        }
        ArrayList<Ordre> alleOrdre = LogicFacade.hentAlleOrdre();
        session.setAttribute("alleOrdre", alleOrdre);


        return "ordre";


    }
}




