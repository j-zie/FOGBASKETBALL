package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    /**
     * registrer og gemmer indtastede commands fra en bruger eller medarbejder.
     */

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "quickByg", new QuickByg() );
        commands.put( "nav", new Navigation() );
        commands.put("stykliste", new lavStykListe());
        commands.put("SkabMateriale", new SkabMateriale());
        commands.put("SletMateriale", new SletMateriale());
        commands.put("lægIkurv", new TilføjTilKurv());
        commands.put("SletOrdre", new SletOrdre());
        commands.put("Notification", new Notificationer());

    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException;

}
