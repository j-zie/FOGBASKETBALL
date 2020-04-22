package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

                   HttpSession session = request.getSession();
                 User kunde = (User) session.getAttribute("") ;

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



    private Boolean tjekFelter(HttpServletRequest request) throws LoginSampleException {
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


           if (!tjekLogin(request)) {
               fejfundet = true;
           }



        return fejfundet;
    }

    private Boolean tjekLogin(HttpServletRequest request) throws LoginSampleException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
   
        request.setAttribute("email", email );
        request.setAttribute("password", password);

        if (validerEmail(email)) {
        if (LogicFacade.login(email, password) != null) {
                 return true;
              }  else {

                request.setAttribute("emailError", "Bruger findes ikke");
              }

        } else{
                  request.setAttribute("emailError", "Ikke valid email");
        }

        return false;
    }
    private Boolean tjekSignup(){

        return false;
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
