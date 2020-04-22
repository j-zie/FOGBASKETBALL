package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String adresse = request.getParameter("adresse");
        int postnr = Integer.parseInt(request.getParameter("postnr"));
        String navn = request.getParameter("navn");
        String tlf = request.getParameter("telefon");
        String by = request.getParameter("by");

       if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, password1, tlf, adresse, navn, postnr, by );
            HttpSession session = request.getSession();

            session.setAttribute("email",email);
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return "main";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
