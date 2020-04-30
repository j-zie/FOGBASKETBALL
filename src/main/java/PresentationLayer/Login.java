package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 login bruges til at forespørge om email og password.
 For derefter at sende en exception hvis dette ikke stemmer med databasens oplysninger

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        if (user == null) {
            return "login"; // Should be a page with a login error..
        }

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        System.out.println(user.getRole());
        session.setAttribute("email", email);
        // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke

        if (user.getRole().equals("Admin")){
            // GO TO ADMIN PAGE
            return "admin";
        }
        return "main";
    }
}