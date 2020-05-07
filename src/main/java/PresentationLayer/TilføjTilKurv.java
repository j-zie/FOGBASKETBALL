package PresentationLayer;

import FunctionLayer.KurvItems;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class TilføjTilKurv  extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        String beskrivelse = request.getParameter("beskrivelse");
        String imgPath = request.getParameter("billede");
        String pris = request.getParameter("pris");

        KurvItems.addItems(beskrivelse,imgPath,pris);
        ArrayList<KurvItems> kurvItems = KurvItems.getItemList();
     
        session.setAttribute("itemListe", kurvItems);

        request.setAttribute("popUp", "yes");
        return "Katalogpage";
    }
}
