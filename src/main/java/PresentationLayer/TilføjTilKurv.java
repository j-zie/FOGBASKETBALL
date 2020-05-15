package PresentationLayer;

import FunctionLayer.KurvItems;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class TilføjTilKurv  extends Command{


    /**
     * Denne klasse indsætter det indtastede oplysing ind i kurvitems og opdatere sessionscopet.
     * @param request
     * @param response
     * @return
     * @throws LoginSampleException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        String beskrivelse = request.getParameter("beskrivelse");
        String imgPath = request.getParameter("billede");
        String pris = request.getParameter("pris");
        String tag = request.getParameter("tag");

        KurvItems.addItems(beskrivelse,imgPath,pris, tag);
        ArrayList<KurvItems> kurvItems = KurvItems.getItemList();
     
        session.setAttribute("itemListe", kurvItems);

        request.setAttribute("popUp", "yes");
        return "Katalogpage";
    }
}
