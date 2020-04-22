package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.FKunde;
import FunctionLayer.LogicFacade;
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

            case "FladtTagOrdrebekræft":

                Boolean fejlFundet = tjekFelter(request);
                if (fejlFundet == true) {
                return "QuickByg/FladtTagpage";
            }

                Carport carport = sammenSætCarport(request);
                FKunde kunde = hentKundeInfo(request);

                LogicFacade.sendForspørgsel(carport, kunde);
                return "QuickByg/Bekræftelse";  // Skal sende en videre til en ny side eller en bekræftelse
        }

        return "fail"; // Lav error handle
    }



private Carport sammenSætCarport(HttpServletRequest request){

    Double bredde = Double.parseDouble(request.getParameter("Bredde"));
    Double længde = Double.parseDouble(request.getParameter("Længde"));
    String tagtype = request.getParameter("tagtype");
    Double redskabsrum_bredde = Double.parseDouble(request.getParameter("Redskabsrum_bredde"));
    Double redskabsrum_længde = Double.parseDouble(request.getParameter("Redskabsrum_længde"));

    Carport carport = new Carport(længde, bredde,
            1,
            0.0,
            true,
            redskabsrum_længde,
            redskabsrum_bredde);

return carport;

    }


    private FKunde hentKundeInfo(HttpServletRequest request){
        String navn = request.getParameter("Navn");
        String adresse = request.getParameter("Adresse");
        String by = request.getParameter("Postnummer");
        String telefon = request.getParameter("Telefon");
        String email = request.getParameter("Email");

        FKunde kunde = new FKunde(navn, adresse, by, telefon, email);
        return kunde;
    }



    private Boolean tjekFelter(HttpServletRequest request){
        Boolean fejfundet = false;
        String bredde = request.getParameter("Bredde");
        String længde = request.getParameter("Længde");
        String tagtype = request.getParameter("tagtype");
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
        if (tagtype.length() < 2) {
            request.setAttribute("tagError", "Udfyld venligst felt");
            fejfundet = true;
        }



        String navn = request.getParameter("Navn");
        String adresse = request.getParameter("Adresse");
        String by = request.getParameter("Postnummer");
        String telefon = request.getParameter("Telefon");
        String email = request.getParameter("Email");

        request.setAttribute("Navn", navn);
        request.setAttribute("Adresse", adresse);
        request.setAttribute("Postnummer", by);
        request.setAttribute("Telefon", telefon);
        request.setAttribute("Email", email);

        if (navn.length() < 2 ) {
            request.setAttribute("navnError", "Navn mangler");
            fejfundet = true;
        }
        if (adresse.length() < 2 ) {
            request.setAttribute("adresseError", "Adresse mangler");
            fejfundet = true;
        }
        if (by.length() < 2 ) {
            request.setAttribute("byError", "Felt mangler");
            fejfundet = true;
        }
        if (telefon.length() < 2 ) {
            request.setAttribute("telefonError", "Telefonnummer mangler");
            fejfundet = true;
        }


       if (validerEmail(email) == false) {
       request.setAttribute("emailError", "Email kan ikke bruges, skriv en rigtig en!");
           fejfundet = true;
        }

        return fejfundet;
    }

    private Boolean validerEmail(String email){
        String regex = "^(.+)@(.+)$";
        if (!email.matches(regex))   {
            return false;
        } else {
            return true;
        }
    }




}
