package PresentationLayer;

import FunctionLayer.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * TODO(Jonathan) PATRICK: nice skrevet! især de klasse private metoder, det glemmer jeg ofte. fix lige indents og white space, please
 * QuickByg modtager http request fra formen under quickbyg siden, kontrollere input og
 * vil ved gyldigt input putte formens informationer i databasen gennem kaldet til LogicFacade.sendForspørgsel
 * Den modtager http requests og retunere strenge der repræsenere filstier til andre jsp pages.
 */
public class QuickByg extends Command{
    /**
     * QuickByg modtager http request fra formen under quickbyg siden, kontrollere input og
     *
     * @return Retunere en jsp side. Har som sideeffekt et funktionskald der gemmer ordren i databasen
     * @param request Request fra jsp side skal indeholde alle felter der beskriver en carports tilstand.
     * @param response Header informationer
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

       String to = request.getParameter("to");

        switch (to) {

            case "Fladt":
                return "QuickByg/FladtTagpage";

            case "Rejsning":
                return "QuickByg/RejsningTagpage";

            case "FladtTagOrdrebekræft":
                Boolean fejlFundet = tjekFelter(request);
                if (fejlFundet == true) {
                return "QuickByg/FladtTagpage";
            }
                Carport carport = sammenSætCarport(request, Tag.Fladt);
                 User kunde = (User) session.getAttribute("user");
                LogicFacade.sendForspørgsel(new Ordre(carport, kunde));
                return "QuickByg/Bekræftelse";

            case "RejsningTagOrdrebekræft":
                 fejlFundet = tjekFelter(request);
                if (fejlFundet == true) {
                    return "QuickByg/RejsningTagpage";
                }
                 carport = sammenSætCarport(request, Tag.Rejsning);
                 kunde = (User) session.getAttribute("user");
                LogicFacade.sendForspørgsel(new Ordre(carport, kunde));
                return "QuickByg/Bekræftelse";

        }

        return "fail"; // Lav error handle
    }


enum Tag {
    Fladt,
    Rejsning
}

    /**
     * Privat metoder der laver en carport fra informationer i request scope
     * @return Retunere et carport objekt
     * @param request Request fra jsp side skal indeholde alle felter der beskriver en carports tilstand.
     */
private Carport sammenSætCarport(HttpServletRequest request, Tag tag){

    Double bredde = Double.parseDouble(request.getParameter("Bredde"));
    Double længde = Double.parseDouble(request.getParameter("Længde"));
    int tagtype = Integer.parseInt(request.getParameter("tagtype"));
    Double redskabsrum_bredde = Double.parseDouble(request.getParameter("Redskabsrum_bredde"));
    Double redskabsrum_længde = Double.parseDouble(request.getParameter("Redskabsrum_længde"));


    switch (tag) {
        case Fladt:

            Carport carport = new Carport(længde,
                    bredde,
                    1,
                    0.0,
                    redskabsrum_længde,
                    redskabsrum_bredde);
            return carport;

        case Rejsning:
            Double hældning = Double.parseDouble(request.getParameter("Taghældning"));
            Carport carport2 = new Carport(længde,
                    bredde,
                    tagtype,
                    hældning,
                    redskabsrum_længde,
                    redskabsrum_bredde);
            return carport2;


        default: return null;
    }

    }


    /**
     * Privat metode der validere informationer i requestscope
     * @return Boolean der bestemmer om carporten bliver sendt til databasen
     * @param request Request fra jsp side skal indeholde alle felter der beskriver en carports tilstand.
     */
    private Boolean tjekFelter(HttpServletRequest request) throws LoginSampleException {
        Boolean fejfundet = false;
        String bredde = request.getParameter("Bredde");
        String længde = request.getParameter("Længde");
        int tagtype = Integer.parseInt(request.getParameter("tagtype"));
        String redskabsrum_bredde = request.getParameter("Redskabsrum_bredde");
        String redskabsrum_længde = request.getParameter("Redskabsrum_længde");

        request.setAttribute("Bredde", bredde);
        request.setAttribute("Længde", længde );
        request.setAttribute("tagtype", tagtype);
        request.setAttribute("Redskabsrum_bredde", redskabsrum_bredde );
        request.setAttribute("Redskabsrum_længde", redskabsrum_længde );

        if (bredde.length() < 2) {
            request.setAttribute("breddeError", "Udfyld venligst felt");
           fejfundet = true;
        }
        if (længde.length() < 2) {
            request.setAttribute("længdeError", "Udfyld venligst felt");
            fejfundet = true;
        }
        if (tagtype < 1) {
            request.setAttribute("tagError", "Udfyld venligst felt");
            fejfundet = true;
        }

       // OBS VI SKAL LIGE TJEKKE OM REDSKABSRUMMET ER I EN valid størelse.


        return fejfundet;
    }





}
