package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Register bruger command til at registrer buger indput til de
 * forskellige parametre der bliver brugt til at lave en bruger
 */

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, NumberFormatException {

        HttpSession session = request.getSession();

        Boolean fejFundet = false;

      for (String[] i : request.getParameterMap().values())   {
          if (i[0].length() < 1) {
              request.setAttribute("emptyError","Husk at udfylde alle felter");
              return "register";
          }
        }
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String adresse = request.getParameter("adresse");
        String navn = request.getParameter("navn");
        String tlf = request.getParameter("telefon");
        String by = request.getParameter("by");
        int postnr = 0;

        String reg = "^[0-9]*$";
        if ( request.getParameter("postnr").matches(reg)) {
            postnr = Integer.parseInt(request.getParameter("postnr"));
        } else {
           request.setAttribute("postnrError","Dette felt må kun indeholde tal");
         fejFundet = true;
        }

        String Ereg = "^(.+)@(.+)$";
        if (!email.matches(Ereg)) {
            request.setAttribute("emailError","Indtast venligst en rigtig email");
          fejFundet = true;
        }



       if ( password1.equals( password2 ) ) {
        } else {
           request.setAttribute("passError","Passwords matcher ikke");
           fejFundet = true;
        }


       if (fejFundet) {
           return "register";
       } else {
           if (session.getAttribute("role") != null && session.getAttribute("role").equals("Admin")){
               User user = LogicFacade.createUser( email, password1, tlf, adresse, navn, postnr, by, "Admin" );
               return "admin";
           }
           User user = LogicFacade.createUser( email, password1, tlf, adresse, navn, postnr, by, "kunde" );

           session.setAttribute("email",email);
           session.setAttribute( "user", user );
           session.setAttribute( "role", user.getRole() );
           return "main";
       }
    }

}
