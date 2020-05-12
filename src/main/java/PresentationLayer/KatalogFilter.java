package PresentationLayer;

import DBAccess.MaterialeMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materiale;
import FunctionLayer.MaterialeListe;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class KatalogFilter extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        ServletContext applicaitonScope = request.getServletContext();

        ArrayList<Materiale> OGlist = new MaterialeListe().getMatListe();
        ArrayList<Materiale> matlist = OGlist;

        String filter = request.getParameter("filter");
        matlist.removeIf(x -> !x.getTag().equals(filter));
        session.setAttribute("matListe",matlist);

        return "Katalogpage";
    }
}
